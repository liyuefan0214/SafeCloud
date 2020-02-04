package com.liyuefan.cloud.controller;

import com.liyuefan.cloud.pojo.Message;
import com.liyuefan.cloud.pojo.Users;
import com.liyuefan.cloud.service.UsersService;
import com.liyuefan.cloud.utils.email.SendMail;
import com.liyuefan.cloud.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author liyuefan
 * @Date ${Date}
 * Description
 */
@Controller
public class UsersController {

    @Autowired
    UsersService usersService;
    @Autowired
    RedisUtil redisUtil;

    //登陆
    @RequestMapping(value = "/login")
    @ResponseBody
    public Message login(Users users, String checkcode) {
        List<Users> list = usersService.UserLogin(users);

        if (list.isEmpty()) {
            return Message.fail().add("ErrorInfo", "用户名或密码错误");
        } else {
            Users users1 = list.get(0);
            users1.setPassword("/");
            return Message.success().add("usersInfo", users1);
        }
    }

    //注册
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Message regist(@Validated Users users, BindingResult bindingResult, String emailcode) {
        if (emailcode.equals(redisUtil.get(users.getEmail()))) {
            if (bindingResult.hasErrors()) {//如果结果集中有错误信息
                //获取所有错误信息
                List<ObjectError> errors = bindingResult.getAllErrors();
                for (ObjectError error : errors) {
                    System.out.println(error.getDefaultMessage());
                }
                return Message.fail().add("Errors", errors);
            } else {
                boolean ifExist = usersService.ifUserNameExist(users);
                if (ifExist == true) {
                    return Message.fail().add("Error", "用户名已存在");
                }
                usersService.UserRegist(users);
                return Message.success().add("registInfo", "注册成功");
            }
        } else {
            return Message.fail().add("Error", "邮箱验证码错误");
        }
    }

    //发送邮件
    @RequestMapping("/sendMail")
    @ResponseBody
    public Message sendMail(String email) {
        SendMail operation = new SendMail();
        String user = "liyuefan0214@163.com";
        String password = "aptx4869";
        String host = "smtp.163.com";
        String from = "liyuefan0214@163.com";
        String to = email;// 收件人
        String subject = "邮箱验证码";
        //邮箱内容
        StringBuffer sb = new StringBuffer();
        String code = (int) Math.floor(Math.random() * 999999) + "";
        sb.append("<!DOCTYPE>" + "<div bgcolor='#f1fcfa'   style='border:1px solid #d9f4ee; font-size:14px; line-height:22px; color:#005aa0;padding-left:1px;padding-top:5px;   padding-bottom:5px;'><span style='font-weight:bold;'>温馨提示：</span>"
                + "<div style='width:950px;font-family:arial;'>您的验证码为：<br/><h2 style='color:green'>" + code + "</h2><br/>本邮件由系统自动发出，请勿回复。<br/>谢谢。<br/>西柚云盘有限公司</div>"
                + "</div>");
        try {
            operation.sendMail(user, password, host, from, to,
                    subject, sb.toString());
            redisUtil.set(email, code);//添加redis缓存
            redisUtil.expire(email, 90);//设置验证码失效时间为90秒
        } catch (Exception e) {
            e.printStackTrace();
            return Message.fail().add("EmailInfo", "发送失败");
        }
        return Message.success().add("EmailInfo", "发送成功");
    }


//    //给前端发送验证码
//    @RequestMapping("/getCheckCode")
//    @ResponseBody
//    public Message getCheckCode() {
//        ValidateCodeUtil.Validate code = ValidateCodeUtil.getRandomCode();
//        //存数据库操作(未实现)
//        String base64Str = code.getBase64Str();
//        return Message.success().add("checkcode", base64Str);
//    }
//
//    //验证码校验
//    @RequestMapping("/check")
//    @ResponseBody
//    public Message check(String checkcode) {
//
//        if (checkcode.isEmpty()) {
//            return Message.fail().add("checkResult", "请输入验证码");
//        } else if (checkcode.equals(scheckcode)) {
//            return Message.success().add("checkResult", "验证成功");
//        } else {
//            return Message.fail().add("checkResult", "验证码错误");
//        }
//    }

}
