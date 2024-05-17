package com.tech.eswitch.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tech.eswitch.configs.ScheduleConf;
import com.tech.eswitch.dto.*;
import com.tech.eswitch.dto.b2c.ValidationResult;
import com.tech.eswitch.dto.sendResult.SendResult;
import com.tech.eswitch.interfaces.*;
import com.tech.eswitch.services.B2CStatusAndBalanceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@EnableScheduling
@RestController
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    private Validate validate;
    private Confirm confirm;
    private SendMoney sendMoney;
    private SendMoneyResult sendMoneyResult;
    private TimedOutTransactions timedOutTransactions;
    private ScheduleConf scheduleConf;
    private final DarajaApi darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;
    private B2CStatusAndBalance b2CStatusAndBalance;

    public HomeController(final Validate validate, final Confirm confirm, final SendMoney sendMoney
            , TimedOutTransactions timedOutTransactions, SendMoneyResult sendMoneyResult,
                          ScheduleConf scheduleConf,
                          DarajaApi darajaApi,
                          AcknowledgeResponse acknowledgeResponse, B2CStatusAndBalance b2CStatusAndBalance) {
        this.validate = validate;
        this.confirm = confirm;
        this.sendMoney = sendMoney;
        this.sendMoneyResult = sendMoneyResult;
        this.timedOutTransactions = timedOutTransactions;
        this.scheduleConf = scheduleConf;
        this.darajaApi = darajaApi;
        this.b2CStatusAndBalance = b2CStatusAndBalance;
        this.acknowledgeResponse = acknowledgeResponse;
    }

    @GetMapping(path = "/api/v1/token_b2c", produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    /**
     * Send money
     */
    @Scheduled(cron = "&{cron:*/1 * * * * ?}")
    public void sendMoney() {
        if (scheduleConf.isProceed()) {
           sendMoney.sendMoney();
        }
    }

}
