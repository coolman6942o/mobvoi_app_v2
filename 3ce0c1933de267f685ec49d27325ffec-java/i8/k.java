package i8;

import com.google.gson.JsonSyntaxException;
import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.b;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class k extends q<Time> {

    /* renamed from: b  reason: collision with root package name */
    public static final r f28152b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f28153a = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> a(e eVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    /* renamed from: e */
    public synchronized Time b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.k0() == JsonToken.NULL) {
            aVar.g0();
            return null;
        }
        try {
            return new Time(this.f28153a.parse(aVar.i0()).getTime());
        } catch (ParseException e10) {
            throw new JsonSyntaxException(e10);
        }
    }

    /* renamed from: f */
    public synchronized void d(b bVar, Time time) throws IOException {
        bVar.r0(time == null ? null : this.f28153a.format((Date) time));
    }
}
