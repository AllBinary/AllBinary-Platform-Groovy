/* Generated Code Do Not Modify */
package org.allbinary.time;

import java.util.Calendar;
import java.util.TimeZone;

/**  *  * @author User  */
@groovy.transform.CompileStatic
public class TimeTypeUtil {
    private static final TimeTypeUtil instance = new TimeTypeUtil();

    /**      * @return the instance      */
    public static TimeTypeUtil getInstance() {
        return TimeTypeUtil.instance;
    }

    public final String NIGHT = 'Night';

    public final String DAY = 'Day';

    //    public final String THE_WITCHING_HOUR = "The Witching Hour";
    public boolean isNight() {
        final int hoursOfDay = this.getHourOfDay();
        return hoursOfDay < 6 || hoursOfDay > 18;
    }

    public int getHourOfDay() {
        //return LocalTime.now().getHour();
        final Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public String getNightOrDay() {
        return this.isNight() ? this.NIGHT : this.DAY;
    }

    public int getHourOfDay(long timeInMillis) {
        //return hoursOfDay < 6 || hoursOfDay > 18;        
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public boolean isNight(long timeInMillis) {
        final int hoursOfDay = this.getHourOfDay(timeInMillis);
        return hoursOfDay < 6 || hoursOfDay > 18;
    }

    public String getNightOrDay(long timeInMillis) {
        return this.isNight(timeInMillis) ? this.NIGHT : this.DAY;
    }

}


