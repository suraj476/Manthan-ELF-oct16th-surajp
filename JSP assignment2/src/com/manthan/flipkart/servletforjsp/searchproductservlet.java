package com.manthan.flipkart.servletforjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.flipkart.bean.productinfobeans;
import com.manthan.flipkart.dao.productDAO;
import com.manthan.flipkart.dao.productDAOimpl;



@WebServlet("/searchEmp")
public class searchproductservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
			int proId=Integer.parseInt(req.getParameter("productid"));
		productDAO dao=(productDAO) new productDAOimpl();
		productinfobeans productinfobeans=dao.searchproduct(proId);
		if(productinfobeans!=null) {
			req.setAttribute("searchedEmployee", productinfobeans);

		}else {
			req.setAttribute("msg", "employee not found");
		}
		req.getRequestDispatcher("./searchEmployeeForm").forward(req, resp);
	}
		else {
			req.setAttribute("msg", "login first");
			req.getRequestDispatcher("./loginPage").forward(req, resp);
		}
	}

}
