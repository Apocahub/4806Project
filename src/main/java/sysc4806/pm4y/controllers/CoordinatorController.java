package sysc4806.pm4y.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sysc4806.pm4y.models.*;
import java.util.*;
import org.springframework.*;
import org.springframework.stereotype.Controller;

@Controller
public class CoordinatorController
{
    private UserRepo repo;
    private ProjectRepo repo2;

    @Autowired
    public void setUserRepo(UserRepo repo)
    {
        this.repo = repo;
    }

    @Autowired
    public void setProjRepo(ProjectRepo repo2)
    {
        this.repo2 = repo2;
    }

    @RequestMapping(value = "/createCoordinator",method = RequestMethod.GET)
    public String createCoordinator(@RequestParam("email") String email,
                                @RequestParam("password") String password)


    {
        ProjectCoordinator p = new ProjectCoordinator(email, password);
        p.setEmail(email);
        p.setPassword(password);
        repo.save(p);
        return "login";
    }

    @RequestMapping(value = "/createCoordinatorss",method = RequestMethod.GET)
    public String createCoordinators()
    {
        return "createCoordinator";
    }
}
