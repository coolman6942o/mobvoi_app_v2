package com.google.android.gms.tasks;

import b7.d;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class n<TResult> implements p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10173a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10174b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private d<? super TResult> f10175c;

    public n(Executor executor, d<? super TResult> dVar) {
        this.f10173a = executor;
        this.f10175c = dVar;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a(b<TResult> bVar) {
        if (bVar.o()) {
            synchronized (this.f10174b) {
                if (this.f10175c != null) {
                    this.f10173a.execute(new o(this, bVar));
                }
            }
        }
    }
}
