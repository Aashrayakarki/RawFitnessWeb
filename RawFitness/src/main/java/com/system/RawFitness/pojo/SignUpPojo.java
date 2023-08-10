package com.system.RawFitness.pojo;

import com.system.RawFitness.Entity.SignUp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpPojo {

    private Integer id;
    private String email;
    private String fullName;
    private String password;

//    private String category;
//    private String duration;


//    private MembershipPojo membership;

    public SignUpPojo(SignUp sign) {
        this.id= sign.getId();
        this.email= sign.getEmail();
        this.fullName= sign.getFullName();
        this.password= sign.getPassword();
//        this.category= String.valueOf(sign.getCategory());
//        this.duration= String.valueOf(sign.getDuration());
    }


}
