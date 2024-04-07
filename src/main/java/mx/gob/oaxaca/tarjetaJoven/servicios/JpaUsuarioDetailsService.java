package mx.gob.oaxaca.tarjetaJoven.servicios;

import mx.gob.oaxaca.tarjetaJoven.entidades.Usuario;
import mx.gob.oaxaca.tarjetaJoven.repositorios.UsuarioRepositorioJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUsuarioDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(JpaUsuarioDetailsService.class);

    @Autowired
    private UsuarioRepositorioJPA usuarioRepositorioJPA;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepositorioJPA.findByUsuario(username);

        if(usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException(String.format("Usuario %s no existe en la base de datos",username));
        }

        Usuario usuario = usuarioOptional.orElseThrow();

        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toList());

        return new User(usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,
                true,
                true,
                authorities);
    }
}
