package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0575d;
/* compiled from: Decoder.java */
/* renamed from: com.huawei.hms.scankit.p.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
/* synthetic */ class C0571c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f14754a;

    static {
        int[] iArr = new int[C0575d.a.values().length];
        f14754a = iArr;
        try {
            iArr[C0575d.a.UPPER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14754a[C0575d.a.LOWER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14754a[C0575d.a.MIXED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14754a[C0575d.a.PUNCT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14754a[C0575d.a.DIGIT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
