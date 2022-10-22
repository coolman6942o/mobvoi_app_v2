package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.g;
import com.huawei.hms.scankit.aiscan.common.j;
import com.huawei.hms.scankit.aiscan.common.n;
import com.huawei.hms.scankit.aiscan.common.q;
import com.huawei.hms.scankit.aiscan.common.z;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Map;
/* compiled from: Detector.java */
/* renamed from: com.huawei.hms.scankit.p.ya  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0644ya {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f15014a;

    /* renamed from: b  reason: collision with root package name */
    private A f15015b;

    public C0644ya(C0595i iVar) {
        this.f15014a = iVar;
    }

    private static q a(z zVar, z zVar2, z zVar3, z zVar4, z zVar5, int i10) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = i10 - 3.5f;
        if (zVar4 != null) {
            float b10 = zVar4.b();
            float c10 = zVar4.c();
            f11 = b10;
            f10 = c10;
            f13 = zVar5.b();
            f12 = zVar5.c();
        } else {
            f11 = (zVar2.b() - zVar.b()) + zVar3.b();
            f10 = (zVar2.c() - zVar.c()) + zVar3.c();
            f13 = f14;
            f12 = f13;
        }
        return q.a(3.5f, 3.5f, f14, 3.5f, f13, f12, 3.5f, f14, zVar.b(), zVar.c(), zVar2.b(), zVar2.c(), f11, f10, zVar3.b(), zVar3.c());
    }

    private float b(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float a10 = a(i10, i11, i12, i13);
        int i14 = i10 - (i12 - i10);
        int i15 = 0;
        if (i14 < 0) {
            f10 = i10 / (i10 - i14);
            i14 = 0;
        } else if (i14 >= this.f15014a.d()) {
            f10 = ((this.f15014a.d() - 1) - i10) / (i14 - i10);
            i14 = this.f15014a.d() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = i11;
        int i16 = (int) (f12 - ((i13 - i11) * f10));
        if (i16 < 0) {
            f11 = f12 / (i11 - i16);
        } else if (i16 >= this.f15014a.b()) {
            f11 = ((this.f15014a.b() - 1) - i11) / (i16 - i11);
            i15 = this.f15014a.b() - 1;
        } else {
            i15 = i16;
            f11 = 1.0f;
        }
        float a11 = a(i10, i11, (int) (i10 + ((i14 - i10) * f11)), i15);
        if (Math.max(a10, a11) > Math.min(a10, a11) * 1.5d) {
            return Float.NaN;
        }
        return (a10 + a11) - 1.0f;
    }

    private static C0595i a(C0595i iVar, q qVar, int i10) throws C0550a {
        return j.a().a(iVar, i10, i10, qVar, true);
    }

    private static int a(z zVar, z zVar2, z zVar3, float f10) throws C0550a {
        int i10;
        int i11;
        try {
            i10 = ((n.a(z.a(zVar, zVar2) / f10) + n.a(z.a(zVar, zVar3) / f10)) / 2) + 7;
            i11 = i10 & 3;
        } catch (C0550a unused) {
            i10 = ((((int) (z.a(zVar, zVar2) / f10)) + ((int) (z.a(zVar, zVar3) / f10))) / 2) + 7;
            int i12 = i10 & 3;
            if (i12 != 0) {
                if (i12 != 2) {
                    return i12 != 3 ? i10 : i10 + 2;
                }
            }
        }
        if (i11 != 0) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return i10;
                }
                throw C0550a.a();
            }
            return i10 - 1;
        }
        return i10 + 1;
    }

    public final g a(Map<EnumC0553d, ?> map) throws C0550a {
        this.f15015b = map == null ? null : (A) map.get(EnumC0553d.NEED_RESULT_POINT_CALLBACK);
        return a(new Ca(this.f15014a, this.f15015b).a());
    }

    protected final g a(Da da2) throws C0550a {
        Aa b10 = da2.b();
        Aa c10 = da2.c();
        Aa a10 = da2.a();
        try {
            float a11 = a(b10, c10, a10);
            if (a11 >= 1.0f) {
                return a(b10, c10, a10, a11);
            }
            throw C0550a.a();
        } catch (C0550a unused) {
            float e10 = ((b10.e() + c10.e()) + a10.e()) / 3.0f;
            if (e10 >= 1.0f) {
                return a(b10, c10, a10, e10);
            }
            throw C0550a.a();
        }
    }

    private g a(Aa aa2, Aa aa3, Aa aa4, float f10) throws C0550a {
        C0596ia[] iaVarArr;
        C0596ia[] iaVarArr2;
        char c10;
        C0596ia[] iaVarArr3;
        int i10;
        q qVar;
        z[] zVarArr;
        int a10 = a((z) aa2, (z) aa3, (z) aa4, f10);
        Ka.f14580r.push(Integer.valueOf(a10));
        Ia b10 = Ia.b(a10);
        if (Ka.f14576n && Ka.f14565c) {
            return a(aa2, aa3, aa4, f10, a10);
        }
        int c11 = b10.c() - 7;
        int length = b10.b().length;
        int i11 = length * length;
        C0596ia[] iaVarArr4 = new C0596ia[i11];
        C0596ia[] iaVarArr5 = new C0596ia[i11];
        C0596ia[] iaVarArr6 = new C0596ia[2];
        if (b10.b().length > 0) {
            iaVarArr3 = iaVarArr6;
            c10 = 2;
            iaVarArr2 = iaVarArr5;
            iaVarArr = iaVarArr4;
            i10 = a(aa2, aa3, aa4, f10, a10, b10, iaVarArr4, iaVarArr5, length, c11, iaVarArr3);
        } else {
            iaVarArr3 = iaVarArr6;
            c10 = 2;
            iaVarArr2 = iaVarArr5;
            iaVarArr = iaVarArr4;
            i10 = 0;
        }
        C0596ia iaVar = iaVarArr3[0];
        q a11 = a(aa2, aa3, aa4, iaVar, iaVarArr3[1], a10);
        if (!Ka.f14573k || !Ka.f14570h) {
            qVar = a11;
        } else {
            qVar = a11;
            a(a11, length, a10, aa2, aa3, aa4, iaVarArr, i10, iaVarArr2);
        }
        C0595i a12 = a(this.f15014a, qVar, a10);
        if (iaVar == null) {
            zVarArr = new z[3];
            zVarArr[0] = aa4;
            zVarArr[1] = aa2;
            zVarArr[c10] = aa3;
        } else {
            zVarArr = new z[4];
            zVarArr[0] = aa4;
            zVarArr[1] = aa2;
            zVarArr[c10] = aa3;
            zVarArr[3] = iaVar;
        }
        float[] fArr = new float[8];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f11 = a10;
        fArr[c10] = f11;
        fArr[3] = 0.0f;
        fArr[4] = f11;
        fArr[5] = f11;
        fArr[6] = 0.0f;
        fArr[7] = f11;
        qVar.a(fArr);
        z zVar = new z(fArr[0], fArr[1], aa2.d());
        z zVar2 = new z(fArr[c10], fArr[3], aa3.d());
        z zVar3 = new z(fArr[4], fArr[5], aa4.d());
        z[] zVarArr2 = new z[4];
        zVarArr2[0] = a(new z(fArr[6], fArr[7]));
        zVarArr2[1] = a(zVar);
        zVarArr2[c10] = a(zVar2);
        zVarArr2[3] = a(zVar3);
        return new g(a12, zVarArr, zVarArr2, f10);
    }

    private int a(Aa aa2, Aa aa3, Aa aa4, float f10, int i10, Ia ia2, C0596ia[] iaVarArr, C0596ia[] iaVarArr2, int i11, int i12, C0596ia[] iaVarArr3) {
        int i13;
        int i14;
        float b10 = (aa3.b() - aa2.b()) + aa4.b();
        float c10 = (aa3.c() - aa2.c()) + aa4.c();
        float f11 = i12;
        float f12 = 3.0f / f11;
        float f13 = 1.0f - f12;
        int b11 = (int) (aa2.b() + ((b10 - aa2.b()) * f13));
        int c11 = (int) (aa2.c() + (f13 * (c10 - aa2.c())));
        if (!Ka.f14579q[0] || i12 != 22) {
            i14 = 4;
            i13 = 16;
        } else {
            i13 = 8;
            i14 = 2;
        }
        for (int i15 = i14; i15 <= i13; i15 <<= 1) {
            try {
                iaVarArr3[0] = a(f10, b11, c11, i15);
                break;
            } catch (C0550a unused) {
            }
        }
        float f14 = i10 - 6.5f;
        iaVarArr3[1] = new C0596ia(f14, f14, aa4.e());
        if (iaVarArr3[0] != null && n.a(b11, c11, iaVarArr3[0].b(), iaVarArr3[0].c()) > f10 * 4.0f) {
            iaVarArr3[0] = null;
        }
        if (iaVarArr3[0] == null && i11 > 2) {
            int i16 = i11 - 2;
            iaVarArr3[1] = new C0596ia(ia2.b()[i16] + 0.5f, f14, aa4.e());
            int c12 = (int) (aa4.c() - (f12 * (aa4.c() - aa2.c())));
            int b12 = (int) ((((ia2.b()[i16] - 3.0f) / f11) * (aa3.b() - aa2.b())) + aa4.b());
            while (i14 <= i13) {
                try {
                    iaVarArr3[0] = a(f10, b12, c12, i14);
                    break;
                } catch (C0550a unused2) {
                    i14 <<= 1;
                }
            }
            if (iaVarArr3[0] != null && n.a(b12, c12, iaVarArr3[0].b(), iaVarArr3[0].c()) > f10 * 4.0f) {
                iaVarArr3[0] = null;
            }
        }
        if (!Ka.f14573k || !Ka.f14570h) {
            return 0;
        }
        return a(ia2, i12, aa3, aa2, aa4, f10, i11, 0, iaVarArr, iaVarArr2);
    }

    private int a(Ia ia2, int i10, Aa aa2, Aa aa3, Aa aa4, float f10, int i11, int i12, C0596ia[] iaVarArr, C0596ia[] iaVarArr2) {
        int i13;
        int i14;
        int i15;
        float f11;
        int i16 = i11;
        int i17 = i12;
        int i18 = 0;
        while (i18 < i16) {
            int i19 = 1;
            if (i18 == 0) {
                i14 = i16 - 1;
                i13 = 1;
            } else {
                i14 = i16;
                i13 = 0;
            }
            if (i18 != i16 - 1) {
                i19 = i13;
            }
            float f12 = 3.0f;
            float f13 = i10;
            float b10 = (((ia2.b()[i18] - 3.0f) * (aa2.b() - aa3.b())) / f13) + aa3.b();
            float c10 = (((ia2.b()[i18] - 3.0f) * (aa2.c() - aa3.c())) / f13) + aa3.c();
            while (i19 < i14) {
                int c11 = (int) (c10 - (((ia2.b()[i19] - f12) * (aa3.c() - aa4.c())) / f13));
                int b11 = (int) (b10 - (((ia2.b()[i19] - f12) * (aa3.b() - aa4.b())) / f13));
                int i20 = 4;
                int i21 = 4;
                while (true) {
                    if (i21 > i20) {
                        i15 = i14;
                        f11 = b10;
                        break;
                    }
                    int i22 = (i18 * i16) + i19;
                    try {
                        iaVarArr[i22] = a(f10, b11, c11, i21);
                        i15 = i14;
                        try {
                            f11 = b10;
                            try {
                                iaVarArr2[i22] = new C0596ia(ia2.b()[i18] + 0.5f, ia2.b()[i19] + 0.5f, aa4.e());
                                i17++;
                                break;
                            } catch (C0550a unused) {
                                continue;
                            }
                        } catch (C0550a unused2) {
                            f11 = b10;
                            i21 <<= 1;
                            i16 = i11;
                            b10 = f11;
                            i14 = i15;
                            i20 = 4;
                        }
                    } catch (C0550a unused3) {
                        i15 = i14;
                    }
                    i21 <<= 1;
                    i16 = i11;
                    b10 = f11;
                    i14 = i15;
                    i20 = 4;
                }
                i19++;
                i16 = i11;
                b10 = f11;
                i14 = i15;
                f12 = 3.0f;
            }
            i18++;
            i16 = i11;
        }
        return i17;
    }

    private void a(q qVar, int i10, int i11, Aa aa2, Aa aa3, Aa aa4, C0596ia[] iaVarArr, int i12, C0596ia[] iaVarArr2) {
        int i13 = i12 + 3;
        int i14 = i13 * 2;
        float[] fArr = new float[i14];
        float[] fArr2 = new float[i14];
        fArr[0] = aa2.b();
        fArr[1] = aa2.c();
        fArr[2] = aa3.b();
        fArr[3] = aa3.c();
        fArr[4] = aa4.b();
        fArr[5] = aa4.c();
        fArr2[0] = 3.5f;
        fArr2[1] = 3.5f;
        float f10 = i11 - 3.5f;
        fArr2[2] = f10;
        fArr2[3] = 3.5f;
        fArr2[4] = 3.5f;
        fArr2[5] = f10;
        int i15 = 6;
        int i16 = 6;
        for (int i17 = 0; i17 < i10 * i10; i17++) {
            if (iaVarArr[i17] != null) {
                int i18 = i15 + 1;
                fArr[i15] = iaVarArr[i17].b();
                i15 = i18 + 1;
                fArr[i18] = iaVarArr[i17].c();
                int i19 = i16 + 1;
                fArr2[i16] = iaVarArr2[i17].b();
                i16 = i19 + 1;
                fArr2[i19] = iaVarArr2[i17].c();
            }
        }
        float[] QuadFitting = LoadOpencvJNIUtil.QuadFitting(fArr2, i13, fArr);
        if (QuadFitting.length != 0) {
            qVar.a(QuadFitting[0], QuadFitting[1], QuadFitting[2], QuadFitting[3], QuadFitting[4], QuadFitting[5], QuadFitting[6], QuadFitting[7], QuadFitting[8], QuadFitting[9], QuadFitting[10], QuadFitting[11], QuadFitting[12], QuadFitting[13]);
        }
    }

    private g a(Aa aa2, Aa aa3, Aa aa4, float f10, int i10) {
        C0595i iVar = new C0595i(i10, i10);
        float f11 = i10;
        float b10 = this.f15014a.b() / f11;
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                double d10 = b10 * 0.5d;
                int i13 = (int) ((i12 * b10) + d10);
                int i14 = (int) ((i11 * b10) + d10);
                if (i13 < -1 || i13 > this.f15014a.d() || i14 < -1 || i14 > this.f15014a.b()) {
                    iVar.c(i12, i11);
                } else if (this.f15014a.b(i13, i14)) {
                    iVar.c(i12, i11);
                }
            }
        }
        z[] zVarArr = {aa4, aa2, aa3};
        float[] fArr = {0.0f, 0.0f, f11, 0.0f, f11, f11, 0.0f, f11};
        a(aa2, aa3, aa4, null, null, i10).a(fArr);
        return new g(iVar, zVarArr, new z[]{a(new z(fArr[6], fArr[7])), a(new z(fArr[0], fArr[1])), a(new z(fArr[2], fArr[3])), a(new z(fArr[4], fArr[5]))}, f10);
    }

    protected final float a(z zVar, z zVar2, z zVar3) {
        return (a(zVar, zVar2) + a(zVar, zVar3)) / 2.0f;
    }

    private float a(z zVar, z zVar2) {
        float b10 = b((int) zVar.b(), (int) zVar.c(), (int) zVar2.b(), (int) zVar2.c());
        float b11 = b((int) zVar2.b(), (int) zVar2.c(), (int) zVar.b(), (int) zVar.c());
        return Float.isNaN(b10) ? b11 / 7.0f : Float.isNaN(b11) ? b10 / 7.0f : (b10 + b11) / 14.0f;
    }

    private float a(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z10;
        C0644ya yaVar;
        boolean z11;
        boolean z12 = true;
        boolean z13 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z13) {
            i16 = i10;
            i17 = i11;
            i14 = i12;
            i15 = i13;
        } else {
            i17 = i10;
            i16 = i11;
            i15 = i12;
            i14 = i13;
        }
        int abs = Math.abs(i15 - i17);
        int abs2 = Math.abs(i14 - i16);
        int i20 = 2;
        int i21 = (-abs) / 2;
        int i22 = -1;
        int i23 = i17 < i15 ? 1 : -1;
        if (i16 < i14) {
            i22 = 1;
        }
        int i24 = i15 + i23;
        int i25 = i17;
        int i26 = i16;
        int i27 = 0;
        while (true) {
            if (i25 == i24) {
                i18 = i24;
                i19 = i20;
                break;
            }
            int i28 = z13 ? i26 : i25;
            int i29 = z13 ? i25 : i26;
            if (i27 == z12) {
                z10 = z13;
                z11 = z12;
                i18 = i24;
                yaVar = this;
            } else {
                yaVar = this;
                z10 = z13;
                i18 = i24;
                z11 = false;
            }
            if (z11 == yaVar.f15014a.b(i28, i29)) {
                if (i27 == 2) {
                    return n.a(i25, i26, i17, i16);
                }
                i27++;
            }
            i21 += abs2;
            if (i21 > 0) {
                if (i26 == i14) {
                    i19 = 2;
                    break;
                }
                i26 += i22;
                i21 -= abs;
            }
            i25 += i23;
            i24 = i18;
            z13 = z10;
            z12 = true;
            i20 = 2;
        }
        if (i27 == i19) {
            return n.a(i18, i14, i17, i16);
        }
        return Float.NaN;
    }

    protected final C0596ia a(float f10, int i10, int i11, float f11) throws C0550a {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.f15014a.d() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (min >= f12) {
            int max2 = Math.max(0, i11 - i12);
            int min2 = Math.min(this.f15014a.b() - 1, i11 + i12) - max2;
            if (min2 >= f12) {
                return new C0600ja(this.f15014a, max, max2, min, min2, f10, this.f15015b).a();
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }

    private z a(z zVar) {
        float b10 = zVar.b();
        float c10 = zVar.c();
        int d10 = this.f15014a.d() - 1;
        int b11 = this.f15014a.b() - 1;
        if (b10 < 0.0f) {
            b10 = 0.0f;
        }
        float f10 = d10;
        if (b10 > f10) {
            b10 = f10;
        }
        if (c10 < 0.0f) {
            c10 = 0.0f;
        }
        float f11 = b11;
        if (c10 > f11) {
            c10 = f11;
        }
        return new z(b10, c10, zVar.d());
    }
}
