package fh;

import ef.p;
import we.a;
/* compiled from: SwimSegmentAnalyzer.java */
/* loaded from: classes2.dex */
public class f extends a<gh.a> {

    /* renamed from: b  reason: collision with root package name */
    private int f27039b;

    /* renamed from: c  reason: collision with root package name */
    private int f27040c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // we.a
    public void d() {
        this.f27040c = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public gh.a c(gh.a aVar, long j10, p pVar) {
        float f10 = 0.0f;
        float f11 = aVar == null ? 0.0f : aVar.f27475a;
        float f12 = pVar.f25964n;
        if (f12 <= 0.0f || f12 <= f11) {
            return null;
        }
        int i10 = (int) (pVar.f25951a - j10);
        int ceil = (int) Math.ceil(f12);
        int i11 = this.f27039b;
        int i12 = i11 * ceil;
        float f13 = pVar.f25954d;
        if (f13 > 0.0f) {
            f10 = i11 / f13;
        }
        gh.a aVar2 = new gh.a(i10, ceil, i12, f10, pVar.f25965o - this.f27040c);
        this.f27040c = pVar.f25965o;
        return aVar2;
    }

    public void g(int i10) {
        this.f27039b = i10;
    }
}
