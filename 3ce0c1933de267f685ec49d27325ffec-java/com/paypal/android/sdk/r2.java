package com.paypal.android.sdk;
/* loaded from: classes2.dex */
public final class r2 implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private q2 f21886a;

    public r2(q2 q2Var) {
        this.f21886a = q2Var;
    }

    @Override // com.paypal.android.sdk.v0
    public final void a(r1 r1Var) {
        if (r1Var instanceof w3) {
            if (r1Var.y()) {
                this.f21886a.a((w3) r1Var);
            } else {
                this.f21886a.s((w3) r1Var);
            }
        } else if (r1Var instanceof r3) {
            if (r1Var.y()) {
                this.f21886a.l((r3) r1Var);
            } else {
                this.f21886a.i((r3) r1Var);
            }
        } else if (r1Var instanceof m3) {
            if (r1Var.y()) {
                this.f21886a.d((m3) r1Var);
            } else {
                this.f21886a.c((m3) r1Var);
            }
        } else if (r1Var instanceof x3) {
            if (r1Var.y()) {
                this.f21886a.r((x3) r1Var);
            } else {
                this.f21886a.p((x3) r1Var);
            }
        } else if (r1Var instanceof n3) {
            if (r1Var.y()) {
                this.f21886a.a();
            } else {
                this.f21886a.b((n3) r1Var);
            }
        } else if (r1Var instanceof k3) {
            if (r1Var.y()) {
                this.f21886a.h((k3) r1Var);
            } else {
                this.f21886a.f((k3) r1Var);
            }
        } else if (r1Var instanceof l3) {
            if (r1Var.y()) {
                this.f21886a.g((l3) r1Var);
            } else {
                this.f21886a.e((l3) r1Var);
            }
        } else if (r1Var instanceof i3) {
            if (r1Var.y()) {
                this.f21886a.m((i3) r1Var);
            } else {
                this.f21886a.j((i3) r1Var);
            }
        } else if (r1Var instanceof p3) {
            if (r1Var.y()) {
                this.f21886a.q((p3) r1Var);
            } else {
                this.f21886a.n((p3) r1Var);
            }
        } else if (!(r1Var instanceof q3)) {
            throw new RuntimeException("not handled");
        } else if (r1Var.y()) {
            this.f21886a.o((q3) r1Var);
        } else {
            this.f21886a.k((q3) r1Var);
        }
    }
}
