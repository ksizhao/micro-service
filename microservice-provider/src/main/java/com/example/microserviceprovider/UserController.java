package com.example.microserviceprovider;

import com.example.microserviceprovider.common.JsonResult;
import com.example.microserviceprovider.dao.UserMapper;
import com.example.microserviceprovider.entry.User;
import com.example.microserviceprovider.resp.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    //http://localhost:8888/getUser?username=xiaoli2
    @GetMapping("/getUser")
    public String getUser(String username){
        User user =userMapper.findUserByUsername(username);
//        UserResp resp=new UserResp();
//        resp.setUserName(user.getUser_name());
//        resp.setUserPassword(user.getUser_password());
//        JsonResult respJsonResult=new JsonResult("操作成功","0",resp);
        return  user!=null ? user.getUser_name()+"的密码是："+user.getUser_password():"用户不存在";
    }

    //http://localhost:8888/updateUser?username=xiaoli2&password=123
    @RequestMapping("/updateUser")
    public String updateUser(String password,String username){
        User user = new User(username,password);
        userMapper.updateUserByUsername(user);
        return "success!";
    }


    //http://localhost:8888/addUser?username=xiaoli2&password=123
    @RequestMapping("/addUser")
    public String addUser(String username,String password){
        User user = new User(username,password);
        userMapper.saveUser(user);
        return "success!";
    }

    //http://localhost:8888/addUser?username=xiaoli2
    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        userMapper.deleteUserByUsername(username);
        return "success!";
    }

    //http://localhost:8888/getUserList
    @RequestMapping("/getUserList")
    public List getUserList(String username, String password){
        return userMapper.getUserList();
    }
}