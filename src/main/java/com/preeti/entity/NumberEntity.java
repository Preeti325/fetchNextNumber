package com.preeti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number")
public class NumberEntity {
	
	@Id
	private  String categoryCode;
	private int value;
	
	public NumberEntity() {
	
	}
	
	public NumberEntity(String categoryCode, int value) {
		this.categoryCode = categoryCode;
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyNumber [categoryCode=" + categoryCode + ", value=" + value + "]";
	}


	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
