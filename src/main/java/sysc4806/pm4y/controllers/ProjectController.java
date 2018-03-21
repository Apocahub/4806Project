package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController
{
    private VerificationController ver;

    @Autowired
    public void setAuth(VerificationController ver){
        this.ver = ver;
    }

    public UserRepo userRepo;
    public ProjectRepo projectRepo;
    @Autowired
    public ProjectController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value = "/createProj", method = RequestMethod.POST)
    public String projectCreation(Model model,
                                  @ModelAttribute("project") Project project,
                                  @CookieValue(value="sessionId",defaultValue="") String sessionId) {
        //Project project = null;
        if(!ver.isAuthenticated(sessionId)) {
            //failed
            return "redirect:/logout";
        }
        List<User> rets = userRepo.findAll();
        List<User> returns = userRepo.findBySessionId(sessionId);
        project.setProfessor((Prof)returns.get(0));
        projectRepo.save(project);
        return "redirect:/prof";
    }

}
