package pg;

import android.text.TextUtils;
import com.mobvoi.health.common.data.pojo.DataType;
import ef.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xe.b;
import yg.f;
/* compiled from: FitnessInternalAccessor.java */
/* loaded from: classes2.dex */
public class a implements mh.a {

    /* renamed from: a  reason: collision with root package name */
    private final b f32773a = f.X().p();

    private void b(List<qf.a> list, u uVar, DataType dataType, float f10) {
        if (f10 > 0.0f) {
            list.add(new qf.a(dataType, uVar.f25989h, uVar.f25990i, f10));
        }
    }

    @Override // mh.a
    public List<qf.a> a(long j10, long j11, String str) {
        List<u> list;
        if (TextUtils.isEmpty(str)) {
            list = this.f32773a.g(new Date(j11), new Date(j10), Integer.MAX_VALUE);
        } else {
            list = this.f32773a.e(new Date(j11), new Date(j10), Integer.MAX_VALUE, str);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (u uVar : list) {
            b(arrayList, uVar, DataType.DeltaStep, uVar.f25995n);
            b(arrayList, uVar, DataType.DeltaCalorie, uVar.f25993l);
            b(arrayList, uVar, DataType.DeltaDistance, uVar.f25992k);
            b(arrayList, uVar, DataType.DeltaExercise, ((float) uVar.f25991j) / 1000.0f);
        }
        return arrayList;
    }
}
