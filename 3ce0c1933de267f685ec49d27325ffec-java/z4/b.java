package z4;

import n5.j;
import t4.c;
/* compiled from: SimpleResource.java */
/* loaded from: classes.dex */
public class b<T> implements c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f37283a;

    public b(T t10) {
        this.f37283a = (T) j.d(t10);
    }

    @Override // t4.c
    public void b() {
    }

    @Override // t4.c
    public final int c() {
        return 1;
    }

    @Override // t4.c
    public Class<T> d() {
        return (Class<T>) this.f37283a.getClass();
    }

    @Override // t4.c
    public final T get() {
        return this.f37283a;
    }
}
