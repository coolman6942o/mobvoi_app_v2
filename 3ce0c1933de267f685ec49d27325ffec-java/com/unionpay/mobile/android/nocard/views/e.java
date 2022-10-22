package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JSONObject f23688a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f23689b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, JSONObject jSONObject) {
        this.f23689b = bVar;
        this.f23688a = jSONObject;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23689b.i();
        b bVar = this.f23689b;
        bVar.b(bVar.f23639a.aJ, this.f23688a);
    }
}
