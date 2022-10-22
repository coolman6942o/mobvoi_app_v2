package com.google.android.gms.tasks;

import b7.c;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class l<TResult> implements p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10168a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10169b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private c f10170c;

    public l(Executor executor, c cVar) {
        this.f10168a = executor;
        this.f10170c = cVar;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a(b<TResult> bVar) {
        if (!bVar.o() && !bVar.m()) {
            synchronized (this.f10169b) {
                if (this.f10170c != null) {
                    this.f10168a.execute(new m(this, bVar));
                }
            }
        }
    }
}
