package com.example.web;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.aliyuncs.http.MethodType;

public class Email {
    public static String send_email(String address,String url) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FhKyB2Fa8AtiddNM7NT", "WEsY7VpQcMYu2ZYdfTmmZEvD9zCxrc");

        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("yinguanghao@ygh2000.work");
            request.setFromAlias("wind");
            request.setAddressType(1);
            request.setTagName("secret");
            request.setReplyToAddress(true);
            request.setToAddress(address);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject("sample");
            request.setHtmlBody(url);
            //开启需要备案，0关闭，1开启
            //request.setClickTrace("0");

            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return "Y";

        } catch (ServerException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return "N\n"+"ErrCode : " + e.getErrCode();
        }
        catch (ClientException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return "N\n"+"ErrCode : " + e.getErrCode();
        }
    }
    public static String send_many_email(String address[], String url) {
        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FhKyB2Fa8AtiddNM7NT", "WEsY7VpQcMYu2ZYdfTmmZEvD9zCxrc");

        // 如果是除杭州region外的其它region（如新加坡region）， 需要做如下处理
        //try {
        //DefaultProfile.addEndpoint("dm.ap-southeast-1.aliyuncs.com", "ap-southeast-1", "Dm",  "dm.ap-southeast-1.aliyuncs.com");
        //} catch (ClientException e) {
        //e.printStackTrace();
        //}
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName("yinguanghao@ygh2000.work");
            request.setFromAlias("wind");
            request.setAddressType(1);
            request.setTagName("secret");
            request.setReplyToAddress(true);
            //request.setToAddress(address);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            String to="";
            for(String i:address){
            //request.setToAddress(i);
                to+=","+i;
                to.substring(1);
            }//System.out.println(to);
            request.setToAddress(to);
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject("sample");
            request.setHtmlBody(url);
            //开启需要备案，0关闭，1开启
            //request.setClickTrace("0");

            //如果调用成功，正常返回httpResponse；如果调用失败则抛出异常，需要在异常中捕获错误异常码；错误异常码请参考对应的API文档;
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            return "Y";

        } catch (ServerException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return "N\n"+"ErrCode : " + e.getErrCode();
        }
        catch (ClientException e) {
            //捕获错误异常码
            System.out.println("ErrCode : " + e.getErrCode());
            e.printStackTrace();
            return "N\n"+"ErrCode : " + e.getErrCode();
        }
    }
    //验证是否为有效的邮箱地址
    public static String validateEmailAddress(String url) {
        if (url == null) {
        return "N";
        }
            String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(rule);
            matcher = pattern.matcher(url);
            if (matcher.matches())
                return "Y";
            else
                return "N";


    }
//    public static void main(String []args){
//        List<String> a=new ArrayList<String>();
//        a.add("ygh@cug.edu.cn");
//        a.add("jinlin68@cug.edu.cn");
//        send_many_email(a,"this is an eample.");
//    }
}
