package com.system.RawFitness.services;

import com.system.RawFitness.Entity.Admin;
import com.system.RawFitness.pojo.AdminPojo;

import java.util.List;


public interface AdminService {
    AdminPojo save(AdminPojo adminPojo) ;

    List<Admin> fetchAll();
    Admin fetchById(Integer id);



    void deleteById(Integer id);


}
