package com.scaffolding.scaffolding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaffolding.scaffolding.entities.beans.LoginBean;
import com.scaffolding.scaffolding.services.LoginService;

@RestController
@RequestMapping("/login")
public class loginController {
    @Autowired
    LoginService loginService;
    
    @PostMapping("")
    public ResponseEntity<Boolean> login (@RequestBody LoginBean login) {
        return new ResponseEntity<Boolean>(loginService.checkCredentials(login), HttpStatus.OK);
    }
}
