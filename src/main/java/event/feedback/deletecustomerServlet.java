package event.feedback;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deletecustomerServlet")
public class deletecustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		isTrue = feedbackDB.deletefeedback(id);
		
		if(isTrue == true) {
			RequestDispatcher disp = request.getRequestDispatcher("feedbackinsert.jsp");
			disp.forward(request, response);
		}
		else {
			
			List<feedback> feedDetails = feedbackDB.getfeedbackDetails(id);
			request.setAttribute("feedDetails", feedDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("feedbackAccount.jsp");
			dis.forward(request, response);
			
		}
	}

}
