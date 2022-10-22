package com.huawei.hms.scankit.util;
/* loaded from: classes2.dex */
public class LoadOpencvJNIUtil {
    private static final String TAG = "LoadOpencvJNIUtil";

    public static float[] QuadFitting(float[] fArr, int i10, float[] fArr2) {
        if (fArr2 != null) {
            return OpencvJNI.QuadFitting(fArr, i10, fArr2);
        }
        return null;
    }

    public static byte[] adaptivebinary(byte[] bArr, int i10, int i11, int i12) {
        if (bArr == null || i10 < i12 || i11 < i12) {
            return null;
        }
        return OpencvJNI.adaptiveBinary(bArr, i10, i11, i12);
    }

    public static byte[] imageResize(byte[] bArr, int i10, int i11, int i12, int i13) {
        if (bArr != null) {
            return OpencvJNI.imageResize(bArr, i10, i11, i12, i13);
        }
        return null;
    }

    public static byte[] imageRotate(byte[] bArr, int i10, int i11, int i12, int i13, float f10, double d10) {
        if (bArr != null) {
            return OpencvJNI.imageRotate(bArr, i10, i11, i12, i13, f10, d10);
        }
        return null;
    }

    public static float[] multiBarcodeDetect(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (bArr != null) {
            return OpencvJNI.multiBarcodeDetect(bArr, i10, i11, i12, z10);
        }
        return null;
    }

    public static void setModel(byte[] bArr, int i10, float[] fArr, int i11, byte[] bArr2, int i12) {
        if (bArr != null && fArr != null) {
            OpencvJNI.setModel(bArr, i10, fArr, i11, bArr2, i12);
        }
    }
}
