package com.blogger.interop;

public class BlogCreateResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BlogCreateResponse [message=" + message + "]";
	}

}
