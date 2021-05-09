package eapli.base.teamManagement.repositories;


import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;


import java.util.Optional;

public interface TeamTypeRepository extends DomainRepository<Uniquecode, TeamType>

{

    /**
     * returns the teamtype whose color is given
     *
     * @param color
     *            the color to search for
     * @return
     */
    Optional<TeamType> findByColor(Description color);

    /**
     * returns the all the teamtypes that exists.
     *
     *
     * @return
     */

    public Iterable<TeamType> findAll();


}

