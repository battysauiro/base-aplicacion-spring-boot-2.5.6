package mx.gob.oaxaca.tarjetaJoven.repositorios;


import mx.gob.oaxaca.tarjetaJoven.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepositorioJPA extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByUsuario(String usuario);
}
