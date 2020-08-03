package com.courseinfo.course;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
	public Course findBycId(String id);
	
	public List<Course> findAllBycId(String id);
	
	public void deleteBycId(String id);
	
}
