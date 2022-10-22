package yp;
/* compiled from: Actions.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37149a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Actions.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements yp.b<T> {

        /* renamed from: a  reason: collision with root package name */
        final yp.a f37150a;

        public a(yp.a aVar) {
            this.f37150a = aVar;
        }

        @Override // yp.b
        public void call(T t10) {
            this.f37150a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Actions.java */
    /* loaded from: classes3.dex */
    public static final class b<T0, T1, T2, T3, T4, T5, T6, T7, T8> implements yp.a, yp.b<T0>, c<T0, T1> {
        b() {
        }

        @Override // yp.c
        public void a(T0 t02, T1 t12) {
        }

        @Override // yp.a
        public void call() {
        }

        @Override // yp.b
        public void call(T0 t02) {
        }
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> b<T0, T1, T2, T3, T4, T5, T6, T7, T8> a() {
        return f37149a;
    }

    public static <T> yp.b<T> b(yp.a aVar) {
        return new a(aVar);
    }
}
