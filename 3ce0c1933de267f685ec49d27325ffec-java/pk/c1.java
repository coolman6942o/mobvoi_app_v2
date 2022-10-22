package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TemperatureCovertImpl.java */
/* loaded from: classes2.dex */
public class c1 implements i<List<ih.a>, List<qf.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f32791a;

    /* compiled from: TemperatureCovertImpl.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(float f10);
    }

    public c1() {
        this(b1.f32780a);
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
    public List<qf.a> convert(List<ih.a> list) {
        String wwid = getWwid();
        String deviceId = getDeviceId();
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            ih.a aVar = list.get(i10);
            if (this.f32791a.a((float) aVar.b())) {
                qf.a aVar2 = new qf.a(DataType.Temperature, aVar.b());
                aVar2.h(aVar.c());
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

    public c1(a aVar) {
        this.f32791a = aVar;
    }
}
