package com.google.android.gms.tasks;

import b7.b;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class j<TResult> implements p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10163a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10164b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private b<TResult> f10165c;

    public j(Executor executor, b<TResult> bVar) {
        this.f10163a = executor;
        this.f10165c = bVar;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a(b<TResult> bVar) {
        synchronized (this.f10164b) {
            if (this.f10165c != null) {
                this.f10163a.execute(new k(this, bVar));
            }
        }
    }
}
