package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class VerificationController {

    private int sessionCount = 0;

    private UserRepo repo;
    @Autowired
    public void instantiateRepo(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value="/login")
    public String login(@ModelAttribute(value = "user") User user,
                        @ModelAttribute(value = "type") String type,
                        HttpServletResponse response) {

        //List<User> accounts = repo.findByEmail(user.getEmail());
        //Query repo for account and check if exists

        if(user.getPassword().equals("test")) { // true if account exists
            user.setSessionId("u" + sessionCount++);
            //repo.save(user);
            response.addCookie(new Cookie("sessionId", user.getSessionId()));
            if(type.equals("prof")) {
                return "redirect:/professor";
            } else if (type.equals("stu")) {
                return "studentLandingPage";
            } else if (type.equals("admin")) {
                return "adminLandingPage";
            }
        } else {
            //password incorrect
        }


        response.addCookie(new Cookie("sessionId", null));
        return "redirect:/";
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public ModelAndView logout(Model model, HttpServletResponse response) {
        response.addCookie(new Cookie("sessionId", null));
        return new ModelAndView("redirect:/");
    }

}
