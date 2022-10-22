package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class g implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f23302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UPPayWapActivity uPPayWapActivity) {
        this.f23302a = uPPayWapActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: Exception -> 0x0040, TRY_LEAVE, TryCatch #0 {Exception -> 0x0040, blocks: (B:3:0x0005, B:11:0x0022, B:12:0x002d, B:14:0x0034), top: B:20:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.unionpay.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str, z zVar) {
        String b10;
        String str2;
        String b11;
        Exception e10;
        String b12;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                str2 = (String) jSONObject.get(Constant.KEY_RESULT_CODE);
            } catch (Exception e11) {
                e10 = e11;
                str2 = str3;
            }
            try {
                str3 = (String) jSONObject.get("resultData");
            } catch (Exception e12) {
                e10 = e12;
                if (zVar != null) {
                    b12 = UPPayWapActivity.b("1", e10.getMessage(), null);
                    zVar.a(b12);
                }
                UPPayWapActivity.a(this.f23302a, str2, str3);
                if (zVar == null) {
                }
            }
            UPPayWapActivity.a(this.f23302a, str2, str3);
            if (zVar == null) {
                b11 = UPPayWapActivity.b("0", Constant.CASH_LOAD_SUCCESS, null);
                zVar.a(b11);
            }
        } catch (Exception e13) {
            if (zVar != null) {
                b10 = UPPayWapActivity.b("1", e13.getMessage(), null);
                zVar.a(b10);
            }
        }
    }
}
