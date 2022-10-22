package vk;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.pingplusplus.android.PaymentActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f35793a = 1010;

    public static void a(Activity activity, String str) {
        try {
            if ("wx".equals(new JSONObject(str).optString("channel"))) {
                String packageName = activity.getPackageName();
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(packageName, packageName + ".wxapi.WXPayEntryActivity"));
                intent.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", str);
                activity.startActivityForResult(intent, f35793a);
                return;
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        Intent intent2 = new Intent(activity, PaymentActivity.class);
        intent2.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", str);
        activity.startActivityForResult(intent2, f35793a);
    }
}
