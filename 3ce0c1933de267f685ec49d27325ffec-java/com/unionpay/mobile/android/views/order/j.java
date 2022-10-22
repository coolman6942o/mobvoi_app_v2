package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f24225a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f24225a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        i iVar = this.f24225a;
        AbstractMethod.b bVar = iVar.f24173e;
        if (bVar != null) {
            jSONObject = iVar.f24219g;
            String a10 = AbstractMethod.a(jSONObject, "label");
            jSONObject2 = this.f24225a.f24219g;
            bVar.a(a10, AbstractMethod.a(jSONObject2, "href"));
        }
    }
}
