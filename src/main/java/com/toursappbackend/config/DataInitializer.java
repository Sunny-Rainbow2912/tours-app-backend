package com.toursappbackend.config;


import com.toursappbackend.model.Event;
import com.toursappbackend.model.Group;
import com.toursappbackend.repository.EventRepository;
import com.toursappbackend.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final GroupRepository groupRepository;
    private final EventRepository eventRepository;

    @Override
    public void run(String... args) {
        if (groupRepository.count() == 0) {
            Group chicago = groupRepository.save(
                    Group.builder()
                            .name("Chicago JUG")
                            .city("Chicago")
                            .state("IL")
                            .country("USA")
                            .build()
            );

            Group london = groupRepository.save(
                    Group.builder()
                            .name("London JUG")
                            .city("London")
                            .state(null)
                            .country("UK")
                            .build()
            );

            eventRepository.saveAll(List.of(
                    Event.builder()
                            .title("Spring Boot Meetup")
                            .date(LocalDate.of(2024, 3, 10))
                            .description("Getting started with Spring Boot")
                            .group(chicago)
                            .build(),

                    Event.builder()
                            .title("Reactive Streams Talk")
                            .date(LocalDate.of(2024, 6, 5))
                            .description("Explore Project Reactor")
                            .group(chicago)
                            .build(),

                    Event.builder()
                            .title("London JUG Panel")
                            .date(LocalDate.of(2024, 4, 20))
                            .description("Discussion on Java 21")
                            .group(london)
                            .build()
            ));
        }
    }
}
