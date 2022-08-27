package SuperCodersApp.SuperCoders.Services;

import SuperCodersApp.SuperCoders.Entity.Enterprise;
import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

public class EnterpriseService {
    Enterprise e1;

    public EnterpriseService(){
        this.e1 = new Enterprise("Mi empresa", "Calle 77 #15-1234","3002326000", "890102248-3");
    }

    public Enterprise getEnterprise(){
        return this.e1;
    }
}
