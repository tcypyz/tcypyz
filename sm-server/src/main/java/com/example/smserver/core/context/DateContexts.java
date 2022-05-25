package com.example.smserver.core.context;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/25
 */
public interface DateContexts {

    /** 默认的时间格式为"yyyy-MM-dd HH:mm:ss"，若后续有其他需求，则可以另行添加 */
    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 格式 "yyyy/MM/dd HH:mm:ss" */
    String DEFAULT_DATE_FORMAT_2 = "yyyy/MM/dd HH:mm:ss";

    /** 格式 "yyyy-MM-dd" */
    String DATE_FORMAT = "yyyy-MM-dd";

    String DATE_FORMAT_2 = "yyyy/MM/dd";

    /** 格式 "yyyy-MM" */
    String MONTH_FORMAT = "yyyy-MM";

    String MONTH_FORMAT_2 = "yyyy/MM";


    String DATE_MARK = "yyyyMMdd";

    String HOUR_MINUTE = "HH:mm";

}
