package com.tech.eswitch.dto;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class AcknowledgeResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
