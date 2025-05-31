package com.toursappbackend.controller;

import com.toursappbackend.model.Group;
import com.toursappbackend.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable UUID id) {
        return groupService.getById(id);
    }

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping("/{id}")
    public Group updateGroup(@PathVariable UUID id, @RequestBody Group group) {
      return groupService.update(id, group);
    }
    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable UUID id) {
        groupService.delete(id);
    }
}
