package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import sysc4806.pm4y.models.Prof;
import sysc4806.pm4y.models.ProjectCoordinator;
import sysc4806.pm4y.models.Student;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    private final UserRepo repo;

    @Autowired
    public LoginController(final UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model,
                        HttpServletResponse response,
                        @CookieValue(value="sessionId",defaultValue="") String sessionId) {

        if(!sessionId.equals("")) {
            response.addCookie(new Cookie("sessionId", null));
        } else {
            //Log in user, using the existing sessionId
        }

        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/createProfessor",method = RequestMethod.POST)
    public RedirectView createProfessor(Model model,
                                        @ModelAttribute("user") User user,
                                        RedirectAttributes ra) {
        ra.addFlashAttribute("user", user);
        ra.addFlashAttribute("type", "prof");
        return new RedirectView("login");
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public RedirectView createStudent(Model model,
                                      @ModelAttribute("user") User user,
                                      RedirectAttributes ra) {
        ra.addFlashAttribute("user", user);
        ra.addFlashAttribute("type", "stu");
        return new RedirectView("login");
    }

    @RequestMapping(value = "/createCoordinator",method = RequestMethod.POST)
    public RedirectView createAdmin(Model model,
                              @ModelAttribute("user") User user,
                              RedirectAttributes ra) {
        ra.addFlashAttribute("user", user);
        ra.addFlashAttribute("type", "admin");
        return new RedirectView("login");
    }
}
