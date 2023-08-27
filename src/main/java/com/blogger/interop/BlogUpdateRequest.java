package com.blogger.interop;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BlogUpdateRequest {

	@NotNull(message = "Blog ID should not be null or empty.")
	@Pattern(regexp = "^[0-9]*$", message = "Blog ID is in invalid format.")
	private int blogId;

	@NotNull(message = "Username should not be null or empty.")
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username is in invalid format.")
	private String userName;

	@NotNull(message = "Blog Title should not be null or empty.")
	@Pattern(regexp = "^[a-zA-Z0-9 .!?*]*$", message = "Blog Title is in invalid format.")
	private String blogTitle;

	@NotNull(message = "Blog Data should not be null or empty.")
	@Pattern(regexp = "^[a-zA-Z0-9 .!?*]*$", message = "Blog Data is in invalid format.")
	private String blogData;

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

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogData() {
		return blogData;
	}

	public void setBlogData(String blogData) {
		this.blogData = blogData;
	}

	@Override
	public String toString() {
		return "BlogCreateRequest [blogId=" + blogId + ", userName=" + userName + ", blogTitle=" + blogTitle
				+ ", blogData=" + blogData + "]";
	}

}
