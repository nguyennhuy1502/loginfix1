package com.techvify.loginBasic.controller;

import com.techvify.loginBasic.dto.CreateDepartmentDTO;
import com.techvify.loginBasic.dto.DepartmentDTO;
import com.techvify.loginBasic.entity.Department;
import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.service.iService.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public List<DepartmentDTO> getAllDepartments() {

//        List<Department>entities = service.getAllDepartment();
//
//        // convert entities --> dtos
//
//        List<DepartmentDTO> dtos = modelMapper.map(entities, new TypeToken<List<DepartmentDTO>>(){
//        }.getType());
//        return dtos;
        return service.getAllDepartment().stream().map(post -> modelMapper.map(post, DepartmentDTO.class))
                .collect(Collectors.toList());

//        return entities.stream().map(e -> objectMapper.convertValue(e,DepartmentDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/all/{id}")
//    public List<DepartmentDTO> getIdDepartment()
    public ResponseEntity<DepartmentDTO> getIdDepartment(@PathVariable(name = "id") int id) {
//        List<Department>departments = service.getIdDepartment(id);
//        List<DepartmentDTO> dtoss = modelMapper.map(departments, new TypeToken<List<DepartmentDTO>>(){
//        }.getType());
//        return dtoss;
        Department department = service.getByIdDepartment(id);
        DepartmentDTO postResponse = modelMapper.map(department, DepartmentDTO.class);
        return ResponseEntity.ok().body(postResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<CreateDepartmentDTO> createDepartment(@RequestBody CreateDepartmentDTO createDepartmentDTO ){
        Department departmentRequest = modelMapper.map(createDepartmentDTO, Department.class);
        Department department = service.createDepartment(departmentRequest);

        CreateDepartmentDTO departmentResponse = modelMapper.map(department, CreateDepartmentDTO.class);
        return new ResponseEntity<CreateDepartmentDTO>(departmentResponse, HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ApiResponse>
}
