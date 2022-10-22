package io.reactivex.internal.operators.flowable;

import bo.b;
import io.reactivex.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractFlowableWithUpstream.java */
/* loaded from: classes2.dex */
public abstract class a<T, R> extends e<R> {

    /* renamed from: b  reason: collision with root package name */
    protected final e<T> f28379b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e<T> eVar) {
        this.f28379b = (e) b.e(eVar, "source is null");
    }
}
