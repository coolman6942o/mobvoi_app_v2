package e3;

import android.graphics.Path;
import i3.g;
import java.util.List;
import l3.a;
/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<g, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final g f25754i = new g();

    /* renamed from: j  reason: collision with root package name */
    private final Path f25755j = new Path();

    public l(List<a<g>> list) {
        super(list);
    }

    /* renamed from: o */
    public Path i(a<g> aVar, float f10) {
        this.f25754i.c(aVar.f30404b, aVar.f30405c, f10);
        k3.g.h(this.f25754i, this.f25755j);
        return this.f25755j;
    }
}
