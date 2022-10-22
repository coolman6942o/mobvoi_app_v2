package com.google.firebase.crash;

import com.google.android.gms.internal.measurement.m7;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class d implements Callable<m7> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f12446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f12446a = cVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ m7 call() throws Exception {
        return this.f12446a.c();
    }
}
