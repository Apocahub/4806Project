package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.util.*;

@Controller
public class PageController {

    private UserRepo userRepo;
    private ProjectRepo projectRepo;

    @Autowired
    public PageController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value="/admin")
    public String adminLoggedIn(Model model){
        List<User> returns = userRepo.findAll();
        List<Student> toDisplay = new ArrayList<Student>();
        for (User user : returns) {
            if(user instanceof Student) {toDisplay.add((Student)user);}
        }
        model.addAttribute("users", toDisplay);
        return "adminLandingPage";
    }

    @RequestMapping(value="/prof")
    public String profLoggedIn(Model model,
                               @ModelAttribute(value = User.MODEL_NAME) User user) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }

        Prof me = (Prof) user;
        List<Project> returns = projectRepo.findAll();
        List<Project> toDisplay = new ArrayList<Project>();

        for (Project project : returns) {
            if(project.getProfessor().equals(me)) {toDisplay.add(project);}
        }
        model.addAttribute("projects", toDisplay);
        //to be implemented
        return "profLandingPage";
    }

    @RequestMapping(value="/student")
    public String studentLoggedIn(Model model){
        //to be implemented
        return "studentLandingPage";
    }
}
