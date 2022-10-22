package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import androidx.work.g;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import g0.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import r1.f;
import r1.h;
import r1.i;
import t1.b;
import y1.n;
import y1.p;
import y1.q;
/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4845d = k.f("ForceStopRunnable");

    /* renamed from: e  reason: collision with root package name */
    private static final long f4846e = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with root package name */
    private final Context f4847a;

    /* renamed from: b  reason: collision with root package name */
    private final i f4848b;

    /* renamed from: c  reason: collision with root package name */
    private int f4849c = 0;

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private static final String f4850a = k.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                k.c().g(f4850a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.g(context);
            }
        }
    }

    public ForceStopRunnable(Context context, i iVar) {
        this.f4847a = context.getApplicationContext();
        this.f4848b = iVar;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i10) {
        return PendingIntent.getBroadcast(context, -1, c(context), i10);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d10 = d(context, a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f4846e;
        if (alarmManager == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(0, currentTimeMillis, d10);
        } else {
            alarmManager.set(0, currentTimeMillis, d10);
        }
    }

    public boolean a() {
        boolean i10 = Build.VERSION.SDK_INT >= 23 ? b.i(this.f4847a, this.f4848b) : false;
        WorkDatabase n10 = this.f4848b.n();
        q M = n10.M();
        n L = n10.L();
        n10.e();
        try {
            List<p> j10 = M.j();
            boolean z10 = j10 != null && !j10.isEmpty();
            if (z10) {
                for (p pVar : j10) {
                    M.b(WorkInfo.State.ENQUEUED, pVar.f36689a);
                    M.d(pVar.f36689a, -1L);
                }
            }
            L.b();
            n10.B();
            return z10 || i10;
        } finally {
            n10.i();
        }
    }

    public void b() {
        boolean a10 = a();
        if (h()) {
            k.c().a(f4845d, "Rescheduling Workers.", new Throwable[0]);
            this.f4848b.r();
            this.f4848b.k().c(false);
        } else if (e()) {
            k.c().a(f4845d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f4848b.r();
        } else if (a10) {
            k.c().a(f4845d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f4848b.h(), this.f4848b.n(), this.f4848b.m());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        int i10 = 536870912;
        try {
            if (a.c()) {
                i10 = 570425344;
            }
            PendingIntent d10 = d(this.f4847a, i10);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d10 != null) {
                    d10.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f4847a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i11 = 0; i11 < historicalProcessExitReasons.size(); i11++) {
                        if (historicalProcessExitReasons.get(i11).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d10 == null) {
                g(this.f4847a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            k.c().h(f4845d, "Ignoring exception", e10);
            return true;
        }
    }

    public boolean f() {
        androidx.work.a h10 = this.f4848b.h();
        if (TextUtils.isEmpty(h10.c())) {
            k.c().a(f4845d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b10 = z1.f.b(this.f4847a, h10);
        k.c().a(f4845d, String.format("Is default app process = %s", Boolean.valueOf(b10)), new Throwable[0]);
        return b10;
    }

    boolean h() {
        return this.f4848b.k().a();
    }

    public void i(long j10) {
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        try {
            if (f()) {
                while (true) {
                    h.e(this.f4847a);
                    k.c().a(f4845d, "Performing cleanup operations.", new Throwable[0]);
                    try {
                        b();
                        break;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
                        i10 = this.f4849c + 1;
                        this.f4849c = i10;
                        if (i10 >= 3) {
                            k c10 = k.c();
                            String str = f4845d;
                            c10.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                            g d10 = this.f4848b.h().d();
                            if (d10 != null) {
                                k.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                                d10.a(illegalStateException);
                            } else {
                                throw illegalStateException;
                            }
                        } else {
                            k.c().a(f4845d, String.format("Retrying after %s", Long.valueOf(i10 * 300)), e10);
                            i(this.f4849c * 300);
                        }
                    }
                    k.c().a(f4845d, String.format("Retrying after %s", Long.valueOf(i10 * 300)), e10);
                    i(this.f4849c * 300);
                }
            }
        } finally {
            this.f4848b.q();
        }
    }
}
