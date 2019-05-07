package com.dharma.user.demo.dao;
import com.dharma.user.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends JpaRepository<User,String>{
    @Query(value = "select name from user where name=? and password=?",nativeQuery = true)
    String login(String name,String password);


}
