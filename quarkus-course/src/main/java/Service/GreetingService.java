package Service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String sayHello(){
        return "Hello!";
    }
}
