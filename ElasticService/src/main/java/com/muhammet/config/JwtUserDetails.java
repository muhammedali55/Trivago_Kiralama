package com.muhammet.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetails implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    /**
     * 1- Sistemde kayıtlı kullanıcıların listesinden kullanıcının bilgilerini droğrulanır
     * 2- Bu kullanıcıya ait yetkiler var ise bu yetkiler çekilir.
     * 3- Spring için UserDetails nesnesi oluşturulur.
     * @param authId
     * @return
     */
    public UserDetails findByAuthId(Long authId){

        return User.builder()
                .username("muhammet")
                .authorities(List.of(new SimpleGrantedAuthority("Admin")))
                .password("")
                .accountExpired(false)
                .accountLocked(false)
                .build();
    }
}
