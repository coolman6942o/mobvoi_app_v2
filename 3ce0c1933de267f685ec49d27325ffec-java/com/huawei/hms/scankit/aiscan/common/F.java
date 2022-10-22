package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0595i;
/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes2.dex */
public final class F {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14159a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14160b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14161c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14162d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14163e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14164f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14165g;

    public F(C0595i iVar) throws C0550a {
        this(iVar, 10, iVar.d() / 2, iVar.b() / 2);
    }

    private z[] b(int[] iArr) throws C0550a {
        int i10 = iArr[1] - iArr[0];
        z zVar = null;
        z zVar2 = null;
        for (int i11 = 1; zVar2 == null && i11 < i10; i11++) {
            zVar2 = a(iArr[0], iArr[3] - i11, iArr[0] + i11, iArr[3]);
        }
        if (zVar2 != null) {
            z zVar3 = null;
            for (int i12 = 1; zVar3 == null && i12 < i10; i12++) {
                zVar3 = a(iArr[0], iArr[2] + i12, iArr[0] + i12, iArr[2]);
            }
            if (zVar3 != null) {
                z zVar4 = null;
                for (int i13 = 1; zVar4 == null && i13 < i10; i13++) {
                    zVar4 = a(iArr[1], iArr[2] + i13, iArr[1] - i13, iArr[2]);
                }
                if (zVar4 != null) {
                    for (int i14 = 1; zVar == null && i14 < i10; i14++) {
                        zVar = a(iArr[1], iArr[3] - i14, iArr[1] - i14, iArr[3]);
                    }
                    if (zVar != null) {
                        return a(zVar, zVar2, zVar4, zVar3);
                    }
                    throw C0550a.a();
                }
                throw C0550a.a();
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }

    private void c(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((z10 || iArr[9] != 1) && iArr[0] >= 0) {
                boolean a10 = a(iArr[2], iArr[3], iArr[0], false);
                if (a10) {
                    iArr[0] = iArr[0] - 1;
                    iArr[5] = 1;
                    iArr[9] = 1;
                } else if (iArr[9] != 1) {
                    iArr[0] = iArr[0] - 1;
                }
                z10 = a10;
            } else {
                return;
            }
        }
    }

    private void d(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((z10 || iArr[7] != 1) && iArr[1] < this.f14161c) {
                z10 = a(iArr[2], iArr[3], iArr[1], false);
                if (z10) {
                    iArr[1] = iArr[1] + 1;
                    iArr[5] = 1;
                    iArr[7] = 1;
                } else if (iArr[7] != 1) {
                    iArr[1] = iArr[1] + 1;
                }
            } else {
                return;
            }
        }
    }

    private void e(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((z10 || iArr[10] != 1) && iArr[2] >= 0) {
                boolean a10 = a(iArr[0], iArr[1], iArr[2], true);
                if (a10) {
                    iArr[2] = iArr[2] - 1;
                    iArr[5] = 1;
                    iArr[10] = 1;
                } else if (iArr[10] != 1) {
                    iArr[2] = iArr[2] - 1;
                }
                z10 = a10;
            } else {
                return;
            }
        }
    }

    public z[] a() throws C0550a {
        int[] iArr = {this.f14162d, this.f14163e, this.f14165g, this.f14164f, 0, 1, 0, 0, 0, 0, 0};
        while (true) {
            if (iArr[5] != 1) {
                break;
            }
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.f14161c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.f14160b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            } else if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] != 1 && iArr[6] == 1) {
            return b(iArr);
        }
        throw C0550a.a();
    }

    public F(C0595i iVar, int i10, int i11, int i12) throws C0550a {
        this.f14159a = iVar;
        int b10 = iVar.b();
        this.f14160b = b10;
        int d10 = iVar.d();
        this.f14161c = d10;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f14162d = i14;
        int i15 = i11 + i13;
        this.f14163e = i15;
        int i16 = i12 - i13;
        this.f14165g = i16;
        int i17 = i12 + i13;
        this.f14164f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= b10 || i15 >= d10) {
            throw C0550a.a();
        }
    }

    private void a(int[] iArr) {
        boolean z10 = true;
        while (true) {
            if ((z10 || iArr[8] != 1) && iArr[3] < this.f14160b) {
                boolean a10 = a(iArr[0], iArr[1], iArr[3], true);
                if (a10) {
                    iArr[3] = iArr[3] + 1;
                    iArr[5] = 1;
                    iArr[8] = 1;
                } else if (iArr[8] != 1) {
                    iArr[3] = iArr[3] + 1;
                }
                z10 = a10;
            } else {
                return;
            }
        }
    }

    private z a(float f10, float f11, float f12, float f13) {
        int a10 = n.a(n.a(f10, f11, f12, f13));
        float f14 = a10;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < a10; i10++) {
            float f17 = i10;
            int a11 = n.a((f17 * f15) + f10);
            int a12 = n.a((f17 * f16) + f11);
            if (this.f14159a.b(a11, a12)) {
                return new z(a11, a12);
            }
        }
        return null;
    }

    private z[] a(z zVar, z zVar2, z zVar3, z zVar4) {
        float b10 = zVar.b();
        float c10 = zVar.c();
        float b11 = zVar2.b();
        float c11 = zVar2.c();
        float b12 = zVar3.b();
        float c12 = zVar3.c();
        float b13 = zVar4.b();
        float c13 = zVar4.c();
        return b10 < ((float) this.f14161c) / 2.0f ? new z[]{new z(b13 - 1.0f, c13 + 1.0f), new z(b11 + 1.0f, c11 + 1.0f), new z(b12 - 1.0f, c12 - 1.0f), new z(b10 + 1.0f, c10 - 1.0f)} : new z[]{new z(b13 + 1.0f, c13 + 1.0f), new z(b11 + 1.0f, c11 - 1.0f), new z(b12 - 1.0f, c12 + 1.0f), new z(b10 - 1.0f, c10 - 1.0f)};
    }

    private boolean a(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f14159a.b(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f14159a.b(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }
}
