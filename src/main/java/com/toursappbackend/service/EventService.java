package com.toursappbackend.service;

import com.toursappbackend.entity.Event;
import com.toursappbackend.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public List<Event> getByGroupId(UUID groupId) {
        return eventRepository.findByGroupId(groupId);
    }

    public Event getById(UUID id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(UUID id, Event updatedEvent) {
        return eventRepository.findById(id).map(existing -> {
            existing.setTitle(updatedEvent.getTitle());
            existing.setDate(updatedEvent.getDate());
            existing.setDescription(updatedEvent.getDescription());
            return eventRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void delete(UUID id) {
        eventRepository.deleteById(id);
    }
}
