package com.byt.zus.controller;

import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(final UserService userService) {

    this.userService = userService;
  }

  @PostMapping("/new")
  public ResponseEntity<?> insertFileReturningId(@RequestParam String name,
                                                 @RequestParam String password) {

    return ResponseEntity.ok(userService.insertIntoReturningId(new User(null, name, password, true)));
  }
}
