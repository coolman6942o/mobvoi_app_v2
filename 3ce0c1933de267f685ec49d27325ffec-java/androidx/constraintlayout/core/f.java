package androidx.constraintlayout.core;
/* compiled from: Pools.java */
/* loaded from: classes.dex */
class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f1552a;

    /* renamed from: b  reason: collision with root package name */
    private int f1553b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i10) {
        if (i10 > 0) {
            this.f1552a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // androidx.constraintlayout.core.e
    public boolean a(T t10) {
        int i10 = this.f1553b;
        Object[] objArr = this.f1552a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f1553b = i10 + 1;
        return true;
    }

    @Override // androidx.constraintlayout.core.e
    public T b() {
        int i10 = this.f1553b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f1552a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f1553b = i10 - 1;
        return t10;
    }

    @Override // androidx.constraintlayout.core.e
    public void c(T[] tArr, int i10) {
        if (i10 > tArr.length) {
            i10 = tArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            T t10 = tArr[i11];
            int i12 = this.f1553b;
            Object[] objArr = this.f1552a;
            if (i12 < objArr.length) {
                objArr[i12] = t10;
                this.f1553b = i12 + 1;
            }
        }
    }
}
