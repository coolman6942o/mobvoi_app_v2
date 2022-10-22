package td;

import android.app.Activity;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.unionpay.UPPayAssistEx;
import com.unionpay.tsmservice.data.Constant;
/* compiled from: UninoPay.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f35139a = "01";

    /* renamed from: b  reason: collision with root package name */
    public static String f35140b = "00";

    public static void a(Intent intent, c cVar) {
        if (cVar != null) {
            if (intent == null) {
                cVar.b();
                return;
            }
            String string = intent.getExtras().getString("pay_result");
            k.a("UnionPay", "UninoPay result: " + string);
            if (Constant.CASH_LOAD_SUCCESS.equalsIgnoreCase(string)) {
                cVar.c();
            } else if (Constant.CASH_LOAD_FAIL.equalsIgnoreCase(string)) {
                cVar.b();
            } else if (Constant.CASH_LOAD_CANCEL.equals(string)) {
                cVar.d();
            }
        }
    }

    public static void b(Activity activity, String str, String str2) {
        int startPay = UPPayAssistEx.startPay(activity, null, null, str, str2);
        k.a("UnionPay", "UninoPay startPay result ret: " + startPay);
        if (startPay == 2 || startPay == -1) {
            k.d("UnionPay", "UninoPay need upgrade or not installed");
        }
    }
}
