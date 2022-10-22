package we;

import ef.d0;
/* compiled from: StrideFreqAnalyzer.java */
/* loaded from: classes2.dex */
public class f extends e<d0> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public d0 f(double d10, double d11) {
        return new d0((long) (d10 * 1000.0d), (float) d11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public d0 j(long j10, float f10, float f11, int i10) {
        float f12 = 0.0f;
        if (f10 > 0.0f) {
            f12 = i10 / f10;
        }
        return new d0(j10, f12);
    }
}
