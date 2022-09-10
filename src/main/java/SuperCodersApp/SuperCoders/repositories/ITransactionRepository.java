package SuperCodersApp.SuperCoders.repositories;

import SuperCodersApp.SuperCoders.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findById(long Id);
}


