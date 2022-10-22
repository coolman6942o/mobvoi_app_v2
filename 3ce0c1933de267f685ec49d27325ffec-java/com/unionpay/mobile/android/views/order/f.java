package com.unionpay.mobile.android.views.order;

import android.view.View;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f24215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f24215a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        b bVar = this.f24215a;
        AbstractMethod.b bVar2 = bVar.f24173e;
        if (bVar2 != null) {
            jSONObject = bVar.f24189g;
            String a10 = AbstractMethod.a(jSONObject, "title");
            jSONObject2 = this.f24215a.f24189g;
            bVar2.a(a10, AbstractMethod.a(jSONObject2, "href"));
        }
    }
}
