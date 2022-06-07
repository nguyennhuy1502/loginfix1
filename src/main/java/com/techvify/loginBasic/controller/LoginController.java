package com.techvify.loginBasic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techvify.loginBasic.dto.DepartmentDTO;
import com.techvify.loginBasic.entity.Department;
import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.service.iService.IDepartmentService;
import com.techvify.loginBasic.service.iService.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/home")
    public List<User> findAll() {
       return userService.findAll();
    }

    @GetMapping("/home/{id}")
    public User getUserById(@PathVariable(name = "id") int id) {
        return userService.getUserById(id);
    }

    @GetMapping("")
    public User findByEmailAndPass(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.findByEmailAndPass(username,password);
    }

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

    @GetMapping("/department")
    public List<DepartmentDTO> getAllDepartments() {

        List<Department>entities = service.getAllDepartment();

        // convert entities --> dtos

        List<DepartmentDTO> dtos = modelMapper.map(entities, new TypeToken<List<DepartmentDTO>>(){
        }.getType());
        return dtos;

//        return entities.stream().map(e -> objectMapper.convertValue(e,DepartmentDTO.class)).collect(Collectors.toList());
    }

//
//    @GetMapping("/department")
//    public List<Department> getAllDepartment(){
//
//        return service.getAllDepartment();
//    }
}