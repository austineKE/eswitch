package com.tech.eswitch.dto.sendFailed;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SendError {
    @JsonProperty("Result")
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
