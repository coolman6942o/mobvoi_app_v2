package xe;

import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.fitness.core.data.pojo.SessionMode;
import com.mobvoi.health.common.data.pojo.SportType;
import ef.o;
import ef.p;
import ef.u;
import ye.b;
/* compiled from: DataTranslator.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(int i10, int i11) {
        return i10 & (~i11);
    }

    public static int b(String str) {
        str.hashCode();
        if (!str.equals(Module.MAIN)) {
            return !str.equals("peer") ? 0 : 2;
        }
        return 1;
    }

    public static int c(int i10, int i11) {
        return i10 | i11;
    }

    public static p d(ye.a aVar) {
        p pVar = new p();
        pVar.f25951a = aVar.q();
        pVar.f25952b = aVar.r();
        pVar.f25953c = aVar.c().intValue();
        pVar.f25954d = aVar.k().floatValue();
        pVar.f25955e = aVar.e().intValue();
        pVar.f25956f = aVar.l().intValue();
        pVar.f25962l = aVar.b().floatValue();
        pVar.f25973w = new o();
        if (aVar.j() != null) {
            pVar.f25963m = aVar.j().booleanValue();
        }
        if (aVar.o() != null) {
            pVar.f25964n = aVar.o().floatValue();
        }
        if (aVar.n() != null) {
            pVar.f25965o = aVar.n().intValue();
        }
        if (aVar.p() != null) {
            pVar.f25966p = aVar.p().intValue();
        }
        if (aVar.d() != null) {
            pVar.f25957g = aVar.d().floatValue();
        }
        pVar.f25973w.f25947d = aVar.g();
        pVar.f25973w.f25946c = aVar.h();
        pVar.f25973w.f25948e = aVar.a();
        float f10 = pVar.f25964n;
        if (f10 > 0.0f) {
            pVar.f25967q = (int) f10;
            pVar.f25969s = pVar.f25966p;
            pVar.f25968r = pVar.f25965o;
        }
        return pVar;
    }

    public static u e(b bVar) {
        u uVar = null;
        if (bVar == null) {
            return null;
        }
        String l10 = bVar.l();
        if (l10 != null && !l10.equals("")) {
            uVar = new u(l10);
            uVar.f25985d = SportType.from(bVar.C());
            Integer r10 = bVar.r();
            if (r10 == null) {
                r10 = -1;
            }
            uVar.D = SessionMode.from(r10.intValue());
            uVar.f25986e = bVar.A().floatValue();
            Integer z10 = bVar.z();
            boolean z11 = false;
            if (z10 == null) {
                z10 = 0;
            }
            uVar.f25987f = ef.b.c(z10.intValue());
            if ((bVar.y() & 1) != 0) {
                z11 = true;
            }
            uVar.f25988g = z11;
            if (bVar.s() != null) {
                uVar.f25989h = bVar.s().longValue();
            }
            if (bVar.i() != null) {
                uVar.f25990i = bVar.i().longValue();
            }
            uVar.f25991j = bVar.h();
            if (bVar.g() != null) {
                uVar.f25992k = bVar.g().intValue();
            }
            if (bVar.b() != null) {
                uVar.f25993l = bVar.b().floatValue();
            }
            if (bVar.m() != null) {
                uVar.f25994m = bVar.m().intValue();
            }
            if (bVar.t() != null) {
                uVar.f25995n = bVar.t().intValue();
            }
            uVar.f25982a = bVar.a();
            uVar.f25983b = bVar.f();
            if (bVar.u() != null) {
                uVar.f26006y = bVar.u().intValue();
            }
            if (bVar.v() != null) {
                uVar.A = bVar.v().intValue();
            }
            if (bVar.x() != null) {
                uVar.B = bVar.x().floatValue();
            }
            if (bVar.w() != null) {
                uVar.C = bVar.w().intValue();
            }
            if (bVar.o() != null) {
                uVar.f25997p = bVar.o().floatValue();
            }
            if (bVar.p() != null) {
                uVar.f25998q = bVar.p().floatValue();
            }
            if (bVar.d() != null) {
                uVar.f25999r = bVar.d().floatValue();
            }
            if (bVar.c() != null) {
                uVar.f26000s = bVar.c().floatValue();
            }
            if (bVar.q() != null) {
                uVar.f26001t = bVar.q().floatValue();
            }
            if (!uVar.f25985d.isSwimming()) {
                int i10 = uVar.f26006y;
                if (i10 > 0) {
                    uVar.f26004w = i10;
                    uVar.f26005x = uVar.A;
                    uVar.f26003v = uVar.C;
                }
                float f10 = uVar.B;
                if (f10 >= 0.0f) {
                    uVar.f26002u = f10;
                }
            }
            if (uVar.f25985d.isCountType()) {
                uVar.H = (int) uVar.f26001t;
            }
            if (bVar.j() != null) {
                uVar.G = bVar.j();
            }
            uVar.f26007z.clear();
            uVar.f26007z.addAll(u.k(bVar.k()));
        }
        return uVar;
    }

    public static ye.a f(ye.a aVar, p pVar) {
        int i10;
        aVar.J(pVar.f25951a);
        aVar.K(pVar.f25952b);
        aVar.v(Integer.valueOf(pVar.f25953c));
        aVar.D(Float.valueOf(pVar.f25954d));
        aVar.x(Integer.valueOf(pVar.f25955e));
        aVar.E(Integer.valueOf(pVar.f25956f));
        aVar.t(Float.valueOf(pVar.f25962l));
        aVar.C(Boolean.valueOf(pVar.f25963m));
        aVar.H(Float.valueOf(pVar.f25964n));
        aVar.G(Integer.valueOf(pVar.f25965o));
        aVar.I(Integer.valueOf(pVar.f25966p));
        aVar.w(Float.valueOf(pVar.f25957g));
        o oVar = pVar.f25973w;
        if (oVar != null) {
            aVar.z(oVar.f25947d);
            aVar.A(pVar.f25973w.f25946c);
            aVar.s(pVar.f25973w.f25948e);
        } else {
            aVar.s(-1.0f);
        }
        if (pVar.f25964n <= 0.0f && (i10 = pVar.f25967q) > 0) {
            aVar.H(Float.valueOf(i10));
            aVar.G(Integer.valueOf(pVar.f25968r));
            aVar.I(Integer.valueOf(pVar.f25969s));
        }
        return aVar;
    }

    public static ye.a g(b bVar, p pVar) {
        ye.a aVar = new ye.a();
        aVar.u(bVar);
        return f(aVar, pVar);
    }

    public static b h(u uVar) {
        return i(null, uVar);
    }

    public static b i(b bVar, u uVar) {
        if (uVar == null) {
            return bVar;
        }
        String str = uVar.f25984c;
        if (str != null && !str.equals("")) {
            if (bVar == null) {
                bVar = new b();
            }
            bVar.O(uVar.f25984c);
            bVar.f0(uVar.f25985d.typeCode);
            SessionMode sessionMode = uVar.D;
            bVar.U(Integer.valueOf(sessionMode != null ? sessionMode.typeCode : -1));
            bVar.c0(Integer.valueOf(ef.b.b(uVar.f25987f)));
            bVar.d0(Float.valueOf(uVar.f25986e));
            bVar.V(Long.valueOf(uVar.f25989h));
            bVar.L(Long.valueOf(uVar.f25990i));
            bVar.K(uVar.f25991j);
            bVar.J(Integer.valueOf(uVar.f25992k));
            bVar.E(Float.valueOf(uVar.f25993l));
            bVar.P(Integer.valueOf(uVar.f25994m));
            bVar.W(Integer.valueOf(uVar.f25995n));
            bVar.D(uVar.f25982a);
            bVar.I(uVar.f25983b);
            bVar.R(Float.valueOf(uVar.f25997p));
            bVar.S(Float.valueOf(uVar.f25998q));
            bVar.G(Float.valueOf(uVar.f25999r));
            bVar.F(Float.valueOf(uVar.f26000s));
            bVar.T(Float.valueOf(uVar.f26001t));
            bVar.N(u.e(uVar.f26007z));
            if (uVar.f25985d.isSwimming()) {
                bVar.a0(Float.valueOf(uVar.B));
                bVar.Y(Integer.valueOf(uVar.A));
                bVar.Z(Integer.valueOf(uVar.C));
            } else {
                int i10 = uVar.f26004w;
                if (i10 > 0) {
                    bVar.X(Integer.valueOf(i10));
                    bVar.Y(Integer.valueOf(uVar.f26005x));
                    bVar.Z(Integer.valueOf(uVar.f26003v));
                }
            }
            float f10 = uVar.f26002u;
            if (f10 > 0.0f) {
                bVar.a0(Float.valueOf(f10));
            }
            if (uVar.f25985d.isCountType()) {
                bVar.T(Float.valueOf(uVar.H));
            }
            String str2 = uVar.G;
            if (str2 != null) {
                bVar.M(str2);
            }
        }
        return bVar;
    }
}
