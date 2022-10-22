package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.j;
import g5.f;
import g5.l;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import u4.b;
import u4.e;
import u4.k;
import v4.a;
import v4.g;
import v4.h;
import v4.i;
/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    private j f7813b;

    /* renamed from: c  reason: collision with root package name */
    private e f7814c;

    /* renamed from: d  reason: collision with root package name */
    private b f7815d;

    /* renamed from: e  reason: collision with root package name */
    private h f7816e;

    /* renamed from: f  reason: collision with root package name */
    private w4.a f7817f;

    /* renamed from: g  reason: collision with root package name */
    private w4.a f7818g;

    /* renamed from: h  reason: collision with root package name */
    private a.AbstractC0513a f7819h;

    /* renamed from: i  reason: collision with root package name */
    private i f7820i;

    /* renamed from: j  reason: collision with root package name */
    private g5.d f7821j;

    /* renamed from: m  reason: collision with root package name */
    private l.b f7824m;

    /* renamed from: n  reason: collision with root package name */
    private w4.a f7825n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f7826o;

    /* renamed from: p  reason: collision with root package name */
    private List<j5.b<Object>> f7827p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f7828q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7829r;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, i<?, ?>> f7812a = new androidx.collection.a();

    /* renamed from: k  reason: collision with root package name */
    private int f7822k = 4;

    /* renamed from: l  reason: collision with root package name */
    private c.a f7823l = new a(this);

    /* renamed from: s  reason: collision with root package name */
    private int f7830s = 700;

    /* renamed from: t  reason: collision with root package name */
    private int f7831t = 128;

    /* compiled from: GlideBuilder.java */
    /* loaded from: classes.dex */
    class a implements c.a {
        a(d dVar) {
        }

        @Override // com.bumptech.glide.c.a
        public j5.c build() {
            return new j5.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(Context context) {
        if (this.f7817f == null) {
            this.f7817f = w4.a.f();
        }
        if (this.f7818g == null) {
            this.f7818g = w4.a.d();
        }
        if (this.f7825n == null) {
            this.f7825n = w4.a.b();
        }
        if (this.f7820i == null) {
            this.f7820i = new i.a(context).a();
        }
        if (this.f7821j == null) {
            this.f7821j = new f();
        }
        if (this.f7814c == null) {
            int b10 = this.f7820i.b();
            if (b10 > 0) {
                this.f7814c = new k(b10);
            } else {
                this.f7814c = new u4.f();
            }
        }
        if (this.f7815d == null) {
            this.f7815d = new u4.j(this.f7820i.a());
        }
        if (this.f7816e == null) {
            this.f7816e = new g(this.f7820i.d());
        }
        if (this.f7819h == null) {
            this.f7819h = new v4.f(context);
        }
        if (this.f7813b == null) {
            this.f7813b = new j(this.f7816e, this.f7819h, this.f7818g, this.f7817f, w4.a.h(), this.f7825n, this.f7826o);
        }
        List<j5.b<Object>> list = this.f7827p;
        if (list == null) {
            this.f7827p = Collections.emptyList();
        } else {
            this.f7827p = Collections.unmodifiableList(list);
        }
        return new c(context, this.f7813b, this.f7816e, this.f7814c, this.f7815d, new l(this.f7824m), this.f7821j, this.f7822k, this.f7823l, this.f7812a, this.f7827p, this.f7828q, this.f7829r, this.f7830s, this.f7831t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(l.b bVar) {
        this.f7824m = bVar;
    }
}
