package com.system.RawFitness.controller;

import com.system.RawFitness.Entity.SignUp;
import com.system.RawFitness.pojo.SignUpPojo;
import com.system.RawFitness.repo.MembershipRepo;
import com.system.RawFitness.services.MembershipService;
import com.system.RawFitness.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class LoginController {
    private final SignUpService signUpService;
    private final MembershipService membershipService;
    private final MembershipRepo membershipRepo;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            model.addAttribute("signup", new SignUpPojo());
            return "User/Login";
        }
        return "redirect:/homepage";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication){
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.clearContext();
        }
        return "User/Login";
    }

    @GetMapping("/homepage")
    public  String getHome(Model model, Principal principal,Authentication authentication) throws IOException {
        if (authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                if (grantedAuthority.getAuthority().equals("Admin")) {
                    return "redirect:/admin/list";
                }
            }
        }
        String email = principal.getName();
        SignUp user = signUpService.fetchByEmail(email);
//        Membership membership=membershipService.fetchById(user.getId());

//            MembershipPojo membershipPojo=new MembershipPojo();
//            membershipPojo.setUser_id(user);
//            membershipService.saveMember(membershipPojo);



        model.addAttribute("user",user);
        return "User/gg";
    }




}