package com.system.RawFitness.controller;

import com.system.RawFitness.Entity.Admin;
import com.system.RawFitness.Entity.Category;
import com.system.RawFitness.Entity.Membership;
import com.system.RawFitness.Entity.SignUp;
import com.system.RawFitness.pojo.AdminPojo;
import com.system.RawFitness.services.AdminService;
import com.system.RawFitness.services.CategoryService;
import com.system.RawFitness.services.MembershipService;
import com.system.RawFitness.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CategoryService categoryService;
    private final SignUpService signUpService;

    private final AdminService adminService;
    private final MembershipService membershipService;
    @GetMapping("/list")
    public String getUSerList(Model model) {

        List<Membership> memberships = membershipService.fetchAll();

        model.addAttribute("members", memberships.stream().map(membership -> {
            Category category = categoryService.fetchById(membership.getCategory_id().getId());
            Admin admin = adminService.fetchById(membership.getPrice_id().getId());
            SignUp user = signUpService.fetchById(membership.getUser_id().getId());

            return Membership.builder()
                    .id(membership.getId())
                    .category_id(membership.getCategory_id())
                    .price_id(membership.getPrice_id())
                    .user_id(membership.getUser_id())
                    .category_id(category)
                    .price_id(admin)
                    .user_id(user)
                    .build();
        }).collect(Collectors.toList()));

        return "User/user_list";
    }

    @GetMapping("/price")
    public String getPricePage(Model model){
//        model.addAttribute("priceTab",new Admin());
        List<Admin> admins = adminService.fetchAll();


        model.addAttribute("priceTable", admins.stream().map(admin ->
                Admin.builder()
                        .id(admin.getId())
                        .duration(admin.getDuration())
                        .price(admin.getPrice())
                        .build()

        ));
        return "User/price";
    }
    @PostMapping("/savePrice")
    public String addPrice(@Valid AdminPojo adminPojo )throws IOException {
        adminService.save(adminPojo);
        return "redirect:/admin/price";
    }

    @GetMapping("/create")
    public String editPrice(Model model) {

        model.addAttribute("price",new AdminPojo());
        return "User/create";
    }
    @GetMapping("/edit/{id}")
    public String getPrice(@PathVariable("id") Integer id,Model model){
        Admin admin = adminService.fetchById(id);
        model.addAttribute("price",admin);
        return "User/create";
    }


    @GetMapping("/{id}")
    public String deletePrice(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Membership membership=new Membership();
        membership.setPrice_id(null);
//        membershipService.deleteById(id);
        adminService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/admin/price";
    }
}
