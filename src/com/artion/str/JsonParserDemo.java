package com.artion.str;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

public class JsonParserDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\pc\\Desktop\\list1")));
		String data1 = null;
		
			while((data1 = br.readLine())!=null)
			{
				String tmp = data1.replaceAll("\\\\", "");
				System.out.println(tmp); 
				String nameMatch = "\"name\":\"(.*?)\".*?\"phone\":\"(.*?)\"";
				Pattern p = Pattern.compile(nameMatch);
				Matcher m = p.matcher(tmp);
				while (m.find()) {
					System.out.println(m.group(1) + ":\t" + m.group(2));
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String data = "{\"5527762bdd942d0556c0b829\":{\"activeTime\":\"2015-04-22 23:07:16\",\"department\":\"小弟\",\"eid\":\"541021\",\"email\":\"\",\"emails\":\"\",\"firstPinyin\":\"gyl\",\"firstPinyinCode\":\"495\",\"fullPinyin\":\"gao yong liang\",\"fullPinyinCode\":\"426 9664 54264\",\"gender\":0,\"id\":\"1cfd471d-3644-4f62-840e-fdfd3467d7e8\",\"isAdmin\":1,\"lastUpdateTime\":\"2015-04-22 23:29:41\",\"name\":\"高永亮\",\"oId\":\"55c244c3-262e-44a1-bced-8c229ead3b12\",\"openId\":\"5527762bdd942d0556c0b829\",\"orgId\":\"916ff6d1-8916-4b2a-af0b-75daca5f555a\",\"orgInfoId\":\"7484e39f-3584-4e2a-a8ca-855cdd1a9934\",\"orgUserType\":0,\"phone\":\"18095272566\",\"phones\":\",18095272566\",\"photoUrl\":\"http://kdweibo.com/space/c/photo/load?id=55276e4416b2e3d852000002\",\"status\":1,\"task1\":3,\"userType\":10,\"wbNetworkId\":\"55276f02dd942d0556c0738b\",\"wbUserId\":\"54ef227add949385e9198482\",\"weights\":0}}";
		System.out.println(data);
		
		String nameMatch = "\"name\":\"(.*?)\".*?\"phones\":\"(.*?)\"";
		Pattern p = Pattern.compile(nameMatch);
		Matcher m = p.matcher(data);
		while (m.find()) {
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
		try {
			JSONObject json = JSONObject.fromObject(data);
			
			System.out.println(json.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
