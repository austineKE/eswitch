package com.tech.eswitch.dto.sendResult;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendResult {
    @JsonProperty("Result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
