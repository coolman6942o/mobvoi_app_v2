package fh;

import ef.f0;
import ef.p;
import we.a;
/* compiled from: SwimStrokeAnalyzer.java */
/* loaded from: classes2.dex */
public class g extends a<f0> {

    /* renamed from: b  reason: collision with root package name */
    private int f27041b;

    /* renamed from: c  reason: collision with root package name */
    private float f27042c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        this.f27042c = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public f0 c(f0 f0Var, long j10, p pVar) {
        float f10 = pVar.f25964n;
        if (f10 < 1.0f) {
            return null;
        }
        float f11 = this.f27042c;
        if (f10 <= f11) {
            return null;
        }
        f0 f0Var2 = new f0(f10, pVar.f25966p, (int) (this.f27041b * (f10 - f11)));
        this.f27042c = pVar.f25964n;
        return f0Var2;
    }

    public void g(int i10) {
        this.f27041b = i10;
    }
}
