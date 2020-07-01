package com.byt.zus.service;

import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
