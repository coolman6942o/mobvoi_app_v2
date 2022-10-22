package ul;

import cm.d;
import java.util.ArrayList;
import java.util.List;
import km.e;
import km.f;
import km.g;
import zl.a;
import zl.c;
/* loaded from: classes2.dex */
public class b extends a {
    public static cm.a o(c cVar) {
        d f10 = cVar.f();
        int i10 = f10 != null ? f10.f5995a : 0;
        return i10 == 16 ? hm.b.q(cVar) : i10 == 17 ? f10.f6005k >= 6 ? f10.O() ? g.s(cVar) : g.r(cVar) : e.q(cVar) : i10 == 20 ? fm.b.q(cVar) : i10 == 18 ? dm.b.o(cVar) : c.o(cVar);
    }

    public static cm.a p(c cVar) {
        d f10 = cVar.f();
        int i10 = cVar.i();
        int j10 = cVar.j();
        if (i10 == 16) {
            return hm.b.r(cVar);
        }
        if (i10 != 17) {
            return i10 == 20 ? fm.b.r(cVar) : i10 == 18 ? dm.b.p(cVar) : c.p(cVar);
        }
        if (j10 >= 6) {
            return f10.O() ? cVar.m() == 19 ? g.w(cVar) : cVar.m() == 20 ? g.v(cVar) : cVar.m() == 23 ? g.u(cVar) : g.t(cVar) : g.x(cVar);
        }
        if (j10 != 5) {
            return e.r(cVar);
        }
        if (!f10.O()) {
            return f.q(cVar);
        }
        if (cVar.m() == 19) {
            return f.u(cVar);
        }
        cVar.m();
        return f.t(cVar);
    }

    public static cm.a q(c cVar) {
        if (cVar == null) {
            il.b.l("loadParams can not be null");
            return null;
        }
        il.b.j(cVar.toString());
        cm.a o10 = cVar.c() == 1 ? o(cVar) : p(cVar);
        if (o10 != null && o10.f5985h == 4096) {
            o10.f5985h = nl.a.a(cVar.f(), o10);
        }
        return o10;
    }

    public static List<wl.a> r(c cVar) {
        cm.a q5 = q(cVar);
        if (q5 != null && q5.f5985h == 4096) {
            return q5.f5993p;
        }
        return new ArrayList();
    }
}
