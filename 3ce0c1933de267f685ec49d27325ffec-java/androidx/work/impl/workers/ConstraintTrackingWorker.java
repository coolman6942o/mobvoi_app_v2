package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import com.google.common.util.concurrent.j;
import java.util.Collections;
import java.util.List;
import r1.i;
import u1.c;
import u1.d;
import y1.p;
/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: k  reason: collision with root package name */
    private static final String f4878k = k.f("ConstraintTrkngWrkr");

    /* renamed from: f  reason: collision with root package name */
    private WorkerParameters f4879f;

    /* renamed from: g  reason: collision with root package name */
    final Object f4880g = new Object();

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f4881h = false;

    /* renamed from: i  reason: collision with root package name */
    androidx.work.impl.utils.futures.c<ListenableWorker.a> f4882i = androidx.work.impl.utils.futures.c.t();

    /* renamed from: j  reason: collision with root package name */
    private ListenableWorker f4883j;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f4885a;

        b(j jVar) {
            this.f4885a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f4880g) {
                if (ConstraintTrackingWorker.this.f4881h) {
                    ConstraintTrackingWorker.this.t();
                } else {
                    ConstraintTrackingWorker.this.f4882i.r(this.f4885a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f4879f = workerParameters;
    }

    @Override // u1.c
    public void b(List<String> list) {
        k.c().a(f4878k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f4880g) {
            this.f4881h = true;
        }
    }

    @Override // u1.c
    public void e(List<String> list) {
    }

    @Override // androidx.work.ListenableWorker
    public a2.a h() {
        return i.j(a()).o();
    }

    @Override // androidx.work.ListenableWorker
    public boolean j() {
        ListenableWorker listenableWorker = this.f4883j;
        return listenableWorker != null && listenableWorker.j();
    }

    @Override // androidx.work.ListenableWorker
    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.f4883j;
        if (listenableWorker != null && !listenableWorker.k()) {
            this.f4883j.q();
        }
    }

    @Override // androidx.work.ListenableWorker
    public j<ListenableWorker.a> p() {
        c().execute(new a());
        return this.f4882i;
    }

    public WorkDatabase r() {
        return i.j(a()).n();
    }

    void s() {
        this.f4882i.p(ListenableWorker.a.a());
    }

    void t() {
        this.f4882i.p(ListenableWorker.a.b());
    }

    void u() {
        String i10 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(i10)) {
            k.c().b(f4878k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker b10 = i().b(a(), i10, this.f4879f);
        this.f4883j = b10;
        if (b10 == null) {
            k.c().a(f4878k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        p n10 = r().M().n(f().toString());
        if (n10 == null) {
            s();
            return;
        }
        d dVar = new d(a(), h(), this);
        dVar.d(Collections.singletonList(n10));
        if (dVar.c(f().toString())) {
            k.c().a(f4878k, String.format("Constraints met for delegate %s", i10), new Throwable[0]);
            try {
                j<ListenableWorker.a> p10 = this.f4883j.p();
                p10.a(new b(p10), c());
            } catch (Throwable th2) {
                k c10 = k.c();
                String str = f4878k;
                c10.a(str, String.format("Delegated worker %s threw exception in startWork.", i10), th2);
                synchronized (this.f4880g) {
                    if (this.f4881h) {
                        k.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        t();
                    } else {
                        s();
                    }
                }
            }
        } else {
            k.c().a(f4878k, String.format("Constraints not met for delegate %s. Requesting retry.", i10), new Throwable[0]);
            t();
        }
    }
}
