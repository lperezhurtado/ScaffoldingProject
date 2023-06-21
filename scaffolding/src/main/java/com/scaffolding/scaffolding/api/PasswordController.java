package com.scaffolding.scaffolding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffolding.scaffolding.entities.beans.NewPasswordBean;
import com.scaffolding.scaffolding.services.PasswordService;

@RestController
@RequestMapping("/password")
public class PasswordController {
    
    @Autowired
    PasswordService passwordService;

    @PutMapping("/change")
	public ResponseEntity<String> changePassword(@RequestBody NewPasswordBean newPassword) {
		return new ResponseEntity<String>(passwordService.changePassword(newPassword), HttpStatus.OK);
	}
}