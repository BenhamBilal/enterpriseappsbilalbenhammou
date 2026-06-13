package com.example.enterpriseappsbilalbenhammou.service;

import com.example.enterpriseappsbilalbenhammou.model.Event;
import com.example.enterpriseappsbilalbenhammou.model.Locatie;
import com.example.enterpriseappsbilalbenhammou.repository.EventRepository;
import com.example.enterpriseappsbilalbenhammou.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private LocatieRepository locatieRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String... args) {
        if (locatieRepository.count() == 0) {
            Locatie loc1 = new Locatie("Community Center", "Street 1, Anderlecht", 100);
            Locatie loc2 = new Locatie("Park Hall", "Street 2, Anderlecht", 50);
            locatieRepository.save(loc1);
            locatieRepository.save(loc2);

            eventRepository.save(new Event(LocalDateTime.now().plusDays(1), "Fundraiser", "Help raise funds", "NGO", "contact@ngo.be", loc1));
            eventRepository.save(new Event(LocalDateTime.now().plusDays(5), "Workshop", "Learn new skills", "Partner Org", "info@partner.be", loc2));
            eventRepository.save(new Event(LocalDateTime.now().minusDays(1), "Past Event", "An old event", "NGO", "contact@ngo.be", loc1));
        }
    }
}