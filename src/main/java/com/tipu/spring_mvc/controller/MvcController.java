package com.tipu.spring_mvc.controller;


import com.tipu.spring_mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MvcController {



    //Method Level Method Attribute

    @RequestMapping("/addProgrammer")
    String addProgrammer(){
        return "programmer/add.html";
    }


    //Model and Model Map same Model Map implemented with map
    @PostMapping("/programmerInfo")
    String programmerInfo(@RequestParam String name, @RequestParam(name = "age") Integer a, Model model){

        System.out.println("Name: "+ name +" Age: " + a);
        model.addAttribute("name", name);
        model.addAttribute("age", a);

        return "programmer/info.html";
    }


    @RequestMapping("/addModelView")
    String addModelView(){
        return "modelview/add.html";
    }



    //View With ModelAndView to model and view Togater;

    //Almost same to Model but should Familiar different style to understand other code
    @PostMapping("/viewModelView")
    ModelAndView viewModelView(@RequestParam String name, @RequestParam(name = "age") Integer a){

        ModelAndView mv = new ModelAndView();

        System.out.println("Name: "+ name +" Age: " + a);

        mv.addObject("name", name);
        mv.addObject("age", a);

        mv.setViewName("modelview/view.html");

        return mv;


    }


    //ModelAttribute
    @RequestMapping("/addModelAttribute")
    String addModelAttribute(){
        return "modelAttribute/add.html";
    }

    //Model take frontend data as object and bind automatic to view

    @PostMapping("/viewModelAttribute")
    String viewModelAttribute(@ModelAttribute Student student){

        System.out.println("Name: "+ student.getName() +" Age: " + student.getAge());
        return "modelAttribute/view.html";


    }







}
