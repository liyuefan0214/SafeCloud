package com.liyuefan.cloud.service;

import com.liyuefan.cloud.dao.UsersMapper;
import com.liyuefan.cloud.pojo.Users;
import com.liyuefan.cloud.pojo.UsersExample;
import com.liyuefan.cloud.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @Author liyuefan
 * @Date ${Date}
 * Description
 */
@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    //验证用户登录信息
    public List<Users> UserLogin(Users users) {

        List<Users> list = null;

        UsersExample usersExample = new UsersExample();
        usersExample.setOrderByClause("username asc"); //asc升序,desc降序排列
        usersExample.setDistinct(false); //去除重复,true是选择不重复记录,false反之
        UsersExample.Criteria criteria = usersExample.createCriteria(); //构造自定义查询条件
        criteria.andUsernameEqualTo(users.getUsername());
        criteria.andPasswordEqualTo(users.getPassword());

        list = usersMapper.selectByExample(usersExample);

        return list;
    }

    //将用户注册信息存入数据库
    public void UserRegist(Users users) {
        String password = users.getPassword();
        String md5 = MD5Utils.stringToMD5(password);
        users.setPassword(md5);
        users.setCreateTime(new Date());
        users.setUpdateTime(new Date());
        usersMapper.insertSelective(users);
    }

    //检验用户名是否存在
    public boolean ifUserNameExist(Users users) {
        List<Users> list = null;

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(users.getUsername());

        list = usersMapper.selectByExample(example);
        if (list.isEmpty() || list == null) {
            return false;
        } else {
            return true;
        }
    }

}
