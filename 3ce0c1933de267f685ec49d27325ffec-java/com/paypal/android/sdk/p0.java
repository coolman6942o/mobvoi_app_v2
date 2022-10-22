package com.paypal.android.sdk;

import android.os.Message;
import java.util.Objects;
/* loaded from: classes2.dex */
public class p0 implements s1 {

    /* renamed from: a  reason: collision with root package name */
    private final a f21496a;

    /* renamed from: b  reason: collision with root package name */
    private final o0 f21497b;

    /* renamed from: c  reason: collision with root package name */
    private final t0 f21498c = new t0();

    /* renamed from: d  reason: collision with root package name */
    private final q0 f21499d = new q0(this);

    /* renamed from: e  reason: collision with root package name */
    private n1 f21500e;

    public p0(a aVar, o0 o0Var, z zVar) {
        this.f21496a = aVar;
        this.f21497b = o0Var;
    }

    @Override // com.paypal.android.sdk.s1
    public final void a(r1 r1Var) {
        r1Var.t();
        t.c().t();
        if (!r1Var.g()) {
            Message message = new Message();
            message.what = 2;
            message.obj = r1Var;
            this.f21499d.sendMessage(message);
        }
    }

    @Override // com.paypal.android.sdk.s1
    public final String b(p1 p1Var) {
        Objects.toString(this.f21497b);
        Objects.toString(this.f21497b.c());
        o0 o0Var = this.f21497b;
        if (o0Var == null || o0Var.c() == null) {
            return null;
        }
        return (String) this.f21497b.c().get(p1Var.a());
    }

    @Override // com.paypal.android.sdk.s1
    public final String c() {
        return this.f21497b.a();
    }

    @Override // com.paypal.android.sdk.s1
    public final a d() {
        return this.f21496a;
    }

    @Override // com.paypal.android.sdk.s1
    public final String e() {
        return this.f21497b.b();
    }

    public final void f() {
        this.f21500e.a();
    }

    public final void h(v0 v0Var) {
        this.f21498c.b(v0Var);
    }

    public final void i(n1 n1Var) {
        if (this.f21500e == null) {
            this.f21500e = n1Var;
            return;
        }
        throw new IllegalStateException();
    }

    public final void j() {
        this.f21498c.a();
    }

    public final void k(r1 r1Var) {
        this.f21500e.b(r1Var);
    }
}
