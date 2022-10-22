package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import r1.i;
import u1.c;
import u1.d;
import y1.p;
/* compiled from: SystemForegroundDispatcher.java */
/* loaded from: classes.dex */
public class a implements c, r1.b {

    /* renamed from: k  reason: collision with root package name */
    static final String f4831k = k.f("SystemFgDispatcher");

    /* renamed from: a  reason: collision with root package name */
    private Context f4832a;

    /* renamed from: b  reason: collision with root package name */
    private i f4833b;

    /* renamed from: c  reason: collision with root package name */
    private final a2.a f4834c;

    /* renamed from: i  reason: collision with root package name */
    final d f4840i;

    /* renamed from: j  reason: collision with root package name */
    private b f4841j;

    /* renamed from: d  reason: collision with root package name */
    final Object f4835d = new Object();

    /* renamed from: e  reason: collision with root package name */
    String f4836e = null;

    /* renamed from: f  reason: collision with root package name */
    final Map<String, e> f4837f = new LinkedHashMap();

    /* renamed from: h  reason: collision with root package name */
    final Set<p> f4839h = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, p> f4838g = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemForegroundDispatcher.java */
    /* renamed from: androidx.work.impl.foreground.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0056a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WorkDatabase f4842a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4843b;

        RunnableC0056a(WorkDatabase workDatabase, String str) {
            this.f4842a = workDatabase;
            this.f4843b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            p n10 = this.f4842a.M().n(this.f4843b);
            if (n10 != null && n10.b()) {
                synchronized (a.this.f4835d) {
                    a.this.f4838g.put(this.f4843b, n10);
                    a.this.f4839h.add(n10);
                    a aVar = a.this;
                    aVar.f4840i.d(aVar.f4839h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemForegroundDispatcher.java */
    /* loaded from: classes.dex */
    public interface b {
        void b(int i10, int i11, Notification notification);

        void c(int i10, Notification notification);

        void d(int i10);

        void stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f4832a = context;
        i j10 = i.j(context);
        this.f4833b = j10;
        a2.a o10 = j10.o();
        this.f4834c = o10;
        this.f4840i = new d(this.f4832a, o10, this);
        this.f4833b.l().d(this);
    }

    public static Intent a(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent d(Context context, String str, e eVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", eVar.c());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", eVar.a());
        intent.putExtra("KEY_NOTIFICATION", eVar.b());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent f(Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    private void g(Intent intent) {
        k.c().d(f4831k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f4833b.e(UUID.fromString(stringExtra));
        }
    }

    private void h(Intent intent) {
        int i10 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        k.c().a(f4831k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (!(notification == null || this.f4841j == null)) {
            this.f4837f.put(stringExtra, new e(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f4836e)) {
                this.f4836e = stringExtra;
                this.f4841j.b(intExtra, intExtra2, notification);
                return;
            }
            this.f4841j.c(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, e> entry : this.f4837f.entrySet()) {
                    i10 |= entry.getValue().a();
                }
                e eVar = this.f4837f.get(this.f4836e);
                if (eVar != null) {
                    this.f4841j.b(eVar.c(), i10, eVar.b());
                }
            }
        }
    }

    private void i(Intent intent) {
        k.c().d(f4831k, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f4834c.b(new RunnableC0056a(this.f4833b.n(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    @Override // u1.c
    public void b(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                k.c().a(f4831k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                this.f4833b.v(str);
            }
        }
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        Map.Entry<String, e> entry;
        synchronized (this.f4835d) {
            p remove = this.f4838g.remove(str);
            if (remove != null ? this.f4839h.remove(remove) : false) {
                this.f4840i.d(this.f4839h);
            }
        }
        e remove2 = this.f4837f.remove(str);
        if (str.equals(this.f4836e) && this.f4837f.size() > 0) {
            Iterator<Map.Entry<String, e>> it = this.f4837f.entrySet().iterator();
            Map.Entry<String, e> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f4836e = entry.getKey();
            if (this.f4841j != null) {
                e value = entry.getValue();
                this.f4841j.b(value.c(), value.a(), value.b());
                this.f4841j.d(value.c());
            }
        }
        b bVar = this.f4841j;
        if (remove2 != null && bVar != null) {
            k.c().a(f4831k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.c()), str, Integer.valueOf(remove2.a())), new Throwable[0]);
            bVar.d(remove2.c());
        }
    }

    @Override // u1.c
    public void e(List<String> list) {
    }

    void j(Intent intent) {
        k.c().d(f4831k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f4841j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.f4841j = null;
        synchronized (this.f4835d) {
            this.f4840i.e();
        }
        this.f4833b.l().i(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            i(intent);
            h(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            h(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            g(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            j(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(b bVar) {
        if (this.f4841j != null) {
            k.c().b(f4831k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f4841j = bVar;
        }
    }
}
