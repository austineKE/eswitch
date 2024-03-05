package com.tech.eswitch.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.squareup.okhttp.*;
import com.tech.eswitch.dto.send.SendMoneyRequest;
import com.tech.eswitch.interfaces.SendMoney;
import com.tech.eswitch.utils.Properties;
import com.tech.eswitch.utils.PropertyReader;
import org.springframework.stereotype.Service;

@Service
public class SendMoneyImpl implements SendMoney {
    @Override
    public void sendMoney() {

        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            SendMoneyRequest sendMoneyRequest = new SendMoneyRequest();
            sendMoneyRequest.setAmount("10");
            sendMoneyRequest.setPartyB("254708374149");
            sendMoneyRequest.setOriginatorConversationID("1");
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(sendMoneyRequest);
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url("https://sandbox.safaricom.co.ke/mpesa/b2c/v3/paymentrequest")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer 6WRVg7GTaXOSeAXqwcLAFNPIKu7x")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
