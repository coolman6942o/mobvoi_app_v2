package nf;
/* compiled from: BehaviorObservable.java */
/* loaded from: classes2.dex */
public class c<T> extends h<T> {

    /* renamed from: c  reason: collision with root package name */
    private T f31230c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31231d = false;

    @Override // nf.h
    public void a(k<T> kVar) {
        boolean z10;
        T t10;
        super.a(kVar);
        if (kVar != null) {
            synchronized (this) {
                z10 = this.f31231d;
                t10 = this.f31230c;
            }
            if (z10) {
                kVar.i(this, t10);
            }
        }
    }

    @Override // nf.h
    public void f(T t10) {
        synchronized (this) {
            this.f31231d = true;
            this.f31230c = t10;
        }
        g();
        super.f(t10);
    }
}
