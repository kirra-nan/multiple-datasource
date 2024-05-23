package com.example.kirracloud.controller;

import com.example.kirracloud.entity.UserInfo;
import com.example.kirracloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-info")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    @GetMapping("/{id}")
    @ResponseBody
    public UserInfo getUserInfo(@PathVariable("id") String id){
        return service.selectUser(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public int save(@RequestBody UserInfo userInfo){
        return service.save(userInfo);
    }

    @PostMapping("/save1")
    @ResponseBody
    public int save1(){
        return service.save1();
    }
}
