package com.teksystems.springboot.database.dao;

import java.util.List;
import java.util.Map;

import com.teksystems.springboot.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Course;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}

