package com.system.RawFitness.services.impl;

import com.system.RawFitness.Entity.Admin;
import com.system.RawFitness.pojo.AdminPojo;
import com.system.RawFitness.repo.AdminRepo;
import com.system.RawFitness.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepo adminRepo;


    @Override
    public AdminPojo save(AdminPojo adminPojo) {
       Admin admin;
        if (adminPojo.getId() != null) {
            admin = adminRepo.findById(adminPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            admin = new Admin();
        }
        admin.setDuration(adminPojo.getDuration());
        admin.setPrice(adminPojo.getPrice());
        int numAdmins = adminRepo.countAdmins();
        if (numAdmins >= 3) {
            throw new RuntimeException("Cannot add more than 3 admins");
        }

        adminRepo.save(admin);
        return new AdminPojo(admin);


    }

    public Admin fetchById(Integer id) {
        return adminRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public List<Admin> fetchAll() {
        return adminRepo.findAll();
    }


    @Override
    public void deleteById(Integer id) {
        adminRepo.deleteById(id);
    }






}

