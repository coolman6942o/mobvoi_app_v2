package com.huawei.hms.scankit.p;
/* compiled from: ErrorCorrectionLevel.java */
/* renamed from: com.huawei.hms.scankit.p.za  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC0647za {
    L(1),
    M(0),
    Q(3),
    H(2);
    

    /* renamed from: e  reason: collision with root package name */
    private static final EnumC0647za[] f15026e;

    /* renamed from: g  reason: collision with root package name */
    private final int f15028g;

    static {
        EnumC0647za zaVar = L;
        EnumC0647za zaVar2 = M;
        EnumC0647za zaVar3 = Q;
        f15026e = new EnumC0647za[]{zaVar2, zaVar, H, zaVar3};
    }

    EnumC0647za(int i10) {
        this.f15028g = i10;
    }

    public int a() {
        return this.f15028g;
    }

    public static EnumC0647za a(int i10) {
        if (i10 >= 0) {
            EnumC0647za[] zaVarArr = f15026e;
            if (i10 < zaVarArr.length) {
                return zaVarArr[i10];
            }
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e10) {
            throw e10;
        }
    }
}
