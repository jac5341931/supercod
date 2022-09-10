package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.repositories.IEnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {

    private final IEnterpriseRepository enterpriseRepository;
   /* private EmployeeService employeeService;*/

    EnterpriseService(IEnterpriseRepository enterpriseRepository/*, EmployeeService employeeService*/) {
        this.enterpriseRepository = enterpriseRepository;
        /*this.employeeService = employeeService;*/
    }

    @Override
    public List<Enterprise> getAllEnterpriseS() {
        //List<Enterprise> enterprises = this.enterpriseRepository.findAll();
       return this.enterpriseRepository.findAll();
/*       for (Enterprise e: enterprises) {
           List<Employee> employesList = this.employeeService.getAllEmployeeS();
           System.out.println(" Empleados : " + employesList.toString());
           e.setEmployees(employesList);
       }*/

       // return enterprises;


    }

    @Override
    public Enterprise getEnterpriseS(long id) {
        return this.enterpriseRepository.findById(id);
    }

    @Override
    public Boolean createEnterpriseS(Enterprise enterprise) {
        try {
            enterprise.setId(0L);
            this.enterpriseRepository.save(enterprise);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateEnterpriseS(Enterprise enterprise) {
        try {
            this.enterpriseRepository.save(enterprise);
            return true;
        }catch(Exception e){
            return false;
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
