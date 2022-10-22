package com.mobvoi.wear.util;
/* loaded from: classes2.dex */
public class SpeexUtil {
    private static final int[] kNBFrameSize = {6, 10, 15, 20, 20, 28, 28, 38, 38, 46, 62};
    private static final int[] kWBFrameSize = {10, 15, 20, 25, 32, 42, 52, 60, 70, 86, 106};

    public static int getFrameSize(int i10, int i11) {
        if (i10 == 8000) {
            return kNBFrameSize[i11];
        }
        if (i10 == 16000) {
            return kWBFrameSize[i11];
        }
        throw new IllegalArgumentException("Olny support NARROWBAND and WIDEBAND!");
    }
}
