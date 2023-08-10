package com.system.RawFitness.services.impl;

import com.system.RawFitness.Entity.SignUp;

import com.system.RawFitness.config.PasswordEncoderUtil;
import com.system.RawFitness.exception.AppException;
import com.system.RawFitness.pojo.SignUpPojo;
import com.system.RawFitness.repo.SignUpRepo;
import com.system.RawFitness.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final SignUpRepo signUpRepo;
    @Override
    public SignUpPojo saveUser(SignUpPojo signUpPojo) throws IOException {
        SignUp signUp;
        if (signUpPojo.getId() != null) {
            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            signUp = new SignUp();
        }
        signUp.setEmail(signUpPojo.getEmail());
        signUp.setFullName(signUpPojo.getFullName());
        signUp.setPassword(PasswordEncoderUtil.getInstance().encode(signUpPojo.getPassword()));

        signUpRepo.save(signUp);
        return new SignUpPojo(signUp);


    }
    @Override
    public SignUpPojo updateUser(SignUpPojo signUpPojo) throws IOException {
        SignUp signUp;

        if (signUpPojo.getId() != null) {
            signUp = signUpRepo.findById(signUpPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            signUp = new SignUp();
        }
        signUp.setEmail(signUpPojo.getEmail());
        signUp.setFullName(signUpPojo.getFullName());

        signUpRepo.save(signUp);
        return new SignUpPojo(signUp);

    }




    @Override
    public SignUp fetchByEmail(String email) {
        SignUp signUp = signUpRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));

        //builder

        return signUp;
    }

    @Override
    public SignUp fetchById(Integer id) {
        return signUpRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void deleteById(Integer id) {
        signUpRepo.deleteById(id);
    }



    @Override
    public List<SignUp> fetchAll() {
        return signUpRepo.findAll();
    }
}
