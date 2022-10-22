package com.bumptech.glide.request;

import a5.f;
import a5.h;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.request.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import e5.c;
import e5.i;
import java.util.Map;
import n5.j;
import n5.k;
import q4.b;
import q4.d;
import q4.e;
import q4.g;
/* compiled from: BaseRequestOptions.java */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f8131a;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f8135e;

    /* renamed from: f  reason: collision with root package name */
    private int f8136f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f8137g;

    /* renamed from: h  reason: collision with root package name */
    private int f8138h;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8143m;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f8145o;

    /* renamed from: p  reason: collision with root package name */
    private int f8146p;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8150t;

    /* renamed from: u  reason: collision with root package name */
    private Resources.Theme f8151u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f8152v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f8153w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8154x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f8156z;

    /* renamed from: b  reason: collision with root package name */
    private float f8132b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    private t4.a f8133c = t4.a.f35052d;

    /* renamed from: d  reason: collision with root package name */
    private Priority f8134d = Priority.NORMAL;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8139i = true;

    /* renamed from: j  reason: collision with root package name */
    private int f8140j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f8141k = -1;

    /* renamed from: l  reason: collision with root package name */
    private b f8142l = m5.a.c();

    /* renamed from: n  reason: collision with root package name */
    private boolean f8144n = true;

    /* renamed from: q  reason: collision with root package name */
    private e f8147q = new e();

    /* renamed from: r  reason: collision with root package name */
    private Map<Class<?>, g<?>> f8148r = new n5.b();

    /* renamed from: s  reason: collision with root package name */
    private Class<?> f8149s = Object.class;

    /* renamed from: y  reason: collision with root package name */
    private boolean f8155y = true;

    private boolean H(int i10) {
        return I(this.f8131a, i10);
    }

    private static boolean I(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    private T R(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        return W(downsampleStrategy, gVar, false);
    }

    private T W(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar, boolean z10) {
        T t10;
        if (z10) {
            t10 = d0(downsampleStrategy, gVar);
        } else {
            t10 = S(downsampleStrategy, gVar);
        }
        t10.f8155y = true;
        return t10;
    }

    private T X() {
        return this;
    }

    private T Y() {
        if (!this.f8150t) {
            return X();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final Resources.Theme A() {
        return this.f8151u;
    }

    public final Map<Class<?>, g<?>> B() {
        return this.f8148r;
    }

    public final boolean C() {
        return this.f8156z;
    }

    public final boolean D() {
        return this.f8153w;
    }

    public final boolean E() {
        return this.f8139i;
    }

    public final boolean F() {
        return H(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f8155y;
    }

    public final boolean J() {
        return this.f8144n;
    }

    public final boolean K() {
        return this.f8143m;
    }

    public final boolean L() {
        return H(2048);
    }

    public final boolean M() {
        return k.s(this.f8141k, this.f8140j);
    }

    public T N() {
        this.f8150t = true;
        return X();
    }

    public T O() {
        return S(DownsampleStrategy.f8065c, new a5.e());
    }

    public T P() {
        return R(DownsampleStrategy.f8064b, new f());
    }

    public T Q() {
        return R(DownsampleStrategy.f8063a, new h());
    }

    final T S(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        if (this.f8152v) {
            return (T) clone().S(downsampleStrategy, gVar);
        }
        i(downsampleStrategy);
        return g0(gVar, false);
    }

    public T T(int i10, int i11) {
        if (this.f8152v) {
            return (T) clone().T(i10, i11);
        }
        this.f8141k = i10;
        this.f8140j = i11;
        this.f8131a |= 512;
        return Y();
    }

    public T U(int i10) {
        if (this.f8152v) {
            return (T) clone().U(i10);
        }
        this.f8138h = i10;
        int i11 = this.f8131a | 128;
        this.f8131a = i11;
        this.f8137g = null;
        this.f8131a = i11 & (-65);
        return Y();
    }

    public T V(Priority priority) {
        if (this.f8152v) {
            return (T) clone().V(priority);
        }
        this.f8134d = (Priority) j.d(priority);
        this.f8131a |= 8;
        return Y();
    }

    public <Y> T Z(d<Y> dVar, Y y10) {
        if (this.f8152v) {
            return (T) clone().Z(dVar, y10);
        }
        j.d(dVar);
        j.d(y10);
        this.f8147q.e(dVar, y10);
        return Y();
    }

    public T a(a<?> aVar) {
        if (this.f8152v) {
            return (T) clone().a(aVar);
        }
        if (I(aVar.f8131a, 2)) {
            this.f8132b = aVar.f8132b;
        }
        if (I(aVar.f8131a, 262144)) {
            this.f8153w = aVar.f8153w;
        }
        if (I(aVar.f8131a, 1048576)) {
            this.f8156z = aVar.f8156z;
        }
        if (I(aVar.f8131a, 4)) {
            this.f8133c = aVar.f8133c;
        }
        if (I(aVar.f8131a, 8)) {
            this.f8134d = aVar.f8134d;
        }
        if (I(aVar.f8131a, 16)) {
            this.f8135e = aVar.f8135e;
            this.f8136f = 0;
            this.f8131a &= -33;
        }
        if (I(aVar.f8131a, 32)) {
            this.f8136f = aVar.f8136f;
            this.f8135e = null;
            this.f8131a &= -17;
        }
        if (I(aVar.f8131a, 64)) {
            this.f8137g = aVar.f8137g;
            this.f8138h = 0;
            this.f8131a &= -129;
        }
        if (I(aVar.f8131a, 128)) {
            this.f8138h = aVar.f8138h;
            this.f8137g = null;
            this.f8131a &= -65;
        }
        if (I(aVar.f8131a, 256)) {
            this.f8139i = aVar.f8139i;
        }
        if (I(aVar.f8131a, 512)) {
            this.f8141k = aVar.f8141k;
            this.f8140j = aVar.f8140j;
        }
        if (I(aVar.f8131a, 1024)) {
            this.f8142l = aVar.f8142l;
        }
        if (I(aVar.f8131a, 4096)) {
            this.f8149s = aVar.f8149s;
        }
        if (I(aVar.f8131a, 8192)) {
            this.f8145o = aVar.f8145o;
            this.f8146p = 0;
            this.f8131a &= -16385;
        }
        if (I(aVar.f8131a, 16384)) {
            this.f8146p = aVar.f8146p;
            this.f8145o = null;
            this.f8131a &= -8193;
        }
        if (I(aVar.f8131a, 32768)) {
            this.f8151u = aVar.f8151u;
        }
        if (I(aVar.f8131a, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            this.f8144n = aVar.f8144n;
        }
        if (I(aVar.f8131a, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            this.f8143m = aVar.f8143m;
        }
        if (I(aVar.f8131a, 2048)) {
            this.f8148r.putAll(aVar.f8148r);
            this.f8155y = aVar.f8155y;
        }
        if (I(aVar.f8131a, 524288)) {
            this.f8154x = aVar.f8154x;
        }
        if (!this.f8144n) {
            this.f8148r.clear();
            int i10 = this.f8131a & (-2049);
            this.f8131a = i10;
            this.f8143m = false;
            this.f8131a = i10 & (-131073);
            this.f8155y = true;
        }
        this.f8131a |= aVar.f8131a;
        this.f8147q.d(aVar.f8147q);
        return Y();
    }

    public T a0(b bVar) {
        if (this.f8152v) {
            return (T) clone().a0(bVar);
        }
        this.f8142l = (b) j.d(bVar);
        this.f8131a |= 1024;
        return Y();
    }

    public T b() {
        if (!this.f8150t || this.f8152v) {
            this.f8152v = true;
            return N();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public T b0(float f10) {
        if (this.f8152v) {
            return (T) clone().b0(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f8132b = f10;
        this.f8131a |= 2;
        return Y();
    }

    public T c() {
        return d0(DownsampleStrategy.f8065c, new a5.e());
    }

    public T c0(boolean z10) {
        if (this.f8152v) {
            return (T) clone().c0(true);
        }
        this.f8139i = !z10;
        this.f8131a |= 256;
        return Y();
    }

    /* renamed from: d */
    public T clone() {
        try {
            T t10 = (T) super.clone();
            e eVar = new e();
            t10.f8147q = eVar;
            eVar.d(this.f8147q);
            n5.b bVar = new n5.b();
            t10.f8148r = bVar;
            bVar.putAll(this.f8148r);
            t10.f8150t = false;
            t10.f8152v = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    final T d0(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        if (this.f8152v) {
            return (T) clone().d0(downsampleStrategy, gVar);
        }
        i(downsampleStrategy);
        return f0(gVar);
    }

    public T e(Class<?> cls) {
        if (this.f8152v) {
            return (T) clone().e(cls);
        }
        this.f8149s = (Class) j.d(cls);
        this.f8131a |= 4096;
        return Y();
    }

    <Y> T e0(Class<Y> cls, g<Y> gVar, boolean z10) {
        if (this.f8152v) {
            return (T) clone().e0(cls, gVar, z10);
        }
        j.d(cls);
        j.d(gVar);
        this.f8148r.put(cls, gVar);
        int i10 = this.f8131a | 2048;
        this.f8131a = i10;
        this.f8144n = true;
        int i11 = i10 | WXMediaMessage.THUMB_LENGTH_LIMIT;
        this.f8131a = i11;
        this.f8155y = false;
        if (z10) {
            this.f8131a = i11 | WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            this.f8143m = true;
        }
        return Y();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f8132b, this.f8132b) == 0 && this.f8136f == aVar.f8136f && k.c(this.f8135e, aVar.f8135e) && this.f8138h == aVar.f8138h && k.c(this.f8137g, aVar.f8137g) && this.f8146p == aVar.f8146p && k.c(this.f8145o, aVar.f8145o) && this.f8139i == aVar.f8139i && this.f8140j == aVar.f8140j && this.f8141k == aVar.f8141k && this.f8143m == aVar.f8143m && this.f8144n == aVar.f8144n && this.f8153w == aVar.f8153w && this.f8154x == aVar.f8154x && this.f8133c.equals(aVar.f8133c) && this.f8134d == aVar.f8134d && this.f8147q.equals(aVar.f8147q) && this.f8148r.equals(aVar.f8148r) && this.f8149s.equals(aVar.f8149s) && k.c(this.f8142l, aVar.f8142l) && k.c(this.f8151u, aVar.f8151u);
    }

    public T f(t4.a aVar) {
        if (this.f8152v) {
            return (T) clone().f(aVar);
        }
        this.f8133c = (t4.a) j.d(aVar);
        this.f8131a |= 4;
        return Y();
    }

    public T f0(g<Bitmap> gVar) {
        return g0(gVar, true);
    }

    public T g() {
        return Z(i.f25826b, Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    T g0(g<Bitmap> gVar, boolean z10) {
        if (this.f8152v) {
            return (T) clone().g0(gVar, z10);
        }
        com.bumptech.glide.load.resource.bitmap.h hVar = new com.bumptech.glide.load.resource.bitmap.h(gVar, z10);
        e0(Bitmap.class, gVar, z10);
        e0(Drawable.class, hVar, z10);
        e0(BitmapDrawable.class, hVar.c(), z10);
        e0(c.class, new e5.f(gVar), z10);
        return Y();
    }

    @Deprecated
    public T h0(Transformation<Bitmap>... transformationArr) {
        return g0(new q4.c(transformationArr), true);
    }

    public int hashCode() {
        return k.n(this.f8151u, k.n(this.f8142l, k.n(this.f8149s, k.n(this.f8148r, k.n(this.f8147q, k.n(this.f8134d, k.n(this.f8133c, k.o(this.f8154x, k.o(this.f8153w, k.o(this.f8144n, k.o(this.f8143m, k.m(this.f8141k, k.m(this.f8140j, k.o(this.f8139i, k.n(this.f8145o, k.m(this.f8146p, k.n(this.f8137g, k.m(this.f8138h, k.n(this.f8135e, k.m(this.f8136f, k.j(this.f8132b)))))))))))))))))))));
    }

    public T i(DownsampleStrategy downsampleStrategy) {
        return Z(DownsampleStrategy.f8068f, j.d(downsampleStrategy));
    }

    public T i0(boolean z10) {
        if (this.f8152v) {
            return (T) clone().i0(z10);
        }
        this.f8156z = z10;
        this.f8131a |= 1048576;
        return Y();
    }

    public T j(int i10) {
        if (this.f8152v) {
            return (T) clone().j(i10);
        }
        this.f8136f = i10;
        int i11 = this.f8131a | 32;
        this.f8131a = i11;
        this.f8135e = null;
        this.f8131a = i11 & (-17);
        return Y();
    }

    public T k(long j10) {
        return Z(q.f8123d, Long.valueOf(j10));
    }

    public final t4.a l() {
        return this.f8133c;
    }

    public final int m() {
        return this.f8136f;
    }

    public final Drawable n() {
        return this.f8135e;
    }

    public final Drawable o() {
        return this.f8145o;
    }

    public final int p() {
        return this.f8146p;
    }

    public final boolean q() {
        return this.f8154x;
    }

    public final e r() {
        return this.f8147q;
    }

    public final int s() {
        return this.f8140j;
    }

    public final int t() {
        return this.f8141k;
    }

    public final Drawable u() {
        return this.f8137g;
    }

    public final int v() {
        return this.f8138h;
    }

    public final Priority w() {
        return this.f8134d;
    }

    public final Class<?> x() {
        return this.f8149s;
    }

    public final b y() {
        return this.f8142l;
    }

    public final float z() {
        return this.f8132b;
    }
}
