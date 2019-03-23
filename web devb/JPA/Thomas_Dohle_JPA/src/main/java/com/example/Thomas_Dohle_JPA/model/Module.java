package com.example.Thomas_Dohle_JPA.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int moduleId;
	
	@OneToMany(mappedBy="module", orphanRemoval=true)
	private List<Lesson> lessons = new ArrayList<>();
	
	private String moduleTitle;
	
	@ManyToOne()
	@JsonIgnore
	private Course course;
	
	public Module() {}
	
	public Module(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}
	
	public Module(Course course, String moduleTitle) {
		this.course=course;
		this.moduleTitle = moduleTitle;
	}
	
	public Module updateModule(Module newModule) {
		this.moduleTitle = newModule.moduleTitle;
		return this;
	}
	
	public List<Lesson> getLessons() {return this.lessons;}
	public Integer getID() {return this.moduleId;}
	public String getModuleTitle() {return this.moduleTitle;}
	public Course getCourse() {return this.course;}
	
	public void setId(Integer id) {this.moduleId = id;}
	public void setCourse(Course course) {this.course = course;}
	public void setModuleTitle(String title) {this.moduleTitle=title;}
	public void addLesson(Lesson l) {this.lessons.add(l);}
	
	@Override
	public String toString() {
		String out = "Module " + this.moduleId;
		out+="\n title: " + this.moduleTitle;
		out += "\n courseId: " + this.course.toString();
		return out;
	}
	

}