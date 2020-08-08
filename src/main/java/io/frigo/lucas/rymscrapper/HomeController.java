package io.frigo.lucas.rymscrapper;

import io.frigo.lucas.rymscrapper.services.RymTopAlbumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    RymTopAlbumsService rymTopAlbumsService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("albumStats", rymTopAlbumsService.getAllStats());
        return "home";
    }
}
