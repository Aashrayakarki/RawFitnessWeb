package com.system.RawFitness.services.impl;

import com.system.RawFitness.Entity.Membership;
import com.system.RawFitness.pojo.MembershipPojo;
import com.system.RawFitness.repo.AdminRepo;
import com.system.RawFitness.repo.CategoryRepo;
import com.system.RawFitness.repo.MembershipRepo;
import com.system.RawFitness.repo.SignUpRepo;
import com.system.RawFitness.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemebershipServiceImpl implements MembershipService {
    private final MembershipRepo membershipRepo;
    private final SignUpRepo signUpRepo;
    private final AdminRepo adminRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public void saveMember(MembershipPojo membershipPojo){
        Membership membership ;
        if (membershipPojo.getId() != null) {
            membership = membershipRepo.findById(membershipPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            membership = new Membership();
        }
        membership.setUser_id(membershipPojo.getUser_id());
        membership.setPrice_id(membershipPojo.getPrice_id());
        membership.setCategory_id(membershipPojo.getCategory_id());
        membershipRepo.save(membership);
    }



    @Override
    public void updateMember(MembershipPojo membershipPojo)throws IOException {
        Membership membership =new Membership();
        if (membershipPojo.getUser_id() != null) {
            membership = membershipRepo.fetchById(membership.getUser_id().getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            membership = new Membership();
        }
        membership.setUser_id(membershipPojo.getUser_id());
        membershipRepo.save(membership);

    }

    @Override
    public void deleteById(Integer id) {
         membershipRepo.deleteById(id);
    }

    @Override
    public void deleteAllBy(Integer id) {
        membershipRepo.deleteAllBy(id);
    }

    @Override
    public Membership fetchById(Integer id) {
        return membershipRepo.fetchById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }


    public List<Membership> fetchAll() {
        return membershipRepo.findAll();
    }
}
