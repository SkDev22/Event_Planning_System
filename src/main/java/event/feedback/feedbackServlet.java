package event.feedback;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/feedbackServlet")
public class feedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");

		
		try {
			List<feedback> feedDetails = feedbackDB.validate(name, email);
			request.setAttribute("feedDetails", feedDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
			//Redirect to feedbackAccount.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("feedbackAccount.jsp");
			dis.forward(request, response);
			
		} 
		
	}
