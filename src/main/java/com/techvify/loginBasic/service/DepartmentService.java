package com.techvify.loginBasic.service;

import com.techvify.loginBasic.dto.CreateDepartmentDTO;
import com.techvify.loginBasic.entity.Department;
import com.techvify.loginBasic.repository.IDepartmentRepository;
import com.techvify.loginBasic.service.iService.IDepartmentService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> getAllDepartment() {
        return repository.findAll();
    }

    @Override
    public List<Department> getIdDepartment(int id) {
        return Collections.singletonList(repository.findById(id).get());
    }

    @Override
    public Department getByIdDepartment(int id) {
        Optional<Department> result = repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Error");
        }

//		Post post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return post;
    }

    @Override
    public Department createDepartment(Department department) {
        return repository.save(department);
    }

//    @Override
//    public void deleteById(int id) {
//        Department department = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Department","id",id));
//        repository.delete(department);
//    }

}
