package com.manthan.flipkart.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.flipkart.bean.Userinfobeans;
import com.manthan.flipkart.dao.userDAO;
import com.manthan.flipkart.dao.userDAOImpl;
@WebServlet("/adduser")
public class Registerservlet extends HttpServlet {
	
	private userDAO dao=new userDAOImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null){
			int userId=Integer.parseInt(req.getParameter("Id"));
			String userName=req.getParameter("name");
			String email=(req.getParameter("email"));
			String password=(req.getParameter("password"));

			Userinfobeans userInfoBeans=new Userinfobeans();
			userInfoBeans.setuserId(userId);
			userInfoBeans.setusername(userName);
			userInfoBeans.setemail(email);
			userInfoBeans.setpassword(password);
			
			if(dao.adduser(userInfoBeans)) {
				req.setAttribute("msg", "employee added sucessfully");
			}else {
				req.setAttribute("msg", "failed to insert");	
			}
				req.getRequestDispatcher("/adduserForm").forward(req, resp);
		}else {
			req.setAttribute("msg", "please login first");
			req.getRequestDispatcher("./loginForm").forward(req, resp);

		}
	}

}
