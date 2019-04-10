package com.example.Thomas_Dohle_JPA.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JsonIgnore
	private Lesson lesson;	
	
	@OneToMany(mappedBy="topic",orphanRemoval=true)
	private List<Widget> widgets = new ArrayList<>();
	private String title;
	
	public Topic() {}
	
	public Topic updateTopic (Topic topic) {
		this.title = topic.title;
		return this;
	}
	
	public Integer getId() {return this.id;}
	public Lesson getLesson() {return this.lesson;}
	public String getTitle() {return this.title;}
	public List<Widget> getWidgets(){return this.widgets;}
	
	public void setId(Integer id) {this.id = id;}
	public void setLesson(Lesson lesson) { this.lesson=lesson;}
	public void setTitle(String title) {this.title=title;}
	public void addWidget(Widget widget) {this.widgets.add(widget);}	
	@Override
	public String toString() {
		return "topic: " + this.id + " " + this.title + "belongs to: " + this.lesson.toString();
	}
}