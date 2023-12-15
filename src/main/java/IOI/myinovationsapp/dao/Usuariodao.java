package IOI.myinovationsapp.dao;



import IOI.myinovationsapp.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Usuariodao extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByNombreUsuario(@Param("usuario")String usuario);
}
