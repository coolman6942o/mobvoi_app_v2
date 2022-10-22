package xc;

import java.util.List;
import kotlin.jvm.internal.i;
import tc.n;
/* compiled from: HealthReportData.kt */
/* loaded from: classes2.dex */
public final class g extends b<List<n>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(List<n> data) {
        super(data, 2);
        i.f(data, "data");
    }

    @Override // xc.b
    public boolean c() {
        List<n> a10 = a();
        return a10 != null && (a10.isEmpty() ^ true);
    }
}
