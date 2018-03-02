package sysc4806.pm4y.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

    @RequestMapping(value = "/land", method = RequestMethod.GET)
    public String landingPage() {
        return "landingPage";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentLandingPage() {
        return "studentLandingPage";
    }

    @RequestMapping(value = "/prof", method = RequestMethod.GET)
    public String profLandingPage() {
        return "profLandingPage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminLandingPage() {
        return "adminLandingPage";
    }


}
