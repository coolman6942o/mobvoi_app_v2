package xc;

import java.util.List;
import qf.a;
/* compiled from: CommonCardData.kt */
/* loaded from: classes2.dex */
public final class d extends b<List<? extends a>> {
    public d(List<? extends a> list, int i10) {
        super(list, i10);
    }

    @Override // xc.b
    public boolean c() {
        List<? extends a> a10 = a();
        return a10 != null && (a10.isEmpty() ^ true);
    }
}
