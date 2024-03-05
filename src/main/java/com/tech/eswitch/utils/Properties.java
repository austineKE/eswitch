package com.tech.eswitch.utils;

public final class Properties {
    public static String getInitiator() {
        return PropertyReader.getProperty("eSwitch.send.money.initiatorName");
    }

    public static String getCommandId() {
        return PropertyReader.getProperty("eSwitch.send.money.commandID");
    }

    public static String getPartyA() {
        return PropertyReader.getProperty("eSwitch.send.money.partyA");
    }

    public static String getRemarks() {
        return PropertyReader.getProperty("eSwitch.send.money.remarks");
    }

    public static String getQueueTimeOutURL() {
        return PropertyReader.getProperty("eSwitch.send.money.queueTimeOutURL");
    }

    public static String getResultURL() {
        return PropertyReader.getProperty("eSwitch.send.money.resultURL");
    }

    public static String getOccasion() {
        return PropertyReader.getProperty("eSwitch.send.money.occasion");
    }

    public static String getSecurityCredential() {
        return PropertyReader.getProperty("eSwitch.send.money.securityCredential");
    }
}
