package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import r1.i;
import y1.g;
import y1.h;
import z1.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Alarms.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4775a = k.f("Alarms");

    public static void a(Context context, i iVar, String str) {
        h J = iVar.n().J();
        g c10 = J.c(str);
        if (c10 != null) {
            b(context, str, c10.f36676b);
            k.c().a(f4775a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            J.d(str);
        }
    }

    private static void b(Context context, String str, int i10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i10, b.b(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service != null && alarmManager != null) {
            k.c().a(f4775a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i10)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void c(Context context, i iVar, String str, long j10) {
        WorkDatabase n10 = iVar.n();
        h J = n10.J();
        g c10 = J.c(str);
        if (c10 != null) {
            b(context, str, c10.f36676b);
            d(context, str, c10.f36676b, j10);
            return;
        }
        int b10 = new c(n10).b();
        J.b(new g(str, b10));
        d(context, str, b10, j10);
    }

    private static void d(Context context, String str, int i10, long j10) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i11 = Build.VERSION.SDK_INT;
        PendingIntent service = PendingIntent.getService(context, i10, b.b(context, str), i11 >= 23 ? 201326592 : 134217728);
        if (alarmManager == null) {
            return;
        }
        if (i11 >= 19) {
            alarmManager.setExact(0, j10, service);
        } else {
            alarmManager.set(0, j10, service);
        }
    }
}
