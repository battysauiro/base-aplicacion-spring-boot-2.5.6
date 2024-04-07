package mx.gob.oaxaca.nombre_proyecto.repositorios;


import mx.gob.oaxaca.nombre_proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepositorioJPA extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByUsuario(String usuario);
}
