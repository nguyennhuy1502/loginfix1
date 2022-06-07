package com.techvify.loginBasic.repository;

import com.techvify.loginBasic.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
