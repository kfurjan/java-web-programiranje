package hr.algebra.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kevin
 */
public class DateUtils {
    
    /**
     * Get current date and time as String.
     * 
     * @param pattern
     * @return Current date and time as String.
     */
    public static String getCurrentDate(String pattern) {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
