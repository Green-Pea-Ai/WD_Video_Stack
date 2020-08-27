package com.example.demo.mongod.controller;

import com.example.demo.mongod.entity.UserVo;
import com.example.demo.mongod.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:7878", allowedHeaders = "*")
public class UserRestController {

    @Autowired
    private UserService service;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserVo> getUser(@PathVariable String id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserVo>> getUserList() {
        return new ResponseEntity<>(service.getUserList(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserVo userVo) {
        service.saveUser(userVo);
        return new ResponseEntity<>("New user successfully saved", HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody UserVo userVo) {
        service.updateUser(userVo);
        return new ResponseEntity<>("User successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestBody UserVo userVo) {
        service.deleteUser(userVo);

        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }
}
