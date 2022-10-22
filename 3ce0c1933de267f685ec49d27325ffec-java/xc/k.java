package xc;

import com.mobvoi.health.core.data.pojo.DataType;
/* compiled from: McuActivityCardData.kt */
/* loaded from: classes2.dex */
public final class k extends b<j> {

    /* renamed from: c  reason: collision with root package name */
    private final long f36515c;

    public k(long j10, j jVar, int i10) {
        super(jVar, i10);
        this.f36515c = j10;
    }

    @Override // xc.b
    public boolean c() {
        return (a() == null || (a().b(DataType.Calorie) == 0 && a().b(DataType.Step) == 0 && a().b(DataType.Distance) == 0)) ? false : true;
    }

    public final long d() {
        return this.f36515c;
    }
}
