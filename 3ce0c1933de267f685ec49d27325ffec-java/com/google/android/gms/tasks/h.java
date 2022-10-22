package com.google.android.gms.tasks;

import b7.a;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
final class h<TResult> implements p<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10159a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10160b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private a f10161c;

    public h(Executor executor, a aVar) {
        this.f10159a = executor;
        this.f10161c = aVar;
    }

    @Override // com.google.android.gms.tasks.p
    public final void a(b bVar) {
        if (bVar.m()) {
            synchronized (this.f10160b) {
                if (this.f10161c != null) {
                    this.f10159a.execute(new i(this));
                }
            }
        }
    }
}
