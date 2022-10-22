package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.n0;
import d.c;
import d.d;
import d.e;
/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b  reason: collision with root package name */
    private static final PorterDuff.Mode f1196b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static j f1197c;

    /* renamed from: a  reason: collision with root package name */
    private n0 f1198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public class a implements n0.f {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1199a = {e.R, e.P, e.f24763a};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1200b = {e.f24777o, e.B, e.f24782t, e.f24778p, e.f24779q, e.f24781s, e.f24780r};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f1201c = {e.O, e.Q, e.f24773k, e.K, e.L, e.M, e.N};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f1202d = {e.f24785w, e.f24771i, e.f24784v};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f1203e = {e.J, e.S};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f1204f = {e.f24765c, e.f24769g, e.f24766d, e.f24770h};

        a() {
        }

        private boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i10) {
            int c10 = s0.c(context, d.a.f24735w);
            return new ColorStateList(new int[][]{s0.f1337b, s0.f1339d, s0.f1338c, s0.f1341f}, new int[]{s0.b(context, d.a.f24733u), b0.a.f(c10, i10), b0.a.f(c10, i10), i10});
        }

        private ColorStateList i(Context context) {
            return h(context, s0.c(context, d.a.f24732t));
        }

        private ColorStateList j(Context context) {
            return h(context, s0.c(context, d.a.f24733u));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i10 = d.a.f24738z;
            ColorStateList e10 = s0.e(context, i10);
            if (e10 == null || !e10.isStateful()) {
                iArr[0] = s0.f1337b;
                iArr2[0] = s0.b(context, i10);
                iArr[1] = s0.f1340e;
                iArr2[1] = s0.c(context, d.a.f24734v);
                iArr[2] = s0.f1341f;
                iArr2[2] = s0.c(context, i10);
            } else {
                iArr[0] = s0.f1337b;
                iArr2[0] = e10.getColorForState(iArr[0], 0);
                iArr[1] = s0.f1340e;
                iArr2[1] = s0.c(context, d.a.f24734v);
                iArr[2] = s0.f1341f;
                iArr2[2] = e10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(n0 n0Var, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable j10 = n0Var.j(context, e.F);
            Drawable j11 = n0Var.j(context, e.G);
            if ((j10 instanceof BitmapDrawable) && j10.getIntrinsicWidth() == dimensionPixelSize && j10.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) j10;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j10.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((j11 instanceof BitmapDrawable) && j11.getIntrinsicWidth() == dimensionPixelSize && j11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) j11;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j11.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (g0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = j.f1196b;
            }
            drawable.setColorFilter(j.e(i10, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.n0.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(Context context, int i10, Drawable drawable) {
            int i11;
            boolean z10;
            PorterDuff.Mode mode = j.f1196b;
            int i12 = 16842801;
            if (f(this.f1199a, i10)) {
                i12 = d.a.f24736x;
            } else if (f(this.f1201c, i10)) {
                i12 = d.a.f24734v;
            } else if (f(this.f1202d, i10)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else if (i10 == e.f24783u) {
                i12 = 16842800;
                i11 = Math.round(40.8f);
                z10 = true;
                if (!z10) {
                    return false;
                }
                if (g0.a(drawable)) {
                    drawable = drawable.mutate();
                }
                drawable.setColorFilter(j.e(s0.c(context, i12), mode));
                if (i11 != -1) {
                    drawable.setAlpha(i11);
                }
                return true;
            } else if (i10 != e.f24774l) {
                i11 = -1;
                z10 = false;
                i12 = 0;
                if (!z10) {
                }
            }
            i11 = -1;
            z10 = true;
            if (!z10) {
            }
        }

        @Override // androidx.appcompat.widget.n0.f
        public PorterDuff.Mode b(int i10) {
            if (i10 == e.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public Drawable c(n0 n0Var, Context context, int i10) {
            if (i10 == e.f24772j) {
                return new LayerDrawable(new Drawable[]{n0Var.j(context, e.f24771i), n0Var.j(context, e.f24773k)});
            }
            if (i10 == e.f24787y) {
                return l(n0Var, context, d.f24756i);
            }
            if (i10 == e.f24786x) {
                return l(n0Var, context, d.f24757j);
            }
            if (i10 == e.f24788z) {
                return l(n0Var, context, d.f24758k);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public ColorStateList d(Context context, int i10) {
            if (i10 == e.f24775m) {
                return e.a.a(context, c.f24744e);
            }
            if (i10 == e.I) {
                return e.a.a(context, c.f24747h);
            }
            if (i10 == e.H) {
                return k(context);
            }
            if (i10 == e.f24768f) {
                return j(context);
            }
            if (i10 == e.f24764b) {
                return g(context);
            }
            if (i10 == e.f24767e) {
                return i(context);
            }
            if (i10 == e.D || i10 == e.E) {
                return e.a.a(context, c.f24746g);
            }
            if (f(this.f1200b, i10)) {
                return s0.e(context, d.a.f24736x);
            }
            if (f(this.f1203e, i10)) {
                return e.a.a(context, c.f24743d);
            }
            if (f(this.f1204f, i10)) {
                return e.a.a(context, c.f24742c);
            }
            if (i10 == e.A) {
                return e.a.a(context, c.f24745f);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.n0.f
        public boolean e(Context context, int i10, Drawable drawable) {
            if (i10 == e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i11 = d.a.f24736x;
                m(findDrawableByLayerId, s0.c(context, i11), j.f1196b);
                m(layerDrawable.findDrawableByLayerId(16908303), s0.c(context, i11), j.f1196b);
                m(layerDrawable.findDrawableByLayerId(16908301), s0.c(context, d.a.f24734v), j.f1196b);
                return true;
            } else if (i10 != e.f24787y && i10 != e.f24786x && i10 != e.f24788z) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(16908288), s0.b(context, d.a.f24736x), j.f1196b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i12 = d.a.f24734v;
                m(findDrawableByLayerId2, s0.c(context, i12), j.f1196b);
                m(layerDrawable2.findDrawableByLayerId(16908301), s0.c(context, i12), j.f1196b);
                return true;
            }
        }
    }

    public static synchronized j b() {
        j jVar;
        synchronized (j.class) {
            if (f1197c == null) {
                h();
            }
            jVar = f1197c;
        }
        return jVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter l10;
        synchronized (j.class) {
            l10 = n0.l(i10, mode);
        }
        return l10;
    }

    public static synchronized void h() {
        synchronized (j.class) {
            if (f1197c == null) {
                j jVar = new j();
                f1197c = jVar;
                jVar.f1198a = n0.h();
                f1197c.f1198a.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, v0 v0Var, int[] iArr) {
        n0.w(drawable, v0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i10) {
        return this.f1198a.j(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i10, boolean z10) {
        return this.f1198a.k(context, i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i10) {
        return this.f1198a.m(context, i10);
    }

    public synchronized void g(Context context) {
        this.f1198a.s(context);
    }
}
