package demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangpeng
 * @description
 * @date 2021-01-06 下午3:00
 **/
public class TimeUtil {

    private static final String PATTERN_DATE_TIME_STANDARD = "yyyy-MM-dd HH:mm:ss";
    private static final String PATTERN_DATE_TIME_MINUTE = "yyyy-MM-dd HH:mm";
    private static final String PATTERN_DATE_TIME_HOUR = "yyyy-MM-dd HH";

    private static final String PATTERN_DATE_ALL = "yyyy-MM-dd";
    private static final String PATTERN_DATE_MONTH = "yyyy-MM";
    private static final String PATTERN_DATE_YEAR = "yyyy";

    private static final ThreadLocal<SimpleDateFormat> DATE_TIME_STANDARD_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat(PATTERN_DATE_TIME_STANDARD));

    private static final ThreadLocal<SimpleDateFormat> DATE_TIME_MINUTE_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat(PATTERN_DATE_TIME_MINUTE));

    public static String formatTimeStandard(Date date){
        return DATE_TIME_STANDARD_FORMATTER.get().format(date);
    }

    public static String formatTimeMinute(Date date){
        return DATE_TIME_MINUTE_FORMATTER.get().format(date);
    }

}
