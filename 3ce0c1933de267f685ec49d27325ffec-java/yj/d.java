package yj;

import com.mobvoi.android.common.json.JsonBean;
import java.util.List;
import java.util.Locale;
/* compiled from: SleepBloodOxygen.java */
/* loaded from: classes2.dex */
public class d implements JsonBean {
    public int avg;
    public long endTime;
    public int max;
    public int min;
    public List<a> oxygen;
    public long startTime;

    public d() {
    }

    public boolean a() {
        return this.avg >= 95;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "SleepBloodOxygen {startTime is %d, endTime is %d}, max is %d, min is %d, avg is %d, oxygen size is %d", Long.valueOf(this.startTime), Long.valueOf(this.endTime), Integer.valueOf(this.max), Integer.valueOf(this.min), Integer.valueOf(this.avg), Integer.valueOf(this.oxygen.size()));
    }

    public d(long j10, long j11, List<a> list, int i10, int i11, int i12) {
        this.startTime = j10;
        this.endTime = j11;
        this.oxygen = list;
        this.max = i10;
        this.min = i11;
        this.avg = i12;
    }
}
