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
        System.out.println("Check Boolean: " + checkBool); // Check

        if (checkBool) {
            // Create new session & set user as the attribute
            newSession = request.getSession();
            newSession.setAttribute("user", user);

            // Redirect to Recipes (App)
            System.out.println("Redirect to Profile"); // Check
            return "redirect:/recipes";
        } else {
            System.out.println("Redirect to Login"); // Check
            return "redirect:/users/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        newSession = null;
        return "/users/logout";
    }
}
