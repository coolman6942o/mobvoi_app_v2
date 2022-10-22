package g0;

import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f27184a;

    /* renamed from: b  reason: collision with root package name */
    private a f27185b;

    /* renamed from: c  reason: collision with root package name */
    private Object f27186c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27187d;

    /* compiled from: CancellationSignal.java */
    /* loaded from: classes.dex */
    public interface a {
        void onCancel();
    }

    private void f() {
        while (this.f27187d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (!this.f27184a) {
                this.f27184a = true;
                this.f27187d = true;
                a aVar = this.f27185b;
                Object obj = this.f27186c;
                if (aVar != null) {
                    try {
                        aVar.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.f27187d = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null && Build.VERSION.SDK_INT >= 16) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f27187d = false;
                    notifyAll();
                }
            }
        }
    }

    public Object b() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f27186c == null) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.f27186c = cancellationSignal;
                if (this.f27184a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.f27186c;
        }
        return obj;
    }

    public boolean c() {
        boolean z10;
        synchronized (this) {
            z10 = this.f27184a;
        }
        return z10;
    }

    public void d(a aVar) {
        synchronized (this) {
            f();
            if (this.f27185b != aVar) {
                this.f27185b = aVar;
                if (this.f27184a && aVar != null) {
                    aVar.onCancel();
                }
            }
        }
    }

    public void e() {
        if (c()) {
            throw new OperationCanceledException();
        }
    }
}
