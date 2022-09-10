package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransactionS();
    Transaction getTransactionS(long id);
    Boolean createTransactionS(Transaction transaction);
    Boolean updateTransactionS(Transaction transaction);
    Boolean deleteTransactionS(long id);
}


