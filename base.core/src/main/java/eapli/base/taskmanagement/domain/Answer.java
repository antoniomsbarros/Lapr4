package eapli.base.taskmanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;

import java.io.Serializable;

public class Answer implements ValueObject, Serializable {
    private String resposta;

    public Answer(String resposta) {
        this.resposta = resposta;
    }

    public Answer() {
    }

    public String getResposta() {
        return resposta;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "resposta='" + resposta + '\'' +
                '}';
    }
}
