package pk;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.LogCleaner;
import ef.g;
import ef.p;
import ef.q;
import ef.r;
import ef.u;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import qf.a;
import xe.b;
/* compiled from: SportHeartRateHandler.java */
/* loaded from: classes2.dex */
public class w0 extends a<List<h0>, List<a>> implements p {

    /* renamed from: b  reason: collision with root package name */
    private final b f32846b;

    /* renamed from: c  reason: collision with root package name */
    private final t f32847c;

    public w0(b bVar, com.mobvoi.health.common.data.db.a aVar) {
        super(new s(v0.f32842a));
        this.f32846b = bVar;
        this.f32847c = new t(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean e(int i10) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void b(List<a> list) {
        long j10 = list.get(list.size() - 1).f33128d;
        long j11 = list.get(0).f33128d - LogCleaner.ONE_MINUTE;
        ArrayList<a> arrayList = new ArrayList();
        for (a aVar : list) {
            if (((int) aVar.e()) > 0) {
                arrayList.add(aVar);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f32847c.b(arrayList);
            List<u> g10 = this.f32846b.g(new Date(j10), new Date(j11), -1);
            if (g10.isEmpty()) {
                k.q("SportHeartRateHandler", "No sport summary found in points time range, skip points insert");
                return;
            }
            for (u uVar : g10) {
                long j12 = uVar.f25991j;
                q qVar = new q();
                ff.a aVar2 = new ff.a();
                for (a aVar3 : arrayList) {
                    g gVar = new g(aVar3.f33128d - uVar.f25989h, 2, (int) aVar3.e());
                    p a10 = ef.b.a(gVar);
                    if (a10 != null) {
                        qVar.b(a10);
                        aVar2.c(gVar);
                    }
                }
                uVar.n(aVar2.b());
                uVar.f25991j = j12;
                r rVar = new r(uVar, qVar);
                k.i("SportHeartRateHandler", "Insert %d sport points to %s", Integer.valueOf(qVar.f()), uVar.f25984c);
                this.f32846b.j(rVar);
            }
        }
    }
}
