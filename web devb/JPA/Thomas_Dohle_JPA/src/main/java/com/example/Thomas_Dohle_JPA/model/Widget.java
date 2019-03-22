package com.example.Thomas_Dohle_JPA.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Widget {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String wType;
	private int width;
	private int height;
	
	@ManyToOne()
	@JsonIgnore
	private Topic topic;
	
	public Widget() {}
	
	public int getId() {return this.id;}
	public String getType() {return this.wType;}
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	
	public void setType(String type) {this.wType=type;}
	public void setWidth(int width) {this.width=width;}
	public void setHeight(int height) {this.height=height;}
	
}
