package pk;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.ticwear.youngwatch.data.LSSleepStatus;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import yj.e;
/* compiled from: SleepResultConvertImpl.java */
/* loaded from: classes2.dex */
class o0 implements i<List<v>, s0> {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<LSSleepStatus, MotionType> f32815a;

    static {
        EnumMap enumMap = new EnumMap(LSSleepStatus.class);
        f32815a = enumMap;
        enumMap.put((EnumMap) LSSleepStatus.LSSleepStatusAwake, (LSSleepStatus) MotionType.Awake);
        enumMap.put((EnumMap) LSSleepStatus.LSSleepStatusDeep, (LSSleepStatus) MotionType.DeepSleep);
        enumMap.put((EnumMap) LSSleepStatus.LSSleepStatusLight, (LSSleepStatus) MotionType.LightSleep);
        enumMap.put((EnumMap) LSSleepStatus.LSSleepStatusUnknown, (LSSleepStatus) MotionType.Unknown);
    }

    private void d(v vVar) {
        long j10 = vVar.f32835a;
        long j11 = vVar.f32836b;
        ArrayList arrayList = new ArrayList();
        Iterator<w> it = vVar.f32841g.iterator();
        while (it.hasNext()) {
            w next = it.next();
            if (f(j10, next.f32844b)) {
                w wVar = new w();
                wVar.f32844b = j10 + 5;
                wVar.f32845c = next.f32844b - 5;
                wVar.f32843a = LSSleepStatus.LSSleepStatusAwake;
                arrayList.add(wVar);
            }
            j10 = next.f32845c;
        }
        if (f(j10, j11)) {
            w wVar2 = new w();
            wVar2.f32844b = j10 + 5;
            wVar2.f32845c = j11 - 5;
            wVar2.f32843a = LSSleepStatus.LSSleepStatusAwake;
            arrayList.add(wVar2);
        }
        vVar.f32841g.addAll(arrayList);
    }

    private boolean f(long j10, long j11) {
        return 100 < j11 - j10;
    }

    private String g(v vVar) {
        return "sleepTimeUTC: " + vVar.f32835a + " getupUtc: " + vVar.f32836b + " awakeCount: " + vVar.f32840f + " lightSleepTime:" + vVar.f32838d + " deepSleepTime:" + vVar.f32837c + " awakeSleepTime:" + vVar.f32839e;
    }

    @Override // pk.i
    public /* synthetic */ String a() {
        return h.d(this);
    }

    @Override // pk.i
    public /* synthetic */ String b() {
        return h.b(this);
    }

    @Override // pk.i
    public /* synthetic */ long c(long j10) {
        return h.a(this, j10);
    }

    /* renamed from: e */
    public s0 convert(List<v> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        s0 s0Var = new s0(arrayList, arrayList2);
        if (list.isEmpty()) {
            return s0Var;
        }
        String wwid = getWwid();
        if (TextUtils.isEmpty(wwid)) {
            k.q("SleepResultConvertImpl", "wwid is null");
            return s0Var;
        }
        String deviceId = getDeviceId();
        for (v vVar : list) {
            k.c("SleepResultConvertImpl", "Sleep result %s", g(vVar));
            d(vVar);
            arrayList.add(new SleepRecord.b(a()).F(c(vVar.f32835a)).v(c(vVar.f32836b)).J(wwid).t(deviceId).s());
            Iterator<w> it = vVar.f32841g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                k.c("SleepResultConvertImpl", "LSSleepStatusData LSSleepStatus %s,startTime %d,endTime %d", next.f32843a, Long.valueOf(next.f32844b), Long.valueOf(next.f32845c));
                e eVar = new e();
                eVar.fromTime = c(next.f32844b);
                eVar.toTime = c(next.f32845c) - 1;
                eVar.depth = f32815a.get(next.f32843a);
                arrayList2.add(eVar);
            }
        }
        return s0Var;
    }

    @Override // pk.i
    public /* synthetic */ String getDeviceId() {
        return h.c(this);
    }

    @Override // pk.i
    public /* synthetic */ String getWwid() {
        return h.e(this);
    }
}
