package com.toursappbackend.repository;

import com.toursappbackend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByGroupId(UUID groupId);
}
