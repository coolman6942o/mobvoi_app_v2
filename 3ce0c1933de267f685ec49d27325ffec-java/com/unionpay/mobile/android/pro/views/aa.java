package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f23915a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.f23915a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        b bVar;
        JSONObject jSONObject = (JSONObject) view.getTag();
        String a10 = j.a(jSONObject, "errMsg");
        if (a10 == null || TextUtils.isEmpty(a10)) {
            String a11 = j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION);
            String a12 = j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE);
            bVar = ((com.unionpay.mobile.android.nocard.views.b) this.f23915a).f23639a;
            String str = bVar.br ? "10" : "2";
            y yVar = this.f23915a;
            y.a(yVar, a11, a12 + ",\"carrier_tp\":" + str);
            return;
        }
        this.f23915a.a(a10);
    }
}
