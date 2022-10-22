package pk;

import ef.r;
import java.util.List;
import xe.b;
/* compiled from: SportHandler.java */
/* loaded from: classes2.dex */
class u0<BandData> extends a<BandData, List<r>> {

    /* renamed from: b  reason: collision with root package name */
    private final b f32834b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(i<BandData, List<r>> iVar, b bVar) {
        super(iVar);
        this.f32834b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void b(List<r> list) {
        for (r rVar : list) {
            this.f32834b.h(rVar);
        }
    }
}
