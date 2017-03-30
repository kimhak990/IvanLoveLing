/*
 * @Class Name : DateUtils.java
 * @Description : 날짜 유틸리티 class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2013.12.26    배동오         최초 생성
 *
 * @author 배동오
 * @since 2013.12.26
 * @see
 */
package com.ivan.blog.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 개발자 : 최유진
 * 날짜 유틸리티.
 */
public class DateUtils
{
    /**
     * The logger.
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * The Constant DEFAULT_PATTERN.
     */
    public static final String PATTERN_DEFAULT = "yyyy-MM-dd";

    public static final String PATTERN_YYMMDDHHmmss = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_YYMMDDHHmmss2 = "yyyyMMddHHmmss";
    
    public static final String PATTERN_YYMMDDHHmmss3 = "yyyy년 MM월 dd일 HH시 mm분 ss초";
    
    public static final String PATTERN_YYMMDDHHmm = "yyyy년 MM월 dd일 HH시 mm분";
    
    public static final String PATTERN_YYMMDD_KR = "yyyy년 MM월 dd일";

    /**
     * The Constant JQUERY_UI_PATTERN.
     */    
    public static final String PATTERN_JQUERY_UI = "MM/dd/yyyy";
    
    /**
     * The Constant PATTERN_SYSDATE.
     */
    public static final String PATTERN_SYSDATE = "yyyyMMdd";

    /**
     * The Constant DEFAULT_PATTERN.
     */
    public static final String PATTERN_YYMMDD = "yy.MM.dd";

    public static final String PATTERN_HHMMDD = "HH:mm:ss";
    
    /**
     * The Constant PATTERN_SYSDATE.
     */
    public static final String PATTERN_SYSDATE_YYYY = "yyyy";

    /**
     * The Constant PATTERN_SYSDATE.
     */
    public static final String PATTERN_SYSDATE_MM = "MM";

    /**
     * The Constant PATTERN_SYSDATE.
     */
    public static final String PATTERN_SYSDATE_DD = "dd";

    /**
     * 현재날짜(yyyy/MM/dd/)를 가져오기.
     *
     * @return the today
     */
    public static String getToday() {
        return getToday(PATTERN_DEFAULT);

    }

    /**
     * 현재날짜시간분(yyyy/MM/dd/HHmmss)를 가져오기.
     *
     * @return the today
     */
    public static String getTodayhhmm() {
        return getToday(PATTERN_YYMMDDHHmmss);

    }

    /**
     * Gets the today.
     *
     * @param format the format
     * @return the today
     */
    public static String getToday(String format) {
        DateTime dt = new DateTime();
        return parseStringDate(dt, format);

    }

    /**
     * 현재날짜(yyyy/MM/dd) 기준으로 몇 일 전후 가져오기.
     *
     * @param days the days
     * @return the before day
     */
    public static String getDayFromToday(int days) {

        DateTime dt = new DateTime();
        Instant pInstant = dt.withFieldAdded(DurationFieldType.days(), days)
                .toInstant();
        DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
        return fmt.print(pInstant);

    }

    /**
     * 오늘 날짜에서 월을 계산하여 날짜를 반환하기.
     *
     * @param months the months
     * @return the month from today
     */
    public static String getMonthFromToday(int months) {

        DateTime dt = new DateTime();
        Instant pInstant = dt
                .withFieldAdded(DurationFieldType.months(), months).toInstant();
        DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
        return fmt.print(pInstant);

    }

    /**
     * 해당년도 1월1일 가져오기.
     *
     * @return the first day for this year
     */
    public static String getFirstDayForThisYear() {

        DateTime dt = new DateTime();
        int year = dt.getYear();
        DateTime dt2 = new DateTime(year, 1, 1, 0, 0);
        return parseStringDate(dt2, PATTERN_DEFAULT);

    }

    /**
     * Gets the year list.
     *
     * @param period the period
     * @return the year list
     */
    public static List<String> getYearList(int period) {

        List<String> yearList = new ArrayList<String>();

        DateTime dt = new DateTime();
        int year = dt.getYear();

        int start = 0;
        int end = 0;

        if (period >= 0) {
            start = year;
            end = year + period;
        } else {
            start = year + period;
            end = year;
        }

        for (; start <= end; start++) {

            yearList.add(Integer.toString(start));
            // System.out.println(start);

        }

        Collections.reverse(yearList);

        return yearList;

    }

    /**
     * 두 날짜 차이(day) 가져오기.
     *
     * @param startDate 시작일자
     * @param endDate   종료일자
     * @param format    날짜포멧
     * @return the days
     */
    public static int getDays(String startDate, String endDate, String format) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern(format);
        DateTime sDate = formatter.parseDateTime(startDate);
        DateTime eDate = formatter.parseDateTime(endDate);

        return Days.daysBetween(sDate, eDate).getDays();

    }

    /**
     * 현재 달의 첫번째 일자 가져오기.
     *
     * @return string date
     */
    public static String getFirstDayOfCurMonth() {
        return getFirstDayOfCurMonth(PATTERN_DEFAULT);
    }

    /**
     * 현재 달의 첫번째 일자 가져오기.
     *
     * @param pattern the pattern
     * @return string date
     */
    public static String getFirstDayOfCurMonth(String pattern) {
        DateTime firstDayOfMonth = new DateTime().dayOfMonth()
                .withMinimumValue();
        return parseStringDate(firstDayOfMonth);
    }

    /**
     * 현재 년도의 1월 1일 가져오기.
     *
     * @return the first day of cur year
     */
    public static String getFirstDayOfCurYear() {
        DateTime date = new DateTime().withMonthOfYear(1).withDayOfMonth(1);
        return parseStringDate(date, PATTERN_DEFAULT);
    }

    /**
     * 현재 년도의 1월 1일 가져오기.
     *
     * @param pattern 날짜 패턴
     * @return the first day of cur year
     */
    public static String getFirstDayOfCurYear(String pattern) {
        DateTime date = new DateTime().withMonthOfYear(1).withDayOfMonth(1);
        return parseStringDate(date, pattern);
    }

    /**
     * String 날짜를 DateTime으로 변환.
     *
     * @param strDate String 날짜
     * @return string date
     */
    public static String getFirstDayOfMonth(String strDate) {
        return getFirstDayOfMonth(strDate, PATTERN_DEFAULT);
    }

    /**
     * String 날짜를 DateTime으로 변환.
     *
     * @param strDate String 날짜
     * @param pattern 날짜 포멧
     * @return string date
     */
    public static String getFirstDayOfMonth(String strDate, String pattern) {
        DateTime firstDayOfMonth = parseDateTime(strDate, pattern).dayOfMonth()
                .withMinimumValue();
        return parseStringDate(firstDayOfMonth);
    }

    /**
     * DateTime을 String 날짜로 변환.
     *
     * @param datetime DateTime
     * @return string date
     */
    public static String parseStringDate(DateTime datetime) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(PATTERN_DEFAULT);
        return fmt.print(datetime);
    }

    /**
     * DateTime을 String 날짜로 변환.
     *
     * @param datetime DateTime
     * @param pattern  날짜 포멧
     * @return string date
     */
    public static String parseStringDate(DateTime datetime, String pattern) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.print(datetime);
    }

    /**
     * DateTime을 String 날짜로 변환.
     *
     * @return string date
     */
    public static String parseStringDate(Date datetime, String pattern) {
    	DateFormat sdFormat = new SimpleDateFormat(pattern);
        return sdFormat.format(datetime);
    }
    
    /**
     * 주어진 포맷에 대한 String 날짜로 변환.
     *
     * @return string date
     */
    public static String parseConvertStringDate(String strDate, String prePattern, String postPattern) {
        DateTimeFormatter preFmt = DateTimeFormat.forPattern(prePattern);
        DateTime datetime = preFmt.parseDateTime(strDate);
        DateTimeFormatter postFmt = DateTimeFormat.forPattern(postPattern);
        
        return postFmt.print(datetime);
    }

    /**
     * String 날짜를 DateTime으로 변환.
     *
     * @param strDate String 날짜
     * @param pattern 날짜 포멧
     * @return string date
     */
    public static DateTime parseDateTime(String strDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(pattern);
        return formatter.parseDateTime(strDate);
    }

    /**
     * 주어진 포맷의 String 날짜를 java.sql.Date으로 변환.
     *
     * @param strDate String 날짜
     * @param pattern 날짜 포멧
     * @return string date
     */
    public static java.sql.Date parseSqlDate(String strDate, String pattern) throws Exception {
		return new java.sql.Date(new SimpleDateFormat(pattern).parse(strDate).getTime());
    }   

    /**
     * default 포맷의 String 날짜를 java.sql.Date으로 변환.
     *
     */
    public static java.sql.Date parseSqlDate(String strDate) throws Exception {
		return parseSqlDate(strDate, PATTERN_DEFAULT);
    } 
    
    /**
    * @Task default(yyyyMMdd) 포맷의 String 날짜를 포맷에 맞게 String으로 변환
    */
    public static String parseDateStr(String strDate, String defaultPattern, String ParsePattern){
    	SimpleDateFormat orgPattern = new SimpleDateFormat(defaultPattern);
    	SimpleDateFormat newPattern = new SimpleDateFormat(ParsePattern);
    	
    	String parseStr = "";
    	try {
        	Date orgDate = orgPattern.parse(strDate);
        	parseStr = newPattern.format(orgDate);
		} catch (Exception e) {
			e.printStackTrace();
			return strDate;
		}
    	
    	return parseStr;
    }
    
    /**
     * 두 날짜의 차이를 리턴한다.
     *
     * @param startDate yyy-MM-dd
     * @param endDate   yyy-MM-dd
     * @return 두날짜의 차이
     */
    public static int getDiffDay(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate;
        Date eDate;
        try {
            sDate = sdf.parse(startDate);
            eDate = sdf.parse(endDate);
            return (int) ((eDate.getTime() - sDate.getTime()) / 1000 / 60 / 60 / 24);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 입력받은 날짜에 해달 일수를 증가한다.
     *
     * @param str yyyy-MM-dd 형식
     * @param i   증가시킬 날
     * @return yyyy-MM-dd 증가된 날짜
     * @throws Exception
     */
    public static String getAfterDate(String str, int i, String decimal) throws Exception {
        DateFormat formatter = new SimpleDateFormat( (str.contains(decimal)) ? "yyyy-MM-dd" : "yyyyMMdd" );
        Date sDate = (Date) formatter.parse(str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.DATE, i);
        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = cal.get(Calendar.MONTH) < 9 ? "0" + Integer.toString(cal.get(Calendar.MONTH) + 1) : Integer.toString(cal.get(Calendar.MONTH) + 1);
        ;
        String date = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) : Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        return (decimal!=null) ? year + decimal + month + decimal + date : year+month+date;
    }

    /**
     * 입력받은 날짜에 해달 일수를 증가한다.
     *
     * @param str yyyy-MM-dd 형식
     * @param i   증가시킬 날
     * @return yyyy-MM-dd 증가된 날짜
     * @throws Exception
     */
    public static String getAfterDateNew(String str, int i) throws Exception {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sDate = (Date) formatter.parse(str);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        cal.add(Calendar.DATE, i);
        String year = Integer.toString(cal.get(Calendar.YEAR));
        String month = cal.get(Calendar.MONTH) < 9 ? "0" + Integer.toString(cal.get(Calendar.MONTH) + 1) : Integer.toString(cal.get(Calendar.MONTH) + 1);
        ;
        String date = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) : Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        return year + month + date;
    }


    /**
     * 특정 날짜의 그주가 속한 월요일의 날짜 구하기
     *
     * @param dateStr
     * @param format
     * @return
     * @throws Exception
     */
    public static String getStartMondayOfWeek(String dateStr, String format) throws Exception {

        DateFormat formatter = new SimpleDateFormat(format);
        Date sDate = (Date) formatter.parse(dateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);

        while (cal.get(Calendar.DAY_OF_WEEK) != 2) {
            // 월요일(1)이 아닐경우 날짜를 계속해서 빼줌,
            // 날짜가 속한 주의 요일(1:일, 2:월, 3:화....)
            cal.add(Calendar.DATE, -1);
        }

        DateTime dt = new DateTime(cal.getTimeInMillis());
        // joda time formatter
        String rStirng = dt.toString(format);

        return rStirng;
    }

    /**
     * 입력받은 달의 마지막 일자를 반환
     *
     * @param dateStr
     * @param format  : date 포멧 패턴
     * @return
     * @throws Exception
     */
    public static String getLastDayOfMonth(String dateStr, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        return sdf.format(cal.getTime());
    }

    /**
     * 입력받은 달의 i 만큼 증감한 달의 1일을 반환
     *
     * @param dateStr
     * @param i
     * @param format
     * @return
     * @throws Exception
     */
    public static String getFirstDayOfAfterMonth(String dateStr, int i, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateStr);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.add(Calendar.MONDAY, i);

        return sdf.format(cal.getTime());
    }
}
