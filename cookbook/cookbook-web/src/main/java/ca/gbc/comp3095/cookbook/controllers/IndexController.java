/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: IndexController displays the index page
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotates this class as a Controller to be managed by Spring Boot
public class IndexController {

    // maps the method to the base url and returns the index.html
    @RequestMapping({"", "/", "index.html"})
    public String index() {
        return "index";

    }
}
