package i3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import d3.h;
import h3.b;
import h3.c;
import h3.f;
/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f28029a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f28030b;

    /* renamed from: c  reason: collision with root package name */
    private final c f28031c;

    /* renamed from: d  reason: collision with root package name */
    private final h3.d f28032d;

    /* renamed from: e  reason: collision with root package name */
    private final f f28033e;

    /* renamed from: f  reason: collision with root package name */
    private final f f28034f;

    /* renamed from: g  reason: collision with root package name */
    private final String f28035g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f28036h;

    public d(String str, GradientType gradientType, Path.FillType fillType, c cVar, h3.d dVar, f fVar, f fVar2, b bVar, b bVar2, boolean z10) {
        this.f28029a = gradientType;
        this.f28030b = fillType;
        this.f28031c = cVar;
        this.f28032d = dVar;
        this.f28033e = fVar;
        this.f28034f = fVar2;
        this.f28035g = str;
        this.f28036h = z10;
    }

    @Override // i3.b
    public d3.c a(com.airbnb.lottie.f fVar, a aVar) {
        return new h(fVar, aVar, this);
    }

    public f b() {
        return this.f28034f;
    }

    public Path.FillType c() {
        return this.f28030b;
    }

    public c d() {
        return this.f28031c;
    }

    public GradientType e() {
        return this.f28029a;
    }

    public String f() {
        return this.f28035g;
    }

    public h3.d g() {
        return this.f28032d;
    }

    public f h() {
        return this.f28033e;
    }

    public boolean i() {
        return this.f28036h;
    }
}
