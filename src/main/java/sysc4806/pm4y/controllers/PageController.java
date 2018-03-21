package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
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

    @RequestMapping(value="/admin/{id}")
    public String adminLoggedIn(Model model, @PathVariable("id") String id){
        List<User> returns = userRepo.findAll();
        List<Student> toDisplay = new ArrayList<Student>();
        for (User user : returns) {
            if(user instanceof Student) {
                if (((Student) user).getProject() == null) {
                    toDisplay.add((Student)user);
                }
            }
        }
        model.addAttribute("users", toDisplay);
        return "adminLandingPage";
    }



    @RequestMapping(value="/student/{id}")
    public String studentLoggedIn(Model model, @PathVariable("id") String id){
        //to be implemented
        return "studentLandingPage";
    }
}
