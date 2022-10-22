package z1;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.e;
import androidx.work.f;
import androidx.work.impl.utils.futures.c;
import com.google.common.util.concurrent.j;
import y1.p;
/* compiled from: WorkForegroundRunnable.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    static final String f37237g = androidx.work.k.f("WorkForegroundRunnable");

    /* renamed from: a  reason: collision with root package name */
    final c<Void> f37238a = c.t();

    /* renamed from: b  reason: collision with root package name */
    final Context f37239b;

    /* renamed from: c  reason: collision with root package name */
    final p f37240c;

    /* renamed from: d  reason: collision with root package name */
    final ListenableWorker f37241d;

    /* renamed from: e  reason: collision with root package name */
    final f f37242e;

    /* renamed from: f  reason: collision with root package name */
    final a2.a f37243f;

    /* compiled from: WorkForegroundRunnable.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f37244a;

        a(c cVar) {
            this.f37244a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37244a.r(k.this.f37241d.d());
        }
    }

    /* compiled from: WorkForegroundRunnable.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f37246a;

        b(c cVar) {
            this.f37246a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = (e) this.f37246a.get();
                if (eVar != null) {
                    androidx.work.k.c().a(k.f37237g, String.format("Updating notification for %s", k.this.f37240c.f36691c), new Throwable[0]);
                    k.this.f37241d.n(true);
                    k kVar = k.this;
                    kVar.f37238a.r(kVar.f37242e.a(kVar.f37239b, kVar.f37241d.f(), eVar));
                    return;
                }
                throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", k.this.f37240c.f36691c));
            } catch (Throwable th2) {
                k.this.f37238a.q(th2);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public k(Context context, p pVar, ListenableWorker listenableWorker, f fVar, a2.a aVar) {
        this.f37239b = context;
        this.f37240c = pVar;
        this.f37241d = listenableWorker;
        this.f37242e = fVar;
        this.f37243f = aVar;
    }

    public j<Void> a() {
        return this.f37238a;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f37240c.f36705q || g0.a.c()) {
            this.f37238a.p(null);
            return;
        }
        c t10 = c.t();
        this.f37243f.a().execute(new a(t10));
        t10.a(new b(t10), this.f37243f.a());
    }
}
