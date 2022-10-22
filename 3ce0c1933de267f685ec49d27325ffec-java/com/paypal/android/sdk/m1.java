package com.paypal.android.sdk;

import java.io.IOException;
import okhttp3.b0;
import okhttp3.e;
import okhttp3.f;
/* loaded from: classes2.dex */
final class m1 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final r1 f21455a;

    private m1(h1 h1Var, r1 r1Var) {
        this.f21455a = r1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m1(h1 h1Var, r1 r1Var, byte b10) {
        this(h1Var, r1Var);
    }

    @Override // okhttp3.f
    public final void onFailure(e eVar, IOException iOException) {
        String unused;
        this.f21455a.i(iOException.getMessage());
        unused = h1.f21323i;
        this.f21455a.v();
        iOException.getMessage();
    }

    @Override // okhttp3.f
    public final void onResponse(e eVar, b0 b0Var) {
        String unused;
        this.f21455a.i(b0Var.c().string());
        unused = h1.f21323i;
        this.f21455a.v();
    }
}
