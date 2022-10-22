package yp;
/* compiled from: Functions.java */
/* loaded from: classes3.dex */
public final class k {

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static class a implements j<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f37151a;

        a(h hVar) {
            this.f37151a = hVar;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [R, java.lang.Object] */
        @Override // yp.j
        public R call(Object... objArr) {
            if (objArr.length == 2) {
                return this.f37151a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Func2 expecting 2 arguments.");
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes3.dex */
    static class b implements j<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f37152a;

        b(i iVar) {
            this.f37152a = iVar;
        }

        /* JADX WARN: Type inference failed for: r6v3, types: [R, java.lang.Object] */
        @Override // yp.j
        public R call(Object... objArr) {
            if (objArr.length == 4) {
                return this.f37152a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Func4 expecting 4 arguments.");
        }
    }

    public static <T0, T1, R> j<R> a(h<? super T0, ? super T1, ? extends R> hVar) {
        return new a(hVar);
    }

    public static <T0, T1, T2, T3, R> j<R> b(i<? super T0, ? super T1, ? super T2, ? super T3, ? extends R> iVar) {
        return new b(iVar);
    }
}
