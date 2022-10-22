package com.mobvoi.wear.util;

import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.math.BigDecimal;
import java.math.RoundingMode;
/* loaded from: classes2.dex */
public class UnitsUtility {
    private static final ImperialGetter DEFAULT_IMPERIAL_GETTER;
    private static final int FOOT_2_INCH = 12;
    private static final float INCH_2_CM_VALUE = 2.54f;
    private static final float KM_2_MILES = 0.621371f;
    private static final float METRE_2_FEET = 3.281f;
    private static final float METRE_2_YARD = 1.0936133f;
    private static final int POUND_2_GRAM = 454;
    private static final String TAG = "UnitsUtility";
    private static final float YARD_2_METRE = 0.9144f;
    private static ImperialGetter imperialGetter;

    /* loaded from: classes2.dex */
    public interface ImperialGetter {
        boolean isImperial(Context context);
    }

    /* loaded from: classes2.dex */
    public static class Length {
        public static float cm2inch(float f10) {
            return f10 * 0.393701f;
        }

        public static float cm2m(float f10) {
            return f10 * 0.01f;
        }

        public static float ft2m(float f10) {
            return f10 / UnitsUtility.METRE_2_FEET;
        }

        public static float inch2cm(float f10) {
            return f10 * 2.54E-4f;
        }

        public static float inch2m(float f10) {
            return f10 * 0.0254f;
        }

        public static float km2m(float f10) {
            return f10 * 1000.0f;
        }

        public static float m2cm(float f10) {
            return f10 * 100.0f;
        }

        public static float m2ft(float f10) {
            return f10 * UnitsUtility.METRE_2_FEET;
        }

        public static float m2inch(float f10) {
            return f10 * 39.3701f;
        }

        public static float m2km(float f10) {
            return f10 * 0.001f;
        }

        public static float m2mile(float f10) {
            return (f10 * UnitsUtility.KM_2_MILES) / 1000.0f;
        }

        public static float m2yard(float f10) {
            return f10 * UnitsUtility.METRE_2_YARD;
        }

        public static float mile2m(float f10) {
            return f10 * 1609.34f;
        }

        public static float yard2m(float f10) {
            return f10 / UnitsUtility.METRE_2_YARD;
        }
    }

    /* loaded from: classes2.dex */
    public static class Pace {
        public static float sPm2sPkm(float f10) {
            return f10 / Length.m2km(1.0f);
        }

        public static float sPm2sPmile(float f10) {
            return f10 / Length.m2mile(1.0f);
        }
    }

    /* loaded from: classes2.dex */
    public static class Speed {
        public static float mPs2kmPh(float f10) {
            return (f10 * Length.m2km(1.0f)) / Time.s2h(1.0f);
        }

        public static float mPs2milePh(float f10) {
            return (f10 * Length.m2mile(1.0f)) / Time.s2h(1.0f);
        }
    }

    /* loaded from: classes2.dex */
    public static class Time {
        public static float ms2min(long j10) {
            return (((float) j10) / 1000.0f) / 60.0f;
        }

        public static float s2h(float f10) {
            return (f10 / 60.0f) / 60.0f;
        }
    }

    static {
        a aVar = a.f20964a;
        DEFAULT_IMPERIAL_GETTER = aVar;
        imperialGetter = aVar;
    }

    public static String cm2FootAInch(float f10) {
        return inch2FootAInch(cm2Inch(f10));
    }

    public static float cm2Inch(float f10) {
        return f10 / INCH_2_CM_VALUE;
    }

    private static float cm2Inch(String str) {
        float f10;
        try {
            f10 = Float.valueOf(str).floatValue();
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            f10 = 0.0f;
        }
        return f10 / INCH_2_CM_VALUE;
    }

    public static int[] getFootAndInch(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[]{0, 0};
        }
        String[] split = str.split("'");
        if (split.length > 1) {
            try {
                return new int[]{Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim())};
            } catch (NumberFormatException e10) {
                k.r(TAG, "Failed to getFootAndInch", e10, new Object[0]);
            }
        }
        return new int[]{0, 0};
    }

    public static float inch2Cm(float f10) {
        return f10 * INCH_2_CM_VALUE;
    }

    public static float inch2Cm(float f10, float f11) {
        return ((f10 * 12.0f) + f11) * INCH_2_CM_VALUE;
    }

    public static float inch2Cm(int i10, int i11) {
        return ((i10 * 12) + i11) * INCH_2_CM_VALUE;
    }

    private static String inch2FootAInch(float f10) {
        int i10 = totalInch2Foot(f10);
        int i11 = totalInch2Inch(f10);
        if (i10 == 0) {
            return i11 + "''";
        }
        return i10 + "' " + i11 + "''";
    }

    public static boolean isImperial(Context context) {
        return imperialGetter.isImperial(context);
    }

    public static float kg2Pound(float f10) {
        return (f10 * 1000.0f) / 454.0f;
    }

    public static String kg2PoundStr(String str) {
        return kg2PoundValue(str) + "pounds";
    }

    public static float kg2PoundValue(float f10) {
        return (f10 * 1000.0f) / 454.0f;
    }

    public static int kg2PoundValue(String str) {
        float f10;
        try {
            f10 = Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            f10 = 0.0f;
        }
        return (int) ((f10 * 1000.0f) / 454.0f);
    }

    public static float km2Miles(float f10) {
        return f10 * KM_2_MILES;
    }

    public static float km2MilesSpeed(float f10) {
        return f10 * KM_2_MILES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(Context context) {
        return "imperial".equals(SharedWearInfoHelper.getInstance(context).getCompanionUnit());
    }

    public static float m2Ma(float f10) {
        return f10 * METRE_2_YARD;
    }

    public static float ma2M(float f10) {
        return f10 * YARD_2_METRE;
    }

    public static float miles2Km(float f10) {
        return f10 / KM_2_MILES;
    }

    public static float paceImperial(float f10) {
        return f10 / KM_2_MILES;
    }

    public static String pound2KgStr(String str) {
        float f10;
        try {
            f10 = Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            f10 = 0.0f;
        }
        return ((f10 * 454.0f) / 1000.0f) + "";
    }

    public static float pound2KgValue(float f10) {
        return (f10 * 454.0f) / 1000.0f;
    }

    public static void setImperialGetter(ImperialGetter imperialGetter2) {
        imperialGetter = imperialGetter2;
    }

    public static String switchValue(String str, Context context) {
        return switchValue(Float.valueOf(str).floatValue(), context) + "";
    }

    public static int totalInch2Foot(float f10) {
        return (int) (f10 / 12.0f);
    }

    public static int totalInch2Foot(String str) {
        return (int) (cm2Inch(str) / 12.0f);
    }

    public static int totalInch2Inch(float f10) {
        return new BigDecimal(f10).remainder(new BigDecimal(12)).setScale(0, RoundingMode.HALF_UP).intValue();
    }

    public static float switchValue(float f10, Context context) {
        return isImperial(context) ? km2Miles(f10) : f10;
    }

    public static String pound2KgStr(int i10) {
        return ((i10 * 454.0f) / 1000.0f) + "";
    }

    public static int totalInch2Inch(String str) {
        return (int) (cm2Inch(str) % 12.0f);
    }

    public static String inch2FootAInch(int i10) {
        float f10 = i10;
        int i11 = totalInch2Foot(f10);
        int i12 = totalInch2Inch(f10);
        if (i11 == 0) {
            return i12 + "''";
        }
        return i11 + "' " + i12 + "''";
    }
}
