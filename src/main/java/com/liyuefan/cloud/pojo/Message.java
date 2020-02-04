package com.liyuefan.cloud.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liyuefan
 * @Date ${Date}
 * Description
 */
public class Message {

    private int code;
    private String message;
    private Map<String,Object> usersMessage = new HashMap<String,Object>();

    public static Message success(){
        Message result = new Message();
        result.setCode(200);
        result.setMessage("处理成功");
        return  result;
    }

    public static Message fail(){
        Message result = new Message();
        result.setCode(500);
        result.setMessage("处理失败");
        return  result;
    }

    public Message add(String key, Object value){
        this.getUsersMessage().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getUsersMessage() {
        return usersMessage;
    }

    public void setUsersMessage(Map<String, Object> usersMessage) {
        this.usersMessage = usersMessage;
    }
}
