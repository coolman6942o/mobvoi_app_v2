package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0620q;
/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.p  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
/* synthetic */ class C0617p {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f14889a;

    static {
        int[] iArr = new int[C0620q.a.values().length];
        f14889a = iArr;
        try {
            iArr[C0620q.a.C40_ENCODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14889a[C0620q.a.TEXT_ENCODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14889a[C0620q.a.ANSIX12_ENCODE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14889a[C0620q.a.EDIFACT_ENCODE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f14889a[C0620q.a.BASE256_ENCODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
