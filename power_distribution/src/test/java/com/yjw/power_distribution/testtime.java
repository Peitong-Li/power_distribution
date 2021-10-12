package com.yjw.power_distribution;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class testtime {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        Random random = new Random();
        Date date = new Date();

        System.out.println(date.getHours());
        int hour = random.nextInt(7) + 15 ;
        System.out.println("AA----" + hour);

    }
}
