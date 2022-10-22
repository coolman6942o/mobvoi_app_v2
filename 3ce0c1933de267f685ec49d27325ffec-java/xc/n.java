package xc;

import ef.u;
import java.util.List;
/* compiled from: SportCardData.kt */
/* loaded from: classes2.dex */
public final class n extends b<List<? extends u>> {

    /* renamed from: c  reason: collision with root package name */
    private final int f36517c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36518d;

    /* renamed from: e  reason: collision with root package name */
    private final float f36519e;

    /* renamed from: f  reason: collision with root package name */
    private long f36520f;

    public n(List<? extends u> list, int i10) {
        super(list, i10);
        int i11;
        float f10 = 0.0f;
        if ((list == null || !(list.isEmpty() ^ true)) ? false : true) {
            for (u uVar : list) {
                this.f36520f += uVar.f25991j;
                f10 += uVar.f25993l;
            }
            long j10 = this.f36520f;
            this.f36517c = (int) (j10 / 3600000);
            this.f36518d = (int) ((j10 - (((i11 * 60) * 60) * 1000)) / 60000);
            this.f36519e = f10;
            return;
        }
        this.f36517c = 0;
        this.f36518d = 0;
        this.f36519e = 0.0f;
    }

    @Override // xc.b
    public boolean c() {
        return this.f36520f > 0;
    }

    public final float d() {
        return this.f36519e;
    }

    public final int e() {
        return this.f36517c;
    }

    public final int f() {
        return this.f36518d;
    }
}
