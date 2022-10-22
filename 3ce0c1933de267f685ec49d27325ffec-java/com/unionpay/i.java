package com.unionpay;

import android.content.Intent;
import android.os.Bundle;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class i implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f23304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UPPayWapActivity uPPayWapActivity) {
        this.f23304a = uPPayWapActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[Catch: Exception -> 0x0065, TRY_LEAVE, TryCatch #2 {Exception -> 0x0065, blocks: (B:3:0x0005, B:11:0x0022, B:12:0x002d, B:14:0x0059), top: B:24:0x0005 }] */
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
                str2 = (String) jSONObject.get("url");
            } catch (Exception e11) {
                e10 = e11;
                str2 = str3;
            }
            try {
                str3 = (String) jSONObject.get("title");
            } catch (Exception e12) {
                e10 = e12;
                if (zVar != null) {
                    b12 = UPPayWapActivity.b("1", e10.getMessage(), null);
                    zVar.a(b12);
                }
                Bundle bundle = new Bundle();
                bundle.putString("waptype", "new_page");
                bundle.putString("wapurl", str2);
                bundle.putString("waptitle", str3);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(this.f23304a, UPPayWapActivity.class);
                this.f23304a.startActivity(intent);
                if (zVar == null) {
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("waptype", "new_page");
            bundle2.putString("wapurl", str2);
            bundle2.putString("waptitle", str3);
            Intent intent2 = new Intent();
            intent2.putExtras(bundle2);
            intent2.setClass(this.f23304a, UPPayWapActivity.class);
            this.f23304a.startActivity(intent2);
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
