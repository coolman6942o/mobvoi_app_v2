package gd;

import android.app.NotificationManager;
import com.mobvoi.android.common.utils.b;
/* compiled from: NotificationController.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static NotificationManager f27397a = (NotificationManager) b.e().getSystemService("notification");

    public static void a() {
        NotificationManager notificationManager = f27397a;
        if (notificationManager != null) {
            notificationManager.cancel(291);
        }
    }
}
