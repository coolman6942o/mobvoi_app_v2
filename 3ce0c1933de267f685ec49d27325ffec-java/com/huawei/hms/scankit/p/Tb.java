package com.huawei.hms.scankit.p;

import com.realsil.sdk.dfu.DfuException;
/* compiled from: SymbolInfo.java */
/* loaded from: classes2.dex */
public class Tb {

    /* renamed from: a  reason: collision with root package name */
    static final Tb[] f14672a;

    /* renamed from: b  reason: collision with root package name */
    private static Tb[] f14673b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14674c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14675d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14676e;

    /* renamed from: f  reason: collision with root package name */
    public final int f14677f;

    /* renamed from: g  reason: collision with root package name */
    public final int f14678g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14679h;

    /* renamed from: i  reason: collision with root package name */
    private final int f14680i;

    /* renamed from: j  reason: collision with root package name */
    private final int f14681j;

    static {
        Tb[] tbArr = {new Tb(false, 3, 5, 8, 8, 1), new Tb(false, 5, 7, 10, 10, 1), new Tb(true, 5, 7, 16, 6, 1), new Tb(false, 8, 10, 12, 12, 1), new Tb(true, 10, 11, 14, 6, 2), new Tb(false, 12, 12, 14, 14, 1), new Tb(true, 16, 14, 24, 10, 1), new Tb(false, 18, 14, 16, 16, 1), new Tb(false, 22, 18, 18, 18, 1), new Tb(true, 22, 18, 16, 10, 2), new Tb(false, 30, 20, 20, 20, 1), new Tb(true, 32, 24, 16, 14, 2), new Tb(false, 36, 24, 22, 22, 1), new Tb(false, 44, 28, 24, 24, 1), new Tb(true, 49, 28, 22, 14, 2), new Tb(false, 62, 36, 14, 14, 4), new Tb(false, 86, 42, 16, 16, 4), new Tb(false, 114, 48, 18, 18, 4), new Tb(false, 144, 56, 20, 20, 4), new Tb(false, 174, 68, 22, 22, 4), new Tb(false, 204, 84, 24, 24, 4, 102, 42), new Tb(false, DfuException.ERROR_ENTER_OTA_MODE_FAILED, 112, 14, 14, 16, 140, 56), new Tb(false, 368, 144, 16, 16, 16, 92, 36), new Tb(false, 456, 192, 18, 18, 16, 114, 48), new Tb(false, 576, 224, 20, 20, 16, 144, 56), new Tb(false, 696, DfuException.ERROR_READ_PATCH_INFO_ERROR, 22, 22, 16, 174, 68), new Tb(false, 816, 336, 24, 24, 16, 136, 56), new Tb(false, 1050, 408, 18, 18, 36, 175, 68), new Tb(false, 1304, 496, 20, 20, 36, 163, 62), new Mb()};
        f14672a = tbArr;
        f14673b = tbArr;
    }

    public Tb(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    public static Tb a(int i10, Ub ub2, C0639wb wbVar, C0639wb wbVar2, boolean z10) {
        Tb[] tbArr;
        for (Tb tb2 : f14673b) {
            if ((ub2 != Ub.FORCE_SQUARE || !tb2.f14674c) && ((ub2 != Ub.FORCE_RECTANGLE || tb2.f14674c) && ((wbVar == null || (tb2.g() >= wbVar.b() && tb2.f() >= wbVar.a())) && ((wbVar2 == null || (tb2.g() <= wbVar2.b() && tb2.f() <= wbVar2.a())) && i10 <= tb2.f14675d)))) {
                return tb2;
            }
        }
        if (!z10) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't find a symbol arrangement that matches the message. Data codewords: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        } catch (Exception e10) {
            throw e10;
        }
    }

    private int h() {
        int i10 = this.f14679h;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (!(i10 == 2 || i10 == 4)) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                try {
                    throw new IllegalStateException("Cannot handle this number of data regions");
                } catch (Exception e10) {
                    throw e10;
                }
            }
        }
        return i11;
    }

    private int i() {
        int i10 = this.f14679h;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        try {
            throw new IllegalStateException("Cannot handle this number of data regions");
        } catch (Exception e10) {
            throw e10;
        }
    }

    public final int b() {
        return this.f14676e;
    }

    public int c() {
        return this.f14675d / this.f14680i;
    }

    public final int d() {
        return i() * this.f14678g;
    }

    public final int e() {
        return h() * this.f14677f;
    }

    public final int f() {
        return d() + (i() * 2);
    }

    public final int g() {
        return e() + (h() * 2);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14674c ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f14677f);
        sb2.append('x');
        sb2.append(this.f14678g);
        sb2.append(", symbol size ");
        sb2.append(g());
        sb2.append('x');
        sb2.append(f());
        sb2.append(", symbol data size ");
        sb2.append(e());
        sb2.append('x');
        sb2.append(d());
        sb2.append(", codewords ");
        sb2.append(this.f14675d);
        sb2.append('+');
        sb2.append(this.f14676e);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tb(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f14674c = z10;
        this.f14675d = i10;
        this.f14676e = i11;
        this.f14677f = i12;
        this.f14678g = i13;
        this.f14679h = i14;
        this.f14680i = i15;
        this.f14681j = i16;
    }

    public final int b(int i10) {
        return this.f14681j;
    }

    public final int a() {
        return this.f14675d;
    }

    public int a(int i10) {
        return this.f14680i;
    }
}
