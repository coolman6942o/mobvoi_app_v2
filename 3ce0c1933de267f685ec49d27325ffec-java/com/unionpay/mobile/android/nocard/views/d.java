package com.unionpay.mobile.android.nocard.views;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f23686a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f23687b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, boolean z10) {
        this.f23687b = bVar;
        this.f23686a = z10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23687b.i();
        if (this.f23686a) {
            this.f23687b.j();
        }
    }
}
