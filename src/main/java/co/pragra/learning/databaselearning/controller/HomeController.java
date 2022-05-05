package co.pragra.learning.databaselearning.controller;

import co.pragra.learning.databaselearning.dao.StudentDAO;
import co.pragra.learning.databaselearning.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
private StudentDAO dao;

    public HomeController(StudentDAO dao) {
        this.dao = dao;
    }

    //@RequestMapping(method = RequestMethod.GET,path = "/")
@GetMapping("/")
    public String home(Model model){
    model.addAttribute("name","Shintu Sebastian");
    Student student = dao.getbyId(2);
    model.addAttribute("st",student);
    return "index";
}
}
