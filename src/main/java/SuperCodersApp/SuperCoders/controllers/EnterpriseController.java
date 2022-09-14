package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Enterprise;
import SuperCodersApp.SuperCoders.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Generaliza la ruta a todos los metodos
//@RequestMapping("enterprise")
public class EnterpriseController {

    EnterpriseService enterpriseServices;

    public EnterpriseController(EnterpriseService enterpriseServices) {
        this.enterpriseServices = enterpriseServices;
    }

    //@GetMapping
    public List<Enterprise> getAllEnterprise() {
        return this.enterpriseServices.getAllEnterpriseS();
    }

    //@GetMapping("/{id}")
    public Enterprise getEnterprise(@PathVariable("id") long id) {
        return this.enterpriseServices.getEnterpriseS(id);
    }


    //@PostMapping
    //public Boolean createEnterprise(@RequestBody Enterprise enterprise) {
    public Boolean createEnterprise(Enterprise enterprise) {
        return this.enterpriseServices.createEnterpriseS(enterprise);
    }

    //@PatchMapping("/{id}")
    //public Boolean updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise enterprise) {
    public Boolean updateEnterprise(long id, Enterprise enterprise) {
        Enterprise e1 = this.enterpriseServices.getEnterpriseS(id);
        if (e1 != null) {
            try {
                return this.enterpriseServices.updateEnterpriseS(enterprise);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    //@DeleteMapping("/{id}")
    //public Boolean deleteEnterprise(@PathVariable("id") long id) {
    public Boolean deleteEnterprise(long id) {
        return this.enterpriseServices.deleteEnterpriseS(id);
    }
}
