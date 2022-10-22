package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import j0.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends c<D> {

    /* renamed from: j  reason: collision with root package name */
    private final Executor f3383j;

    /* renamed from: k  reason: collision with root package name */
    volatile a<D>.RunnableC0036a f3384k;

    /* renamed from: l  reason: collision with root package name */
    volatile a<D>.RunnableC0036a f3385l;

    /* renamed from: m  reason: collision with root package name */
    long f3386m;

    /* renamed from: n  reason: collision with root package name */
    long f3387n;

    /* renamed from: o  reason: collision with root package name */
    Handler f3388o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: androidx.loader.content.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0036a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: j  reason: collision with root package name */
        private final CountDownLatch f3389j = new CountDownLatch(1);

        /* renamed from: k  reason: collision with root package name */
        boolean f3390k;

        RunnableC0036a() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void h(D d10) {
            try {
                a.this.B(this, d10);
            } finally {
                this.f3389j.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void i(D d10) {
            try {
                a.this.C(this, d10);
            } finally {
                this.f3389j.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.H();
            } catch (OperationCanceledException e10) {
                if (f()) {
                    return null;
                }
                throw e10;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3390k = false;
            a.this.D();
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.f3369h);
    }

    public void A() {
    }

    void B(a<D>.RunnableC0036a aVar, D d10) {
        G(d10);
        if (this.f3385l == aVar) {
            v();
            this.f3387n = SystemClock.uptimeMillis();
            this.f3385l = null;
            e();
            D();
        }
    }

    void C(a<D>.RunnableC0036a aVar, D d10) {
        if (this.f3384k != aVar) {
            B(aVar, d10);
        } else if (j()) {
            G(d10);
        } else {
            c();
            this.f3387n = SystemClock.uptimeMillis();
            this.f3384k = null;
            f(d10);
        }
    }

    void D() {
        if (this.f3385l == null && this.f3384k != null) {
            if (this.f3384k.f3390k) {
                this.f3384k.f3390k = false;
                this.f3388o.removeCallbacks(this.f3384k);
            }
            if (this.f3386m <= 0 || SystemClock.uptimeMillis() >= this.f3387n + this.f3386m) {
                this.f3384k.c(this.f3383j, null);
                return;
            }
            this.f3384k.f3390k = true;
            this.f3388o.postAtTime(this.f3384k, this.f3387n + this.f3386m);
        }
    }

    public boolean E() {
        return this.f3385l != null;
    }

    public abstract D F();

    public void G(D d10) {
    }

    protected D H() {
        return F();
    }

    @Override // androidx.loader.content.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f3384k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3384k);
            printWriter.print(" waiting=");
            printWriter.println(this.f3384k.f3390k);
        }
        if (this.f3385l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f3385l);
            printWriter.print(" waiting=");
            printWriter.println(this.f3385l.f3390k);
        }
        if (this.f3386m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.f3386m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.f3387n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // androidx.loader.content.c
    protected boolean n() {
        if (this.f3384k == null) {
            return false;
        }
        if (!this.f3404e) {
            this.f3407h = true;
        }
        if (this.f3385l != null) {
            if (this.f3384k.f3390k) {
                this.f3384k.f3390k = false;
                this.f3388o.removeCallbacks(this.f3384k);
            }
            this.f3384k = null;
            return false;
        } else if (this.f3384k.f3390k) {
            this.f3384k.f3390k = false;
            this.f3388o.removeCallbacks(this.f3384k);
            this.f3384k = null;
            return false;
        } else {
            boolean a10 = this.f3384k.a(false);
            if (a10) {
                this.f3385l = this.f3384k;
                A();
            }
            this.f3384k = null;
            return a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.c
    public void p() {
        super.p();
        b();
        this.f3384k = new RunnableC0036a();
        D();
    }

    private a(Context context, Executor executor) {
        super(context);
        this.f3387n = -10000L;
        this.f3383j = executor;
    }
}
