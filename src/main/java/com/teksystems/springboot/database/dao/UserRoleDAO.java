package com.teksystems.springboot.database.dao;

import java.util.List;
import java.util.Map;

import com.teksystems.springboot.database.entity.User;
import com.teksystems.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Course;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    //this will return all records in the user_roles table for a userId
    public List<UserRole> findByUserId(Integer userId);


}
