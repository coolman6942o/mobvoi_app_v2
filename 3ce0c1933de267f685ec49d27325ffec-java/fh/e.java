package fh;

import bh.g;
import ef.e0;
/* compiled from: StrideLenAnalyzer.java */
/* loaded from: classes2.dex */
public class e extends we.e<e0> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public e0 f(double d10, double d11) {
        return new e0((long) (d10 * 1000.0d), (float) d11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public e0 j(long j10, float f10, float f11, int i10) {
        if (!(i10 > 0)) {
            return null;
        }
        float f12 = f11 / i10;
        if (f12 >= eg.e.f26042a) {
            return null;
        }
        return new e0(j10, g.b(f12, b()));
    }
}
