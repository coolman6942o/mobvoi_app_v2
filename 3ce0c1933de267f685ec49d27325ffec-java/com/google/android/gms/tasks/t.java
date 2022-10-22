package com.google.android.gms.tasks;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ s f10187a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Callable f10188b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, Callable callable) {
        this.f10187a = sVar;
        this.f10188b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10187a.q(this.f10188b.call());
        } catch (Exception e10) {
            this.f10187a.p(e10);
        }
    }
}
