package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import org.apache.logging.log4j.message.Message;
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
    public String indexEnterprise(Model model, @ModelAttribute("message") String message) {

        List<Enterprise> listEnterprise = enterpriseController.getAllEnterprise();
        model.addAttribute("listEnterprise", listEnterprise);
        model.addAttribute("message", message);
        return "enterprise/index"; //Llamamos al HTML
    }

    @GetMapping("/enterprise/new")
    public String addEnterprise(Model model, @ModelAttribute("message") String message) {
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "enterprise/add";
    }

    @PostMapping("/enterprise")
    public String saveEnterprise(Enterprise enterprise, RedirectAttributes redirectAttributes) {
        if (enterpriseController.createEnterprise(enterprise)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/enterprise/add";
    }

    @GetMapping("/enterprise/{id}/edit")
    public String editEnterprise(Model model, @PathVariable long id, @ModelAttribute("message") String message) {
        Enterprise enterprise = enterpriseController.getEnterprise(id);
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("message", message);
        return "enterprise/edit";
    }

    @PostMapping("/enterprise/{id}")
    public String updateEnterprise(@PathVariable long id, @ModelAttribute("enterprise") Enterprise enterprise, RedirectAttributes redirectAttributes) {
        if (enterpriseController.updateEnterprise(id, enterprise)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "updateError");
        return "redirect:/enterprise/edit";
    }

    @PostMapping("/enterprise/{id}/delete")
    public String deleteEnterprise(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (enterpriseController.deleteEnterprise(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteOK");
            return "redirect:/enterprise";
        }
        redirectAttributes.addFlashAttribute("message", "deleteError");
        return "redirect:/enterprise";
    }
}
