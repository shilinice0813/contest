package com.contest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private static String currentDate;


    public static String getCurrentDate() {
        return currentDate;
    }

    public static void setCurrentDate(String newCurrentDate) {
        currentDate = newCurrentDate;
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param num     为增加的天数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static String plusDay(int num, String newDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date currdate = format.parse(newDate);
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        return enddate;
    }
}
