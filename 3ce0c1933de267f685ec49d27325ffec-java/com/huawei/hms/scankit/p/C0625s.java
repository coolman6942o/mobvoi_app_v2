package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.F;
import com.huawei.hms.scankit.aiscan.common.g;
import com.huawei.hms.scankit.aiscan.common.j;
import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: Detector.java */
/* renamed from: com.huawei.hms.scankit.p.s  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0625s {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14921a;

    /* renamed from: b  reason: collision with root package name */
    private final F f14922b;

    public C0625s(C0595i iVar) throws C0550a {
        this.f14921a = iVar;
        this.f14922b = new F(iVar);
    }

    private z[] b(z[] zVarArr) {
        z zVar = zVarArr[0];
        z zVar2 = zVarArr[1];
        z zVar3 = zVarArr[3];
        z zVar4 = zVarArr[2];
        int a10 = a(zVar, zVar2);
        int a11 = a(zVar2, zVar3);
        int a12 = a(zVar3, zVar4);
        int a13 = a(zVar4, zVar);
        z[] zVarArr2 = {zVar4, zVar, zVar2, zVar3};
        if (a10 > a11) {
            zVarArr2[0] = zVar;
            zVarArr2[1] = zVar2;
            zVarArr2[2] = zVar3;
            zVarArr2[3] = zVar4;
            a10 = a11;
        }
        if (a10 > a12) {
            zVarArr2[0] = zVar2;
            zVarArr2[1] = zVar3;
            zVarArr2[2] = zVar4;
            zVarArr2[3] = zVar;
        } else {
            a12 = a10;
        }
        if (a12 > a13) {
            zVarArr2[0] = zVar3;
            zVarArr2[1] = zVar4;
            zVarArr2[2] = zVar;
            zVarArr2[3] = zVar2;
        }
        return zVarArr2;
    }

    private z[] c(z[] zVarArr) {
        z zVar = zVarArr[0];
        z zVar2 = zVarArr[1];
        z zVar3 = zVarArr[2];
        z zVar4 = zVarArr[3];
        int a10 = (a(zVar, zVar4) + 1) * 4;
        if (a(a(zVar2, zVar3, a10), zVar) < a(a(zVar3, zVar2, a10), zVar4)) {
            zVarArr[0] = zVar;
            zVarArr[1] = zVar2;
            zVarArr[2] = zVar3;
            zVarArr[3] = zVar4;
        } else {
            zVarArr[0] = zVar2;
            zVarArr[1] = zVar3;
            zVarArr[2] = zVar4;
            zVarArr[3] = zVar;
        }
        return zVarArr;
    }

    private z[] d(z[] zVarArr) {
        z zVar = zVarArr[0];
        z zVar2 = zVarArr[1];
        z zVar3 = zVarArr[2];
        z zVar4 = zVarArr[3];
        z a10 = a(zVar, zVar2, (a(zVar3, zVar4) + 1) * 4);
        z a11 = a(zVar3, zVar2, (a(zVar, zVar4) + 1) * 4);
        int a12 = a(a10, zVar4) + 1;
        int a13 = a(a11, zVar4) + 1;
        if ((a12 & 1) == 1) {
            a12++;
        }
        if ((a13 & 1) == 1) {
            a13++;
        }
        float b10 = (((zVar.b() + zVar2.b()) + zVar3.b()) + zVar4.b()) / 4.0f;
        float c10 = (((zVar.c() + zVar2.c()) + zVar3.c()) + zVar4.c()) / 4.0f;
        z a14 = a(zVar, b10, c10);
        z a15 = a(zVar2, b10, c10);
        z a16 = a(zVar3, b10, c10);
        z a17 = a(zVar4, b10, c10);
        int i10 = a13 * 4;
        int i11 = a12 * 4;
        return new z[]{a(a(a14, a15, i10), a17, i11), a(a(a15, a14, i10), a16, i11), a(a(a16, a17, i10), a15, i11), a(a(a17, a16, i10), a14, i11)};
    }

    public g a() throws C0550a {
        int i10;
        int i11;
        z[] c10 = c(b(this.f14922b.a()));
        c10[3] = a(c10);
        if (c10[3] != null) {
            z[] d10 = d(c10);
            z zVar = d10[0];
            z zVar2 = d10[1];
            z zVar3 = d10[2];
            z zVar4 = d10[3];
            int a10 = a(zVar, zVar4) + 1;
            int a11 = a(zVar3, zVar4) + 1;
            if ((a10 & 1) == 1) {
                a10++;
            }
            if ((a11 & 1) == 1) {
                a11++;
            }
            if (a10 * 4 >= a11 * 7 || a11 * 4 >= a10 * 7) {
                i11 = a10;
                i10 = a11;
            } else {
                i11 = Math.max(a10, a11);
                i10 = i11;
            }
            return new g(a(this.f14921a, zVar, zVar2, zVar3, zVar4, i11, i10), new z[]{zVar, zVar2, zVar3, zVar4});
        }
        throw C0550a.a();
    }

    private static z a(z zVar, z zVar2, int i10) {
        float f10 = i10 + 1;
        return new z(zVar.b() + ((zVar2.b() - zVar.b()) / f10), zVar.c() + ((zVar2.c() - zVar.c()) / f10));
    }

    private static z a(z zVar, float f10, float f11) {
        float b10 = zVar.b();
        float c10 = zVar.c();
        return new z(b10 < f10 ? b10 - 1.0f : b10 + 1.0f, c10 < f11 ? c10 - 1.0f : c10 + 1.0f);
    }

    private z a(z[] zVarArr) {
        z zVar = zVarArr[0];
        z zVar2 = zVarArr[1];
        z zVar3 = zVarArr[2];
        z zVar4 = zVarArr[3];
        int a10 = a(zVar, zVar4);
        z a11 = a(zVar, zVar2, (a(zVar2, zVar4) + 1) * 4);
        z a12 = a(zVar3, zVar2, (a10 + 1) * 4);
        int a13 = a(a11, zVar4);
        int a14 = a(a12, zVar4);
        float f10 = a13 + 1;
        z zVar5 = new z(zVar4.b() + ((zVar3.b() - zVar2.b()) / f10), zVar4.c() + ((zVar3.c() - zVar2.c()) / f10));
        float f11 = a14 + 1;
        z zVar6 = new z(zVar4.b() + ((zVar.b() - zVar2.b()) / f11), zVar4.c() + ((zVar.c() - zVar2.c()) / f11));
        if (a(zVar5)) {
            return (a(zVar6) && a(a11, zVar5) + a(a12, zVar5) <= a(a11, zVar6) + a(a12, zVar6)) ? zVar6 : zVar5;
        }
        if (a(zVar6)) {
            return zVar6;
        }
        return null;
    }

    private boolean a(z zVar) {
        return zVar.b() >= 0.0f && zVar.b() < ((float) this.f14921a.d()) && zVar.c() > 0.0f && zVar.c() < ((float) this.f14921a.b());
    }

    private static C0595i a(C0595i iVar, z zVar, z zVar2, z zVar3, z zVar4, int i10, int i11) throws C0550a {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return j.a().a(iVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, zVar.b(), zVar.c(), zVar4.b(), zVar4.c(), zVar3.b(), zVar3.c(), zVar2.b(), zVar2.c());
    }

    private int a(z zVar, z zVar2) {
        int i10;
        boolean z10;
        C0625s sVar = this;
        int b10 = (int) zVar.b();
        int c10 = (int) zVar.c();
        int b11 = (int) zVar2.b();
        int c11 = (int) zVar2.c();
        boolean z11 = Math.abs(c11 - c10) > Math.abs(b11 - b10);
        if (!z11) {
            c10 = b10;
            b10 = c10;
            c11 = b11;
            b11 = c11;
        }
        int abs = Math.abs(c11 - c10);
        int abs2 = Math.abs(b11 - b10);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = b10 < b11 ? 1 : -1;
        if (c10 < c11) {
            i12 = 1;
        }
        boolean b12 = sVar.f14921a.b(z11 ? b10 : c10, z11 ? c10 : b10);
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (c10 != c11) {
            boolean b13 = sVar.f14921a.b(z11 ? b10 : c10, z11 ? c10 : b10);
            i14++;
            if (b13 != b12) {
                i10 = c11;
                z10 = z11;
                if (i14 > Math.ceil(i15 / 1.5d)) {
                    i16++;
                    i15 -= (i15 - i14) / i16;
                    b12 = b13;
                    i14 = 0;
                }
            } else {
                i10 = c11;
                z10 = z11;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (b10 == b11) {
                    break;
                }
                b10 += i13;
                i11 -= abs;
            }
            c10 += i12;
            sVar = this;
            z11 = z10;
            c11 = i10;
        }
        return i16;
    }
}
