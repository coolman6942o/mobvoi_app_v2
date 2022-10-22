package bh;

import java.util.Calendar;
import java.util.Date;
/* compiled from: DateUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static Calendar a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 2015);
        calendar.set(2, 5);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Date b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTime();
    }

    public static Date c(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 1);
        return calendar.getTime();
    }
}
