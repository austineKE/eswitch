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

    @GetMapping(path = "/api/v1/token", produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken() {
        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    @GetMapping(path = "/api/v1/register", produces = "application/json")
    public ResponseEntity<RegisterUrlResponse> registerUrl() {
//        return ResponseEntity.ok(darajaApi.registerUrl());
        return null;
    }

    @GetMapping(path = "/api/v1/status", produces = "application/json")
    public ResponseEntity<Object> getTransactionStatus() {
        return ResponseEntity.ok(b2CStatusAndBalance.getTransactionStatus());
    }

    @GetMapping(path = "/api/v1/balance", produces = "application/json")
    public ResponseEntity<Object> getAccountBalance() {
        return ResponseEntity.ok(b2CStatusAndBalance.getAccountBalance());
    }

    @PostMapping(path = "/api/v1/c2b", produces = "application/json")
    public ResponseEntity<SimulateTransactionResponse> simulateB2CTransaction(@RequestBody SimulateTransactionRequest simulateTransactionRequest) {
       // return ResponseEntity.ok(darajaApi.simulateC2BTransaction(simulateTransactionRequest));
        return null;
    }

    /**
     * Transaction validation -accept/decline transaction
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/validation", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public ValidationResult validation(@RequestBody TransactionRequest request) {
        return validate.validate(request);
    }

    /**
     * \
     * Transaction confirmation -cash received
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/confirmation", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public TransactionResponseConfirmation confirmation(@RequestBody TransactionRequest request) {
        return confirm.confirm(request);
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

    /**
     * queue timeout transactions
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/queue", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void sendMoneyQueue(@RequestBody Object request) {
        //Todo -delete this part --------------------
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            System.out.println(ow.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Todo -delete this part --------------------
        timedOutTransactions.addToQueue(request);
    }

    /**
     * Send money transaction result -success result
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/result", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void sendMoneyResult(@RequestBody SendResult request) {
        sendMoneyResult.sendMoneyResult(request);
    }

}
