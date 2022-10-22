package androidx.lifecycle;
/* compiled from: Transformations.java */
/* loaded from: classes.dex */
public class e0 {

    /* compiled from: Transformations.java */
    /* loaded from: classes.dex */
    class a implements x<X> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f3309a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m.a f3310b;

        a(u uVar, m.a aVar) {
            this.f3309a = uVar;
            this.f3310b = aVar;
        }

        @Override // androidx.lifecycle.x
        public void a(X x10) {
            this.f3309a.o(this.f3310b.apply(x10));
        }
    }

    public static <X, Y> LiveData<Y> a(LiveData<X> liveData, m.a<X, Y> aVar) {
        u uVar = new u();
        uVar.p(liveData, new a(uVar, aVar));
        return uVar;
    }
}
