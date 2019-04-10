package com.example.Thomas_Dohle_JPA.model;
import javax.persistence.*;

@Entity
public class ParagraphWidget extends Widget{

	private String text;
	
	public ParagraphWidget() {
		super();
		this.setWidgetType("PARAGRAPH");
	}
	
	public String getText() {return this.text;}
	
	public void setText(String text) {this.text=text;}
	
	public ParagraphWidget update(ParagraphWidget wid) {
		setTitle(wid.getTitle());
		this.text = wid.getText();
		return this;
	}
}
