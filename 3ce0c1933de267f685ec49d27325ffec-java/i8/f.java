package i8;

import com.google.gson.h;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.stream.b;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class f extends b {

    /* renamed from: o  reason: collision with root package name */
    private static final Writer f28120o = new a();

    /* renamed from: p  reason: collision with root package name */
    private static final n f28121p = new n("closed");

    /* renamed from: m  reason: collision with root package name */
    private String f28123m;

    /* renamed from: l  reason: collision with root package name */
    private final List<k> f28122l = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private k f28124n = l.f12652a;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public f() {
        super(f28120o);
    }

    private void A0(k kVar) {
        if (this.f28123m != null) {
            if (!kVar.e() || u()) {
                ((m) z0()).h(this.f28123m, kVar);
            }
            this.f28123m = null;
        } else if (this.f28122l.isEmpty()) {
            this.f28124n = kVar;
        } else {
            k z02 = z0();
            if (z02 instanceof h) {
                ((h) z02).h(kVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private k z0() {
        List<k> list = this.f28122l;
        return list.get(list.size() - 1);
    }

    @Override // com.google.gson.stream.b
    public b I() throws IOException {
        A0(l.f12652a);
        return this;
    }

    @Override // com.google.gson.stream.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f28122l.isEmpty()) {
            this.f28122l.add(f28121p);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.b
    public b h() throws IOException {
        h hVar = new h();
        A0(hVar);
        this.f28122l.add(hVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public b i() throws IOException {
        m mVar = new m();
        A0(mVar);
        this.f28122l.add(mVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public b k0(long j10) throws IOException {
        A0(new n(Long.valueOf(j10)));
        return this;
    }

    @Override // com.google.gson.stream.b
    public b m0(Boolean bool) throws IOException {
        if (bool == null) {
            return I();
        }
        A0(new n(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public b o() throws IOException {
        if (this.f28122l.isEmpty() || this.f28123m != null) {
            throw new IllegalStateException();
        } else if (z0() instanceof h) {
            List<k> list = this.f28122l;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public b o0(Number number) throws IOException {
        if (number == null) {
            return I();
        }
        if (!w()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        A0(new n(number));
        return this;
    }

    @Override // com.google.gson.stream.b
    public b q() throws IOException {
        if (this.f28122l.isEmpty() || this.f28123m != null) {
            throw new IllegalStateException();
        } else if (z0() instanceof m) {
            List<k> list = this.f28122l;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public b r0(String str) throws IOException {
        if (str == null) {
            return I();
        }
        A0(new n(str));
        return this;
    }

    @Override // com.google.gson.stream.b
    public b t0(boolean z10) throws IOException {
        A0(new n(Boolean.valueOf(z10)));
        return this;
    }

    public k w0() {
        if (this.f28122l.isEmpty()) {
            return this.f28124n;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f28122l);
    }

    @Override // com.google.gson.stream.b
    public b x(String str) throws IOException {
        if (this.f28122l.isEmpty() || this.f28123m != null) {
            throw new IllegalStateException();
        } else if (z0() instanceof m) {
            this.f28123m = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }
}
