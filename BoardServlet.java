package com.example.board;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<PostBean> postBeanList = new ArrayList<>();
	



	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		PostBean post = null;
		String pathInfo = request.getPathInfo();
		int editIndex = 0;
		
		switch (pathInfo) {
	        case "/create": 
	    		String author = request.getParameter("author");
	    		String title = request.getParameter("title");
	    		String body = request.getParameter("body");
	    		String id = UUID.randomUUID().toString();
	    		LocalDateTime date = LocalDateTime.now();
	    		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    		String createDate = dateFormat.format(date);
	    		post = new PostBean();
	    		post.setId(id);
	    		post.setAuthor(author);
	    		post.setTitle(title);
	    		post.setBody(body);
	    		post.setCreateDate(createDate);
	    		post.setDeleted(false);
	    		post.setEdit(false);
				postBeanList.add(post);
	        break;
	        case "/edit":
	        	for(PostBean editPost: this.postBeanList) {
	        		String targetId = editPost.getId();
	        		if(targetId.equals(request.getParameter("id"))) {
	        			editPost.setEdit(true);
	        			editIndex = postBeanList.indexOf(editPost);
	        			request.setAttribute("targetPost", editPost);
	        		}
	        	}
	        break;
	        case "/update":
	        			PostBean updatePost = postBeanList.get(editIndex);
	    	    		author = request.getParameter("author");
	    	    		title = request.getParameter("title");
	    	    		body = request.getParameter("body");
	    	    		date = LocalDateTime.now();
	    	    		dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    	    		String updateDate = dateFormat.format(date);
	    	    		updatePost.setAuthor(author);
	    	    		updatePost.setTitle(title);
	    	    		updatePost.setBody(body);
	    	    		updatePost.setCreateDate(updateDate);
	        			this.postBeanList.set(editIndex, updatePost);	
	        break;
	        case "/delete":
	        	for(PostBean deletePost: this.postBeanList) {
	        		String targetId = deletePost.getId();
	        		if(targetId.equals(request.getParameter("id"))) {
	        			deletePost.setDeleted(true);
	        		}
	        }
	        break;
	        default:
	        	//post = new PostBean();
	        	//request.setAttribute("post", post);
	        break;
		}
    	request.setAttribute("postBeanList", this.postBeanList);
    	this.getServletContext().getRequestDispatcher("/layout.jsp").forward(request, response);
	}

}