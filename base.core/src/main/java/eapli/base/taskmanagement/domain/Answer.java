package eapli.base.taskmanagement.domain;

import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Answer implements ValueObject, Serializable {
    private List<String> respostas = new ArrayList<>();

    public Answer(List<String> respostas) {
        this.respostas = respostas;
    }

    public Answer() {
    }

    public List<String> getResposta() {
        return respostas;
    }

    public void addResposta(String resposta){
        this.respostas.add(resposta);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "resposta='" + respostas.toString() + '\'' +
                '}';
    }
}