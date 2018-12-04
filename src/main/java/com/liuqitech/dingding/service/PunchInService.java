package com.liuqitech.dingding.service;

import com.liuqitech.dingding.util.CmdUtil;
import com.liuqitech.dingding.util.EmailUtil;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqitoday@163.com
 */
public class PunchInService implements Runnable {

  @Override
  public void run() {
    try {
      int min = 0;
      int max = 20;
      int sleepTime = new Random().nextInt(max) % (max - min + 1) + min;
      System.out.println("延迟" + sleepTime + "分钟执行");
      TimeUnit.MINUTES.sleep(sleepTime);
      // 点亮屏幕
      CmdUtil.executeCmd("adb shell input keyevent 26");
      TimeUnit.SECONDS.sleep(1);
      // 解锁
      CmdUtil.executeCmd("adb shell input swipe 360 1030 360 660");
      TimeUnit.SECONDS.sleep(2);
      // 打开钉钉
      CmdUtil.executeCmd("adb shell monkey -p com.alibaba.android.rimet -c android.intent.category.LAUNCHER 1");
      TimeUnit.SECONDS.sleep(2);
      // 点击密码框
      CmdUtil.executeCmd("adb shell input tap 91 602");
      TimeUnit.SECONDS.sleep(2);
      // 输入密码
      // TODO 登陆密码
      CmdUtil.executeCmd("adb shell input text \"xxxxxxxx\"");
      TimeUnit.SECONDS.sleep(2);
      // 点击登录
      CmdUtil.executeCmd("adb shell input tap 631 731");
      TimeUnit.SECONDS.sleep(4);
      // 点击工作
      CmdUtil.executeCmd("adb shell input tap 362 1218");
      TimeUnit.SECONDS.sleep(3);
      // 点击考勤打卡
      CmdUtil.executeCmd("adb shell input tap 636 1043");
      TimeUnit.SECONDS.sleep(3);
      // 点击上班打卡
      CmdUtil.executeCmd("adb shell input tap 364 512");
      // 发送通知
      //TODO 收件邮箱
      EmailUtil.sendAsHtml("liuqitoday@163.com",
          "钉钉签到通知",
          "<p>打卡完成，请检查!</p>");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
