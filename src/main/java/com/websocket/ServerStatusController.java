package com.websocket;

import com.bean.ServerStatus;
import com.bean.ReceiveBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller
@EnableScheduling
public class ServerStatusController  {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    //当浏览器向服务端发送请求时，通过@MessageMapping映射的地址，类似于@RequestMapping
    @MessageMapping("/serverinfo")
    @SendTo("/ws-be/serverinfo") //广播所有用户
    //传递的参数会自动的被注入到userbean中
    public ArrayList<ServerStatus> serverStatus (ReceiveBean receiveBean) throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        // 返回值被广播给所有订户，如@SendTo注释中所指定的"/receive/message" 。请注意，来自输入消息的名称已被清理，因为在这种情况下，它将被回显并重新呈现在客户端的浏览器DOM中。
        ArrayList<ServerStatus> list = new ArrayList<>();
        int length = 0;
        if (receiveBean.getTime().equals("mouth")) {
            length = 150;
        } else if (receiveBean.getTime().equals("day")){
            length = 100;
        } else if (receiveBean.getTime().equals("hours")) {
            length = 50;
        } else {
            length = 150;
        }
        for (int i = 0; i< length ; i++) {
            list.add(new ServerStatus(
                    (int) (Math.random() * 10 + 50),
                    (int) (Math.random() * 30 ),
                    (int) (Math.random() * 40 + 500),
                    new Date().getTime() + i * 1000,
                    (int) (Math.random() * 30 + 1000),
                    (int) (Math.random() * 70 + 505),
                    (int) (Math.random() * 90 + 2000),
                    (int) (Math.random() * 100 + 50),
                    (int) (Math.random() * 10 + 3000),
                    "Windows 10"));
        }
        return list;
    }
    @Scheduled(fixedRate = 5000) //每个5秒提取一次
    @SendTo("/ws-be/serverinfo") //广播所有用户
    public Object sendAllMessage () {
        // 发现消息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/ws-be/serverinfo", new ServerStatus(
                (int) (Math.random() * 10 + 50),
                (int) (Math.random() * 30 ),
                (int) (Math.random() * 40 + 500),
                new Date().getTime(),
                (int) (Math.random() * 30 + 1000),
                (int) (Math.random() * 70 + 505),
                (int) (Math.random() * 90 + 2000),
                (int) (Math.random() * 100 + 50),
                (int) (Math.random() * 10 + 3000),
                "Windows 10"));
        return "callback";
    }
}
