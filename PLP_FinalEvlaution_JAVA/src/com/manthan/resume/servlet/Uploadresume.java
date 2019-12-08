package com.manthan.resume.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/Uploadresume")
public class Uploadresume extends HttpServlet {
	   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try{
    		MultipartRequest multipartrequest = new MultipartRequest(request,"C:\\Study-IT");
    		String filename = multipartrequest.getOriginalFileName("file");
    		System.out.println(filename);
    		request.setAttribute("msg", "Resume Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("msg", "Resume Not Found " + ex);
            }          
           request.getRequestDispatcher("/Upload").forward(request, response);
    }
}
           
