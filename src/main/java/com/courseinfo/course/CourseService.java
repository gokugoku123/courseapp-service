package com.courseinfo.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findBycId(id);
	}
	
	public List<String> getStudentIDList(String id) {
		Course tempCourse = courseRepository.findBycId(id);
		List<String> result = tempCourse.getStudentsList() == null ? new ArrayList<>() : tempCourse.getStudentsList();
		return result ;
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public void updateCourse(String cId, Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.deleteBycId(id);
	}
	
	public void updateStudentsList(String cId, String sId) {
		Course tempCourse = courseRepository.findBycId(cId);

		if(! tempCourse.getStudentsList().contains(sId))
			tempCourse.addToStudentList(sId);
		courseRepository.save(tempCourse);
	}
	
	public void deleteFromStudentsList(String cId, String sId) {
		Course tempCourse = courseRepository.findBycId(cId);
		tempCourse.removeFromSudentList(sId);
		courseRepository.save(tempCourse);
	}

}
 