package com.websocket;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class TestRunnable implements  Runnable{
    private Thread thread;

    @Override
    public void run() {
        try {
            Thread.sleep(1000); // 使线程休眠1秒来模拟处理延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }
    public void start () {
        if (thread == null) {
            thread = new Thread();
            thread.start();
        }
    }

    @SendTo("/receive/message") //广播所有用户
    public int test () {
        int number = (int) (Math.random() * 10 + 100);
        System.out.println("number=" + number);
        return number;
    }
}
