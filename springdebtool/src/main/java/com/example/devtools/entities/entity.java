package com.example.devtools.entities;

public class entity {
	private int userId;
	private int id;
	private String title;
	private String body;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "entity [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	public entity(int userId, int id, String title, String body) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}
	public entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
