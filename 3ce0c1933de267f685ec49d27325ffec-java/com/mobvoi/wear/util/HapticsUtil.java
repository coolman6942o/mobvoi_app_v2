package com.mobvoi.wear.util;

import android.content.Context;
import android.os.Build;
import com.mobvoi.wear.common.base.TicwatchModels;
import u9.b;
/* loaded from: classes2.dex */
public class HapticsUtil {
    private static final int SEQ_MAX_SIZE = 256;
    public static final int VIBRATE_LEVEL_HIGH = 0;
    public static final int VIBRATE_LEVEL_LOW = 1;

    private static Object invoke(Context context, String str, Object[] objArr, Class[] clsArr) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemHaptics");
            return loadClass.getMethod(str, clsArr).invoke(loadClass.getConstructor(Context.class).newInstance(context), objArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean isSupportHaptics(Context context) {
        String str = Build.MODEL;
        if (TicwatchModels.TICWATCH2_LILY.equals(str) || TicwatchModels.TICWATCH2_LOTUS.equals(str)) {
            return false;
        }
        return b.b("config.has_haptics", false);
    }

    public static void playEffect(Context context, int i10) throws IllegalArgumentException {
        if (i10 < 0 || i10 > 127) {
            throw new IllegalArgumentException("effect id should be 0~127");
        }
        invoke(context, "playeffect", new Object[]{Integer.valueOf(i10)}, new Class[]{Integer.TYPE});
    }

    public static void playEffectSequence(Context context, byte[] bArr) throws IllegalArgumentException {
        if (bArr.length < 1 || bArr.length > 256) {
            throw new IllegalArgumentException("effectSeq's size should between 0 and 256");
        }
        tranToHapticByte(bArr);
        invoke(context, "playEffectSeqBuff", new Object[]{bArr, Integer.valueOf(bArr.length)}, new Class[]{bArr.getClass(), Integer.TYPE});
    }

    public static void playRingEffectSequence(Context context, byte[] bArr) throws IllegalArgumentException {
        if (bArr.length < 1 || bArr.length > 256) {
            throw new IllegalArgumentException("effectSeq's size should between 0 and 256");
        }
        tranToHapticByte(bArr);
        invoke(context, "playRingEffectSeqBuff", new Object[]{bArr, Integer.valueOf(bArr.length)}, new Class[]{bArr.getClass(), Integer.TYPE});
    }

    public static void stopPlayEffect(Context context) {
        invoke(context, "stopPlayingEffect", new Object[0], new Class[0]);
    }

    private static void tranToHapticByte(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] < 0) {
                bArr[i10] = (byte) (Math.abs((int) bArr[i10]) | 128);
            }
        }
    }

    public static void userPreference(Context context, int i10) {
        invoke(context, "userPreference", new Object[]{Integer.valueOf(i10)}, new Class[]{Integer.TYPE});
    }

    public static int userPreferenceGet(Context context) {
        return ((Integer) invoke(context, "userPreferenceGet", new Object[0], new Class[0])).intValue();
    }
}
