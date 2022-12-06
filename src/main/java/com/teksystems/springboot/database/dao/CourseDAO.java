package com.teksystems.springboot.database.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teksystems.springboot.database.entity.Course;

@Repository
public interface CourseDAO extends JpaRepository<Course, Long> { 

	@Query("SELECT c FROM Course c where c.name = :name")
	public List<Course> findByCourseName(String name);
	
	// select * from course where lower(name) like lower('%name%') order by name desc
	public List<Course> findByNameContainingIgnoreCaseOrderByNameDesc(String name);
	
	public Course findByNameAndId(String name, Integer id);
	
	@Query("SELECT c FROM Course c where c.name = :name or c.instructor = :instructor")
	public List<Course> findByNameOrInstructor(String name, String instructor);

	@Query("SELECT c FROM Course c where instructor = :instructor")
	public List<Course> findByInstructor(String instructor);

	public Course findById(Integer id);

	public Course findByName(String name);

	@Query( value = "select instructor, count(*) as cnt "
			+ "from course "
			+ "where instructor is not null and instructor != \"\" "
			+ "group by instructor "
			+ "order by instructor", nativeQuery = true)
	public List<Map<String,Object>> instructorCourseCount();





}
