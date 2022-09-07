package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    //Get all
    public List<Enterprise> getAllEnterpriseS();

    //Get one
    public Enterprise getEnterpriseS(long id);

    //Create
    public Boolean createEnterpriseS(Enterprise enterprise);

    public Boolean updateEnterpriseS(long id, Enterprise enterprise);

    //Delete
    public Boolean deleteEnterpriseS(long id);
}
