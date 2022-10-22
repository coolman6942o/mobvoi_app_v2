package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
/* compiled from: MultiFormatWriter.java */
/* renamed from: com.huawei.hms.scankit.p.xb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
/* synthetic */ class C0642xb {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f15002a;

    static {
        int[] iArr = new int[BarcodeFormat.values().length];
        f15002a = iArr;
        try {
            iArr[BarcodeFormat.EAN_8.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15002a[BarcodeFormat.UPC_E.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15002a[BarcodeFormat.EAN_13.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f15002a[BarcodeFormat.UPC_A.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15002a[BarcodeFormat.QR_CODE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f15002a[BarcodeFormat.CODE_39.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f15002a[BarcodeFormat.CODE_93.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f15002a[BarcodeFormat.CODE_128.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f15002a[BarcodeFormat.ITF.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f15002a[BarcodeFormat.PDF_417.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f15002a[BarcodeFormat.CODABAR.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f15002a[BarcodeFormat.DATA_MATRIX.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f15002a[BarcodeFormat.AZTEC.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
