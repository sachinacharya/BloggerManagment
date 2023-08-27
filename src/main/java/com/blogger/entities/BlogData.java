package com.blogger.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BlogData {

	@Id
	@Column
	private int blogId;
	
	@Column
	private String userName;
	
	@Column
	private String blogTitle;
	
	@Column
	private String blogData;

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBlogData() {
		return blogData;
	}

	public void setBlogData(String blogData) {
		this.blogData = blogData;
	}

}
