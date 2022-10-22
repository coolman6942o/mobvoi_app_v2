package com.mobvoi.watch;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;
/* loaded from: classes2.dex */
public class SpeechUtils {
    public static final int AUDIO_BUF_SIZE_IN_BYTES = 8192;
    public static final int AUDIO_FORMAT = 2;
    public static final int CHANNEL = 16;
    public static final int CHUNKED_MODE_BUFFER_SIZE = 0;
    public static final int DEFAULT_BUFFER = 4096;
    public static final int SAMPLE_RATE = 16000;
    private static float sNoiseLevel = 75.0f;

    public static short[] bytesToShorts(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            sArr[i10] = (short) (((bArr[i11 + 1] << 8) & 65280) | (bArr[i11] & 255));
        }
        return sArr;
    }

    public static float getRmsdB(float f10) {
        float f11 = sNoiseLevel;
        if (f11 < f10) {
            sNoiseLevel = (f11 * 0.999f) + (0.001f * f10);
        } else {
            sNoiseLevel = (f11 * 0.95f) + (0.05f * f10);
        }
        float f12 = sNoiseLevel;
        if (f12 <= 0.0d || f10 / f12 <= 1.0E-6d) {
            return -120.0f;
        }
        return Math.min(Math.max(0.0f, ((float) Math.log10(f10 / f12)) * 10.0f), 60.0f);
    }

    public static boolean muteAudioFocus(Context context, boolean z10) {
        if (context == null) {
            Log.d("ANDROID_LAB", "context is null.");
            return false;
        } else if (Build.VERSION.SDK_INT <= 7) {
            return false;
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (z10) {
                if (audioManager.requestAudioFocus(null, 3, 2) != 1) {
                    return false;
                }
            } else if (audioManager.abandonAudioFocus(null) != 1) {
                return false;
            }
            return true;
        }
    }

    public static float rms(byte[] bArr, int i10, int i11) {
        if (i11 != 0) {
            float f10 = 0.0f;
            for (int i12 = i10; i12 < i10 + i11; i12 += 2) {
                short s10 = 0;
                for (int i13 = 0; i13 < 2; i13++) {
                    s10 = (short) (s10 | ((bArr[i12 + i13] & 255) << (i13 * 8)));
                }
                f10 += s10 * s10;
            }
            return (float) Math.sqrt(f10 / (i11 / 2));
        }
        throw new IllegalArgumentException();
    }

    public static void setNoiseLevel(float f10) {
        sNoiseLevel = f10;
    }

    public static byte[] shortArrayToByteArray(short[] sArr, int i10) {
        byte[] bArr = new byte[i10 * 2];
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] shortToBytes = shortToBytes(sArr[i11]);
            int i12 = i11 * 2;
            bArr[i12] = shortToBytes[0];
            bArr[i12 + 1] = shortToBytes[1];
        }
        return bArr;
    }

    public static byte[] shortToBytes(short s10) {
        return new byte[]{(byte) s10, (byte) (s10 >> 8)};
    }

    public static byte[] shortsToBytes(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i10 = 0; i10 < sArr.length; i10++) {
            byte[] shortToBytes = shortToBytes(sArr[i10]);
            int i11 = i10 * 2;
            bArr[i11] = shortToBytes[0];
            bArr[i11 + 1] = shortToBytes[1];
        }
        return bArr;
    }
}
