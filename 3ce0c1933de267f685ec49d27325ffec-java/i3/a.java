package i3;

import android.graphics.PointF;
import d3.c;
import h3.f;
import h3.m;
/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f28022a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f28023b;

    /* renamed from: c  reason: collision with root package name */
    private final f f28024c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f28025d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f28026e;

    public a(String str, m<PointF, PointF> mVar, f fVar, boolean z10, boolean z11) {
        this.f28022a = str;
        this.f28023b = mVar;
        this.f28024c = fVar;
        this.f28025d = z10;
        this.f28026e = z11;
    }

    @Override // i3.b
    public c a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new d3.f(fVar, aVar, this);
    }

    public String b() {
        return this.f28022a;
    }

    public m<PointF, PointF> c() {
        return this.f28023b;
    }

    public f d() {
        return this.f28024c;
    }

    public boolean e() {
        return this.f28026e;
    }

    public boolean f() {
        return this.f28025d;
    }
}
