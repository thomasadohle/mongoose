package com.example.Thomas_Dohle_JPA.model;
import javax.persistence.*;

@Entity
public class ImageWidget extends Widget{

	private String source;
	
	public ImageWidget() {
		super();
		this.setWidgetType("IMAGE");
	}
	
	public String getSource() {return this.source;}
	public void setSource(String source) {this.source=source;}
	
	public ImageWidget update(ImageWidget wid) {
		setTitle(wid.getTitle());
		this.source = wid.source;
		return this;
	}
}
