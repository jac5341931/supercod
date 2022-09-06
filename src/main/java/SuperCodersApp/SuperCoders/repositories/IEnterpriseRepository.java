package SuperCodersApp.SuperCoders.repositories;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IEnterpriseRepository extends CrudRepository<Enterprise, Long>{
    List<Enterprise> findEnterpriseByNIT(String NIT);

    Enterprise findById(long Id);

}
