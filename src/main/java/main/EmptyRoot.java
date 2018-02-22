package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

@Controller
public class EmptyRoot {

    @RequestMapping("/")
    public String emptyRoot() {
        return "Hello World!";
    }

}
