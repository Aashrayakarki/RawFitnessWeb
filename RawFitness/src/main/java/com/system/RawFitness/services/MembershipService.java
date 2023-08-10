package com.system.RawFitness.services;

import com.system.RawFitness.Entity.Membership;
import com.system.RawFitness.pojo.MembershipPojo;

import java.io.IOException;
import java.util.List;

public interface MembershipService {
    void saveMember( MembershipPojo membershipPojo)throws IOException;

    void updateMember(MembershipPojo membershipPojo)throws IOException;

    void deleteById(Integer id);

    void deleteAllBy(Integer id);

    Membership fetchById(Integer id);

    List<Membership> fetchAll();


}
