package com.example.smserver.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/16
 */
public class DateUtils {

    /**
     * 将 Date 转为 LocalDateTime
     *
     * @param date 日期
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
