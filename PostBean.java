package com.example.board;


public class PostBean {
	String name;
	String title;
	String content;
	
	public PostBean(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;

	}
	
    public void setName(String name) {
    	this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }
	
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getName() {
    	return this.name;
    }

    public String getTitle() {
        return this.title;
    }
	
    public String getContent() {
        return this.content;
    }
}