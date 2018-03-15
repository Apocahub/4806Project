package sysc4806.pm4y.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfessorController {
    @RequestMapping("/professor")
    public String professor(Model model) {
        return "profLandingPage";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject() {
        return "redirect:/createProject";
    }
}
