package com.pnfe.dashboard.service;

import com.pnfe.dashboard.dto.UserInfo;
import com.pnfe.dashboard.entity.UserEntity;
import com.pnfe.dashboard.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public UserInfo retrieveUserInfo (String userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        UserInfo userInfo = new UserInfo();
        if (userEntity.isPresent()) {
            userInfo.setProfileType(userEntity.get().getProfileType());
            userInfo.setFullName(userEntity.get().getFullName());
        } else {
            userInfo = null;
        }
        return userInfo;
    }
}
