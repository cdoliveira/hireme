package com.cdsoftware.hireme.service.impl;

import com.cdsoftware.hireme.dto.UserDto;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.mapper.UserMapper;
import com.cdsoftware.hireme.repository.UserRepository;
import com.cdsoftware.hireme.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

import static com.cdsoftware.hireme.mapper.UserMapper.USER_MAPPER;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(UserDto userDto) {
        String message;
        try {
            userRepository.save(USER_MAPPER.DtoToUser(userDto));
            message = "User Inserted";
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        return message;
    }

    @Override
    public Map<String, Object> signWithGoogle(OAuth2User OatOAuth2User) {


        return Collections.singletonMap("name", OatOAuth2User.getAttribute("name"));
    }

    public UserDto getAuthUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        UserDto userDTO = UserMapper.USER_MAPPER.userToUserDto(user);
        return userDTO;
    }
}
