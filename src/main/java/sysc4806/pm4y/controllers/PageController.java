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

    @RequestMapping(value="/student/{id}")
    public String studentLoggedIn(Model model, @PathVariable("id") String id){
        User me = userRepo.findById(id);
        List<Project> returns = projectRepo.findAll();
        List<Project> toDisplay = new ArrayList<Project>();

        for (Project project : returns) {
            if(project.getMaxStudents() > project.getStudents().size()) {
                if(project.getEngineeringStreams().size() == 0 || project.getEngineeringStreams().contains(((Student)me).getEngineeringStream())) {
                    if(!project.isArchived)
                        toDisplay.add(project);
                }
            }
        }
        model.addAttribute("projects", toDisplay);
        model.addAttribute("dueDateProject", (toDisplay.isEmpty() ? new Project() : toDisplay.get(0)));
        return "studentLandingPage";
    }
}
