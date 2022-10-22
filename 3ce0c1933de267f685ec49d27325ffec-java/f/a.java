package f;

import a0.i;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.n0;
import f.b;
import f.e;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends f.e implements c0.d {

    /* renamed from: o  reason: collision with root package name */
    private c f26251o;

    /* renamed from: p  reason: collision with root package name */
    private g f26252p;

    /* renamed from: q  reason: collision with root package name */
    private int f26253q;

    /* renamed from: r  reason: collision with root package name */
    private int f26254r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f26255s;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        private final Animatable f26256a;

        b(Animatable animatable) {
            super();
            this.f26256a = animatable;
        }

        @Override // f.a.g
        public void c() {
            this.f26256a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f26256a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends e.a {
        androidx.collection.d<Long> K;
        androidx.collection.g<Integer> L;

        c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new androidx.collection.d<>();
            this.L = new androidx.collection.g<>();
        }

        private static long D(int i10, int i11) {
            return i11 | (i10 << 32);
        }

        int B(int[] iArr, Drawable drawable, int i10) {
            int z10 = super.z(iArr, drawable);
            this.L.j(z10, Integer.valueOf(i10));
            return z10;
        }

        int C(int i10, int i11, Drawable drawable, boolean z10) {
            int a10 = super.a(drawable);
            long D = D(i10, i11);
            long j10 = z10 ? 8589934592L : 0L;
            long j11 = a10;
            this.K.a(D, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.a(D(i11, i10), Long.valueOf(4294967296L | j11 | j10));
            }
            return a10;
        }

        int E(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return this.L.f(i10, 0).intValue();
        }

        int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        int G(int i10, int i11) {
            return (int) this.K.g(D(i10, i11), -1L).longValue();
        }

        boolean H(int i10, int i11) {
            return (this.K.g(D(i10, i11), -1L).longValue() & 4294967296L) != 0;
        }

        boolean I(int i10, int i11) {
            return (this.K.g(D(i10, i11), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // f.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // f.e.a, f.b.d
        void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // f.e.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.c f26257a;

        d(androidx.vectordrawable.graphics.drawable.c cVar) {
            super();
            this.f26257a = cVar;
        }

        @Override // f.a.g
        public void c() {
            this.f26257a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f26257a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectAnimator f26258a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f26259b;

        e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i10 = z10 ? numberOfFrames - 1 : 0;
            int i11 = z10 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            if (Build.VERSION.SDK_INT >= 18) {
                g.b.a(ofInt, true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f26259b = z11;
            this.f26258a = ofInt;
        }

        @Override // f.a.g
        public boolean a() {
            return this.f26259b;
        }

        @Override // f.a.g
        public void b() {
            this.f26258a.reverse();
        }

        @Override // f.a.g
        public void c() {
            this.f26258a.start();
        }

        @Override // f.a.g
        public void d() {
            this.f26258a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    private static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        private int[] f26260a;

        /* renamed from: b  reason: collision with root package name */
        private int f26261b;

        /* renamed from: c  reason: collision with root package name */
        private int f26262c;

        f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        int a() {
            return this.f26262c;
        }

        int b(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f26261b = numberOfFrames;
            int[] iArr = this.f26260a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f26260a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f26260a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f26262c = i10;
            return i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = (int) ((f10 * this.f26262c) + 0.5f);
            int i11 = this.f26261b;
            int[] iArr = this.f26260a;
            int i12 = 0;
            while (i12 < i11 && i10 >= iArr[i12]) {
                i10 -= iArr[i12];
                i12++;
            }
            return (i12 / i11) + (i12 < i11 ? i10 / this.f26262c : 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void o(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        q(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        r(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void p() {
        onStateChange(getState());
    }

    private int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray s10 = i.s(resources, theme, attributeSet, g.e.f27176h);
        int resourceId = s10.getResourceId(g.e.f27177i, 0);
        int resourceId2 = s10.getResourceId(g.e.f27178j, -1);
        Drawable j10 = resourceId2 > 0 ? n0.h().j(context, resourceId2) : null;
        s10.recycle();
        int[] k10 = k(attributeSet);
        if (j10 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("vector")) {
                j10 = androidx.vectordrawable.graphics.drawable.i.c(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j10 = g.c.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                j10 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j10 != null) {
            return this.f26251o.B(k10, j10, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    private int r(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray s10 = i.s(resources, theme, attributeSet, g.e.f27179k);
        int resourceId = s10.getResourceId(g.e.f27182n, -1);
        int resourceId2 = s10.getResourceId(g.e.f27181m, -1);
        int resourceId3 = s10.getResourceId(g.e.f27180l, -1);
        Drawable j10 = resourceId3 > 0 ? n0.h().j(context, resourceId3) : null;
        boolean z10 = s10.getBoolean(g.e.f27183o, false);
        s10.recycle();
        if (j10 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                j10 = androidx.vectordrawable.graphics.drawable.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                j10 = g.c.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                j10 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (j10 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f26251o.C(resourceId, resourceId2, j10, z10);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    private boolean s(int i10) {
        int i11;
        int G;
        g gVar;
        g gVar2 = this.f26252p;
        if (gVar2 == null) {
            i11 = c();
        } else if (i10 == this.f26253q) {
            return true;
        } else {
            if (i10 != this.f26254r || !gVar2.a()) {
                i11 = this.f26253q;
                gVar2.d();
            } else {
                gVar2.b();
                this.f26253q = this.f26254r;
                this.f26254r = i10;
                return true;
            }
        }
        this.f26252p = null;
        this.f26254r = -1;
        this.f26253q = -1;
        c cVar = this.f26251o;
        int E = cVar.E(i11);
        int E2 = cVar.E(i10);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            gVar = new e((AnimationDrawable) current, cVar.H(E, E2), I);
        } else if (current instanceof androidx.vectordrawable.graphics.drawable.c) {
            gVar = new d((androidx.vectordrawable.graphics.drawable.c) current);
        } else {
            if (current instanceof Animatable) {
                gVar = new b((Animatable) current);
            }
            return false;
        }
        gVar.c();
        this.f26252p = gVar;
        this.f26254r = i11;
        this.f26253q = i10;
        return true;
    }

    private void t(TypedArray typedArray) {
        c cVar = this.f26251o;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f26280d |= g.c.b(typedArray);
        }
        cVar.x(typedArray.getBoolean(g.e.f27172d, cVar.f26285i));
        cVar.t(typedArray.getBoolean(g.e.f27173e, cVar.f26288l));
        cVar.u(typedArray.getInt(g.e.f27174f, cVar.A));
        cVar.v(typedArray.getInt(g.e.f27175g, cVar.B));
        setDither(typedArray.getBoolean(g.e.f27170b, cVar.f26300x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.e, f.b
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.f26251o = (c) dVar;
        }
    }

    @Override // f.e, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f26252p;
        if (gVar != null) {
            gVar.d();
            this.f26252p = null;
            g(this.f26253q);
            this.f26253q = -1;
            this.f26254r = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public c j() {
        return new c(this.f26251o, this, null);
    }

    @Override // f.e, f.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f26255s && super.mutate() == this) {
            this.f26251o.r();
            this.f26255s = true;
        }
        return this;
    }

    public void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray s10 = i.s(resources, theme, attributeSet, g.e.f27169a);
        setVisible(s10.getBoolean(g.e.f27171c, true), true);
        t(s10);
        i(resources);
        s10.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f.e, f.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int F = this.f26251o.F(iArr);
        boolean z10 = F != c() && (s(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z10 | current.setState(iArr) : z10;
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f26252p;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    a(c cVar, Resources resources) {
        super(null);
        this.f26253q = -1;
        this.f26254r = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
