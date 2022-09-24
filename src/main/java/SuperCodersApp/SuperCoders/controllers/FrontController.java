package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Profile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;


@Controller
public class FrontController {

    ProfileController profileController;
    Profile profile;

    public FrontController(ProfileController profileController) {
        this.profileController = profileController;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
        this.profile = new Profile();
        if(principal != null){
            System.out.println(principal.getClaims());
            this.profile = this.profileController.getOrCreateProfile(principal.getClaims());
            model.addAttribute("user", this.profile);
            return "user/dashboard";
        }

        return  "index";
    }

    @GetMapping("/user")
    public String userDashboard(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal != null){
            this.profile = new Profile();
            //this.profile.setOuth0Id(principal.getClaims().);
            System.out.println(principal.getClaims());
        }

        model.addAttribute("user", principal.getClaims());
        return "user/dashboard"; //Llamamos al HTML
    }

}
