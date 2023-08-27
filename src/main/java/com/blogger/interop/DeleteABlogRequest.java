package com.blogger.interop;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DeleteABlogRequest {

	@NotNull(message = "Blog ID should not be null or empty.")
	@Pattern(regexp = "^[0-9]*$", message = "Blog ID is in invalid format.")
	private int blogId;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "DeleteABlogRequest [blogId=" + blogId + "]";
	}

}
