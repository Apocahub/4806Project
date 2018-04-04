package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    private UserRepo userRepo;
    private ProjectRepo projectRepo;

    @Autowired
    public AdminController(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
    }


    @RequestMapping(value="/admin/{id}")
    public String adminLoggedIn(Model model,
                                @PathVariable("id") String id,
                                RedirectAttributes redirectAttributes){
        User me = userRepo.findById(id);
        List<User> returns = userRepo.findAll();
        List<Student> toDisplay = new ArrayList<Student>();
        for (User user : returns) {
            if(user instanceof Student) {
                if (((Student) user).getProject() == null) {
                    toDisplay.add((Student)user);
                }
            }
        }
        model.addAttribute("users", toDisplay);
        model.addAttribute(ProjectCoordinator.MODEL_NAME, me);
        return "adminLandingPage";
    }

    @RequestMapping(value = "/admin/updateDate/{id}")
    public String dueDateUpdate(Model model,
                                @PathVariable("id") String id,
                                @ModelAttribute("dateContainer") DateContainer dateContainer,
                                RedirectAttributes redirectAttributes) {

        LocalDateTime date = dateContainer.getDateTime();
        if(date == null) {
            redirectAttributes.addFlashAttribute("notify", "Not a valid date/time!");
            redirectAttributes.addFlashAttribute("dateContainer", new DateContainer());
            return "redirect:/admin/" + id;
        }
        List<Project> projects = projectRepo.findAll();
        for(Project p : projects) {
            p.setDue(date);
        }

        //Do not touch me, code doesnt work without extra query (no idea)
        List<Project> projects2 = projectRepo.findAll();

        redirectAttributes.addFlashAttribute("notify", "Project due date updated");
        redirectAttributes.addFlashAttribute("dateContainer", new DateContainer());
        return "redirect:/admin/" + id;
    }
}
