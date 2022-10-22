package xc;

import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.util.Collection;
/* compiled from: SleepCardData.kt */
/* loaded from: classes2.dex */
public final class m extends b<Collection<? extends SleepRecord>> {

    /* renamed from: c  reason: collision with root package name */
    private boolean f36516c;

    public m(Collection<? extends SleepRecord> collection, int i10) {
        super(collection, i10);
    }

    @Override // xc.b
    public boolean c() {
        Collection<? extends SleepRecord> a10 = a();
        return a10 != null && (a10.isEmpty() ^ true);
    }

    public final boolean d() {
        return this.f36516c;
    }

    public final void e(boolean z10) {
        this.f36516c = z10;
    }
}
