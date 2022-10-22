package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReversedViews.kt */
/* loaded from: classes3.dex */
public final class f0<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<T> f30057a;

    public f0(List<T> delegate) {
        i.f(delegate, "delegate");
        this.f30057a = delegate;
    }

    @Override // kotlin.collections.c
    public int a() {
        return this.f30057a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        int A;
        List<T> list = this.f30057a;
        A = s.A(this, i10);
        list.add(A, t10);
    }

    @Override // kotlin.collections.c
    public T b(int i10) {
        int z10;
        List<T> list = this.f30057a;
        z10 = s.z(this, i10);
        return list.remove(z10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f30057a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        int z10;
        List<T> list = this.f30057a;
        z10 = s.z(this, i10);
        return list.get(z10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        int z10;
        List<T> list = this.f30057a;
        z10 = s.z(this, i10);
        return list.set(z10, t10);
    }
}
