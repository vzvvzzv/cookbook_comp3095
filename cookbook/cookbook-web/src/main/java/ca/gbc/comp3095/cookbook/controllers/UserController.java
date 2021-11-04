package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;
    private HttpSession newSession;

    public UserController(UserService userService) {
        this.userService = userService;
        this.newSession = null;
    }

    @RequestMapping({"", "/", "/index.html"})
    public String listUsers(Model model){

        model.addAttribute("users", userService.findAll());

        return "/users/index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new User());
        return "/users/login";
    }

    @PostMapping({"/process_login"})
    public String process_login(User user, HttpSession session, HttpServletRequest request) {

        session.invalidate();
        boolean checkBool = userService.checkCredentials(user);
        System.out.println("Check Boolean: " + checkBool);
        if (checkBool) {
            // Create new session & set user as the attribute
            newSession = request.getSession();
            newSession.setAttribute("user", user);

            // Check Redirect
            System.out.println("Redirect to Profile");
            return "redirect:/users/profile";
        } else {
            System.out.println("Redirect to Login");
            return "redirect:/users/login";
        }
    }

    @RequestMapping("/profile")
    public String displayProfile(){

        // Checking if session persists
        if (newSession == null) {
            System.out.println(newSession);
            return "redirect:/users/login";
        }

        // Checking Session
        System.out.println(newSession);
        return "/users/profile";
    }
}
