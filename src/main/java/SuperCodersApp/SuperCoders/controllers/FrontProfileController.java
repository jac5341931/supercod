package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.entities.Enterprise;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FrontProfileController {

    final
    ProfileController profileController;
    EmployeeController employeeController;
    EnterpriseController enterpriseController;




    public FrontProfileController(ProfileController profileController, EnterpriseController enterpriseController, EmployeeController employeeController) {
        this.enterpriseController = enterpriseController;
        this.profileController = profileController;
        this.employeeController = employeeController;
    }

    @GetMapping("/profile")
    public String indexProfile(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }

        List<Profile> listProfile = profileController.getAllProfile();
        model.addAttribute("listProfile", listProfile);
        model.addAttribute("message", message);
        return "profile/index"; //Llamamos al HTML
    }

    @GetMapping("/profile/new")
    public String addProfile(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }

        Profile profile = new Profile();
        List<Profile> profiles = profileController.getAllProfile();
        model.addAttribute("profile", profile);
        model.addAttribute("message", message);
        return "profile/add";
    }

    @PostMapping("/profile")
    public String saveProfile(@AuthenticationPrincipal OidcUser principal, Profile profile, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (profileController.createProfile(profile) != null) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/profile";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/profile/add";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfile(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @PathVariable long id, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Profile profile = profileController.getProfile(id);
        List<Employee> employees= employeeController.getAllEmployee();
        model.addAttribute("profile", profile);
        model.addAttribute("employee", employees);
        model.addAttribute("message", message);
        return "profile/edit";
    }

    @PostMapping("/profile/{id}")
    public String updateProfile(@AuthenticationPrincipal OidcUser principal, @PathVariable long id, @ModelAttribute("profile") Profile profile, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (profileController.updateProfile(id, profile)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/profile";
        }
        redirectAttributes.addFlashAttribute("message", "updateError");
        return "redirect:/profile/edit";
    }

    @PostMapping("/profile/{id}/delete")
    public String deleteProfile(@AuthenticationPrincipal OidcUser principal, @PathVariable Integer id, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (profileController.deleteProfile(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteOK");
            return "redirect:/profile";
        }
        redirectAttributes.addFlashAttribute("message", "deleteError");
        return "redirect:/profile";
    }
}
