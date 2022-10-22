package f;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private d f26263a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f26264b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f26265c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f26266d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26268f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26270h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f26271i;

    /* renamed from: j  reason: collision with root package name */
    private long f26272j;

    /* renamed from: k  reason: collision with root package name */
    private long f26273k;

    /* renamed from: l  reason: collision with root package name */
    private c f26274l;

    /* renamed from: e  reason: collision with root package name */
    private int f26267e = 255;

    /* renamed from: g  reason: collision with root package name */
    private int f26269g = -1;

    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DrawableContainer.java */
    /* renamed from: f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0283b {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static class c implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Drawable.Callback f26276a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f26276a;
            this.f26276a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f26276a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f26276a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f26276a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static abstract class d extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final b f26277a;

        /* renamed from: b  reason: collision with root package name */
        Resources f26278b;

        /* renamed from: c  reason: collision with root package name */
        int f26279c;

        /* renamed from: d  reason: collision with root package name */
        int f26280d;

        /* renamed from: e  reason: collision with root package name */
        int f26281e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f26282f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f26283g;

        /* renamed from: h  reason: collision with root package name */
        int f26284h;

        /* renamed from: i  reason: collision with root package name */
        boolean f26285i;

        /* renamed from: j  reason: collision with root package name */
        boolean f26286j;

        /* renamed from: k  reason: collision with root package name */
        Rect f26287k;

        /* renamed from: l  reason: collision with root package name */
        boolean f26288l;

        /* renamed from: m  reason: collision with root package name */
        boolean f26289m;

        /* renamed from: n  reason: collision with root package name */
        int f26290n;

        /* renamed from: o  reason: collision with root package name */
        int f26291o;

        /* renamed from: p  reason: collision with root package name */
        int f26292p;

        /* renamed from: q  reason: collision with root package name */
        int f26293q;

        /* renamed from: r  reason: collision with root package name */
        boolean f26294r;

        /* renamed from: s  reason: collision with root package name */
        int f26295s;

        /* renamed from: t  reason: collision with root package name */
        boolean f26296t;

        /* renamed from: u  reason: collision with root package name */
        boolean f26297u;

        /* renamed from: v  reason: collision with root package name */
        boolean f26298v;

        /* renamed from: w  reason: collision with root package name */
        boolean f26299w;

        /* renamed from: x  reason: collision with root package name */
        boolean f26300x;

        /* renamed from: y  reason: collision with root package name */
        boolean f26301y;

        /* renamed from: z  reason: collision with root package name */
        int f26302z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(d dVar, b bVar, Resources resources) {
            Resources resources2;
            this.f26285i = false;
            this.f26288l = false;
            this.f26300x = true;
            this.A = 0;
            this.B = 0;
            this.f26277a = bVar;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = dVar != null ? dVar.f26278b : null;
            }
            this.f26278b = resources2;
            int f10 = b.f(resources, dVar != null ? dVar.f26279c : 0);
            this.f26279c = f10;
            if (dVar != null) {
                this.f26280d = dVar.f26280d;
                this.f26281e = dVar.f26281e;
                this.f26298v = true;
                this.f26299w = true;
                this.f26285i = dVar.f26285i;
                this.f26288l = dVar.f26288l;
                this.f26300x = dVar.f26300x;
                this.f26301y = dVar.f26301y;
                this.f26302z = dVar.f26302z;
                this.A = dVar.A;
                this.B = dVar.B;
                this.C = dVar.C;
                this.D = dVar.D;
                this.E = dVar.E;
                this.F = dVar.F;
                this.G = dVar.G;
                this.H = dVar.H;
                this.I = dVar.I;
                if (dVar.f26279c == f10) {
                    if (dVar.f26286j) {
                        this.f26287k = dVar.f26287k != null ? new Rect(dVar.f26287k) : rect;
                        this.f26286j = true;
                    }
                    if (dVar.f26289m) {
                        this.f26290n = dVar.f26290n;
                        this.f26291o = dVar.f26291o;
                        this.f26292p = dVar.f26292p;
                        this.f26293q = dVar.f26293q;
                        this.f26289m = true;
                    }
                }
                if (dVar.f26294r) {
                    this.f26295s = dVar.f26295s;
                    this.f26294r = true;
                }
                if (dVar.f26296t) {
                    this.f26297u = dVar.f26297u;
                    this.f26296t = true;
                }
                Drawable[] drawableArr = dVar.f26283g;
                this.f26283g = new Drawable[drawableArr.length];
                this.f26284h = dVar.f26284h;
                SparseArray<Drawable.ConstantState> sparseArray = dVar.f26282f;
                if (sparseArray != null) {
                    this.f26282f = sparseArray.clone();
                } else {
                    this.f26282f = new SparseArray<>(this.f26284h);
                }
                int i10 = this.f26284h;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11] != null) {
                        Drawable.ConstantState constantState = drawableArr[i11].getConstantState();
                        if (constantState != null) {
                            this.f26282f.put(i11, constantState);
                        } else {
                            this.f26283g[i11] = drawableArr[i11];
                        }
                    }
                }
                return;
            }
            this.f26283g = new Drawable[10];
            this.f26284h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f26282f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f26283g[this.f26282f.keyAt(i10)] = s(this.f26282f.valueAt(i10).newDrawable(this.f26278b));
                }
                this.f26282f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, this.f26302z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f26277a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i10 = this.f26284h;
            if (i10 >= this.f26283g.length) {
                o(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f26277a);
            this.f26283g[i10] = drawable;
            this.f26284h++;
            this.f26281e = drawable.getChangingConfigurations() | this.f26281e;
            p();
            this.f26287k = null;
            this.f26286j = false;
            this.f26289m = false;
            this.f26298v = false;
            return i10;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i10 = this.f26284h;
                Drawable[] drawableArr = this.f26283g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11] != null && androidx.core.graphics.drawable.a.b(drawableArr[i11])) {
                        androidx.core.graphics.drawable.a.a(drawableArr[i11], theme);
                        this.f26281e |= drawableArr[i11].getChangingConfigurations();
                    }
                }
                y(C0283b.c(theme));
            }
        }

        public boolean c() {
            if (this.f26298v) {
                return this.f26299w;
            }
            e();
            this.f26298v = true;
            int i10 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f26299w = false;
                    return false;
                }
            }
            this.f26299w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i10 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f26282f.get(i11);
                    if (constantState != null && C0283b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f26289m = true;
            e();
            int i10 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            this.f26291o = -1;
            this.f26290n = -1;
            this.f26293q = 0;
            this.f26292p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f26290n) {
                    this.f26290n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f26291o) {
                    this.f26291o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f26292p) {
                    this.f26292p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f26293q) {
                    this.f26293q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f26283g.length;
        }

        public final Drawable g(int i10) {
            int indexOfKey;
            Drawable drawable = this.f26283g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f26282f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable s10 = s(this.f26282f.valueAt(indexOfKey).newDrawable(this.f26278b));
            this.f26283g[i10] = s10;
            this.f26282f.removeAt(indexOfKey);
            if (this.f26282f.size() == 0) {
                this.f26282f = null;
            }
            return s10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f26280d | this.f26281e;
        }

        public final int h() {
            return this.f26284h;
        }

        public final int i() {
            if (!this.f26289m) {
                d();
            }
            return this.f26291o;
        }

        public final int j() {
            if (!this.f26289m) {
                d();
            }
            return this.f26293q;
        }

        public final int k() {
            if (!this.f26289m) {
                d();
            }
            return this.f26292p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f26285i) {
                return null;
            }
            Rect rect2 = this.f26287k;
            if (rect2 != null || this.f26286j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i10 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f26286j = true;
            this.f26287k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f26289m) {
                d();
            }
            return this.f26290n;
        }

        public final int n() {
            if (this.f26294r) {
                return this.f26295s;
            }
            e();
            int i10 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            int opacity = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i11].getOpacity());
            }
            this.f26295s = opacity;
            this.f26294r = true;
            return opacity;
        }

        public void o(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f26283g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f26283g = drawableArr;
        }

        void p() {
            this.f26294r = false;
            this.f26296t = false;
        }

        public final boolean q() {
            return this.f26288l;
        }

        abstract void r();

        public final void t(boolean z10) {
            this.f26288l = z10;
        }

        public final void u(int i10) {
            this.A = i10;
        }

        public final void v(int i10) {
            this.B = i10;
        }

        final boolean w(int i10, int i11) {
            int i12 = this.f26284h;
            Drawable[] drawableArr = this.f26283g;
            boolean z10 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                if (drawableArr[i13] != null) {
                    boolean m10 = Build.VERSION.SDK_INT >= 23 ? androidx.core.graphics.drawable.a.m(drawableArr[i13], i10) : false;
                    if (i13 == i11) {
                        z10 = m10;
                    }
                }
            }
            this.f26302z = i10;
            return z10;
        }

        public final void x(boolean z10) {
            this.f26285i = z10;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f26278b = resources;
                int f10 = b.f(resources, this.f26279c);
                int i10 = this.f26279c;
                this.f26279c = f10;
                if (i10 != f10) {
                    this.f26289m = false;
                    this.f26286j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f26274l == null) {
            this.f26274l = new c();
        }
        drawable.setCallback(this.f26274l.b(drawable.getCallback()));
        try {
            if (this.f26263a.A <= 0 && this.f26268f) {
                drawable.setAlpha(this.f26267e);
            }
            d dVar = this.f26263a;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    androidx.core.graphics.drawable.a.o(drawable, dVar.F);
                }
                d dVar2 = this.f26263a;
                if (dVar2.I) {
                    androidx.core.graphics.drawable.a.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f26263a.f26300x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
            }
            if (i10 >= 19) {
                androidx.core.graphics.drawable.a.j(drawable, this.f26263a.C);
            }
            Rect rect = this.f26264b;
            if (i10 >= 21 && rect != null) {
                androidx.core.graphics.drawable.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f26274l.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    static int f(Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(boolean z10) {
        boolean z11;
        Drawable drawable;
        boolean z12 = true;
        this.f26268f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            long j10 = this.f26272j;
            if (j10 != 0) {
                if (j10 <= uptimeMillis) {
                    drawable2.setAlpha(this.f26267e);
                    this.f26272j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j10 - uptimeMillis) * 255)) / this.f26263a.A)) * this.f26267e) / 255);
                    z11 = true;
                    drawable = this.f26266d;
                    if (drawable == null) {
                        long j11 = this.f26273k;
                        if (j11 != 0) {
                            if (j11 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f26266d = null;
                                this.f26273k = 0L;
                            } else {
                                drawable.setAlpha(((((int) ((j11 - uptimeMillis) * 255)) / this.f26263a.B) * this.f26267e) / 255);
                                if (!z10 && z12) {
                                    scheduleSelf(this.f26271i, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        this.f26273k = 0L;
                    }
                    z12 = z11;
                    if (!z10) {
                        return;
                    }
                    return;
                }
            }
        } else {
            this.f26272j = 0L;
        }
        z11 = false;
        drawable = this.f26266d;
        if (drawable == null) {
        }
        z12 = z11;
        if (!z10) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f26263a.b(theme);
    }

    d b() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f26269g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f26263a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f26266d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i10) {
        Runnable runnable;
        if (i10 == this.f26269g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f26263a.B > 0) {
            Drawable drawable = this.f26266d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f26265c;
            if (drawable2 != null) {
                this.f26266d = drawable2;
                this.f26273k = this.f26263a.B + uptimeMillis;
            } else {
                this.f26266d = null;
                this.f26273k = 0L;
            }
        } else {
            Drawable drawable3 = this.f26265c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i10 >= 0) {
            d dVar = this.f26263a;
            if (i10 < dVar.f26284h) {
                Drawable g10 = dVar.g(i10);
                this.f26265c = g10;
                this.f26269g = i10;
                if (g10 != null) {
                    int i11 = this.f26263a.A;
                    if (i11 > 0) {
                        this.f26272j = uptimeMillis + i11;
                    }
                    d(g10);
                }
                if (this.f26272j == 0 || this.f26273k != 0) {
                    runnable = this.f26271i;
                    if (runnable != null) {
                        this.f26271i = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f26265c = null;
        this.f26269g = -1;
        if (this.f26272j == 0) {
        }
        runnable = this.f26271i;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f26267e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f26263a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f26263a.c()) {
            return null;
        }
        this.f26263a.f26280d = getChangingConfigurations();
        return this.f26263a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f26265c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f26264b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f26263a.q()) {
            return this.f26263a.i();
        }
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f26263a.q()) {
            return this.f26263a.m();
        }
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f26263a.q()) {
            return this.f26263a.j();
        }
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f26263a.q()) {
            return this.f26263a.k();
        }
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f26265c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f26263a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            C0283b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean z10;
        Rect l10 = this.f26263a.l();
        if (l10 != null) {
            rect.set(l10);
            z10 = (l10.right | ((l10.left | l10.top) | l10.bottom)) != 0;
        } else {
            Drawable drawable = this.f26265c;
            if (drawable != null) {
                z10 = drawable.getPadding(rect);
            } else {
                z10 = super.getPadding(rect);
            }
        }
        if (e()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(d dVar) {
        this.f26263a = dVar;
        int i10 = this.f26269g;
        if (i10 >= 0) {
            Drawable g10 = dVar.g(i10);
            this.f26265c = g10;
            if (g10 != null) {
                d(g10);
            }
        }
        this.f26266d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f26263a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f26263a;
        if (dVar != null) {
            dVar.p();
        }
        if (drawable == this.f26265c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f26263a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f26266d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f26266d = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f26268f) {
                this.f26265c.setAlpha(this.f26267e);
            }
        }
        if (this.f26273k != 0) {
            this.f26273k = 0L;
            z10 = true;
        }
        if (this.f26272j != 0) {
            this.f26272j = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f26270h && super.mutate() == this) {
            d b10 = b();
            b10.r();
            h(b10);
            this.f26270h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f26266d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return this.f26263a.w(i10, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f26266d;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f26266d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable == this.f26265c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (!this.f26268f || this.f26267e != i10) {
            this.f26268f = true;
            this.f26267e = i10;
            Drawable drawable = this.f26265c;
            if (drawable == null) {
                return;
            }
            if (this.f26272j == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        d dVar = this.f26263a;
        if (dVar.C != z10) {
            dVar.C = z10;
            Drawable drawable = this.f26265c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f26263a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f26265c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        d dVar = this.f26263a;
        if (dVar.f26300x != z10) {
            dVar.f26300x = z10;
            Drawable drawable = this.f26265c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f26264b;
        if (rect == null) {
            this.f26264b = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f26265c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f26263a;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f26265c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f26263a;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            androidx.core.graphics.drawable.a.p(this.f26265c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f26266d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f26265c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f26265c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
