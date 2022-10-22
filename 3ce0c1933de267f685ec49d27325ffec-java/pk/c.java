package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import gg.g;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ArtyInfoCovertImpl.java */
/* loaded from: classes2.dex */
public class c implements i<List<g>, List<qf.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f32781a;

    /* compiled from: ArtyInfoCovertImpl.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(int i10);
    }

    public c() {
        this(b.f32778a);
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
    public List<qf.a> convert(List<g> list) {
        String wwid = getWwid();
        String deviceId = getDeviceId();
        ArrayList arrayList = new ArrayList(list.size());
        for (g gVar : list) {
            if (this.f32781a.a(gVar.f27472g)) {
                DataType dataType = DataType.ArtyData;
                long j10 = gVar.f27466a;
                qf.a aVar = new qf.a(dataType, j10, j10, gVar.f27467b + "," + gVar.f27468c + "," + gVar.f27469d + "," + gVar.f27470e + "," + gVar.f27471f + "," + gVar.f27472g + "," + gVar.f27473h + "," + gVar.f27474i);
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

    public c(a aVar) {
        this.f32781a = aVar;
    }
}
