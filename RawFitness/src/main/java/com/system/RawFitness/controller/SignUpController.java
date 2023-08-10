package com.system.RawFitness.controller;

import com.system.RawFitness.Entity.Admin;
import com.system.RawFitness.Entity.Category;
import com.system.RawFitness.Entity.Membership;
import com.system.RawFitness.Entity.SignUp;
import com.system.RawFitness.pojo.MembershipPojo;
import com.system.RawFitness.pojo.SignUpPojo;
import com.system.RawFitness.repo.MembershipRepo;
import com.system.RawFitness.services.AdminService;
import com.system.RawFitness.services.CategoryService;
import com.system.RawFitness.services.MembershipService;
import com.system.RawFitness.services.SignUpService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")

public class SignUpController {

    private final SignUpService signUpService;
    private final MembershipService membershipService;
    private final CategoryService categoryService;
    private final AdminService adminService;
    private final MembershipRepo membershipRepo;


    @GetMapping("/signup")
    public String createUser(Model model){

        model.addAttribute("signup", new SignUpPojo());
        return "User/signup";
    }
    @PostMapping("/save" )
    public String saveUser(@Valid SignUpPojo signUpPojo)throws IOException {

        signUpService.saveUser(signUpPojo);

//        membershipService.saveMember(membershipPojo);
        return "redirect:/login";
    }

    @PostMapping("/update")
    public String updateUser(@Valid SignUpPojo signUpPojo)throws IOException {
        signUpService.updateUser(signUpPojo);
        return "redirect:/homepage";
    }
    @PostMapping("/updateMember")
    public String updateMember(@Valid MembershipPojo membershipPojo )throws IOException {
        membershipService.saveMember(membershipPojo);
        return "redirect:/homepage";
    }



    @GetMapping("/list/{id}")
    public String getUserDetails(@PathVariable("id") Integer id,Model model){
        SignUp signUp =signUpService.fetchById(id);
        Membership membership =membershipService.fetchById(id);
        List<Category> categories=categoryService.fetchAll();
        List<Admin>admins=adminService.fetchAll();

        model.addAttribute("categories",categories);
        model.addAttribute("duration",admins);


        model.addAttribute("memberUpdate",new MembershipPojo());
        model.addAttribute("update", new SignUpPojo(signUp));

        model.addAttribute("userList",signUp);
        model.addAttribute("members", membership);

        model.addAttribute("tab1Active", true);
        model.addAttribute("tab2Active", false);


        return "User/profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable ("id") Integer id) throws IOException {
//        MembershipPojo membershipPojo=new MembershipPojo();
//        membershipPojo.setUser_id(null);
//        membershipPojo.setPrice_id(null);
//        membershipPojo.setCategory_id(null);
        membershipService.deleteById(id);
        return "redirect:/homepage";
    }
    @GetMapping("/deleteAccount/{id}")
    public String deleteAcc(@PathVariable ("id") Integer id) throws IOException {
//        MembershipPojo membershipPojo=new MembershipPojo();
//        membershipPojo.setUser_id(null);
//        membershipPojo.setPrice_id(null);
//        membershipPojo.setCategory_id(null);
        signUpService.deleteById(id);
        membershipService.deleteById(id);
        return "redirect:/homepage";
    }



}
