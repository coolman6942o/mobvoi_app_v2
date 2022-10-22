package fh;

import com.mobvoi.wear.util.UnitsUtility;
import ef.o;
import ef.p;
import ef.z;
import we.a;
/* compiled from: LocationAnalyzer.java */
/* loaded from: classes2.dex */
public class b extends a<z> {

    /* renamed from: b  reason: collision with root package name */
    private float f27030b;

    /* renamed from: c  reason: collision with root package name */
    private int f27031c;

    /* renamed from: d  reason: collision with root package name */
    private int f27032d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f27033e = false;

    private z f(long j10, o oVar, float f10, float f11, z zVar, boolean z10) {
        return new z(j10, oVar.f25947d, oVar.f25946c, f11, f10, zVar == null || j10 - zVar.f26023a < 10000, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        super.d();
        this.f27030b = 0.0f;
        this.f27031c = 0;
        this.f27032d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public z c(z zVar, long j10, p pVar) {
        z zVar2;
        float f10;
        float f11 = 0.0f;
        if (pVar.f25954d >= 0.0f) {
            if (b()) {
                f10 = UnitsUtility.Speed.mPs2milePh(pVar.f25954d);
            } else {
                f10 = UnitsUtility.Speed.mPs2kmPh(pVar.f25954d);
            }
            this.f27030b = f10;
        }
        int i10 = pVar.f25953c;
        if (i10 > 0) {
            float f12 = i10;
            f11 = b() ? UnitsUtility.Length.m2mile(f12) : UnitsUtility.Length.m2km(f12);
            this.f27031c = (int) Math.floor(f11);
        }
        if (pVar.f25963m) {
            this.f27033e = true;
        }
        o oVar = pVar.f25973w;
        if (oVar == null || !oVar.a()) {
            zVar2 = null;
        } else {
            if (this.f27031c <= this.f27032d) {
                f11 = -1.0f;
            }
            zVar2 = f(pVar.f25951a, pVar.f25973w, this.f27030b, f11, zVar, this.f27033e);
            this.f27033e = false;
        }
        this.f27032d = this.f27031c;
        return zVar2;
    }
}
