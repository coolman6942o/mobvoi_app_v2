package com.huawei.hms.scankit.p;
/* compiled from: Mode.java */
/* loaded from: classes2.dex */
public enum Fa {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    

    /* renamed from: l  reason: collision with root package name */
    private final int[] f14527l;

    /* renamed from: m  reason: collision with root package name */
    private final int f14528m;

    Fa(int[] iArr, int i10) {
        this.f14527l = iArr;
        this.f14528m = i10;
    }

    public static Fa a(int i10) {
        if (i10 == 0) {
            return TERMINATOR;
        }
        if (i10 == 1) {
            return NUMERIC;
        }
        if (i10 == 2) {
            return ALPHANUMERIC;
        }
        if (i10 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i10 == 4) {
            return BYTE;
        }
        if (i10 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i10 == 7) {
            return ECI;
        }
        if (i10 == 8) {
            return KANJI;
        }
        if (i10 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i10 == 13) {
            return HANZI;
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e10) {
            throw e10;
        }
    }

    public int a(Ia ia2) {
        int e10 = ia2.e();
        return this.f14527l[e10 <= 9 ? (char) 0 : e10 <= 26 ? (char) 1 : (char) 2];
    }

    public int a() {
        return this.f14528m;
    }
}
