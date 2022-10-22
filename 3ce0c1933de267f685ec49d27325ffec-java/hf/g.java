package hf;

import android.os.Handler;
import com.mobvoi.wear.lpa.LpaConstants;
import ef.r;
import ef.u;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import xe.b;
import zf.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClientQuerier.java */
/* loaded from: classes2.dex */
public class g implements o<n> {

    /* renamed from: a  reason: collision with root package name */
    private final b f27835a;

    /* renamed from: b  reason: collision with root package name */
    private l f27836b;

    /* renamed from: c  reason: collision with root package name */
    private k f27837c;

    /* renamed from: d  reason: collision with root package name */
    private k f27838d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.f27835a = bVar;
    }

    private void d(m mVar, List<u> list) {
        List<u> list2 = mVar.f27846d;
        if (list2 != null) {
            if (list != null) {
                Collections.sort(list, u.J);
            }
            for (u uVar : list2) {
                if ((list == null ? -1 : Collections.binarySearch(list, uVar, u.J)) < 0 && uVar.f25988g) {
                    String str = uVar.f25984c;
                    com.mobvoi.android.common.utils.k.i("fit.sync.query", "Sport %s is not in server anymore, mark as deleted", str);
                    this.f27835a.d(str);
                    this.f27835a.f(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(r rVar, o oVar, Throwable th2) {
        Object[] objArr = new Object[1];
        objArr[0] = rVar == null ? LpaConstants.VALUE_NULL : rVar.b();
        com.mobvoi.android.common.utils.k.i("fit.sync.query", "Load sport details success: %s", objArr);
        if (!(rVar == null || rVar.b() == null)) {
            u b10 = rVar.b();
            if (this.f27835a.l(b10.f25984c)) {
                this.f27835a.j(rVar);
            } else {
                this.f27835a.h(rVar);
            }
            this.f27835a.p(this.f27836b.a(), b10.f25984c, true);
        }
        if (oVar != null) {
            oVar.a(rVar, th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Handler handler, final o oVar, final r rVar, final Throwable th2) {
        handler.post(new Runnable() { // from class: hf.f
            @Override // java.lang.Runnable
            public final void run() {
                g.this.e(rVar, oVar, th2);
            }
        });
    }

    /* renamed from: g */
    public void a(n nVar, Throwable th2) {
        k kVar;
        if (nVar != null) {
            m mVar = nVar.f27847a;
            List<u> list = nVar.f27848b;
            if (list == null) {
                this.f27835a.n();
                d(mVar, null);
                this.f27835a.endBatchEdit();
            } else if (this.f27836b != null) {
                this.f27835a.n();
                d(mVar, list);
                for (u uVar : list) {
                    r rVar = new r(uVar, null);
                    if (this.f27835a.l(uVar.f25984c)) {
                        this.f27835a.j(rVar);
                    } else {
                        this.f27835a.h(rVar);
                    }
                    this.f27835a.p(this.f27836b.a(), uVar.f25984c, true);
                }
                this.f27835a.endBatchEdit();
                if (list.size() == 0) {
                    this.f27835a.a();
                }
            }
        } else if (th2 != null && (kVar = this.f27838d) != null) {
            kVar.a(th2);
        }
    }

    public void h(String str, final o<r> oVar) {
        k kVar;
        r m10 = this.f27835a.m(str);
        if ((m10 == null || m10.a().f() == 0) && (kVar = this.f27837c) != null && kVar.isConnected()) {
            final Handler handler = new Handler();
            this.f27837c.c(str, new o() { // from class: hf.e
                @Override // hf.o
                public final void a(Object obj, Throwable th2) {
                    g.this.f(handler, oVar, (r) obj, th2);
                }
            });
        } else if (oVar != null) {
            oVar.a(m10, null);
        }
    }

    public void i(Date date, Date date2, int i10) {
        List<u> g10 = this.f27835a.g(date, date2, i10);
        l lVar = this.f27836b;
        if (lVar != null && lVar.isConnected()) {
            m mVar = new m(date, date2, i10);
            mVar.f27846d = this.f27835a.g(mVar.f27843a, mVar.f27844b, mVar.f27845c);
            this.f27836b.f(mVar);
        } else if (!g10.isEmpty()) {
            this.f27835a.a();
        }
    }

    public void j(k kVar) {
        if (this.f27837c != kVar) {
            this.f27837c = kVar;
        }
    }

    public void k(l lVar) {
        l lVar2 = this.f27836b;
        if (lVar2 != lVar) {
            if (lVar2 != null) {
                lVar2.h(null);
            }
            this.f27836b = lVar;
            lVar.h(this);
        }
    }

    public void l(k kVar) {
        this.f27838d = kVar;
    }
}
