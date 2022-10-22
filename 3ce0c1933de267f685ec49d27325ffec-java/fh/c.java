package fh;

import com.mobvoi.wear.util.UnitsUtility;
import ef.a0;
import ef.p;
import java.util.List;
import we.a;
/* compiled from: PaceAnalyzer.java */
/* loaded from: classes2.dex */
public class c extends a<a0> {

    /* renamed from: b  reason: collision with root package name */
    private float f27034b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private int f27035c = 0;

    /* renamed from: d  reason: collision with root package name */
    private a0 f27036d;

    /* renamed from: e  reason: collision with root package name */
    private long f27037e;

    /* renamed from: f  reason: collision with root package name */
    private long f27038f;

    @Override // we.a, we.b
    public List<a0> a(Iterable<p> iterable) {
        List<a0> a10 = super.a(iterable);
        a0 f10 = f(this.f27036d, this.f27038f, this.f27037e);
        if (f10 != null) {
            a10.add(f10);
        }
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        super.d();
        this.f27034b = 0.0f;
        this.f27035c = 0;
        this.f27036d = null;
        this.f27037e = 0L;
        this.f27038f = 0L;
    }

    protected a0 f(a0 a0Var, long j10, long j11) {
        float f10 = 0.0f;
        if (a0Var == null) {
            a0Var = new a0(0, 0.0f, 0.0f);
        }
        float m2mile = b() ? UnitsUtility.Length.m2mile(this.f27034b) : UnitsUtility.Length.m2km(this.f27034b);
        int floor = (int) Math.floor(m2mile);
        if (j11 <= j10 || m2mile <= a0Var.f25907a) {
            return null;
        }
        float ms2min = UnitsUtility.Time.ms2min(j11 - j10) / (m2mile - a0Var.f25907a);
        float f11 = a0Var.f25908b;
        if (f11 > 0.0f) {
            f10 = ms2min - f11;
        }
        return new a0(floor, ms2min, f10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public a0 c(a0 a0Var, long j10, p pVar) {
        a0 a0Var2;
        float f10 = 0.0f;
        if (a0Var == null) {
            a0Var = new a0(0, 0.0f, 0.0f);
        }
        int i10 = pVar.f25953c;
        if (i10 > this.f27034b) {
            this.f27034b = i10;
        }
        float m2mile = b() ? UnitsUtility.Length.m2mile(this.f27034b) : UnitsUtility.Length.m2km(this.f27034b);
        int floor = (int) Math.floor(m2mile);
        if (floor > this.f27035c) {
            float ms2min = UnitsUtility.Time.ms2min(pVar.f25951a - j10) / (m2mile - a0Var.f25907a);
            float f11 = a0Var.f25908b;
            if (f11 > 0.0f) {
                f10 = ms2min - f11;
            }
            a0Var2 = new a0(floor, ms2min, f10);
            this.f27036d = a0Var2;
            this.f27038f = pVar.f25951a;
        } else {
            a0Var2 = null;
        }
        this.f27035c = floor;
        this.f27037e = pVar.f25951a;
        return a0Var2;
    }
}
