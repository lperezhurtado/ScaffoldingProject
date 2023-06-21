package com.scaffolding.scaffolding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffolding.scaffolding.entities.beans.UserBean;
import com.scaffolding.scaffolding.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserBean newUser) {
        return new ResponseEntity<String>(userService.createUser(newUser), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserBean updatedUser) {
        return new ResponseEntity<String>(userService.updateUser(updatedUser), HttpStatus.OK);
    }
}