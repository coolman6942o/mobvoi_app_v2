package pk;

import com.mobvoi.health.common.data.pojo.DataType;
import java.util.List;
import qf.a;
/* compiled from: DataPointHandler.java */
/* loaded from: classes2.dex */
public class k<BandData> extends a<BandData, List<a>> {

    /* renamed from: b  reason: collision with root package name */
    protected final com.mobvoi.health.common.data.db.a f32810b;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(i<BandData, List<a>> iVar, com.mobvoi.health.common.data.db.a aVar) {
        super(iVar);
        this.f32810b = aVar;
    }

    private void d(List<a> list) {
        if (com.mobvoi.android.common.utils.k.j() && !list.isEmpty()) {
            a aVar = list.get(0);
            this.f32810b.r(aVar.f33126b);
            if (this.f32810b.h((DataType) aVar.c(), aVar.f33129e, 1 + list.get(list.size() - 1).f33128d).isEmpty()) {
                throw new RuntimeException("Insert point fail");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void b(List<a> list) {
        this.f32810b.k(list);
        d(list);
    }
}
