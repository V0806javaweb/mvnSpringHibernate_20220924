package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Student;

@Controller
public class StudentController {
	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        Student temp=new Student();
        temp.setId(1);
        temp.setUserName("John");
        temp.setAge(20);
        return new ModelAndView("jqStudent", "command", temp);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {
        model.addAttribute("name", student.getUserName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());

        return "result";
    }
}
