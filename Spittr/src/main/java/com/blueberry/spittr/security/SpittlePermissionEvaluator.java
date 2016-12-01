package com.blueberry.spittr.security;

import com.blueberry.spittr.beans.Spitter;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;

/**
 * Created by Administrator on 11/30/2016.
 */
public class SpittlePermissionEvaluator implements PermissionEvaluator {

    /**
     * usage: @PreFilter("hasPermission(targetObject,'delete)")
     *
     * @param authentication
     * @param target
     * @param permission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {

        if (target instanceof Spitter) {
            String username = ((Spitter) target).getUsername();
            if ("delete".equals(permission)) {
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }
        throw new UnsupportedOperationException("hasPermission not supported for object <" + target
                + "> and permission <" + permission + ">");
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }

    private static final GrantedAuthority ADMIN_AUTHORITY =
            new SimpleGrantedAuthority("ROLE_SPITTER");

    /**
     * 在目标对象的ID可以得到的时候才有用
     *
     * @param authentication
     * @param targetId
     * @param targetType
     * @param permission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException();
    }
}
