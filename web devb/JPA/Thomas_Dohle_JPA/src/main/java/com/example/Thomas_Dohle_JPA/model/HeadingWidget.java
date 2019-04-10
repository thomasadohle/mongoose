package com.example.Thomas_Dohle_JPA.model;
import javax.persistence.*;

@Entity
public class HeadingWidget extends Widget {
	public String text;
	public int size;
	
	public HeadingWidget() {
		super();
		this.setWidgetType("HEADING");
		}
	
	public String getText() {return this.text;}
	public int getSize() {return this.size;}
	
	public void setText(String text) {this.text=text;}
	public void setSize(int size) {this.size=size;}
	
	public HeadingWidget update (HeadingWidget newWid) {
		this.text = newWid.getText();
		this.size = newWid.getSize();
		return this;
	}
	
}
