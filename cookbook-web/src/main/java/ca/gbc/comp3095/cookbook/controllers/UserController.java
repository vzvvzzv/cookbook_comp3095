/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: UserController displays pages in the /users subdirectory.
 * UserController manages the login and logout process
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/users") // Map controller to /users path in URL
@Controller // Annotates this class as a Controller to be managed by Spring Boot
public class UserController {

    // Dependencies
    private final UserService userService;
    private HttpSession newSession;

    // Constructor Dependency Injection
    public UserController(UserService userService) {
        this.userService = userService;
        this.newSession = null;
    }

    // adds all users to model.attribute & returns /users/index
    @RequestMapping({"", "/", "/index.html"})
    public String listUsers(Model model){

        model.addAttribute("users", userService.findAll());
        return "/users/index";
    }

    // maps method to /users/login path
    // adds new user object as attribute to model and returns /users/login
    @RequestMapping("/login")
    public String login(Model model) {

        model.addAttribute("user", new User());
        return "/users/login";
    }

    // maps method to /users/process_login (POST)
    // invalidates session, checks if user object equals to a user in the database
    // if true it gets a session & sets the user object as a session attribute
    // if false returns to login page
    @PostMapping({"/process_login"})
    public String process_login(User user, HttpSession session, HttpServletRequest request) {

        session.invalidate();
        boolean checkBool = userService.checkCredentials(user);

        if (checkBool) {
            // get session & set user as the attribute
            newSession = request.getSession();
            newSession.setAttribute("user", user);

            // Redirect to Recipes (App)
            return "redirect:/recipes/";
        } else {
            return "redirect:/users/login";
        }
    }

    @PostMapping("/update_user")
    public String update_user(User user, HttpServletRequest request){
        newSession = request.getSession();
        User tempUser = userService.findByUsername(user.getUsername());
        tempUser.setFirstname(user.getFirstname());
        tempUser.setLastname(user.getLastname());
        tempUser.setEmail(user.getEmail());
        userService.save(tempUser);
        return "/users/update-user-success";
    }

    @PostMapping("/change_password")
    public String change_password(User user, HttpServletRequest request){
        newSession = request.getSession();
        newSession.setAttribute("user", user);
        return "/users/change-password";
    }

    @PostMapping("/update_password")
    public String update_password(User user, HttpServletRequest request){
        newSession = request.getSession();
        User tempUser = userService.findByUsername(user.getUsername());
        tempUser.setPassword(user.getPassword());
        userService.save(tempUser);
        return "/users/update-password-success";
    }

    // maps method to /users/logout path
    // invalidates session to clear attributes, sets newSession to null. and returns /users/logout
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        newSession = null;
        return "/users/logout";
    }
}
