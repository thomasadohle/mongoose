package com.example.Thomas_Dohle_JPA.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.*;

@Entity
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int width;
	private int height;
	
	@ManyToOne()
	@JsonIgnore
	private Topic topic;
	private String widgetType;
	private String title;
	public Widget() {}
	
	public int getId() {return this.id;}
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	public Topic getTopic() {return this.topic;}
	public String getWidgetType() {return this.widgetType;}
	public String getTitle() {return this.title;}
	
	public void setWidth(int width) {this.width=width;}
	public void setHeight(int height) {this.height=height;}
	public void setTopic(Topic topic) {this.topic=topic;}
	public void setWidgetType(String type) {this.widgetType = type;}
	public void setTitle(String newTitle) {this.title=newTitle;}
	

	
	@Override
	public String toString() {
		String wid = "";
		wid += this.widgetType;
		wid += "\n";
		wid += this.getTitle();
		return wid;
	}
}
