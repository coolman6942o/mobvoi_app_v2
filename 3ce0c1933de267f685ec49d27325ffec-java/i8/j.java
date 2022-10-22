package i8;

import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends q<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f28150b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f28151a = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    /* renamed from: e */
    public synchronized Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == JsonToken.NULL) {
            aVar.g0();
            return null;
        }
        try {
            return new Date(this.f28151a.parse(aVar.i0()).getTime());
        } catch (ParseException e10) {
            throw new JsonSyntaxException(e10);
        }
    }

    /* renamed from: f */
    public synchronized void d(b bVar, Date date) throws IOException {
        bVar.r0(date == null ? null : this.f28151a.format((java.util.Date) date));
    }
}
