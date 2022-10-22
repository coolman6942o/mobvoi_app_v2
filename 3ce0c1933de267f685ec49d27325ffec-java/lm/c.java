package lm;

import android.content.Context;
import android.os.Handler;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: d  reason: collision with root package name */
    public Context f30543d;

    /* renamed from: f  reason: collision with root package name */
    public lm.b f30545f;

    /* renamed from: h  reason: collision with root package name */
    public b f30547h;

    /* renamed from: k  reason: collision with root package name */
    public boolean f30550k;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30540a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30541b = kl.b.f30015a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30542c = kl.b.f30016b;

    /* renamed from: e  reason: collision with root package name */
    public nm.a f30544e = null;

    /* renamed from: g  reason: collision with root package name */
    public int f30546g = 2;

    /* renamed from: i  reason: collision with root package name */
    public Object f30548i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public int f30549j = 0;

    /* renamed from: l  reason: collision with root package name */
    public Handler f30551l = new Handler();

    /* renamed from: m  reason: collision with root package name */
    public Runnable f30552m = new a();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {
        public void a(int i10, int i11) {
        }

        public void b(int i10, Throughput throughput) {
        }

        public void c(DfuProgressInfo dfuProgressInfo) {
        }

        public void d(int i10) {
        }
    }

    public void a(long j10) {
        synchronized (this.f30548i) {
            try {
                if (this.f30542c) {
                    il.b.j("waitSyncLock");
                }
                this.f30548i.wait(j10);
            } catch (InterruptedException e10) {
                il.b.c("wait sync data interrupted: " + e10.toString());
            }
        }
    }

    public boolean b() {
        if (this.f30544e == null) {
            il.b.d(this.f30540a, "dfu has not been initialized");
            f();
        }
        if (this.f30545f == null) {
            il.b.c("mConnectParams == null");
            m(4098);
            return false;
        }
        il.b.j("retry to reconnect device, reconnectTimes =" + this.f30546g);
        return true;
    }

    public boolean c(lm.b bVar) {
        if (this.f30544e == null) {
            il.b.m(this.f30540a, "dfu has not been initialized");
            f();
            return false;
        } else if (bVar == null) {
            il.b.l("ConnectParams can not be null");
            return false;
        } else {
            this.f30545f = bVar;
            this.f30546g = bVar.f();
            il.b.j("mConnectParams:" + this.f30545f.toString());
            return true;
        }
    }

    public void d() {
        this.f30546g = 0;
        Handler handler = this.f30551l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public boolean e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public abstract boolean f();

    public boolean g() {
        return (this.f30549j & 2048) == 2048;
    }

    public boolean h() {
        int i10 = this.f30549j;
        return (i10 & 512) == 512 && i10 != 527;
    }

    public void i(int i10) {
        j(WXMediaMessage.THUMB_LENGTH_LIMIT, i10);
    }

    public void j(int i10, int i11) {
        il.b.j(String.format("onError: 0x%04X", Integer.valueOf(i11)));
        b bVar = this.f30547h;
        if (bVar != null) {
            bVar.a(i10, i11);
        } else {
            il.b.k(this.f30542c, "no callback registered");
        }
    }

    public void k() {
        try {
            synchronized (this.f30548i) {
                this.f30548i.notifyAll();
            }
        } catch (Exception e10) {
            il.b.l(e10.toString());
        }
    }

    public void l(DfuProgressInfo dfuProgressInfo) {
        b bVar = this.f30547h;
        if (bVar != null) {
            bVar.c(dfuProgressInfo);
        } else {
            il.b.k(this.f30542c, "no callback registered");
        }
    }

    public void m(int i10) {
        int i11 = this.f30549j;
        if (i10 != i11) {
            il.b.j(String.format("DFU 0x%04X >> 0x%04X", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
        this.f30549j = i10;
        b bVar = this.f30547h;
        if (bVar != null) {
            bVar.d(i10);
        } else {
            il.b.k(this.f30542c, "no callback registered");
        }
    }

    public void n(int i10, int i11) {
        int i12 = i10 | i11;
        il.b.j(String.format("notifyStateChanged 0x%04X >> 0x%04X", Integer.valueOf(this.f30549j), Integer.valueOf(i12)));
        this.f30549j = i12;
        b bVar = this.f30547h;
        if (bVar != null) {
            bVar.d(i12);
        } else {
            il.b.k(this.f30542c, "no callback registered");
        }
    }
}
