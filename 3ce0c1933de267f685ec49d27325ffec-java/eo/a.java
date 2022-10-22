package eo;

import io.reactivex.internal.util.e;
import io.reactivex.r;
import xn.b;
/* compiled from: DefaultObserver.java */
/* loaded from: classes3.dex */
public abstract class a<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    private b f26228a;

    protected void a() {
    }

    @Override // io.reactivex.r
    public final void onSubscribe(b bVar) {
        if (e.d(this.f26228a, bVar, getClass())) {
            this.f26228a = bVar;
            a();
        }
    }
}
