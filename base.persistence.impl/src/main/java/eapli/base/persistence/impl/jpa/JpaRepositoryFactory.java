package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.base.catalogmanagement.repository.CriticalityLevelRepository;
import eapli.base.catalogmanagement.repository.ServiceRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.ordermanagement.domain.repository.FormRepository;
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
	public CatalogRepository catalogs() {
		return new JpaCatalogRepository(Application.settings().getPersistenceUnitName());
	}


	public CatalogRepository catalogs(final TransactionalContext autoTx) {
		return new JpaCatalogRepository(autoTx);
	}

	@Override
	public FormRepository forms() {
		return new JpaFormRepository();
	}

	@Override
	public ServiceRepository services() {
		return new JpaServiceRepository();
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
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(), Application.settings().getExtendedPersistenceProperties());
	}
}
