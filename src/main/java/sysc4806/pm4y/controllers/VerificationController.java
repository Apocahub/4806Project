package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class VerificationController {

    private int sessionCount = 0;

    public UserRepo userRepo;
    public ProjectRepo projectRepo;
    @Autowired
    public void instantiateRepo(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value="/login")
    public String login(@ModelAttribute(value = "user") User user,
                        @ModelAttribute(value = "type") String type,
                        HttpServletResponse response,
                        Model model) {

        List<User> accounts = userRepo.findByEmail(user.getEmail());

        //Query repo for account and check if exists

        if(user.getPassword().equals(accounts.get(0).getPassword())) { // true if account exists

            accounts.get(0).setSessionId("u" + sessionCount++);
            userRepo.save(accounts.get(0));
            //repo.save(user);
            response.addCookie(new Cookie("sessionId", accounts.get(0).getSessionId()));
            if(type.equals("prof")) {
                return "redirect:/prof";
            } else if (type.equals("stu")) {
                return "redirect:/student";
            } else if (type.equals("admin")) {
                return "redirect:/admin";
            }
        } else {
            //password incorrect
        }

        response.addCookie(new Cookie("sessionId", null));
        return "redirect:/logout";
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public ModelAndView logout(Model model, HttpServletResponse response) {
        response.addCookie(new Cookie("sessionId", null));
        return new ModelAndView("redirect:/");
    }


    public boolean isAuthenticated(String sessionId) {
        List<User> users = userRepo.findBySessionId(sessionId);
        return !users.isEmpty();
    }

}
