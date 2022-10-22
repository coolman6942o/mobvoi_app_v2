package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;
/* compiled from: TimeSource.java */
/* loaded from: classes.dex */
class o {

    /* renamed from: c  reason: collision with root package name */
    private static final o f10855c = new o(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f10856a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f10857b;

    private o(Long l10, TimeZone timeZone) {
        this.f10856a = l10;
        this.f10857b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c() {
        return f10855c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f10857b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l10 = this.f10856a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
