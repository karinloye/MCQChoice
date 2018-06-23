/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.epita.quiz.datamodel.Login;
import fr.epita.quiz.services.AuthenticationService;

/**
 * @author ADEBOWALE
 *
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet  extends SpringServlet {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	@Inject
	AuthenticationService auth;

	/**
	 * Default constructor.
	 * This construction to allow the initialization of LoginServlet class.
	 */
	public LoginServlet() {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		final String email = request.getParameter("login");
		final String password = request.getParameter("password");
		
		/** 
		 * This was use to test the get method on console.
		 * System.out.println("login : " + email);
		 * System.out.println("password" + password);
		 */
		
		Login login = new Login(email, password);
		
		final boolean authenticated = auth.authenticate(login);
		request.getSession().setAttribute("authenticated", authenticated);
		request.getSession().setAttribute("userName", login);

		if(authenticated) {
		response.sendRedirect("destroy.jsp");
		LOGGER.setLevel( Level.INFO);
		}
		else {
			response.sendRedirect("error.jsp");
			LOGGER.setLevel( Level.ERROR);
		}
	}

}
