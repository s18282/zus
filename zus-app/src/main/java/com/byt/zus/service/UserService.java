package com.byt.zus.service;

import com.balaur.zus.dao.tables.pojos.User;
import com.byt.zus.repository.UserRepository;

import java.util.List;

public class UserService {

  final UserRepository userRepository;

  public UserService(final UserRepository userRepository) {

    this.userRepository = userRepository;
  }

  public Long insertIntoReturningId(final User user) {

    return userRepository.insertIntoReturningId(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }
}
