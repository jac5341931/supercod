package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FrontTransactionController {

    @Autowired
    //TransactionService transactionService;
    TransactionController transactionController;
    @Autowired
    EmployeeController employeeController;

    @Autowired
    EnterpriseController enterpriseController;

    @GetMapping("/transaction")
    public String getAllTransaction(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes,Model model, @ModelAttribute("message") String message, @ModelAttribute("type") String type){
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        List<Transaction> transactionList = this.transactionController.getAllTransaction();
        model.addAttribute("transactionList", transactionList);
       // model.addAttribute("employee", new Employee());
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "transaction/index";
    }

    @GetMapping("/transaction/new")
    public String addTransaction(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes,Model model, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Transaction transaction = new Transaction();
        List<Employee> employees = employeeController.getAllEmployee();
        List<Enterprise> enterprises = enterpriseController.getAllEnterprise();
        model.addAttribute("transaction", transaction);
        model.addAttribute("employees", employees);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("message", message);
        return "transaction/add";
    }

    @PostMapping("/transaction")
    public String saveTransaction(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes,Transaction transaction) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (transactionController.createTransaction(transaction)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/transaction";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/transaction/add";
    }


    @GetMapping("/transaction/{id}/edit")
    public String editTransaction(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes,Model model, @PathVariable long id, @ModelAttribute("message") String message) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        Transaction transaction = transactionController.getTransaction(id);
        List<Employee> employees = employeeController.getAllEmployee();
        List<Enterprise> enterprises = enterpriseController.getAllEnterprise();
        //Creamos un atributo para el modelo, que se llame igualmente emp y es el que ira al html para llenar o alimentar campos
        model.addAttribute("transaction", transaction);
        model.addAttribute("employees", employees);
        model.addAttribute("enterprises", enterprises);
        model.addAttribute("message", message);
        return "transaction/edit";
    }

    @PostMapping("/transaction/{id}")
    public String updateTransaction(@AuthenticationPrincipal OidcUser principal, RedirectAttributes redirectAttributes, @PathVariable long id, @ModelAttribute("transaction") Transaction transaction) {
        //Validacion de acceso
        if(principal == null){
            redirectAttributes.addFlashAttribute("message", "Must be logged!");
            return "redirect:/";
        }
        if (transactionController.updateTransaction(id, transaction)) {
            redirectAttributes.addFlashAttribute("message", "updateOK");
            return "redirect:/transaction";
        }
        redirectAttributes.addFlashAttribute("message", "updateError");
        return "redirect:/transaction/edit";
    }



}
