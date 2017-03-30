/**
 * 
 */
package com.ivan.blog.util;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * <pre>
 * 공통 Util
 * 작성일 : 2016. 3. 11.
 * 작성자 : Freebee
 * </pre>
 * @author Freebee
 */
public class CommonUtil {
	private static CommonUtil instance;
	
	public static CommonUtil getInstance()	{
		if (instance == null)	{
			instance = new CommonUtil();
		}
		return instance;
	}
	
	/** 
	 * 오늘 날짜
	 * <pre>
	 * 1. MethodName : getToDay
	 * 2. Method설명 : 오늘 날짜 
	 * 3. 작성일 : 2015. 12. 15.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param separator
	**/
	public String getToDay(String separator)	{
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(0x1ee6280, "KST"));
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		
		String convertMonth = String.valueOf(month);
		if (month < 10)
			convertMonth = "0" + convertMonth;
		String convertDay = String.valueOf(day);
		if (day < 10)
			convertDay = "0" + convertDay;
			
		String  thisDayMiner = cal.get(Calendar.YEAR) + separator + convertMonth + separator + convertDay;
		return thisDayMiner;
	}
	
	/** 
	 * 날짜 Parsing
	 * <pre>
	 * 1. MethodName : getParsingDate
	 * 2. Method설명 : 날짜 Parsing
	 * 3. 작성일 : 2015. 12. 22.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param targetDate
	**/
	public String getParsingDate(String targetDate)	{
		String resultDate = "";
		final String[] dayArry = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = Integer.parseInt(targetDate.substring(0, 4));
		int month = Integer.parseInt(targetDate.substring(4, 6));
		int day = Integer.parseInt(targetDate.substring(6, 8));
		Calendar parsingDate = Calendar.getInstance();
		parsingDate.set(year, month-1, day);
		parsingDate.getTime();
		
		resultDate = year + "년 " + month + "월 " + day + "일 " + dayArry[parsingDate.get(Calendar.DAY_OF_WEEK)-1] + "요일";
		
		return resultDate;
	}
	
	/** 
	* Null을 빈 값으로 치환 
	* <pre>
	* 1. MethodName : null2Empty
	* 2. Method설명 : Null을 빈 값으로 치환 
	* 3. 작성일 : 2015. 11. 23
	* 4. 작성자 : Freebee
	* </pre>
	* @return String
	* @param param String
	*/
	public Object null2Empty(Object param)	{
		if (param == null)	{
			param = "";
		}
		
		return param;
	}
	
	/**
	 * Method 설명 : Null을 '-'로 반환
	 * 작성일 : 2016. 3. 9.
	 * @param param
	 * @return
	 */
	public String null2Dash(String param)	{
		if (param == null)	{
			param = "-";
		}
		
		return param;
	}

	/** 
	 * Time Parsing
	 * <pre>
	 * 1. MethodName : getParsingTime
	 * 2. Method설명 : Time Parsing 
	 * 3. 작성일 : 2015. 12. 23.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param timeValue
	 * @param timeMode
	**/
	public String getParsingTime(String timeValue, String timeMode, boolean isSecond) {
		String parsingTime = "";
		
		int hour = 0;
		String minute = "";
		String second = "";
		if (timeValue.length() == 6)	{
			hour = Integer.parseInt(timeValue.substring(0, 2));
			minute = timeValue.substring(2, 4);
			second = timeValue.substring(4, 6);
		} else if (timeValue.length() == 14)	{
			hour = Integer.parseInt(timeValue.substring(8, 10));
			minute = timeValue.substring(10, 12);
			second = timeValue.substring(12, 14);
		} else {
			hour = 00;
			minute = "00";
			second = "00";
		}
		
		String timeType = "";
		if(!timeMode.equals("24H"))	{
			if(hour >= 12)	{
				if(hour !=  12)	{
					hour = hour - 12;
				}
				timeType = "오후";
			} else {
				timeType = "오전";
			}
		}
		parsingTime = timeType + " " + hour + ":" + minute;
		if(isSecond)	{
			parsingTime += ":" + second;
		}
		
		return parsingTime;
	}

	/** 
	 * 
	 * <pre>
	 * 1. MethodName : getParsingSeparatorDate
	 * 2. Method설명 : 
	 * 3. 작성일 : 2015. 12. 23.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param dateValue
	 * @param dateSeparator
	 * @param timeSeparator
	**/
	public String getParsingSeparatorDate(String dateValue, String dateSeparator, String timeSeparator, boolean isSecond) {
		String parsingDate = "";
		String year = "";
		String month = "";
		String day = "";
		String hour = "";
		String minute = "";
		String second = "";
		String timeType = "";
		dateValue = dateValue.replace(":", "");
		year = dateValue.substring(0,4);
		month = dateValue.substring(4,6);
		day = dateValue.substring(6,8);
		
		if(dateSeparator.equals(""))	{
			parsingDate += year + "년 " + month + "월 " + day + "일 ";
		} else {
			parsingDate += year + dateSeparator + month + dateSeparator + day;
		}
		if (dateValue.length() >= 10)	{
			hour = dateValue.substring(8, 10);
			int parseHour = Integer.parseInt(hour);
			if(parseHour >= 12)	{
				if(parseHour !=  12)	{
					hour = String.valueOf(parseHour - 12);
				}
				timeType = "오후";
			} else {
				timeType = "오전";
			}
			if(dateValue.length() > 12)	{
				minute = dateValue.substring(10, 12);
				second = dateValue.substring(12, 14);
			}
			if(timeSeparator.equals(""))	{
				parsingDate +=  " " + timeType + " " + hour + "시 " + minute + "분";
			} else {
				parsingDate +=  " " + timeType + " " + hour + timeSeparator + minute;
			}
		}
		if(isSecond)	{
			parsingDate +=  timeSeparator + second;
		}
		
		return parsingDate;
	}	
	
	/** 
	 * Date Format으로 오늘 날짜 가져오기
	 * <pre>
	 * 1. MethodName : toDateForDateFormat
	 * 2. Method설명 : Date Format으로 오늘 날짜 가져오기
	 * 3. 작성일 : 2015. 12. 28.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param dateFormat
	**/
	public String getToDateForDateFormat(String dateFormat)	{
		String resultDay = "";
		long toDayTime = System.currentTimeMillis(); 
		SimpleDateFormat formatToday;
		
		formatToday = new SimpleDateFormat(dateFormat);
		resultDay = formatToday.format(new Date(toDayTime));
				
		return resultDay;
	}
	

	/** 
	 * JSP에서 표시할 공백처리
	 * <pre>
	 * 1. MethodName : null2nbsp
	 * 2. Method설명 : JSP에서 표시할 공백처리
	 * 3. 작성일 : 2016. 2. 1.
	 * 4. 작성자 : Freebee
	 * </pre>
	 * @return String
	 * @param param
	 * @return 
	**/
	public String null2nbsp(String param) {
		if (param == null)	{
			param = "&nbsp;";
		}
		
		return param;
	}
	
	/**
	 * 천단위 콤마 찍힌 숫자를 리턴한다. 
	 * @param str
	 * @return
	 */
	public static String getMoneyType(String str) 	{
		if(str == null) {
			return str;
		}
		if(str.indexOf(",") > -1)	{
			str = str.replaceAll(",", "");
		}
		int length = str.length();
		if(length < 4)
	       return str;

        StringBuilder result = new StringBuilder();
        for(int i = length - 1; i >= 0; --i) {
        	char number = str.charAt(length - i - 1);
            if(i != 0 && i % 3 == 0) {
                result.append(number);
                result.append(',');
                continue;
            }
            result.append(number);
        }
        
        return result.toString();
	}
	
	
	/**
     * null인 경우 ""를 return
     * @param value
     * @return
     */
	public static String nvl(String value) {
		return nvl(value, "");
	}

	/**
	 * value가 null인 경우 defalult값을 return
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static String nvl(String value, String defaultValue) {
		if (value == null || value.equals(""))
			return defaultValue;
		else
			return value;
	}
	
	/**
	 * value가 null인 경우 defalult값을 return
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static int nvl(String value, int defaultValue) {
		if (value == null || value.equals(""))
			return defaultValue;
		else
			return Integer.parseInt(value);
	}
	
	public static String toShellPath(String inPath) {
		StringBuffer path = new StringBuffer();
		int index = -1;

		inPath = inPath.trim();
		index = inPath.indexOf(":\\");
		inPath = inPath.replace('\\', '/');
		if (index > -1) {
			path.append("//");
			path.append(inPath.substring(0, index));
			path.append('/');
			path.append(inPath.substring(index + 2));
		} else {
			path.append(inPath);
		}
		return path.toString();
	}

	public static String toWindowsPath(String path) {
		String winPath = path;
		int index = winPath.indexOf("//");

		if (index > -1) {
			winPath = winPath.substring(0, index) + ":\\"
					+ winPath.substring(index + 2);
		}
		index = winPath.indexOf(58);
		if (index == 1) {
			winPath = winPath.substring(0, 1).toUpperCase()
					+ winPath.substring(1);
		}
		winPath = winPath.replace('/', '\\');
		return winPath;
	}
	
	public static String toCurrentPath(String path) {
		String cPath = path;

		if (File.separatorChar == '/')
			cPath = toShellPath(cPath);
		else {
			cPath = toWindowsPath(cPath);
		}
		File file = new File(cPath);

		file = new File(file.getAbsolutePath());
		if (file.exists()) {
			cPath = file.getAbsolutePath();
		}
		return cPath.trim();
	}
	
	public static String toJavaPath(String in) {
		String path = new String(in);

		path = toCurrentPath(path);
		return path.replace('\\', '/');
	}
	
	@SuppressWarnings("rawtypes")
	public static Map renewName(String fileName, int size) {
		int lastindex = fileName.lastIndexOf('.');
		String name = fileName.substring(0, lastindex);
		String fileType = fileName.substring(lastindex + 1);
		
		if (size <= 100) {
			size = 100;
		} else if (size > 100 & size <= 250) {
			size = 250;
		} else if (size > 250 & size <= 510) {
			size = 510;
		} else if (size > 510 & size <= 620) {
			size = 620;
		}
		
		String newFileName = name + "_" + size + "." + fileType;
		
		Map<String,String> model = new HashMap<String,String>();
		model.put("fileType", fileType);
		model.put("newFileName", newFileName);
		
		return model;
	}
	
	@SuppressWarnings("rawtypes")
	public static void saveThumbnailImgRv(String path, String fileNm, int width) throws IOException {
		try {
			Map newFile = renewName(fileNm, width);
			if(!"/".equals(path.substring(path.length()-1,path.length()))){
				path = path+"/";
			}
			ImageUtils.thumbnail(new File(path + fileNm), new File(path + newFile.get("newFileName").toString()), width);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Task 문자로만 이루어진 생성
	* @MethodName createRandomKey
	* @param digit
	* @return String
	*/
	public String createRandomKey(int digit) {
		String key = RandomStringUtils.randomAlphanumeric(digit);
		
		return key;
	}

	/**
	 * @Task 숫자로만 이루어진 난수 생성
	 * @MethodName createProductCode
	 * @param digit
	 * @return String
     */
	public String createProductCode(int digit) {
		String key = RandomStringUtils.randomNumeric(digit);
		return key;
	}
	
	/**
	 * 오늘 날짜를 기준으로 +/- 날짜 구하기
	 * @param calc +/-할 숫자
	 * @return String
	 */
	public static String getCalcDate(int calc){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, calc);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * @Task java 숫자형 체크
	 * @MethodName isStringDouble
	 * @param s
	 * @return
	 * @return boolean
	 * @date 2016. 5. 30.
	 * @author jk.han
	 */
	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 
	 * @Task 날짜 유효성 체크 
	 * @date 2016. 6. 29.
	 * @author youngbok.kim
	 * @MethodName checkDate
	 * @param szDate
	 * @param szFormat
	 * @return
	 */
	@SuppressWarnings("unused")
	public static boolean checkDate(String szDate, String szFormat) {
        
        boolean bResult = true;
        SimpleDateFormat oDateFormat = new SimpleDateFormat();
        Date oDate = new Date();
 
        oDateFormat.applyPattern(szFormat);
        oDateFormat.setLenient(false);      
         
        try {
            oDate = oDateFormat.parse(szDate);
        } catch (ParseException e) {
            bResult = false;
        }
         
        return bResult;
         
    }
	
	/**
	 * @Task 개인정보 노출 처리 
	 * @MethodName personalInfoReplace
	 * @param replaceMode
	 * @param targetValue
	 * @return String
	 * @date 2016. 7. 1.
	 * @author tk.kang
	 */
	public static String personalInfoReplace(String replaceMode, String targetValue)	{
		String resultValue = "";
		
		if(replaceMode.toUpperCase().equals("ID"))	{								/*뒤에서 4자리 '*'*/
			resultValue = targetValue.substring(0, targetValue.length() - 4);
			resultValue += "****";
		} else if(replaceMode.toUpperCase().equals("NAME"))	{						/*첫째짜리 제외하고 모두 '*'*/
			for(int idx=0; idx<targetValue.length(); idx++)	{
				if(idx == 0)	{
					resultValue += targetValue.substring(idx, idx+1);
				} else {
					resultValue += "*"; 
				}
			}
		} else if(replaceMode.toUpperCase().equals("HP") ||							/*모두 '*'*/ 
				  replaceMode.toUpperCase().equals("EMAIL"))	{
			for(int idx=0; idx<targetValue.length(); idx++)	{
				resultValue += "*";
			}
		} else if(replaceMode.toUpperCase().equals("ACCOUNT"))	{					/*뒤에서 8자리 '*'*/
			resultValue = targetValue.substring(0, targetValue.length() - 8);
			resultValue += "********";
		}
		
		return resultValue;
	}


	/**
	 * 주문에서 사용할 랜던한 숫자로 이루어진 8자리 문자열 생성
	 * @return 랜던한 숫자로 이루어진 8자리 문자열
	 */
	public static String createEightDigitRandomNumber() {
		return StringUtils.substring(String.valueOf(System.currentTimeMillis()), 5);
	}
	
	/**
	 * 
	 * @Task 영유아 카테고리 체크 
	 * @date 2016. 8. 4.
	 * @author youngbok.kim
	 * @MethodName chkCateList
	 * @param mktCid
	 * @return
	 */
	public static boolean chkCateList(String mktCid){
		List<String> cateList = new ArrayList<String>();
		cateList = Arrays.asList("M03_01_01","M03_01_02","M03_01_03","M03_01_04","M03_01_05","M03_02_01","M03_02_02","M03_02_03","M03_02_04","M03_02_05"
				,"M03_02_06","M03_02_07","M03_03_02","M03_03_03","M03_03_04","M03_03_05","M03_03_06","M03_03_07","M03_03_08","M03_03_09");
		if(cateList.contains(mktCid)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @Task Random 문자열 생성
	 * @MethodName randomString
	 * @param stringLength
	 * @return String
	 * @date 2016. 8. 19.
	 * @author tk.kang
	 */
	public static String randomString(int stringLength) {
		char[] charSet = new char[]{
		  '0','1','2','3','4','5','6','7','8','9'
		  ,'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
		  ,'O','P','Q','R','S','T','U','V','W','S','Y','Z'
		  ,'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
		  ,'o','p','q','r','s','t','u','v','w','s','y','z'
		  ,'~','!','@','#','$','%','^','&','*','(',')','`','=','-',',','.','/','?',';','[',']','{','}',':','|'
		};
		
		char[] checkSpecificChar = {'~','!','@','#','$','%','^','&','*','(',')','`','=','-',',','.','/','?',';','[',']','{','}',':','|'};
		int setIdx = 0;
		StringBuffer sb = new StringBuffer();
		for(int idx=0; idx<stringLength; idx++){
			setIdx = (int)(charSet.length*Math.random());
			sb.append(charSet[setIdx]);
		}
		
		boolean isCheck = false;
		for(int idx=0; idx<checkSpecificChar.length; idx++)	{
			if(sb.toString().indexOf(checkSpecificChar[idx]) > -1)	{
				isCheck = true;
				break;
			}
		}
		if(!isCheck)	{
			randomString(stringLength);
		}
		
		return sb.toString();
	}
	
	/**
	 * @Task 회원 
	 * @MethodName localIpInfo
	 * @return String
	 * @date 2016. 8. 22.
	 * @author tk.kang
	 */
	public static String getLocalHostIp() {
		String localIp = "";
		try {
			InetAddress ipInfo = InetAddress.getLocalHost();
			localIp = ipInfo.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return localIp;
	}
	
	/**
	 * 
	 * @Task 날짜 형변환 
	 * @date 2016. 8. 31.
	 * @author youngbok.kim
	 * @MethodName formatDate
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(String date, String format) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date to = new Date();
		try {
			to = transFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateFormatUtils.format(to, format);
	}
	
}

