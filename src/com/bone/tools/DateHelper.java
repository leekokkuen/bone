package com.bone.tools;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	private static final Calendar min =
		new GregorianCalendar(1970,Calendar.JANUARY,1,0,0,0);

	private static final Calendar max =
		new GregorianCalendar(9999,Calendar.DECEMBER,31,23,59,59);

	private static Calendar currentTime;

	/**
	 * 设置当前时间，只能在测试代码中调用。
	 */
	public static void setCurrentDateTime(Calendar currentDateTime) {
		currentTime = currentDateTime;
	}

	public static Calendar getCurrentDateTime()	{
		if (currentTime != null) {
            return currentTime;
        }
	    return Calendar.getInstance();
	}

	public static Calendar getMin(){
        Calendar calendar = clone(min);
        return calendar;
	}

    public static Calendar getMax(){
        Calendar calendar = clone(max);
        return calendar;
    }

    public static Calendar getStartOfCurrent(){
    	return getStartOf(getCurrentDateTime());
    }

    public static Calendar getEndOfCurrent(){
    	return getEndOf(getCurrentDateTime());
    }

    /**
     * 获取指定时间的月末日期
     */
    public static Calendar getEndOfMonth(Calendar calendar){
    	calendar.set(Calendar.DATE, 1);
    	calendar.add(Calendar.MONTH, 1);
    	calendar.add(Calendar.DATE, -1);
    	return calendar;
    }
    /**
     * 获取指定日期的起始时间
     * 注: 有效期核心算法, 修改请谨慎.
     */
    public static Calendar getStartOf(final Calendar calendar){
        return new GregorianCalendar(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 获取指定日期的截止时间
     */
    public static Calendar getEndOf(final Calendar calendar){
        return new GregorianCalendar(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            23, 59, 59);
    }

    public static Calendar getFirstDateOfMonth(Calendar calendar){
    	Calendar dateTime = getCurrentDateTime();
    	dateTime.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
    	dateTime.set(Calendar.MONTH, calendar.get(Calendar.MONDAY));
    	dateTime.set(Calendar.DAY_OF_MONTH, 1);
    	dateTime.set(Calendar.HOUR_OF_DAY, 0);
    	dateTime.set(Calendar.MINUTE, 0);
    	dateTime.set(Calendar.SECOND, 0);
    	dateTime.set(Calendar.MILLISECOND, 0);
    	return dateTime;
    }

    /**
     *                                     日   一    二   三   四    五   六
     *clandar.get(Calendar.DAY_OF_WEEK)值:  1  2  3  4  5  6  7
     *到上一个周日需要天数：                                               7  1  2  3  4  5  6
     * @param clandar
     * @return
     */
    public static Calendar getPreviousSunday(Calendar clandar){
    	int dayOfWeek = clandar.get(Calendar.DAY_OF_WEEK);
    	String str = toString(clandar, datePattern);
    	int offsetDay = 0;
    	if(dayOfWeek==1){
    		offsetDay = 7;
    	}else{
    		offsetDay = dayOfWeek-1;
    	}
    	Calendar clone = (Calendar)clandar.clone();
    	clone.add(Calendar.DAY_OF_MONTH, -offsetDay);
    	return clone;
    }

    /**
     * 获取指定日期的次日起始时间
     */
    public static Calendar getNextDayStartOf(final Calendar date){
        Calendar calendar = clone(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return getStartOf(calendar);
    }

    public static Calendar getNextDayStart(){
        return getNextDayStartOf(DateHelper.getCurrentDateTime());
    }

    public static Calendar clone(final Calendar date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date.getTime());
        return calendar;
    }
    /**
     * 获取指定日期前一日的截止时间
     */
    public static Calendar getPreviousDayEndOf(final Calendar date){
        Calendar calendar = clone(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return getEndOf(calendar);
    }

    /**
     * yyyy-MM-dd
     */
	public static final String datePattern = "yyyy-MM-dd";
	/**
	 * yyyyMMdd
	 */
	public static final String datePattern2 = "yyyyMMdd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static final String dateMinutePattern = "yyyy-MM-dd HH:mm";
	/**
	 * yyyy-MM
	 */
	public static final String dateMonthPattern = "yyyy-MM";
	/**
	 * yyyyMM
	 */
	public static final String dateMonthPattern2 = "yyyyMM";
	/**
	 * yyyyMMdd HHmmss
	 */
	public static final String dateTimePattern2 = "yyyyMMdd HHmmss";
	/**
	 * yyyyMMddHHmmss
	 */
	public static final String dateTimePattern3 = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static final String dateTimePattern4 = "yyyy-MM-dd HH:mm:ss:SSS";
	/**
     * yyyyMMddHHmmssSSS
     */
    public static final String dateTimePattern5 = "yyyyMMddHHmmssSSS";
    /**
	 * yyyyMMddHHmm
	 */
	public static final String dateTimePattern6 = "yyyyMMddHHmm";
	/**
	 * HH:mm:ss
	 */
	public static final String timePattern = "HH:mm:ss";
	/**
	 * HH:mm
	 */
	public static final String hourMinutesPattern = "HH:mm";
	public static final String MonthAndDatePattern = "MMdd";

	public static String toTimeString(Calendar calendar){
		return toDateString(calendar, timePattern);
	}


	public static String toHourMinutesPattern(Calendar calendar){
		return toDateString(calendar, hourMinutesPattern);
	}

	/**
	 *  转换成字符串 格式: yyyy-MM-dd
	 * @param calendar
	 * @return
	 */
	public static String toDateString(Calendar calendar){
		return toDateString(calendar, datePattern);
	}
	/**
	 *格式yyyyMMdd
	 */
	public static String toDateString2(Calendar calendar){
		return toDateString(calendar, datePattern2);
	}
	public static String toDateTimeString(Calendar calendar){
		return toDateString(calendar, dateTimePattern);
	}
	public static String toDateTimeString2(Calendar calendar){
		return toDateString(calendar, dateTimePattern2);
	}
	public static String toDateTimeString3(Calendar calendar) {
        return toDateString(calendar, dateTimePattern3);
    }
	public static String toDateTimeString4(Calendar calendar) {
        return toDateString(calendar, dateTimePattern4);
    }
	public static String toDateTimeString5(Calendar calendar) {
        return toDateString(calendar, dateTimePattern5);
    }

	public static String toDateTimeString6(Calendar calendar) {
        return toDateString(calendar, dateTimePattern6);
    }

	public static String toDateMonthString(Calendar calendar){
		return toDateString(calendar, dateMonthPattern);
	}

	public static String toDateMonthString2(Calendar calendar){
        return toDateString(calendar, dateMonthPattern2);
    }

	public static String toDateMinuteString(Calendar calendar){
        return toDateString(calendar, dateMinutePattern);
    }
	/**
	 * 月日(MMdd)格式
	 * @param calendar
	 * @return
	 */
	public static String toMonthAndDateString(Calendar calendar){
		return toDateString(calendar, MonthAndDatePattern);
	}
	/**
	 * 时间转化
	 *
	 * @param calendar 时间
	 * @param pattern 传入匹配模式
	 * @return 格式化后的时间字符串
	 */
	public static String toDateString(Calendar calendar,String pattern){
        if(calendar==null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(calendar.getTime());
    }

	/**
	 * 用诸如2007-01-02构造
	 */
    public static Calendar toCalendar(String s){
    		Calendar c =getStartOf(Calendar.getInstance());
    		c.set(
    				Integer.parseInt(s.substring(0, 4)),
    				Integer.parseInt(s.substring(5,7))-1,
    				Integer.parseInt(s.substring(8, 10))
    				);
        return c;
    }

    /**
	 * 用诸如2007-01-02 00:00:00构造
     */
    public static Calendar toCalendar2(String s){
    		Calendar c =getStartOf(Calendar.getInstance());
    		c.set(
    				Integer.parseInt(s.substring(0, 4)),
    				Integer.parseInt(s.substring(5,7))-1,
    				Integer.parseInt(s.substring(8, 10)),
    				Integer.parseInt(s.substring(11, 13)),
    				Integer.parseInt(s.substring(14, 16)),
    				Integer.parseInt(s.substring(17, 19))
    				);
        return c;
    }


    /**
	 * 用诸如20070102 000000构造
     */
    public static Calendar toCalendar3(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1,
				Integer.parseInt(s.substring(6, 8)),
				Integer.parseInt(s.substring(9, 11)),
				Integer.parseInt(s.substring(11, 13)),
				Integer.parseInt(s.substring(13, 15))
				);
		return c;
    }

    /**
	 * 用诸如20070102构造
     */
    public static Calendar toCalendar4(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(
				Integer.parseInt(s.substring(0, 4)),
				Integer.parseInt(s.substring(4,6))-1,
				Integer.parseInt(s.substring(6, 8))
				);
		return c;
    }

    /**
	 * 用诸如22:00:00构造
     */
    public static Calendar toCalendar6(String s){
		Calendar c =getStartOf(Calendar.getInstance());
		c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(s.substring(0,2)));
		c.set(Calendar.MINUTE, Integer.parseInt(s.substring(3,5)));
		c.set(Calendar.SECOND, Integer.parseInt(s.substring(6,7)));
		return c;
    }

    /**
     * 用诸如20070102000000构造
     */
    public static Calendar toCalendar5(String s){
        Calendar c =getStartOf(Calendar.getInstance());
        c.set(
                Integer.parseInt(s.substring(0, 4)),
                Integer.parseInt(s.substring(4,6))-1,
                Integer.parseInt(s.substring(6, 8)),
                Integer.parseInt(s.substring(8, 10)),
                Integer.parseInt(s.substring(10, 12)),
                Integer.parseInt(s.substring(12, 14))
                );
        return c;
    }
	/**
	 * 获取两个日期之间相差的天数，不足一天按一天计
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getDurationDays(Calendar start, Calendar end) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		assert start.compareTo(end) <= 0 : MessageFormat.format(
				"开始日期“{0}”大于截止日期“{1}”",
				dateFormat.format(start.getTime()),
				dateFormat.format(end.getTime()));
		long mod = (end.getTimeInMillis() - start.getTimeInMillis())
				% (24 * 60 * 60 * 1000);
		long days = (end.getTimeInMillis() - start.getTimeInMillis())
				/ (24 * 60 * 60 * 1000) + (mod == 0 ? 0 : 1);
		return days;
	}

	/**
	 * 获取两个日期之间相差的计费天数
	 */
	public static long getChargeDays(Calendar start, Calendar end) {
		long mod = (end.getTimeInMillis() - start.getTimeInMillis())
				% (24 * 60 * 60 * 1000);
		long days = (end.getTimeInMillis() - start.getTimeInMillis())
				/ (24 * 60 * 60 * 1000) + (mod == 0 ? 0 : (mod > 0 ? 1 : -1));
		// 如果开始、结束日期在同一天算0天
		if (Math.abs(days) == 1
				&& start.get(Calendar.DAY_OF_MONTH) == end.get(Calendar.DAY_OF_MONTH)) {
            days = 0;
        }
		return days;
	}


    public static Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar;
    }

    /**
     * dateTime 是否是当前月中的时间
     * @param dateTime
     * @return
     */
    public static boolean isCurrentMonthDateTime(Calendar dateTime){
    	assert dateTime!=null : "dateTime不能为空";

    	int currentYear = getCurrentDateTime().get(Calendar.YEAR);
    	int currentMonth = getCurrentDateTime().get(Calendar.MONTH);

    	int dateTimeYear = dateTime.get(Calendar.YEAR);
    	int dateTimeMonth = dateTime.get(Calendar.MONTH);

    	return (currentYear==dateTimeYear && currentMonth==dateTimeMonth);
    }

    public static boolean isFirstDayOfMonth(Calendar dateTime){
    	return dateTime.get(Calendar.DAY_OF_MONTH)==1;
    }

    public static Calendar getCurrentMonthStartDateTime(){
    	Calendar startDateTime = getCurrentDateTime();

    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    public static Calendar getNextMonthStartDateTime(){
    	Calendar startDateTime = getCurrentDateTime();

    	startDateTime.add(Calendar.MONTH, 1);
    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    /**
     * 返回传入时间的次月月首时间
     * 注: 有效期核心算法, 修改请谨慎.
     * @param date
     * @return
     */
    public static Calendar getNextMonthStartDateTime(Calendar date){
    	Calendar startDateTime = DateHelper.clone(date);

    	startDateTime.add(Calendar.MONTH, 1);
    	startDateTime.set(Calendar.DAY_OF_MONTH, 1);
    	startDateTime.set(Calendar.HOUR_OF_DAY, 0);
    	startDateTime.set(Calendar.MINUTE, 0);
    	startDateTime.set(Calendar.SECOND, 0);
    	startDateTime.set(Calendar.MILLISECOND, 0);

    	return startDateTime;
    }

    public static Calendar toCalendar(String dateTime, String dateFormatter) {
    	DateFormat dateFormat = new SimpleDateFormat(dateFormatter);
    	Date date;
		try {
			date = dateFormat.parse(dateTime);
		} catch (ParseException e) {
			throw new Error("解析错误，时间格式：" + dateFormatter + "，时间：" + dateTime, e);
		}
    	return toCalendar(date);
    }

    public static String toString(Calendar dateTime, String dateFormatter) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatter);
		return dateFormat.format(dateTime.getTime());
    }

    /**
     * 取参数中较小的那个日期
     */
	public static Calendar min(Calendar... dates) {
		return Collections.min(Arrays.asList(dates));
	}

    /**
     * 取参数中较大的那个日期
     */
	public static Calendar max(Calendar... dates) {
		return Collections.max(Arrays.asList(dates));
	}
	
	/**
	 * 比较两个时间之间相差多少小时
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getHoursDifference(Calendar start, Calendar end){
		return (end.getTimeInMillis() - start.getTimeInMillis()) / (60 * 60 * 1000);
	}

	
	/**
	 * 计算两个日期相差的天数，忽略参数中日期的 小时、分钟、秒
	 * 注: 有效期核心算法, 修改请谨慎.
	 * @param start
	 * @param end
	 * @return
	 */
	public static long getDaysDifference(Calendar start, Calendar end) {
		start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DATE), 0, 0, 0);
		end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), end.get(Calendar.DATE), 0, 0, 0);
		return (end.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
	}


	public static boolean isSameDate(Calendar c1,Calendar c2){
		return toDateString(c1).equals(toDateString(c2));
	}

	public static boolean isDifferentDay(Calendar calendar, Calendar otherCalendar){
		return !isSameDay(calendar,otherCalendar);
	}
	public static boolean isSameDay(Calendar calendar, Calendar otherCalendar){
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		int otherYear = otherCalendar.get(Calendar.YEAR);
		int otherMonth = otherCalendar.get(Calendar.MONTH);
		int otherDayOfMonth = otherCalendar.get(Calendar.DAY_OF_MONTH);

		if(year==otherYear&&month==otherMonth&&dayOfMonth==otherDayOfMonth){
			return true;
		}else{
			return false;
		}
	}

	public static Calendar getStartOfMonth(final Calendar date){
		  return new GregorianCalendar(
				  date.get(Calendar.YEAR),
				  date.get(Calendar.MONTH),1);
	}


	/**
	 * 判断所给的日期是否为整月
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isFullMonth(String date1,String date2){
		Calendar d1 = toCalendar(date1,datePattern2);
		Calendar d2 = toCalendar(date2,datePattern2);
		return isFullMonth(d1,d2);
	}

	/**
	 * 判断所给的日期是否为整月
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isFullMonth(Calendar date1, Calendar date2) {
		int syear = date1.get(Calendar.YEAR);
		int smonth = date1.get(Calendar.MONTH);
		int eyear = date2.get(Calendar.YEAR);
		int emonth = date2.get(Calendar.MONTH);
		if (!(syear == eyear && smonth == emonth)) {
            return false;
        }
		Calendar monthStart = getStartOfMonth(clone(date1));
		Calendar monthEnd = getEndOfMonth(clone(date2));
		return (monthStart.get(Calendar.DAY_OF_MONTH) == date1
				.get(Calendar.DAY_OF_MONTH))
				&& (monthEnd.get(Calendar.DAY_OF_MONTH) == date2
						.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 取calendar时间所在月的天数
	 * 注: 有效期核心算法, 修改请谨慎.
	 */
	public static int getDaysOfMonth(Calendar calendar) {
		return getEndOfMonth(clone(calendar)).get(Calendar.DATE);
	}

	/**
	 * 计算两个时间之间的天数，计算时去除时分秒
	 */
	public static int getDays(Calendar startC, Calendar endC) {
		startC = DateHelper.getStartOf(startC);
		endC = DateHelper.getStartOf(endC);
		long days = (endC.getTimeInMillis() - startC.getTimeInMillis())
				/ (1000 * 60 * 60 * 24);
		return (int) days;
	}

	/**
	 * 方案1：产品首个计费日
	 *       如果日期中的天数为29、30、31，则把日期变化为下月一号
	 *       如果日期在1到28号之间，则取原值即可
	 *
	 * 方案1暂时废弃，取原值
	 *
	 */
	public static Calendar getStartDayByProductChargeType(Calendar date) {
		return date;
//		if(date.get(Calendar.DATE) > 28) {
//			return getNextMonthStartDateTime(date);
//		}else {
//			return date;
//		}
	}

	/**
	 * 判断两个日期是否为同一个月
	 */
	public static boolean isSameMonth(Calendar calendar1, Calendar calendar2) {
		return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
				&& calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
	}

	/**
	 * 取两个时间段之间相差的自然月月份数
	 */
	public static int getCountMonths(Calendar start, Calendar end) {
		int startMonths = start.get(Calendar.YEAR) * 12 + start.get(Calendar.MONTH);
		int endMonths = end.get(Calendar.YEAR) * 12 + end.get(Calendar.MONTH);
		return (startMonths > endMonths ? startMonths - endMonths : endMonths - startMonths);
	}

	/**
	 * 到期时间给减一秒，符合阅读习惯
	 */
	public static Calendar processEndValidFor(Calendar calendar){
		if(calendar==null) {
            return null;
        }
		Calendar c = (Calendar)calendar.clone();
		c.add(Calendar.SECOND, -1);
		return c;
	}

	public static Calendar addTime(Calendar calendar, int calendarField, int amount){
	    Calendar result = clone(calendar);
	    result.add(calendarField, amount);
	    return result;
	}

	/**
	 * 获取指定日期的当前月开始日期时间
	 *
	 * @param calendar
	 *            2012/12/04 10:23:32
	 * @return 2012/12/01 00:00:00
	 */
	public static Calendar getMonthStartDateTime(final Calendar calendar) {
		Calendar startDateTime = DateHelper.clone(calendar);

		startDateTime.set(Calendar.DAY_OF_MONTH, 1);
		startDateTime.set(Calendar.HOUR_OF_DAY, 0);
		startDateTime.set(Calendar.MINUTE, 0);
		startDateTime.set(Calendar.SECOND, 0);
		startDateTime.set(Calendar.MILLISECOND, 0);

		return startDateTime;
	}

	/**
	 * 获取指定日期的月末日期时间
	 *
	 * @param calendar
	 *            2012/12/04 10:23:32
	 * @return 2012/12/31 23:59:59
	 */
	public static Calendar getMonthEndDateTime(final Calendar calendar) {
		Calendar dateTime = DateHelper.clone(calendar);

		dateTime.set(Calendar.DATE, 1);
		dateTime.add(Calendar.MONTH, 1);
		dateTime.add(Calendar.DATE, -1);
		dateTime.set(Calendar.HOUR_OF_DAY, 23);
		dateTime.set(Calendar.MINUTE, 59);
		dateTime.set(Calendar.SECOND, 59);
		dateTime.set(Calendar.MILLISECOND, 999);

		return dateTime;
	}
}