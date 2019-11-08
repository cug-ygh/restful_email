package com.example.client.client;

import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class windows {

    public static void windows(){
        JFrame jf=new JFrame("邮件推送");
        Container contenpane=jf.getContentPane();
        JPanel panel=new JPanel();
        panel.setLayout(null);
        JLabel lable1=new JLabel("收件人");
        lable1.setBounds(40,30,50,20);
        panel.add(lable1);
        JLabel label2=new JLabel("正文");
        label2.setBounds(40,130,50,50);
        panel.add(label2);
        contenpane.add(panel);
        JTextArea textArea1=new JTextArea("1824472510@qq.com;2112140870@qq.com;ygh@cug.edu.cn");
        textArea1.setFont(new Font("黑体", Font.PLAIN,13));
        textArea1.setLineWrap(true);
        JScrollPane up=new JScrollPane(textArea1, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        up.setBounds(80, 35, 460, 38);
        panel.add(up);
        JTextArea textArea2=new JTextArea("This is just a simple.");
        textArea2.setFont(new Font("黑体", Font.PLAIN,13));
        textArea2.setLineWrap(true);
        JScrollPane down=new JScrollPane(textArea2, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        down.setBounds(80, 150, 460, 300);
        panel.add(down);
        JButton jb1=new JButton();
        jb1.setText("发送");
        jb1.setBounds(540,430,90,30);
        panel.add(jb1);
        jb1.addActionListener(new ActionListener() {
                                  public void actionPerformed(ActionEvent e) {
                                      //判断输入邮箱地址的个数
                                      String get = textArea1.getText();
                                      String content=textArea2.getText();
                                      String address[] = get.split(";");
                                      if (get .equals("")) {
                                          System.out.println("0");
                                      } else if (address.length == 1) {
                                          //openDefaultBrowser(get,content);
                                          String url="http://3.91.28.195:8080/email?address="+get+"&url="+content;
                                          String res=client.get(url);

                                              if(res.equals("Y")){
                                                  JOptionPane.showMessageDialog(jf,"发送成功");
                                              }
                                              else{
                                                  JOptionPane.showMessageDialog(jf,"发送失败"+res);
                                              }
                                         // System.out.println("1");
                                      } else if (address.length >= 1) {
                                          //System.out.println(address.length);
                                          try {
                                              String res=client.post(address,content);
                                              if(res.equals("Y")){
                                                  JOptionPane.showMessageDialog(jf,"发送成功");
                                              }
                                              else{
                                                  JOptionPane.showMessageDialog(jf,"发送失败");
                                              }
                                          } catch (JSONException ex) {
                                              ex.printStackTrace();
                                          } catch (IOException ex) {
                                              ex.printStackTrace();
                                          }
                                      }

                                  }
                                  }
                              );
        jf.setBounds(400,100,646,516);
        jf.setVisible(true);

    }
}
