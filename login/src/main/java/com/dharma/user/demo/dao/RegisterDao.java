package com.dharma.user.demo.dao;

import com.dharma.user.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterDao extends JpaRepository<User,String> {
    public List<User> findByName(String name);
}
