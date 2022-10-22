package kotlinx.coroutines;

import io.m;
import qo.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class i1 extends o1 {

    /* renamed from: e  reason: collision with root package name */
    private final l<Throwable, m> f30191e;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(l<? super Throwable, m> lVar) {
        this.f30191e = lVar;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        w(th2);
        return m.f28349a;
    }

    @Override // kotlinx.coroutines.c0
    public void w(Throwable th2) {
        this.f30191e.invoke(th2);
    }
}
