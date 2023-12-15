package IOI.myinovationsapp.servicios;

import IOI.myinovationsapp.dao.Usuariodao;
import IOI.myinovationsapp.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicioInterface, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UsuarioServicioImpl.class);
    @Autowired
    private Usuariodao usuariodao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =usuariodao.findByNombreUsuario(username).get();
        List<GrantedAuthority> authorities =usuario.getRoles().stream()
                .map(role-> new SimpleGrantedAuthority(role.getNombreRol()))
                .collect(Collectors.toList());
        return new User(usuario.getNombreUsuario(), usuario.getContrasena(), true, true, true, true, authorities);

    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByNombreUsuario(String username) {
        return usuariodao.findByNombreUsuario(username).get();
    }
}
