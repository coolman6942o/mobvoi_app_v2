package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.k;
import java.util.HashMap;
import java.util.Map;
import y1.p;
/* compiled from: CommandHandler.java */
/* loaded from: classes.dex */
public class b implements r1.b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4776d = k.f("CommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4777a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, r1.b> f4778b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Object f4779c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f4777a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent d(Context context, String str, boolean z10) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z10);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent e(Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i10, e eVar) {
        k.c().a(f4776d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.f4777a, i10, eVar).a();
    }

    private void i(Intent intent, int i10, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f4779c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            k c10 = k.c();
            String str = f4776d;
            c10.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.f4778b.containsKey(string)) {
                d dVar = new d(this.f4777a, i10, string, eVar);
                this.f4778b.put(string, dVar);
                dVar.f();
            } else {
                k.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void j(Intent intent, int i10) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z10 = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        k.c().a(f4776d, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i10)), new Throwable[0]);
        c(string, z10);
    }

    private void k(Intent intent, int i10, e eVar) {
        k.c().a(f4776d, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i10)), new Throwable[0]);
        eVar.g().r();
    }

    private void l(Intent intent, int i10, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k c10 = k.c();
        String str = f4776d;
        c10.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase n10 = eVar.g().n();
        n10.e();
        try {
            p n11 = n10.M().n(string);
            if (n11 == null) {
                k c11 = k.c();
                c11.h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (n11.f36690b.isFinished()) {
                k c12 = k.c();
                c12.h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
            } else {
                long a10 = n11.a();
                if (!n11.b()) {
                    k.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a10)), new Throwable[0]);
                    a.c(this.f4777a, eVar.g(), string, a10);
                } else {
                    k.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a10)), new Throwable[0]);
                    a.c(this.f4777a, eVar.g(), string, a10);
                    eVar.k(new e.b(eVar, a(this.f4777a), i10));
                }
                n10.B();
            }
        } finally {
            n10.i();
        }
    }

    private void m(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        k.c().a(f4776d, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.g().w(string);
        a.a(this.f4777a, eVar.g(), string);
        eVar.c(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        synchronized (this.f4779c) {
            r1.b remove = this.f4778b.remove(str);
            if (remove != null) {
                remove.c(str, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        boolean z10;
        synchronized (this.f4779c) {
            z10 = !this.f4778b.isEmpty();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Intent intent, int i10, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i10, eVar);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i10, eVar);
        } else if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            k.c().b(f4776d, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i10, eVar);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i10, eVar);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i10);
        } else {
            k.c().h(f4776d, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
