package com.blogger.interop;

public class DeleteABlogResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DeleteABlogResponse [message=" + message + "]";
	}

}
