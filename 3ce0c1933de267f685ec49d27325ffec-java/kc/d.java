package kc;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* compiled from: NotificationUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static boolean a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        for (String str : string.split(":")) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
            if (unflattenFromString != null && unflattenFromString.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
