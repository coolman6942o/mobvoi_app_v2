package com.paypal.android.sdk.payments;

import android.text.TextUtils;
import com.paypal.android.sdk.a2;
import com.paypal.android.sdk.ez;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class g3 {

    /* renamed from: a  reason: collision with root package name */
    private final k1 f21727a;

    public g3(k1 k1Var) {
        this.f21727a = k1Var;
    }

    private String b(ez ezVar, boolean z10) {
        String str = com.paypal.android.sdk.g3.f21312b + ":" + a() + ":" + ezVar.a();
        if (!z10) {
            return str;
        }
        return str + "|error";
    }

    protected abstract String a();

    public void c(ez ezVar, boolean z10, String str, String str2, String str3) {
        a2.a();
        String locale = Locale.getDefault().toString();
        HashMap hashMap = new HashMap();
        boolean z11 = !TextUtils.isEmpty(str);
        hashMap.put("gn", b(ezVar, z11));
        hashMap.put("v31", b(ezVar, z11));
        String str4 = b(ezVar, z11) + ":" + ezVar.a(this.f21727a.e(), z10);
        if (z11) {
            str4 = str4 + "|error";
        }
        hashMap.put("c25", str4);
        hashMap.put("v25", "D=c25");
        hashMap.put("c37", com.paypal.android.sdk.g3.f21311a + "::");
        hashMap.put("c50", locale);
        hashMap.put("c35", "out");
        e(hashMap, ezVar, str2, str3);
        if (str != null) {
            hashMap.put("c29", str);
        }
        d("2.15.1", hashMap);
    }

    abstract void d(String str, Map map);

    protected abstract void e(Map map, ez ezVar, String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public k1 f() {
        return this.f21727a;
    }
}
