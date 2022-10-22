package fg;

import com.mobvoi.health.companion.heartrate.ui.detail.BodyMindDetailActivity;
import com.mobvoi.health.companion.heartrate.ui.detail.HeartRateDetailActivity;
import com.mobvoi.health.companion.noise.NoiseDetailActivity;
import com.mobvoi.health.companion.oxygen.BloodOxygenDetailActivity;
import com.mobvoi.health.companion.pressure.PressureDetailActivity;
import com.mobvoi.health.companion.sleep.SleepDetailActivity;
import com.mobvoi.health.companion.sport.SportDetailActivity;
import com.mobvoi.health.companion.temperature.TemperatureDetailActivity;
/* compiled from: HealthUtils.java */
/* loaded from: classes2.dex */
public class l {
    public static int a(Class<?> cls) {
        String name = cls.getName();
        if (HeartRateDetailActivity.class.getName().equals(name)) {
            return 1;
        }
        if (PressureDetailActivity.class.getName().equals(name)) {
            return 3;
        }
        if (NoiseDetailActivity.class.getName().equals(name)) {
            return 5;
        }
        if (BloodOxygenDetailActivity.class.getName().equals(name)) {
            return 2;
        }
        if (SleepDetailActivity.class.getName().equals(name)) {
            return 4;
        }
        if (SportDetailActivity.class.getName().equals(name)) {
            return 6;
        }
        if (TemperatureDetailActivity.class.getName().equals(name)) {
            return 8;
        }
        return BodyMindDetailActivity.class.getName().equals(name) ? 10 : -1;
    }

    public static double b(long[] jArr, double d10, int i10, int i11) {
        if (jArr.length - 1 < i10) {
            return 0.0d;
        }
        double d11 = d10;
        if (d10 <= 0.0d) {
            for (long j10 : jArr) {
                d11 += j10;
            }
        }
        double pow = Math.pow(10.0d, i11);
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i12 = 0; i12 < jArr.length; i12++) {
            dArr[i12] = (jArr[i12] / d11) * pow * 100.0d;
        }
        double d12 = 100.0d * pow;
        int length2 = jArr.length;
        double[] dArr2 = new double[length2];
        for (int i13 = 0; i13 < length; i13++) {
            dArr2[i13] = Math.floor(dArr[i13]);
        }
        double d13 = 0.0d;
        for (int i14 = 0; i14 < length2; i14++) {
            d13 += dArr2[i14];
        }
        int length3 = jArr.length;
        double[] dArr3 = new double[length3];
        for (int i15 = 0; i15 < length2; i15++) {
            dArr3[i15] = dArr[i15] - dArr2[i15];
        }
        while (d13 < d12) {
            int i16 = 0;
            double d14 = 0.0d;
            for (int i17 = 0; i17 < length3; i17++) {
                if (dArr3[i17] > d14) {
                    d14 = dArr3[i17];
                    i16 = i17;
                }
            }
            dArr2[i16] = dArr2[i16] + 1.0d;
            dArr3[i16] = 0.0d;
            d13 += 1.0d;
        }
        return dArr2[i10] / pow;
    }
}
