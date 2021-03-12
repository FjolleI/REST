/**
 * 
 */
package com.coursestopics.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class Topic {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	public Topic(){
		super();
	}
	
	public Topic(String id, String name, String description){
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
