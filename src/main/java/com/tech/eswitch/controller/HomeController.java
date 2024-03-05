package com.tech.eswitch.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tech.eswitch.dto.TransactionRequest;
import com.tech.eswitch.dto.TransactionResponseConfirmation;
import com.tech.eswitch.dto.TransactionResponseValidation;
import com.tech.eswitch.dto.sendSuccess.SendSuccess;
import com.tech.eswitch.interfaces.Confirm;
import com.tech.eswitch.interfaces.SendMoney;
import com.tech.eswitch.interfaces.Validate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@EnableScheduling
@RestController
public class HomeController {
    private Validate validate;
    private Confirm confirm;
    private SendMoney sendMoney;

    public HomeController(final Validate validate, final Confirm confirm, final SendMoney sendMoney) {
        this.validate = validate;
        this.confirm = confirm;
        this.sendMoney = sendMoney;
    }

    /**
     * Transaction validation -accept/decline transaction
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/validation", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public TransactionResponseValidation validation(@RequestBody TransactionRequest request) {
        //Todo -delete this part --------------------
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            System.out.println(ow.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Todo -delete this part --------------------
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
        //Todo -delete this part --------------------
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            System.out.println(ow.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Todo -delete this part --------------------
        return confirm.confirm(request);
    }

    /**
     * Send money
     */
    @Scheduled(cron = "&{cron:*/1 * * * * ?}")
    public void sendMoney() {
//        sendMoney.sendMoney();
    }

    /**
     * Payment queue for timeout
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/queue", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Object sendMoneyQueue(@RequestBody TransactionRequest request) {
        //Todo -delete this part --------------------
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            System.out.println(ow.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Todo -delete this part --------------------
        return confirm.confirm(request);
    }

    /**
     * Send money transaction result -success result
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/result", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public void sendMoneyResult(@RequestBody SendSuccess request) {
        //Todo -delete this part --------------------
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            System.out.println(ow.writeValueAsString(request));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Todo -delete this part --------------------

    }

}
