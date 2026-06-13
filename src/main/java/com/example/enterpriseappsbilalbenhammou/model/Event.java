package com.example.enterpriseappsbilalbenhammou.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "evenementen")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String organization;

    private String contactEmail;

    @ManyToOne
    @JoinColumn(name = "locatie_id")
    private Locatie location;

    public Event() {}

    public Event(LocalDateTime timestamp, String title, String description,
                 String organization, String contactEmail, Locatie location) {
        this.timestamp = timestamp;
        this.title = title;
        this.description = description;
        this.organization = organization;
        this.contactEmail = contactEmail;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getOrganization() { return organization; }
    public void setOrganization(String organization) { this.organization = organization; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public Locatie getLocation() { return location; }
    public void setLocation(Locatie location) { this.location = location; }
}
