package j0;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f29368c = new Object();

    public g(int i10) {
        super(i10);
    }

    @Override // j0.f, j0.e
    public boolean a(T t10) {
        boolean a10;
        synchronized (this.f29368c) {
            a10 = super.a(t10);
        }
        return a10;
    }

    @Override // j0.f, j0.e
    public T b() {
        T t10;
        synchronized (this.f29368c) {
            t10 = (T) super.b();
        }
        return t10;
    }
}
