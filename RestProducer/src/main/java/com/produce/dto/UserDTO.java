package com.produce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	@JsonProperty("User_id")
	private String id;
	
	@JsonProperty("User_Name")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
