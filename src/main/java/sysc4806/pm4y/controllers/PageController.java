package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.time.LocalDateTime;
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
    public String studentLoggedIn(Model model,
                                  @PathVariable("id") String id){
        Student me = (Student) userRepo.findById(id);
        if(me.getProject() == null) {
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
            model.addAttribute(Student.MODEL_NAME, me);
            model.addAttribute("dueDateProject", (toDisplay.isEmpty() ? new Project() : toDisplay.get(0)));
            return "studentLandingPage";
        } else {
            //isRegistered

            LocalDateTime t = me.getProject().getDue();
            if(t != null && t.isBefore(LocalDateTime.now())) {
                model.addAttribute("dueDateProject", me.getProject());
                return "studentDeadlinePassed";
            }
            model.addAttribute(Student.MODEL_NAME, me);
            model.addAttribute("dueDateProject", me.getProject());
            return "studentSubmissionPage";
        }
    }

    @RequestMapping(value="/student/{id}/project/{pid}")
    public String applyToProject(Model model,
                                 @PathVariable("id") String id,
                                 @PathVariable("pid") String pid,
                                 RedirectAttributes redirectAttributes) {
        Project toApply = projectRepo.findById(Integer.parseInt(pid));
        Student me = (Student)userRepo.findById(id);
        toApply.addStudent(me);
        me.setProject(toApply);
        List<Project> projectGarbage = projectRepo.findAll();
        List<User> userGarbage = userRepo.findAll();
        return "redirect:/student/" + id;
    }
}
