package td;

import android.app.Activity;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.unionpay.tsmservice.data.Constant;
/* compiled from: WxPay.java */
/* loaded from: classes2.dex */
public class f {
    public static void a(Intent intent, c cVar) {
        if (cVar != null) {
            if (intent == null) {
                cVar.b();
                return;
            }
            String stringExtra = intent.getStringExtra("wxPayResult");
            k.a("wxpay", "WxPay result: " + stringExtra);
            if (Constant.CASH_LOAD_SUCCESS.equalsIgnoreCase(stringExtra)) {
                cVar.c();
            } else if (Constant.CASH_LOAD_FAIL.equalsIgnoreCase(stringExtra)) {
                cVar.b();
            } else if (Constant.CASH_LOAD_CANCEL.equals(stringExtra)) {
                cVar.d();
            }
        }
    }

    public static void b(Activity activity, Class<?> cls, String str) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("payInfo", str);
        activity.startActivityForResult(intent, 11);
    }
}
