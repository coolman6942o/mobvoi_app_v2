package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class n implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f24464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(UPPayWapActivity uPPayWapActivity) {
        this.f24464a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        String b11;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                UPUtils.a(this.f24464a, jSONObject.getString(next), next);
            }
            if (zVar != null) {
                b11 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, null);
                zVar.a(b11);
            }
        } catch (Exception e10) {
            if (zVar != null) {
                b10 = UPPayWapActivity.b("1", e10.getMessage(), null);
                zVar.a(b10);
            }
        }
    }
}
