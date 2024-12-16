package DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.controller;

import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.dto.CarDto;
import DAWI_Mendosa_Sanchez_Jose_manuel.EF_spring_resful_Mendoza.sevice.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<CarDto> cars = manageService.getAllCars();
            model.addAttribute("cars", cars);
            model.addAttribute("error", "");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al cargar los datos");
        }
        return "manage";
    }
}