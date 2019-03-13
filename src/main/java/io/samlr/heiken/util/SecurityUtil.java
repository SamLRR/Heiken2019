package io.samlr.heiken.util;

import io.samlr.heiken.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

    @Autowired
    UserService userService;

    /**
     * method for getting authorized user
     *
     * @return authorized user
     */
    public String getAuthorizedUser() {
        String userName;
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
            return userName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
}
