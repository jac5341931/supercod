package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.repositories.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployeeS() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeS(long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public Boolean createEmployeeS(Employee employee) {
        if(employee.getId() == 0L){
            //employee.setId(0L);
            this.employeeRepository.save(employee);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean updateEmployeeS(Employee employee) {
        try {
            this.employeeRepository.save(employee);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteEmployeeS(long id) {
        try {
            this.employeeRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}





