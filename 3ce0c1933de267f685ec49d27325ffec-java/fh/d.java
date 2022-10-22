package fh;

import com.mobvoi.wear.util.UnitsUtility;
import ef.b0;
import ef.p;
/* compiled from: SpeedAnalyzer.java */
/* loaded from: classes2.dex */
public class d extends we.d<b0> {
    public d() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public b0 f(double d10, double d11) {
        return new b0((long) (d10 * 1000.0d), (float) d11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public b0 c(b0 b0Var, long j10, p pVar) {
        float f10;
        if (pVar.f25954d < 0.0f) {
            return null;
        }
        if (b()) {
            f10 = UnitsUtility.Speed.mPs2milePh(pVar.f25954d);
        } else {
            f10 = UnitsUtility.Speed.mPs2kmPh(pVar.f25954d);
        }
        return new b0(pVar.f25951a, f10);
    }
}
