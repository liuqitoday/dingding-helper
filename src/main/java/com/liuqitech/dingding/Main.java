package com.liuqitech.dingding;

import com.liuqitech.dingding.service.PunchInService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqitoday@163.com
 */
public class Main {

  public static void main(String[] args) {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    try {
      long period = 1000 * 60 * 60 * 24;

      SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      Date targetDate = sdf1.parse(sdf2.format(new Date()) + " 08:06:21");
      long initialDelay = targetDate.getTime() - System.currentTimeMillis();
      initialDelay = initialDelay > 0 ? initialDelay : period + initialDelay;

      scheduledExecutorService
          .scheduleAtFixedRate(new PunchInService(), initialDelay, period, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
