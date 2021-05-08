package eapli.base.catalogmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Keyword implements ValueObject, Serializable {

    private String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    public Keyword() {
    }

    @Override
    public String toString() {
        return "Keyword: " + this.keyword + "\n";
    }
}
