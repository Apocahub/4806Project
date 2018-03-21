package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/projects/prof/")
public class ProjectController {
    private UserRepo userRepo;
    private ProjectRepo projectRepo;
    private Project project;
    @Autowired
    ProjectController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value = "/{id}/newProject", method = RequestMethod.POST)
    public String newProject(@PathVariable(value = "id") String id) {
        User user = userRepo.findById(id);
        if(!(user instanceof Prof)) {
            return "redirect:/logout";
        }
        Prof prof = (Prof) user;
       project.setProfessor(prof);
       projectRepo.save(project);
        return "redirect:/prof/" + id;
    }

    @RequestMapping("/{id}/createProject")
    public String createProjectPage(@PathVariable(value = "id") String id, Model model) {
        project = new Project();
        model.addAttribute(Project.MODEL_NAME, project);
        model.addAttribute("id", id);
        return "projectCreationPage";
    }

}
