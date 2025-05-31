package com.toursappbackend.service;

import com.toursappbackend.model.Group;
import com.toursappbackend.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group getById(UUID id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found"));
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public Group update(UUID id, Group group) {
        return groupRepository.findById(id).map(existing -> {
            existing.setName(group.getName());
            existing.setCity(group.getCity());
            existing.setState(group.getState());
            existing.setCountry(group.getCountry());
            return groupRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Group not found"));
    }


    public void delete(UUID id) {
        if (!groupRepository.existsById(id)) {
            throw new RuntimeException("Group not found");
        }
        groupRepository.deleteById(id);
    }

}

