package e5;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import n5.j;
import n5.k;
import u4.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final p4.a f25800a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f25801b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f25802c;

    /* renamed from: d  reason: collision with root package name */
    final h f25803d;

    /* renamed from: e  reason: collision with root package name */
    private final e f25804e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25805f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25806g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25807h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.g<Bitmap> f25808i;

    /* renamed from: j  reason: collision with root package name */
    private a f25809j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25810k;

    /* renamed from: l  reason: collision with root package name */
    private a f25811l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f25812m;

    /* renamed from: n  reason: collision with root package name */
    private q4.g<Bitmap> f25813n;

    /* renamed from: o  reason: collision with root package name */
    private a f25814o;

    /* renamed from: p  reason: collision with root package name */
    private d f25815p;

    /* renamed from: q  reason: collision with root package name */
    private int f25816q;

    /* renamed from: r  reason: collision with root package name */
    private int f25817r;

    /* renamed from: s  reason: collision with root package name */
    private int f25818s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends k5.c<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f25819d;

        /* renamed from: e  reason: collision with root package name */
        final int f25820e;

        /* renamed from: f  reason: collision with root package name */
        private final long f25821f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap f25822g;

        a(Handler handler, int i10, long j10) {
            this.f25819d = handler;
            this.f25820e = i10;
            this.f25821f = j10;
        }

        @Override // k5.i
        public void g(Drawable drawable) {
            this.f25822g = null;
        }

        Bitmap i() {
            return this.f25822g;
        }

        /* renamed from: j */
        public void a(Bitmap bitmap, l5.b<? super Bitmap> bVar) {
            this.f25822g = bitmap;
            this.f25819d.sendMessageAtTime(this.f25819d.obtainMessage(1, this), this.f25821f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                g.this.m((a) message.obj);
                return true;
            } else if (i10 != 2) {
                return false;
            } else {
                g.this.f25803d.m((a) message.obj);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.c cVar, p4.a aVar, int i10, int i11, q4.g<Bitmap> gVar, Bitmap bitmap) {
        this(cVar.f(), com.bumptech.glide.c.u(cVar.h()), aVar, null, i(com.bumptech.glide.c.u(cVar.h()), i10, i11), gVar, bitmap);
    }

    private static q4.b g() {
        return new m5.b(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.g<Bitmap> i(h hVar, int i10, int i11) {
        return hVar.j().a(j5.c.l0(t4.a.f35049a).i0(true).c0(true).T(i10, i11));
    }

    private void l() {
        if (this.f25805f && !this.f25806g) {
            if (this.f25807h) {
                j.a(this.f25814o == null, "Pending target must be null when starting from the first frame");
                this.f25800a.g();
                this.f25807h = false;
            }
            a aVar = this.f25814o;
            if (aVar != null) {
                this.f25814o = null;
                m(aVar);
                return;
            }
            this.f25806g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + this.f25800a.e();
            this.f25800a.b();
            this.f25811l = new a(this.f25801b, this.f25800a.h(), uptimeMillis);
            this.f25808i.a(j5.c.m0(g())).y0(this.f25800a).r0(this.f25811l);
        }
    }

    private void n() {
        Bitmap bitmap = this.f25812m;
        if (bitmap != null) {
            this.f25804e.c(bitmap);
            this.f25812m = null;
        }
    }

    private void p() {
        if (!this.f25805f) {
            this.f25805f = true;
            this.f25810k = false;
            l();
        }
    }

    private void q() {
        this.f25805f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f25802c.clear();
        n();
        q();
        a aVar = this.f25809j;
        if (aVar != null) {
            this.f25803d.m(aVar);
            this.f25809j = null;
        }
        a aVar2 = this.f25811l;
        if (aVar2 != null) {
            this.f25803d.m(aVar2);
            this.f25811l = null;
        }
        a aVar3 = this.f25814o;
        if (aVar3 != null) {
            this.f25803d.m(aVar3);
            this.f25814o = null;
        }
        this.f25800a.clear();
        this.f25810k = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f25800a.c().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.f25809j;
        return aVar != null ? aVar.i() : this.f25812m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.f25809j;
        if (aVar != null) {
            return aVar.f25820e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.f25812m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f25800a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f25818s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f25800a.i() + this.f25816q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f25817r;
    }

    void m(a aVar) {
        d dVar = this.f25815p;
        if (dVar != null) {
            dVar.a();
        }
        this.f25806g = false;
        if (this.f25810k) {
            this.f25801b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f25805f) {
            this.f25814o = aVar;
        } else {
            if (aVar.i() != null) {
                n();
                a aVar2 = this.f25809j;
                this.f25809j = aVar;
                for (int size = this.f25802c.size() - 1; size >= 0; size--) {
                    this.f25802c.get(size).a();
                }
                if (aVar2 != null) {
                    this.f25801b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(q4.g<Bitmap> gVar, Bitmap bitmap) {
        this.f25813n = (q4.g) j.d(gVar);
        this.f25812m = (Bitmap) j.d(bitmap);
        this.f25808i = this.f25808i.a(new j5.c().f0(gVar));
        this.f25816q = k.g(bitmap);
        this.f25817r = bitmap.getWidth();
        this.f25818s = bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(b bVar) {
        if (this.f25810k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f25802c.contains(bVar)) {
            boolean isEmpty = this.f25802c.isEmpty();
            this.f25802c.add(bVar);
            if (isEmpty) {
                p();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(b bVar) {
        this.f25802c.remove(bVar);
        if (this.f25802c.isEmpty()) {
            q();
        }
    }

    g(e eVar, h hVar, p4.a aVar, Handler handler, com.bumptech.glide.g<Bitmap> gVar, q4.g<Bitmap> gVar2, Bitmap bitmap) {
        this.f25802c = new ArrayList();
        this.f25803d = hVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f25804e = eVar;
        this.f25801b = handler;
        this.f25808i = gVar;
        this.f25800a = aVar;
        o(gVar2, bitmap);
    }
}
