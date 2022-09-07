package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    //Get all
    List<Enterprise> getAllEnterpriseS();

    //Get one
    Enterprise getEnterpriseS(long id);

    //Create
    Boolean createEnterpriseS(Enterprise enterprise);

    Boolean updateEnterpriseS(Enterprise enterprise);

    //Delete
    Boolean deleteEnterpriseS(long id);
}
