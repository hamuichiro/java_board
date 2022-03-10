package com.example.board;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
        
		String pathInfo = request.getPathInfo();
		switch (pathInfo) {
	        case "/create": 
	    		String name = request.getParameter("name");
	    		String title = request.getParameter("title");
	    		String content = request.getParameter("content");
	    		LocalDateTime date = LocalDateTime.now();
	    		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    		String createDate = dateFormat.format(date);
				PostBean post = new PostBean(name, title, content, createDate);
				postBeanList.add(post);
	        	request.setAttribute("postBeanList", this.postBeanList);
	        	this.getServletContext().getRequestDispatcher("/layout.jsp").forward(request, response);
	        break;
	        default:
	        	request.setAttribute("postBeanList", this.postBeanList);
	        	this.getServletContext().getRequestDispatcher("/layout.jsp").forward(request, response);
            break;
		}
	}

}