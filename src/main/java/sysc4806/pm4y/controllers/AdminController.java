package sysc4806.pm4y.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sysc4806.pm4y.models.DateContainer;
import sysc4806.pm4y.models.Project;
import sysc4806.pm4y.models.Student;
import sysc4806.pm4y.models.User;
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
        model.addAttribute("id", id);
        redirectAttributes.addFlashAttribute("test", "test");
        return "adminLandingPage";
    }

    @RequestMapping(value = "/admin/updateDate")
    public String dueDateUpdate(Model model,
                                @ModelAttribute(value = "dateContainer") DateContainer dateContainer) {
        //Need ID to get back to admin landing page

        LocalDateTime date = dateContainer.getDateTime();
        if(date == null) {
            return "redirect:/";
        }
        List<Project> projects = projectRepo.findAll();
        for(Project p : projects) {
            p.setDue(date);
        }
        return "redirect:/";
    }
}
