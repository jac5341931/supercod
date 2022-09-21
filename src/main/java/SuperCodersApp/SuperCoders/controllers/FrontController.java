package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.services.ProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class FrontController {

    ProfileController profileController;

    @GetMapping("/")
    public String index() {

        return "index"; //Llamamos al HTML
    }

    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal OidcUser principal) {

        if(principal != null){
            System.out.println(principal.getClaims());
            //Profile profile = this.profileController.createProfile(principal.getClaims());
            model.addAttribute("user", principal.getClaims());
            return  "user/index";
        }

        return  "index";
    }

    @GetMapping("/user/index")
    public String userIndex(Model model, @AuthenticationPrincipal OidcUser principal) {
        model.addAttribute("user", principal.getClaims());
        return "user/index"; //Llamamos al HTML
    }

}
