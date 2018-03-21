package sysc4806.pm4y.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.repositories.ProjectRepo;

@Controller
public class ProjectCreationController {
    private final ProjectRepo projectRepo;
    ProjectCreationController(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }
    @RequestMapping("/createProject")
    public String createProjectPage(Model model) {
        model.addAttribute("project", new Project());
        return "projectCreationPage";
    }


    @RequestMapping(value = "/newProject", method = RequestMethod.POST)
    public String newProject(@ModelAttribute(value = "project") Project project) {
        projectRepo.save(project);
        return "redirect:/professor";
    }

}
