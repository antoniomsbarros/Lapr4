/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
    FunctionRepository functions(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	FunctionRepository functions();
	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	AutomaticTaskRepository AutomaticTasks(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	AutomaticTaskRepository AutomaticTasks();


	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

	TeamRepository team();

	CatalogRepository catalogs();

	FormRepository forms();

	ServiceRepository services();

	CriticalityLevelRepository criticalityLevels();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	TeamTypeRepository teamTypes(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	TeamTypeRepository teamTypes();
}
