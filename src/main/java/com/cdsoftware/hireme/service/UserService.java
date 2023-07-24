package com.cdsoftware.hireme.service;

import com.cdsoftware.hireme.dto.UserDto;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public interface UserService {

    public String createUser(UserDto userDto);

    public Map<String,Object> signWithGoogle(OAuth2User OatOAuth2User);




}
