package s1;

import androidx.work.k;
import androidx.work.p;
import java.util.HashMap;
import java.util.Map;
/* compiled from: DelayedWorkTracker.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    static final String f34277d = k.f("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    final b f34278a;

    /* renamed from: b  reason: collision with root package name */
    private final p f34279b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Runnable> f34280c = new HashMap();

    /* compiled from: DelayedWorkTracker.java */
    /* renamed from: s1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0493a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y1.p f34281a;

        RunnableC0493a(y1.p pVar) {
            this.f34281a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.c().a(a.f34277d, String.format("Scheduling work %s", this.f34281a.f36689a), new Throwable[0]);
            a.this.f34278a.f(this.f34281a);
        }
    }

    public a(b bVar, p pVar) {
        this.f34278a = bVar;
        this.f34279b = pVar;
    }

    public void a(y1.p pVar) {
        Runnable remove = this.f34280c.remove(pVar.f36689a);
        if (remove != null) {
            this.f34279b.b(remove);
        }
        RunnableC0493a aVar = new RunnableC0493a(pVar);
        this.f34280c.put(pVar.f36689a, aVar);
        long currentTimeMillis = System.currentTimeMillis();
        this.f34279b.a(pVar.a() - currentTimeMillis, aVar);
    }

    public void b(String str) {
        Runnable remove = this.f34280c.remove(str);
        if (remove != null) {
            this.f34279b.b(remove);
        }
    }
}
