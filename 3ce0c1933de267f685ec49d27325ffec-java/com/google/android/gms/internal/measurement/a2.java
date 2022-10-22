package com.google.android.gms.internal.measurement;

import b6.i;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a2 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f9157a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z1 f9158b;

    public a2(z1 z1Var, String str) {
        this.f9158b = z1Var;
        i.k(str);
        this.f9157a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th2) {
        this.f9158b.c().K().d(this.f9157a, th2);
    }
}
