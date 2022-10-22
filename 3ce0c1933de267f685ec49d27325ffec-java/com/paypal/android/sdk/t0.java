package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    private final List f21973a = new ArrayList();

    public final void a() {
        synchronized (this.f21973a) {
            for (u0 u0Var : this.f21973a) {
                this.f21973a.remove(u0Var);
            }
        }
    }

    public final void b(v0 v0Var) {
        synchronized (this.f21973a) {
            for (u0 u0Var : this.f21973a) {
                if (u0Var.f22007a == v0Var) {
                    Objects.toString(v0Var);
                    return;
                }
            }
            this.f21973a.add(new u0(this, v0Var));
        }
    }

    public final void c(r1 r1Var, long j10) {
        r1Var.v();
        if (r1Var.w() < 0) {
            r1Var.v();
            return;
        }
        ArrayList<u0> arrayList = new ArrayList();
        synchronized (this.f21973a) {
            for (u0 u0Var : this.f21973a) {
                arrayList.add(0, u0Var);
            }
        }
        for (u0 u0Var2 : arrayList) {
            u0Var2.f22007a.a(r1Var);
        }
    }
}
