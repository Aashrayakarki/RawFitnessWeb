//package com.system.RawFitness;
//
//import com.system.RawFitness.Entity.SignUp;
//import com.system.RawFitness.repo.SignUpRepo;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.core.annotation.Order;
//
//import java.util.List;
//import java.util.Optional;
//
//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class customerrepoTest {
//    @Autowired
//    private SignUpRepo signUpRepo;
//
//    @Test
//    @Order(1)
//    public void saveCustomerTest(){
//        SignUp sign = SignUp.builder()
//        .fullName("saaa").build();
//        signUpRepo.save(sign);
//        Assertions.assertThat(sign.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    @Order(2)
//    public void getCustomertest(){
//        SignUp sign = signUpRepo.findById(1).get();
//        Assertions.assertThat(sign.getId()).isEqualTo(0);
//    }
//
//    @Test
//    @Order(3)
//    public void getListOfCustomerTest(){
//        List<SignUp> sign =signUpRepo.findAll();
//        Assertions.assertThat(SignUp.size()).isGreaterThan(0);
//    }
//
//    @Test
//    @Order(4)
//    public void deleteCustomerTest() {
//        SignUp sign = signUpRepo.findById(1).get();
//        signUpRepo.delete((sign));
//        SignUp signUp = null;
//        Optional<SignUp>optionalSignUp = signUpRepo.findByEmail("sa@g.com");
//        Assertions.assertThat(sign.getId()).isNotEqualTo(1);
//    }
//}
