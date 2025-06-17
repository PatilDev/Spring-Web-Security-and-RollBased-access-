package com.dev.springsecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// step3
@Controller
public class LoginController {
@GetMapping("/show_login_page")
public String showLoginPage() {
    return "plain-login";
}
@GetMapping("/access-denied")
public String showAccessDenied() {
    return "access-denied";
}


}
