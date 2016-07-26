package com.junjie.model;

import java.util.Date;

public class Immo24Category {
	Integer id;
	
	String name;
	
	Date syncTimestamp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSyncTimestamp() {
		return syncTimestamp;
	}

	public void setSyncTimestamp(Date syncTimestamp) {
		this.syncTimestamp = syncTimestamp;
	}
	
	
}
