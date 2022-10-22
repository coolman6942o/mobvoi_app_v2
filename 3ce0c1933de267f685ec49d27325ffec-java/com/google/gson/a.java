package com.google.gson;

import com.google.gson.internal.e;
import com.google.gson.internal.h;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes.dex */
final class a extends q<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Date> f12544a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f12545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f12545b = arrayList;
        this.f12544a = g(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private Date e(String str) {
        synchronized (this.f12545b) {
            for (DateFormat dateFormat : this.f12545b) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return j8.a.e(str, new ParsePosition(0));
            } catch (ParseException e10) {
                throw new JsonSyntaxException(str, e10);
            }
        }
    }

    private static Class<? extends Date> g(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    /* renamed from: f */
    public Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == JsonToken.NULL) {
            aVar.g0();
            return null;
        }
        Date e10 = e(aVar.i0());
        Class<? extends Date> cls = this.f12544a;
        if (cls == Date.class) {
            return e10;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(e10.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(e10.getTime());
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    public void d(b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.I();
            return;
        }
        synchronized (this.f12545b) {
            bVar.r0(this.f12545b.get(0).format(date));
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f12545b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public a(Class<? extends Date> cls, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f12545b = arrayList;
        this.f12544a = g(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (e.e()) {
            arrayList.add(h.c(i10, i11));
        }
    }
}
