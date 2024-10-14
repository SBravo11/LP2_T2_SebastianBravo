package pe.com.cibertec.lp2_t2_sebastianbravo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.EmpleadoEntity;
import pe.com.cibertec.lp2_t2_sebastianbravo.service.EmpleadoService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public String index(Model model) {
        List<EmpleadoEntity> listarEmpleados = empleadoService.buscarEmpleados();
        model.addAttribute("list_empleado", listarEmpleados);
        return "listar_empleados";
    }

    @GetMapping("/detalle_empleado/{dni}")
    public String verDetalle(Model model, @PathVariable("dni")String dni) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dni);
        model.addAttribute("user", empleadoEncontrado);
        return "detalle_empleado";
    }

    @GetMapping("/delete/{dni}")
    public String deleteUsuario(@PathVariable("dni")String dni) {
        empleadoService.eliminarEmpleado(dni);
        return "redirect:/";
    }

    @GetMapping("/registrar_empleado")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("user", new EmpleadoEntity());
        return "registrar_empleado";
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute("user")EmpleadoEntity user, Model model) {
        if(empleadoService.buscarEmpleadoPorDni(user.getDni()) != null) {
            model.addAttribute("errorMessage", "El empleado ya existe.");
            model.addAttribute("user", user);
            return "registrar_empleado";
        }

        empleadoService.crearEmpleado(user);
        return "redirect:/";
    }

    @GetMapping("/editar_empleado/{dni}")
    public String mostrarEditarEmpleado(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleadoEncontrado = empleadoService.buscarEmpleadoPorDni(dni);
        model.addAttribute("user", empleadoEncontrado);
        return "editar_emplado";
    }

    @PostMapping("/editar_empleado/{dni}")
    public String editarEmpleado(@PathVariable("dni")String dni,
                                @ModelAttribute("user") EmpleadoEntity user, Model model) {

        empleadoService.actualizarEmpleado(dni, user);
        return "redirect:/";
    }
}
