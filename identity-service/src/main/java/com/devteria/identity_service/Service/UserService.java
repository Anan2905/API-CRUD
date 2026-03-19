package com.devteria.identity_service.Service;

import com.devteria.identity_service.dto.request.UserCreationRequest;
import com.devteria.identity_service.entity.User;
import com.devteria.identity_service.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public User creatUser(UserCreationRequest request){
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFistName(request.getFistName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

         return userReponsitory.save(user);
    }
}
