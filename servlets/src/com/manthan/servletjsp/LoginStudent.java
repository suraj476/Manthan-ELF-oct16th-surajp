package com.manthan.servletjsp;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.beans.StudentInfoBean;
import com.manthan.dao.StudentDao;
import com.manthan.dao.StudentDaoImpl;



@WebServlet("/loginStudentJsp")
public class LoginStudent extends HttpServlet{
	StudentDao dao=new StudentDaoImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=(req.getParameter("username"));
		String password=(req.getParameter("password"));
		HttpSession sessionAttempt=req.getSession();
		sessionAttempt.setAttribute("count", 3);
		StudentInfoBean studentInfoBean=dao.auth(username, password);
		if(studentInfoBean!=null &&  (boolean)req.getSession(false);) {
			HttpSession session=req.getSession(true);
			session.setAttribute("studentInfoBean", studentInfoBean);
			req.getRequestDispatcher("/homePage").forward(req, resp);
		}else {
			int c=(int)sessionAttempt.getAttribute("count");
			c--;
			sessionAttempt.setAttribute("count", c);
			if((int)sessionAttempt.getAttribute("count")>0 && (int)sessionAttempt.getAttribute("count")<4) {
				req.setAttribute("invalidMessage", "Invalid ID or Password... You have "+c+" attempts left!!!");
			}else {
				req.setAttribute("invalidMessage", "Sorry!! your account has been blocked.");;
			}
			req.getRequestDispatcher("/loginForm").forward(req, resp);
		}

	}
}
