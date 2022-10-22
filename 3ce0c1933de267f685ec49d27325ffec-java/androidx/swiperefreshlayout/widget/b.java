package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import j0.h;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g  reason: collision with root package name */
    private static final Interpolator f4406g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    private static final Interpolator f4407h = new x0.b();

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f4408i = {-16777216};

    /* renamed from: a  reason: collision with root package name */
    private final c f4409a;

    /* renamed from: b  reason: collision with root package name */
    private float f4410b;

    /* renamed from: c  reason: collision with root package name */
    private Resources f4411c;

    /* renamed from: d  reason: collision with root package name */
    private Animator f4412d;

    /* renamed from: e  reason: collision with root package name */
    float f4413e;

    /* renamed from: f  reason: collision with root package name */
    boolean f4414f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f4415a;

        a(c cVar) {
            this.f4415a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.f4415a);
            b.this.b(floatValue, this.f4415a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: androidx.swiperefreshlayout.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f4417a;

        C0049b(c cVar) {
            this.f4417a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f4417a, true);
            this.f4417a.A();
            this.f4417a.l();
            b bVar = b.this;
            if (bVar.f4414f) {
                bVar.f4414f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f4417a.x(false);
                return;
            }
            bVar.f4413e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f4413e = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        final Paint f4420b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f4421c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f4422d;

        /* renamed from: i  reason: collision with root package name */
        int[] f4427i;

        /* renamed from: j  reason: collision with root package name */
        int f4428j;

        /* renamed from: k  reason: collision with root package name */
        float f4429k;

        /* renamed from: l  reason: collision with root package name */
        float f4430l;

        /* renamed from: m  reason: collision with root package name */
        float f4431m;

        /* renamed from: n  reason: collision with root package name */
        boolean f4432n;

        /* renamed from: o  reason: collision with root package name */
        Path f4433o;

        /* renamed from: q  reason: collision with root package name */
        float f4435q;

        /* renamed from: r  reason: collision with root package name */
        int f4436r;

        /* renamed from: s  reason: collision with root package name */
        int f4437s;

        /* renamed from: u  reason: collision with root package name */
        int f4439u;

        /* renamed from: a  reason: collision with root package name */
        final RectF f4419a = new RectF();

        /* renamed from: e  reason: collision with root package name */
        float f4423e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4424f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4425g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        float f4426h = 5.0f;

        /* renamed from: p  reason: collision with root package name */
        float f4434p = 1.0f;

        /* renamed from: t  reason: collision with root package name */
        int f4438t = 255;

        c() {
            Paint paint = new Paint();
            this.f4420b = paint;
            Paint paint2 = new Paint();
            this.f4421c = paint2;
            Paint paint3 = new Paint();
            this.f4422d = paint3;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f4429k = this.f4423e;
            this.f4430l = this.f4424f;
            this.f4431m = this.f4425g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f4419a;
            float f10 = this.f4435q;
            float f11 = (this.f4426h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f4436r * this.f4434p) / 2.0f, this.f4426h / 2.0f);
            }
            rectF.set(rect.centerX() - f11, rect.centerY() - f11, rect.centerX() + f11, rect.centerY() + f11);
            float f12 = this.f4423e;
            float f13 = this.f4425g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f4424f + f13) * 360.0f) - f14;
            this.f4420b.setColor(this.f4439u);
            this.f4420b.setAlpha(this.f4438t);
            float f16 = this.f4426h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f4422d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f4420b);
            b(canvas, f14, f15, rectF);
        }

        void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f4432n) {
                Path path = this.f4433o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f4433o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f4433o.moveTo(0.0f, 0.0f);
                this.f4433o.lineTo(this.f4436r * this.f4434p, 0.0f);
                Path path3 = this.f4433o;
                float f12 = this.f4434p;
                path3.lineTo((this.f4436r * f12) / 2.0f, this.f4437s * f12);
                this.f4433o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.f4436r * this.f4434p) / 2.0f), rectF.centerY() + (this.f4426h / 2.0f));
                this.f4433o.close();
                this.f4421c.setColor(this.f4439u);
                this.f4421c.setAlpha(this.f4438t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f4433o, this.f4421c);
                canvas.restore();
            }
        }

        int c() {
            return this.f4438t;
        }

        float d() {
            return this.f4424f;
        }

        int e() {
            return this.f4427i[f()];
        }

        int f() {
            return (this.f4428j + 1) % this.f4427i.length;
        }

        float g() {
            return this.f4423e;
        }

        int h() {
            return this.f4427i[this.f4428j];
        }

        float i() {
            return this.f4430l;
        }

        float j() {
            return this.f4431m;
        }

        float k() {
            return this.f4429k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f4429k = 0.0f;
            this.f4430l = 0.0f;
            this.f4431m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i10) {
            this.f4438t = i10;
        }

        void o(float f10, float f11) {
            this.f4436r = (int) f10;
            this.f4437s = (int) f11;
        }

        void p(float f10) {
            if (f10 != this.f4434p) {
                this.f4434p = f10;
            }
        }

        void q(float f10) {
            this.f4435q = f10;
        }

        void r(int i10) {
            this.f4439u = i10;
        }

        void s(ColorFilter colorFilter) {
            this.f4420b.setColorFilter(colorFilter);
        }

        void t(int i10) {
            this.f4428j = i10;
            this.f4439u = this.f4427i[i10];
        }

        void u(int[] iArr) {
            this.f4427i = iArr;
            t(0);
        }

        void v(float f10) {
            this.f4424f = f10;
        }

        void w(float f10) {
            this.f4425g = f10;
        }

        void x(boolean z10) {
            if (this.f4432n != z10) {
                this.f4432n = z10;
            }
        }

        void y(float f10) {
            this.f4423e = f10;
        }

        void z(float f10) {
            this.f4426h = f10;
            this.f4420b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f4411c = ((Context) h.g(context)).getResources();
        c cVar = new c();
        this.f4409a = cVar;
        cVar.u(f4408i);
        k(2.5f);
        m();
    }

    private void a(float f10, c cVar) {
        n(f10, cVar);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((((float) (Math.floor(cVar.j() / 0.8f) + 1.0d)) - cVar.j()) * f10));
    }

    private int c(float f10, int i10, int i11) {
        int i12 = (i10 >> 24) & 255;
        int i13 = (i10 >> 16) & 255;
        int i14 = (i10 >> 8) & 255;
        int i15 = i10 & 255;
        return ((i12 + ((int) ((((i11 >> 24) & 255) - i12) * f10))) << 24) | ((i13 + ((int) ((((i11 >> 16) & 255) - i13) * f10))) << 16) | ((i14 + ((int) ((((i11 >> 8) & 255) - i14) * f10))) << 8) | (i15 + ((int) (f10 * ((i11 & 255) - i15))));
    }

    private void h(float f10) {
        this.f4410b = f10;
    }

    private void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f4409a;
        float f14 = this.f4411c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    private void m() {
        c cVar = this.f4409a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f4406g);
        ofFloat.addListener(new C0049b(cVar));
        this.f4412d = ofFloat;
    }

    void b(float f10, c cVar, boolean z10) {
        float f11;
        float f12;
        if (this.f4414f) {
            a(f10, cVar);
        } else if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                f11 = cVar.k();
                f12 = (f4407h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + f11;
            } else {
                float k10 = cVar.k() + 0.79f;
                f11 = k10 - (((1.0f - f4407h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f12 = k10;
            }
            cVar.y(f11);
            cVar.v(f12);
            cVar.w(j10 + (0.20999998f * f10));
            h((f10 + this.f4413e) * 216.0f);
        }
    }

    public void d(boolean z10) {
        this.f4409a.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f4410b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f4409a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f4409a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f4409a.u(iArr);
        this.f4409a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f4409a.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4409a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4412d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f4409a.y(f10);
        this.f4409a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f4409a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f4409a.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4409a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4412d.cancel();
        this.f4409a.A();
        if (this.f4409a.d() != this.f4409a.g()) {
            this.f4414f = true;
            this.f4412d.setDuration(666L);
            this.f4412d.start();
            return;
        }
        this.f4409a.t(0);
        this.f4409a.m();
        this.f4412d.setDuration(1332L);
        this.f4412d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4412d.cancel();
        h(0.0f);
        this.f4409a.x(false);
        this.f4409a.t(0);
        this.f4409a.m();
        invalidateSelf();
    }
}
