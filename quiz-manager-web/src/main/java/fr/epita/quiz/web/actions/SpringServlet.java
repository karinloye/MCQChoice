/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.quiz.web.actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.epita.quiz.datamodel.QuestionType;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class SpringServlet  extends HttpServlet {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(SpringServlet.class);
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	public QuestionType type(HttpServletRequest req) {
		if (req.getParameter("type").contains("OPEN")) {
			return QuestionType.OPEN;
		} else if (req.getParameter("type").contains("MCQ")) {
			return QuestionType.MCQ;
		} else if (req.getParameter("type").contains("ASSOCIATIVE")) {
			return QuestionType.ASSOCIATIVE;
		}
		return null;
	}

}
