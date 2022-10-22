package mj;

import cn.s;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.bean.SportControlBean;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.p;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.ticwear.youngwatch.data.b;
import gn.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mj.j;
import nj.j;
/* compiled from: WorkoutPresenter.java */
/* loaded from: classes2.dex */
public class n implements p {

    /* renamed from: j  reason: collision with root package name */
    private static final String f30825j = "n";

    /* renamed from: a  reason: collision with root package name */
    j f30826a;

    /* renamed from: b  reason: collision with root package name */
    private int f30827b;

    /* renamed from: g  reason: collision with root package name */
    private mj.a f30832g;

    /* renamed from: h  reason: collision with root package name */
    private int f30833h;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30829d = false;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<b> f30831f = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    TimerTask f30834i = new a();

    /* renamed from: c  reason: collision with root package name */
    private Timer f30828c = new Timer();

    /* renamed from: e  reason: collision with root package name */
    private final SportControlBean f30830e = new SportControlBean();

    /* compiled from: WorkoutPresenter.java */
    /* loaded from: classes2.dex */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (n.this.f30833h == 2) {
                n.this.f30830e.f19133b++;
                n.this.f30830e.f19135d = j.b(n.this.f30830e.f19132a, n.this.f30830e.f19133b);
                n.this.f30830e.f19138g = j.a(n.this.f30830e.f19132a, n.this.f30830e.f19133b);
                n nVar = n.this;
                nVar.f30826a.j(nVar.f30830e.f19133b);
                n.this.f30832g.r(n.this.f30830e);
            }
        }
    }

    public n(j jVar, mj.a aVar) {
        this.f30832g = aVar;
        this.f30826a = jVar;
        jVar.l(new j.a() { // from class: mj.m
            @Override // mj.j.a
            public final void a(float f10, double d10) {
                n.this.k(f10, d10);
            }
        });
    }

    private void g() {
        Timer timer = this.f30828c;
        if (timer != null) {
            timer.cancel();
            this.f30828c.purge();
            this.f30828c = null;
        }
        this.f30829d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i10, boolean z10) {
        Iterator<b> it = this.f30831f.iterator();
        while (it.hasNext()) {
            it.next().a(i10);
        }
        r(i10, this.f30830e, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i10) {
        Iterator<b> it = this.f30831f.iterator();
        while (it.hasNext()) {
            it.next().d(i10);
        }
        s(i10);
    }

    private void u(SportControlBean sportControlBean) {
        int i10 = this.f30833h;
        if (i10 == 1) {
            u uVar = u.f19202a;
            uVar.j0(this);
            b.c().b();
            f.A(uVar, true, this.f30827b, 1);
        } else if (i10 == 2) {
            h(33, sportControlBean);
        } else if (i10 == 3) {
            h(22, sportControlBean);
        } else if (i10 == 4) {
            f.A(u.f19202a, false, this.f30827b, 1);
        }
    }

    @Override // com.mobvoi.mcuwatch.engine.p
    public void a(int i10, cn.u uVar) {
        String str = f30825j;
        k.h(str, " onGetSportsModesInfo switchStatus = " + i10 + " mSportStatus = " + this.f30833h);
        if (i10 == 2 && this.f30833h != 3) {
            i(3, false);
        } else if (i10 == 3 && this.f30833h != 2) {
            i(2, false);
        } else if (i10 == 0 && this.f30833h != 4) {
            i(4, false);
        }
        if (uVar != null) {
            this.f30830e.f19136e = uVar.k();
            this.f30830e.f19137f = uVar.g();
        }
    }

    public void h(int i10, SportControlBean sportControlBean) {
        f.b(u.f19202a, new s(i10, sportControlBean.f19133b, (float) sportControlBean.f19132a, (int) sportControlBean.f19134c, sportControlBean.f19135d, true, true));
    }

    public void i(final int i10, final boolean z10) {
        if (this.f30832g.a(i10)) {
            this.f30832g.getHandler().post(new Runnable() { // from class: mj.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.m(i10, z10);
                }
            });
        }
    }

    public void j(final int i10) {
        this.f30832g.getHandler().post(new Runnable() { // from class: mj.k
            @Override // java.lang.Runnable
            public final void run() {
                n.this.n(i10);
            }
        });
    }

    public void k(float f10, double d10) {
        SportControlBean sportControlBean = this.f30830e;
        sportControlBean.f19132a = f10;
        sportControlBean.f19139h = d10;
        int i10 = this.f30827b;
        int i11 = 2;
        if (i10 == 1) {
            i11 = 1;
        } else if (i10 != 2) {
            i11 = 0;
        }
        sportControlBean.f19134c = y.h(com.mobvoi.android.common.utils.b.e()).c((int) f10, i11);
    }

    public int l() {
        return this.f30833h;
    }

    public void o() {
        this.f30826a.f();
        g();
        v();
        this.f30832g = null;
    }

    public void p() {
        this.f30826a.g();
    }

    public void q() {
        this.f30826a.h();
    }

    public void r(int i10, SportControlBean sportControlBean, boolean z10) {
        String str = f30825j;
        k.h(str, " changeSportControlStatus sportStatus = " + i10);
        this.f30833h = i10;
        this.f30826a.i(i10);
        int i11 = this.f30833h;
        if (i11 == 2) {
            if (!this.f30829d) {
                if (this.f30828c == null) {
                    this.f30828c = new Timer();
                }
                try {
                    this.f30828c.schedule(this.f30834i, 0L, 1000L);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                this.f30829d = true;
            }
        } else if (i11 == 4) {
            u.f19202a.j0(null);
            g();
            if (this.f30830e.f19132a < 100.0d) {
                this.f30832g.j();
            }
        }
        if (z10) {
            u(sportControlBean);
        }
    }

    public void s(int i10) {
        if (i10 == 0) {
            this.f30827b = 1;
        } else if (i10 == 1) {
            this.f30827b = 9;
        } else if (i10 == 2) {
            this.f30827b = 2;
        }
        this.f30826a.k(this.f30827b);
    }

    public void t(List<b> list) {
        if (this.f30831f != null) {
            for (b bVar : list) {
                if (!this.f30831f.contains(bVar)) {
                    this.f30831f.add(bVar);
                }
            }
        }
    }

    public void v() {
        this.f30831f.clear();
    }
}
