package com.example.client.client;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class client {
    public static String post(String[]address, String content) throws JSONException, IOException {
        //用%分开收件人，用#分开发送内容
        String url="";
        for(String i:address){
            url+="%"+i;
        }
        url.substring(1);
        url+="#"+content;
//        RestTemplate client = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        HttpMethod method = HttpMethod.POST;
//        // 以表单的方式提交
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        //将请求头部和参数合成一个请求
//        MultiValueMap<String, String> params=null;
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //部署在公网上
       HttpPost httpPost=new HttpPost("http://3.91.28.195:8080/sendmessage");
        //部署在本地
        //HttpPost httpPost=new HttpPost("http://localhost:8080/sendmessage");
        StringEntity entity = new StringEntity(url, "utf-8");
        entity.setContentType("application/text");
        httpPost.setEntity(entity);
        HttpResponse response = httpclient.execute(httpPost);
        String res = EntityUtils.toString(response.getEntity());
        //System.out.println(res);
        return res;

    }
    public static String get(String url){
        RestTemplate restTemplate = new RestTemplate();
        String notice = restTemplate.getForObject(url, String.class);
        return notice;
    }
public static void main(String[] args) throws JSONException, IOException {
        //post();
    windows.windows();
    }
}
