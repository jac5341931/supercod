package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Generaliza la ruta a todos los metodos
@RequestMapping("enterprise")
public class EnterpriseController {

    EnterpriseService enterpriseServices;

    public EnterpriseController(EnterpriseService enterpriseServices) {
        this.enterpriseServices = enterpriseServices;
    }

    @GetMapping
    public List<Enterprise> getAllEnterprise() {
        return this.enterpriseServices.getAllEnterpriseS();
    }

    @GetMapping("/{id}")
    public Enterprise getEnterpriseS(@PathVariable("id") long id) {
        return this.enterpriseServices.getEnterpriseS(id);
    }


    @PostMapping
    public Boolean setEnterpriseS(@RequestBody Enterprise enterprise) {
        return this.enterpriseServices.setEnterpriseS(enterprise);
    }

    @PatchMapping("/{id}")
    public Boolean updateEnterpriseS(@PathVariable("id") long id, @RequestBody Enterprise enterprise){
        Enterprise e1 = this.enterpriseServices.getEnterpriseS(id);
        if( e1 != null && e1.getId() == id){
            this.enterpriseServices.setEnterpriseS(enterprise);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEnterprise(@PathVariable("id") long id){
        return this.enterpriseServices.deleteEnterpriseS(id);
    }
}
