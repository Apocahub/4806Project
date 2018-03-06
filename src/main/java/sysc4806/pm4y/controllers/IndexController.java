package sysc4806.pm4y.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class IndexController {

    @RequestMapping("/")
	@ResponseBody
    public String index() {
        return "Hello World!";
    }

}
