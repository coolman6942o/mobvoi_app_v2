package md;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.contacts.StartJobIntentServiceReceiver;
import com.mobvoi.companion.scheduler.PeriodicalIntentService;
/* compiled from: AlarmUtil.java */
/* loaded from: classes2.dex */
public class a {
    private static long a() {
        return b.e().getSharedPreferences("alarm_settings", 0).getLong("last_upload_app_info_time", 0L);
    }

    public static void b() {
        b.e().getSharedPreferences("alarm_settings", 0).edit().putLong("last_upload_app_info_time", System.currentTimeMillis()).apply();
    }

    public static void c(Context context) {
        k.a("AlarmUtil", "startUploadAppInfoTask");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager != null) {
            Intent intent = new Intent(context, PeriodicalIntentService.class);
            intent.setAction("com.mobvoi.companion.action.UPLOAD_INSTALLED_APPS");
            alarmManager.set(1, Math.max(System.currentTimeMillis(), a() + 604800000), PendingIntent.getBroadcast(context, 0, StartJobIntentServiceReceiver.a(context, intent, 2002), 67108864));
        }
    }
}
