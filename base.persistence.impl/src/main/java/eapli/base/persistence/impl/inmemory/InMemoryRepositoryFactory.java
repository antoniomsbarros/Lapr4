package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogmanagement.repository.ActivityRepository;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.funcaomanagement.repositories.FunctionRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	static {
		// only needed because of the in memory persistence
		new BaseBootstrapper().execute();
	}

	@Override
	public UserRepository users(final TransactionalContext tx) {
		return new InMemoryUserRepository();
	}

	@Override
	public UserRepository users() {
		return users(null);
	}


	@Override
	public ClientUserRepository clientUsers(final TransactionalContext tx) {

		return new InMemoryClientUserRepository();
	}

	@Override
	public ClientUserRepository clientUsers() {
		return clientUsers(null);
	}

	@Override
	public ActivityRepository activity() {
		return new InMemoryActivityRepository();
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return signupRequests(null);
	}

	@Override
	public TeamRepository team() {
		return new InMemoryTeamRepository();
	}

	@Override
	public CatalogRepository catalogs() {
		return catalogs(null);
	}


	public CatalogRepository catalogs(final TransactionalContext tx){
		return new InMemoryCatalogRepository();
	}

	@Override
	public FormRepository forms() {
		return new InMemoryFormRepository();
	}

	@Override
	public ServiceRepository services() {
		return services(null);
	}


	public ServiceRepository services(final TransactionalContext tx){
		return new InMemoryServiceRepository();
	}

	@Override
	public CriticalityLevelRepository criticalityLevels() {
		return new InMemoryCriticalitylevelRepository();
	}

	@Override
	public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
		return null;
	}

	@Override
	public TeamTypeRepository teamTypes() {
		return new InMemoryTeamTypeRepository();
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext tx) {
		return new InMemorySignupRequestRepository();
	}

	@Override
	public FunctionRepository functions(final TransactionalContext tx) {

		return new InMemoryFunctionRepository();
	}

	@Override
	public AutomaticTaskRepository AutomaticTasks() {
		return AutomaticTasks(null);
	}

	@Override
	public AutomaticTaskRepository AutomaticTasks(final TransactionalContext tx) {

		return new InMemoryAutomaticTaskRepository();
	}

	@Override
	public ManualTaskRepository manualTasks() {
		return manualTasks(null);
	}

	@Override
	public ManualTaskRepository manualTasks(final TransactionalContext tx) {

		return new InMemoryManualTaskRepository();
	}

	@Override
	public FunctionRepository functions() {
		return functions(null);
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		// in memory does not support transactions...
		return null;
	}


}
