package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/prof")
public class ProfessorController {
    private UserRepo userRepo;
    private ProjectRepo projectRepo;
    @Autowired
    public ProfessorController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }
    @RequestMapping("/{id}")
    public String profLoggedIn(Model model, @PathVariable(value = "id") String id) {
        if(!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }
        User user = userRepo.findById(id);
        if(!user.getSessionId().equals(RequestContextHolder.currentRequestAttributes().getSessionId())) {
            return "redirect:/logout";
        }
        if(!(user instanceof Prof)) {
            return "redirect:/logout";
        }
        Prof me = (Prof) user;
        List<Project> returns = projectRepo.findAll();
        List<Project> toDisplay = new ArrayList<Project>();

        for (Project project : returns) {
            if(project.getProfessor() == null) continue;
            if(project.getProfessor().equals(me)) {toDisplay.add(project);}
        }
        model.addAttribute("projects", toDisplay);
        model.addAttribute("prof", me);
        //to be implemented
        return "profLandingPage";
    }

    /*@RequestMapping("/{id}/createProject")
    public String createProject(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("id", id);
        return "redirect:/projects/createProject";
    }*/

}
