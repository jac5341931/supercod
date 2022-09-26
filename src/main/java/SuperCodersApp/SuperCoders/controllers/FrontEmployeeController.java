package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.entities.Profile;
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
public class FrontEmployeeController {

    final
    EmployeeController employeeController;

    EnterpriseController enterpriseController;
    ProfileController profileController;

    public FrontEmployeeController(EmployeeController employeeController, EnterpriseController enterpriseController, ProfileController profileController) {
        this.employeeController = employeeController;
        this.enterpriseController = enterpriseController;
        this.profileController = profileController;
    }

    @GetMapping("/employee")
    public String indexEmployee(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }

        List<Employee> listEmployee = employeeController.getAllEmployee();
        model.addAttribute("listEmployee", listEmployee);
        model.addAttribute("message", message);
        return "employee/index"; //Llamamos al HTML
    }

    @GetMapping("/employee/new")
    public String addEmployee(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }

        Employee employee = new Employee();
        List<Enterprise> enterprises = enterpriseController.getAllEnterprise();
        List<Profile> profiles = profileController.getAllProfileWithoutEmployee();
        model.addAttribute("employee", employee);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("profiles", profiles);
        model.addAttribute("message", message);
        return "employee/add";
    }

    @PostMapping("/employee")
    public String saveEmployee(@AuthenticationPrincipal OidcUser principal, Employee employee, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (employeeController.createEmployee(employee)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/employee/add";
    }

    @GetMapping("/employee/{id}/edit")
    public String editEmployee(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, Model model, @PathVariable long id, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Employee employee = employeeController.getEmployee(id);
        List<Enterprise> enterprises = enterpriseController.getAllEnterprise();
        List<Profile> profiles = profileController.getAllProfileWithoutEmployee();
        model.addAttribute("employee", employee);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("profiles", profiles);
        model.addAttribute("message", message);
        return "employee/edit";
    }

    @PostMapping("/employee/{id}")
    public String updateEmployee(@AuthenticationPrincipal OidcUser principal, @PathVariable long id, @ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (employeeController.updateEmployee(id, employee)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "updateError");
        return "redirect:/employee/edit";
    }

    @PostMapping("/employee/{id}/delete")
    public String deleteEmployee(@AuthenticationPrincipal OidcUser principal, @PathVariable Integer id, RedirectAttributes redirectAttributes) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (employeeController.deleteEmployee(id)) {
            redirectAttributes.addFlashAttribute("message", "deleteOK");
            return "redirect:/employee";
        }
        redirectAttributes.addFlashAttribute("message", "deleteError");
        return "redirect:/employee";
    }
}
