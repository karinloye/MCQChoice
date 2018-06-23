/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet(urlPatterns = "/update")
public class EditServlet extends SpringServlet {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(EditServlet.class);
	private static final long serialVersionUID = -3131943414389127397L;
	@Inject
	QuestionDAO questionDAO;

	@Inject
	MCQChoiceDAO mcqDAO;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

		if ((req.getRequestURL() + "").contains(Constants.UPDATE_OPERATION)) {
			editQuestion(req, resp);
		}

	}

	/**
	 * 
	 * @param req
	 * @param resp
	 *            deleteData method to remote question from the list.
	 */

	/**
	 * 
	 * @param req
	 * @param resp
	 *            updateData will make a modification to question.
	 */

	private void editQuestion(HttpServletRequest req, HttpServletResponse resp) {

		Question question = new Question();

		question.setQuestion(req.getParameter("question"));

		question.setType(type(req));

		questionDAO.search(question);
		int id = question.getId();

		List<Question> questionList = questionDAO.search(question);

		Question fetchedQuestion = questionList.get(0);

		if (!fetchedQuestion.getQuestion().equalsIgnoreCase(req.getParameter("question"))
				|| !fetchedQuestion.getType().toString().equalsIgnoreCase(req.getParameter("type"))) {

			question.setQuestion(req.getParameter("question"));
			question.setType(type(req));
			question.setId(id);

			try {
				if (question.getType() != null)
					questionDAO.update(question);
				resp.sendRedirect("welcome.html");
				LOGGER.setLevel(Level.INFO);
			} catch (IOException e) {

				LOGGER.setLevel(Level.ERROR);
				LOGGER.error(" Error Occur");
				LOGGER.error(e);
				
			}
		}
	}

}
