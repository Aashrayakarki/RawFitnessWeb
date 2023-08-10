package com.system.RawFitness.repo;

import com.system.RawFitness.Entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepo extends JpaRepository<SignUp, Integer> {
    @Query(value = "SELECT * FROM signup WHERE email = ?1", nativeQuery = true)
    Optional<SignUp> findByEmail(String email);

    @Query(value = "UPDATE * FROM signup WHERE email = ?1", nativeQuery = true)
    Optional<SignUp> UpdateByEmail(String email);

}
