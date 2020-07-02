package com.byt.zus.service;

import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.repository.UserRepository;
import lombok.var;
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

  public Long loginReturningId(final User user) {

    var userOptional = userRepository.findByName(user.getName());

    if (userOptional.isPresent()) {
      var u = userOptional.get();
      if (u.getPassword().equals(user.getPassword())) {
        return u.getId();
      }
    }
    return -1L;
  }

  public List<User> findAll() {

    return userRepository.findAll();
  }

  public User findById(final long id) {

    return userRepository.findById(id);
  }
}
