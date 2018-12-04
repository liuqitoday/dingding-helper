package com.liuqitech.dingding.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author liuqitoday@163.com
 */
public class EmailUtil {

  //TODO 邮件发送账号
  private static final String SENDER_USERNAME = "liuqitoday@163.com";
  //TODO 邮件发送密码
  private static final String SENDER_PASSWORD = "xxxxxxxx";

  public static void sendAsHtml(String to, String title, String html) throws MessagingException {
    System.out.println("Sending email to " + to);

    Session session = createSession();

    //create message using session
    MimeMessage message = new MimeMessage(session);
    prepareEmailMessage(message, to, title, html);

    //sending message
    Transport.send(message);
  }

  private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
      throws MessagingException {
    message.setContent(html, "text/html; charset=utf-8");
    message.setFrom(new InternetAddress(SENDER_USERNAME));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    message.setSubject(title);
  }

  private static Session createSession() {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.ssl.enable", "true");
    props.put("mail.debug", "false");
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.timeout", "10000");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.host", "smtp.163.com");
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(SENDER_USERNAME, SENDER_PASSWORD);
      }
    });
    return session;
  }

  public static void main(String[] args) throws MessagingException {
    EmailUtil.sendAsHtml("liuqitoday@163.com",
        "Test email",
        "<h2>Java Mail Example</h2><p>hi there!</p>");
  }
}
