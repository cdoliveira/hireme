package com.cdsoftware.hireme.controller;

import com.cdsoftware.hireme.dto.UserDto;
import com.cdsoftware.hireme.entity.User;
import com.cdsoftware.hireme.mapper.UserMapper;
import com.cdsoftware.hireme.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

   private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
        String message;
        try {
            userService.createUser(userDto);
            message = "Success";
        }catch (Exception ex){
            message = ex.getMessage();
        }
       return ResponseEntity.ok(message);
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerWithGoogle(@AuthenticationPrincipal OAuth2User oAuth2User){
        Map<String,Object> objUser = userService.signWithGoogle(oAuth2User);

        Object user = objUser.get("name");
        return ResponseEntity.ok(user.toString());
    }

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok(userService.getAuthUser().toString());
    }
}
