package com.huawei.hms.scankit.util;

import com.huawei.hms.scankit.k;
/* loaded from: classes2.dex */
public class OpencvJNI {
    static {
        a.c("OpencvJNI", "start load method");
        try {
            System.loadLibrary("scannative");
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            a.b("OpencvJNI", "UnsatisfiedLinkError");
            k.a(false);
        }
    }

    public static native float[] QuadFitting(float[] fArr, int i10, float[] fArr2);

    public static native byte[] adaptiveBinary(byte[] bArr, int i10, int i11, int i12);

    public static native byte[] imageResize(byte[] bArr, int i10, int i11, int i12, int i13);

    public static native byte[] imageRotate(byte[] bArr, int i10, int i11, int i12, int i13, float f10, double d10);

    public static void init() {
        a.c("OpencvJNI", "init()");
    }

    public static native float[] multiBarcodeDetect(byte[] bArr, int i10, int i11, int i12, boolean z10);

    public static native void setModel(byte[] bArr, int i10, float[] fArr, int i11, byte[] bArr2, int i12);
}
