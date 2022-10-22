package com.unionpay.mobile.android.widgets;

import android.text.TextUtils;
import android.view.View;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.languages.c;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f24412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f24412a = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f A[LOOP:0: B:17:0x0079->B:19:0x007f, LOOP_END] */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onClick(View view) {
        boolean z10;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        String format;
        String str;
        z10 = this.f24412a.f24408r;
        if (z10) {
            JSONObject jSONObject = new JSONObject();
            try {
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (TextUtils.isEmpty(this.f24412a.a())) {
                c cVar = c.bD;
                format = String.format(cVar.aC, cVar.C);
            } else if (this.f24412a.a().matches("[A-Za-z0-9]{8,32}")) {
                this.f24412a.a(true);
                jSONObject.put(HealthDataProviderContracts.NAME_VALUE, this.f24412a.h());
                str = this.f24412a.f24410t;
                jSONObject.put(TelephonyUtil.KEY_SIM_ACTION, str);
                view.setTag(jSONObject);
                arrayList2 = this.f24412a.f24405o;
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                return;
            } else {
                c cVar2 = c.bD;
                format = String.format(cVar2.aD, cVar2.C);
            }
            jSONObject.put("errMsg", format);
            view.setTag(jSONObject);
            arrayList2 = this.f24412a.f24405o;
            it = arrayList2.iterator();
            while (it.hasNext()) {
            }
            return;
        }
        ((aa) this.f24412a).f24277b.e();
        this.f24412a.a(false);
        arrayList = this.f24412a.f24406p;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((View.OnClickListener) it2.next()).onClick(view);
        }
    }
}
