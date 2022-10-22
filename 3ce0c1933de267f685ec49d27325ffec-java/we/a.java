package we;

import ef.p;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseAnalyzer.java */
/* loaded from: classes2.dex */
public abstract class a<Data> implements b<Data> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f36221a;

    @Override // we.b
    public List<Data> a(Iterable<p> iterable) {
        Data c10;
        ArrayList arrayList = new ArrayList();
        d();
        Data data = null;
        long j10 = 0;
        for (p pVar : iterable) {
            if (pVar.f25951a > 0 && (c10 = c(data, j10, pVar)) != null) {
                arrayList.add(c10);
                j10 = pVar.f25951a;
                data = c10;
            }
        }
        return arrayList;
    }

    public boolean b() {
        return this.f36221a;
    }

    protected abstract Data c(Data data, long j10, p pVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    public void e(boolean z10) {
        this.f36221a = z10;
    }
}
