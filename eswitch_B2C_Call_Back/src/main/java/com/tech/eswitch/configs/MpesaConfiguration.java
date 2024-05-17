package com.tech.eswitch.configs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")
public class MpesaConfiguration {

    private String consumerKey;
    private String consumerSecret;
    private String grantType;
    private String oauthEndpoint;
    private String registerUrlEndpoint;
    private String simulateTransactionEndpoint;
    private String shortCode;
    private String confirmationURL;
    private String validationURL;
    private String responseType;

    @Override
    public String toString() {
        return String.format("{consumerKey='%s', consumerSecret='%s', grantType='%s', oauthEndpoint='%s'}",
                consumerKey, consumerSecret, grantType, oauthEndpoint);
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getOauthEndpoint() {
        return oauthEndpoint;
    }

    public void setOauthEndpoint(String oauthEndpoint) {
        this.oauthEndpoint = oauthEndpoint;
    }

    public String getRegisterUrlEndpoint() {
        return registerUrlEndpoint;
    }

    public void setRegisterUrlEndpoint(String registerUrlEndpoint) {
        this.registerUrlEndpoint = registerUrlEndpoint;
    }

    public String getSimulateTransactionEndpoint() {
        return simulateTransactionEndpoint;
    }

    public void setSimulateTransactionEndpoint(String simulateTransactionEndpoint) {
        this.simulateTransactionEndpoint = simulateTransactionEndpoint;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getConfirmationURL() {
        return confirmationURL;
    }

    public void setConfirmationURL(String confirmationURL) {
        this.confirmationURL = confirmationURL;
    }

    public String getValidationURL() {
        return validationURL;
    }

    public void setValidationURL(String validationURL) {
        this.validationURL = validationURL;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}
