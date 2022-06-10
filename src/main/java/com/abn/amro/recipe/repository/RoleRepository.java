package com.abn.amro.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abn.amro.recipe.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
