package com.example.demo.Repos;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    //依據email尋找
    User findByEmail(String email);
    User findByAccount(String account);


}
