package com.scaffolding.scaffolding.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.PasswordEntity;
import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.LoginBean;
import com.scaffolding.scaffolding.entities.beans.NewPasswordBean;
import com.scaffolding.scaffolding.entities.beans.PasswordBean;
import com.scaffolding.scaffolding.exceptions.ValidationException;
import com.scaffolding.scaffolding.helper.ValidationHelper;
import com.scaffolding.scaffolding.repository.PasswordRepository;
import com.scaffolding.scaffolding.repository.UserRepository;

@Service
public class PasswordService {
    
    @Autowired
	PasswordRepository passwordRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    LoginService loginService;

    public String saveIdUserWithPassword(Long id) {
        String password = generateRandomPassword();
        PasswordBean passwordBean = new PasswordBean(id, password);
		passwordRepo.save(passwordBeanToEntity(passwordBean));

        return password;
	}
	
	public PasswordEntity passwordBeanToEntity(PasswordBean passwordBean) {
		PasswordEntity password = new PasswordEntity();
		password.setPassword(passwordBean.getPassword());
		password.setIdUser(passwordBean.getUser());

		return password;
	}

    public String changePassword(NewPasswordBean newPassword) {
        
        checkIfDataIsCorrect(newPassword);
        ValidationHelper.validatePassword(newPassword.getNewPassword());

        UserEntity user = userRepo.findByDni(newPassword.getDni());

        PasswordEntity newPasswordEntity = passwordRepo.findByIdUser(user.getUid());
        newPasswordEntity.setPassword(newPassword.getNewPassword());

        return "Contraseña cambiada a "+passwordRepo.save(newPasswordEntity).getPassword();
    }
	
	public Long deletepassword(Long id) {
		return passwordRepo.deleteByIdUser(id);
	}
	
    public String generateRandomPassword() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public void checkIfDataIsCorrect(NewPasswordBean newPassword) {
        LoginBean userCheck = new LoginBean(newPassword.getDni(), newPassword.getActualPassword());

        if (!loginService.checkCredentials(userCheck)) {
            throw new ValidationException("Los datos no coiciden");
        }
    }
}
