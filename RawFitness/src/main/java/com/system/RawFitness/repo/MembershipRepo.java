package com.system.RawFitness.repo;

import com.system.RawFitness.Entity.Membership;
import com.system.RawFitness.Entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, Integer> {

//    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
//    Optional<Membership> fetchById(Integer userId);
//

    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
    Optional<Membership> fetchById(Integer Id);

    @Query(value = "DELETE FROM membership WHERE user_id = ?1", nativeQuery = true)
    Optional<Membership> deleteAllBy(Integer Id);

    @Query(value = "DELETE FROM membership WHERE id = ?1", nativeQuery = true)
    Optional<Membership> deleteBYId(SignUp Id);

    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Membership>> fetchAll(Integer userId);

//    @Query(value = "UPDATE * FROM membership WHERE user_id = ?1", nativeQuery = true)
//    Optional<Membership> update(Integer userId);



    void deleteById(Integer id);


//    @Query(value = "SELECT * FROM signup WHERE user_id = ?1", nativeQuery = true)
//    Optional<List<Membership>> fetchAll(Integer userId);

}
