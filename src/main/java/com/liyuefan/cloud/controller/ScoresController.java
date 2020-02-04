//
//package com.liyuefan.cloud.controller;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.liyuefan.cloud.pojo.Message;
//import com.liyuefan.cloud.service.ScoresService;
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
//
//@Controller
//public class ScoresController {
//
//    @Autowired
//    ScoresService scoresService;
//
//    @RequestMapping("/getScores")
//    @ResponseBody
//    public Message getScores(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
//        PageHelper.startPage(pageNum,8);//每次查几条
//        List<Scores> allScores = scoresService.getAllScores();
//        PageInfo pageInfo = new PageInfo(allScores,5);//每次显示几页
//        return Message.success().add("pageInfo",pageInfo);
//    }
//
//}
//
