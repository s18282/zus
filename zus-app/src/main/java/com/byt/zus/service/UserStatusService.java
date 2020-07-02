package com.byt.zus.service;

import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.repository.UserRepository;
import com.mysql.cj.exceptions.WrongArgumentException;

public class UserStatusService {

  final UserRepository userRepository;

  public UserStatusService(final UserRepository userRepository) {

    this.userRepository = userRepository;
  }

  public UserStatus findStatusById(final Long id) {

    return this.userRepository.findStatusById(id);
  }

  public User updateUserStatus(final Long loggedUserId,
                               final Long idToUpdate,
                               final UserStatus userStatus) {

    if (findStatusById(loggedUserId).equals(UserStatus.ADMIN)) {
      userRepository.updateUserStatus(idToUpdate, userStatus);
      return userRepository.findById(idToUpdate);
    }
    throw new WrongArgumentException("wrong loggedUserId");
  }
}
