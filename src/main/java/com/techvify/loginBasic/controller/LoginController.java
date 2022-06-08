package com.techvify.loginBasic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techvify.loginBasic.dto.UpdateUser;
import com.techvify.loginBasic.dto.UserDTO;
import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.service.iService.IDepartmentService;
import com.techvify.loginBasic.service.iService.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/home")
    public List<UserDTO> findAll() {
        return userService.findAll().stream().map(post -> modelMapper.map(post, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") int id) {
        User user = userService.getUserById(id);
        UserDTO userResponse = modelMapper.map(user, UserDTO.class);
        return ResponseEntity.ok().body(userResponse);
    }

//    @GetMapping("")
//    public User findByEmailAndPass(@PathVariable("username") String username, @PathVariable("password") String password){
//        return userService.findByEmailAndPass(username,password);
//    }

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDTO form) {
        userService.createUser(form.toEntity());
    }

    @PostMapping("")
    public User loginUser(@RequestBody CreateUserDTO createUserDTO){
        return userService.loginUser(createUserDTO);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteById(@PathVariable(name = "id") int id) {
        return userService.deleteById(id);
    }

//    @GetMapping("/department")
//    public List<Department> getAllDepartment(){
//
//        return service.getAllDepartment();
//    }
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable(name = "id") int id, @RequestBody UpdateUser updateUser){
//        User userRequest = modelMapper.map(updateUser, User.class);
//        User user = userService.updateUser(id, userRequest);
//
//
//        UpdateUser userDTO = modelMapper.map(user, UpdateUser.class);
//
//
//        return ResponseEntity.ok().body(userDTO);

      return userService.updateUser(id,updateUser);

    }
}