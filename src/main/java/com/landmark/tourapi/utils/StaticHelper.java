package com.landmark.tourapi.utils;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticHelper {

    public static Date intToDate(BigInteger dateTime, String format) {
        Date date = new Date();

        try {
            String stringTime = String.valueOf(dateTime);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(stringTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static Date stringToDate(String dateTime, String format) {
        Date date = new Date();

        try {
            String stringTime = String.valueOf(dateTime);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(stringTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static BigInteger dateToBigInteger(Date dateTime, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String stringTime = sdf.format(dateTime);
            return new BigInteger(stringTime);
        } catch (Exception e) {
            e.printStackTrace();
            return new BigInteger("0");
        }
    }

    public static String encodeUTF8(String keyword) {
        return URLEncoder.encode(keyword);
    }

}
