package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String getAllTransaction(Model model, @ModelAttribute("message") String message, @ModelAttribute("type") String type){
        List<Transaction> transactionList = this.transactionController.getAllTransaction();
        model.addAttribute("transactionList", transactionList);
        model.addAttribute("employee", new Employee());
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "transaction/index";
    }

    @GetMapping("/transaction/new")
    public String addTransaction(Model model, @ModelAttribute("message") String message) {
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
    public String saveTransaction(Transaction transaction, RedirectAttributes redirectAttributes) {
        if (transactionController.createTransaction(transaction)) {
            redirectAttributes.addFlashAttribute("message", "saveOK");
            return "redirect:/transaction";
        }
        redirectAttributes.addFlashAttribute("message", "saveError");
        return "redirect:/transaction/add";
    }


}
