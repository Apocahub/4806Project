package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

    @RequestMapping("/land")
    public String landingPage() {
        return "landingPage";
    }

    @RequestMapping("/student")
    public String studentLandingPage() {
        return "studentLandingPage";
    }

    @RequestMapping("/prof")
    public String profLandingPage() {
        return "profLandingPage";
    }

    @RequestMapping("/admin")
    public String adminLandingPage() {
        return "adminLandingPage";
    }


}
