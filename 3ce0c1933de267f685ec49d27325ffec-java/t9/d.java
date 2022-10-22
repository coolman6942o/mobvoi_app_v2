package t9;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskScheduler.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private b f35097a;

    /* renamed from: b  reason: collision with root package name */
    private String f35098b;

    /* renamed from: c  reason: collision with root package name */
    private long f35099c = 10000;

    /* renamed from: d  reason: collision with root package name */
    private boolean f35100d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f35101e = new a();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<c> f35102f = new ArrayList<>();

    /* compiled from: TaskScheduler.java */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes2.dex */
    private class a extends Handler {
        a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                d.this.e((c) message.obj);
            } else if (i10 == 2) {
                d.this.k((Runnable) message.obj);
            } else if (i10 == 3) {
                d.this.g();
            } else if (i10 == 4) {
                d.this.i();
            }
        }
    }

    public d(b bVar, String str) {
        o.e(bVar);
        o.e(str);
        this.f35097a = bVar;
        this.f35098b = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(c cVar) {
        this.f35102f.add(cVar);
        m(cVar.f35094c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f35102f.isEmpty()) {
            if (this.f35100d) {
                k.c("TaskScheduler", "[%s] Tasks empty, cancel check.", this.f35098b);
            }
            this.f35101e.removeMessages(3);
            return;
        }
        Iterator<c> it = this.f35102f.iterator();
        ArrayList arrayList = new ArrayList();
        long j10 = this.f35099c;
        while (it.hasNext()) {
            c next = it.next();
            if (SystemClock.elapsedRealtime() >= next.f35096e) {
                if (this.f35100d) {
                    k.c("TaskScheduler", "[%s] execute task: %s", this.f35098b, next);
                }
                arrayList.add(next.f35093b);
                if (next.f35095d > 0) {
                    next.f35096e = SystemClock.elapsedRealtime() + next.f35095d;
                } else {
                    it.remove();
                    next = null;
                }
            }
            if (next != null) {
                long elapsedRealtime = next.f35096e - SystemClock.elapsedRealtime();
                if (elapsedRealtime < j10) {
                    j10 = elapsedRealtime;
                }
            }
        }
        this.f35101e.removeMessages(3);
        this.f35101e.sendEmptyMessageDelayed(3, j10);
        if (arrayList.size() > 0) {
            this.f35097a.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f35102f.clear();
        this.f35097a.b();
    }

    private boolean j() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Runnable runnable) {
        int i10 = 0;
        while (i10 < this.f35102f.size()) {
            c cVar = this.f35102f.get(i10);
            if (cVar.f35093b.equals(runnable)) {
                if (this.f35100d) {
                    k.c("TaskScheduler", "[%s] task removed: %s", this.f35098b, cVar);
                }
                this.f35102f.remove(i10);
            } else {
                i10++;
            }
        }
    }

    private void m(long j10) {
        long j11 = this.f35099c;
        if (j10 > j11) {
            j10 = j11;
        }
        this.f35101e.sendEmptyMessageDelayed(3, j10);
    }

    private void n(c cVar) {
        if (j()) {
            e(cVar);
        } else {
            this.f35101e.obtainMessage(1, cVar).sendToTarget();
        }
    }

    public void f(Runnable runnable) {
        if (this.f35100d) {
            k.c("TaskScheduler", "[%s] cancel task: %s", this.f35098b, runnable);
        }
        if (j()) {
            k(runnable);
        } else {
            this.f35101e.obtainMessage(2, runnable).sendToTarget();
        }
    }

    public void h() {
        if (this.f35100d) {
            k.c("TaskScheduler", "[%s] clear tasks", this.f35098b);
        }
        if (j()) {
            i();
        } else {
            this.f35101e.sendEmptyMessage(4);
        }
    }

    public void l(Runnable runnable, long j10) {
        c cVar = new c(runnable, j10);
        if (this.f35100d) {
            k.c("TaskScheduler", "[%s] schedule one-off task: %s", this.f35098b, cVar);
        }
        n(cVar);
    }
}
