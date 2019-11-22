package com.example.helloworld.controller;


import com.example.helloworld.constant.MqConstant;
import com.example.helloworld.dao.UserMapper;
import com.example.helloworld.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AmqpTemplate amqpTemplate; 

    @RequestMapping("sayHello")
    public String sayHello()
    {
        List<User> users =this.userMapper.selectAll();
        //System.out.println(user.);
        return "sfe";
    }
    @RequestMapping("queue")
    public String rabbitQueue()
    {
        amqpTemplate.convertAndSend("test-jpl","test");
        //amqpTemplate.
        //System.out.println(user.);
        return "sfe";
    }
    @RequestMapping("fanoutSend")
    public String fanoutSend()
    {
        amqpTemplate.convertAndSend(MqConstant.exchangeName,"","testexchange");
        //System.out.println(user.);
        return "sfe";
    }
}
