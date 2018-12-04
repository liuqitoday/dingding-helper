package com.liuqitech.dingding.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author liuqitoday@163.com
 */
public class CmdUtil {

  /**
   * 执行cmd命令
   */
  public static String executeCmd(String command) {
    StringBuilder result = new StringBuilder();
    Runtime runtime = Runtime.getRuntime();
    try {
      Process process = runtime.exec(command);
      BufferedReader bReader = new BufferedReader(
          new InputStreamReader(process.getInputStream(), "gbk"));
      String line;
      while ((line = bReader.readLine()) != null) {
        result.append(line).append("\r\n");
      }
      process.waitFor();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(result.toString());
    return result.toString();
  }

}
