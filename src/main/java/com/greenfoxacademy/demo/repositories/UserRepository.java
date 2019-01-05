package com.greenfoxacademy.demo.repositories;

import com.greenfoxacademy.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    void deleteUserByAgeIsLessThan(int age);
    User getByName(String name);
}
