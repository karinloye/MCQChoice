/**
 * 
 */
package fr.epita.quiz.web.actions;


import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet(urlPatterns = ("/search"))
public class FindServlet extends SpringServlet {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(FindServlet.class);

	private static final long serialVersionUID = -3131943414389127397L;
	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		if ((req.getRequestURL() + "").contains(Constants.SEARCH_OPERATION)) {
			findQuestion(req, resp);
		}

	}

	private void findQuestion(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();
		question.setQuestion(req.getParameter("question"));

		question.setType(type(req));
		questionDAO.search(question);
	}
}
