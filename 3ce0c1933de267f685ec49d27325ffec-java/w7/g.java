package w7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import c0.d;
import java.util.BitSet;
import w7.k;
import w7.l;
import w7.m;
/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes.dex */
public class g extends Drawable implements d, n {

    /* renamed from: x  reason: collision with root package name */
    private static final String f36013x = g.class.getSimpleName();

    /* renamed from: y  reason: collision with root package name */
    private static final Paint f36014y;

    /* renamed from: a  reason: collision with root package name */
    private c f36015a;

    /* renamed from: b  reason: collision with root package name */
    private final m.g[] f36016b;

    /* renamed from: c  reason: collision with root package name */
    private final m.g[] f36017c;

    /* renamed from: d  reason: collision with root package name */
    private final BitSet f36018d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f36019e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f36020f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f36021g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f36022h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f36023i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f36024j;

    /* renamed from: k  reason: collision with root package name */
    private final Region f36025k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f36026l;

    /* renamed from: m  reason: collision with root package name */
    private k f36027m;

    /* renamed from: n  reason: collision with root package name */
    private final Paint f36028n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f36029o;

    /* renamed from: p  reason: collision with root package name */
    private final v7.a f36030p;

    /* renamed from: q  reason: collision with root package name */
    private final l.b f36031q;

    /* renamed from: r  reason: collision with root package name */
    private final l f36032r;

    /* renamed from: s  reason: collision with root package name */
    private PorterDuffColorFilter f36033s;

    /* renamed from: t  reason: collision with root package name */
    private PorterDuffColorFilter f36034t;

    /* renamed from: u  reason: collision with root package name */
    private int f36035u;

    /* renamed from: v  reason: collision with root package name */
    private final RectF f36036v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f36037w;

    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes.dex */
    class a implements l.b {
        a() {
        }

        @Override // w7.l.b
        public void a(m mVar, Matrix matrix, int i10) {
            g.this.f36018d.set(i10, mVar.e());
            g.this.f36016b[i10] = mVar.f(matrix);
        }

        @Override // w7.l.b
        public void b(m mVar, Matrix matrix, int i10) {
            g.this.f36018d.set(i10 + 4, mVar.e());
            g.this.f36017c[i10] = mVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes.dex */
    public class b implements k.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f36039a;

        b(g gVar, float f10) {
            this.f36039a = f10;
        }

        @Override // w7.k.c
        public w7.c a(w7.c cVar) {
            return cVar instanceof i ? cVar : new w7.b(this.f36039a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f36014y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    private float F() {
        if (N()) {
            return this.f36029o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean L() {
        c cVar = this.f36015a;
        int i10 = cVar.f36056q;
        return i10 != 1 && cVar.f36057r > 0 && (i10 == 2 || V());
    }

    private boolean M() {
        Paint.Style style = this.f36015a.f36061v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean N() {
        Paint.Style style = this.f36015a.f36061v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f36029o.getStrokeWidth() > 0.0f;
    }

    private void P() {
        super.invalidateSelf();
    }

    private void S(Canvas canvas) {
        if (L()) {
            canvas.save();
            U(canvas);
            if (!this.f36037w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.f36036v.width() - getBounds().width());
            int height = (int) (this.f36036v.height() - getBounds().height());
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f36036v.width()) + (this.f36015a.f36057r * 2) + width, ((int) this.f36036v.height()) + (this.f36015a.f36057r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f10 = (getBounds().left - this.f36015a.f36057r) - width;
            float f11 = (getBounds().top - this.f36015a.f36057r) - height;
            canvas2.translate(-f10, -f11);
            n(canvas2);
            canvas.drawBitmap(createBitmap, f10, f11, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int T(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void U(Canvas canvas) {
        int B = B();
        int C = C();
        if (Build.VERSION.SDK_INT < 21 && this.f36037w) {
            Rect clipBounds = canvas.getClipBounds();
            int i10 = this.f36015a.f36057r;
            clipBounds.inset(-i10, -i10);
            clipBounds.offset(B, C);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(B, C);
    }

    private PorterDuffColorFilter f(Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int l10 = l(color);
        this.f36035u = l10;
        if (l10 != color) {
            return new PorterDuffColorFilter(l10, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f36015a.f36049j != 1.0f) {
            this.f36020f.reset();
            Matrix matrix = this.f36020f;
            float f10 = this.f36015a.f36049j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f36020f);
        }
        path.computeBounds(this.f36036v, true);
    }

    private void i() {
        k y10 = E().y(new b(this, -F()));
        this.f36027m = y10;
        this.f36032r.d(y10, this.f36015a.f36050k, v(), this.f36022h);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.f36035u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        if (colorStateList == null || mode == null) {
            return f(paint, z10);
        }
        return j(colorStateList, mode, z10);
    }

    private boolean k0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f36015a.f36043d == null || color2 == (colorForState2 = this.f36015a.f36043d.getColorForState(iArr, (color2 = this.f36028n.getColor())))) {
            z10 = false;
        } else {
            this.f36028n.setColor(colorForState2);
            z10 = true;
        }
        if (this.f36015a.f36044e == null || color == (colorForState = this.f36015a.f36044e.getColorForState(iArr, (color = this.f36029o.getColor())))) {
            return z10;
        }
        this.f36029o.setColor(colorForState);
        return true;
    }

    private boolean l0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f36033s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f36034t;
        c cVar = this.f36015a;
        this.f36033s = k(cVar.f36046g, cVar.f36047h, this.f36028n, true);
        c cVar2 = this.f36015a;
        this.f36034t = k(cVar2.f36045f, cVar2.f36047h, this.f36029o, false);
        c cVar3 = this.f36015a;
        if (cVar3.f36060u) {
            this.f36030p.d(cVar3.f36046g.getColorForState(getState(), 0));
        }
        return !j0.c.a(porterDuffColorFilter, this.f36033s) || !j0.c.a(porterDuffColorFilter2, this.f36034t);
    }

    public static g m(Context context, float f10) {
        int c10 = j7.a.c(context, d7.b.f25161q, g.class.getSimpleName());
        g gVar = new g();
        gVar.O(context);
        gVar.Z(ColorStateList.valueOf(c10));
        gVar.Y(f10);
        return gVar;
    }

    private void m0() {
        float K = K();
        this.f36015a.f36057r = (int) Math.ceil(0.75f * K);
        this.f36015a.f36058s = (int) Math.ceil(K * 0.25f);
        l0();
        P();
    }

    private void n(Canvas canvas) {
        if (this.f36018d.cardinality() > 0) {
            Log.w(f36013x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f36015a.f36058s != 0) {
            canvas.drawPath(this.f36021g, this.f36030p.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f36016b[i10].b(this.f36030p, this.f36015a.f36057r, canvas);
            this.f36017c[i10].b(this.f36030p, this.f36015a.f36057r, canvas);
        }
        if (this.f36037w) {
            int B = B();
            int C = C();
            canvas.translate(-B, -C);
            canvas.drawPath(this.f36021g, f36014y);
            canvas.translate(B, C);
        }
    }

    private void o(Canvas canvas) {
        q(canvas, this.f36028n, this.f36021g, this.f36015a.f36040a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (kVar.u(rectF)) {
            float a10 = kVar.t().a(rectF) * this.f36015a.f36050k;
            canvas.drawRoundRect(rectF, a10, a10, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private RectF v() {
        this.f36024j.set(u());
        float F = F();
        this.f36024j.inset(F, F);
        return this.f36024j;
    }

    public int A() {
        return this.f36035u;
    }

    public int B() {
        c cVar = this.f36015a;
        return (int) (cVar.f36058s * Math.sin(Math.toRadians(cVar.f36059t)));
    }

    public int C() {
        c cVar = this.f36015a;
        return (int) (cVar.f36058s * Math.cos(Math.toRadians(cVar.f36059t)));
    }

    public int D() {
        return this.f36015a.f36057r;
    }

    public k E() {
        return this.f36015a.f36040a;
    }

    public ColorStateList G() {
        return this.f36015a.f36046g;
    }

    public float H() {
        return this.f36015a.f36040a.r().a(u());
    }

    public float I() {
        return this.f36015a.f36040a.t().a(u());
    }

    public float J() {
        return this.f36015a.f36055p;
    }

    public float K() {
        return w() + J();
    }

    public void O(Context context) {
        this.f36015a.f36041b = new n7.a(context);
        m0();
    }

    public boolean Q() {
        n7.a aVar = this.f36015a.f36041b;
        return aVar != null && aVar.d();
    }

    public boolean R() {
        return this.f36015a.f36040a.u(u());
    }

    public boolean V() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 < 21 || (!R() && !this.f36021g.isConvex() && i10 < 29);
    }

    public void W(float f10) {
        setShapeAppearanceModel(this.f36015a.f36040a.w(f10));
    }

    public void X(w7.c cVar) {
        setShapeAppearanceModel(this.f36015a.f36040a.x(cVar));
    }

    public void Y(float f10) {
        c cVar = this.f36015a;
        if (cVar.f36054o != f10) {
            cVar.f36054o = f10;
            m0();
        }
    }

    public void Z(ColorStateList colorStateList) {
        c cVar = this.f36015a;
        if (cVar.f36043d != colorStateList) {
            cVar.f36043d = colorStateList;
            onStateChange(getState());
        }
    }

    public void a0(float f10) {
        c cVar = this.f36015a;
        if (cVar.f36050k != f10) {
            cVar.f36050k = f10;
            this.f36019e = true;
            invalidateSelf();
        }
    }

    public void b0(int i10, int i11, int i12, int i13) {
        c cVar = this.f36015a;
        if (cVar.f36048i == null) {
            cVar.f36048i = new Rect();
        }
        this.f36015a.f36048i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void c0(float f10) {
        c cVar = this.f36015a;
        if (cVar.f36053n != f10) {
            cVar.f36053n = f10;
            m0();
        }
    }

    public void d0(boolean z10) {
        this.f36037w = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f36028n.setColorFilter(this.f36033s);
        int alpha = this.f36028n.getAlpha();
        this.f36028n.setAlpha(T(alpha, this.f36015a.f36052m));
        this.f36029o.setColorFilter(this.f36034t);
        this.f36029o.setStrokeWidth(this.f36015a.f36051l);
        int alpha2 = this.f36029o.getAlpha();
        this.f36029o.setAlpha(T(alpha2, this.f36015a.f36052m));
        if (this.f36019e) {
            i();
            g(u(), this.f36021g);
            this.f36019e = false;
        }
        S(canvas);
        if (M()) {
            o(canvas);
        }
        if (N()) {
            r(canvas);
        }
        this.f36028n.setAlpha(alpha);
        this.f36029o.setAlpha(alpha2);
    }

    public void e0(int i10) {
        this.f36030p.d(i10);
        this.f36015a.f36060u = false;
        P();
    }

    public void f0(int i10) {
        c cVar = this.f36015a;
        if (cVar.f36059t != i10) {
            cVar.f36059t = i10;
            P();
        }
    }

    public void g0(float f10, int i10) {
        j0(f10);
        i0(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f36015a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f36015a.f36056q != 2) {
            if (R()) {
                outline.setRoundRect(getBounds(), H() * this.f36015a.f36050k);
                return;
            }
            g(u(), this.f36021g);
            if (this.f36021g.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f36021g);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f36015a.f36048i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f36025k.set(getBounds());
        g(u(), this.f36021g);
        this.f36026l.setPath(this.f36021g, this.f36025k);
        this.f36025k.op(this.f36026l, Region.Op.DIFFERENCE);
        return this.f36025k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        l lVar = this.f36032r;
        c cVar = this.f36015a;
        lVar.e(cVar.f36040a, cVar.f36050k, rectF, this.f36031q, path);
    }

    public void h0(float f10, ColorStateList colorStateList) {
        j0(f10);
        i0(colorStateList);
    }

    public void i0(ColorStateList colorStateList) {
        c cVar = this.f36015a;
        if (cVar.f36044e != colorStateList) {
            cVar.f36044e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f36019e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f36015a.f36046g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f36015a.f36045f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f36015a.f36044e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f36015a.f36043d) != null && colorStateList4.isStateful())));
    }

    public void j0(float f10) {
        this.f36015a.f36051l = f10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(int i10) {
        float K = K() + z();
        n7.a aVar = this.f36015a.f36041b;
        return aVar != null ? aVar.c(i10, K) : i10;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f36015a = new c(this.f36015a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f36019e = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        boolean z10 = k0(iArr) || l0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.f36015a.f36040a, rectF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(Canvas canvas) {
        q(canvas, this.f36029o, this.f36022h, this.f36027m, v());
    }

    public float s() {
        return this.f36015a.f36040a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f36015a;
        if (cVar.f36052m != i10) {
            cVar.f36052m = i10;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f36015a.f36042c = colorFilter;
        P();
    }

    @Override // w7.n
    public void setShapeAppearanceModel(k kVar) {
        this.f36015a.f36040a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        this.f36015a.f36046g = colorStateList;
        l0();
        P();
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f36015a;
        if (cVar.f36047h != mode) {
            cVar.f36047h = mode;
            l0();
            P();
        }
    }

    public float t() {
        return this.f36015a.f36040a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF u() {
        this.f36023i.set(getBounds());
        return this.f36023i;
    }

    public float w() {
        return this.f36015a.f36054o;
    }

    public ColorStateList x() {
        return this.f36015a.f36043d;
    }

    public float y() {
        return this.f36015a.f36050k;
    }

    public float z() {
        return this.f36015a.f36053n;
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(k.e(context, attributeSet, i10, i11).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    private g(c cVar) {
        this.f36016b = new m.g[4];
        this.f36017c = new m.g[4];
        this.f36018d = new BitSet(8);
        this.f36020f = new Matrix();
        this.f36021g = new Path();
        this.f36022h = new Path();
        this.f36023i = new RectF();
        this.f36024j = new RectF();
        this.f36025k = new Region();
        this.f36026l = new Region();
        Paint paint = new Paint(1);
        this.f36028n = paint;
        Paint paint2 = new Paint(1);
        this.f36029o = paint2;
        this.f36030p = new v7.a();
        this.f36032r = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.f36036v = new RectF();
        this.f36037w = true;
        this.f36015a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l0();
        k0(getState());
        this.f36031q = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes.dex */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public k f36040a;

        /* renamed from: b  reason: collision with root package name */
        public n7.a f36041b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f36042c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f36043d;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f36044e;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f36045f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f36046g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f36047h;

        /* renamed from: i  reason: collision with root package name */
        public Rect f36048i;

        /* renamed from: j  reason: collision with root package name */
        public float f36049j;

        /* renamed from: k  reason: collision with root package name */
        public float f36050k;

        /* renamed from: l  reason: collision with root package name */
        public float f36051l;

        /* renamed from: m  reason: collision with root package name */
        public int f36052m;

        /* renamed from: n  reason: collision with root package name */
        public float f36053n;

        /* renamed from: o  reason: collision with root package name */
        public float f36054o;

        /* renamed from: p  reason: collision with root package name */
        public float f36055p;

        /* renamed from: q  reason: collision with root package name */
        public int f36056q;

        /* renamed from: r  reason: collision with root package name */
        public int f36057r;

        /* renamed from: s  reason: collision with root package name */
        public int f36058s;

        /* renamed from: t  reason: collision with root package name */
        public int f36059t;

        /* renamed from: u  reason: collision with root package name */
        public boolean f36060u;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f36061v;

        public c(k kVar, n7.a aVar) {
            this.f36043d = null;
            this.f36044e = null;
            this.f36045f = null;
            this.f36046g = null;
            this.f36047h = PorterDuff.Mode.SRC_IN;
            this.f36048i = null;
            this.f36049j = 1.0f;
            this.f36050k = 1.0f;
            this.f36052m = 255;
            this.f36053n = 0.0f;
            this.f36054o = 0.0f;
            this.f36055p = 0.0f;
            this.f36056q = 0;
            this.f36057r = 0;
            this.f36058s = 0;
            this.f36059t = 0;
            this.f36060u = false;
            this.f36061v = Paint.Style.FILL_AND_STROKE;
            this.f36040a = kVar;
            this.f36041b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f36019e = true;
            return gVar;
        }

        public c(c cVar) {
            this.f36043d = null;
            this.f36044e = null;
            this.f36045f = null;
            this.f36046g = null;
            this.f36047h = PorterDuff.Mode.SRC_IN;
            this.f36048i = null;
            this.f36049j = 1.0f;
            this.f36050k = 1.0f;
            this.f36052m = 255;
            this.f36053n = 0.0f;
            this.f36054o = 0.0f;
            this.f36055p = 0.0f;
            this.f36056q = 0;
            this.f36057r = 0;
            this.f36058s = 0;
            this.f36059t = 0;
            this.f36060u = false;
            this.f36061v = Paint.Style.FILL_AND_STROKE;
            this.f36040a = cVar.f36040a;
            this.f36041b = cVar.f36041b;
            this.f36051l = cVar.f36051l;
            this.f36042c = cVar.f36042c;
            this.f36043d = cVar.f36043d;
            this.f36044e = cVar.f36044e;
            this.f36047h = cVar.f36047h;
            this.f36046g = cVar.f36046g;
            this.f36052m = cVar.f36052m;
            this.f36049j = cVar.f36049j;
            this.f36058s = cVar.f36058s;
            this.f36056q = cVar.f36056q;
            this.f36060u = cVar.f36060u;
            this.f36050k = cVar.f36050k;
            this.f36053n = cVar.f36053n;
            this.f36054o = cVar.f36054o;
            this.f36055p = cVar.f36055p;
            this.f36057r = cVar.f36057r;
            this.f36059t = cVar.f36059t;
            this.f36045f = cVar.f36045f;
            this.f36061v = cVar.f36061v;
            if (cVar.f36048i != null) {
                this.f36048i = new Rect(cVar.f36048i);
            }
        }
    }
}
