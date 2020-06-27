package com.byt.zus.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class User {

    private String username;
    private String password;
    private boolean activated;
    private Collection<UserRole> roles;

}
