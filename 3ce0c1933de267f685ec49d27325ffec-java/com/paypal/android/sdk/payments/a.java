package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.l3;
import com.paypal.android.sdk.p3;
import com.unionpay.tsmservice.data.Constant;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private h1 f21655a;

    /* renamed from: b  reason: collision with root package name */
    private Object f21656b;

    /* renamed from: c  reason: collision with root package name */
    private e1 f21657c;

    private void f(e1 e1Var) {
        e1Var.a(this.f21656b);
        Object obj = this.f21656b;
        boolean z10 = !(obj instanceof l3) && !(obj instanceof p3);
        this.f21656b = null;
        if (z10) {
            this.f21657c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.f21656b == null) {
            this.f21656b = Constant.CASH_LOAD_SUCCESS;
        }
        e1 e1Var = this.f21657c;
        if (e1Var != null) {
            f(e1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(e1 e1Var) {
        if (this.f21656b != null) {
            f(e1Var);
            return;
        }
        h1 h1Var = this.f21655a;
        if (h1Var != null) {
            e1Var.a(h1Var);
            this.f21655a = null;
            this.f21657c = null;
            return;
        }
        this.f21657c = e1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(h1 h1Var) {
        e1 e1Var = this.f21657c;
        if (e1Var != null) {
            e1Var.a(h1Var);
        } else {
            this.f21655a = h1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(Object obj) {
        this.f21656b = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.f21657c = null;
    }
}
