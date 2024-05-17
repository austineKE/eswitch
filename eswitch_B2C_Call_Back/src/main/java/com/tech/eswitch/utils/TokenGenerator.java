package com.tech.eswitch.utils;


import com.tech.eswitch.dto.AccessTokenResponse;
import com.tech.eswitch.interfaces.DarajaApi;
import org.springframework.stereotype.Service;


@Service
public class TokenGenerator {
    private DarajaApi darajaApi;

    public TokenGenerator(DarajaApi darajaApi) {
        this.darajaApi = darajaApi;
    }

    public String getToken() throws Exception {
        AccessTokenResponse accessTokenResponse = darajaApi.getAccessToken();
        return accessTokenResponse.getAccessToken();
    }
}
