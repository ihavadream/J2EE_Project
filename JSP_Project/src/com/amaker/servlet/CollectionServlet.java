package com.amaker.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.beans.editors.IntEditor;

import com.amaker.bean.CollectionBean;
import com.amaker.dao.impl.CollDao;
import com.amaker.dao.impl.CollDaoImpl;

public class CollectionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CollectionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null&&action.equals("save")){
			save(request, response);
		}else if (action!=null&&action.equals("list")) {
			list(request, response);
		}else if (action!=null&&action.equals("get")) {
			get(request, response);
		}else if (action!=null&&action.equals("update")) {
			update(request, response);
		}else if (action!=null&&action.equals("delete")) {
			delete(request, response);
		}else {
			
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void get(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		CollDao dao=new CollDaoImpl();
		CollectionBean bean=dao.get(new Integer(id).intValue());
		request.setAttribute("CollectionBean",bean);
		request.getRequestDispatcher("/CollectionEdit.jsp").forward(request, response);
	}
	
	public void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		String url=request.getParameter("url");
		
		CollDao dao=new CollDaoImpl();
		CollectionBean bean=new CollectionBean();
		bean.setName(name);
		bean.setUrl(url);
		dao.save(bean);
		list(request, response);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String url=request.getParameter("url");
		
		CollDao dao=new CollDaoImpl();
		CollectionBean bean=new CollectionBean();
		bean.setId(new Integer(id).intValue());
		bean.setName(name);
		bean.setUrl(url);
		dao.update(bean);
		list(request, response);
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids=request.getParameterValues("ids");
		CollDao dao=new CollDaoImpl();
		dao.delete(ids);
		list(request, response);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CollDao dao=new CollDaoImpl();
		
		List list=dao.list();
		request.setAttribute("CL", list);
		
		request.getRequestDispatcher("/Collection.jsp").forward(request, response);
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
