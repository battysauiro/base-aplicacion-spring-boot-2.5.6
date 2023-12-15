package IOI.myinovationsapp.controladores.conektra;

import IOI.myinovationsapp.servicios.conektra.ClientesConektraServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/conektra-clientes")
public class clientes {

    @Autowired
    private ClientesConektraServicioImpl clientesConektraServicio;

    @GetMapping("/listar/{url}")
    public String listaClientesConektra(@PathVariable String url) {
        try {
            return clientesConektraServicio.obtenerClientes("url");
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
