package IOI.myinovationsapp.servicios;

import IOI.myinovationsapp.entidades.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioServicioInterface {

    public Usuario findByNombreUsuario(String nombreUsuario);
}
