package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class f<TResult, TContinuationResult> implements p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10154a;

    /* renamed from: b  reason: collision with root package name */
    private final a<TResult, TContinuationResult> f10155b;

    /* renamed from: c  reason: collision with root package name */
    private final s<TContinuationResult> f10156c;

    public f(Executor executor, a<TResult, TContinuationResult> aVar, s<TContinuationResult> sVar) {
        this.f10154a = executor;
        this.f10155b = aVar;
        this.f10156c = sVar;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a(b<TResult> bVar) {
        this.f10154a.execute(new g(this, bVar));
    }
}
