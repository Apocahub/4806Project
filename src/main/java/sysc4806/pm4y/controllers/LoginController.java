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
        model.addAttribute(Prof.MODEL_NAME, new Prof());
        model.addAttribute(Student.MODEL_NAME, new Student());
        model.addAttribute(ProjectCoordinator.MODEL_NAME, new ProjectCoordinator());
        return "login";
    }

    @RequestMapping(value = "/createProfessor",method = RequestMethod.POST)
    public String createProfessor(@ModelAttribute(Prof.MODEL_NAME) Prof user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.PROFESSOR);
        return "redirect:/login";
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public String createStudent(@ModelAttribute(Student.MODEL_NAME) Student user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.STUDENT);
        return "redirect:/login";
    }

    @RequestMapping(value = "/createCoordinator",method = RequestMethod.POST)
    public String createAdmin(@ModelAttribute(ProjectCoordinator.MODEL_NAME) ProjectCoordinator user, RedirectAttributes ra) {
        ra.addFlashAttribute(User.MODEL_NAME, user);
        ra.addFlashAttribute(UserType.MODEL_NAME, UserType.COORDINATOR);
        return "redirect:/login";
    }
}
