package com.example.board;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<PostBean> postBeanList = new ArrayList<>();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		PostBean post = new PostBean(name, title, content);
		
		
		postBeanList.add(post);
		request.setAttribute("postBeanList", postBeanList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/layout.jsp");
		dispatcher.forward(request, response);
		
	}

}