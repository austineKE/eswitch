package com.tech.eswitch.dto.sendSuccess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendSuccess {
    @JsonProperty("Result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
