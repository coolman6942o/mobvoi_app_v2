package i8;

import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.internal.h;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class c extends q<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f28112b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<DateFormat> f28113a;

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f28113a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.e.e()) {
            arrayList.add(h.c(2, 2));
        }
    }

    private synchronized Date e(String str) {
        for (DateFormat dateFormat : this.f28113a) {
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

    /* renamed from: f */
    public Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() != JsonToken.NULL) {
            return e(aVar.i0());
        }
        aVar.g0();
        return null;
    }

    /* renamed from: g */
    public synchronized void d(b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.I();
        } else {
            bVar.r0(this.f28113a.get(0).format(date));
        }
    }
}
