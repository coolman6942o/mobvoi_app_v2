package yj;

import com.mobvoi.android.common.json.JsonBean;
import java.util.Locale;
/* compiled from: BloodOxygen.java */
/* loaded from: classes2.dex */
public class a implements JsonBean {
    public int percent;
    public long time;

    public a() {
    }

    public String toString() {
        return String.format(Locale.getDefault(), "BloodOxygen {%d, %d}", Long.valueOf(this.time), Integer.valueOf(this.percent));
    }

    public a(long j10, int i10) {
        this.time = j10;
        this.percent = i10;
    }
}
