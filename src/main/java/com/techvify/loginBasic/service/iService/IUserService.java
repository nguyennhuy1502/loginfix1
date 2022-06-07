package com.techvify.loginBasic.service.iService;

import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.entity.Department;
import com.techvify.loginBasic.entity.User;

import java.util.List;


public interface IUserService {
    List<User> findAll();


    User findByEmailAndPass(String username, String password);
    User getUserById(int id);

    User deleteById(int id);

    void createUser(User user);

    User loginUser(CreateUserDTO createUserDTO);

}
