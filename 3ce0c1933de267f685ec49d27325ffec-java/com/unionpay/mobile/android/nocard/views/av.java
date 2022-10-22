package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class av implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f23634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.f23634a = atVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String a10 = j.a(jSONObject, "errMsg");
        if (a10 == null || TextUtils.isEmpty(a10)) {
            at.a(this.f23634a, j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION), j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE));
            return;
        }
        this.f23634a.a(a10);
    }
}
