package sysc4806.pm4y.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sysc4806.pm4y.models.UserRepo;
import sysc4806.pm4y.models.Student;

import java.util.*;
import org.springframework.*;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController
{
    private UserRepo repo;

    @Autowired
    public void setRepo(UserRepo repo)
    {
        this.repo = repo;
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.GET)
    public String createStudent(@RequestParam("first") String first,
                                @RequestParam("last") String last,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password)


    {
        Student student = new Student(first,last);
        student.setEmail(email);
        student.setPassword(password);
        repo.save(student);
        return "login";
    }

    @RequestMapping(value = "/createStudents",method = RequestMethod.GET)
    public String createStudents()
    {
        return "createStudents";
    }
}
