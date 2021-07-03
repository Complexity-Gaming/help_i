package com.complexity.gaming.help_i.security.application;

import com.complexity.gaming.help_i.security.domain.model.Person;
import com.complexity.gaming.help_i.security.domain.model.Player;
import com.complexity.gaming.help_i.security.domain.repository.ExpertRepository;
import com.complexity.gaming.help_i.security.domain.repository.PlayerRepository;
import com.complexity.gaming.help_i.security.domain.service.DefaultUserDetailsService;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements DefaultUserDetailsService {
    private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = new ArrayList<>();

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ExpertRepository expertRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var player = playerRepository.findByEmail(username);
        if (player.isPresent())
            return new User(player.get().getEmail(), player.get().getPassword(), DEFAULT_AUTHORITIES);
        var expert = expertRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found with email:" + username));
        return new User(expert.getEmail(), expert.getPassword(), DEFAULT_AUTHORITIES);
    }
}
