package com.unionpay.mobile.android.nocard.views;

import android.text.TextUtils;
import android.view.View;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f23737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f23737a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JSONObject jSONObject = (JSONObject) view.getTag();
        String a10 = j.a(jSONObject, "errMsg");
        if (a10 == null || TextUtils.isEmpty(a10)) {
            o.a(this.f23737a, j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION), j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE));
            return;
        }
        this.f23737a.a(a10);
    }
}
