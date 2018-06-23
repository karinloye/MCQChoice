/**
 * 
 */
package fr.epita.quiz.services;

import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import fr.epita.quiz.datamodel.Login;

/**
 * @author ADEBOWALE
 *
 */

public class User {
	
	@Inject
	private LoginDAO loginDao;
	
	/**
	 * the createUser method will create a new user.
	 * @throws SystemException 
	 * @throws HeuristicRollbackException 
	 * @throws HeuristicMixedException 
	 * @throws RollbackException 
	 * @throws SecurityException 
	 */
	
	public  void createUser(Login login) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		 loginDao.create(login);;
	}

}
