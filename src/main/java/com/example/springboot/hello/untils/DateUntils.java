package com.example.springboot.hello.untils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUntils {
    //获取当前系统时间
    public static String getCurrentDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(System.currentTimeMillis());
        return date;
    }
    /**
     * 增加时间单位：天
     * @param day
     * @return
     */
    public static Date addDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }
}
