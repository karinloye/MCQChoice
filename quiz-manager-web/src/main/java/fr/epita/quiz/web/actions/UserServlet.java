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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.epita.quiz.datamodel.Login;
import fr.epita.quiz.services.LoginDAO;

/**
 * @author ADEBOWALE
 *
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends SpringServlet {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(UserServlet.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	LoginDAO loginDao;

	public UserServlet() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String email = request.getParameter("login");
		final String password = request.getParameter("password");

		Login login = new Login(email, password);

		if (login != null) {
			try {
				loginDao.create(login);
			} catch (Exception  e) {
				
				/**
				 *  TODO  use a logj4 to generated catch block  
				 * 
				 ***/
				e.printStackTrace();
			}
			response.sendRedirect("question.jsp");
			/**
			 * System.out.println("login : " + email + "password" + password);
			 * **/
		} else
			response.sendRedirect("user.jsp");
		System.out.println("please try again");

	}
}
