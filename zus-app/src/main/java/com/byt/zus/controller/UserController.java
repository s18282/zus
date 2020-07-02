package com.byt.zus.controller;

import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/new")
  public ResponseEntity<?> insertFileReturningId(@RequestParam String name,
                                                 @RequestParam String password) {

    return ResponseEntity.ok(userService.insertIntoReturningId(new User(null, name, password, true, UserStatus.USER)));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestParam String name,
                                    @RequestParam String password) {

    var newUser = new User(null, name, password, true, UserStatus.USER);
    return ResponseEntity.ok(userService.insertIntoReturningId(newUser));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestParam String name,
                                 @RequestParam String password) {

    var userId = userService.loginReturningId(new User(null, name, password, true, UserStatus.USER));
    if (userId > 0) {
      return ResponseEntity.ok(userId);
    } else {
      return ResponseEntity.noContent().build();
    }
  }
}
