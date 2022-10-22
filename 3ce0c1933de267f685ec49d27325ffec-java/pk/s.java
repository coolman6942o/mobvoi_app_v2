package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.List;
/* compiled from: HeartRateCovertImpl.java */
/* loaded from: classes2.dex */
public class s implements i<List<h0>, List<qf.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f32830a;

    /* compiled from: HeartRateCovertImpl.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(int i10);
    }

    public s() {
        this(r.f32818a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean f(int i10) {
        return i10 > 0;
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
    public List<qf.a> convert(List<h0> list) {
        String wwid = getWwid();
        String deviceId = getDeviceId();
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            h0 h0Var = list.get(i10);
            if (this.f32830a.a(h0Var.a())) {
                qf.a aVar = new qf.a(DataType.HeartRate, c(h0Var.b()));
                aVar.i(h0Var.a());
                aVar.f33126b = wwid;
                aVar.f33125a = deviceId;
                arrayList.add(aVar);
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

    public s(a aVar) {
        this.f32830a = aVar;
    }
}
