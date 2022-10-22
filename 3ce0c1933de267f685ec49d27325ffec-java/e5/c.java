package e5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.b;
import e5.g;
import java.nio.ByteBuffer;
import java.util.List;
import n5.j;
/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    /* renamed from: a  reason: collision with root package name */
    private final a f25787a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25788b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25789c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25790d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25791e;

    /* renamed from: f  reason: collision with root package name */
    private int f25792f;

    /* renamed from: g  reason: collision with root package name */
    private int f25793g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25794h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f25795i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f25796j;

    /* renamed from: k  reason: collision with root package name */
    private List<b> f25797k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifDrawable.java */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f25798a;

        a(g gVar) {
            this.f25798a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, p4.a aVar, q4.g<Bitmap> gVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.c(context), aVar, i10, i11, gVar, bitmap)));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f25796j == null) {
            this.f25796j = new Rect();
        }
        return this.f25796j;
    }

    private Paint h() {
        if (this.f25795i == null) {
            this.f25795i = new Paint(2);
        }
        return this.f25795i;
    }

    private void j() {
        List<b> list = this.f25797k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f25797k.get(i10).a(this);
            }
        }
    }

    private void l() {
        this.f25792f = 0;
    }

    private void n() {
        j.a(!this.f25790d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f25787a.f25798a.f() == 1) {
            invalidateSelf();
        } else if (!this.f25788b) {
            this.f25788b = true;
            this.f25787a.f25798a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f25788b = false;
        this.f25787a.f25798a.s(this);
    }

    @Override // e5.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f25792f++;
        }
        int i10 = this.f25793g;
        if (i10 != -1 && this.f25792f >= i10) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f25787a.f25798a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.f25790d) {
            if (this.f25794h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.f25794h = false;
            }
            canvas.drawBitmap(this.f25787a.f25798a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f25787a.f25798a.e();
    }

    public int f() {
        return this.f25787a.f25798a.f();
    }

    public int g() {
        return this.f25787a.f25798a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f25787a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f25787a.f25798a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f25787a.f25798a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f25787a.f25798a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f25788b;
    }

    public void k() {
        this.f25790d = true;
        this.f25787a.f25798a.a();
    }

    public void m(q4.g<Bitmap> gVar, Bitmap bitmap) {
        this.f25787a.f25798a.o(gVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f25794h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        j.a(!this.f25790d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f25791e = z10;
        if (!z10) {
            o();
        } else if (this.f25789c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f25789c = true;
        l();
        if (this.f25791e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f25789c = false;
        o();
    }

    c(a aVar) {
        this.f25791e = true;
        this.f25793g = -1;
        this.f25787a = (a) j.d(aVar);
    }
}
