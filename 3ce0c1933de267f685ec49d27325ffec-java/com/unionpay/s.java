package com.unionpay;

import com.mobvoi.wear.providers.OtaColumn;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class s implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f24469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(UPPayWapActivity uPPayWapActivity) {
        this.f24469a = uPPayWapActivity;
    }

    @Override // com.unionpay.y
    public final void a(String str, z zVar) {
        String b10;
        String b11;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                jSONObject.get("url");
                jSONObject.get(OtaColumn.COLUMN_APP);
                jSONObject.get("title");
                jSONObject.get("desp");
                jSONObject.get(OtaColumn.COLUMN_MD5);
            } catch (Exception e10) {
                if (zVar != null) {
                    b11 = UPPayWapActivity.b("1", e10.getMessage(), null);
                    zVar.a(b11);
                }
            }
        } catch (Exception e11) {
            if (zVar != null) {
                b10 = UPPayWapActivity.b("1", e11.getMessage(), null);
                zVar.a(b10);
            }
        }
    }
}
