package com.huawei.hms.scankit.p;

import java.util.Formatter;
/* compiled from: DetectionResultColumn.java */
/* loaded from: classes2.dex */
class W {

    /* renamed from: a  reason: collision with root package name */
    private final Q f14702a;

    /* renamed from: b  reason: collision with root package name */
    private final S[] f14703b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(Q q5) {
        this.f14702a = new Q(q5);
        this.f14703b = new S[(q5.d() - q5.f()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i10, S s10) {
        this.f14703b[c(i10)] = s10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final S b(int i10) {
        S s10;
        S s11;
        S a10 = a(i10);
        if (a10 != null) {
            return a10;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int c10 = c(i10) - i11;
            if (c10 >= 0 && (s11 = this.f14703b[c10]) != null) {
                return s11;
            }
            int c11 = c(i10) + i11;
            S[] sArr = this.f14703b;
            if (c11 < sArr.length && (s10 = sArr[c11]) != null) {
                return s10;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int c(int i10) {
        return i10 - this.f14702a.f();
    }

    public String toString() {
        S[] sArr;
        Formatter formatter = new Formatter();
        try {
            int i10 = 0;
            for (S s10 : this.f14703b) {
                if (s10 == null) {
                    i10++;
                    formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                } else {
                    i10++;
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(s10.c()), Integer.valueOf(s10.e()));
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    formatter.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final S a(int i10) {
        return this.f14703b[c(i10)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Q a() {
        return this.f14702a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final S[] b() {
        return this.f14703b;
    }
}
