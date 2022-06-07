package com.techvify.loginBasic.service;

import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.dto.UserDTO;
import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.repository.IUserRepository;
import com.techvify.loginBasic.service.iService.IUserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }


    @Override
    public User findByEmailAndPass(String username, String password) {
        return iUserRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(int id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public User deleteById(int id) {
        iUserRepository.deleteById(id);
        return null;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        if (user.getUsername() != null && user.getPassword() != null) {
            if (user.getUsername().length() >= 6 && user.getPassword().length() >= 8) {
                String pass = user.getPassword();
                String base64 = Base64.getEncoder().encodeToString(pass.getBytes());
                user.setPassword(base64);
                iUserRepository.save(user);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Not Found");
            }
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }

    @Override
    public User loginUser(@RequestBody CreateUserDTO createUserDTO) {
        String pass = createUserDTO.getPassword();
        String base64 = Base64.getEncoder().encodeToString(pass.getBytes());
        User user = iUserRepository.findByUsernameAndPassword(createUserDTO.getUsername(), base64);

        String passs = createUserDTO.getPassword();
        if (passs != null) {
            return user;
        }
        return null;
    }

}
