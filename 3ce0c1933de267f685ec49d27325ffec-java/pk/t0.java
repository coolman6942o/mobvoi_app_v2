package pk;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.LogCleaner;
import ef.a;
import ef.p;
import ef.q;
import ef.r;
import ef.u;
import java.util.Date;
import java.util.List;
import xe.b;
/* compiled from: SportCalorieHandler.java */
/* loaded from: classes2.dex */
public class t0 extends a<g0, List<a>> implements p {

    /* renamed from: b  reason: collision with root package name */
    private final b f32833b;

    public t0(b bVar) {
        super(new g());
        this.f32833b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void b(List<a> list) {
        if (!list.isEmpty()) {
            List<u> g10 = this.f32833b.g(new Date(list.get(list.size() - 1).f25945b), new Date(list.get(0).f25945b - LogCleaner.ONE_MINUTE), -1);
            if (g10.isEmpty()) {
                k.q("SportCalorieHandler", "No sport summary found in points time range, skip points insert");
                return;
            }
            for (u uVar : g10) {
                q qVar = new q();
                if (uVar.f25993l <= 0.0f) {
                    for (a aVar : list) {
                        if (uVar.f25993l == -1.0f) {
                            uVar.f25993l = 0.0f;
                        }
                        long j10 = aVar.f25945b - uVar.f25989h;
                        uVar.f25993l += aVar.a();
                        p a10 = ef.b.a(new a(j10, aVar.a()));
                        if (a10 != null) {
                            qVar.b(a10);
                        }
                    }
                    r rVar = new r(uVar, qVar);
                    k.i("SportCalorieHandler", "Insert %d sport points to %s", Integer.valueOf(qVar.f()), uVar.f25984c);
                    this.f32833b.j(rVar);
                }
            }
        }
    }
}
