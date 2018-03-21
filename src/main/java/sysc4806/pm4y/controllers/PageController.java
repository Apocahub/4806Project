package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.util.*;

@Controller
public class PageController {public UserRepo userRepo;
    public ProjectRepo projectRepo;
    @Autowired
    public void instantiateRepo(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value="/admin")
    public String adminLoggedIn(Model model){
        List<User> returns = userRepo.findAll();
        List<ProjectCoordinator> toDisplay = new ArrayList<ProjectCoordinator>();
        for (User user : returns) {
            if(user instanceof Student) {toDisplay.add((ProjectCoordinator)user);}
        }
        model.addAttribute("users", toDisplay);
        return "adminLandingPage";
    }

    @RequestMapping(value="/prof")
    public String profLoggedIn(Model model){
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }

        List<Project> toDisplay = projectRepo.findAll();
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
