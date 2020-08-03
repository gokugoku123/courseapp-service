package com.courseinfo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseinfo")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/hi")
	public String hi() {
		return "<h1> Hi from Course info </h1>";
	}
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		System.out.println("Courses : " + courseService.getAllCourses());
		return courseService.getAllCourses();
	}
	@RequestMapping("/courses/{cId}")
	public Course getCourse(@PathVariable String cId) {
		System.out.println("Courses : " + courseService.getCourse(cId));
		return courseService.getCourse(cId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/courses")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course); 
	}
	
	@RequestMapping("/courses/{cId}/studentIdList")
	public List<String> getStudentIDList(@PathVariable 	String cId) {
		return courseService.getStudentIDList(cId);
	}
	
	@PutMapping("/courses/add/{cId}/{sId}")
	public void updateStudentsList( @PathVariable String cId, @PathVariable String sId) {
		courseService.updateStudentsList(cId, sId);
	}
	
	@PutMapping("/courses/delete/{cId}/{sId}")
	public void deleteFromStudentsList( @PathVariable String cId, @PathVariable String sId) {
		
		courseService.deleteFromStudentsList(cId, sId); 
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/courses/{cId}")
	public void updateCourse(@PathVariable String cId, @RequestBody Course course) {
		courseService.updateCourse(cId, course); 
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{cId}")
	public void deleteCourse(@PathVariable String cId) {
		courseService.deleteCourse(cId); 
	}
}
