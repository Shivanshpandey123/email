package loginDemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");
		
		PrintWriter out = resp.getWriter();
		
		if (myemail.equals("muskaan21@gmail.com") && mypass.equals("muskaan123")) {
			out.print("welcome in my coding world");
			req.setAttribute("name_key", "shivansh");
		RequestDispatcher rd = req.getRequestDispatcher("/mylogin.jsp");
		rd.forward(req, resp);
			
		} else {      
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>  email id and password didnt match try again </h3>"); 
		RequestDispatcher rd =	req.getRequestDispatcher("/index.html");
		 rd.include(req, resp);
		}
	}

}
