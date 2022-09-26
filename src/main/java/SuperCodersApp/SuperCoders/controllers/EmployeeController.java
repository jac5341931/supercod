package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //@GetMapping
    public List<Employee> getAllEmployee(){
        return this.employeeService.getAllEmployeeS();
    }

    public List<Employee> getAllEmployeeWithoutProfile(){
        return this.employeeService.getEmployeesByProfileIsNullS();
    }
    //@GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") long id){
        return this.employeeService.getEmployeeS(id);
    }

    //@PostMapping
    public Boolean createEmployee(@RequestBody Employee employee){
        return this.employeeService.createEmployeeS(employee);
    }

    //@PatchMapping("/{id}")
    public Boolean updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        Employee e1 = this.employeeService.getEmployeeS(id);
        if(e1 != null){
            try{
                return this.employeeService.updateEmployeeS(employee);
            }catch(Exception e){
                return false;
            }
        }else{
            return false;
        }
    }
    //@DeleteMapping("/{id}")
    public Boolean deleteEmployee (@PathVariable("id") long id){
        return this.employeeService.deleteEmployeeS(id);
    }

}








