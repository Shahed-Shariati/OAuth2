package com.example.springrest.controller;


import com.example.springrest.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class UserController {


    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        if(bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        System.out.println("save " + userDTO.getLastName());
        userDTO.setId(1);
        return ResponseEntity.ok(userDTO);
    }


    @PostMapping("/callback")
    public ResponseEntity<UserDTO> callb(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) throws MethodArgumentNotValidException {
        if(bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        System.out.println("save " + userDTO.getLastName());
        userDTO.setId(1);
        return ResponseEntity.ok(userDTO);
    }
}
