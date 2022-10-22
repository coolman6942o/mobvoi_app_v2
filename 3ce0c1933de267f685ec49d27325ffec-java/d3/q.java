package d3;

import android.graphics.Path;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import i3.g;
import i3.j;
import java.util.List;
/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class q implements m, a.b {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25116b;

    /* renamed from: c  reason: collision with root package name */
    private final f f25117c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, Path> f25118d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25119e;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25115a = new Path();

    /* renamed from: f  reason: collision with root package name */
    private b f25120f = new b();

    public q(f fVar, com.airbnb.lottie.model.layer.a aVar, j jVar) {
        jVar.b();
        this.f25116b = jVar.d();
        this.f25117c = fVar;
        a<g, Path> a10 = jVar.c().a();
        this.f25118d = a10;
        aVar.j(a10);
        a10.a(this);
    }

    private void d() {
        this.f25119e = false;
        this.f25117c.invalidateSelf();
    }

    @Override // d3.m
    public Path a() {
        if (this.f25119e) {
            return this.f25115a;
        }
        this.f25115a.reset();
        if (this.f25116b) {
            this.f25119e = true;
            return this.f25115a;
        }
        this.f25115a.set(this.f25118d.h());
        this.f25115a.setFillType(Path.FillType.EVEN_ODD);
        this.f25120f.b(this.f25115a);
        this.f25119e = true;
        return this.f25115a;
    }

    @Override // e3.a.b
    public void b() {
        d();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f25120f.a(sVar);
                    sVar.d(this);
                }
            }
        }
    }
}
