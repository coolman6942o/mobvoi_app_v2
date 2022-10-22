package com.huawei.hms.scankit.p;
/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.va  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
/* synthetic */ class C0635va {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f14991a;

    static {
        int[] iArr = new int[Fa.values().length];
        f14991a = iArr;
        try {
            iArr[Fa.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14991a[Fa.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14991a[Fa.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14991a[Fa.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14991a[Fa.TERMINATOR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f14991a[Fa.FNC1_FIRST_POSITION.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f14991a[Fa.FNC1_SECOND_POSITION.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f14991a[Fa.STRUCTURED_APPEND.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f14991a[Fa.ECI.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f14991a[Fa.HANZI.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
