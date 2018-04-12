package service.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
class TestController {  
      
    @Value("${wayne.from}")  
    private String from;  
      
    @RequestMapping("/from")  
    public String from() {  
        return this.from;  
    }  
}  
