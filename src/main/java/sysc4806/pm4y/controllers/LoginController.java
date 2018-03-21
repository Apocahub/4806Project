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
import sysc4806.pm4y.models.UserType;
import sysc4806.pm4y.repositories.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(User.MODEL_NAME, new User());
        return "login";
    }

    @RequestMapping(value = "/createProfessor",method = RequestMethod.POST)
    public String createProfessor(@ModelAttribute(User.MODEL_NAME) User user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.PROFESSOR);
        return "redirect:/login";
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public String createStudent(@ModelAttribute(User.MODEL_NAME) User user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.STUDENT);
        return "redirect:/login";
    }

    @RequestMapping(value = "/createCoordinator",method = RequestMethod.POST)
    public String createAdmin(@ModelAttribute(User.MODEL_NAME) User user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.COORDINATOR);
        return "redirect:/login";
    }
}
