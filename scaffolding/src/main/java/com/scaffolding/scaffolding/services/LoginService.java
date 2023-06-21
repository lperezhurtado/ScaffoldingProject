package com.scaffolding.scaffolding.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.PasswordEntity;
import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.LoginBean;
import com.scaffolding.scaffolding.exceptions.ValidationException;
import com.scaffolding.scaffolding.helper.ValidationHelper;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import com.scaffolding.scaffolding.repository.UserRepository;

@Service
public class LoginService {
    
    @Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordRepository passwordRepo;

    public boolean checkCredentials(LoginBean login) {
		ValidationHelper.validateFalseDNI(login.getDni(), "Formato DNI incorrecto");
		
		if (!userRepo.existsByDni(login.getDni())) {
			throw new ValidationException("Dni no existente en la BBDD");
		}
		
		UserEntity user = userRepo.findByDni(login.getDni());
		PasswordEntity userPassword = passwordRepo.findByIdUser(user.getUid());

        return ( user.getDni().equals(login.getDni()) && userPassword.getPassword().equals(login.getPassword()) );
	}
}
