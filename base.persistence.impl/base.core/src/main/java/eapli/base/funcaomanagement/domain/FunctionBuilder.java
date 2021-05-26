package eapli.base.funcaomanagement.domain;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

public class FunctionBuilder implements DomainFactory<Function> {

    private Designation functionname;
    private Description functiondescription;

    public FunctionBuilder withFunctionName(Designation functionname){
        this.functionname = functionname;
        return this;
    }

    public FunctionBuilder withFunctionDescription(Description functiondescription){
        this.functiondescription = functiondescription;
        return this;
    }

    @Override
    public Function build() {
        return new Function(functionname,functiondescription);
    }
}
