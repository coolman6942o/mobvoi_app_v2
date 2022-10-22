package we;

import com.mobvoi.wear.util.UnitsUtility;
import ef.p;
import ef.y;
import java.util.List;
/* compiled from: LapAnalyzer.java */
/* loaded from: classes2.dex */
public class c extends a<y> {

    /* renamed from: b  reason: collision with root package name */
    private y f36222b;

    /* renamed from: c  reason: collision with root package name */
    private long f36223c;

    /* renamed from: d  reason: collision with root package name */
    private int f36224d;

    /* renamed from: e  reason: collision with root package name */
    private long f36225e;

    private y f(long j10, int i10) {
        return new y(1, i10, j10, j10, UnitsUtility.Time.ms2min(j10) / (b() ? UnitsUtility.Length.m2mile(i10) : UnitsUtility.Length.m2km(i10)));
    }

    @Override // we.a, we.b
    public List<y> a(Iterable<p> iterable) {
        List<y> a10 = super.a(iterable);
        if (a10.isEmpty()) {
            f(this.f36225e, this.f36224d);
        }
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        super.d();
        this.f36222b = null;
        this.f36223c = 0L;
        this.f36224d = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public y c(y yVar, long j10, p pVar) {
        int i10 = pVar.f25953c;
        if (i10 > this.f36224d) {
            this.f36224d = i10;
        }
        long j11 = pVar.f25951a;
        if (j11 > this.f36225e) {
            this.f36225e = j11;
        }
        if (this.f36222b == null) {
            this.f36222b = new y(0, 0, 0L, 0L, 0.0f);
        }
        if (pVar.f25967q <= this.f36222b.f26018a) {
            return null;
        }
        int i11 = pVar.f25969s;
        float m2mile = b() ? UnitsUtility.Length.m2mile(i11) : UnitsUtility.Length.m2km(i11);
        int i12 = pVar.f25967q;
        int i13 = pVar.f25968r;
        long j12 = i13;
        this.f36223c += j12;
        y yVar2 = new y(i12, i11, this.f36223c, j12, (i13 > 0 ? (((float) i11) * 1.0f) / (((float) i13) / 1000.0f) : 0.0f) < 0.42f ? 0.0f : UnitsUtility.Time.ms2min(j12) / m2mile);
        this.f36222b = yVar2;
        return yVar2;
    }
}
