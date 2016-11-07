package com.artion.str;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlMatch {

	// 匹配网址
//	public final static Pattern URL_PATTERN = Pattern
//			.compile("http://([\\w-]+\\.)+[\\w-]+(/[\\w-\\./?%&=]*)?");
	public final static Pattern URL_PATTERN = Pattern
			.compile("(http://|https://){1}[\\w\\.\\-/:]+");
	
	
	public final static Pattern NAME_PATTERN = Pattern
			.compile("@(.*?)(@|\\s|$)");
	
	public final static Pattern URL_REDID_PATTERN = Pattern
			.compile("redId=([^\\s\\$\\^\\[\\]\\?:!#%&=;@'\"<>$，；：“”。！、？]+)");
	
	public static void checkRedID(String content) {
		if(content == null) {
			return ;
		}
		
		Matcher nameMatcher = URL_REDID_PATTERN.matcher(content);
		while (nameMatcher.find()) {
//			names.add(nameMatcher.group(1));
			System.out.println("找到redId=" + nameMatcher.group(1));
		}
	}
	
	
	public static List<String> getMentionNames(String content) {
		if(content == null) {
			return null;
		}
		
		List<String> names = new ArrayList<String>();
		
		Pattern NAME_PATTERN = Pattern
				.compile("@([^\\s\\$\\^\\[\\]\\?:!#%&=;@'\"<>$，；：“”。！、？]+)");//@([^@\\s]+?)(?=@|\\s|$) //@([^@\\s^@|\\s|$]+)
		//@([^\\s\\$\\^\\[\\]\\?:!#%&=;@'\"<>$，；：“”。！、？]+)
		Matcher nameMatcher = NAME_PATTERN.matcher(content);
		while (nameMatcher.find()) {
//			names.add(nameMatcher.group(1));
			System.out.println("找到名字:" + nameMatcher.group(1));
		}
		
		return names;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		sb.append("=");
		sb.append(15);
		System.out.println("sb == " + sb.toString());
		
		checkRedID("redId=1233213&groupId=0000");
		
		String subText = "fsaf【】【金蝶】】fdasfd【12321】";
		Pattern psub = Pattern.compile("\\【(.*?)\\】");
		Matcher msub = psub.matcher(subText);
		 while(msub.find()) {
			 if(msub.group(1).length() > 0){
				 System.out.println(msub.group(1));//m.group(1)不包括这两个字符
				 int start = msub.start();
		            int end = msub.end();
		            System.out.println(subText.substring(start, end));
				 break;
			 }

		        }
		
		String filetext = "张小名=25分|李小花=43分|王力=100分|";
		Pattern p = Pattern.compile("\\=(.*?)\\|");//正则表达式，取=和|之间的字符串，不包括=和|
		Matcher m = p.matcher(filetext);
		 while(m.find()) {
		       System.out.println(m.group(1));//m.group(1)不包括这两个字符

		        }
		
		String content = "@abcfasdfads 1@蔡锦升 @@@@111,@22 @@ @..";
//		Matcher nameMatcher = NAME_PATTERN.matcher(content);
//		while (nameMatcher.find()) {
//			System.out.println("找到名字:" + nameMatcher.group(2));
//		}
		getMentionNames(content);
		
		System.out.println("找到没有：" + content.matches("/@([^@\\s]+?)(@|\\s|$)/"));
		
		

		String url = "http://www.baidu.com:8080/fdsaf这是什么";
		Matcher urlMatcher = URL_PATTERN.matcher(url);
		while (urlMatcher.find()) {
			System.out.println("找到地址:" + urlMatcher.group(0));
		}
		
		try {
			URI uri = new URI("cloudhub://status?id=123456");
			
			System.out.println(uri.getQuery());
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String ls = "明天|下午";
		Pattern lsp = Pattern.compile(ls);
		String lsStr = "明天下午我在这等你";
		Matcher lsM = lsp.matcher(lsStr);
		while(lsM.find()) {
			System.out.println(lsM.group(0));

		}
		
		
		String ls2 = "：(//回复 @蔡锦升)//\n";
		Pattern lsp2 = Pattern.compile(ls2);
		String lsStr2 = "回复 @蔡锦升：//回复 @蔡锦升//\n你好：//回复 @蔡锦升//";
		Matcher lsM2 = lsp2.matcher(lsStr2);
		while(lsM2.find()) {
			System.out.println(lsM2.group());
//			break;
		}
		
		
		
		String ls3 = "(^|(?<=\\D))((1\\d{10})|(0\\d{10,11})|(1\\d{2}-\\d{4}-\\d{4})|(0\\d{2,3}-\\d{7,8})|(\\d{7,8})|((4|8)00\\d{1}-\\d{3}-\\d{3})|((4|8)00\\d{7}))(?!\\d)";
		Pattern lsp3 = Pattern.compile(ls3);
//		String lsStr3 = "ff4008-308-110dd";
//		String lsStr3 = "4008-308-110";
//		String lsStr3 = "ff4008-308-110";
//		String lsStr3 = "4008-308-110dd";
//		String lsStr3 = "14008-308-110";
//		String lsStr3 = "4008-308-1102";
//		String lsStr3 = "4008-3018-110";
//		String lsStr3 = "13510575685";
//		String lsStr3 = "03510575681";
//		String lsStr3 = "0755-28514122";
//		String lsStr3 = "075528514122";
//		String lsStr3 = "ee13510575685";
//		String lsStr3 = "ee1351057568";
//		String lsStr3 = "ee0755-28514122";
		String lsStr3 = "ee075528514122";
		Matcher lsM3 = lsp3.matcher(lsStr3);
		while(lsM3.find()) {
			System.out.println(lsM3.group());
//			break;
		}
	}

}
