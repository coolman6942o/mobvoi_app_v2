package com.paypal.android.sdk;

import java.io.IOException;
import okhttp3.y;
/* loaded from: classes2.dex */
final class i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ r1 f21348a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f21349b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ h1 f21350c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i1(h1 h1Var, r1 r1Var, String str) {
        this.f21350c = h1Var;
        this.f21348a = r1Var;
        this.f21349b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar;
        try {
            h1 h1Var = this.f21350c;
            r1 r1Var = this.f21348a;
            String str = this.f21349b;
            yVar = h1Var.f21329e;
            h1Var.h(r1Var, str, yVar, new m1(this.f21350c, this.f21348a, (byte) 0));
        } catch (IOException unused) {
        }
    }
}
