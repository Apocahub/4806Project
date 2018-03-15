package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.repositories.ProjectRepo;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ProfessorController {
    private final ProjectRepo projectRepo;
    @Autowired
    ProfessorController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @RequestMapping("/professor")
    public String professor(Model model) {
        //TODO
        //projectRepo.getProjectsForProfId(profid)
        //add to model
        Project project = new Project();
        project.setProjectName("This is a name");
        project.setDescription("This is a description");
        project.setMaxStudents(1);
        project.setRestrictions("SYSC4005, " +"SYSC 4509");
        model.addAttribute("projects", Arrays.asList(project));
        return "profLandingPage";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject() {
        return "redirect:/createProject";
    }
}
