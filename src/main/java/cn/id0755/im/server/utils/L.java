package cn.id0755.im.server.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class L {
    private final static String TAG = "logger";
    private static Logger logger = LoggerFactory.getLogger(TAG);

    public static void v(String tag, String logStr, Object... args) {
        logger.info(appendTag(tag, logStr), args);
    }

    public static void d(String tag, String logStr, Object... args) {
        logger.debug(appendTag(tag, logStr), args);
    }

    public static void w(String tag, String logStr, Object... args) {
        logger.warn(appendTag(tag, logStr), args);
    }

    public static void e(String tag, String logStr, Object... args) {
        logger.error(appendTag(tag, logStr), args);
    }

    private static String appendTag(String tag, String logStr) {
        StringBuilder sb = new StringBuilder(tag);
        sb.append(" : ");
        sb.append(logStr);
        return sb.toString();
    }
}
