package com.tech.eswitch.dto.sendResult;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceData {
    @JsonProperty("ReferenceItem")
    private ReferenceItem referenceItem;

    public ReferenceItem getReferenceItem() {
        return referenceItem;
    }

    public void setReferenceItem(ReferenceItem referenceItem) {
        this.referenceItem = referenceItem;
    }
}
