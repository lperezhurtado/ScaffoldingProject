package com.scaffolding.scaffolding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaffolding.scaffolding.entities.PasswordEntity;

public interface PasswordRepository extends JpaRepository<PasswordEntity, Long>{

    PasswordEntity findByIdUser(Long idUser);
	Long deleteByIdUser(Long idUser);

    //PasswordEntity findByDni(String dni);

    //boolean existsByDni(String dni);
    
}
