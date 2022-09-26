package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Profile;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployeeS();
    List<Employee> getEmployeesByProfileIsNullS();
    Employee getEmployeeS(long id);
    Boolean createEmployeeS(Employee employee);
    Boolean updateEmployeeS(Employee employee);
    Boolean deleteEmployeeS(long id);
}


