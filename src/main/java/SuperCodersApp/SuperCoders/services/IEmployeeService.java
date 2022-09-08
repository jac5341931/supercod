package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployeeS();
    Employee getEmployeeS(long id);
    Boolean createEmployeeS(Employee employee);
    Boolean updateEmployeeS(Employee employee);
    Boolean deleteEmployeeS(long id);
}


