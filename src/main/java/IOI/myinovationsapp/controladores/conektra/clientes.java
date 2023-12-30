package IOI.myinovationsapp.controladores.conektra;

import IOI.myinovationsapp.dtos.ClienteDTO;
import IOI.myinovationsapp.servicios.conektra.ClientesConektraServicioImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/obtener-cliente/{idCliente}")
    public String obtenerClienteConektra(@PathVariable String idCliente) {
        try {
            return clientesConektraServicio.obtenerCliente(idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
    @PostMapping()
    public String crearClienteConektra(@RequestBody ClienteDTO clienteDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(clienteDTO);
            return clientesConektraServicio.agregarCliente(jsonString);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @PutMapping("/editar-cliente/{idCliente}")
    public String editarClienteConektra(@RequestBody ClienteDTO clienteDTO,@PathVariable String idCliente) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(clienteDTO);
            return clientesConektraServicio.editarCliente(jsonString,idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @DeleteMapping("/eliminar-cliente/{idCliente}")
    public String eliminarClienteConektra(@PathVariable String idCliente) {
        try {
            return clientesConektraServicio.eliminarCliente(idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
