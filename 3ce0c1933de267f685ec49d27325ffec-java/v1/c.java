package v1;

import java.util.ArrayList;
import java.util.List;
import w1.d;
import y1.p;
/* compiled from: ConstraintController.java */
/* loaded from: classes.dex */
public abstract class c<T> implements u1.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f35570a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private T f35571b;

    /* renamed from: c  reason: collision with root package name */
    private d<T> f35572c;

    /* renamed from: d  reason: collision with root package name */
    private a f35573d;

    /* compiled from: ConstraintController.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(List<String> list);

        void b(List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d<T> dVar) {
        this.f35572c = dVar;
    }

    private void h(a aVar, T t10) {
        if (!this.f35570a.isEmpty() && aVar != null) {
            if (t10 == null || c(t10)) {
                aVar.b(this.f35570a);
            } else {
                aVar.a(this.f35570a);
            }
        }
    }

    @Override // u1.a
    public void a(T t10) {
        this.f35571b = t10;
        h(this.f35573d, t10);
    }

    abstract boolean b(p pVar);

    abstract boolean c(T t10);

    public boolean d(String str) {
        T t10 = this.f35571b;
        return t10 != null && c(t10) && this.f35570a.contains(str);
    }

    public void e(Iterable<p> iterable) {
        this.f35570a.clear();
        for (p pVar : iterable) {
            if (b(pVar)) {
                this.f35570a.add(pVar.f36689a);
            }
        }
        if (this.f35570a.isEmpty()) {
            this.f35572c.c(this);
        } else {
            this.f35572c.a(this);
        }
        h(this.f35573d, this.f35571b);
    }

    public void f() {
        if (!this.f35570a.isEmpty()) {
            this.f35570a.clear();
            this.f35572c.c(this);
        }
    }

    public void g(a aVar) {
        if (this.f35573d != aVar) {
            this.f35573d = aVar;
            h(aVar, this.f35571b);
        }
    }
}
