package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.ByteString;
import okio.c;
import okio.e;
import rp.d;
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f6689g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f6690a;

    /* renamed from: b  reason: collision with root package name */
    int[] f6691b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f6692c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f6693d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f6694e;

    /* renamed from: f  reason: collision with root package name */
    boolean f6695f;

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f6696a;

        /* renamed from: b  reason: collision with root package name */
        final d f6697b;

        private a(String[] strArr, d dVar) {
            this.f6696a = strArr;
            this.f6697b = dVar;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                c cVar = new c();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    JsonReader.W(cVar, strArr[i10]);
                    cVar.readByte();
                    byteStringArr[i10] = cVar.d0();
                }
                return new a((String[]) strArr.clone(), d.i(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f6689g[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f6689g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader E(e eVar) {
        return new d(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void W(okio.d dVar, String str) throws IOException {
        String str2;
        String[] strArr = f6689g;
        dVar.C(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i10 < i11) {
                    dVar.a0(str, i10, i11);
                }
                dVar.R(str2);
                i10 = i11 + 1;
            } else {
                if (charAt == 8232) {
                    str2 = "\\u2028";
                } else if (charAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i10 < i11) {
                }
                dVar.R(str2);
                i10 = i11 + 1;
            }
        }
        if (i10 < length) {
            dVar.a0(str, i10, length);
        }
        dVar.C(34);
    }

    public abstract Token I() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(int i10) {
        int i11 = this.f6690a;
        int[] iArr = this.f6691b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f6691b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f6692c;
                this.f6692c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f6693d;
                this.f6693d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new com.airbnb.lottie.parser.moshi.a("Nesting too deep at " + a());
            }
        }
        int[] iArr3 = this.f6691b;
        int i12 = this.f6690a;
        this.f6690a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int Q(a aVar) throws IOException;

    public abstract void T() throws IOException;

    public abstract void V() throws IOException;

    public final String a() {
        return c.a(this.f6690a, this.f6691b, this.f6692c, this.f6693d);
    }

    public abstract void d() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b g0(String str) throws b {
        throw new b(str + " at path " + a());
    }

    public abstract void h() throws IOException;

    public abstract void i() throws IOException;

    public abstract void n() throws IOException;

    public abstract boolean o() throws IOException;

    public abstract boolean q() throws IOException;

    public abstract double u() throws IOException;

    public abstract int v() throws IOException;

    public abstract String w() throws IOException;

    public abstract String x() throws IOException;
}
