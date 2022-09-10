package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Transaction;
import SuperCodersApp.SuperCoders.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Generaliza la ruta a todos los metodos
@RequestMapping("transaction")
public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransaction() {
        return this.transactionService.getAllTransactionS();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable("id") long id) {
        return this.transactionService.getTransactionS(id);
    }


    @PostMapping
    public Boolean createTransaction(@RequestBody Transaction transaction) {
        return this.transactionService.createTransactionS(transaction);
    }

    @PatchMapping("/{id}")
    public Boolean updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        Transaction e1 = this.transactionService.getTransactionS(id);
        if (e1 != null) {
            try {
                return this.transactionService.updateTransactionS(transaction);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTransaction(@PathVariable("id") long id) {
        return this.transactionService.deleteTransactionS(id);
    }
}
