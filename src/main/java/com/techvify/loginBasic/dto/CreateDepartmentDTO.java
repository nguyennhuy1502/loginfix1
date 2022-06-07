package com.techvify.loginBasic.dto;

import com.techvify.loginBasic.entity.Department;

public class CreateDepartmentDTO {
   private String name;

   public Department create(){
       return new Department(name);
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
