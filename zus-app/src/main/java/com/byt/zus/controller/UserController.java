package com.byt.zus.controller;

import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.service.UserService;
import com.byt.zus.service.UserStatusService;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.byt.zus.dao.UserStatus.USER;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final UserStatusService userStatusService;

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

  @GetMapping("/checkUserStatus")
  public ResponseEntity<?> findStatusById(@RequestParam Long id) {

    return ResponseEntity.ok(userStatusService.findStatusById(id));
  }

  @PutMapping("/updateUserStatus")
  public ResponseEntity<?> updateUserStatus(@RequestParam Long loggedUserId,
                                            @RequestParam Long idToUpdate,
                                            @RequestParam UserStatus userStatus) {

    return ResponseEntity.ok(userStatusService.updateUserStatus(loggedUserId, idToUpdate, userStatus));
  }
}
