package sysc4806.pm4y.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sysc4806.pm4y.models.UserRepo;
import sysc4806.pm4y.models.Prof;


import java.util.*;
import org.springframework.*;
import org.springframework.stereotype.Controller;

@Controller
public class ProfessorController
{
    private UserRepo repo;

    @Autowired
    public void setRepo(UserRepo repo)
    {
        this.repo = repo;
    }

    @RequestMapping(value = "/createProfessor",method = RequestMethod.GET)
    public String createStudent(@RequestParam("first") String first,
                                @RequestParam("last") String last,
                                @RequestParam("email") String email,
                                @RequestParam("password") String password)


    {
        Prof prof = new Prof(first,last);
        prof.setEmail(email);
        prof.setPassword(password);
        repo.save(prof);
        return "login";
    }

    @RequestMapping(value = "/createProfessors",method = RequestMethod.GET)
    public String createProfs()
    {
        return "createProf";
    }
}
