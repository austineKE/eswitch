package com.tech.eswitch.dto.sendResult;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResultParameters {
    @JsonProperty("ResultParameter")
    private ArrayList<ResultParameter> resultParameter;

    public ArrayList<ResultParameter> getResultParameter() {
        return resultParameter;
    }

    public void setResultParameter(ArrayList<ResultParameter> resultParameter) {
        this.resultParameter = resultParameter;
    }
}
