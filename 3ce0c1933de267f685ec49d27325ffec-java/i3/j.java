package i3;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.q;
import h3.h;
/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28059a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28060b;

    /* renamed from: c  reason: collision with root package name */
    private final h f28061c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28062d;

    public j(String str, int i10, h hVar, boolean z10) {
        this.f28059a = str;
        this.f28060b = i10;
        this.f28061c = hVar;
        this.f28062d = z10;
    }

    @Override // i3.b
    public c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public String b() {
        return this.f28059a;
    }

    public h c() {
        return this.f28061c;
    }

    public boolean d() {
        return this.f28062d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f28059a + ", index=" + this.f28060b + '}';
    }
}
