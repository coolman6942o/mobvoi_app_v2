package yj;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.android.common.utils.d;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.pojo.MotionType;
import java.util.Locale;
import qf.a;
/* compiled from: SleepDepth.java */
/* loaded from: classes2.dex */
public class e implements JsonBean {
    public MotionType depth;
    public long fromTime;
    public MotionType nextDepth;
    public long toTime;

    public e() {
        MotionType motionType = MotionType.Unknown;
        this.depth = motionType;
        this.nextDepth = motionType;
    }

    public a a() {
        a aVar = new a(DataType.Motion, this.fromTime, this.toTime);
        aVar.i(this.depth.typeCode, this.nextDepth.typeCode);
        return aVar;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "SleepDepth %s, nextDepth %s [%s, %s)", this.depth, this.nextDepth, d.a(this.fromTime), d.a(this.toTime));
    }

    public e(long j10, long j11, MotionType motionType, MotionType motionType2) {
        MotionType motionType3 = MotionType.Unknown;
        this.depth = motionType3;
        this.nextDepth = motionType3;
        this.fromTime = j10;
        this.toTime = j11;
        this.depth = motionType;
        this.nextDepth = motionType2;
    }
}
