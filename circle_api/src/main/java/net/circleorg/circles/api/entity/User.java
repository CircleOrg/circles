package net.circleorg.circles.api.entity;

import java.util.UUID;

public class User {
    private UUID id;
	private String name;

    public User() {
    	
    }
    
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
		return id;
	}

}
