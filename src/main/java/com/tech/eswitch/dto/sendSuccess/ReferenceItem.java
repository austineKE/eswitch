package com.tech.eswitch.dto.sendSuccess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceItem {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("Value")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
