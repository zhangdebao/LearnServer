package com.controller;

import com.bean.ExecutionResult;
import com.bean.ResultMsg;
import com.utils.ResultUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TransferController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/operationTransfer", method = RequestMethod.GET)
    public ResultMsg getTransfer(){
        String str = System.getProperty("user.dir");
        List<String> list = new ArrayList<>();
        list = readFiles(str + "\\" + "src\\main\\resources\\res", list ,"");
        ResultMsg resultMsg = ResultUtils.success(list, "success");
        return  resultMsg;
    }
    @RequestMapping(value = "/operationTransfer", method = RequestMethod.POST)
    public ResultMsg editTransfer(String files){
        String[] fileArray = files.split(",");
        List<String> resultExecution = new ArrayList<>();
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\res\\";
        Long totalTime = 0L;
        for (String path1 : fileArray) {
            String path2 = "cmd /c start "+path + path1;
            String result = path1 + run_cmd(path2);
            String time = result.substring(result.indexOf(":") + 1, result.indexOf("(ms)"));
            totalTime += Long.parseLong(time);
            resultExecution.add( result);
        }
        ExecutionResult executionResult = new ExecutionResult();
        executionResult.setExecutionTime(totalTime);
        executionResult.setResultExecution(resultExecution);
        ResultMsg resultMsg = ResultUtils.success(executionResult, "success");
        return  resultMsg;
    }

    /**
     * 读取路径下的所有文件
     * @param path
     */
    public List<String> readFiles(String path, List<String> fileLists, String filesPath) {
        try{
            File files = new File(path);
            if (!files.isDirectory()) {
                System.out.println("是文件目录");
            } else {
                System.out.println("是文件夹");
                String[] fileList = files.list();
                for (String file : fileList) {
                    File readFile = new File(path+ "\\" + file);
                    if(!readFile.isDirectory()) {
                        fileLists.add(filesPath + file);
                    } else {
                        fileLists = readFiles(path+ "\\" + file, fileLists, filesPath + file + "\\");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return fileLists;
    }

    /**
     * 执行bat文件
     * @param strcmd
     */
    public String run_cmd(String strcmd) {
        Long startTime = new Date().getTime();
        String result = "";
        Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
        try {
            ps = rt.exec(strcmd);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps.waitFor();  //等待子进程完成再往下执行。
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i = ps.exitValue();  //接收执行完毕的返回值
        if (i == 0) {
            result = "执行完成";
        } else {
            result = "执行失败";
        }


        ps.destroy();  //销毁子进程
        ps = null;
        Long endTime = new Date().getTime();
        return result + "花费时间为:" + (endTime - startTime) + "(ms)！";
    }
}
