package androidx.lifecycle;

import java.util.Iterator;
import java.util.Map;
import l.b;
/* compiled from: MediatorLiveData.java */
/* loaded from: classes.dex */
public class u<T> extends w<T> {

    /* renamed from: l  reason: collision with root package name */
    private b<LiveData<?>, a<?>> f3337l = new b<>();

    /* compiled from: MediatorLiveData.java */
    /* loaded from: classes.dex */
    private static class a<V> implements x<V> {

        /* renamed from: a  reason: collision with root package name */
        final LiveData<V> f3338a;

        /* renamed from: b  reason: collision with root package name */
        final x<? super V> f3339b;

        /* renamed from: c  reason: collision with root package name */
        int f3340c = -1;

        a(LiveData<V> liveData, x<? super V> xVar) {
            this.f3338a = liveData;
            this.f3339b = xVar;
        }

        @Override // androidx.lifecycle.x
        public void a(V v10) {
            if (this.f3340c != this.f3338a.g()) {
                this.f3340c = this.f3338a.g();
                this.f3339b.a(v10);
            }
        }

        void b() {
            this.f3338a.j(this);
        }

        void c() {
            this.f3338a.n(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void k() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f3337l.iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void l() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.f3337l.iterator();
        while (it.hasNext()) {
            it.next().getValue().c();
        }
    }

    public <S> void p(LiveData<S> liveData, x<? super S> xVar) {
        a<?> aVar = new a<>(liveData, xVar);
        a<?> f10 = this.f3337l.f(liveData, aVar);
        if (f10 != null && f10.f3339b != xVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (f10 == null && h()) {
            aVar.b();
        }
    }
}
