package s1;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.WorkInfo;
import androidx.work.a;
import androidx.work.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import r1.e;
import r1.i;
import u1.c;
import u1.d;
import y1.p;
import z1.f;
/* compiled from: GreedyScheduler.java */
/* loaded from: classes.dex */
public class b implements e, c, r1.b {

    /* renamed from: i  reason: collision with root package name */
    private static final String f34283i = k.f("GreedyScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f34284a;

    /* renamed from: b  reason: collision with root package name */
    private final i f34285b;

    /* renamed from: c  reason: collision with root package name */
    private final d f34286c;

    /* renamed from: e  reason: collision with root package name */
    private a f34288e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34289f;

    /* renamed from: h  reason: collision with root package name */
    Boolean f34291h;

    /* renamed from: d  reason: collision with root package name */
    private final Set<p> f34287d = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final Object f34290g = new Object();

    public b(Context context, a aVar, a2.a aVar2, i iVar) {
        this.f34284a = context;
        this.f34285b = iVar;
        this.f34286c = new d(context, aVar2, this);
        this.f34288e = new a(this, aVar.k());
    }

    private void g() {
        this.f34291h = Boolean.valueOf(f.b(this.f34284a, this.f34285b.h()));
    }

    private void h() {
        if (!this.f34289f) {
            this.f34285b.l().d(this);
            this.f34289f = true;
        }
    }

    private void i(String str) {
        synchronized (this.f34290g) {
            Iterator<p> it = this.f34287d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f36689a.equals(str)) {
                    k.c().a(f34283i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f34287d.remove(next);
                    this.f34286c.d(this.f34287d);
                    break;
                }
            }
        }
    }

    @Override // r1.e
    public boolean a() {
        return false;
    }

    @Override // u1.c
    public void b(List<String> list) {
        for (String str : list) {
            k.c().a(f34283i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f34285b.w(str);
        }
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        i(str);
    }

    @Override // r1.e
    public void d(String str) {
        if (this.f34291h == null) {
            g();
        }
        if (!this.f34291h.booleanValue()) {
            k.c().d(f34283i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        k.c().a(f34283i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        a aVar = this.f34288e;
        if (aVar != null) {
            aVar.b(str);
        }
        this.f34285b.w(str);
    }

    @Override // u1.c
    public void e(List<String> list) {
        for (String str : list) {
            k.c().a(f34283i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f34285b.t(str);
        }
    }

    @Override // r1.e
    public void f(p... pVarArr) {
        if (this.f34291h == null) {
            g();
        }
        if (!this.f34291h.booleanValue()) {
            k.c().d(f34283i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a10 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f36690b == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < a10) {
                    a aVar = this.f34288e;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 23 && pVar.f36698j.h()) {
                        k.c().a(f34283i, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else if (i10 < 24 || !pVar.f36698j.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f36689a);
                    } else {
                        k.c().a(f34283i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                    }
                } else {
                    k.c().a(f34283i, String.format("Starting work for %s", pVar.f36689a), new Throwable[0]);
                    this.f34285b.t(pVar.f36689a);
                }
            }
        }
        synchronized (this.f34290g) {
            if (!hashSet.isEmpty()) {
                k.c().a(f34283i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f34287d.addAll(hashSet);
                this.f34286c.d(this.f34287d);
            }
        }
    }
}
