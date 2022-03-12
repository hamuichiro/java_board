package com.example.board;



public class PostBean {
	String id;
	String author;
	String title;
	String body;
	String createDate;
	String updateDate;
	boolean deleted;
	boolean edit;
	
	
	public void setId(String id) {
		this.id = id;
	}
	
    public void setAuthor(String author) {
    	this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
	
    public void setBody(String body) {
        this.body = body;
    }
    
    public void setCreateDate(String createDate) {
    	this.createDate = createDate;
    }
    
    public void setUpdateDate(String updateDate) {
    	this.updateDate = updateDate;
    }
    
    public void setDeleted (boolean deleted) {
    	this.deleted = deleted;
    }
    
    public void setEdit(boolean edit) {
    	this.edit = edit;
    }
    
    public String getId() {
    	return this.id;
    }
    
    public String getAuthor() {
    	return this.author;
    }

    public String getTitle() {
        return this.title;
    }
	
    public String getBody() {
        return this.body;
    }
    
    public String getCreateDate() {
    	return this.createDate;
    }
    
    public String getUpdateDate() {
    	return this.updateDate;
    }
    
    public boolean getDeleted() {
    	return this.deleted;
    }
    
    public boolean getEdit() {
    	return this.edit;
    }
}