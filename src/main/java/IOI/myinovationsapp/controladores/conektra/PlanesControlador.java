package IOI.myinovationsapp.controladores.conektra;

import IOI.myinovationsapp.dtos.ClienteDTO;
import IOI.myinovationsapp.dtos.PlanDTO;
import IOI.myinovationsapp.servicios.conektra.PlanesConektraServicioImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/conektra-planes")
public class PlanesControlador {

    @Autowired
    private PlanesConektraServicioImpl planesConektraServicio;

    @GetMapping("/listar-planes/{limite}/{busqueda}/{siguiente}/{anterior}")
    public String listaPlanesConektra(@PathVariable int limite,@PathVariable String busqueda,@PathVariable String siguiente,@PathVariable String anterior) {
        try {
            return planesConektraServicio.obtenerPlanes(limite,busqueda,siguiente,anterior);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @GetMapping("/obtener-plan/{idPlan}")
    public String obtenerPlanConektra(@PathVariable String idPlan) {
        try {
            return planesConektraServicio.obtenerPlan(idPlan);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @PostMapping()
    public String crearPlanConektra(@RequestBody PlanDTO planDTO) {
        try {
            return planesConektraServicio.agregarPlan(planDTO);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @PutMapping("/editar-plan")
    public String editarPlanConektra(@RequestBody PlanDTO planDTO) {
        try {
            return planesConektraServicio.editarPlan(planDTO);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }

    @DeleteMapping("/eliminar-plan/{idPlan}")
    public String eliminarPlanConektra(@PathVariable String idPlan) {
        try {
            return planesConektraServicio.eliminarPlan(idPlan);
        } catch (Exception e) {
            return "Error al realizar la solicitud: " + e.getMessage();
        }
    }
}
