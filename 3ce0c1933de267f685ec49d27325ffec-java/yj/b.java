package yj;

import com.mobvoi.android.common.json.JsonBean;
import java.util.Locale;
/* compiled from: HeartRate.java */
/* loaded from: classes2.dex */
public class b implements JsonBean {
    public long time;
    public float value;

    public b() {
    }

    public String toString() {
        return String.format(Locale.getDefault(), "HeartRate {%d, %.1f}", Long.valueOf(this.time), Float.valueOf(this.value));
    }

    public b(long j10, float f10) {
        this.time = j10;
        this.value = f10;
    }
}
