package eapli.base.teamManagement.repositories;


import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.teamManagement.domain.TeamType;
import eapli.base.teamManagement.domain.Uniquecode;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.Description;
import org.springframework.data.jpa.repository.Query;


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
    @Query(value = "SELECT color FROM TeamType WHERE color = :color",nativeQuery = true)





    /**
     * returns the all the teamtypes that exists.
     *
     *
     * @return
     */

    public Iterable<TeamType> findAll();


}

