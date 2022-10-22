package i3;

import android.graphics.PointF;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.o;
import h3.b;
import h3.f;
import h3.m;
/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28037a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f28038b;

    /* renamed from: c  reason: collision with root package name */
    private final f f28039c;

    /* renamed from: d  reason: collision with root package name */
    private final b f28040d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28041e;

    public e(String str, m<PointF, PointF> mVar, f fVar, b bVar, boolean z10) {
        this.f28037a = str;
        this.f28038b = mVar;
        this.f28039c = fVar;
        this.f28040d = bVar;
        this.f28041e = z10;
    }

    @Override // i3.b
    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new o(fVar, aVar, this);
    }

    public b b() {
        return this.f28040d;
    }

    public String c() {
        return this.f28037a;
    }

    public m<PointF, PointF> d() {
        return this.f28038b;
    }

    public f e() {
        return this.f28039c;
    }

    public boolean f() {
        return this.f28041e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f28038b + ", size=" + this.f28039c + '}';
    }
}
