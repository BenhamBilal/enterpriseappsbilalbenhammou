package com.example.enterpriseappsbilalbenhammou.service;

import com.example.enterpriseappsbilalbenhammou.model.Event;
import com.example.enterpriseappsbilalbenhammou.model.Locatie;
import com.example.enterpriseappsbilalbenhammou.repository.EventRepository;
import com.example.enterpriseappsbilalbenhammou.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocatieRepository locatieRepository;

    public List<Event>getTop10Events(){
        return eventRepository.findTop10ByOrderByTimestampDesc();
    }


    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void saveEvent(Event event, Long locatieId) {
        Locatie locatie = locatieRepository.findById(locatieId).orElseThrow(() -> new RuntimeException("Location not found"));
        event.setLocation(locatie);
        eventRepository.save(event);
    }

    public List<Locatie> getAllLocations() {
        return locatieRepository.findAll();
    }
}
