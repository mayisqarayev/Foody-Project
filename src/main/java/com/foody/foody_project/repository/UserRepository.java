package com.foody.foody_project.repository;

import com.foody.foody_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Transactional
    @Modifying
    @Query("""
        update User u
        set u.fullName = ?1, u.email = ?2, u.photo = ?3, u.photo = ?4 where u.id = ?5
    """)
    void updateProfile(String fullName, String email, String photo, String phone, String id);

    User findUserByUsername(String username);
}
