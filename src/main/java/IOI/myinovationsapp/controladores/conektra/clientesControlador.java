package IOI.myinovationsapp.controladores.conektra;

import IOI.myinovationsapp.dtos.ClienteDTO;
import IOI.myinovationsapp.servicios.conektra.ClientesConektraServicioImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/conektra-clientes")
public class clientesControlador {

    @Autowired
    private ClientesConektraServicioImpl clientesConektraServicio;

    @GetMapping("/listar/{token}")
    public String listaClientesConektra(@PathVariable String token) {
        try {
            return clientesConektraServicio.obtenerClientes(token);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @GetMapping("/obtener-cliente/{token}/{idCliente}")
    public String obtenerClienteConektra(@PathVariable String token,@PathVariable String idCliente) {
        try {
            return clientesConektraServicio.obtenerCliente(token,idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
    @PostMapping("/{token}")
    public String crearClienteConektra(@RequestBody ClienteDTO clienteDTO,@PathVariable String token) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(clienteDTO);
            return clientesConektraServicio.agregarCliente(token,jsonString);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @PutMapping("/editar-cliente/{token}/{idCliente}")
    public String editarClienteConektra(@PathVariable String token,@RequestBody ClienteDTO clienteDTO,@PathVariable String idCliente) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(clienteDTO);
            return clientesConektraServicio.editarCliente(token,jsonString,idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @DeleteMapping("/eliminar-cliente/{token}/{idCliente}")
    public String eliminarClienteConektra(@PathVariable String token,@PathVariable String idCliente) {
        try {
            return clientesConektraServicio.eliminarCliente(token,idCliente);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
