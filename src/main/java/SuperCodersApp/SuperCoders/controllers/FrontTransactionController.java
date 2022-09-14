package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class FrontTransactionController {

    @Autowired
    //TransactionService transactionService;

    TransactionController transactionController;

    @GetMapping("/transaction")
    public String getAllTransaction(Model model, @ModelAttribute("message") String message, @ModelAttribute("type") String type){
        List<Transaction> transactionList = this.transactionController.getAllTransaction();
        model.addAttribute("transactionList", transactionList);
        model.addAttribute("type", type);
        model.addAttribute("message", message);
        return "transaction/index";
    }


}
