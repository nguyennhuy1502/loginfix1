package com.techvify.loginBasic.service;

import com.techvify.loginBasic.entity.Department;
import com.techvify.loginBasic.repository.IDepartmentRepository;
import com.techvify.loginBasic.service.iService.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartment() {
        return repository.findAll();
    }
}
