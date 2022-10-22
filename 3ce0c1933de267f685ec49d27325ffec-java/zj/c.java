package zj;

import com.mobvoi.sleep.data.pojo.SleepRecord;
import yj.b;
/* compiled from: MorningPulseUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static int a(SleepRecord sleepRecord) {
        int i10;
        int i11;
        if (sleepRecord != null) {
            b d10 = sleepRecord.d();
            if (d10 == null) {
                i10 = -1;
            } else {
                i10 = (int) d10.value;
            }
            b i12 = sleepRecord.i();
            if (i12 == null) {
                i11 = -1;
            } else {
                i11 = (int) i12.value;
            }
            if (i11 >= 0 && i10 >= 0) {
                return Math.abs(i10 - i11);
            }
        }
        return -1;
    }

    public static int b(SleepRecord sleepRecord) {
        b d10;
        if (sleepRecord == null || (d10 = sleepRecord.d()) == null) {
            return -1;
        }
        return (int) d10.value;
    }
}
