package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.ProjectCoordinator;
import sysc4806.pm4y.models.Student;
import sysc4806.pm4y.repositories.UserRepo;

@Controller
public class LoginController {
    private final UserRepo repo;
    @Autowired
    public LoginController(final UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("prof", new Prof());
        model.addAttribute("student", new Student());
        model.addAttribute("coordinator", new ProjectCoordinator());
        return "login";
    }

    @RequestMapping(value = "/createProfessor",method = RequestMethod.POST)
    public String createProfessor(@ModelAttribute(value = "prof") Prof prof)
    {
        repo.save(prof);
        return "profLandingPage";
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public String createStudent(@ModelAttribute(value = "student") Student student) {
        repo.save(student);
        return "studentLandingPage";
    }

    @RequestMapping(value = "/createCoordinator",method = RequestMethod.POST)
    public String createProfessor(@ModelAttribute(value = "coordinator") ProjectCoordinator projectCoordinator) {
        repo.save(projectCoordinator);
        return "adminLandingPage";
    }
}
