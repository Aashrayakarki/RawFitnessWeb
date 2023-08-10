package com.system.RawFitness.repo;

import com.system.RawFitness.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
//    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
//    Optional<SignUp> findByEmail(String email);
    @Query("SELECT COUNT(a) FROM Admin a")
    int countAdmins();
}