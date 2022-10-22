package com.google.gson.stream;

import com.mobvoi.wear.lpa.LpaConstants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f12673j = new String[128];

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f12674k;

    /* renamed from: a  reason: collision with root package name */
    private final Writer f12675a;

    /* renamed from: d  reason: collision with root package name */
    private String f12678d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12680f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12681g;

    /* renamed from: h  reason: collision with root package name */
    private String f12682h;

    /* renamed from: b  reason: collision with root package name */
    private int[] f12676b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f12677c = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f12679e = ":";

    /* renamed from: i  reason: collision with root package name */
    private boolean f12683i = true;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f12673j[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f12673j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f12674k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        T(6);
        Objects.requireNonNull(writer, "out == null");
        this.f12675a = writer;
    }

    private void E() throws IOException {
        if (this.f12678d != null) {
            this.f12675a.write("\n");
            int i10 = this.f12677c;
            for (int i11 = 1; i11 < i10; i11++) {
                this.f12675a.write(this.f12678d);
            }
        }
    }

    private b O(int i10, String str) throws IOException {
        d();
        T(i10);
        this.f12675a.write(str);
        return this;
    }

    private int Q() {
        int i10 = this.f12677c;
        if (i10 != 0) {
            return this.f12676b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void T(int i10) {
        int i11 = this.f12677c;
        int[] iArr = this.f12676b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[i11 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f12676b = iArr2;
        }
        int[] iArr3 = this.f12676b;
        int i12 = this.f12677c;
        this.f12677c = i12 + 1;
        iArr3[i12] = i10;
    }

    private void V(int i10) {
        this.f12676b[this.f12677c - 1] = i10;
    }

    private void c() throws IOException {
        int Q = Q();
        if (Q == 5) {
            this.f12675a.write(44);
        } else if (Q != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        E();
        V(4);
    }

    private void d() throws IOException {
        int Q = Q();
        if (Q == 1) {
            V(2);
            E();
        } else if (Q == 2) {
            this.f12675a.append(',');
            E();
        } else if (Q != 4) {
            if (Q != 6) {
                if (Q != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f12680f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            V(7);
        } else {
            this.f12675a.append((CharSequence) this.f12679e);
            V(5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j0(String str) throws IOException {
        String str2;
        String[] strArr = this.f12681g ? f12674k : f12673j;
        this.f12675a.write("\"");
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i10 < i11) {
                    this.f12675a.write(str, i10, i11 - i10);
                }
                this.f12675a.write(str2);
                i10 = i11 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                }
                this.f12675a.write(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            this.f12675a.write(str, i10, length - i10);
        }
        this.f12675a.write("\"");
    }

    private b n(int i10, int i11, String str) throws IOException {
        int Q = Q();
        if (Q != i11 && Q != i10) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f12682h == null) {
            this.f12677c--;
            if (Q == i11) {
                E();
            }
            this.f12675a.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f12682h);
        }
    }

    private void u0() throws IOException {
        if (this.f12682h != null) {
            c();
            j0(this.f12682h);
            this.f12682h = null;
        }
    }

    public b I() throws IOException {
        if (this.f12682h != null) {
            if (this.f12683i) {
                u0();
            } else {
                this.f12682h = null;
                return this;
            }
        }
        d();
        this.f12675a.write(LpaConstants.VALUE_NULL);
        return this;
    }

    public final void W(boolean z10) {
        this.f12681g = z10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12675a.close();
        int i10 = this.f12677c;
        if (i10 > 1 || (i10 == 1 && this.f12676b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f12677c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f12677c != 0) {
            this.f12675a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void g0(String str) {
        if (str.length() == 0) {
            this.f12678d = null;
            this.f12679e = ":";
            return;
        }
        this.f12678d = str;
        this.f12679e = ": ";
    }

    public b h() throws IOException {
        u0();
        return O(1, "[");
    }

    public final void h0(boolean z10) {
        this.f12680f = z10;
    }

    public b i() throws IOException {
        u0();
        return O(3, "{");
    }

    public final void i0(boolean z10) {
        this.f12683i = z10;
    }

    public b k0(long j10) throws IOException {
        u0();
        d();
        this.f12675a.write(Long.toString(j10));
        return this;
    }

    public b m0(Boolean bool) throws IOException {
        if (bool == null) {
            return I();
        }
        u0();
        d();
        this.f12675a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b o() throws IOException {
        return n(1, 2, "]");
    }

    public b o0(Number number) throws IOException {
        if (number == null) {
            return I();
        }
        u0();
        String obj = number.toString();
        if (this.f12680f || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            d();
            this.f12675a.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public b q() throws IOException {
        return n(3, 5, "}");
    }

    public b r0(String str) throws IOException {
        if (str == null) {
            return I();
        }
        u0();
        d();
        j0(str);
        return this;
    }

    public b t0(boolean z10) throws IOException {
        u0();
        d();
        this.f12675a.write(z10 ? "true" : "false");
        return this;
    }

    public final boolean u() {
        return this.f12683i;
    }

    public final boolean v() {
        return this.f12681g;
    }

    public boolean w() {
        return this.f12680f;
    }

    public b x(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f12682h != null) {
            throw new IllegalStateException();
        } else if (this.f12677c != 0) {
            this.f12682h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }
}
