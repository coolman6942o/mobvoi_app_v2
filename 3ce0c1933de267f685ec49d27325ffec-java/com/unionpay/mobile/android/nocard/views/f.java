package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JSONObject f23690a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f23691b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, JSONObject jSONObject) {
        this.f23691b = bVar;
        this.f23690a = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23691b.i();
        b bVar = this.f23691b;
        bVar.b(bVar.f23639a.aL, this.f23690a);
    }
}
