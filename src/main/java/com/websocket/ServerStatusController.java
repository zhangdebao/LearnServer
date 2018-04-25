package com.websocket;

import com.bean.ServerStatus;
import com.bean.ReceiveBean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ServerStatusController  {
    //当浏览器向服务端发送请求时，通过@MessageMapping映射的地址，类似于@RequestMapping
    @MessageMapping("/serverStatus")
    @SendTo("/receive/message") //广播所有用户
    //传递的参数会自动的被注入到userbean中
    public ServerStatus serverStatus (ReceiveBean receiveBean) throws InterruptedException {
//        Thread.sleep(1000); // 使线程休眠1秒来模拟处理延迟
        // 返回值被广播给所有订户，如@SendTo注释中所指定的"/receive/message" 。请注意，来自输入消息的名称已被清理，因为在这种情况下，它将被回显并重新呈现在客户端的浏览器DOM中。
        return new ServerStatus((int) (Math.random() * 10 + 50));
    }
    

}
