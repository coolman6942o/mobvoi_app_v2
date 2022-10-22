package gf;

import com.alibaba.fastjson.JSON;
import com.mobvoi.fitness.core.data.bt.a;
import com.mobvoi.wear.common.base.WearPath;
import hf.i;
import hf.o;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BtDeleteClient.java */
/* loaded from: classes2.dex */
public abstract class b extends a implements i {

    /* renamed from: e  reason: collision with root package name */
    private o<List<String>> f27443e;

    /* renamed from: f  reason: collision with root package name */
    private String f27444f;

    public b() {
        super(WearPath.Sports.SPORTS_DELETE);
    }

    @Override // hf.i
    public void b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            com.mobvoi.fitness.core.data.bt.b bVar = new com.mobvoi.fitness.core.data.bt.b();
            bVar.accountId = this.f27444f;
            bVar.f17901id = str;
            arrayList.add(bVar);
        }
        j(a.a(arrayList));
    }

    @Override // hf.i
    public void g(o<List<String>> oVar) {
        this.f27443e = oVar;
    }

    @Override // gf.a
    protected void i(String str, Throwable th2) {
        if (this.f27443e != null) {
            this.f27443e.a(str == null ? null : JSON.parseArray(str, String.class), th2);
        }
    }

    public void m(String str) {
        this.f27444f = str;
    }
}
