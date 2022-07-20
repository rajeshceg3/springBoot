package com.user;
import com.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    //User findbyName(String name);
}
