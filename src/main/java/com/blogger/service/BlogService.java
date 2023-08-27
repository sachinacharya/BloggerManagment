package com.blogger.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.entities.BlogData;
import com.blogger.interop.BlogCreateRequest;
import com.blogger.interop.BlogUpdateRequest;
import com.blogger.interop.BlogUpdateResponse;
import com.blogger.interop.DeleteABlogRequest;
import com.blogger.interop.DeleteABlogResponse;
import com.blogger.interop.FetchABlogRequest;
import com.blogger.interop.FetchABlogResponse;
import com.blogger.interop.FetchAllBlogsResponse;
import com.blogger.repositories.BlogDataRepository;

@Service
public class BlogService {

	@Autowired
	BlogDataRepository blogDataRepository;

	public boolean saveBlog(BlogCreateRequest blogCreateRequest) {
		BlogData bd = new BlogData();
		boolean status = false;
		try {
			bd.setBlogId(blogCreateRequest.getBlogId());
			bd.setUserName(blogCreateRequest.getUserName());
			bd.setBlogTitle(blogCreateRequest.getBlogTitle());
			bd.setBlogData(blogCreateRequest.getBlogData());

			blogDataRepository.save(bd);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public FetchABlogResponse fetchABlog(FetchABlogRequest fetchABlogRequest) {
		FetchABlogResponse fetchABlogResponse = new FetchABlogResponse();
		BlogData bd = new BlogData();
		try {
			bd = blogDataRepository.findById(fetchABlogRequest.getBlogId()).get();
			if (bd == null) {
				fetchABlogResponse.setMessage("Blog does not exists.");
				fetchABlogResponse.setBd(null);
			} else {
				fetchABlogResponse.setMessage("Blog fetched successfully.");
				fetchABlogResponse.setBd(bd);
			}
		} catch (Exception e) {
			fetchABlogResponse.setMessage("Unable to fetch blog details.");
			fetchABlogResponse.setBd(null);
		}
		return fetchABlogResponse;
	}

	public FetchAllBlogsResponse fetchAllBlogs() {
		List<BlogData> blogDataList = new ArrayList<BlogData>();
		FetchAllBlogsResponse fetchAllBlogsResponse = new FetchAllBlogsResponse();
		try {
			blogDataRepository.findAll().forEach(blog -> blogDataList.add(blog));
			if (blogDataList.size() == 0) {
				fetchAllBlogsResponse.setMessage("No Blogs found.");
				fetchAllBlogsResponse.setBd(blogDataList);
			} else {
				fetchAllBlogsResponse.setMessage("All blogs fetched.");
				fetchAllBlogsResponse.setBd(blogDataList);
			}
		} catch (Exception e) {
			fetchAllBlogsResponse.setMessage("Unable to fetch blog lists.");
			fetchAllBlogsResponse.setBd(blogDataList);
		}
		return fetchAllBlogsResponse;
	}


	public BlogUpdateResponse updateBlog(BlogUpdateRequest blogUpdateRequest) {
		BlogData bd = new BlogData();
		BlogUpdateResponse blogUpdateResponse = new BlogUpdateResponse();
		try {
			if (blogDataRepository.existsById(blogUpdateRequest.getBlogId())) {
				bd.setBlogId(blogUpdateRequest.getBlogId());
				bd.setUserName(blogUpdateRequest.getUserName());
				bd.setBlogTitle(blogUpdateRequest.getBlogTitle());
				bd.setBlogData(blogUpdateRequest.getBlogData());

				blogDataRepository.save(bd);
				blogUpdateResponse.setMessage("Blog Updated successfully.");

			} else {
				blogUpdateResponse.setMessage("No Blog exists with mentioned Blog ID.");
			}
		} catch (Exception e) {
			blogUpdateResponse.setMessage(
					"Due to some technical issue we are unable to update at this current moment, Please try afetr sometime.");
		}
		return blogUpdateResponse;
	}

	public DeleteABlogResponse deleteABlog(DeleteABlogRequest deleteABlogRequest) {

		DeleteABlogResponse deleteABlogResponse = new DeleteABlogResponse();
		try {
			blogDataRepository.deleteById(deleteABlogRequest.getBlogId());
			deleteABlogResponse.setMessage("Blog deleted successfully.");
		} catch (Exception e) {
			deleteABlogResponse.setMessage(
					"Due to some technical issue we are unable to delete at this current moment, Please try afetr sometime.");

		}
		return deleteABlogResponse;
	}
}
