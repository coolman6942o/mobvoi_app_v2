package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.huawei.hms.mlkit.common.ha.d;
import d7.j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: UtcDates.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    static AtomicReference<o> f10858a = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j10) {
        Calendar q5 = q();
        q5.setTimeInMillis(j10);
        return f(q5).getTimeInMillis();
    }

    private static int b(String str, String str2, int i10, int i11) {
        while (i11 >= 0 && i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            if (str.charAt(i11) == '\'') {
                do {
                    i11 += i10;
                    if (i11 >= 0 && i11 < str.length()) {
                    }
                } while (str.charAt(i11) != '\'');
            }
            i11 += i10;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat c(Locale locale) {
        return e("MMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat d(Locale locale) {
        return e("MMMEd", locale);
    }

    @TargetApi(24)
    private static DateFormat e(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(p());
        return instanceForSkeleton;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar f(Calendar calendar) {
        Calendar r10 = r(calendar);
        Calendar q5 = q();
        q5.set(r10.get(1), r10.get(2), r10.get(5));
        return q5;
    }

    private static java.text.DateFormat g(int i10, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i10, locale);
        dateInstance.setTimeZone(n());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat h(Locale locale) {
        return g(0, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat i(Locale locale) {
        return g(2, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat j(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) i(locale);
        simpleDateFormat.applyPattern(u(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(n());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(j.M);
        String string2 = resources.getString(j.L);
        String string3 = resources.getString(j.K);
        if (pattern.replaceAll("[^y]", "").length() == 1) {
            pattern = pattern.replace("y", "yyyy");
        }
        return pattern.replace(d.f14069a, string3).replace("M", string2).replace("y", string);
    }

    static o m() {
        o oVar = f10858a.get();
        return oVar == null ? o.c() : oVar;
    }

    private static TimeZone n() {
        return TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar o() {
        Calendar a10 = m().a();
        a10.set(11, 0);
        a10.set(12, 0);
        a10.set(13, 0);
        a10.set(14, 0);
        a10.setTimeZone(n());
        return a10;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone p() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar q() {
        return r(null);
    }

    static Calendar r(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(n());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat s(Locale locale) {
        return e("yMMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(24)
    public static DateFormat t(Locale locale) {
        return e("yMMMEd", locale);
    }

    private static String u(String str) {
        int b10 = b(str, "yY", 1, 0);
        if (b10 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b11 = b(str, str2, 1, b10);
        if (b11 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(b(str, str2, -1, b10) + 1, b11), " ").trim();
    }
}
