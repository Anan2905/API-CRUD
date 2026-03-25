package com.devteria.identity_service.Service;

import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.dto.request.UserUpdateRequest;
import com.devteria.identity_service.entity.User;
import com.devteria.identity_service.exception.AppException;
import com.devteria.identity_service.exception.ErrorCode;
import com.devteria.identity_service.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public User createUser(UserCreationRequest request){
        User user = new User();
        if (userReponsitory.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFistName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

         return userReponsitory.save(user);
    }

    public User updateUser(String userId ,UserUpdateRequest request){
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFistName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
       return userReponsitory.save(user);

    }

    public void deleteUser(String userId){
        userReponsitory.deleteById(userId);
    }

    public List<User> getUser(){
        return userReponsitory.findAll();
    }

    public User getUser (String id){
        return  userReponsitory.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }
}
