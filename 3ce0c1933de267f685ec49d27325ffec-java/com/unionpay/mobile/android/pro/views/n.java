package com.unionpay.mobile.android.pro.views;

import android.text.TextUtils;
import android.view.View;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f23953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.f23953a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String a10 = j.a(jSONObject, "errMsg");
        if (a10 == null || TextUtils.isEmpty(a10)) {
            String a11 = j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION);
            String a12 = j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE);
            k kVar = this.f23953a;
            k.a(kVar, a11, a12 + ",\"carrier_tp\":\"7\"");
            return;
        }
        this.f23953a.a(a10);
    }
}
