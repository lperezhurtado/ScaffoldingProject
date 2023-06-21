package com.scaffolding.scaffolding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.scaffolding.scaffolding.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    boolean existsByName(String name);
	boolean existsByDni(String dni);
	
	UserEntity findByDni(String dni);
}
