package com.system.RawFitness.services.impl;

import com.system.RawFitness.repo.SignUpRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetailsService {
    private final SignUpRepo signUpRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.signUpRepo.findByEmail(username).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }
}
