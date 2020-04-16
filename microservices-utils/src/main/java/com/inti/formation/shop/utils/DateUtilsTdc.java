package com.inti.formation.shop.utils;



import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class DateUtilsTdc {
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSXXX_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSSSSXXX_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX";
    public static final String YYYY_MM_DD_T_HH_MM_SS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZZZZ_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ";

    /**
     * Convert date format to timestamp
     * @return
     */
    public static long stringToTimestamp(final String  dateString) {
        long time = 0;
        DateTimeFormatter formatter;
        LocalDateTime dateTime;
        /*
          Format date trying
         */
        try {
            formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_T_HH_MM_SS_SSSSSSXXX_PATTERN);
            dateTime = LocalDateTime.parse(dateString, formatter);
            time = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } catch (DateTimeException e1) {
            try {
                formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_T_HH_MM_SS_SSSXXX_PATTERN);
                dateTime = LocalDateTime.parse(dateString, formatter);
                time = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            } catch (DateTimeException e2) {
                try {
                    formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_T_HH_MM_SS_SSSZZZZ_PATTERN);
                    dateTime = LocalDateTime.parse(dateString, formatter);
                    time = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                } catch (DateTimeException e3) {
                    //log.error("Error during the date format operation {} ", e3.getMessage());
                }
            }
        }
       return time;

    }

    /**
     * Convert date format to timestamp
     * @param dateString
     * @return
     */
    public static long stringToTimestamp(final String  dateString, final String  format) {
        long time = 0;
        DateTimeFormatter formatter;
        LocalDateTime dateTime;
        /*
          Format date trying
         */
        try {
            formatter = DateTimeFormatter.ofPattern(format);
            dateTime = LocalDateTime.parse(dateString, formatter);
            time = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } catch (DateTimeException e) {
           // log.error("Error during the date format operation {} ", e.getMessage());
       }
        return time;

    }
}
