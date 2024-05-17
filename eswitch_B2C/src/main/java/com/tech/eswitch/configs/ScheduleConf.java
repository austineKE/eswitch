package com.tech.eswitch.configs;

import org.springframework.stereotype.Component;

@Component
public class ScheduleConf {
    boolean proceed=true;

    public boolean isProceed() {
        return proceed;
    }

    public void setProceed(boolean proceed) {
        this.proceed = proceed;
    }
}
