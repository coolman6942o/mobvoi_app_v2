package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: DetectionResultRowIndicatorColumn.java */
/* loaded from: classes2.dex */
final class X extends W {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14705c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(Q q5, boolean z10) {
        super(q5);
        this.f14705c = z10;
    }

    private void b(O o10) {
        Q a10 = a();
        z g10 = this.f14705c ? a10.g() : a10.h();
        z a11 = this.f14705c ? a10.a() : a10.b();
        int c10 = c((int) a11.c());
        S[] b10 = b();
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        for (int c11 = c((int) g10.c()); c11 < c10; c11++) {
            if (b10[c11] != null) {
                S s10 = b10[c11];
                s10.h();
                int c12 = s10.c() - i10;
                if (c12 == 0) {
                    i11++;
                } else {
                    if (c12 == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = s10.c();
                    } else if (s10.c() >= o10.c()) {
                        b10[c11] = null;
                    } else {
                        i10 = s10.c();
                    }
                    i11 = 1;
                }
            }
        }
    }

    private void f() {
        S[] b10;
        for (S s10 : b()) {
            if (s10 != null) {
                s10.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(O o10) throws C0550a {
        S[] b10 = b();
        f();
        a(b10, o10);
        Q a10 = a();
        z g10 = this.f14705c ? a10.g() : a10.h();
        z a11 = this.f14705c ? a10.a() : a10.b();
        int c10 = c((int) g10.c());
        int c11 = c((int) a11.c());
        int i10 = -1;
        int i11 = 0;
        int i12 = 1;
        while (c10 < c11) {
            if (b10[c10] != null) {
                S s10 = b10[c10];
                int c12 = s10.c() - i10;
                if (c12 == 0) {
                    i11++;
                } else {
                    if (c12 == 1) {
                        i12 = Math.max(i12, i11);
                        i10 = s10.c();
                    } else if (c12 < 0 || s10.c() >= o10.c() || c12 > c10) {
                        b10[c10] = null;
                    } else {
                        if (i12 > 2) {
                            c12 *= i12 - 2;
                        }
                        boolean z10 = c12 >= c10;
                        for (int i13 = 1; i13 <= c12 && !z10; i13++) {
                            z10 = b10[c10 - i13] != null;
                        }
                        if (z10) {
                            b10[c10] = null;
                        } else {
                            i10 = s10.c();
                        }
                    }
                    i11 = 1;
                }
            }
            c10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public O c() throws C0550a {
        S[] b10 = b();
        P p10 = new P();
        P p11 = new P();
        P p12 = new P();
        P p13 = new P();
        for (S s10 : b10) {
            if (s10 != null) {
                s10.h();
                int e10 = s10.e() % 30;
                int c10 = s10.c();
                if (!this.f14705c) {
                    c10 += 2;
                }
                int i10 = c10 % 3;
                if (i10 == 0) {
                    p11.a((e10 * 3) + 1);
                } else if (i10 == 1) {
                    p13.a(e10 / 3);
                    p12.a(e10 % 3);
                } else if (i10 == 2) {
                    p10.a(e10 + 1);
                } else {
                    throw C0550a.a();
                }
            }
        }
        if (p10.a().length == 0 || p11.a().length == 0 || p12.a().length == 0 || p13.a().length == 0 || p10.a()[0] < 1 || p11.a()[0] + p12.a()[0] < 3 || p11.a()[0] + p12.a()[0] > 90) {
            return null;
        }
        O o10 = new O(p10.a()[0], p11.a()[0], p12.a()[0], p13.a()[0]);
        a(b10, o10);
        return o10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] d() throws C0550a {
        S[] b10;
        int c10;
        O c11 = c();
        if (c11 == null) {
            return null;
        }
        b(c11);
        int c12 = c11.c();
        int[] iArr = new int[c12];
        for (S s10 : b()) {
            if (s10 != null && (c10 = s10.c()) < c12) {
                iArr[c10] = iArr[c10] + 1;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f14705c;
    }

    @Override // com.huawei.hms.scankit.p.W
    public String toString() {
        return "IsLeft: " + this.f14705c + '\n' + super.toString();
    }

    private void a(S[] sArr, O o10) throws C0550a {
        for (int i10 = 0; i10 < sArr.length; i10++) {
            S s10 = sArr[i10];
            if (sArr[i10] != null) {
                int e10 = s10.e() % 30;
                int c10 = s10.c();
                if (c10 > o10.c()) {
                    sArr[i10] = null;
                } else {
                    if (!this.f14705c) {
                        c10 += 2;
                    }
                    int i11 = c10 % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 != 2) {
                                throw C0550a.a();
                            } else if (e10 + 1 != o10.a()) {
                                sArr[i10] = null;
                            }
                        } else if (e10 / 3 != o10.b() || e10 % 3 != o10.d()) {
                            sArr[i10] = null;
                        }
                    } else if ((e10 * 3) + 1 != o10.e()) {
                        sArr[i10] = null;
                    }
                }
            }
        }
    }
}
