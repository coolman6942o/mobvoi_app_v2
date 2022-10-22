package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.k;
import java.util.ArrayList;
import java.util.List;
import r1.i;
import z1.g;
import z1.j;
import z1.n;
/* compiled from: SystemAlarmDispatcher.java */
/* loaded from: classes.dex */
public class e implements r1.b {

    /* renamed from: k  reason: collision with root package name */
    static final String f4795k = k.f("SystemAlarmDispatcher");

    /* renamed from: a  reason: collision with root package name */
    final Context f4796a;

    /* renamed from: b  reason: collision with root package name */
    private final a2.a f4797b;

    /* renamed from: c  reason: collision with root package name */
    private final n f4798c;

    /* renamed from: d  reason: collision with root package name */
    private final r1.d f4799d;

    /* renamed from: e  reason: collision with root package name */
    private final i f4800e;

    /* renamed from: f  reason: collision with root package name */
    final androidx.work.impl.background.systemalarm.b f4801f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f4802g;

    /* renamed from: h  reason: collision with root package name */
    final List<Intent> f4803h;

    /* renamed from: i  reason: collision with root package name */
    Intent f4804i;

    /* renamed from: j  reason: collision with root package name */
    private c f4805j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            e eVar;
            synchronized (e.this.f4803h) {
                e eVar2 = e.this;
                eVar2.f4804i = eVar2.f4803h.get(0);
            }
            Intent intent = e.this.f4804i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f4804i.getIntExtra("KEY_START_ID", 0);
                k c10 = k.c();
                String str = e.f4795k;
                c10.a(str, String.format("Processing command %s, %s", e.this.f4804i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock b10 = j.b(e.this.f4796a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    k.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, b10), new Throwable[0]);
                    b10.acquire();
                    e eVar3 = e.this;
                    eVar3.f4801f.p(eVar3.f4804i, intExtra, eVar3);
                    k.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                    b10.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th2) {
                    try {
                        k c11 = k.c();
                        String str2 = e.f4795k;
                        c11.b(str2, "Unexpected error in onHandleIntent", th2);
                        k.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                        b10.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th3) {
                        k.c().a(e.f4795k, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                        b10.release();
                        e eVar4 = e.this;
                        eVar4.k(new d(eVar4));
                        throw th3;
                    }
                }
                eVar.k(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f4807a;

        /* renamed from: b  reason: collision with root package name */
        private final Intent f4808b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4809c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(e eVar, Intent intent, int i10) {
            this.f4807a = eVar;
            this.f4808b = intent;
            this.f4809c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4807a.a(this.f4808b, this.f4809c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    /* compiled from: SystemAlarmDispatcher.java */
    /* loaded from: classes.dex */
    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final e f4810a;

        d(e eVar) {
            this.f4810a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4810a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        this(context, null, null);
    }

    private void b() {
        if (this.f4802g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        b();
        synchronized (this.f4803h) {
            for (Intent intent : this.f4803h) {
                if (str.equals(intent.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock b10 = j.b(this.f4796a, "ProcessCommand");
        try {
            b10.acquire();
            this.f4800e.o().b(new a());
        } finally {
            b10.release();
        }
    }

    public boolean a(Intent intent, int i10) {
        k c10 = k.c();
        String str = f4795k;
        boolean z10 = false;
        c10.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i10)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            k.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i10);
            synchronized (this.f4803h) {
                if (!this.f4803h.isEmpty()) {
                    z10 = true;
                }
                this.f4803h.add(intent);
                if (!z10) {
                    l();
                }
            }
            return true;
        }
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        k(new b(this, androidx.work.impl.background.systemalarm.b.d(this.f4796a, str, z10), 0));
    }

    void d() {
        k c10 = k.c();
        String str = f4795k;
        c10.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f4803h) {
            if (this.f4804i != null) {
                k.c().a(str, String.format("Removing command %s", this.f4804i), new Throwable[0]);
                if (this.f4803h.remove(0).equals(this.f4804i)) {
                    this.f4804i = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            g c11 = this.f4797b.c();
            if (!this.f4801f.o() && this.f4803h.isEmpty() && !c11.a()) {
                k.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f4805j;
                if (cVar != null) {
                    cVar.a();
                }
            } else if (!this.f4803h.isEmpty()) {
                l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1.d e() {
        return this.f4799d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a2.a f() {
        return this.f4797b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i g() {
        return this.f4800e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n h() {
        return this.f4798c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        k.c().a(f4795k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f4799d.i(this);
        this.f4798c.a();
        this.f4805j = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        this.f4802g.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(c cVar) {
        if (this.f4805j != null) {
            k.c().b(f4795k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f4805j = cVar;
        }
    }

    e(Context context, r1.d dVar, i iVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4796a = applicationContext;
        this.f4801f = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.f4798c = new n();
        iVar = iVar == null ? i.j(context) : iVar;
        this.f4800e = iVar;
        dVar = dVar == null ? iVar.l() : dVar;
        this.f4799d = dVar;
        this.f4797b = iVar.o();
        dVar.d(this);
        this.f4803h = new ArrayList();
        this.f4804i = null;
        this.f4802g = new Handler(Looper.getMainLooper());
    }
}
