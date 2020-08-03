package com.courseinfo.course;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
	
	@Id
	private String cId;
	private String cName;
	private double rating, duration;
	
	private List<String> studentsList = new ArrayList<>();
	
	

	public Course() {
		this.studentsList = new ArrayList<>();
	}
	
	public Course(String cId, String cName, double rating, double duration) {
		super();
		this.studentsList = new ArrayList<>();
		this.cId = cId;
		this.cName = cName;
		this.rating = rating;
		this.duration = duration;
	}
	
	public List<String> getStudentsList() {
		System.out.println("Value = " + studentsList);
		return studentsList;
	}
	
	public void addToStudentList(String sId) {
		studentsList.add(sId);
	}
	
	public void removeFromSudentList(String sId) {
		System.out.println("Insdide the delete section");
		for(int i = 0; i < studentsList.size(); i++) {
			
			if(studentsList.get(i).equals(sId)) {
				studentsList.remove(i);
				System.out.println("REmocved + " + studentsList);
				return;
			}
		}
	}

	public void setStudentsList(List<String> studentsList) {
		this.studentsList = studentsList;
	}


	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return this.cName + " and List = " + this.studentsList;
	}
	
	
	
}
