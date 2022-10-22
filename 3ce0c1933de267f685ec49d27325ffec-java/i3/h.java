package i3;

import android.graphics.Path;
import com.airbnb.lottie.f;
import d3.c;
import d3.g;
import h3.a;
import h3.d;
/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28050a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f28051b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28052c;

    /* renamed from: d  reason: collision with root package name */
    private final a f28053d;

    /* renamed from: e  reason: collision with root package name */
    private final d f28054e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f28055f;

    public h(String str, boolean z10, Path.FillType fillType, a aVar, d dVar, boolean z11) {
        this.f28052c = str;
        this.f28050a = z10;
        this.f28051b = fillType;
        this.f28053d = aVar;
        this.f28054e = dVar;
        this.f28055f = z11;
    }

    @Override // i3.b
    public c a(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new g(fVar, aVar, this);
    }

    public a b() {
        return this.f28053d;
    }

    public Path.FillType c() {
        return this.f28051b;
    }

    public String d() {
        return this.f28052c;
    }

    public d e() {
        return this.f28054e;
    }

    public boolean f() {
        return this.f28055f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f28050a + '}';
    }
}
