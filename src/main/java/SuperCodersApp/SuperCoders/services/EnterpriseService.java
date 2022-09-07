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
    public Boolean createEnterpriseS(Enterprise enterprise) {
        Enterprise e1 = this.enterpriseRepository.findById(enterprise.getId());
        if(e1 != null){
            return false;
        }else{
            try {
                this.enterpriseRepository.save(enterprise);
                return true;
            }catch(Exception e){
                return false;
            }
        }
    }

    @Override
    public Boolean updateEnterpriseS(long id, Enterprise enterprise) {
        Enterprise e1 = this.enterpriseRepository.findById(id);
        if(e1.getName().equals(enterprise.getName()) || e1.getNIT().equals(enterprise.getNIT()) ){
            return false;
        }else {
            try {
                this.enterpriseRepository.save(enterprise);
                return true;
            }catch(Exception e){
                return false;
            }
        }
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
