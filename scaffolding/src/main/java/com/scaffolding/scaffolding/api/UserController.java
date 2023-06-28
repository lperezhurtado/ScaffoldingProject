package com.scaffolding.scaffolding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffolding.scaffolding.entities.UserEntity;
import com.scaffolding.scaffolding.entities.beans.ResponseBean;
import com.scaffolding.scaffolding.entities.beans.UserBean;
import com.scaffolding.scaffolding.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

     @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable(value = "id") Long idUser) {
        return new ResponseEntity<UserEntity>(userService.getUser(idUser), HttpStatus.OK);
    }

    // @PostMapping("/create")
    // public ResponseEntity<String> create(@RequestBody UserBean newUser) {
    //     return new ResponseEntity<String>(userService.createUser(newUser), HttpStatus.OK);
    // }

    @PostMapping("/create")
    public ResponseEntity<ResponseBean> create(@RequestBody UserBean newUser) {
        return new ResponseEntity<ResponseBean>(userService.createUser(newUser), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserBean updatedUser) {
        return new ResponseEntity<String>(userService.updateUser(updatedUser), HttpStatus.OK);
    }
}