package com.paypal.android.sdk;

import android.text.TextUtils;
/* loaded from: classes2.dex */
final class g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ r1 f21309a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ f1 f21310b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(f1 f1Var, r1 r1Var) {
        this.f21310b = f1Var;
        this.f21309a = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s1 s1Var;
        int i10;
        String unused;
        String unused2;
        int unused3;
        String unused4;
        int unused5;
        unused = f1.f21222d;
        this.f21309a.v();
        this.f21309a.n();
        if (this.f21310b.h(this.f21309a)) {
            String f10 = this.f21310b.f();
            this.f21309a.p().a();
            this.f21309a.i(f10);
            d1.c(this.f21309a, this.f21310b.g());
        } else {
            String m10 = this.f21309a.m();
            if (!TextUtils.isEmpty(m10)) {
                this.f21309a.p().a();
                this.f21309a.i(m10);
                d1.b(this.f21309a);
            } else {
                throw new RuntimeException("Empty mock value for " + this.f21309a.p());
            }
        }
        if (!this.f21309a.g()) {
            try {
                unused2 = f1.f21222d;
                unused3 = this.f21310b.f21225c;
                i10 = this.f21310b.f21225c;
                Thread.sleep(i10);
                unused4 = f1.f21222d;
                unused5 = this.f21310b.f21225c;
            } catch (InterruptedException unused6) {
                this.f21309a.p().a();
            }
            s1Var = this.f21310b.f21223a;
            s1Var.a(this.f21309a);
        }
    }
}
