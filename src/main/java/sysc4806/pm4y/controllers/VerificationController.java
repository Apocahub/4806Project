package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.User;
import sysc4806.pm4y.models.UserType;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class VerificationController {
    private UserRepo repo;
    @Autowired
    public void instantiateRepo(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping(value="/login")
    public String login(@ModelAttribute(value = User.MODEL_NAME) User user,
                        @ModelAttribute(value = UserType.MODEL_NAME) UserType userType,
                        RedirectAttributes redirectAttributes) {

        User account = repo.findByEmail(user.getEmail());
        if(account == null) {
            repo.save(user);
        } else if(!account.getPassword().equals(user.getPassword())) {
            redirectAttributes.addFlashAttribute("error", "Login Failed");
            return "redirect:/";
        }
        switch (userType) {
            case PROFESSOR:
                return "redirect:/professor";
            case STUDENT:
                return "studentLandingPage";
            case COORDINATOR:
                return "adminLandingPage";
            default:
                redirectAttributes.addFlashAttribute("error","Error occurred while attempting to login");
                return "redirect:/";
        }

    }
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
