package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class EmptyRoot {

    @RequestMapping("/")
    public @ResponseBody String emptyRoot() {
        return "Hello World!";
    }

}
