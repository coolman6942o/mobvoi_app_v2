package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import j3.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: b  reason: collision with root package name */
    private com.airbnb.lottie.d f6454b;

    /* renamed from: c  reason: collision with root package name */
    private final k3.e f6455c;

    /* renamed from: h  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f6460h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView.ScaleType f6461i;

    /* renamed from: j  reason: collision with root package name */
    private f3.b f6462j;

    /* renamed from: k  reason: collision with root package name */
    private String f6463k;

    /* renamed from: l  reason: collision with root package name */
    private com.airbnb.lottie.b f6464l;

    /* renamed from: m  reason: collision with root package name */
    private f3.a f6465m;

    /* renamed from: n  reason: collision with root package name */
    com.airbnb.lottie.a f6466n;

    /* renamed from: o  reason: collision with root package name */
    q f6467o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f6468p;

    /* renamed from: q  reason: collision with root package name */
    private com.airbnb.lottie.model.layer.b f6469q;

    /* renamed from: s  reason: collision with root package name */
    private boolean f6471s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6472t;

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f6453a = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private float f6456d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6457e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6458f = false;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<o> f6459g = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private int f6470r = 255;

    /* renamed from: u  reason: collision with root package name */
    private boolean f6473u = true;

    /* renamed from: v  reason: collision with root package name */
    private boolean f6474v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class a implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6475a;

        a(String str) {
            this.f6475a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.U(this.f6475a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class b implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6478b;

        b(int i10, int i11) {
            this.f6477a = i10;
            this.f6478b = i11;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.T(this.f6477a, this.f6478b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class c implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6480a;

        c(int i10) {
            this.f6480a = i10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.N(this.f6480a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class d implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f6482a;

        d(float f10) {
            this.f6482a = f10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.Z(this.f6482a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class e implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g3.d f6484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f6485b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l3.c f6486c;

        e(g3.d dVar, Object obj, l3.c cVar) {
            this.f6484a = dVar;
            this.f6485b = obj;
            this.f6486c = cVar;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.c(this.f6484a, this.f6485b, this.f6486c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0088f implements ValueAnimator.AnimatorUpdateListener {
        C0088f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (f.this.f6469q != null) {
                f.this.f6469q.H(f.this.f6455c.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class g implements o {
        g() {
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class h implements o {
        h() {
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class i implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6491a;

        i(int i10) {
            this.f6491a = i10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.V(this.f6491a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class j implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f6493a;

        j(float f10) {
            this.f6493a = f10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.X(this.f6493a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class k implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f6495a;

        k(int i10) {
            this.f6495a = i10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.Q(this.f6495a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class l implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f6497a;

        l(float f10) {
            this.f6497a = f10;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.S(this.f6497a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class m implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6499a;

        m(String str) {
            this.f6499a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.W(this.f6499a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class n implements o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f6501a;

        n(String str) {
            this.f6501a = str;
        }

        @Override // com.airbnb.lottie.f.o
        public void a(com.airbnb.lottie.d dVar) {
            f.this.R(this.f6501a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public interface o {
        void a(com.airbnb.lottie.d dVar);
    }

    public f() {
        k3.e eVar = new k3.e();
        this.f6455c = eVar;
        new HashSet();
        C0088f fVar = new C0088f();
        this.f6460h = fVar;
        eVar.addUpdateListener(fVar);
    }

    private void d() {
        this.f6469q = new com.airbnb.lottie.model.layer.b(this, s.a(this.f6454b), this.f6454b.j(), this.f6454b);
    }

    private void g(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f6461i) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    private void h(Canvas canvas) {
        float f10;
        if (this.f6469q != null) {
            int i10 = -1;
            Rect bounds = getBounds();
            float width = bounds.width() / this.f6454b.b().width();
            float height = bounds.height() / this.f6454b.b().height();
            if (this.f6473u) {
                float min = Math.min(width, height);
                if (min < 1.0f) {
                    f10 = 1.0f / min;
                    width /= f10;
                    height /= f10;
                } else {
                    f10 = 1.0f;
                }
                if (f10 > 1.0f) {
                    i10 = canvas.save();
                    float width2 = bounds.width() / 2.0f;
                    float height2 = bounds.height() / 2.0f;
                    float f11 = width2 * min;
                    float f12 = min * height2;
                    canvas.translate(width2 - f11, height2 - f12);
                    canvas.scale(f10, f10, f11, f12);
                }
            }
            this.f6453a.reset();
            this.f6453a.preScale(width, height);
            this.f6469q.g(canvas, this.f6453a, this.f6470r);
            if (i10 > 0) {
                canvas.restoreToCount(i10);
            }
        }
    }

    private void i(Canvas canvas) {
        float f10;
        if (this.f6469q != null) {
            float f11 = this.f6456d;
            float u10 = u(canvas);
            if (f11 > u10) {
                f10 = this.f6456d / u10;
            } else {
                u10 = f11;
                f10 = 1.0f;
            }
            int i10 = -1;
            if (f10 > 1.0f) {
                i10 = canvas.save();
                float width = this.f6454b.b().width() / 2.0f;
                float height = this.f6454b.b().height() / 2.0f;
                float f12 = width * u10;
                float f13 = height * u10;
                canvas.translate((A() * width) - f12, (A() * height) - f13);
                canvas.scale(f10, f10, f12, f13);
            }
            this.f6453a.reset();
            this.f6453a.preScale(u10, u10);
            this.f6469q.g(canvas, this.f6453a, this.f6470r);
            if (i10 > 0) {
                canvas.restoreToCount(i10);
            }
        }
    }

    private void i0() {
        if (this.f6454b != null) {
            float A = A();
            setBounds(0, 0, (int) (this.f6454b.b().width() * A), (int) (this.f6454b.b().height() * A));
        }
    }

    private Context n() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private f3.a o() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f6465m == null) {
            this.f6465m = new f3.a(getCallback(), this.f6466n);
        }
        return this.f6465m;
    }

    private f3.b r() {
        if (getCallback() == null) {
            return null;
        }
        f3.b bVar = this.f6462j;
        if (bVar != null && !bVar.b(n())) {
            this.f6462j = null;
        }
        if (this.f6462j == null) {
            this.f6462j = new f3.b(getCallback(), this.f6463k, this.f6464l, this.f6454b.i());
        }
        return this.f6462j;
    }

    private float u(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f6454b.b().width(), canvas.getHeight() / this.f6454b.b().height());
    }

    public float A() {
        return this.f6456d;
    }

    public float B() {
        return this.f6455c.n();
    }

    public q C() {
        return this.f6467o;
    }

    public Typeface D(String str, String str2) {
        f3.a o10 = o();
        if (o10 != null) {
            return o10.b(str, str2);
        }
        return null;
    }

    public boolean E() {
        k3.e eVar = this.f6455c;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean F() {
        return this.f6472t;
    }

    public void G() {
        this.f6459g.clear();
        this.f6455c.p();
    }

    public void H() {
        if (this.f6469q == null) {
            this.f6459g.add(new g());
            return;
        }
        if (this.f6457e || y() == 0) {
            this.f6455c.q();
        }
        if (!this.f6457e) {
            N((int) (B() < 0.0f ? v() : t()));
            this.f6455c.g();
        }
    }

    public List<g3.d> I(g3.d dVar) {
        if (this.f6469q == null) {
            k3.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f6469q.h(dVar, 0, arrayList, new g3.d(new String[0]));
        return arrayList;
    }

    public void J() {
        if (this.f6469q == null) {
            this.f6459g.add(new h());
            return;
        }
        if (this.f6457e || y() == 0) {
            this.f6455c.u();
        }
        if (!this.f6457e) {
            N((int) (B() < 0.0f ? v() : t()));
            this.f6455c.g();
        }
    }

    public void K(boolean z10) {
        this.f6472t = z10;
    }

    public boolean L(com.airbnb.lottie.d dVar) {
        if (this.f6454b == dVar) {
            return false;
        }
        this.f6474v = false;
        f();
        this.f6454b = dVar;
        d();
        this.f6455c.w(dVar);
        Z(this.f6455c.getAnimatedFraction());
        d0(this.f6456d);
        i0();
        Iterator it = new ArrayList(this.f6459g).iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(dVar);
            it.remove();
        }
        this.f6459g.clear();
        dVar.u(this.f6471s);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void M(com.airbnb.lottie.a aVar) {
        f3.a aVar2 = this.f6465m;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void N(int i10) {
        if (this.f6454b == null) {
            this.f6459g.add(new c(i10));
        } else {
            this.f6455c.x(i10);
        }
    }

    public void O(com.airbnb.lottie.b bVar) {
        this.f6464l = bVar;
        f3.b bVar2 = this.f6462j;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public void P(String str) {
        this.f6463k = str;
    }

    public void Q(int i10) {
        if (this.f6454b == null) {
            this.f6459g.add(new k(i10));
        } else {
            this.f6455c.y(i10 + 0.99f);
        }
    }

    public void R(String str) {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            this.f6459g.add(new n(str));
            return;
        }
        g3.g k10 = dVar.k(str);
        if (k10 != null) {
            Q((int) (k10.f27243b + k10.f27244c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void S(float f10) {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            this.f6459g.add(new l(f10));
        } else {
            Q((int) k3.g.j(dVar.o(), this.f6454b.f(), f10));
        }
    }

    public void T(int i10, int i11) {
        if (this.f6454b == null) {
            this.f6459g.add(new b(i10, i11));
        } else {
            this.f6455c.z(i10, i11 + 0.99f);
        }
    }

    public void U(String str) {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            this.f6459g.add(new a(str));
            return;
        }
        g3.g k10 = dVar.k(str);
        if (k10 != null) {
            int i10 = (int) k10.f27243b;
            T(i10, ((int) k10.f27244c) + i10);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void V(int i10) {
        if (this.f6454b == null) {
            this.f6459g.add(new i(i10));
        } else {
            this.f6455c.A(i10);
        }
    }

    public void W(String str) {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            this.f6459g.add(new m(str));
            return;
        }
        g3.g k10 = dVar.k(str);
        if (k10 != null) {
            V((int) k10.f27243b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void X(float f10) {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            this.f6459g.add(new j(f10));
        } else {
            V((int) k3.g.j(dVar.o(), this.f6454b.f(), f10));
        }
    }

    public void Y(boolean z10) {
        this.f6471s = z10;
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar != null) {
            dVar.u(z10);
        }
    }

    public void Z(float f10) {
        if (this.f6454b == null) {
            this.f6459g.add(new d(f10));
            return;
        }
        com.airbnb.lottie.c.a("Drawable#setProgress");
        this.f6455c.x(k3.g.j(this.f6454b.o(), this.f6454b.f(), f10));
        com.airbnb.lottie.c.b("Drawable#setProgress");
    }

    public void a0(int i10) {
        this.f6455c.setRepeatCount(i10);
    }

    public void b0(int i10) {
        this.f6455c.setRepeatMode(i10);
    }

    public <T> void c(g3.d dVar, T t10, l3.c<T> cVar) {
        if (this.f6469q == null) {
            this.f6459g.add(new e(dVar, t10, cVar));
            return;
        }
        boolean z10 = true;
        if (dVar.d() != null) {
            dVar.d().d(t10, cVar);
        } else {
            List<g3.d> I = I(dVar);
            for (int i10 = 0; i10 < I.size(); i10++) {
                I.get(i10).d().d(t10, cVar);
            }
            z10 = true ^ I.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (t10 == com.airbnb.lottie.k.A) {
                Z(x());
            }
        }
    }

    public void c0(boolean z10) {
        this.f6458f = z10;
    }

    public void d0(float f10) {
        this.f6456d = f10;
        i0();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f6474v = false;
        com.airbnb.lottie.c.a("Drawable#draw");
        if (this.f6458f) {
            try {
                g(canvas);
            } catch (Throwable th2) {
                k3.d.b("Lottie crashed in draw!", th2);
            }
        } else {
            g(canvas);
        }
        com.airbnb.lottie.c.b("Drawable#draw");
    }

    public void e() {
        this.f6459g.clear();
        this.f6455c.cancel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(ImageView.ScaleType scaleType) {
        this.f6461i = scaleType;
    }

    public void f() {
        if (this.f6455c.isRunning()) {
            this.f6455c.cancel();
        }
        this.f6454b = null;
        this.f6469q = null;
        this.f6462j = null;
        this.f6455c.f();
        invalidateSelf();
    }

    public void f0(float f10) {
        this.f6455c.B(f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(Boolean bool) {
        this.f6457e = bool.booleanValue();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f6470r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().height() * A());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.b().width() * A());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h0(q qVar) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (!this.f6474v) {
            this.f6474v = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return E();
    }

    public void j(boolean z10) {
        if (this.f6468p != z10) {
            if (Build.VERSION.SDK_INT < 19) {
                k3.d.c("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.f6468p = z10;
            if (this.f6454b != null) {
                d();
            }
        }
    }

    public boolean j0() {
        return this.f6454b.c().l() > 0;
    }

    public boolean k() {
        return this.f6468p;
    }

    public void l() {
        this.f6459g.clear();
        this.f6455c.g();
    }

    public com.airbnb.lottie.d m() {
        return this.f6454b;
    }

    public int p() {
        return (int) this.f6455c.j();
    }

    public Bitmap q(String str) {
        f3.b r10 = r();
        if (r10 != null) {
            return r10.a(str);
        }
        return null;
    }

    public String s() {
        return this.f6463k;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f6470r = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        k3.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        H();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        l();
    }

    public float t() {
        return this.f6455c.l();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v() {
        return this.f6455c.m();
    }

    public com.airbnb.lottie.n w() {
        com.airbnb.lottie.d dVar = this.f6454b;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }

    public float x() {
        return this.f6455c.i();
    }

    public int y() {
        return this.f6455c.getRepeatCount();
    }

    public int z() {
        return this.f6455c.getRepeatMode();
    }
}
