package com.example.Thomas_Dohle_JPA.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	
	@OneToMany(mappedBy="course", orphanRemoval=true)
	private List<Module> modules = new ArrayList<>();
	
	@ManyToOne()
	@JsonIgnore
	private User author;
	
	private String courseTitle;
	
	public Course() {}
	
	public Course (User author, String courseTitle) {
		this.author=author;
		this.courseTitle = courseTitle;
	}
	
	public Course (String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public Course updateCourse(Course newCourse) {
		this.courseTitle = newCourse.getCourseTitle();
		return this;
	}
	
	public List<Module> getModules() {return this.modules;}
	public User getAuthor() {return this.author;}
	public Integer getID() {return this.courseId;}
	public String getCourseTitle() {return this.courseTitle;}
	
	public void setCourseTitle(String title) {
		this.courseTitle=title;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	public Module addModule(Module m) {
		this.modules.add(m);
		return m;
	}
	
	public void removeModule(Module m) {
		this.modules.remove(m);
	}
	
	@Override
	public String toString() {
		String course = this.getCourseTitle();
		course += " \n Modules: ";
		for (Module m : this.modules) {
			course+="\n " + m.toString();
			course+= "\n         Lessons: ";
			for (Lesson l : m.getLessons()) {
				course+= "\n                 " + l.toString();
				course+= "\n                             Topics: ";
				for (Topic t : l.getTopics()) {
					course+= "\n                               " + t.getTitle();
				}
			}
		}
		return course;
	}
	

	
}