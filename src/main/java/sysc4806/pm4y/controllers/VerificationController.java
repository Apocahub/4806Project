package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VerificationController {

    private UserRepo userRepo;
    private ProjectRepo projectRepo;
  
    @Autowired
    public VerificationController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }

    @RequestMapping(value="/login")
    public String login(@ModelAttribute(value = User.MODEL_NAME) User user,
                        @ModelAttribute(value = UserType.MODEL_NAME) UserType userType,
                        RedirectAttributes redirectAttributes) {

        User account = userRepo.findByEmail(user.getEmail());
        if(account == null) {
            userRepo.save(user);
            account = user;
        } else if(!account.getPassword().equals(user.getPassword())) {
            redirectAttributes.addFlashAttribute("error", "Login Failed");
            return "redirect:/";
        }
        account.setSessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
        userRepo.save(account);
        switch (userType) {
            case PROFESSOR:
                return "redirect:/prof/" + account.getId();
            case STUDENT:
                return "redirect:/student/" + account.getId();
            case COORDINATOR:
                return "redirect:/admin/" + account.getId();
            default:
                redirectAttributes.addFlashAttribute("error","Error occurred while attempting to login");
                return "redirect:/logout";
        }

    }
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        Cookie killMe = new Cookie("JSESSIONID", null);
        killMe.setMaxAge(0);
        killMe.setPath("/");
        response.addCookie(killMe);

        return "redirect:/";
    }


    public boolean isAuthenticated(String sessionId) {
        List<User> users = userRepo.findBySessionId(sessionId);
        return !users.isEmpty();
    }

}
