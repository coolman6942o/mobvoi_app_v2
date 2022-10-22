package k9;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import k9.a;
import r9.d;
import r9.e;
/* compiled from: RemitDatabase.java */
/* loaded from: classes2.dex */
public class c implements k9.a {

    /* renamed from: c  reason: collision with root package name */
    private Handler f29812c;

    /* renamed from: g  reason: collision with root package name */
    private volatile Thread f29816g;

    /* renamed from: e  reason: collision with root package name */
    private final List<Integer> f29814e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private AtomicInteger f29815f = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final b f29810a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final d f29811b = new d();

    /* renamed from: d  reason: collision with root package name */
    private final long f29813d = d.a().f33471b;

    /* compiled from: RemitDatabase.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                if (c.this.f29816g != null) {
                    LockSupport.unpark(c.this.f29816g);
                    c.this.f29816g = null;
                }
                return false;
            }
            try {
                c.this.f29815f.set(i10);
                c.this.y(i10);
                c.this.f29814e.add(Integer.valueOf(i10));
                return false;
            } finally {
                c.this.f29815f.set(0);
                if (c.this.f29816g != null) {
                    LockSupport.unpark(c.this.f29816g);
                    c.this.f29816g = null;
                }
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(e.A("RemitHandoverToDB"));
        handlerThread.start();
        this.f29812c = new Handler(handlerThread.getLooper(), new a());
    }

    private void w(int i10) {
        this.f29812c.removeMessages(i10);
        if (this.f29815f.get() == i10) {
            this.f29816g = Thread.currentThread();
            this.f29812c.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        y(i10);
    }

    private boolean x(int i10) {
        return !this.f29814e.contains(Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i10) {
        if (r9.c.f33469a) {
            r9.c.a(this, "sync cache to db %d", Integer.valueOf(i10));
        }
        this.f29811b.j(this.f29810a.o(i10));
        List<o9.a> n10 = this.f29810a.n(i10);
        this.f29811b.h(i10);
        for (o9.a aVar : n10) {
            this.f29811b.b(aVar);
        }
    }

    @Override // k9.a
    public void a(int i10) {
        this.f29810a.a(i10);
        if (!x(i10)) {
            this.f29811b.a(i10);
        }
    }

    @Override // k9.a
    public void b(o9.a aVar) {
        this.f29810a.b(aVar);
        if (!x(aVar.c())) {
            this.f29811b.b(aVar);
        }
    }

    @Override // k9.a
    public a.AbstractC0365a c() {
        d dVar = this.f29811b;
        b bVar = this.f29810a;
        return dVar.v(bVar.f29807a, bVar.f29808b);
    }

    @Override // k9.a
    public void clear() {
        this.f29810a.clear();
        this.f29811b.clear();
    }

    @Override // k9.a
    public void d(int i10, Throwable th2) {
        this.f29810a.d(i10, th2);
        if (!x(i10)) {
            this.f29811b.d(i10, th2);
        }
    }

    @Override // k9.a
    public void e(int i10, long j10) {
        this.f29810a.e(i10, j10);
        if (x(i10)) {
            this.f29812c.removeMessages(i10);
            if (this.f29815f.get() == i10) {
                this.f29816g = Thread.currentThread();
                this.f29812c.sendEmptyMessage(0);
                LockSupport.park();
                this.f29811b.e(i10, j10);
            }
        } else {
            this.f29811b.e(i10, j10);
        }
        this.f29814e.remove(Integer.valueOf(i10));
    }

    @Override // k9.a
    public void f(int i10, String str, long j10, long j11, int i11) {
        this.f29810a.f(i10, str, j10, j11, i11);
        if (!x(i10)) {
            this.f29811b.f(i10, str, j10, j11, i11);
        }
    }

    @Override // k9.a
    public void g(int i10, int i11, long j10) {
        this.f29810a.g(i10, i11, j10);
        if (!x(i10)) {
            this.f29811b.g(i10, i11, j10);
        }
    }

    @Override // k9.a
    public void h(int i10) {
        this.f29810a.h(i10);
        if (!x(i10)) {
            this.f29811b.h(i10);
        }
    }

    @Override // k9.a
    public void i(int i10) {
        this.f29812c.sendEmptyMessageDelayed(i10, this.f29813d);
    }

    @Override // k9.a
    public void j(FileDownloadModel fileDownloadModel) {
        this.f29810a.j(fileDownloadModel);
        if (!x(fileDownloadModel.e())) {
            this.f29811b.j(fileDownloadModel);
        }
    }

    @Override // k9.a
    public void k(int i10, Throwable th2, long j10) {
        this.f29810a.k(i10, th2, j10);
        if (x(i10)) {
            w(i10);
        }
        this.f29811b.k(i10, th2, j10);
        this.f29814e.remove(Integer.valueOf(i10));
    }

    @Override // k9.a
    public void l(int i10, long j10) {
        this.f29810a.l(i10, j10);
        if (!x(i10)) {
            this.f29811b.l(i10, j10);
        }
    }

    @Override // k9.a
    public void m(int i10, long j10, String str, String str2) {
        this.f29810a.m(i10, j10, str, str2);
        if (!x(i10)) {
            this.f29811b.m(i10, j10, str, str2);
        }
    }

    @Override // k9.a
    public List<o9.a> n(int i10) {
        return this.f29810a.n(i10);
    }

    @Override // k9.a
    public FileDownloadModel o(int i10) {
        return this.f29810a.o(i10);
    }

    @Override // k9.a
    public void p(int i10, int i11) {
        this.f29810a.p(i10, i11);
        if (!x(i10)) {
            this.f29811b.p(i10, i11);
        }
    }

    @Override // k9.a
    public void q(int i10, long j10) {
        this.f29810a.q(i10, j10);
        if (x(i10)) {
            w(i10);
        }
        this.f29811b.q(i10, j10);
        this.f29814e.remove(Integer.valueOf(i10));
    }

    @Override // k9.a
    public boolean remove(int i10) {
        this.f29811b.remove(i10);
        return this.f29810a.remove(i10);
    }
}
