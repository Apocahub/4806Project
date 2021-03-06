package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.*;
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
    private Prof prof;
    @Autowired
    public ProfessorController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }
    @RequestMapping("/{id}")
    public String profLoggedIn(Model model, @PathVariable(value = "id") String id) {
        User user = userRepo.findById(id);
        if(!user.getSessionId().equals(RequestContextHolder.currentRequestAttributes().getSessionId())) {
            return "redirect:/logout";
        }
        if(!(user instanceof Prof)) {
            return "redirect:/logout";
        }
        prof =  (Prof) user;
        List<Project> returns = projectRepo.findAll();
        List<Project> toDisplay = new ArrayList<Project>();

        for (Project project : returns) {
            if(project.getProfessor() == null) continue;
            if(project.getProfessor().equals(prof)) {toDisplay.add(project);}
        }

        model.addAttribute("projects", toDisplay);
        model.addAttribute("dueDateProject", (toDisplay.isEmpty() ? new Project() : toDisplay.get(0)));
        model.addAttribute(Prof.MODEL_NAME, prof);
        return "profLandingPage";
    }

    @RequestMapping(value = "/{id}/project/new", method = RequestMethod.GET)
    public String createProject(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute(Project.MODEL_NAME, new Project());
        model.addAttribute("id", id);
        return "projectCreationPage";
    }

    @RequestMapping(value = "/{id}/project/new", method = RequestMethod.POST)
    public String create(@PathVariable(value = "id") String id,
                         @RequestParam("projectName") String projectName,
                         @RequestParam("description") String description,
                         @RequestParam("maxStudents") int maxStudents,
                         @RequestParam(required = false, name="engineeringStreams") List<EngineeringStream> engineeringStreams) {
        Project project = new Project();
        project.setProfessor(prof);
        project.setProjectName(projectName);
        project.setDescription(description);
        project.setMaxStudents(maxStudents);
        project.setEngineeringStreams(engineeringStreams!=null ? engineeringStreams : new ArrayList<EngineeringStream>());
        projectRepo.save(project);
        return "redirect:/prof/" + id;
    }

    //Hacky
    @RequestMapping(value = "/{id}/project/{pid}/delete", method = RequestMethod.POST)
    private String delete(@PathVariable(value = "id") String id, @PathVariable(value = "pid") Long pid) {
        projectRepo.deleteById(pid);
        return "redirect:/prof/" + id;
    }

    @RequestMapping(value = "/{id}/project/{pid}/archive", method = RequestMethod.POST)
    private String archive(@PathVariable(value = "id") String id, @PathVariable(value = "pid") String pid) {
        Project p = projectRepo.findById(Integer.parseInt(pid));
        p.isArchived = !p.isArchived;

        List<Project> garbage = projectRepo.findAll();

        return "redirect:/prof/" + id;
    }
}
