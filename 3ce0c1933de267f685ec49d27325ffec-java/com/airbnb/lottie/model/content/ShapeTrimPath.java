package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.s;
import i3.b;
/* loaded from: classes.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6583a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f6584b;

    /* renamed from: c  reason: collision with root package name */
    private final h3.b f6585c;

    /* renamed from: d  reason: collision with root package name */
    private final h3.b f6586d;

    /* renamed from: e  reason: collision with root package name */
    private final h3.b f6587e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6588f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i10);
        }
    }

    public ShapeTrimPath(String str, Type type, h3.b bVar, h3.b bVar2, h3.b bVar3, boolean z10) {
        this.f6583a = str;
        this.f6584b = type;
        this.f6585c = bVar;
        this.f6586d = bVar2;
        this.f6587e = bVar3;
        this.f6588f = z10;
    }

    @Override // i3.b
    public c a(f fVar, a aVar) {
        return new s(aVar, this);
    }

    public h3.b b() {
        return this.f6586d;
    }

    public String c() {
        return this.f6583a;
    }

    public h3.b d() {
        return this.f6587e;
    }

    public h3.b e() {
        return this.f6585c;
    }

    public Type f() {
        return this.f6584b;
    }

    public boolean g() {
        return this.f6588f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f6585c + ", end: " + this.f6586d + ", offset: " + this.f6587e + "}";
    }
}
