/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.web.constants.Constants;

/**
 * @author ADEBOWALE
 *
 */
@WebServlet(urlPatterns = ("/destroy"))
public class DestroyServlet extends SpringServlet {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(DestroyServlet.class);
	

	private static final long serialVersionUID = -3131943414389127397L;
	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		if ((req.getRequestURL() + "").contains(Constants.DELETE_OPERATION)) {
			destroyQuestion(req, resp);
		}
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 *            deleteData method to remote question from the list.
	 */
	private void destroyQuestion(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		question.setQuestion(req.getParameter("question"));
		question.setType(type(req));
		if (question.getType() != null) {
			try {
				questionDAO.delete(question);
				mcqDAO.deleteAllMCQs(question);
				resp.sendRedirect("welcome.html");
				LOGGER.setLevel( Level.INFO);
			} catch (IOException e) {
				LOGGER.setLevel(Level.ERROR);
				LOGGER.error(" Error Occur");
				LOGGER.error(e);
				
			}
		}
	}

}
