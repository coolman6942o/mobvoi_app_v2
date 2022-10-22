package p8;

import com.google.zxing.NotFoundException;
import com.google.zxing.i;
/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.b f32610a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32611b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32612c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32613d;

    /* renamed from: e  reason: collision with root package name */
    private final int f32614e;

    /* renamed from: f  reason: collision with root package name */
    private final int f32615f;

    /* renamed from: g  reason: collision with root package name */
    private final int f32616g;

    public b(com.google.zxing.common.b bVar) throws NotFoundException {
        this(bVar, 10, bVar.k() / 2, bVar.g() / 2);
    }

    private i[] a(i iVar, i iVar2, i iVar3, i iVar4) {
        float c10 = iVar.c();
        float d10 = iVar.d();
        float c11 = iVar2.c();
        float d11 = iVar2.d();
        float c12 = iVar3.c();
        float d12 = iVar3.d();
        float c13 = iVar4.c();
        float d13 = iVar4.d();
        return c10 < ((float) this.f32612c) / 2.0f ? new i[]{new i(c13 - 1.0f, d13 + 1.0f), new i(c11 + 1.0f, d11 + 1.0f), new i(c12 - 1.0f, d12 - 1.0f), new i(c10 + 1.0f, d10 - 1.0f)} : new i[]{new i(c13 + 1.0f, d13 + 1.0f), new i(c11 + 1.0f, d11 - 1.0f), new i(c12 - 1.0f, d12 + 1.0f), new i(c10 - 1.0f, d10 - 1.0f)};
    }

    private boolean b(int i10, int i11, int i12, boolean z10) {
        if (z10) {
            while (i10 <= i11) {
                if (this.f32610a.d(i10, i12)) {
                    return true;
                }
                i10++;
            }
            return false;
        }
        while (i10 <= i11) {
            if (this.f32610a.d(i12, i10)) {
                return true;
            }
            i10++;
        }
        return false;
    }

    private i d(float f10, float f11, float f12, float f13) {
        int c10 = a.c(a.a(f10, f11, f12, f13));
        float f14 = c10;
        float f15 = (f12 - f10) / f14;
        float f16 = (f13 - f11) / f14;
        for (int i10 = 0; i10 < c10; i10++) {
            float f17 = i10;
            int c11 = a.c((f17 * f15) + f10);
            int c12 = a.c((f17 * f16) + f11);
            if (this.f32610a.d(c11, c12)) {
                return new i(c11, c12);
            }
        }
        return null;
    }

    public i[] c() throws NotFoundException {
        int i10 = this.f32613d;
        int i11 = this.f32614e;
        int i12 = this.f32616g;
        int i13 = this.f32615f;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = true;
        while (z16) {
            boolean z17 = false;
            boolean z18 = true;
            while (true) {
                if ((z18 || !z11) && i11 < this.f32612c) {
                    z18 = b(i12, i13, i11, false);
                    if (z18) {
                        i11++;
                        z11 = true;
                        z17 = true;
                    } else if (!z11) {
                        i11++;
                    }
                }
            }
            if (i11 < this.f32612c) {
                boolean z19 = true;
                while (true) {
                    if ((z19 || !z12) && i13 < this.f32611b) {
                        z19 = b(i10, i11, i13, true);
                        if (z19) {
                            i13++;
                            z12 = true;
                            z17 = true;
                        } else if (!z12) {
                            i13++;
                        }
                    }
                }
                if (i13 < this.f32611b) {
                    boolean z20 = true;
                    while (true) {
                        if ((z20 || !z13) && i10 >= 0) {
                            z20 = b(i12, i13, i10, false);
                            if (z20) {
                                i10--;
                                z13 = true;
                                z17 = true;
                            } else if (!z13) {
                                i10--;
                            }
                        }
                    }
                    if (i10 >= 0) {
                        z16 = z17;
                        boolean z21 = true;
                        while (true) {
                            if ((z21 || !z15) && i12 >= 0) {
                                z21 = b(i10, i11, i12, true);
                                if (z21) {
                                    i12--;
                                    z16 = true;
                                    z15 = true;
                                } else if (!z15) {
                                    i12--;
                                }
                            }
                        }
                        if (i12 >= 0) {
                            if (z16) {
                                z14 = true;
                            }
                        }
                    }
                }
            }
            z10 = true;
            break;
        }
        if (z10 || !z14) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i14 = i11 - i10;
        i iVar = null;
        i iVar2 = null;
        for (int i15 = 1; iVar2 == null && i15 < i14; i15++) {
            iVar2 = d(i10, i13 - i15, i10 + i15, i13);
        }
        if (iVar2 != null) {
            i iVar3 = null;
            for (int i16 = 1; iVar3 == null && i16 < i14; i16++) {
                iVar3 = d(i10, i12 + i16, i10 + i16, i12);
            }
            if (iVar3 != null) {
                i iVar4 = null;
                for (int i17 = 1; iVar4 == null && i17 < i14; i17++) {
                    iVar4 = d(i11, i12 + i17, i11 - i17, i12);
                }
                if (iVar4 != null) {
                    for (int i18 = 1; iVar == null && i18 < i14; i18++) {
                        iVar = d(i11, i13 - i18, i11 - i18, i13);
                    }
                    if (iVar != null) {
                        return a(iVar, iVar2, iVar4, iVar3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public b(com.google.zxing.common.b bVar, int i10, int i11, int i12) throws NotFoundException {
        this.f32610a = bVar;
        int g10 = bVar.g();
        this.f32611b = g10;
        int k10 = bVar.k();
        this.f32612c = k10;
        int i13 = i10 / 2;
        int i14 = i11 - i13;
        this.f32613d = i14;
        int i15 = i11 + i13;
        this.f32614e = i15;
        int i16 = i12 - i13;
        this.f32616g = i16;
        int i17 = i12 + i13;
        this.f32615f = i17;
        if (i16 < 0 || i14 < 0 || i17 >= g10 || i15 >= k10) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
