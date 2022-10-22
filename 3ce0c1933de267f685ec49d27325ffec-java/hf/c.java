package hf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xe.b;
import zf.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientDeleter.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f27822a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<i, o<List<String>>> f27823b = new HashMap(2);

    /* renamed from: c  reason: collision with root package name */
    private k f27824c;

    public c(b bVar) {
        this.f27822a = bVar;
    }

    private boolean c(String str) {
        for (i iVar : this.f27823b.keySet()) {
            if (!f(iVar.a(), str)) {
                return false;
            }
        }
        return true;
    }

    private void d(String str) {
        this.f27822a.c(str);
    }

    private boolean f(String str, String str2) {
        return this.f27822a.k(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(i iVar, List list, Throwable th2) {
        k kVar;
        if (list != null) {
            k(iVar.a(), list);
        } else if (th2 != null && (kVar = this.f27824c) != null) {
            kVar.a(th2);
        }
    }

    private void h(String str) {
        this.f27822a.d(str);
        this.f27822a.f(str);
    }

    private void i(String str, String str2, boolean z10) {
        this.f27822a.p(str, str2, z10);
    }

    private boolean j(String str) {
        for (i iVar : this.f27823b.keySet()) {
            if (f(iVar.a(), str)) {
                return false;
            }
        }
        return true;
    }

    private void k(String str, List<String> list) {
        this.f27822a.n();
        for (String str2 : list) {
            i(str, str2, true);
            if (c(str2)) {
                d(str2);
            }
        }
        this.f27822a.endBatchEdit();
    }

    private boolean n(List<String> list) {
        boolean z10 = true;
        for (i iVar : this.f27823b.keySet()) {
            String a10 = iVar.a();
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (!f(a10, str)) {
                    arrayList.add(str);
                }
            }
            if (!iVar.isConnected()) {
                z10 = false;
            } else if (!arrayList.isEmpty()) {
                iVar.b(arrayList);
            }
        }
        return z10;
    }

    public void b(final i iVar) {
        if (iVar != null && !this.f27823b.keySet().contains(iVar)) {
            o<List<String>> bVar = new o() { // from class: hf.b
                @Override // hf.o
                public final void a(Object obj, Throwable th2) {
                    c.this.g(iVar, (List) obj, th2);
                }
            };
            iVar.g(bVar);
            this.f27823b.put(iVar, bVar);
        }
    }

    public void e(List<String> list) {
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            this.f27822a.n();
            for (String str : list) {
                if (j(str)) {
                    d(str);
                } else {
                    arrayList.add(str);
                    h(str);
                    for (i iVar : this.f27823b.keySet()) {
                        String a10 = iVar.a();
                        i(a10, str, !f(a10, str));
                    }
                }
            }
            this.f27822a.endBatchEdit();
            n(arrayList);
        }
    }

    public void l(k kVar) {
        this.f27824c = kVar;
    }

    public boolean m() {
        List<String> o10 = this.f27822a.o();
        return o10.isEmpty() || n(o10);
    }
}
