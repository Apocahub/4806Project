package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.util.List;

@Controller
public class ProjectController
{
    private ProjectRepo repo;
    private UserRepo repo2;

    @Autowired
    public void setRepo(ProjectRepo repo)
    {
        this.repo = repo;
    }

    @Autowired
    public void setUserRepo(UserRepo repo2)
    {
        this.repo2 = repo2;
    }

    @RequestMapping(value="/createProject",method=RequestMethod.GET)
    public String createProject(@RequestParam(value="name") String name,
                                @RequestParam(value="maxStudents") int maxStudents,
                                @RequestParam(value="description") String description,
                                @RequestParam(value="restrictions") String restrictions,
                                @CookieValue(value="sessionId",defaultValue="") String sessionId,
                                Model model){

        List<User> profs = repo2.findBySessionId(sessionId);
        Prof prof = (Prof) profs.get(0);
        Project p = new Project();
        p.setProjectName(name);
        p.setProfessor(prof);
        p.setMaxStudents(maxStudents);
        p.setDescription(description);
        p.setRestrictions(restrictions);
        model.addAttribute("project",p);
        repo.save(p);
        return "project";
    }

    @RequestMapping(value="/deleteProject",method=RequestMethod.GET)
    public String deleteProject(@RequestParam(value="projectId") int projectId,
                                @CookieValue(value="sessionId",defaultValue="") String sessionId,
                                Model model){

        List<User> profs = repo2.findBySessionId(sessionId);
        List<Project> projects = repo.findById(projectId);
        Project p = projects.get(0);
        repo.delete(p);
        model.addAttribute("delete",true);
        return "deleted";
    }
}
