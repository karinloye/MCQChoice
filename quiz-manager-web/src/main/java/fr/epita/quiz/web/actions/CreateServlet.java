/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.QuestionType;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.web.constants.Constants;

/**
 * @author ADEBOWALE
 *
 */
@WebServlet(urlPatterns = ("/create"))
public class CreateServlet extends SpringServlet {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(CreateServlet.class);
	private static final long serialVersionUID = -3131943414389127397L;
	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		if ((req.getRequestURL() + "").contains(Constants.CREATE_OPERATION)) {
			try {
				createData(req, resp);
				resp.sendRedirect("welcome.html");
				LOGGER.setLevel(Level.INFO);
			} catch (Exception e) {

				LOGGER.setLevel( Level.INFO);
			}
		}
	}

	private void createData(HttpServletRequest req, HttpServletResponse resp) {
		Question question = new Question();

		question.setQuestion(req.getParameter("question"));

		question.setType(type(req));

		if (question.getType() != null)
			questionDAO.create(question);

	}

	

}
