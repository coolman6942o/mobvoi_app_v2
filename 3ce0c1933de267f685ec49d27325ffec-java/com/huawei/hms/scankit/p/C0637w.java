package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.r;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;
/* compiled from: DetectorRotate.java */
/* renamed from: com.huawei.hms.scankit.p.w  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0637w {

    /* renamed from: a  reason: collision with root package name */
    private static C0640x f14994a;

    /* renamed from: b  reason: collision with root package name */
    private static C0587g f14995b;

    public static List<C0634v> a(boolean z10, C0587g gVar, int i10, boolean z11) {
        int e10 = gVar.e();
        int c10 = gVar.c();
        byte[] b10 = gVar.a().c().b();
        C0640x xVar = new C0640x();
        f14994a = xVar;
        xVar.a(z10, b10, c10, e10, i10, z11);
        return f14994a.f14999a;
    }

    public static boolean a(boolean z10, C0587g gVar, C0634v vVar) throws C0550a {
        float f10;
        int e10 = gVar.e();
        int c10 = gVar.c();
        float[] fArr = {vVar.j(), vVar.k(), vVar.f(), vVar.c()};
        if (z10) {
            vVar.f14982n = Math.max(vVar.m(), vVar.l());
            vVar.f14983o = Math.min(vVar.m(), vVar.l());
            f10 = vVar.i();
            if (vVar.g() == 11.0f || vVar.g() == 0.0f) {
                f10 = 0.0f;
            }
            vVar.f14990v = Math.max(fArr[2], fArr[3]);
            vVar.f14986r = (int) Math.max(fArr[0] - (fArr[2] * 0.5d), 0.0d);
            vVar.f14987s = (int) Math.max(fArr[1] - (fArr[3] * 0.5d), 0.0d);
        } else {
            f10 = vVar.i();
            vVar.f14990v = Math.max(fArr[2], fArr[3]);
            vVar.f14986r = (int) vVar.d();
            vVar.f14987s = (int) vVar.e();
        }
        vVar.f14984p = Math.min(e10 - vVar.f14986r, (int) fArr[2]);
        int min = Math.min(c10 - vVar.f14987s, (int) fArr[3]);
        vVar.f14985q = min;
        int i10 = vVar.f14984p;
        if (i10 <= 0 || min <= 0) {
            throw C0550a.a("crop_w <= 0 || crop_h <= 0");
        }
        C0587g a10 = gVar.a(vVar.f14986r, vVar.f14987s, i10, min);
        f14995b = a10;
        a(a10, f10, vVar, fArr);
        return true;
    }

    private static void a(C0587g gVar, float f10, C0634v vVar, float[] fArr) {
        float f11;
        float f12;
        float radians = (float) Math.toRadians(f10);
        double d10 = radians;
        int abs = (int) ((vVar.f14984p * Math.abs(Math.sin(d10))) + (vVar.f14985q * Math.abs(Math.cos(d10))));
        int abs2 = (int) ((vVar.f14985q * Math.abs(Math.sin(d10))) + (vVar.f14984p * Math.abs(Math.cos(d10))));
        float[] fArr2 = vVar.f14981m;
        fArr2[0] = abs2 * 0.5f;
        fArr2[1] = abs * 0.5f;
        fArr2[2] = (abs2 - vVar.f14984p) * 0.5f;
        fArr2[3] = (abs - vVar.f14985q) * 0.5f;
        fArr2[4] = radians;
        if (f10 == 0.0f) {
            vVar.f14988t = 0;
            vVar.f14989u = 0;
            vVar.f14980l = gVar;
            return;
        }
        C0587g gVar2 = new C0587g(new C0602k(new r(LoadOpencvJNIUtil.imageRotate(gVar.a().c().b(), vVar.f14985q, vVar.f14984p, abs, abs2, f10, 1.0d), abs2, abs, 0, 0, abs2, abs, false)));
        if ((vVar.g() == 3.0f || vVar.g() == 4.0f) && gVar2.c() > gVar2.e()) {
            f12 = Math.min(fArr[2], fArr[3]);
            f11 = Math.max(fArr[2], fArr[3]);
        } else {
            f12 = Math.max(fArr[2], fArr[3]);
            f11 = Math.min(fArr[2], fArr[3]);
        }
        vVar.f14988t = (int) Math.max((abs2 * 0.5d) - (f12 * 0.5d), 0.0d);
        vVar.f14989u = (int) Math.max((abs * 0.5d) - (f11 * 0.5d), 0.0d);
        vVar.f14980l = gVar2.a(vVar.f14988t, vVar.f14989u, Math.min(abs2 - vVar.f14988t, (int) f12), Math.min(abs - vVar.f14989u, (int) f11));
    }

    public static void a(C0595i iVar, x xVar, float f10, C0634v vVar) {
        int i10;
        int i11;
        z[] f11 = xVar.f();
        float min = Math.min(f11[0].b(), f11[1].b());
        float max = Math.max(f11[0].b(), f11[1].b());
        float c10 = f11[0].c();
        if (max > iVar.d() - 1) {
            max = iVar.d() - 1;
        }
        float f12 = max;
        float b10 = c10 > ((float) (iVar.b() - 1)) ? iVar.b() - 1 : c10;
        int b11 = iVar.b();
        try {
            int[] a10 = a(iVar, f11, min, f12, b10, b11, new int[b11]);
            i11 = a10[0];
            i10 = a10[1];
        } catch (IndexOutOfBoundsException unused) {
            i11 = (int) f11[0].c();
            i10 = (int) f11[0].c();
        }
        float f13 = i11;
        float f14 = i10;
        z[] zVarArr = {new z(min, f13), new z(f12, f13), new z(f12, f14), new z(min, f14)};
        if (vVar != null) {
            a(zVarArr, f10, vVar);
        }
        xVar.a();
        xVar.a(zVarArr);
    }

    private static int[] a(C0595i iVar, z[] zVarArr, float f10, float f11, float f12, int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        int i14 = (int) f10;
        int i15 = i14;
        int i16 = 0;
        while (true) {
            i11 = ((int) f11) - 1;
            if (i15 >= i11) {
                break;
            }
            int i17 = (int) f12;
            boolean b10 = iVar.b(i15, i17);
            i15++;
            if (iVar.b(i15, i17) ^ b10) {
                i16++;
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            int i20 = i14;
            int i21 = 0;
            while (i20 < i11) {
                boolean b11 = iVar.b(i20, i19);
                i20++;
                if (b11 ^ iVar.b(i20, i19)) {
                    i21++;
                }
            }
            float f13 = i16;
            if (i21 > 1.5f * f13) {
                i21 = 0;
            }
            if (i21 < f13 * 0.5f) {
                i21 = 0;
            }
            iArr[i19] = i21;
            if (iArr[i19] > i18) {
                i18 = iArr[i19];
            }
        }
        if (i18 > 0) {
            float[] fArr = new float[i10];
            for (int i22 = 0; i22 < i10; i22++) {
                fArr[i22] = iArr[i22] / i18;
            }
            float f14 = 0.0f;
            for (int i23 = 0; i23 < i10; i23++) {
                f14 += fArr[i23];
            }
            float f15 = f14 / i10;
            if (f15 > 1.0d) {
                f15 = 0.99f;
            }
            i13 = (int) f12;
            i12 = i13;
            while (true) {
                if (i12 < 0) {
                    i12 = 0;
                    break;
                } else if (fArr[i12] < f15) {
                    break;
                } else {
                    i12--;
                }
            }
            while (true) {
                if (i13 >= i10) {
                    i13 = 0;
                    break;
                } else if (fArr[i13] < f15) {
                    break;
                } else {
                    i13++;
                }
            }
        } else {
            i13 = 0;
            i12 = 0;
        }
        if (i12 == 0 && i13 == 0) {
            i12 = ((int) zVarArr[0].c()) + (-10) < 0 ? 0 : ((int) zVarArr[0].c()) - 10;
            i13 = i10 - 1;
            if (((int) zVarArr[0].c()) + 10 <= i13) {
                i13 = ((int) zVarArr[0].c()) + 10;
            }
        }
        return new int[]{i12, i13};
    }

    private static z a(float f10, float f11, C0634v vVar) {
        float[] fArr = vVar.f14981m;
        if (fArr == null || fArr.length != 5) {
            return new z(f10, f11);
        }
        double d10 = f10 - fArr[0];
        double d11 = -fArr[4];
        float[] fArr2 = vVar.f14981m;
        double sin = ((-(f10 - fArr2[0])) * Math.sin(d11)) + ((f11 - vVar.f14981m[1]) * Math.cos(d11));
        float[] fArr3 = vVar.f14981m;
        return new z((((int) (((d10 * Math.cos(d11)) + ((f11 - vVar.f14981m[1]) * Math.sin(d11))) + fArr2[0])) - fArr3[2]) + vVar.f14986r, (((int) (sin + fArr3[1])) - fArr3[3]) + vVar.f14987s);
    }

    public static void a(z[] zVarArr, float f10, C0634v vVar) {
        if (!(vVar == null || zVarArr == null)) {
            for (int i10 = 0; i10 < zVarArr.length; i10++) {
                zVarArr[i10] = a((zVarArr[i10].b() * f10) + vVar.f14988t, (zVarArr[i10].c() * f10) + vVar.f14989u, vVar);
            }
        }
    }
}
