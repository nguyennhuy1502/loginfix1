package com.techvify.loginBasic.service.iService;

import com.techvify.loginBasic.dto.CreateDepartmentDTO;
import com.techvify.loginBasic.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartment();

    List<Department> getIdDepartment(int id);

    Department getByIdDepartment(int id);

    Department createDepartment(Department department);

//    void deleteById(int id);
}
