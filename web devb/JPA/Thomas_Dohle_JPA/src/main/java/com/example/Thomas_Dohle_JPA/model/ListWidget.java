package com.example.Thomas_Dohle_JPA.model;


import javax.persistence.*;

@Entity
public class ListWidget extends Widget {
	private String[] items;
	private boolean ordered;
	
	public ListWidget() {
		super();
		this.setWidgetType("LIST");
		}
	
	public String[] getItems(){return this.items;}
	public boolean getOrdered() {return this.ordered;}
	

	public void setOrdered(Boolean b) {this.ordered=b;}
	
	public ListWidget update(ListWidget newWid) {
		this.items = newWid.items;
		this.ordered = newWid.ordered;
		return this;
	}

}
