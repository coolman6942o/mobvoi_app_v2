package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.ticwear.youngwatch.data.PedometerData;
import java.util.ArrayList;
import java.util.List;
/* compiled from: StepConvertImpl.java */
/* loaded from: classes2.dex */
public class z0 implements i<List<PedometerData>, List<qf.a>> {

    /* renamed from: a  reason: collision with root package name */
    private final a f32866a;

    /* compiled from: StepConvertImpl.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean a(float f10);
    }

    public z0() {
        this(y0.f32865a);
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
    public List<qf.a> convert(List<PedometerData> list) {
        int i10;
        int i11;
        int i12;
        ArrayList arrayList;
        String wwid = getWwid();
        String deviceId = getDeviceId();
        int size = list.size();
        ArrayList arrayList2 = new ArrayList(size);
        com.mobvoi.health.common.data.db.a c10 = e.f().c();
        int i13 = 0;
        int i14 = 0;
        while (i14 < size) {
            PedometerData pedometerData = list.get(i14);
            long d10 = pedometerData.d();
            long c11 = pedometerData.c() > 0 ? d10 + pedometerData.c() : d10;
            if (this.f32866a.a(pedometerData.e())) {
                List<qf.a> h10 = c10.h(DataType.DeltaStep, d10, c11 + 1);
                int e10 = pedometerData.e();
                if (h10.size() > 0) {
                    long j10 = ((qf.a) h10.get(i13)).f33128d;
                    int i15 = i13;
                    for (qf.a aVar : h10) {
                        i14 = i14;
                        long j11 = aVar.f33128d;
                        if (j10 < j11) {
                            j10 = j11;
                        }
                        i15 = (int) (i15 + aVar.e());
                    }
                    i10 = i14;
                    e10 -= i15;
                    d10 = j10 + 1;
                } else {
                    i10 = i14;
                }
                long j12 = d10;
                if (e10 > 0) {
                    qf.a aVar2 = new qf.a(DataType.DeltaStep, j12, c11);
                    aVar2.i(e10);
                    aVar2.f33126b = wwid;
                    aVar2.f33125a = deviceId;
                    arrayList2.add(aVar2);
                }
            } else {
                i10 = i14;
                if (this.f32866a.a(pedometerData.b())) {
                    long j13 = c11 + 2;
                    List<qf.a> h11 = c10.h(DataType.DeltaDistance, d10, j13);
                    List<qf.a> h12 = c10.h(DataType.DeltaCalorie, d10, j13);
                    int b10 = pedometerData.b();
                    double a10 = pedometerData.a();
                    if (h11.size() > 0) {
                        int i16 = 0;
                        for (qf.a aVar3 : h11) {
                            size = size;
                            arrayList2 = arrayList2;
                            if (aVar3.f33129e == aVar3.f33128d) {
                                i16 = (int) (i16 + aVar3.e());
                            }
                        }
                        i11 = size;
                        arrayList = arrayList2;
                        double d11 = 0.0d;
                        for (qf.a aVar4 : h12) {
                            double d12 = d11;
                            d11 = aVar4.f33129e == aVar4.f33128d ? d12 + aVar4.e() : d12;
                        }
                        b10 -= i16;
                        a10 -= d11;
                    } else {
                        i11 = size;
                        arrayList = arrayList2;
                    }
                    if (b10 > 0) {
                        long j14 = c11 + 1;
                        qf.a aVar5 = new qf.a(DataType.DeltaDistance, j14, j14);
                        aVar5.i(b10);
                        aVar5.f33126b = wwid;
                        aVar5.f33125a = deviceId;
                        arrayList2 = arrayList;
                        arrayList2.add(aVar5);
                    } else {
                        arrayList2 = arrayList;
                    }
                    if (a10 > 0.0d) {
                        long j15 = c11 + 1;
                        qf.a aVar6 = new qf.a(DataType.DeltaCalorie, j15, j15);
                        float f10 = (float) a10;
                        i12 = 0;
                        aVar6.h(f10);
                        aVar6.f33126b = wwid;
                        aVar6.f33125a = deviceId;
                        arrayList2.add(aVar6);
                        i14 = i10 + 1;
                        i13 = i12;
                        size = i11;
                    }
                    i12 = 0;
                    i14 = i10 + 1;
                    i13 = i12;
                    size = i11;
                }
            }
            i11 = size;
            i12 = 0;
            i14 = i10 + 1;
            i13 = i12;
            size = i11;
        }
        return arrayList2;
    }

    @Override // pk.i
    public /* synthetic */ String getDeviceId() {
        return h.c(this);
    }

    @Override // pk.i
    public /* synthetic */ String getWwid() {
        return h.e(this);
    }

    public z0(a aVar) {
        this.f32866a = aVar;
    }
}
