package com.tech.eswitch.dto.sendSuccess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParameter {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Value")
    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
