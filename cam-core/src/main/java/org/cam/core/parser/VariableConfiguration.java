package org.cam.core.parser;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class VariableConfiguration {

    private Map<String,Variable> variablePool ;

    public VariableConfiguration(List<Variable> variables){
        variables = Lists.newArrayList();
    }

    public void setVariables(List<Variable> variables) {
    }

    public Variable getVariable(String varName){
        return variablePool.get(varName);
    }

}
