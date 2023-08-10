package com.system.RawFitness.pojo;

import com.system.RawFitness.Entity.Admin;
import com.system.RawFitness.Entity.Category;
import com.system.RawFitness.Entity.SignUp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPojo {
    private Integer id;
    private Category category_id;
    private SignUp user_id;
    private Admin price_id;


//    public MembershipPojo(Membership membership) {
//        SignUp signUp;
//        this.id= membership.getId();
//        this.category= membership.getCategory();
//        this.duration=membership.getDuration();
//        this.user_id= signUp.getId();
//        this.price_id= Admin.builder().build();
////        signUp.setCategory(membership);
//    }
}
