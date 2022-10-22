package ve;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import bf.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.SportType;
import ef.q;
import ef.r;
import ef.u;
import hf.h;
import hf.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import jf.g;
/* compiled from: SportStorage.java */
/* loaded from: classes2.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private h f35758a;

    /* renamed from: b  reason: collision with root package name */
    private g f35759b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Looper f35760c;

    /* renamed from: d  reason: collision with root package name */
    private c f35761d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f35762e;

    /* renamed from: f  reason: collision with root package name */
    private nf.c<Collection<u>> f35763f;

    /* compiled from: SportStorage.java */
    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Date f35764a;

        /* renamed from: b  reason: collision with root package name */
        public final Date f35765b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35766c;

        private b(Date date, Date date2, int i10) {
            this.f35764a = date;
            this.f35765b = date2;
            this.f35766c = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SportStorage.java */
    /* loaded from: classes2.dex */
    public static final class c extends Handler {

        /* renamed from: d  reason: collision with root package name */
        private static final Comparator<r> f35767d = m.f35771a;

        /* renamed from: a  reason: collision with root package name */
        private final xe.b f35768a;

        /* renamed from: b  reason: collision with root package name */
        private final h f35769b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<r> f35770c;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int c(r rVar, r rVar2) {
            if (rVar.b() == null || rVar2.b() == null) {
                return 0;
            }
            return rVar.b().f25984c.compareTo(rVar2.b().f25984c);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList<r> arrayList;
            int i10 = message.what;
            if (i10 == 1) {
                k.h("fit.data.storage", "Clear all records");
                this.f35768a.q();
            } else if (i10 == 2) {
                String str = (String) message.obj;
                k.i("fit.data.storage", "Delelte Record: %s", str);
                this.f35769b.e(str);
            } else if (i10 == 3) {
                b bVar = (b) message.obj;
                this.f35769b.m(bVar.f35764a, bVar.f35765b, bVar.f35766c);
            } else if (i10 == 4) {
                k.h("fit.data.storage", "Start a sync");
                this.f35769b.n();
                removeMessages(4);
            } else if (i10 == 7) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                synchronized (this.f35770c) {
                    arrayList = new ArrayList(this.f35770c);
                    this.f35770c.clear();
                }
                this.f35768a.n();
                for (r rVar : arrayList) {
                    if (this.f35768a.l(rVar.b().f25984c)) {
                        this.f35768a.j(rVar);
                    } else {
                        this.f35768a.h(rVar);
                    }
                }
                this.f35768a.endBatchEdit();
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (elapsedRealtime2 > 1000) {
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    for (r rVar2 : arrayList) {
                        arrayList2.add(rVar2.b().f25984c);
                    }
                    k.s("fit.data.storage", "Insert or update %d records for %d ms, larger than 1s! records:\n%s", Integer.valueOf(arrayList.size()), Long.valueOf(elapsedRealtime2), arrayList2);
                }
            }
        }

        private c(Looper looper, xe.b bVar, h hVar) {
            super(looper);
            this.f35770c = new TreeSet(f35767d);
            this.f35768a = bVar;
            this.f35769b = hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(o oVar, boolean z10) {
        oVar.a(Boolean.valueOf(z10), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(final o oVar) {
        final boolean n10 = this.f35758a.n();
        if (oVar != null) {
            this.f35762e.post(new Runnable() { // from class: ve.e
                @Override // java.lang.Runnable
                public final void run() {
                    l.A(o.this, n10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            if (uVar.h()) {
                arrayList.add(new u(uVar));
            }
        }
        H(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(nf.h hVar, final Collection collection) {
        q().post(new Runnable() { // from class: ve.i
            @Override // java.lang.Runnable
            public final void run() {
                l.this.C(collection);
            }
        });
    }

    private void H(final List<u> list) {
        this.f35762e.post(new Runnable() { // from class: ve.j
            @Override // java.lang.Runnable
            public final void run() {
                l.this.z(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(o oVar, r rVar, Throwable th2) {
        oVar.a(rVar == null ? null : rVar.a(), th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(final o oVar, final r rVar, final Throwable th2) {
        this.f35762e.post(new Runnable() { // from class: ve.c
            @Override // java.lang.Runnable
            public final void run() {
                l.u(o.this, rVar, th2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(String str, o oVar) {
        this.f35758a.l(str, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str, Date date, Date date2, int i10, final o oVar) {
        final List<u> list;
        if (TextUtils.isEmpty(str)) {
            list = p().g(date, date2, i10);
        } else {
            list = p().e(date, date2, i10, str);
        }
        if (oVar != null) {
            this.f35762e.post(new Runnable() { // from class: ve.d
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a(list, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(List list) {
        this.f35763f.f(list);
    }

    public void E(final String str, final o<q> oVar) {
        final o aVar = oVar == null ? null : new o() { // from class: ve.a
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                l.this.v(oVar, (r) obj, th2);
            }
        };
        q().post(new Runnable() { // from class: ve.g
            @Override // java.lang.Runnable
            public final void run() {
                l.this.w(str, aVar);
            }
        });
    }

    public void F(Date date, Date date2, int i10) {
        q().obtainMessage(3, new b(date, date2, i10)).sendToTarget();
    }

    public void G(final Date date, final Date date2, final int i10, final String str, final o<Collection<u>> oVar) {
        q().post(new Runnable() { // from class: ve.h
            @Override // java.lang.Runnable
            public final void run() {
                l.this.y(str, date, date2, i10, oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(Throwable th2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(Context context) {
        this.f35762e = new Handler(Looper.getMainLooper());
        h l10 = l(context);
        this.f35758a = l10;
        l10.a();
        this.f35758a.o(new zf.k() { // from class: ve.b
            @Override // zf.k
            public final void a(Throwable th2) {
                l.this.I(th2);
            }
        });
        g m10 = m(context);
        this.f35759b = m10;
        m10.c();
        new f(context);
    }

    public void K() {
        q().removeMessages(4);
        q().sendEmptyMessage(4);
    }

    public void L(final o<Boolean> oVar) {
        q().post(new Runnable() { // from class: ve.f
            @Override // java.lang.Runnable
            public final void run() {
                l.this.B(oVar);
            }
        });
    }

    public void M(long j10) {
        q().removeMessages(4);
        q().sendEmptyMessageDelayed(4, j10);
    }

    public nf.h<Collection<u>> N() {
        if (this.f35763f == null) {
            this.f35763f = new nf.c<>();
            this.f35758a.p().a(new nf.k() { // from class: ve.k
                @Override // nf.k
                public final void i(nf.h hVar, Object obj) {
                    l.this.D(hVar, (Collection) obj);
                }
            });
        }
        return this.f35763f;
    }

    public void k() {
        q().removeMessages(1);
        q().sendEmptyMessage(1);
    }

    protected abstract h l(Context context);

    protected abstract g m(Context context);

    public void n(String str) {
        q().obtainMessage(2, str).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h o() {
        return this.f35758a;
    }

    protected abstract xe.b p();

    public Handler q() {
        if (this.f35761d == null) {
            this.f35761d = new c(r(), p(), this.f35758a);
        }
        return this.f35761d;
    }

    public Looper r() {
        if (this.f35760c == null) {
            synchronized (this) {
                if (this.f35760c == null) {
                    HandlerThread handlerThread = new HandlerThread("Storage Worker", 10);
                    handlerThread.start();
                    this.f35760c = handlerThread.getLooper();
                }
            }
        }
        return this.f35760c;
    }

    public void s(r rVar) {
        if (rVar.b() == null) {
            k.q("fit.data.storage", "Cannot insert or update record without summary");
        } else if (rVar.b().f25985d == SportType.Unknown) {
            k.q("fit.data.storage", "Unknown Sport cannot be save!");
        } else {
            r rVar2 = new r(rVar);
            q().removeMessages(7);
            synchronized (this.f35761d.f35770c) {
                this.f35761d.f35770c.remove(rVar2);
                this.f35761d.f35770c.add(rVar2);
            }
            q().sendEmptyMessage(7);
        }
    }

    public void t(r rVar) {
        s(rVar);
    }
}
