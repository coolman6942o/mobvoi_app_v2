package b8;

import e8.a;
/* loaded from: classes.dex */
final class o<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f5096c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f5097a = f5096c;

    /* renamed from: b  reason: collision with root package name */
    private volatile a<T> f5098b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(final d<T> dVar, final c cVar) {
        this.f5098b = new a(dVar, cVar) { // from class: b8.p

            /* renamed from: a  reason: collision with root package name */
            private final d f5099a;

            /* renamed from: b  reason: collision with root package name */
            private final c f5100b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5099a = dVar;
                this.f5100b = cVar;
            }

            @Override // e8.a
            public final Object get() {
                Object a10;
                a10 = this.f5099a.a(this.f5100b);
                return a10;
            }
        };
    }

    @Override // e8.a
    public final T get() {
        T t10 = (T) this.f5097a;
        Object obj = f5096c;
        if (t10 == obj) {
            synchronized (this) {
                t10 = this.f5097a;
                if (t10 == obj) {
                    t10 = this.f5098b.get();
                    this.f5097a = t10;
                    this.f5098b = null;
                }
            }
        }
        return t10;
    }
}
