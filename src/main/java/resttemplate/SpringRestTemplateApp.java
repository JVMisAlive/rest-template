package resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import resttemplate.responseService.ResponseService;
import resttemplate.responseService.ResponseServiceImpl;

@SpringBootApplication
public class SpringRestTemplateApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringRestTemplateApp.class, args);
        ResponseService responseService = new ResponseServiceImpl();
        responseService.getResult();
    }
}
