//package com.liyuefan.cloud.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.liyuefan.cloud.pojo.Message;
//import com.liyuefan.cloud.service.CDsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @Author liyuefan
// * @Date ${Date}
// * Description
// */
//@Controller
//public class CDsController {
//
//    @Autowired
//    CDsService cDsService;
//
//
//    @RequestMapping("/getCDs")
//    @ResponseBody
//    public Message getCDs(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
//        PageHelper.startPage(pageNum,8);
//        List<CDs> allCDs = cDsService.getAllCDs();
//
//        PageInfo pageInfo = new PageInfo(allCDs,5);
//        return Message.success().add("pageInfo",pageInfo);
//    }
//
//}
