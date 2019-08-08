package com.wz.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class testController {

    @RequestMapping("test")
    public String test(){

        return "你好世界";
    }

    @RequestMapping("/*")
    public String IpAddr(HttpServletRequest request){
        String ip = "服务地址 : ";
        String remoteAddr = request.getServerName();
        int serverPort = request.getServerPort();
        ip += remoteAddr+" --端口:"+serverPort;
        return ip;
    }
}
