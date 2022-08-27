package SuperCodersApp.SuperCoders.Controller;

import SuperCodersApp.SuperCoders.Entity.Enterprise;
import SuperCodersApp.SuperCoders.Services.EnterpriseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseController {

    EnterpriseService services;

    public EnterpriseController() {
        this.services = new EnterpriseService();
    }

    @GetMapping("/enterprise")
    public Enterprise enterprise(){
        return this.services.getEnterprise();
    }




}
