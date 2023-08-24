package com.example.redcrosshackthon.domain.user.controller;

import com.example.redcrosshackthon.domain.user.dto.response.UserInfoResDto;
import com.example.redcrosshackthon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/{user_id}")
    public ResponseEntity<UserInfoResDto> getUser(@PathVariable("user_id") Long userId){
        UserInfoResDto userInfoResDto = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userInfoResDto);
    }

}
