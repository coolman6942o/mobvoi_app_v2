package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.n;
import h3.m;
import i3.b;
/* loaded from: classes.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6561a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f6562b;

    /* renamed from: c  reason: collision with root package name */
    private final h3.b f6563c;

    /* renamed from: d  reason: collision with root package name */
    private final m<PointF, PointF> f6564d;

    /* renamed from: e  reason: collision with root package name */
    private final h3.b f6565e;

    /* renamed from: f  reason: collision with root package name */
    private final h3.b f6566f;

    /* renamed from: g  reason: collision with root package name */
    private final h3.b f6567g;

    /* renamed from: h  reason: collision with root package name */
    private final h3.b f6568h;

    /* renamed from: i  reason: collision with root package name */
    private final h3.b f6569i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f6570j;

    /* loaded from: classes.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        Type(int i10) {
            this.value = i10;
        }

        public static Type forValue(int i10) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i10) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, h3.b bVar, m<PointF, PointF> mVar, h3.b bVar2, h3.b bVar3, h3.b bVar4, h3.b bVar5, h3.b bVar6, boolean z10) {
        this.f6561a = str;
        this.f6562b = type;
        this.f6563c = bVar;
        this.f6564d = mVar;
        this.f6565e = bVar2;
        this.f6566f = bVar3;
        this.f6567g = bVar4;
        this.f6568h = bVar5;
        this.f6569i = bVar6;
        this.f6570j = z10;
    }

    @Override // i3.b
    public c a(f fVar, a aVar) {
        return new n(fVar, aVar, this);
    }

    public h3.b b() {
        return this.f6566f;
    }

    public h3.b c() {
        return this.f6568h;
    }

    public String d() {
        return this.f6561a;
    }

    public h3.b e() {
        return this.f6567g;
    }

    public h3.b f() {
        return this.f6569i;
    }

    public h3.b g() {
        return this.f6563c;
    }

    public m<PointF, PointF> h() {
        return this.f6564d;
    }

    public h3.b i() {
        return this.f6565e;
    }

    public Type j() {
        return this.f6562b;
    }

    public boolean k() {
        return this.f6570j;
    }
}
