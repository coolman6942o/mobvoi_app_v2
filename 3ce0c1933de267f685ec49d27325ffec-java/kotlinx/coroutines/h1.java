package kotlinx.coroutines;

import io.m;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import qo.l;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
final class h1 extends k1 {

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30189f = AtomicIntegerFieldUpdater.newUpdater(h1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e  reason: collision with root package name */
    private final l<Throwable, m> f30190e;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(l<? super Throwable, m> lVar) {
        this.f30190e = lVar;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        w(th2);
        return m.f28349a;
    }

    @Override // kotlinx.coroutines.c0
    public void w(Throwable th2) {
        if (f30189f.compareAndSet(this, 0, 1)) {
            this.f30190e.invoke(th2);
        }
    }
}
