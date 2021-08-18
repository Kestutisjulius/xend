package com.javavilnius10.reposirory;

import com.javavilnius10.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    void deleteUserById(Long id);

    @Query("SELECT u FROM User u WHERE u.companyName = ?1")
    User getUserByName(String name);
}