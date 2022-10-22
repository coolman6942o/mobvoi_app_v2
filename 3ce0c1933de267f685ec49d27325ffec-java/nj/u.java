package nj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* compiled from: TimeToolUtils.java */
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f31296a = new SimpleDateFormat("HH:mm", Locale.getDefault());

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f31297b = new SimpleDateFormat("E, MMM dd, h:mma", Locale.getDefault());

    public static String a(long j10) {
        return f31296a.format(new Date(j10));
    }

    public static String b(long j10) {
        return f31297b.format(new Date(j10));
    }

    public static int c(long j10, int i10) {
        if (j10 <= 0) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return calendar.get(i10);
    }
}
