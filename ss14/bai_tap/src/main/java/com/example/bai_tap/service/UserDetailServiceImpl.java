package com.example.bai_tap.service;

import com.example.bai_tap.model.AppUser;
import com.example.bai_tap.model.UserRole;
import com.example.bai_tap.repository.IUserRoleRepository;
import com.example.bai_tap.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

        @Autowired
        private IAppUserRepository appUserRepository;

        @Autowired
        private IUserRoleRepository appRoleRepository;

        @Override
        public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            AppUser appUser = appUserRepository.findByUserNameContaining(userName);

            if (appUser == null) {
                System.out.println("User not found! " + userName);
                throw new UsernameNotFoundException("User " + userName + " was not found in the database");
            }

            System.out.println("Found User: " + appUser);

            // [ROLE_USER, ROLE_ADMIN,..]
                List<UserRole> roleNames =appRoleRepository.findByAppUser(appUser);

            List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
            if (roleNames != null) {
                for (UserRole role : roleNames) {
                    // ROLE_USER, ROLE_ADMIN,..
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getAppRole().getRoleName());
                    grantList.add(authority);
                }
            }

            UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                    appUser.getEncrytedPassword(), grantList);

            return userDetails;
        }
}
