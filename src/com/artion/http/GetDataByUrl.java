package com.artion.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class GetDataByUrl {  
    public static String cc(String leibie, String num) {  
        StringBuffer temp = new StringBuffer();  
        try {  
            System.out.println(leibie);  
            System.out.println(num);  
            String url = "http://mini.eastday.com/mobile/160629060324558.html?idx=2&recommendtype=-1&ishot=1&fr=toutiao";  
            HttpURLConnection uc = (HttpURLConnection)new URL(url).  
                                   openConnection();  
            uc.setConnectTimeout(10000);  
            uc.setDoOutput(true);  
            uc.setRequestMethod("GET");  
            uc.setUseCaches(false);  
            DataOutputStream out = new DataOutputStream(uc.getOutputStream());  
  
            // 要传的参数  
            String s = URLEncoder.encode("ra", "utf-8") + "=" +  
                       URLEncoder.encode(leibie, "utf-8");  
            s += "&" + URLEncoder.encode("keyword", "utf-8") + "=" +  
                    URLEncoder.encode(num, "utf-8");  
            // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面  
//            out.writeBytes(s);  
            out.flush();  
            out.close();  
            InputStream in = new BufferedInputStream(uc.getInputStream());  
            Reader rd = new InputStreamReader(in, "utf-8");  
            int c = 0;  
            while ((c = rd.read()) != -1) {  
                temp.append((char) c);  
            }  
            System.out.println(temp.toString());  
            in.close();  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return temp.toString();  
    }  
    
    public static String getHtml(String urlString) {
    	try {
    	StringBuffer html = new StringBuffer();
    	URL url = new URL(urlString);
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	InputStreamReader isr = new InputStreamReader(conn.getInputStream());
    	BufferedReader br = new BufferedReader(isr);
    	String temp;
    	while ((temp = br.readLine()) != null) {
    	html.append(temp).append("\n");
    	}
    	br.close();
    	isr.close();
    	return html.toString();
    	} catch (Exception e) {
    	e.printStackTrace();
    	return null;
    	}
    	}
  
public static void main(String[] a){  
//        GetDataByUrl.cc("1","吉H");  
	
	System.out.println(getHtml("http://mini.eastday.com/mobile/160629060324558.html?idx=2&recommendtype=-1&ishot=1&fr=toutiao"));
    }  
  
}  