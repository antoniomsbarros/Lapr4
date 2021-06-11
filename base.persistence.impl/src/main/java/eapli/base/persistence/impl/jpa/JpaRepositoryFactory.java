package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.repository.*;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.repository.FormRepository;
import eapli.base.ordermanagement.repository.DraftRepository;
import eapli.base.ordermanagement.repository.RequestRepository;
import eapli.base.taskmanagement.repositories.AutomaticTaskRepository;
import eapli.base.taskmanagement.repositories.ManualTaskRepository;
import eapli.base.teamManagement.repositories.TeamRepository;
import eapli.base.teamManagement.repositories.TeamTypeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ActivityRepository activity() {
		return new JpaActivityRepository();
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public TeamRepository team() {
		return new JpaTeamRepository();
	}

	@Override
	public JpaCatalogRepository catalogs() {
		return new JpaCatalogRepository();
	}

	@Override
	public FormRepository forms() {
		return new JpaFormRepository(Application.settings().getPersistenceUnitName());
	}

	public FormRepository forms(final TransactionalContext autoTx) {
		return new JpaFormRepository(autoTx);
	}

	@Override
	public ServiceRepository services() {
		return new JpaServiceRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SequenceRepository sequences() {
		return new JpaSequenceRepository(Application.settings().getPersistenceUnitName());
	}

	public ServiceRepository services(final TransactionalContext autoTx) {
		return new JpaServiceRepository(autoTx);
	}


	@Override
	public CriticalityLevelRepository criticalityLevels() {
		return new JpaCriticalitylevelRepository();
	}

	public TeamTypeRepository teamTypes(TransactionalContext autoTx) {
		return new JpaTeamTypesRepository(autoTx);
	}

	@Override
	public TeamTypeRepository teamTypes() {
		return new JpaTeamTypesRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public JpaFunctionRepository functions(final TransactionalContext autoTx) {
		return new JpaFunctionRepository(autoTx);
	}

	@Override
	public JpaFunctionRepository functions() {
		return new JpaFunctionRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public AutomaticTaskRepository AutomaticTasks(final TransactionalContext autoTx) {
		return new JpaAutomaticTaskRepository(autoTx);
	}

	@Override
	public AutomaticTaskRepository AutomaticTasks() {
		return new JpaAutomaticTaskRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public ManualTaskRepository manualTasks(final TransactionalContext autoTx) {
		return new JpaManualTaskRepository(autoTx);
	}

	@Override
	public ManualTaskRepository manualTasks() {
		return new JpaManualTaskRepository(Application.settings().getPersistenceUnitName());
	}

	public DraftRepository drafts(){
		return new JpaDraftRepository(Application.settings().getPersistenceUnitName());
	}

	public DraftRepository drafts(final TransactionalContext autoTx){
		return new JpaDraftRepository(autoTx);
	}

	public RequestRepository requests(){
		return new JpaRequestRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public WorkflowRepository workflow() {
		return new JpaWorkflowRepository(Application.settings().getPersistenceUnitName());
	}

	public RequestRepository requests(final TransactionalContext autoTx){
		return new JpaRequestRepository(autoTx);
	}


	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(), Application.settings().getExtendedPersistenceProperties());
	}
}
