package com.tech.eswitch.interfaces;


import com.tech.eswitch.dto.AccessTokenResponse;
import com.tech.eswitch.dto.RegisterUrlResponse;
import com.tech.eswitch.dto.SimulateTransactionRequest;
import com.tech.eswitch.dto.SimulateTransactionResponse;

public interface DarajaApi {

    /**
     * @return Returns Daraja API Access Token Response
     */
    AccessTokenResponse getAccessToken();

    RegisterUrlResponse registerUrl();

    SimulateTransactionResponse simulateC2BTransaction(SimulateTransactionRequest simulateTransactionRequest);


}
