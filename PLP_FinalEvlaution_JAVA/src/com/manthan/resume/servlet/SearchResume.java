package com.manthan.resume.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import org.apache.tika.exception.TikaException;

@WebServlet("/searchresume")
public class SearchResume extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Resumebean resumebean =new Resumebean();
		resumebean = null;
		List<Resumebean> resumebeanarray = new ArrayList<Resumebean>();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();		
		String data = req.getParameter("search");
		String datatype;
		datatype = null;
		String emailRegex = "([a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+)";
		String phonenumRegex = "(0/91)?[7-9][0-9]{9}";
		File folder = new File("C:\\Study-IT");
		       if(folder.exists()&& folder.isDirectory())
		          {
		             File allfiles[] = folder.listFiles();
		              for(File file : allfiles)
		              {
		        	     FileInputStream inputstream = new FileInputStream(file)	;  
		                 AutoDetectParser parser = new AutoDetectParser();
		                 ParseContext pcontext = new ParseContext();
		                  try {
		                	 parser.parse(inputstream, handler, metadata,pcontext);
		                	 } catch (SAXException | TikaException e) {
		                	 e.printStackTrace();
		                	 }
		                 String content = handler.toString();
		                 Pattern pat = Pattern.compile(phonenumRegex); 
		                 resumebean = new Resumebean();
		                 	if(pat.matcher(data).matches())
		                 	{
		                 		datatype = "number";
		                 	}
		                 	Pattern pat1 = Pattern.compile(emailRegex); 
		                 	if(pat1.matcher(data).matches()){
		                 		datatype = "email";  
		                 	}   
		                 	if(datatype=="number")
		                 	{
		                 		Pattern p = Pattern.compile(phonenumRegex); //REGEX for getting mobile number
		                 		Matcher found = p.matcher(content);
		                 		if (found.find())
		                 		{
		                 			System.out.println(file);
		                 			Pattern email=Pattern.compile(emailRegex);
		                 			Matcher mail=email.matcher(content);
		                 			if(mail.find())
		                 			{
		                 				String emailprint = mail.group(0);
		                 				resumebean.setemail(emailprint);
		                 				resumebean.setfilename(file.getName());
		                 				StringTokenizer st=new StringTokenizer(content);
		         
		                 			}
		                 		}
		                 	} else if(datatype=="email")
		                 	{
		                 		Pattern email=Pattern.compile(emailRegex);
		                 		Matcher mail=email.matcher(content);
		                 		if(mail.find())
		                 		{
		                 			String emailprint = mail.group(0);
		                 			resumebean.setemail(emailprint);
		                 			resumebean.setfilename(file.getName());
		                 		}
		                 	}else
		                 	{  
		                 		String key = data;
		                 		int flag =0;
		                 		StringTokenizer st=new StringTokenizer(content);
		                 		while(st.hasMoreTokens())
		                 		{ 
		                 			if (key.equals(st.nextToken())) 
		                 			{
		                 				flag=1;
		                 			}
		                 		} 
		                 		if(flag==1)
		                 		{
		                 			Pattern email2=Pattern.compile(emailRegex);
		                 			Matcher mail2=email2.matcher(content);
		                 			if(mail2.find())
		                 			{
		                 				String emailprint = mail2.group(0);
		                 				resumebean.setemail(emailprint);
		                 				resumebean.setfilename(file.getName());
		                 			}
		                 		}
		                 	}
		              resumebeanarray.add(resumebean);
		              }
		   
		          }
		       req.setAttribute("resumebean", resumebeanarray);
		       req.getRequestDispatcher("/searchresume1").forward(req, resp);
	}
		      
}
		
