package com.blogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogger.interop.BlogCreateRequest;
import com.blogger.interop.BlogCreateResponse;
import com.blogger.interop.BlogUpdateRequest;
import com.blogger.interop.BlogUpdateResponse;
import com.blogger.interop.DeleteABlogRequest;
import com.blogger.interop.DeleteABlogResponse;
import com.blogger.interop.FetchABlogRequest;
import com.blogger.interop.FetchABlogResponse;
import com.blogger.interop.FetchAllBlogsResponse;
import com.blogger.service.BlogService;

@RestController
@RequestMapping("/blog-manager")
public class BlogController {

	@Autowired
	BlogService blogService;

	@PostMapping("/create-a-blog")
	public ResponseEntity<?> createBlog(@Valid @RequestBody BlogCreateRequest blogCreateRequest) {
		BlogCreateResponse blogCreateResponse = new BlogCreateResponse();
		boolean status = blogService.saveBlog(blogCreateRequest);
		if (status) {
			blogCreateResponse.setMessage("Blog created successfully.");
		} else {
			blogCreateResponse.setMessage(
					"Due to some technical issue we are unable to create at this current moment, Please try afetr sometime.");
		}
		return new ResponseEntity<BlogCreateResponse>(blogCreateResponse, HttpStatus.OK);
	}

	@GetMapping("/fetch-a-blog")
	public ResponseEntity<?> fetchABLog(@Valid @RequestBody FetchABlogRequest fetchABlogRequest) {
		FetchABlogResponse fetchABlogResponse = new FetchABlogResponse();
		fetchABlogResponse = blogService.fetchABlog(fetchABlogRequest);
		return new ResponseEntity<FetchABlogResponse>(fetchABlogResponse, HttpStatus.OK);
	}

	@GetMapping("/fetch-all-blogs")
	public ResponseEntity<?> fetchAllBlogs() {
		FetchAllBlogsResponse fetchAllBlogsResponse = new FetchAllBlogsResponse();
		fetchAllBlogsResponse = blogService.fetchAllBlogs();
		return new ResponseEntity<FetchAllBlogsResponse>(fetchAllBlogsResponse, HttpStatus.OK);
	}

	@PostMapping("/update-a-blog")
	public ResponseEntity<?> updateABlog(@Valid @RequestBody BlogUpdateRequest blogUpdateRequest) {
		BlogUpdateResponse blogUpdateResponse = new BlogUpdateResponse();
		blogUpdateResponse = blogService.updateBlog(blogUpdateRequest);
		return new ResponseEntity<BlogUpdateResponse>(blogUpdateResponse, HttpStatus.OK);
	}

	@PostMapping("/delete-a-blog")
	public ResponseEntity<?> deleteABlog(@Valid @RequestBody DeleteABlogRequest deleteABlogRequest) {
		DeleteABlogResponse deleteABlogResponse = new DeleteABlogResponse();
		deleteABlogResponse = blogService.deleteABlog(deleteABlogRequest);
		return new ResponseEntity<DeleteABlogResponse>(deleteABlogResponse, HttpStatus.OK);
	}

}
