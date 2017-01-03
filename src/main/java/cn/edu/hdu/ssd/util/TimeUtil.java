/*
 * File Name: TimeUtil.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年8月26日

 * Modifier: Pi Chen
 * Modify Date: 2016年8月26日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.ssd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.edu.hdu.ssd.common.log.Logger;

/**
 * 时间工具类
 * 
 * 
 * @author Pi Chen
 * @version ssd V1.0.0, 2016年12月14日
 * @see
 * @since ssd V1.0.0
 */

public class TimeUtil
{
    public static Logger logger = Logger.getLogger(TimeUtil.class);
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YEARTIME_POSTFIX = "-01-01 00:00:00";
    public static final String MONTHTIME_POSTFIX = "-01 00:00:00";

    
    
    /**
     * 获取年初时间
     *
     * @return
     */
    public static String getCurYearStartTime()
    {
        return new GregorianCalendar().get(Calendar.YEAR) + YEARTIME_POSTFIX;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurTime()
    {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(new Date());
    }

    /**
     * 获取去年年初时间
     *
     * @return
     */
    public static String getLastYearStartTime()
    {
        return (new GregorianCalendar().get(Calendar.YEAR) - 1) + YEARTIME_POSTFIX;
    }

    /**
     * 获取去年当前时间
     *
     * @return
     */
    public static String getLastYearCurTime()
    {
        return getDate(new Date(), -1, 0, 0, 0);
    }

    /**
     *
     * 根据指定时间差获取时间
     *
     * @param comparedDate
     * @param y
     * @param m
     * @param d
     * @param h
     * @return
     */
    public static String getDate(Date comparedDate, int y, int m, int d, int h)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(comparedDate);
        calendar.add(Calendar.YEAR, y);
        calendar.add(Calendar.MONTH, m);
        calendar.add(Calendar.DATE, d);
        calendar.add(Calendar.HOUR, h);
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return formatter.format(date);
    }

    
    public static String getDate(String date, int y, int m, int d, int h ) {

        SimpleDateFormat sdf =   new SimpleDateFormat( DATE_TIME_FORMAT);
         String time="2000-01-01 00:00:00";
        try
        {
            time = TimeUtil.getDate(sdf.parse(date), y, m, d, h);
        }
        catch (ParseException e)
        {
            logger.error(e.toString(), e);

        }
         return time;
    }
}
