package w7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import d7.l;
/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: m  reason: collision with root package name */
    public static final w7.c f36064m = new i(0.5f);

    /* renamed from: a  reason: collision with root package name */
    d f36065a;

    /* renamed from: b  reason: collision with root package name */
    d f36066b;

    /* renamed from: c  reason: collision with root package name */
    d f36067c;

    /* renamed from: d  reason: collision with root package name */
    d f36068d;

    /* renamed from: e  reason: collision with root package name */
    w7.c f36069e;

    /* renamed from: f  reason: collision with root package name */
    w7.c f36070f;

    /* renamed from: g  reason: collision with root package name */
    w7.c f36071g;

    /* renamed from: h  reason: collision with root package name */
    w7.c f36072h;

    /* renamed from: i  reason: collision with root package name */
    f f36073i;

    /* renamed from: j  reason: collision with root package name */
    f f36074j;

    /* renamed from: k  reason: collision with root package name */
    f f36075k;

    /* renamed from: l  reason: collision with root package name */
    f f36076l;

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes.dex */
    public interface c {
        w7.c a(w7.c cVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    private static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new w7.a(i12));
    }

    private static b d(Context context, int i10, int i11, w7.c cVar) {
        if (i11 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
            i10 = i11;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i10, l.f25391d4);
        try {
            int i12 = obtainStyledAttributes.getInt(l.f25399e4, 0);
            int i13 = obtainStyledAttributes.getInt(l.f25423h4, i12);
            int i14 = obtainStyledAttributes.getInt(l.f25431i4, i12);
            int i15 = obtainStyledAttributes.getInt(l.f25415g4, i12);
            int i16 = obtainStyledAttributes.getInt(l.f25407f4, i12);
            w7.c m10 = m(obtainStyledAttributes, l.f25439j4, cVar);
            w7.c m11 = m(obtainStyledAttributes, l.f25463m4, m10);
            w7.c m12 = m(obtainStyledAttributes, l.f25471n4, m10);
            w7.c m13 = m(obtainStyledAttributes, l.f25455l4, m10);
            return new b().y(i13, m11).C(i14, m12).u(i15, m13).q(i16, m(obtainStyledAttributes, l.f25447k4, m10));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new w7.a(i12));
    }

    public static b g(Context context, AttributeSet attributeSet, int i10, int i11, w7.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25462m3, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(l.f25470n3, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(l.f25478o3, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    private static w7.c m(TypedArray typedArray, int i10, w7.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return cVar;
        }
        int i11 = peekValue.type;
        if (i11 == 5) {
            return new w7.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i11 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f h() {
        return this.f36075k;
    }

    public d i() {
        return this.f36068d;
    }

    public w7.c j() {
        return this.f36072h;
    }

    public d k() {
        return this.f36067c;
    }

    public w7.c l() {
        return this.f36071g;
    }

    public f n() {
        return this.f36076l;
    }

    public f o() {
        return this.f36074j;
    }

    public f p() {
        return this.f36073i;
    }

    public d q() {
        return this.f36065a;
    }

    public w7.c r() {
        return this.f36069e;
    }

    public d s() {
        return this.f36066b;
    }

    public w7.c t() {
        return this.f36070f;
    }

    public boolean u(RectF rectF) {
        boolean z10 = this.f36076l.getClass().equals(f.class) && this.f36074j.getClass().equals(f.class) && this.f36073i.getClass().equals(f.class) && this.f36075k.getClass().equals(f.class);
        float a10 = this.f36069e.a(rectF);
        return z10 && ((this.f36070f.a(rectF) > a10 ? 1 : (this.f36070f.a(rectF) == a10 ? 0 : -1)) == 0 && (this.f36072h.a(rectF) > a10 ? 1 : (this.f36072h.a(rectF) == a10 ? 0 : -1)) == 0 && (this.f36071g.a(rectF) > a10 ? 1 : (this.f36071g.a(rectF) == a10 ? 0 : -1)) == 0) && ((this.f36066b instanceof j) && (this.f36065a instanceof j) && (this.f36067c instanceof j) && (this.f36068d instanceof j));
    }

    public b v() {
        return new b(this);
    }

    public k w(float f10) {
        return v().o(f10).m();
    }

    public k x(w7.c cVar) {
        return v().p(cVar).m();
    }

    public k y(c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(b bVar) {
        this.f36065a = bVar.f36077a;
        this.f36066b = bVar.f36078b;
        this.f36067c = bVar.f36079c;
        this.f36068d = bVar.f36080d;
        this.f36069e = bVar.f36081e;
        this.f36070f = bVar.f36082f;
        this.f36071g = bVar.f36083g;
        this.f36072h = bVar.f36084h;
        this.f36073i = bVar.f36085i;
        this.f36074j = bVar.f36086j;
        this.f36075k = bVar.f36087k;
        this.f36076l = bVar.f36088l;
    }

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private d f36077a;

        /* renamed from: b  reason: collision with root package name */
        private d f36078b;

        /* renamed from: c  reason: collision with root package name */
        private d f36079c;

        /* renamed from: d  reason: collision with root package name */
        private d f36080d;

        /* renamed from: e  reason: collision with root package name */
        private w7.c f36081e;

        /* renamed from: f  reason: collision with root package name */
        private w7.c f36082f;

        /* renamed from: g  reason: collision with root package name */
        private w7.c f36083g;

        /* renamed from: h  reason: collision with root package name */
        private w7.c f36084h;

        /* renamed from: i  reason: collision with root package name */
        private f f36085i;

        /* renamed from: j  reason: collision with root package name */
        private f f36086j;

        /* renamed from: k  reason: collision with root package name */
        private f f36087k;

        /* renamed from: l  reason: collision with root package name */
        private f f36088l;

        public b() {
            this.f36077a = h.b();
            this.f36078b = h.b();
            this.f36079c = h.b();
            this.f36080d = h.b();
            this.f36081e = new w7.a(0.0f);
            this.f36082f = new w7.a(0.0f);
            this.f36083g = new w7.a(0.0f);
            this.f36084h = new w7.a(0.0f);
            this.f36085i = h.c();
            this.f36086j = h.c();
            this.f36087k = h.c();
            this.f36088l = h.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f36063a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f36012a;
            }
            return -1.0f;
        }

        public b A(float f10) {
            this.f36081e = new w7.a(f10);
            return this;
        }

        public b B(w7.c cVar) {
            this.f36081e = cVar;
            return this;
        }

        public b C(int i10, w7.c cVar) {
            return D(h.a(i10)).F(cVar);
        }

        public b D(d dVar) {
            this.f36078b = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                E(n10);
            }
            return this;
        }

        public b E(float f10) {
            this.f36082f = new w7.a(f10);
            return this;
        }

        public b F(w7.c cVar) {
            this.f36082f = cVar;
            return this;
        }

        public k m() {
            return new k(this);
        }

        public b o(float f10) {
            return A(f10).E(f10).w(f10).s(f10);
        }

        public b p(w7.c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        public b q(int i10, w7.c cVar) {
            return r(h.a(i10)).t(cVar);
        }

        public b r(d dVar) {
            this.f36080d = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                s(n10);
            }
            return this;
        }

        public b s(float f10) {
            this.f36084h = new w7.a(f10);
            return this;
        }

        public b t(w7.c cVar) {
            this.f36084h = cVar;
            return this;
        }

        public b u(int i10, w7.c cVar) {
            return v(h.a(i10)).x(cVar);
        }

        public b v(d dVar) {
            this.f36079c = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                w(n10);
            }
            return this;
        }

        public b w(float f10) {
            this.f36083g = new w7.a(f10);
            return this;
        }

        public b x(w7.c cVar) {
            this.f36083g = cVar;
            return this;
        }

        public b y(int i10, w7.c cVar) {
            return z(h.a(i10)).B(cVar);
        }

        public b z(d dVar) {
            this.f36077a = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                A(n10);
            }
            return this;
        }

        public b(k kVar) {
            this.f36077a = h.b();
            this.f36078b = h.b();
            this.f36079c = h.b();
            this.f36080d = h.b();
            this.f36081e = new w7.a(0.0f);
            this.f36082f = new w7.a(0.0f);
            this.f36083g = new w7.a(0.0f);
            this.f36084h = new w7.a(0.0f);
            this.f36085i = h.c();
            this.f36086j = h.c();
            this.f36087k = h.c();
            this.f36088l = h.c();
            this.f36077a = kVar.f36065a;
            this.f36078b = kVar.f36066b;
            this.f36079c = kVar.f36067c;
            this.f36080d = kVar.f36068d;
            this.f36081e = kVar.f36069e;
            this.f36082f = kVar.f36070f;
            this.f36083g = kVar.f36071g;
            this.f36084h = kVar.f36072h;
            this.f36085i = kVar.f36073i;
            this.f36086j = kVar.f36074j;
            this.f36087k = kVar.f36075k;
            this.f36088l = kVar.f36076l;
        }
    }

    public k() {
        this.f36065a = h.b();
        this.f36066b = h.b();
        this.f36067c = h.b();
        this.f36068d = h.b();
        this.f36069e = new w7.a(0.0f);
        this.f36070f = new w7.a(0.0f);
        this.f36071g = new w7.a(0.0f);
        this.f36072h = new w7.a(0.0f);
        this.f36073i = h.c();
        this.f36074j = h.c();
        this.f36075k = h.c();
        this.f36076l = h.c();
    }
}
