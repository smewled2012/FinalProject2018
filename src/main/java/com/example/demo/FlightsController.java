package com.example.demo;

import com.example.demo.security.RoleRepository;
import com.example.demo.security.User;
import com.example.demo.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FlightsController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    OptionTypeRepository optionTypeRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

        if(result.hasErrors()){
            return "registration";
        }

        else {
            userRepository.save(user);
            model.addAttribute("message", "User Account Created");
        }
        return "index";
    }


//    @RequestMapping("/")
//    public String index(Model model, Principal principal) {
//        User currentUser = principal != null ? userRepository.findByUsername(principal.getName()) : null;
//        model.addAttribute("user", currentUser);
//        model.addAttribute("flights", flightRepository.findAll());
//
//        return "index";
//    }

    @RequestMapping("/")
    public String index(Model model) {
       // model.addAttribute("user", currentUser);
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("option", new OptionType());
        model.addAttribute("flight", new Flight());

        return "homepage";
    }

    @RequestMapping("/flights")
    public String search(Model model, Principal principal) {
        User currentUser = principal != null ? userRepository.findByUsername(principal.getName()) : null;
        model.addAttribute("user", currentUser);

        model.addAttribute("search", new FlightSearch());
        model.addAttribute("airports", airportRepository.findAll());

        return "search";
    }



    @PostMapping("/processSearch")
    public String processSearch(@Valid FlightSearch flightSearch, BindingResult result, Model model, Principal principal) {

        if (result.hasErrors()) {
            User currentUser = userRepository.findByUsername(principal.getName());
            model.addAttribute("user", currentUser);
            return "search";
        }

        ArrayList<Flight> flights = new ArrayList<>();
        for (Flight flight : flightRepository.findAll()) {
            if (flight.getFrom().getCode().equals(flightSearch.getFrom().getCode()) &&
                    flight.getTo().getCode().equals(flightSearch.getTo().getCode())) {
                flights.add(flight);
            }
        }
        model.addAttribute("flightOptions", flights);

        model.addAttribute("search", flightSearch);
        model.addAttribute("airports", airportRepository.findAll());

        return "search";
    }

    @PostMapping("/process")
    public String saveFlight(@Valid Flight flight, BindingResult result, OptionType option, Principal principal) {

        if (result.hasErrors()) {
            return "homepage";
        }


        flightRepository.save(flight);
        optionTypeRepository.save(option);

        return "search";
    }



}
