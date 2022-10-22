package rx.subjects;

import java.util.ArrayList;
import rx.c;
import rx.internal.operators.d;
import rx.subjects.e;
import yp.b;
/* compiled from: BehaviorSubject.java */
/* loaded from: classes3.dex */
public final class a<T> extends d<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f34183c = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    private final e<T> f34184b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorSubject.java */
    /* renamed from: rx.subjects.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0487a implements b<e.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f34185a;

        C0487a(e eVar) {
            this.f34185a = eVar;
        }

        /* renamed from: a */
        public void call(e.c<T> cVar) {
            cVar.c(this.f34185a.d());
        }
    }

    protected a(c.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f34184b = eVar;
    }

    public static <T> a<T> o0() {
        return p0(null, false);
    }

    private static <T> a<T> p0(T t10, boolean z10) {
        e eVar = new e();
        if (z10) {
            eVar.j(d.g(t10));
        }
        C0487a aVar = new C0487a(eVar);
        eVar.onAdded = aVar;
        eVar.onTerminated = aVar;
        return new a<>(eVar, eVar);
    }

    @Override // rx.subjects.d
    public boolean m0() {
        return this.f34184b.h().length > 0;
    }

    @Override // rx.d
    public void onCompleted() {
        if (this.f34184b.d() == null || this.f34184b.active) {
            Object b10 = d.b();
            for (e.c<T> cVar : this.f34184b.k(b10)) {
                cVar.e(b10);
            }
        }
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        if (this.f34184b.d() == null || this.f34184b.active) {
            Object c10 = d.c(th2);
            ArrayList arrayList = null;
            for (e.c<T> cVar : this.f34184b.k(c10)) {
                try {
                    cVar.e(c10);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th3);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.d
    public void onNext(T t10) {
        if (this.f34184b.d() == null || this.f34184b.active) {
            Object g10 = d.g(t10);
            for (e.c<T> cVar : this.f34184b.g(g10)) {
                cVar.e(g10);
            }
        }
    }
}
