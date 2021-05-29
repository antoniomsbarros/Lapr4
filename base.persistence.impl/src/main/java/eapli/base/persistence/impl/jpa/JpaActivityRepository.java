package eapli.base.persistence.impl.jpa;

import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.catalogmanagement.repository.ActivityRepository;

import javax.persistence.TypedQuery;

public class JpaActivityRepository extends BasepaRepositoryBase<Activity,Long,Long>  implements ActivityRepository {
    JpaActivityRepository() {
        super("identifier");
    }


    @Override
    public Iterable<Activity> getAtivitiebyCollaborator(Integer RESPONSAVEL_NUMBER) {
         TypedQuery<Activity> query = createQuery("Select a from eapli.base.catalogmanagement.domain.Activity a INNER JOIN " +
                 "eapli.base.catalogmanagement.domain.Responsable r ON r.id=a.responsable where r.responsavel.mecanographicNumber.number=: number", Activity.class);

        query.setParameter("number",String.valueOf(RESPONSAVEL_NUMBER));
        return query.getResultList();
    }
}
