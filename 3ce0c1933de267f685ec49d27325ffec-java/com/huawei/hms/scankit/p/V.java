package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import java.util.Formatter;
/* compiled from: DetectionResult.java */
/* loaded from: classes2.dex */
final class V {

    /* renamed from: a  reason: collision with root package name */
    private final O f14697a;

    /* renamed from: b  reason: collision with root package name */
    private final W[] f14698b;

    /* renamed from: c  reason: collision with root package name */
    private Q f14699c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14700d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public V(O o10, Q q5) {
        this.f14697a = o10;
        int a10 = o10.a();
        this.f14700d = a10;
        this.f14699c = q5;
        this.f14698b = new W[a10 + 2];
    }

    private void a(W w10) throws C0550a {
        if (w10 != null) {
            try {
                ((X) w10).a(this.f14697a);
            } catch (ClassCastException unused) {
                throw C0550a.a();
            }
        }
    }

    private int f() {
        int g10 = g();
        if (g10 == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.f14700d + 1; i10++) {
            S[] b10 = this.f14698b[i10].b();
            for (int i11 = 0; i11 < b10.length; i11++) {
                if (b10[i11] != null && !b10[i11].g()) {
                    a(i10, i11, b10);
                }
            }
        }
        return g10;
    }

    private int g() {
        h();
        return i() + j();
    }

    private void h() {
        W[] wArr = this.f14698b;
        if (!(wArr[0] == null || wArr[this.f14700d + 1] == null)) {
            S[] b10 = wArr[0].b();
            S[] b11 = this.f14698b[this.f14700d + 1].b();
            for (int i10 = 0; i10 < b10.length; i10++) {
                if (!(b10[i10] == null || b11[i10] == null || b10[i10].c() != b11[i10].c())) {
                    for (int i11 = 1; i11 <= this.f14700d; i11++) {
                        S s10 = this.f14698b[i11].b()[i10];
                        if (s10 != null) {
                            s10.b(b10[i10].c());
                            if (!s10.g()) {
                                this.f14698b[i11].b()[i10] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int i() {
        W[] wArr = this.f14698b;
        if (wArr[0] == null) {
            return 0;
        }
        S[] b10 = wArr[0].b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10.length; i11++) {
            if (b10[i11] != null) {
                int c10 = b10[i11].c();
                int i12 = 0;
                for (int i13 = 1; i13 < this.f14700d + 1 && i12 < 2; i13++) {
                    S s10 = this.f14698b[i13].b()[i11];
                    if (s10 != null) {
                        i12 = a(c10, i12, s10);
                        if (!s10.g()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    private int j() {
        W[] wArr = this.f14698b;
        int i10 = this.f14700d + 1;
        if (wArr[i10] == null) {
            return 0;
        }
        S[] b10 = wArr[i10].b();
        int i11 = 0;
        for (int i12 = 0; i12 < b10.length; i12++) {
            if (b10[i12] != null) {
                int c10 = b10[i12].c();
                int i13 = 0;
                for (int i14 = this.f14700d + 1; i14 > 0 && i13 < 2; i14--) {
                    S s10 = this.f14698b[i14].b()[i12];
                    if (s10 != null) {
                        i13 = a(c10, i13, s10);
                        if (!s10.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14697a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f14697a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q d() {
        return this.f14699c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W[] e() throws C0550a {
        a(this.f14698b[0]);
        a(this.f14698b[this.f14700d + 1]);
        int i10 = 928;
        while (true) {
            int f10 = f();
            if (f10 <= 0 || f10 >= i10) {
                break;
            }
            i10 = f10;
        }
        return this.f14698b;
    }

    public String toString() {
        W[] wArr = this.f14698b;
        W w10 = wArr[0];
        if (w10 == null) {
            w10 = wArr[this.f14700d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < w10.b().length; i10++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i10));
                for (int i11 = 0; i11 < this.f14700d + 2; i11++) {
                    W[] wArr2 = this.f14698b;
                    if (wArr2[i11] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        S s10 = wArr2[i11].b()[i10];
                        if (s10 == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(s10.c()), Integer.valueOf(s10.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } finally {
                try {
                    throw th;
                } catch (Throwable th2) {
                }
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static int a(int i10, int i11, S s10) {
        if (s10 == null || s10.g()) {
            return i11;
        }
        if (!s10.a(i10)) {
            return i11 + 1;
        }
        s10.b(i10);
        return 0;
    }

    private void a(int i10, int i11, S[] sArr) {
        S s10 = sArr[i11];
        S[] b10 = this.f14698b[i10 - 1].b();
        W[] wArr = this.f14698b;
        int i12 = i10 + 1;
        S[] b11 = wArr[i12] != null ? wArr[i12].b() : b10;
        S[] sArr2 = new S[14];
        sArr2[2] = b10[i11];
        sArr2[3] = b11[i11];
        if (i11 > 0) {
            int i13 = i11 - 1;
            sArr2[0] = sArr[i13];
            sArr2[4] = b10[i13];
            sArr2[5] = b11[i13];
        }
        if (i11 > 1) {
            int i14 = i11 - 2;
            sArr2[8] = sArr[i14];
            sArr2[10] = b10[i14];
            sArr2[11] = b11[i14];
        }
        if (i11 < sArr.length - 1) {
            int i15 = i11 + 1;
            sArr2[1] = sArr[i15];
            sArr2[6] = b10[i15];
            sArr2[7] = b11[i15];
        }
        if (i11 < sArr.length - 2) {
            int i16 = i11 + 2;
            sArr2[9] = sArr[i16];
            sArr2[12] = b10[i16];
            sArr2[13] = b11[i16];
        }
        for (int i17 = 0; i17 < 14 && !a(s10, sArr2[i17]); i17++) {
        }
    }

    private static boolean a(S s10, S s11) {
        if (s11 == null || !s11.g() || s11.a() != s10.a()) {
            return false;
        }
        s10.b(s11.c());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f14700d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Q q5) {
        this.f14699c = q5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i10, W w10) {
        this.f14698b[i10] = w10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public W a(int i10) {
        return this.f14698b[i10];
    }
}
