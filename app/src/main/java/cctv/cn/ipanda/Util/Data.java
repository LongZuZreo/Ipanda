package cctv.cn.ipanda.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/4/13.
 */

public class Data {


    /**
     * android中将毫秒数转化为日期格式
     *
     * @param pattern
     * @param dateTime
     * @return
     */
    public static String getFormatedDateTime(String pattern, long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
        return sDateFormat.format(new Date(dateTime + 0));
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    private String getData() {
        // TODO Auto-generated method stub
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd `");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }
}
