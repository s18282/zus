package com.byt.zus.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtils {

    public static String getCurrentUserUsername() {

        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();
    }
}
