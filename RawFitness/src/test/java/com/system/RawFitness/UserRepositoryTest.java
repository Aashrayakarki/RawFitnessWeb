package com.system.RawFitness;

import com.system.RawFitness.Entity.SignUp;
import com.system.RawFitness.repo.SignUpRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private SignUpRepo signUpRepo;


    @Test
    @Order(1)
    public void saveUserTest() {

//        User User = new User();
//        User.setFullname("rak");

        SignUp user = SignUp.builder()
                .fullName("saharsha")
                .email("a@g.com")
                .password("1234")
                .build();


        signUpRepo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest() {

        SignUp user = SignUp.builder()
                .fullName("saharsha")
                .email("a@g.com")
                .password("1234")
                .build();


        signUpRepo.save(user);


        SignUp userCreated = signUpRepo.findById(user.getId()).get();
        Assertions.assertThat(userCreated.getId()).isEqualTo(user.getId());

    }

    @Test
    @Order(3)
    public void getListOfUserTest(){
        SignUp user = SignUp.builder()
                .fullName("saharsha")
                .email("a@g.com")
                .password("1234")
                .build();


        signUpRepo.save(user);
        List<SignUp> User = signUpRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }


    @Test
    @Order(4)
    public void updateUserTest(){

        SignUp user = SignUp.builder()
                .fullName("rak")
                .email("a@g.com")
                .password("1234")
                .build();


        signUpRepo.save(user);

        SignUp user1  = signUpRepo.findById(user.getId()).get();

        user1.setFullName("new name");

        SignUp userUpdated  = signUpRepo.save(user);

        Assertions.assertThat(userUpdated.getFullName()).isEqualTo("new name");

    }

    @Test
    @Order(5)
    public void deleteUserTest(){

        SignUp user = SignUp.builder()
                .fullName("rak")
                .email("a@g.com")
                .password("1234")
                .build();


        signUpRepo.save(user);

//        @Query(value = "SELECT * from")

        SignUp user1 = signUpRepo.findById(user.getId()).get();
//        User user1 = userRepo.findById(user.getId()).get();
        signUpRepo.delete(user1);

        SignUp user2 = null;
        Optional<SignUp> optionalUser = signUpRepo.findByEmail("a@g.com");
        if(optionalUser.isPresent()){
            user2 = optionalUser.get();
        }

        Assertions.assertThat(user2).isNull();
//        Assertions.assertThat(User1.getId()).isNull();
    }
}