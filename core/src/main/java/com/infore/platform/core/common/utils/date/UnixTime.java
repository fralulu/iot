package com.infore.platform.core.common.utils.date;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;

public class UnixTime {

    public static long getStartUnixTimeOfTodayInSecond() {
        return LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static long getStartUnixTimeOfTodayInMillisecond() {
        return getStartUnixTimeOfTodayInSecond() * 1000L;
    }

    public static Timestamp getStartTimestampOfToday() {
        return new Timestamp(getStartUnixTimeOfTodayInMillisecond());
    }

    public static String getStartTimeStringOfToday() {
        return getStartTimestampOfToday().toString();
    }

    public static long getStopUnixTimeOfTodayInSecond() {
        return getStartUnixTimeOfTodayInSecond() + 86400L;
    }

    public static long getStopUnixTimeOfTodayInMillisecond() {
        return getStopUnixTimeOfTodayInSecond() * 1000L;
    }

    public static Timestamp getStopTimestampOfToday() {
        return new Timestamp(getStopUnixTimeOfTodayInMillisecond());
    }

    public static String getStopTimeStringOfToday() {
        return getStopTimestampOfToday().toString();
    }
}
