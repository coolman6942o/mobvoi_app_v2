package sg;

import com.mobvoi.sleep.data.pojo.SleepRecord;
import fg.o;
/* compiled from: SleepTypePercent.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public int f34423a;

    /* renamed from: b  reason: collision with root package name */
    public long f34424b;

    /* renamed from: c  reason: collision with root package name */
    public SleepRecord.TimeType f34425c;

    /* renamed from: d  reason: collision with root package name */
    public float f34426d;

    /* renamed from: e  reason: collision with root package name */
    public float f34427e;

    public e(int i10, long j10, SleepRecord.TimeType timeType) {
        this.f34424b = j10;
        this.f34423a = i10;
        this.f34425c = timeType;
    }

    public int a() {
        SleepRecord.TimeType timeType = this.f34425c;
        if (timeType == SleepRecord.TimeType.Awake) {
            return o.f26484t;
        }
        if (timeType == SleepRecord.TimeType.Rem) {
            return o.f26490w;
        }
        if (timeType == SleepRecord.TimeType.LightSleep) {
            return o.f26488v;
        }
        return o.f26486u;
    }
}
