package pe.com.cibertec.lp2_t2_sebastianbravo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.lp2_t2_sebastianbravo.model.entity.AreaEntity;
import pe.com.cibertec.lp2_t2_sebastianbravo.service.AreaService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    /*@GetMapping("/listar_area")
    public String index(Model model) {
        List<AreaEntity> listarAreas = areaService.buscarArea();
        model.addAttribute("list_area", listarAreas);
        return "lista_area";
    }

    @GetMapping("/detalle_area/{id}")
    public String verDetalle(Model model, @PathVariable("id") Integer id) {
        AreaEntity areaEncontrada = areaService.buscarAreaPorId(id);
        model.addAttribute("user", areaEncontrada);
        return "detalle_area";
    }

    @GetMapping("/delete/{id}")
    public String deleteArea(@PathVariable("id") Integer id) {
        areaService.eliminarArea(id);
        return "redirect:/listar_area";
    }

    @GetMapping("/registrar_area")
    public String mostrarRegistrarArea(Model model) {
        model.addAttribute("user", new AreaEntity());
        return "registrar_area";
    }

    @PostMapping("/registrar_area")
    public String registrarArea(@ModelAttribute("user")AreaEntity user, Model model) {
        if(areaService.buscarAreaPorId(user.getAreaId()) != null) {
            model.addAttribute("errorMessage", "El area ya existe.");
            model.addAttribute("user", user);
            return "registrar_area";
        }

        areaService.crearArea(user);
        return "redirect:/listar_area";
    }

    @GetMapping("/editar_area/{id}")
    public String mostrarEditarArea(@PathVariable("id") Integer id, Model model) {
        AreaEntity areaEncontrada = areaService.buscarAreaPorId(id);
        model.addAttribute("user", areaEncontrada);
        return "editar_area";
    }

    @PostMapping("/editar_area/{id}")
    public String editarEmpleado(@PathVariable("id")Integer id,
                                 @ModelAttribute("user") AreaEntity user, Model model) {

        areaService.actualizarArea(id, user);
        return "redirect:/listar_area";
    }*/
}
