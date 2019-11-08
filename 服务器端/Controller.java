package com.example.web;

//import jdk.nashorn.internal.ir.RuntimeNode;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    public static String url="this is an example";
    public static String address="ygh@cug.edu.cn";
    public String []list={"",""};
    @RequestMapping(value="/email",method= RequestMethod.GET)
    public String send_email(@RequestParam String address,String url){
       // Email.send_email(address,url);
        return  Email.send_email(address,url);
    }

    @RequestMapping(value="/greeting")
    public greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping(value="/validateEmailAddress",method= RequestMethod.GET)
    public String validateEmailAddress(@RequestParam String url){
        return Email.validateEmailAddress(url);
    }
    @RequestMapping(value = "/sendmessage",method = RequestMethod.POST)
    public String send_mass_texting(@RequestBody String str) {
        //String a=jsonobject.getString("id").toString();
        System.out.println(str);
        String []list=str.split("#");
        String content=list[1];
        String address[]=list[0].split("%");
        System.out.println(content);
       return Email.send_many_email(address,content);


    }





}
