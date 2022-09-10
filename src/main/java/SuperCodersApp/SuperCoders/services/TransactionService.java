package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Transaction;
import SuperCodersApp.SuperCoders.repositories.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{

    ITransactionRepository transactionRepository;

    public TransactionService(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactionS() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionS(long id) {

        return this.transactionRepository.findById(id);
    }

    @Override
    public Boolean createTransactionS(Transaction transaction) {
        if(transaction.getId() == 0L){
            //employee.setId(0L);
            this.transactionRepository.save(transaction);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateTransactionS(Transaction transaction) {
        try {
            this.transactionRepository.save(transaction);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteTransactionS(long id) {
        try {
            this.transactionRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}





