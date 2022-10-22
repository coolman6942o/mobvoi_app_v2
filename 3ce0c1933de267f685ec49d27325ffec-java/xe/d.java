package xe;

import com.mobvoi.android.common.utils.k;
import ef.p;
import ef.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ye.a;
import ye.b;
import ye.c;
/* compiled from: SportPointAccessor.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final b f36529a;

    /* renamed from: b  reason: collision with root package name */
    private final c f36530b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, c cVar) {
        this.f36529a = bVar;
        this.f36530b = cVar;
    }

    private List<p> c() {
        List<a> list;
        try {
            list = this.f36530b.k(this.f36529a.n());
            if (list == null) {
            }
        } catch (Exception e10) {
            k.e("SportPointAccessor", "fitness dao loadPointsByRecord error", e10);
        } finally {
            new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (a aVar : list) {
            arrayList.add(a.d(aVar));
        }
        return arrayList;
    }

    public void a() {
        try {
            this.f36530b.j(this.f36529a.n());
        } catch (Exception e10) {
            k.e("SportPointAccessor", "fitness dao deletePointsByRecordId error", e10);
        }
    }

    public q b() {
        return new q(c());
    }

    public a d(p pVar) {
        List<a> list;
        a aVar;
        a aVar2 = null;
        try {
            list = this.f36530b.d(this.f36529a.n(), Long.valueOf(pVar.f25951a));
        } catch (Exception e10) {
            k.e("SportPointAccessor", "save loadPointsByRecordAndTime exception!", e10);
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                aVar2 = list.get(list.size() - 1);
                for (a aVar3 : list) {
                    if (aVar3 != aVar2) {
                        this.f36530b.n(aVar3);
                    }
                }
            } else {
                aVar2 = list.get(0);
            }
        }
        if (aVar2 != null) {
            aVar = a.f(aVar2, pVar);
            try {
                this.f36530b.r(aVar);
            } catch (Exception e11) {
                k.e("SportPointAccessor", "fitness dao updatePoints error", e11);
            }
        } else {
            aVar = a.g(this.f36529a, pVar);
            try {
                this.f36530b.g(aVar);
            } catch (Exception e12) {
                k.e("SportPointAccessor", "fitness dao insertPoints error", e12);
            }
        }
        return aVar;
    }

    public void e(q qVar) {
        if (qVar != null) {
            for (p pVar : qVar.e()) {
                d(pVar);
            }
            Iterator<p> it = qVar.d().iterator();
            while (it.hasNext()) {
                this.f36530b.g(a.g(this.f36529a, it.next()));
            }
        }
    }
}
