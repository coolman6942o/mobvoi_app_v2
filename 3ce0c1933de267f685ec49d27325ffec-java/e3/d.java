package e3;

import i3.c;
import java.util.List;
import l3.a;
/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<c> {

    /* renamed from: i  reason: collision with root package name */
    private final c f25742i;

    public d(List<a<c>> list) {
        super(list);
        int i10 = 0;
        c cVar = list.get(0).f30404b;
        i10 = cVar != null ? cVar.c() : i10;
        this.f25742i = new c(new float[i10], new int[i10]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public c i(a<c> aVar, float f10) {
        this.f25742i.d(aVar.f30404b, aVar.f30405c, f10);
        return this.f25742i;
    }
}
