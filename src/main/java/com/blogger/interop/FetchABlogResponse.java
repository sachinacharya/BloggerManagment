package com.blogger.interop;

import com.blogger.entities.BlogData;

public class FetchABlogResponse {

	private String message;

	private BlogData bd;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BlogData getBd() {
		return bd;
	}

	public void setBd(BlogData bd) {
		this.bd = bd;
	}

	@Override
	public String toString() {
		return "FetchABlogResponse [message=" + message + ", bd=" + bd + "]";
	}

}
