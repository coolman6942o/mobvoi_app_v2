package qi;

import android.app.Application;
import com.mobvoi.mcuwatch.ui.card.a0;
import com.mobvoi.mcuwatch.ui.pair.qrscan.ScanQrActivity;
import ei.e;
import gn.z;
import nj.q;
import pc.g;
import rk.a;
/* compiled from: TicWatchLiteMcuDeviceManager.java */
/* loaded from: classes2.dex */
public class k extends j {
    public k(Application application) {
        super(application);
    }

    @Override // qi.j, qk.a
    public a b() {
        if (q.g().l() == 5) {
            return e.x().y();
        }
        return super.b();
    }

    @Override // qk.a
    public Class<?> c() {
        if (!e()) {
            return null;
        }
        int l10 = q.g().l();
        if (l10 != 1) {
            if (l10 == 2 || l10 == 3) {
                z.v(this.f33171d.getApplicationContext()).m0(1);
                return a0.class;
            } else if (!(l10 == 4 || l10 == 6 || l10 == 7)) {
                return a0.class;
            }
        }
        z.v(this.f33171d.getApplicationContext()).m0(2);
        return a0.class;
    }

    @Override // qk.a
    public boolean e() {
        if (this.f33168a.isEmpty() || this.f33168a.get(0) == null || !(this.f33168a.get(0) instanceof g)) {
            return false;
        }
        return q.g().q(((g) this.f33168a.get(0)).f32754c);
    }

    @Override // qk.a
    public void f(int i10) {
        q.g().B(i10);
        ScanQrActivity.start(this.f33171d);
    }

    @Override // qk.a
    public String getDeviceType() {
        return "ticlite_mcu";
    }

    @Override // qi.j
    public void s(Application application) {
        if (!this.f33170c) {
            super.s(application);
        }
    }
}
