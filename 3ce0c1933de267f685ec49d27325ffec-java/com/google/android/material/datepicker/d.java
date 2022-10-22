package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateStrings.java */
/* loaded from: classes.dex */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0.d<String, String> a(Long l10, Long l11) {
        return b(l10, l11, null);
    }

    static j0.d<String, String> b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return j0.d.a(null, null);
        }
        if (l10 == null) {
            return j0.d.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return j0.d.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar o10 = p.o();
        Calendar q5 = p.q();
        q5.setTimeInMillis(l10.longValue());
        Calendar q10 = p.q();
        q10.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return j0.d.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        } else if (q5.get(1) != q10.get(1)) {
            return j0.d.a(k(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault()));
        } else {
            if (q5.get(1) == o10.get(1)) {
                return j0.d.a(f(l10.longValue(), Locale.getDefault()), f(l11.longValue(), Locale.getDefault()));
            }
            return j0.d.a(f(l10.longValue(), Locale.getDefault()), k(l11.longValue(), Locale.getDefault()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j10) {
        return d(j10, null);
    }

    static String d(long j10, SimpleDateFormat simpleDateFormat) {
        Calendar o10 = p.o();
        Calendar q5 = p.q();
        q5.setTimeInMillis(j10);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j10));
        }
        if (o10.get(1) == q5.get(1)) {
            return e(j10);
        }
        return j(j10);
    }

    static String e(long j10) {
        return f(j10, Locale.getDefault());
    }

    static String f(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.c(locale).format(new Date(j10));
        }
        return p.j(locale).format(new Date(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(long j10) {
        return h(j10, Locale.getDefault());
    }

    static String h(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.d(locale).format(new Date(j10));
        }
        return p.h(locale).format(new Date(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(Context context, long j10) {
        return DateUtils.formatDateTime(context, j10 - TimeZone.getDefault().getOffset(j10), 36);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(long j10) {
        return k(j10, Locale.getDefault());
    }

    static String k(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.s(locale).format(new Date(j10));
        }
        return p.i(locale).format(new Date(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j10) {
        return m(j10, Locale.getDefault());
    }

    static String m(long j10, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return p.t(locale).format(new Date(j10));
        }
        return p.h(locale).format(new Date(j10));
    }
}
