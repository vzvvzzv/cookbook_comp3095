package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Event;
import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.EventService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RequestMapping("/events")
@Controller
public class EventController {
    // Dependencies
    private final EventService eventService;
    private final UserService userService;

    // Constructor Dependency Injection
    public EventController(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }



    @RequestMapping("/viewEvent")
    public String viewEvent(Model model) {

        model.addAttribute("events", eventService.findAll());
        return "/events/view-event";
    }

//    @RequestMapping("/addEvent")
//    public String addEvent(Event event, HttpSession session){
//
//        System.out.println(event.getEventName() + " " + event.getEventUser()); // Check
//
//        Set<Event> userEvent = null;
//
//        if (session.getAttribute("userEvent") != null) {
//            userEvent = (Set) session.getAttribute("userEvent");
//        } else {
//            userEvent = new HashSet<Event>();
//        }
//        userEvent.add(event);
//        session.setAttribute("userEvent", userEvent);
//
//        return "redirect:/events/edit-events";
//    }
//    @RequestMapping("/removeEvent")
//    public String removeEvent(@RequestParam String eventName, @RequestParam String eventUser,
//                                   HttpSession session){
//
//        System.out.println(eventName + " " + eventUser); // Check
//
//        Event eventRemove = new Event();
//        eventRemove.setEventName(eventName);
//        eventRemove.setEventUser(eventUser);
//
//        Set<Event> userEvent = (Set) session.getAttribute("userEvent");
//        Iterator eventFind = userEvent.iterator();
//
//        while (eventFind.hasNext()) {
//            Event temp = (Event) eventFind.next();
//            if (eventRemove.equals(temp)) {
//                userEvent.remove(temp);
//                break;
//            }
//        }
//
//        session.setAttribute("userEvent", userEvent);
//
//        return "redirect:/events/edit-events";
//    }

}