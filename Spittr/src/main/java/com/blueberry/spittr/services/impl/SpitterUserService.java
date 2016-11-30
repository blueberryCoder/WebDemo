package com.blueberry.spittr.services.impl;

import com.blueberry.spittr.beans.Spitter;
import com.blueberry.spittr.dao.SpitterRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11/23/2016.
 */
public class SpitterUserService implements UserDetailsService {

    private final SpitterRepository spitterRepository;

    public SpitterUserService(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter != null) {
            List<GrantedAuthority> authorityList
                    = new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(username, spitter.getPassword(), authorityList);
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
