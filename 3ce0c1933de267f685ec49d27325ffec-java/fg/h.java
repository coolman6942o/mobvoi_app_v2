package fg;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.HealthSleepSharesActivity;
import com.mobvoi.health.companion.system.b;
import com.mobvoi.health.companion.system.c;
import com.mobvoi.wear.common.base.WearPath;
import eg.a;
/* compiled from: HealthMessageListener.java */
/* loaded from: classes2.dex */
public class h implements b.c {
    private void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("sleepId", str);
        intent.setComponent(new ComponentName(context, HealthSleepSharesActivity.class));
        context.startActivity(intent);
    }

    @Override // com.mobvoi.health.companion.system.b.c
    public void a(b.C0221b bVar) {
        String str = bVar.f19015b;
        k.c("health.bt.listener", "onMessageReceived %s", str);
        byte[] bArr = bVar.f19016c;
        if (WearPath.Health.SYNC_STEP_TO_WECHAT.equals(str)) {
            c.a().i(bVar.f19014a, Integer.parseInt(new String(bArr)));
        } else if (WearPath.Health.SLEEP_SHARE.equals(str)) {
            b(bVar.f19014a, new String(bArr));
        } else if (WearPath.Health.CMD_NEW_WEAR_PUSH_TO_PHONE.equals(str)) {
            f.a(bVar.f19014a, bArr);
        } else {
            a.e().g(str, bArr);
        }
    }
}
