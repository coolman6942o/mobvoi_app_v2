package r1;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.h;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import y1.p;
import y1.q;
import y1.t;
import z1.d;
import z1.l;
import z1.m;
/* compiled from: WorkerWrapper.java */
/* loaded from: classes.dex */
public class j implements Runnable {

    /* renamed from: t  reason: collision with root package name */
    static final String f33329t = k.f("WorkerWrapper");

    /* renamed from: a  reason: collision with root package name */
    Context f33330a;

    /* renamed from: b  reason: collision with root package name */
    private String f33331b;

    /* renamed from: c  reason: collision with root package name */
    private List<e> f33332c;

    /* renamed from: d  reason: collision with root package name */
    private WorkerParameters.a f33333d;

    /* renamed from: e  reason: collision with root package name */
    p f33334e;

    /* renamed from: f  reason: collision with root package name */
    ListenableWorker f33335f;

    /* renamed from: g  reason: collision with root package name */
    a2.a f33336g;

    /* renamed from: i  reason: collision with root package name */
    private androidx.work.a f33338i;

    /* renamed from: j  reason: collision with root package name */
    private x1.a f33339j;

    /* renamed from: k  reason: collision with root package name */
    private WorkDatabase f33340k;

    /* renamed from: l  reason: collision with root package name */
    private q f33341l;

    /* renamed from: m  reason: collision with root package name */
    private y1.b f33342m;

    /* renamed from: n  reason: collision with root package name */
    private t f33343n;

    /* renamed from: o  reason: collision with root package name */
    private List<String> f33344o;

    /* renamed from: p  reason: collision with root package name */
    private String f33345p;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f33348s;

    /* renamed from: h  reason: collision with root package name */
    ListenableWorker.a f33337h = ListenableWorker.a.a();

    /* renamed from: q  reason: collision with root package name */
    androidx.work.impl.utils.futures.c<Boolean> f33346q = androidx.work.impl.utils.futures.c.t();

    /* renamed from: r  reason: collision with root package name */
    com.google.common.util.concurrent.j<ListenableWorker.a> f33347r = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkerWrapper.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.common.util.concurrent.j f33349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.c f33350b;

        a(com.google.common.util.concurrent.j jVar, androidx.work.impl.utils.futures.c cVar) {
            this.f33349a = jVar;
            this.f33350b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f33349a.get();
                k.c().a(j.f33329t, String.format("Starting work for %s", j.this.f33334e.f36691c), new Throwable[0]);
                j jVar = j.this;
                jVar.f33347r = jVar.f33335f.p();
                this.f33350b.r(j.this.f33347r);
            } catch (Throwable th2) {
                this.f33350b.q(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkerWrapper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.c f33352a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f33353b;

        b(androidx.work.impl.utils.futures.c cVar, String str) {
            this.f33352a = cVar;
            this.f33353b = str;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            Throwable e10;
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.f33352a.get();
                    if (aVar == null) {
                        k.c().b(j.f33329t, String.format("%s returned a null result. Treating it as a failure.", j.this.f33334e.f36691c), new Throwable[0]);
                    } else {
                        k.c().a(j.f33329t, String.format("%s returned a %s result.", j.this.f33334e.f36691c, aVar), new Throwable[0]);
                        j.this.f33337h = aVar;
                    }
                } catch (InterruptedException e11) {
                    e10 = e11;
                    k.c().b(j.f33329t, String.format("%s failed because it threw an exception/error", this.f33353b), e10);
                } catch (CancellationException e12) {
                    k.c().d(j.f33329t, String.format("%s was cancelled", this.f33353b), e12);
                } catch (ExecutionException e13) {
                    e10 = e13;
                    k.c().b(j.f33329t, String.format("%s failed because it threw an exception/error", this.f33353b), e10);
                }
            } finally {
                j.this.f();
            }
        }
    }

    /* compiled from: WorkerWrapper.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        Context f33355a;

        /* renamed from: b  reason: collision with root package name */
        ListenableWorker f33356b;

        /* renamed from: c  reason: collision with root package name */
        x1.a f33357c;

        /* renamed from: d  reason: collision with root package name */
        a2.a f33358d;

        /* renamed from: e  reason: collision with root package name */
        androidx.work.a f33359e;

        /* renamed from: f  reason: collision with root package name */
        WorkDatabase f33360f;

        /* renamed from: g  reason: collision with root package name */
        String f33361g;

        /* renamed from: h  reason: collision with root package name */
        List<e> f33362h;

        /* renamed from: i  reason: collision with root package name */
        WorkerParameters.a f33363i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, a2.a aVar2, x1.a aVar3, WorkDatabase workDatabase, String str) {
            this.f33355a = context.getApplicationContext();
            this.f33358d = aVar2;
            this.f33357c = aVar3;
            this.f33359e = aVar;
            this.f33360f = workDatabase;
            this.f33361g = str;
        }

        public j a() {
            return new j(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f33363i = aVar;
            }
            return this;
        }

        public c c(List<e> list) {
            this.f33362h = list;
            return this;
        }
    }

    j(c cVar) {
        this.f33330a = cVar.f33355a;
        this.f33336g = cVar.f33358d;
        this.f33339j = cVar.f33357c;
        this.f33331b = cVar.f33361g;
        this.f33332c = cVar.f33362h;
        this.f33333d = cVar.f33363i;
        this.f33335f = cVar.f33356b;
        this.f33338i = cVar.f33359e;
        WorkDatabase workDatabase = cVar.f33360f;
        this.f33340k = workDatabase;
        this.f33341l = workDatabase.M();
        this.f33342m = this.f33340k.E();
        this.f33343n = this.f33340k.N();
    }

    private String a(List<String> list) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.f33331b);
        sb2.append(", tags={ ");
        boolean z10 = true;
        for (String str : list) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    private void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            k.c().d(f33329t, String.format("Worker result SUCCESS for %s", this.f33345p), new Throwable[0]);
            if (this.f33334e.d()) {
                h();
            } else {
                m();
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            k.c().d(f33329t, String.format("Worker result RETRY for %s", this.f33345p), new Throwable[0]);
            g();
        } else {
            k.c().d(f33329t, String.format("Worker result FAILURE for %s", this.f33345p), new Throwable[0]);
            if (this.f33334e.d()) {
                h();
            } else {
                l();
            }
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f33341l.m(str2) != WorkInfo.State.CANCELLED) {
                this.f33341l.b(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.f33342m.a(str2));
        }
    }

    private void g() {
        this.f33340k.e();
        try {
            this.f33341l.b(WorkInfo.State.ENQUEUED, this.f33331b);
            this.f33341l.r(this.f33331b, System.currentTimeMillis());
            this.f33341l.d(this.f33331b, -1L);
            this.f33340k.B();
        } finally {
            this.f33340k.i();
            i(true);
        }
    }

    private void h() {
        this.f33340k.e();
        try {
            this.f33341l.r(this.f33331b, System.currentTimeMillis());
            this.f33341l.b(WorkInfo.State.ENQUEUED, this.f33331b);
            this.f33341l.o(this.f33331b);
            this.f33341l.d(this.f33331b, -1L);
            this.f33340k.B();
        } finally {
            this.f33340k.i();
            i(false);
        }
    }

    /* JADX WARN: Finally extract failed */
    private void i(boolean z10) {
        ListenableWorker listenableWorker;
        this.f33340k.e();
        try {
            if (!this.f33340k.M().k()) {
                d.a(this.f33330a, RescheduleReceiver.class, false);
            }
            if (z10) {
                this.f33341l.b(WorkInfo.State.ENQUEUED, this.f33331b);
                this.f33341l.d(this.f33331b, -1L);
            }
            if (!(this.f33334e == null || (listenableWorker = this.f33335f) == null || !listenableWorker.j())) {
                this.f33339j.b(this.f33331b);
            }
            this.f33340k.B();
            this.f33340k.i();
            this.f33346q.p(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            this.f33340k.i();
            throw th2;
        }
    }

    private void j() {
        WorkInfo.State m10 = this.f33341l.m(this.f33331b);
        if (m10 == WorkInfo.State.RUNNING) {
            k.c().a(f33329t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f33331b), new Throwable[0]);
            i(true);
            return;
        }
        k.c().a(f33329t, String.format("Status for %s is %s; not doing any work", this.f33331b, m10), new Throwable[0]);
        i(false);
    }

    private void k() {
        androidx.work.d b10;
        if (!n()) {
            this.f33340k.e();
            try {
                p n10 = this.f33341l.n(this.f33331b);
                this.f33334e = n10;
                if (n10 == null) {
                    k.c().b(f33329t, String.format("Didn't find WorkSpec for id %s", this.f33331b), new Throwable[0]);
                    i(false);
                    this.f33340k.B();
                } else if (n10.f36690b != WorkInfo.State.ENQUEUED) {
                    j();
                    this.f33340k.B();
                    k.c().a(f33329t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f33334e.f36691c), new Throwable[0]);
                } else {
                    if (n10.d() || this.f33334e.c()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        p pVar = this.f33334e;
                        if (!(pVar.f36702n == 0) && currentTimeMillis < pVar.a()) {
                            k.c().a(f33329t, String.format("Delaying execution for %s because it is being executed before schedule.", this.f33334e.f36691c), new Throwable[0]);
                            i(true);
                            this.f33340k.B();
                            return;
                        }
                    }
                    this.f33340k.B();
                    this.f33340k.i();
                    if (this.f33334e.d()) {
                        b10 = this.f33334e.f36693e;
                    } else {
                        h b11 = this.f33338i.f().b(this.f33334e.f36692d);
                        if (b11 == null) {
                            k.c().b(f33329t, String.format("Could not create Input Merger %s", this.f33334e.f36692d), new Throwable[0]);
                            l();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f33334e.f36693e);
                        arrayList.addAll(this.f33341l.p(this.f33331b));
                        b10 = b11.b(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f33331b), b10, this.f33344o, this.f33333d, this.f33334e.f36699k, this.f33338i.e(), this.f33336g, this.f33338i.m(), new m(this.f33340k, this.f33336g), new l(this.f33340k, this.f33339j, this.f33336g));
                    if (this.f33335f == null) {
                        this.f33335f = this.f33338i.m().b(this.f33330a, this.f33334e.f36691c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f33335f;
                    if (listenableWorker == null) {
                        k.c().b(f33329t, String.format("Could not create Worker %s", this.f33334e.f36691c), new Throwable[0]);
                        l();
                    } else if (listenableWorker.l()) {
                        k.c().b(f33329t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f33334e.f36691c), new Throwable[0]);
                        l();
                    } else {
                        this.f33335f.o();
                        if (!o()) {
                            j();
                        } else if (!n()) {
                            androidx.work.impl.utils.futures.c t10 = androidx.work.impl.utils.futures.c.t();
                            z1.k kVar = new z1.k(this.f33330a, this.f33334e, this.f33335f, workerParameters.b(), this.f33336g);
                            this.f33336g.a().execute(kVar);
                            com.google.common.util.concurrent.j<Void> a10 = kVar.a();
                            a10.a(new a(a10, t10), this.f33336g.a());
                            t10.a(new b(t10, this.f33345p), this.f33336g.c());
                        }
                    }
                }
            } finally {
                this.f33340k.i();
            }
        }
    }

    private void m() {
        this.f33340k.e();
        try {
            this.f33341l.b(WorkInfo.State.SUCCEEDED, this.f33331b);
            this.f33341l.i(this.f33331b, ((ListenableWorker.a.c) this.f33337h).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f33342m.a(this.f33331b)) {
                if (this.f33341l.m(str) == WorkInfo.State.BLOCKED && this.f33342m.b(str)) {
                    k.c().d(f33329t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f33341l.b(WorkInfo.State.ENQUEUED, str);
                    this.f33341l.r(str, currentTimeMillis);
                }
            }
            this.f33340k.B();
        } finally {
            this.f33340k.i();
            i(false);
        }
    }

    private boolean n() {
        if (!this.f33348s) {
            return false;
        }
        k.c().a(f33329t, String.format("Work interrupted for %s", this.f33345p), new Throwable[0]);
        WorkInfo.State m10 = this.f33341l.m(this.f33331b);
        if (m10 == null) {
            i(false);
        } else {
            i(!m10.isFinished());
        }
        return true;
    }

    private boolean o() {
        this.f33340k.e();
        try {
            boolean z10 = true;
            if (this.f33341l.m(this.f33331b) == WorkInfo.State.ENQUEUED) {
                this.f33341l.b(WorkInfo.State.RUNNING, this.f33331b);
                this.f33341l.q(this.f33331b);
            } else {
                z10 = false;
            }
            this.f33340k.B();
            return z10;
        } finally {
            this.f33340k.i();
        }
    }

    public com.google.common.util.concurrent.j<Boolean> b() {
        return this.f33346q;
    }

    public void d() {
        boolean z10;
        this.f33348s = true;
        n();
        com.google.common.util.concurrent.j<ListenableWorker.a> jVar = this.f33347r;
        if (jVar != null) {
            z10 = jVar.isDone();
            this.f33347r.cancel(true);
        } else {
            z10 = false;
        }
        ListenableWorker listenableWorker = this.f33335f;
        if (listenableWorker == null || z10) {
            k.c().a(f33329t, String.format("WorkSpec %s is already done. Not interrupting.", this.f33334e), new Throwable[0]);
        } else {
            listenableWorker.q();
        }
    }

    void f() {
        if (!n()) {
            this.f33340k.e();
            try {
                WorkInfo.State m10 = this.f33341l.m(this.f33331b);
                this.f33340k.L().a(this.f33331b);
                if (m10 == null) {
                    i(false);
                } else if (m10 == WorkInfo.State.RUNNING) {
                    c(this.f33337h);
                } else if (!m10.isFinished()) {
                    g();
                }
                this.f33340k.B();
            } finally {
                this.f33340k.i();
            }
        }
        List<e> list = this.f33332c;
        if (list != null) {
            for (e eVar : list) {
                eVar.d(this.f33331b);
            }
            f.b(this.f33338i, this.f33340k, this.f33332c);
        }
    }

    void l() {
        this.f33340k.e();
        try {
            e(this.f33331b);
            this.f33341l.i(this.f33331b, ((ListenableWorker.a.C0053a) this.f33337h).e());
            this.f33340k.B();
        } finally {
            this.f33340k.i();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> b10 = this.f33343n.b(this.f33331b);
        this.f33344o = b10;
        this.f33345p = a(b10);
        k();
    }
}
