package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest_2_3 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("password");

		PrintWriter pw = response.getWriter();

		if (name.trim().equals("admin") && pass.trim().equals("admin")) {

			response.setHeader("refresh", "3;URL=index.html");
			pw.println("<h4 align=\"center\"><font color=\"#FF1515\">login successful! Page will go to index after 3 second.</font></h4>");
			pw.close();

		} else {

			response.setHeader("refresh", "3;URL=login.html");
			pw.println("<h4 align=\"center\"><font color=\"#FF1515\">login fail! Page will go to login.html after 3 second.</font></h4>");
			pw.close();

		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
