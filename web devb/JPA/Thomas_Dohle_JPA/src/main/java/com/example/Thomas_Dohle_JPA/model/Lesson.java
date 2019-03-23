package com.example.Thomas_Dohle_JPA.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lesson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lessonId;
	
	@OneToMany(mappedBy="lesson", orphanRemoval=true)
	private List<Topic> topics = new ArrayList<>();
	
	private String title;
	
	@ManyToOne
	@JsonIgnore
	private Module module;
	
	public Lesson() {}
	
	public Lesson (String title) {
		this.title=title;}
	
	public Lesson updateLesson (Lesson lesson) {
		this.title = lesson.title;
		return this;
	}
	
	public List<Topic> getTopics(){return this.topics;}
	public Integer getId() {return this.lessonId;}
	public String getTitle() {return this.title;}
	public Module getModule() {return this.module;}
	
	public void addTopic(Topic t) {this.topics.add(t);}
	public void setId(Integer id) {this.lessonId = id;}
	public void setModule(Module module) {this.module = module;}
	public void setTitle(String title) {this.title=title;}
	
	@Override
	public String toString() {
		String str = "";
		str += "Lesson " + this.getTitle();
		return str;
	}
	
}
