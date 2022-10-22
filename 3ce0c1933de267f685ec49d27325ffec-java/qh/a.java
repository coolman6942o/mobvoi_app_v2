package qh;

import com.mobvoi.health.common.data.db.c;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import java.util.List;
import rh.b;
/* compiled from: HeartRateDbAccessor.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private c f33154a;

    public a(c cVar) {
        this.f33154a = cVar;
    }

    public List<b> a(long j10, long j11) {
        List<qf.a> h10 = this.f33154a.h(DataType.HeartRate, j10, j11);
        ArrayList arrayList = new ArrayList(h10.size());
        for (qf.a aVar : h10) {
            float e10 = aVar.e();
            if (e10 > 0.0f) {
                arrayList.add(new b(aVar.f33128d, e10));
            }
        }
        return arrayList;
    }
}
