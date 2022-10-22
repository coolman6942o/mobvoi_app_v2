package rx.internal.operators;

import rx.c;
import rx.i;
/* compiled from: OnSubscribeThrow.java */
/* loaded from: classes3.dex */
public final class r<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f33902a;

    public r(Throwable th2) {
        this.f33902a = th2;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        iVar.onError(this.f33902a);
    }
}
