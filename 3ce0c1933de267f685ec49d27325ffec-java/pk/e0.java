package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.List;
/* compiled from: OxygenCovertImpl.java */
/* loaded from: classes2.dex */
public class e0 implements i<List<qg.a>, List<qf.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f32796a;

    /* compiled from: OxygenCovertImpl.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(float f10);
    }

    public e0() {
        this(d0.f32792a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean f(float f10) {
        return f10 > 0.0f;
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
    public List<qf.a> convert(List<qg.a> list) {
        String wwid = getWwid();
        String deviceId = getDeviceId();
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            qg.a aVar = list.get(i10);
            if (this.f32796a.a((float) aVar.f33152a)) {
                qf.a aVar2 = new qf.a(DataType.BloodOxygen, aVar.f33152a);
                aVar2.h(aVar.f33153b);
                aVar2.f33126b = wwid;
                aVar2.f33125a = deviceId;
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    @Override // pk.i
    public /* synthetic */ String getDeviceId() {
        return h.c(this);
    }

    @Override // pk.i
    public /* synthetic */ String getWwid() {
        return h.e(this);
    }

    public e0(a aVar) {
        this.f32796a = aVar;
    }
}
