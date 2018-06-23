/**
 * 
 */
package fr.epita.quiz.web.actions;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.services.MCQChoiceDAO;
import fr.epita.quiz.web.constants.Constants;

/**
 * @author ADEBOWALE
 *
 */

public class MCQChoiceServlet extends SpringServlet {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(MCQChoiceServlet.class);

	private static final long serialVersionUID = -7851615693917357921L;
	
	@Inject
	MCQChoiceDAO mcqDAO;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if ((req.getRequestURL() + "").contains(Constants.CREATE_OPERATION)) {
			try {
				createMCQChoice(req, resp);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else if ((req.getRequestURL() + "").contains(Constants.SEARCH_OPERATION)) {
			searchMCQChoice(req, resp);
		} else if ((req.getRequestURL() + "").contains(Constants.UPDATE_OPERATION)) {
			updateMCQChoice(req, resp);
		} else if ((req.getRequestURL() + "").contains(Constants.DELETE_OPERATION)) {
			deleteMCQChoice(req, resp);
		}
	}
	/**
	 * 
	 * @param req
	 * @param resp
	 * this method will delete a MCQChoice...
	 */

	/**
	 * 
	 * @param req
	 * @param resp
	 * this method will update the MCQChoice
	 */

	private void updateMCQChoice(HttpServletRequest req, HttpServletResponse resp) {
		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter("mcqOption"));
		choice.setOrder(Integer.valueOf(req.getParameter("order")));
		choice.setValid(validOption(req));
		
		List<MCQChoice> mcqList = mcqDAO.search(choice);

		MCQChoice fetchedMCQ = mcqList.get(0);
		

		if (!fetchedMCQ.getChoice().equalsIgnoreCase(req.getParameter("mcqOption"))
				|| fetchedMCQ.getOrder() != (Integer.valueOf(req.getParameter("order"))) 
				||(fetchedMCQ.isValid() == (req.getParameter("valid").equalsIgnoreCase("true")?true:false))
				) {
		
			choice.setChoice(req.getParameter("mcqOption"));
			choice.setOrder(Integer.valueOf(req.getParameter("order")));
			choice.setValid(validOption(req));
			mcqDAO.update(choice);
		}
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * this method will be used to search for MCQChoice
	 */
	private void searchMCQChoice(HttpServletRequest req, HttpServletResponse resp) {

		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter("mcqOption"));
		choice.setOrder(Integer.valueOf(req.getParameter("order")));
		choice.setValid(validOption(req));

		mcqDAO.search(choice);
	}
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * this method will be used to create a new MQCChoice
	 * @throws SystemException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws SecurityException 
	 */

	private void createMCQChoice(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		MCQChoice choice = new MCQChoice();

		choice.setChoice(req.getParameter("mcqOption"));
		choice.setOrder(Integer.valueOf(req.getParameter("order")));
		choice.setValid(validOption(req));
		mcqDAO.create(choice);

	}

	private boolean validOption(HttpServletRequest req) {
		
		if(req.getParameter("valid").contains("true")) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @param req
	 * @param resp
	 * this method will delete a MCQChoice...
	 */
	
	private void deleteMCQChoice(HttpServletRequest req, HttpServletResponse resp) {
		
		MCQChoice choice = new MCQChoice();
		choice.setChoice(req.getParameter("mcqOption"));
		choice.setOrder(Integer.valueOf(req.getParameter("order")));
		choice.setValid(validOption(req));	
		mcqDAO.delete(choice);
		
	}


}
