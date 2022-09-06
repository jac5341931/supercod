package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.repositories.IEnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {

    private IEnterpriseRepository enterpriseRepository;

    EnterpriseService(IEnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public List<Enterprise> getAllEnterpriseS() {
        return (List<Enterprise>) this.enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getEnterpriseS(long id) {
        return this.enterpriseRepository.findById(id);
    }

    @Override
    public Boolean setEnterpriseS(Enterprise enterprise) {
        try {
            this.enterpriseRepository.save(enterprise);
            return true;
        } catch (Exception e) {
            System.out.println("Ya existe este documento, nombre de empresa, id");
        }
        return false;
    }

    @Override
    public Boolean deleteEnterpriseS(long id) {
        try {
            this.enterpriseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
