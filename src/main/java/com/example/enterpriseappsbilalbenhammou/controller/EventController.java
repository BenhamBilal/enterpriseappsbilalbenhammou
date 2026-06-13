package com.example.enterpriseappsbilalbenhammou.controller;

import com.example.enterpriseappsbilalbenhammou.model.Event;
import com.example.enterpriseappsbilalbenhammou.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
    public class EventController {

        @Autowired
        private EventService eventService;

        @GetMapping("/new")
        public String showNewForm(Model model) {
            model.addAttribute("event", new Event());
            model.addAttribute("locations", eventService.getAllLocations());
            return "new";
        }

        @PostMapping("/new")
        public String createEvent(@RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam String organization,
                                  @RequestParam String contactEmail,
                                  @RequestParam String timestamp,
                                  @RequestParam Long locationId,
                                  Model model) {
            if (title.isEmpty() || description.isEmpty() || organization.isEmpty() ||
                    contactEmail.isEmpty() || !contactEmail.contains("@") || locationId == null) {
                model.addAttribute("error", "All fields are required and email must be valid");
                model.addAttribute("locations", eventService.getAllLocations());
                return "new";
            }

            Event event = new Event();
            event.setTitle(title);
            event.setDescription(description);
            event.setOrganization(organization);
            event.setContactEmail(contactEmail);
            event.setTimestamp(LocalDateTime.parse(timestamp));

            eventService.saveEvent(event, locationId);
            return "redirect:/";
        }

        @GetMapping("/detail/{id}")
        public String detail(@PathVariable Long id, Model model) {
            model.addAttribute("event", eventService.getEventById(id));
            return "detail";
        }
}
