package xc;

import com.mobvoi.health.core.data.pojo.DataType;
/* compiled from: HealthCardData.kt */
/* loaded from: classes2.dex */
public final class f extends b<e> {

    /* renamed from: c  reason: collision with root package name */
    private final long f36512c;

    public f(long j10, e eVar, int i10) {
        super(eVar, i10);
        this.f36512c = j10;
    }

    @Override // xc.b
    public boolean c() {
        return (a() == null || (a().d(DataType.Active) == 0 && a().d(DataType.Exercise) == 0 && a().d(DataType.Step) == 0)) ? false : true;
    }

    public final long d() {
        return this.f36512c;
    }
}
