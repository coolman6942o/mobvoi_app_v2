package j0;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f29366a;

    /* renamed from: b  reason: collision with root package name */
    private int f29367b;

    public f(int i10) {
        if (i10 > 0) {
            this.f29366a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t10) {
        for (int i10 = 0; i10 < this.f29367b; i10++) {
            if (this.f29366a[i10] == t10) {
                return true;
            }
        }
        return false;
    }

    @Override // j0.e
    public boolean a(T t10) {
        if (!c(t10)) {
            int i10 = this.f29367b;
            Object[] objArr = this.f29366a;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t10;
            this.f29367b = i10 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // j0.e
    public T b() {
        int i10 = this.f29367b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f29366a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f29367b = i10 - 1;
        return t10;
    }
}
