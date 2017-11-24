package com.hirisun.springbootdemo.service.impl;

import com.hirisun.springbootdemo.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@ConfigurationProperties
public class ScheduleServiceImpl implements ScheduleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Override
    @Scheduled(fixedDelayString = "${scheduleService.getInfoOne.fixedRateString}")
    public String getInfoOne() {
        LOGGER.debug("每隔{}毫秒执行一次！",6000);
        return null;
    }

    @Override
    @Scheduled(cron = "${scheduleService.getInfoTwo.cron}")
    public String getInfoTwo() {
        LOGGER.debug(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"执行！");
        return null;
    }
}
