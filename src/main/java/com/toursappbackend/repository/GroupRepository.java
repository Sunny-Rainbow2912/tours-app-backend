package com.toursappbackend.repository;



import com.toursappbackend.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    // Example of a custom method (optional)
    boolean existsByName(String name);

    Group findByName(String name);
}
