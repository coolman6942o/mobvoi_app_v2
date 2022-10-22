package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.content.ShapeStroke;
import d3.i;
import h3.c;
import h3.d;
import h3.f;
import i3.b;
import java.util.List;
/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6589a;

    /* renamed from: b  reason: collision with root package name */
    private final GradientType f6590b;

    /* renamed from: c  reason: collision with root package name */
    private final c f6591c;

    /* renamed from: d  reason: collision with root package name */
    private final d f6592d;

    /* renamed from: e  reason: collision with root package name */
    private final f f6593e;

    /* renamed from: f  reason: collision with root package name */
    private final f f6594f;

    /* renamed from: g  reason: collision with root package name */
    private final h3.b f6595g;

    /* renamed from: h  reason: collision with root package name */
    private final ShapeStroke.LineCapType f6596h;

    /* renamed from: i  reason: collision with root package name */
    private final ShapeStroke.LineJoinType f6597i;

    /* renamed from: j  reason: collision with root package name */
    private final float f6598j;

    /* renamed from: k  reason: collision with root package name */
    private final List<h3.b> f6599k;

    /* renamed from: l  reason: collision with root package name */
    private final h3.b f6600l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f6601m;

    public a(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, h3.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f10, List<h3.b> list, h3.b bVar2, boolean z10) {
        this.f6589a = str;
        this.f6590b = gradientType;
        this.f6591c = cVar;
        this.f6592d = dVar;
        this.f6593e = fVar;
        this.f6594f = fVar2;
        this.f6595g = bVar;
        this.f6596h = lineCapType;
        this.f6597i = lineJoinType;
        this.f6598j = f10;
        this.f6599k = list;
        this.f6600l = bVar2;
        this.f6601m = z10;
    }

    @Override // i3.b
    public d3.c a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new i(fVar, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f6596h;
    }

    public h3.b c() {
        return this.f6600l;
    }

    public f d() {
        return this.f6594f;
    }

    public c e() {
        return this.f6591c;
    }

    public GradientType f() {
        return this.f6590b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f6597i;
    }

    public List<h3.b> h() {
        return this.f6599k;
    }

    public float i() {
        return this.f6598j;
    }

    public String j() {
        return this.f6589a;
    }

    public d k() {
        return this.f6592d;
    }

    public f l() {
        return this.f6593e;
    }

    public h3.b m() {
        return this.f6595g;
    }

    public boolean n() {
        return this.f6601m;
    }
}
