package eg;

import android.app.Application;
import com.mobvoi.android.common.utils.b;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import mf.d;
/* compiled from: CalendarUtils.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f26040a = (int) TimeUnit.DAYS.toSeconds(1);

    /* renamed from: b  reason: collision with root package name */
    public static final int f26041b = (int) TimeUnit.MINUTES.toSeconds(30);

    public static Calendar a(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return n(calendar);
    }

    public static long b(long j10) {
        return a(j10).getTimeInMillis();
    }

    public static int c(int i10) {
        return (int) TimeUnit.MILLISECONDS.toSeconds(a(TimeUnit.SECONDS.toMillis(i10)).getTimeInMillis());
    }

    public static Calendar d(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return p(calendar);
    }

    public static long e(boolean z10) {
        Calendar calendar = Calendar.getInstance();
        if (z10) {
            calendar.set(2, 0);
        } else {
            calendar.set(2, 6);
        }
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static String f(long j10) {
        long currentTimeMillis = System.currentTimeMillis() - j10;
        if (j10 <= 0 || currentTimeMillis < 0 || currentTimeMillis > TimeUnit.DAYS.toMillis(1L)) {
            return "";
        }
        Application e10 = b.e();
        int i10 = (int) (currentTimeMillis / 1000);
        if (i10 < 60) {
            return e10.getString(d.f30680c);
        }
        if (i10 < 3600) {
            int i11 = d.f30683d;
            return e10.getString(i11, (i10 / 60) + "");
        } else if (i10 < 86400) {
            int i12 = d.f30677b;
            return e10.getString(i12, ((i10 / 60) / 60) + "");
        } else {
            int i13 = d.f30674a;
            return e10.getString(i13, (((i10 / 60) / 60) / 24) + "");
        }
    }

    public static long g() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    public static long h() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar.set(7, calendar.getFirstDayOfWeek());
        return calendar.getTimeInMillis();
    }

    public static long i() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.clear(12);
        calendar.clear(13);
        calendar.clear(14);
        calendar.set(6, 1);
        return calendar.getTimeInMillis();
    }

    public static int j() {
        return (int) TimeUnit.MILLISECONDS.toSeconds(a(System.currentTimeMillis()).getTimeInMillis());
    }

    public static boolean k(int i10, int i11) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return l(timeUnit.toMillis(i10), timeUnit.toMillis(i11));
    }

    public static boolean l(long j10, long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        return m(calendar, calendar2);
    }

    private static boolean m(Calendar calendar, Calendar calendar2) {
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    public static Calendar n(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar o(Calendar calendar) {
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public static Calendar p(Calendar calendar) {
        long j10 = 30;
        if (calendar.get(12) < 30) {
            j10 = 0;
        }
        return q(calendar.getTimeInMillis(), (int) j10);
    }

    public static Calendar q(long j10, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        calendar.set(12, i10);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }
}
