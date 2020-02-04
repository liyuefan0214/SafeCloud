package com.liyuefan.cloud.utils.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @Author liyuefan
 * @Date
 * Description 发邮件者信息
 */
public class AuthorInfo  extends Authenticator {

        public static String USERNAME = "liyuefan0214@163.com";
        public static String PASSWORD = "aptx4869";

        public AuthorInfo() {
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USERNAME, PASSWORD);
        }

}
