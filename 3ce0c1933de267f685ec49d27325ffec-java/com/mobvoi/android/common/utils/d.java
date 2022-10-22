package com.mobvoi.android.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* compiled from: DateTimeUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static TimeZone f15425a;

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f15426b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);

    public static String a(long j10) {
        b();
        return f15426b.format(new Date(j10));
    }

    private static void b() {
        if (f15425a == null) {
            TimeZone timeZone = TimeZone.getDefault();
            SimpleDateFormat simpleDateFormat = f15426b;
            if (!timeZone.equals(simpleDateFormat.getTimeZone())) {
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
            }
        }
    }
}
