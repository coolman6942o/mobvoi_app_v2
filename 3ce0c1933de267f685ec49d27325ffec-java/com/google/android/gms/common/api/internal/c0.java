package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b0 f8541a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(b0 b0Var) {
        this.f8541a = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        Context context;
        cVar = this.f8541a.f8519d;
        context = this.f8541a.f8518c;
        cVar.a(context);
    }
}
