package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import org.apache.logging.log4j.message.Message;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FrontEnterpriseController {

    final
    EnterpriseController enterpriseController;

    public FrontEnterpriseController(EnterpriseController enterpriseController) {
        this.enterpriseController = enterpriseController;
    }

    @GetMapping("/enterprise")
    public String indexEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        List<Enterprise> listEnterprise = enterpriseController.getAllEnterprise();
        model.addAttribute("listEnterprise", listEnterprise);
        model.addAttribute("message", message);
        return "enterprise/index"; //Llamamos al HTML
    }

    @GetMapping("/enterprise/new")
    public String addEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "enterprise/add";
    }

    @PostMapping("/enterprise")
    public String saveEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes,Enterprise enterprise) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (enterpriseController.createEnterprise(enterprise)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/enterprise/add";
    }

    @GetMapping("/enterprise/{id}/edit")
    public String editEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @PathVariable long id, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Enterprise enterprise = enterpriseController.getEnterprise(id);
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "enterprise/edit";
    }

    @PostMapping("/enterprise/{id}")
    public String updateEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, @PathVariable long id, @ModelAttribute("enterprise") Enterprise enterprise) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (enterpriseController.updateEnterprise(id, enterprise)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "updateError");
        return "redirect:/enterprise/edit";
    }

    @PostMapping("/enterprise/{id}/delete")
    public String deleteEnterprise(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (enterpriseController.deleteEnterprise(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "deleteError");
        return "redirect:/enterprise";
    }
}
