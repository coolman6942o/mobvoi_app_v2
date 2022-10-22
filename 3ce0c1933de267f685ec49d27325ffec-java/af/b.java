package af;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.LocationUtil;
import ef.o;
import eg.j;
import java.util.Collection;
/* compiled from: PathFilter.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f203d = false;

    /* renamed from: a  reason: collision with root package name */
    private final a f204a = new a(20.0f);

    /* renamed from: b  reason: collision with root package name */
    private final a f205b = new a(8.0f);

    /* renamed from: c  reason: collision with root package name */
    private boolean f206c = false;

    public b() {
        d();
    }

    private double a(o oVar, o oVar2) {
        return LocationUtil.getDistance(oVar2.f25947d, oVar2.f25946c, oVar.f25947d, oVar.f25946c);
    }

    private boolean b(long j10) {
        return this.f204a.d() || j10 - this.f204a.f().f25945b > 15000;
    }

    private boolean c(o oVar, Collection<o> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        double[] dArr = new double[collection.size()];
        o oVar2 = null;
        int i10 = 0;
        for (o oVar3 : collection) {
            if (oVar2 == null) {
                dArr[i10] = oVar3.f25949f;
            } else {
                dArr[i10] = a(oVar2, oVar3) / ((oVar3.f25945b - oVar2.f25945b) / 1000.0d);
            }
            i10++;
            oVar2 = oVar3;
        }
        j jVar = new j(dArr);
        double a10 = a(oVar2, oVar) / ((oVar.f25945b - oVar2.f25945b) / 1000.0d);
        return jVar.a() == 0.0d || a10 < 10.0d || f(a10, jVar.a(), jVar.b());
    }

    private boolean f(double d10, double d11, double d12) {
        double d13 = d12 * 2.0d;
        return Math.abs(d11) - d13 < Math.abs(d10) && Math.abs(d10) < Math.abs(d11) + d13;
    }

    public void d() {
        this.f204a.a();
        this.f205b.a();
        this.f206c = true;
    }

    public boolean e(o oVar) {
        if (oVar == null || !oVar.a()) {
            k.c("fit.core.loc.filter", "Skip invalid location %s", oVar);
            return false;
        }
        boolean b10 = b(oVar.f25945b);
        if (!b10 || oVar.f25948e <= 100.0f) {
            if (b10 && !this.f204a.d()) {
                k.a("fit.core.loc.filter", "GPS lost, reset valid queue.");
                this.f204a.a();
            }
            boolean z10 = !this.f204a.d() && c(oVar, this.f204a.c());
            boolean z11 = this.f205b.e() && c(oVar, this.f205b.c());
            if ((!f203d || !this.f206c) && !z10 && !z11) {
                k.c("fit.core.loc.filter", "Skip out stand location %s", oVar);
                this.f205b.b(oVar);
                return false;
            }
            this.f206c = false;
            this.f204a.b(oVar);
            this.f205b.a();
            return true;
        }
        k.c("fit.core.loc.filter", "Skip accuracy > %d before locked: %s", 100, oVar);
        return false;
    }
}
