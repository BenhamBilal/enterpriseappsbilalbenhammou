Enterprise Apps Bilal Benhammou
===============================

Beschrijving
------------
Een Spring Boot webapplicatie prototype voor een Anderlechtse NGO.
Beheert gemeenschapsevenementen met locatiedetails, een over-pagina en een contactformulier.

Frameworks & Bibliotheken
-------------------------
- Spring Boot 4.0.6
- Spring MVC (Thymeleaf templating)
- Spring Data JPA (Hibernate ORM)
- H2 Database (in-memory)
- Tailwind CSS (via CDN)

Tutorials & Documentatie
------------------------
- Spring Boot Getting Started: https://spring.io/guides/gs/spring-boot/
- Thymeleaf Documentatie: https://www.thymeleaf.org/documentation.html
- Spring Data JPA Reference: https://docs.spring.io/spring-data/jpa/reference/
- H2 Database: https://www.h2database.com/html/main.html
- Tailwind CSS: https://tailwindcss.com/docs

AI Chat Geschiedenis
--------------------
- opencode (AI coding assistant): Begeleiding bij projectstructuur (MVC patroon, mappenindeling), uitleg over JPA entiteitsrelaties en Thymeleaf fragments. Geen code geschreven, enkel uitleg en advies gekregen.
- ChatGPT: Tailwind CSS classes voor professionele layout en kleurenschema (blauw/oranje combinatie en card-design).
- link van ia Chat [AI Chat Geschiedenis](aiChatGeschiedenis.md)

Handleiding / Hoe uit te voeren 
-------------------------------
1. Zorg dat Java 25 geinstalleerd is (java -version)
2. Open een terminal in de project root map
3. Voer uit: ./gradlew bootRun (of gradlew.bat bootRun op Windows)
4. Open http://localhost:8080 in je browser
5. H2 Console beschikbaar op http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:ngo)