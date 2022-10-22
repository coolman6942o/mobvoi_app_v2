package i8;

import com.google.gson.h;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.stream.JsonToken;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class e extends com.google.gson.stream.a {

    /* renamed from: u  reason: collision with root package name */
    private static final Object f28115u = new Object();

    /* renamed from: q  reason: collision with root package name */
    private Object[] f28116q;

    /* renamed from: r  reason: collision with root package name */
    private int f28117r;

    /* renamed from: s  reason: collision with root package name */
    private String[] f28118s;

    /* renamed from: t  reason: collision with root package name */
    private int[] f28119t;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes.dex */
    static class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        new a();
    }

    private String E() {
        return " at path " + a();
    }

    private void J0(JsonToken jsonToken) throws IOException {
        if (k0() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + k0() + E());
        }
    }

    private Object K0() {
        return this.f28116q[this.f28117r - 1];
    }

    private Object L0() {
        Object[] objArr = this.f28116q;
        int i10 = this.f28117r - 1;
        this.f28117r = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    private void N0(Object obj) {
        int i10 = this.f28117r;
        Object[] objArr = this.f28116q;
        if (i10 == objArr.length) {
            Object[] objArr2 = new Object[i10 * 2];
            int[] iArr = new int[i10 * 2];
            String[] strArr = new String[i10 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            System.arraycopy(this.f28119t, 0, iArr, 0, this.f28117r);
            System.arraycopy(this.f28118s, 0, strArr, 0, this.f28117r);
            this.f28116q = objArr2;
            this.f28119t = iArr;
            this.f28118s = strArr;
        }
        Object[] objArr3 = this.f28116q;
        int i11 = this.f28117r;
        this.f28117r = i11 + 1;
        objArr3[i11] = obj;
    }

    @Override // com.google.gson.stream.a
    public void H0() throws IOException {
        if (k0() == JsonToken.NAME) {
            V();
            this.f28118s[this.f28117r - 2] = LpaConstants.VALUE_NULL;
        } else {
            L0();
            int i10 = this.f28117r;
            if (i10 > 0) {
                this.f28118s[i10 - 1] = LpaConstants.VALUE_NULL;
            }
        }
        int i11 = this.f28117r;
        if (i11 > 0) {
            int[] iArr = this.f28119t;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean I() throws IOException {
        J0(JsonToken.BOOLEAN);
        boolean h10 = ((n) L0()).h();
        int i10 = this.f28117r;
        if (i10 > 0) {
            int[] iArr = this.f28119t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return h10;
    }

    public void M0() throws IOException {
        J0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) K0()).next();
        N0(entry.getValue());
        N0(new n((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public double O() throws IOException {
        JsonToken k02 = k0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (k02 == jsonToken || k02 == JsonToken.STRING) {
            double j10 = ((n) K0()).j();
            if (w() || (!Double.isNaN(j10) && !Double.isInfinite(j10))) {
                L0();
                int i10 = this.f28117r;
                if (i10 > 0) {
                    int[] iArr = this.f28119t;
                    int i11 = i10 - 1;
                    iArr[i11] = iArr[i11] + 1;
                }
                return j10;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + j10);
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + k02 + E());
    }

    @Override // com.google.gson.stream.a
    public int Q() throws IOException {
        JsonToken k02 = k0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (k02 == jsonToken || k02 == JsonToken.STRING) {
            int k10 = ((n) K0()).k();
            L0();
            int i10 = this.f28117r;
            if (i10 > 0) {
                int[] iArr = this.f28119t;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return k10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + k02 + E());
    }

    @Override // com.google.gson.stream.a
    public long T() throws IOException {
        JsonToken k02 = k0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (k02 == jsonToken || k02 == JsonToken.STRING) {
            long l10 = ((n) K0()).l();
            L0();
            int i10 = this.f28117r;
            if (i10 > 0) {
                int[] iArr = this.f28119t;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return l10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + k02 + E());
    }

    @Override // com.google.gson.stream.a
    public String V() throws IOException {
        J0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) K0()).next();
        String str = (String) entry.getKey();
        this.f28118s[this.f28117r - 1] = str;
        N0(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (i10 < this.f28117r) {
            Object[] objArr = this.f28116q;
            if (objArr[i10] instanceof h) {
                i10++;
                if (objArr[i10] instanceof Iterator) {
                    sb2.append('[');
                    sb2.append(this.f28119t[i10]);
                    sb2.append(']');
                }
            } else if (objArr[i10] instanceof m) {
                i10++;
                if (objArr[i10] instanceof Iterator) {
                    sb2.append('.');
                    String[] strArr = this.f28118s;
                    if (strArr[i10] != null) {
                        sb2.append(strArr[i10]);
                    }
                }
            }
            i10++;
        }
        return sb2.toString();
    }

    @Override // com.google.gson.stream.a
    public void c() throws IOException {
        J0(JsonToken.BEGIN_ARRAY);
        N0(((h) K0()).iterator());
        this.f28119t[this.f28117r - 1] = 0;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f28116q = new Object[]{f28115u};
        this.f28117r = 1;
    }

    @Override // com.google.gson.stream.a
    public void d() throws IOException {
        J0(JsonToken.BEGIN_OBJECT);
        N0(((m) K0()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void g0() throws IOException {
        J0(JsonToken.NULL);
        L0();
        int i10 = this.f28117r;
        if (i10 > 0) {
            int[] iArr = this.f28119t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String i0() throws IOException {
        JsonToken k02 = k0();
        JsonToken jsonToken = JsonToken.STRING;
        if (k02 == jsonToken || k02 == JsonToken.NUMBER) {
            String n10 = ((n) L0()).n();
            int i10 = this.f28117r;
            if (i10 > 0) {
                int[] iArr = this.f28119t;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return n10;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + k02 + E());
    }

    @Override // com.google.gson.stream.a
    public JsonToken k0() throws IOException {
        if (this.f28117r == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object K0 = K0();
        if (K0 instanceof Iterator) {
            boolean z10 = this.f28116q[this.f28117r - 2] instanceof m;
            Iterator it = (Iterator) K0;
            if (!it.hasNext()) {
                return z10 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z10) {
                return JsonToken.NAME;
            }
            N0(it.next());
            return k0();
        } else if (K0 instanceof m) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (K0 instanceof h) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (K0 instanceof n) {
                n nVar = (n) K0;
                if (nVar.s()) {
                    return JsonToken.STRING;
                }
                if (nVar.o()) {
                    return JsonToken.BOOLEAN;
                }
                if (nVar.q()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (K0 instanceof l) {
                return JsonToken.NULL;
            } else {
                if (K0 == f28115u) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.gson.stream.a
    public void o() throws IOException {
        J0(JsonToken.END_ARRAY);
        L0();
        L0();
        int i10 = this.f28117r;
        if (i10 > 0) {
            int[] iArr = this.f28119t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void q() throws IOException {
        J0(JsonToken.END_OBJECT);
        L0();
        L0();
        int i10 = this.f28117r;
        if (i10 > 0) {
            int[] iArr = this.f28119t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public boolean v() throws IOException {
        JsonToken k02 = k0();
        return (k02 == JsonToken.END_OBJECT || k02 == JsonToken.END_ARRAY) ? false : true;
    }
}
