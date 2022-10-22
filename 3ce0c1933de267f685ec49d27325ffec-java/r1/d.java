package r1;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.b;
import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import com.google.common.util.concurrent.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import r1.j;
/* compiled from: Processor.java */
/* loaded from: classes.dex */
public class d implements b, x1.a {

    /* renamed from: l  reason: collision with root package name */
    private static final String f33289l = k.f("Processor");

    /* renamed from: b  reason: collision with root package name */
    private Context f33291b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.work.a f33292c;

    /* renamed from: d  reason: collision with root package name */
    private a2.a f33293d;

    /* renamed from: e  reason: collision with root package name */
    private WorkDatabase f33294e;

    /* renamed from: h  reason: collision with root package name */
    private List<e> f33297h;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, j> f33296g = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private Map<String, j> f33295f = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private Set<String> f33298i = new HashSet();

    /* renamed from: j  reason: collision with root package name */
    private final List<b> f33299j = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f33290a = null;

    /* renamed from: k  reason: collision with root package name */
    private final Object f33300k = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Processor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private b f33301a;

        /* renamed from: b  reason: collision with root package name */
        private String f33302b;

        /* renamed from: c  reason: collision with root package name */
        private j<Boolean> f33303c;

        a(b bVar, String str, j<Boolean> jVar) {
            this.f33301a = bVar;
            this.f33302b = str;
            this.f33303c = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                z10 = this.f33303c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z10 = true;
            }
            this.f33301a.c(this.f33302b, z10);
        }
    }

    public d(Context context, androidx.work.a aVar, a2.a aVar2, WorkDatabase workDatabase, List<e> list) {
        this.f33291b = context;
        this.f33292c = aVar;
        this.f33293d = aVar2;
        this.f33294e = workDatabase;
        this.f33297h = list;
    }

    private static boolean e(String str, j jVar) {
        if (jVar != null) {
            jVar.d();
            k.c().a(f33289l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        k.c().a(f33289l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    private void m() {
        synchronized (this.f33300k) {
            if (!(!this.f33295f.isEmpty())) {
                this.f33291b.startService(androidx.work.impl.foreground.a.f(this.f33291b));
                PowerManager.WakeLock wakeLock = this.f33290a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f33290a = null;
                }
            }
        }
    }

    @Override // x1.a
    public void a(String str, e eVar) {
        synchronized (this.f33300k) {
            k.c().d(f33289l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            j remove = this.f33296g.remove(str);
            if (remove != null) {
                if (this.f33290a == null) {
                    PowerManager.WakeLock b10 = z1.j.b(this.f33291b, "ProcessorForegroundLck");
                    this.f33290a = b10;
                    b10.acquire();
                }
                this.f33295f.put(str, remove);
                b.n(this.f33291b, androidx.work.impl.foreground.a.d(this.f33291b, str, eVar));
            }
        }
    }

    @Override // x1.a
    public void b(String str) {
        synchronized (this.f33300k) {
            this.f33295f.remove(str);
            m();
        }
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        synchronized (this.f33300k) {
            this.f33296g.remove(str);
            k.c().a(f33289l, String.format("%s %s executed; reschedule = %s", d.class.getSimpleName(), str, Boolean.valueOf(z10)), new Throwable[0]);
            for (b bVar : this.f33299j) {
                bVar.c(str, z10);
            }
        }
    }

    public void d(b bVar) {
        synchronized (this.f33300k) {
            this.f33299j.add(bVar);
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f33300k) {
            contains = this.f33298i.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z10;
        synchronized (this.f33300k) {
            if (!this.f33296g.containsKey(str) && !this.f33295f.containsKey(str)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f33300k) {
            containsKey = this.f33295f.containsKey(str);
        }
        return containsKey;
    }

    public void i(b bVar) {
        synchronized (this.f33300k) {
            this.f33299j.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.f33300k) {
            if (g(str)) {
                k.c().a(f33289l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            j a10 = new j.c(this.f33291b, this.f33292c, this.f33293d, this, this.f33294e, str).c(this.f33297h).b(aVar).a();
            com.google.common.util.concurrent.j<Boolean> b10 = a10.b();
            b10.a(new a(this, str, b10), this.f33293d.a());
            this.f33296g.put(str, a10);
            this.f33293d.c().execute(a10);
            k.c().a(f33289l, String.format("%s: processing %s", d.class.getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean e10;
        synchronized (this.f33300k) {
            boolean z10 = true;
            k.c().a(f33289l, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.f33298i.add(str);
            j remove = this.f33295f.remove(str);
            if (remove == null) {
                z10 = false;
            }
            if (remove == null) {
                remove = this.f33296g.remove(str);
            }
            e10 = e(str, remove);
            if (z10) {
                m();
            }
        }
        return e10;
    }

    public boolean n(String str) {
        boolean e10;
        synchronized (this.f33300k) {
            k.c().a(f33289l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            e10 = e(str, this.f33295f.remove(str));
        }
        return e10;
    }

    public boolean o(String str) {
        boolean e10;
        synchronized (this.f33300k) {
            k.c().a(f33289l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            e10 = e(str, this.f33296g.remove(str));
        }
        return e10;
    }
}
