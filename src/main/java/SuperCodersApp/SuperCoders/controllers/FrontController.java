package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Profile;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@EnableAutoConfiguration
public class FrontController {

    ProfileController profileController;
    Profile profile;

    public FrontController(ProfileController profileController) {
        this.profileController = profileController;
    }

/*    @GetMapping({"","/", "/index"})
    public String index(Model model) {
        return  "home";
    }*/

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {

        if(principal != null){
            this.profile = new Profile();
            System.out.println(principal.getClaims());
            this.profile = this.profileController.getOrCreateProfile(principal.getClaims());
            model.addAttribute("user", this.profile);
            return "user/dashboard";
        }

        return  "home";
    }
/*
    @GetMapping("/user")
    public String userDashboard(Model model, @AuthenticationPrincipal OidcUser principal) {
        if(principal != null){
            this.profile = new Profile();
            //this.profile.setOuth0Id(principal.getClaims().);
            System.out.println(principal.getClaims());
        }

        model.addAttribute("user", principal.getClaims());
        return "user/dashboard"; //Llamamos al HTML
    }*/

/*    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
*//*
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }*//*
        }
        return "application/error";
    }*/
}
