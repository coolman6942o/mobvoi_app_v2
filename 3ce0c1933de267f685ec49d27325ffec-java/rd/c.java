package rd;

import android.content.Context;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.WearPath;
import rx.j;
import ta.a;
import yp.b;
/* compiled from: SafetyCheck.java */
/* loaded from: classes2.dex */
public class c {
    public static boolean a(Context context) {
        return context.getSharedPreferences(WearPath.TicPay.PAY, 0).getBoolean("need_upload_account", false);
    }

    public static void b(Context context, boolean z10) {
        context.getSharedPreferences(WearPath.TicPay.PAY, 0).edit().putBoolean("need_upload_account", z10).apply();
    }

    public static j c(Context context, b<b> bVar, b<Throwable> bVar2) {
        String wearDeviceId = CompanionSetting.getWearDeviceId(context);
        return new e().d().a(new a(a.x(), wearDeviceId)).Z(cq.a.c()).H(xp.a.b()).Y(bVar, bVar2);
    }
}
