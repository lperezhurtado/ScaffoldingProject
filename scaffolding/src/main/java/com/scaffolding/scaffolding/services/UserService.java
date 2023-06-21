package com.scaffolding.scaffolding.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.UserBean;
import com.scaffolding.scaffolding.exceptions.ValidationException;
import com.scaffolding.scaffolding.helper.ValidationHelper;
import com.scaffolding.scaffolding.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordService passwordService;

    public void validateID(Long id) {
        if (!userRepo.existsById(id)) {
            throw new ValidationException("No existe usuario con id  " + id);
        }
    }

    public void validate(UserBean userEntity) {
        ValidationHelper.validateFalseDNI(userEntity.getDni(), " DNI no válido");
        ValidationHelper.validateStringLength(userEntity.getName(), 2, 30, "campo nombre de Usuario (el campo debe tener longitud de 2 a 30 caracteres)");
        ValidationHelper.validateStringLength(userEntity.getLastName(), 2, 30, "campo primer apellido de Usuario (el campo debe tener longitud de 2 a 30 caracteres)");
        ValidationHelper.validateEmail(userEntity.getEmail(), " Email de Usuario no válido");
        ValidationHelper.isNumeric(Integer.toString(userEntity.getPostalCode()));
    }

    @Transactional
    public String createUser(UserBean newUser) {

        validate(newUser);
        checkIfDniExist(newUser.getDni());
        Long id = userRepo.save(userBeanToEntity(newUser)).getUid();

        return passwordService.saveIdUserWithPassword(id);
    }

    @Transactional
    public String deleteUser(Long id) {
        validateID(id);
        userRepo.deleteById(id);
        passwordService.deletepassword(id);
        return "Se ha eliminado el usuario con id "+id;
    }

    public String updateUser(UserBean updateUser) {
        validateID(updateUser.getUid());
        validate(updateUser);
        UserEntity updatedUser = userRepo.getReferenceById(updateUser.getUid());
        updatedUser = userBeanToEntity(updateUser);
        updatedUser.setUid(updateUser.getUid());
        userRepo.save(updatedUser);
        return "Se ha actualizado la información";
    }

    

    public UserEntity userBeanToEntity(UserBean userBean) {
        UserEntity user = new UserEntity();
        user.setName(userBean.getName());
        user.setLastName(userBean.getLastName());
        user.setDni(userBean.getDni());
        user.setBirth(userBean.getBirth());
        user.setAdress(userBean.getAdress());
        user.setPostalCode(userBean.getPostalCode());
        user.setEmail(userBean.getEmail());

        return user;
    }

    public boolean checkIfDniExist(String dni) {
        return userRepo.existsByDni(dni);
    }

    public UserEntity getByDni(String dni) {
        if (!checkIfDniExist(dni)) {
            throw new ValidationException("No existe usuario con dni  " + dni);
        }
        return userRepo.findByDni(dni);
    }

}
