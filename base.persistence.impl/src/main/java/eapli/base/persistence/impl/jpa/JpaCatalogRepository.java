package eapli.base.persistence.impl.jpa;

import eapli.base.catalogmanagement.domain.Catalog;
import eapli.base.catalogmanagement.repository.CatalogRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

class JpaCatalogRepository extends BasepaRepositoryBase<Catalog,Long,Designation> implements CatalogRepository {


    JpaCatalogRepository(){
        super("name");
    }

    @Override
    public Optional<Catalog> ofIdentity(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean containsOfIdentity(Long id) {
        return false;
    }

    @Override
    public boolean contains(Catalog entity) {
        return false;
    }

    @Override
    public void deleteOfIdentity(Long entityId) {

    }

    @Override
    public void remove(Catalog entity) {

    }

    @Override
    public void removeOfIdentity(Long entityId) {

    }

    @Override
    public void forEach(Consumer<? super Catalog> action) {

    }

    @Override
    public Spliterator<Catalog> spliterator() {
        return null;
    }
}
