package SuperCodersApp.SuperCoders.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class FrontController {

    public FrontController() {

    }

    @GetMapping("/")
    public String index() {
        return "index"; //Llamamos al HTML
    }

}
