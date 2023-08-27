package com.blogger.interop;

import java.util.List;

import com.blogger.entities.BlogData;

public class FetchAllBlogsResponse {

	private List<BlogData> bd;

	private String message;

	public List<BlogData> getBd() {
		return bd;
	}

	public void setBd(List<BlogData> bd) {
		this.bd = bd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "FetchAllBlogsResponse [bd=" + bd + ", message=" + message + "]";
	}

}
