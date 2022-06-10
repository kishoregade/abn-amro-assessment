package com.abn.amro.recipe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abn.amro.recipe.model.User;

public interface UserRepository extends JpaRepository<User, String>{
    Optional<User> findByUserName(String username);

}
