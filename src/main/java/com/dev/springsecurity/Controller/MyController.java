package com.dev.springsecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MyController {
@GetMapping("/home")   
public String homepage(Model model)
{
    return "home";
}
//add a request mapping for /leaders
@GetMapping("/leaders")
public String showLeaders() {
    return "leaders";
}
 
 @GetMapping("/admin")
public String showAdmin() {
    return "systems";
}



}
