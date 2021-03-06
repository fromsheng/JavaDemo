package com.artion.str;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jinsheng_cai
 * @since 2013-10-25
 * 
 */
public class VerifyTools {
	
	public static boolean isInMyTime() {
		Date date = new Date();
		
		
		int hours = date.getHours();
		int minutes = date.getMinutes();
		
		if(hours == 8 && minutes > 30) {
			return true;
		}
		
		if(hours == 9 && minutes < 20) {
			return true;
		}
		
		if(hours == 12 && minutes > 30) {
			return true;
		}
		
		if(hours == 18 && minutes > 30) {
			return true;
		}
		
		if(hours == 19) {
			return true;
		}
		
		return true;
	}
	
	public static String getNaturalNumberString(String str) {
		if(isEmpty(str) || !verifyNumber(str)) {
			return "0";
		}
		
		int count = Integer.parseInt(str);
		
		if(count < 0) {
			count = 0;
		}
		
		return String.valueOf(count);
	}
	
//	/**
//	 * 取得需要高亮的字符串
//	 * @param source
//	 * @param pattern
//	 * @param highLightColor
//	 * @return
//	 */
//	public static SpannableString getHighLightText(String source, String pattern, int highLightColor) {
//		SpannableString s = new SpannableString(source);
//	    
//        Pattern p = Pattern.compile(pattern);
//        
//        
//         Matcher m = p.matcher(s);
//
//        while (m.find()) {
//            int start = m.start();
//            int end = m.end();
//            s.setSpan(new ForegroundColorSpan(highLightColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        }
//        
//        return s;
//	}
//	
//	/**
//	 * 判断jsonArray字符串是否为空
//	 * @param json
//	 * @return
//	 */
//	public static boolean isJsonArrayStrNull(String json) {
//		if(isEmpty(json)) {
//			return true;
//		}
//		
//		try {
//			JSONArray ja = new JSONArray(json);
//			if(ja != null && ja.length() > 0) {
//				return false;
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return true;
//	}
	
	/**
	 * 判断个数是否为空
	 * @param count
	 * @return
	 */
	public static boolean isCountNull(String count) {
		if(isEmpty(count)){
			return true;
		}
		
		if("0".equals(count.trim())) {
			return true;
		}
		
		return false;
	}
	
	public static String getCountZero(String count) {
		if(isCountNull(count)) {
			return "0";
		}
		
		return count;
	}
	
	/**
	 * 判断字符串是否为空.
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(String src) {
		return src == null || "".equals(src.trim()) || "null".equalsIgnoreCase(src);
	}

	/**
	 * 邮箱验证
	 * 
	 * @param email
	 *            需要验证的邮箱
	 * */
	public static boolean isEmail(String email) {

		return Pattern
				.compile(
						"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$")
				.matcher(email).matches();
	}

	/**
	 * 验证密码格式, 只支持英文和数字.
	 * 
	 * @param pwd
	 * @return
	 */
	public static boolean verifyPasswordFormat(String pwd) {
		return Pattern.compile("[a-zA-Z0-9]*").matcher(pwd).matches();
	}

	/**
	 * 验证手机号是否正确;
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		// Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		// 增加18号段跟147 145
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[5,7]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	/**
	 * 验证是否是数字串
	 * @param src
	 * @return
	 */
	public static boolean verifyNumber(String src) {
		return Pattern.compile("[0-9]+").matcher(src).matches();
	}

	/**
	 * 返回文件大小，带单位B,KB,MB等
	 * @param fileSize
	 * @return
	 */
	public static String getStringBySize(long fileSize){
		String result="";
		if((fileSize/1024)>=1){
			fileSize/=1024;
			if(fileSize/1024>=1){
				//解决当最后一位为0时，未显示出来的问题
				double value= fileSize*1.0/1024;
				DecimalFormat df = new DecimalFormat("#.00");
				result= df.format(value)+" MB";
//				result=new BigDecimal(fileSize*1.0/1024).setScale(2,BigDecimal.ROUND_HALF_UP).floatValue()+" MB";
			}else{
				result=fileSize+" KB";
			}
		}else{
			result=fileSize+" B";
		}
		return result;
	}
	
	public static int getByteLength(String str) {
		return getByteLength(str, "GBK");
	}
	
	public static int getByteLength(String str, String code) {
		if(str == null) {
			return 0;
		}
		try {
			return str.getBytes(code).length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static int getCount(String str) {
		int charNum = 0;
		int charNumCount = 0;
		int gbkLen = getByteLength(str);
		int chNum = gbkLen - str.length();
		charNum = str.length() - chNum;
		if(charNum > 0) {
			charNumCount = charNum/2 + charNum%2;
		}
		return chNum + charNumCount;
	}
	
	public static String getSpliteStrs(String srcStr, final int lineMaxByteLen, final int outPutLines) {
		if(srcStr == null) {
			return srcStr;
		}
		StringBuffer  sb = new StringBuffer();
		String[] spliteStrs = srcStr.split("");
		String s = null;
		int curByteLen = 0;
		int curLine = 1;
		for (int i = 0; i < spliteStrs.length; i++) {
			s = spliteStrs[i];
			if(s.length() <= 0) {
				continue;
			}
			int sByteLen = getByteLength(s);
			curByteLen += sByteLen;
			if(curByteLen > lineMaxByteLen && curLine < outPutLines) {
				sb.append("\n");
				curLine ++;
				curByteLen = sByteLen;
			} 
			sb.append(s);
			
		}
		
		return sb.toString();
	}
	
	public static String getEllipsizeText(String srcStr, int extraBytelen) {
		if(srcStr == null) {
			return srcStr;
		}

		String[] spliteStrs = srcStr.split("");
		String s = null;
		int curByteLen = 0;
		int index = spliteStrs.length - 1;
		for(int i = spliteStrs.length - 1; i >= 0; i --) {
			s = spliteStrs[i];
			if(s.length() <= 0) {
				continue;
			}

			int sByteLen = getByteLength(s, "GBK");
			curByteLen += sByteLen;
			if(curByteLen > extraBytelen) {
				index = i;
				break;
			}
		}
		return srcStr.substring(0, index);
	}
	
	
}
