package com.huawei.hms.scankit.drawable;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.p.Ac;
import com.huawei.hms.scankit.p.Bc;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class ScanDrawable extends Drawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14311a = {13625597, 357325};

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f14312b = new a(0.4f, 0.0f, 0.4f, 1.0f);

    /* renamed from: c  reason: collision with root package name */
    private static final Interpolator f14313c = new a(0.4f, 0.0f, 0.7f, 1.0f);

    /* renamed from: d  reason: collision with root package name */
    private static final Interpolator f14314d = new a(0.25f, 0.0f, 0.4f, 1.0f);
    private AnimatorSet A;

    /* renamed from: e  reason: collision with root package name */
    private final ValueAnimator f14315e;

    /* renamed from: f  reason: collision with root package name */
    private final ValueAnimator f14316f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f14317g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f14318h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f14319i;

    /* renamed from: j  reason: collision with root package name */
    private final ColorMatrix f14320j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f14321k;

    /* renamed from: l  reason: collision with root package name */
    private final Rect f14322l;

    /* renamed from: m  reason: collision with root package name */
    private final Rect f14323m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f14324n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f14325o;

    /* renamed from: p  reason: collision with root package name */
    private int f14326p;

    /* renamed from: q  reason: collision with root package name */
    private int f14327q;

    /* renamed from: r  reason: collision with root package name */
    private float f14328r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f14329s;

    /* renamed from: t  reason: collision with root package name */
    private float f14330t;

    /* renamed from: u  reason: collision with root package name */
    private int f14331u;

    /* renamed from: v  reason: collision with root package name */
    private Ac f14332v;

    /* renamed from: w  reason: collision with root package name */
    private float f14333w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14334x;

    /* renamed from: y  reason: collision with root package name */
    private Bitmap f14335y;

    /* renamed from: z  reason: collision with root package name */
    private Bitmap f14336z;

    public ScanDrawable() {
        this.f14315e = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f14316f = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f14317g = new Matrix();
        this.f14318h = new Paint();
        this.f14319i = new Paint();
        this.f14320j = new ColorMatrix();
        this.f14321k = new Matrix();
        this.f14322l = new Rect();
        this.f14323m = new Rect();
        this.f14324n = new Rect();
        this.f14325o = new Rect();
        this.f14328r = 0.5f;
        this.f14329s = false;
        this.f14330t = 0.0f;
        this.f14334x = true;
        this.A = new AnimatorSet();
        d();
    }

    private void e() {
        this.f14315e.setInterpolator(new LinearInterpolator());
        this.f14315e.setRepeatMode(2);
        this.f14315e.setRepeatCount(-1);
        this.f14315e.setDuration(500L);
        this.f14315e.setStartDelay(200L);
        this.f14315e.addListener(new d(this));
    }

    private void f() {
        this.f14316f.setDuration(2000L);
        this.f14316f.setInterpolator(new LinearInterpolator());
        this.f14316f.setRepeatCount(-1);
        this.f14316f.setRepeatMode(2);
        this.f14316f.addUpdateListener(new b(this));
        this.f14316f.addListener(new c(this));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isRunning() || canvas == null) {
            Log.w("ScanDrawable", "animator is not running or canvas is null.");
            return;
        }
        if (!this.f14329s) {
            int i10 = this.f14331u;
            this.f14323m.set(0, i10, getBounds().right, i10 - ((int) ((this.f14327q * this.f14330t) * 0.5f)));
            int i11 = this.f14331u;
            this.f14324n.set(0, i11, getBounds().right, i11 - ((int) (this.f14327q * this.f14330t)));
        } else {
            int i12 = this.f14331u;
            this.f14323m.set(0, i12, getBounds().right, ((int) (this.f14327q * this.f14330t * 0.5f)) + i12);
            int i13 = this.f14331u;
            this.f14324n.set(0, i13, getBounds().right, ((int) (this.f14327q * this.f14330t)) + i13);
        }
        a(canvas, this.f14324n);
        b(canvas);
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        if (resources == null || xmlPullParser == null || attributeSet == null) {
            Log.e("ScanDrawable", "resources, xmlPullParser or attributeSet is null when inflating drawable");
            return;
        }
        a(resources);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.A.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (rect == null) {
            Log.e("ScanDrawable", "on bounds change: bounds is null!");
            return;
        }
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            Log.i("ScanDrawable", "start failed, animator is running");
            return;
        }
        this.f14329s = false;
        this.f14334x = true;
        a(getBounds());
        this.A.start();
        Log.i("ScanDrawable", "start scan animator success");
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.A.end();
            this.f14332v = null;
            Log.i("ScanDrawable", "stop scan animator success");
            return;
        }
        Log.i("ScanDrawable", "stop failed, animator is not running");
    }

    private void d() {
        f();
        e();
        AnimatorSet animatorSet = new AnimatorSet();
        this.A = animatorSet;
        animatorSet.playTogether(this.f14316f, this.f14315e);
    }

    private void b(Canvas canvas) {
        Ac ac2 = this.f14332v;
        if (ac2 == null) {
            Log.e("ScanDrawable", "drawParticle failed, mParticle is null");
        } else {
            ac2.a(canvas, this.f14323m);
        }
    }

    private void a(Resources resources) {
        if (resources == null) {
            Log.e("ScanDrawable", "resources is null when init drawable");
            return;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_light);
        this.f14336z = Bitmap.createBitmap(decodeResource.getWidth() * 2, decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(this.f14336z);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        paint.setShader(new BitmapShader(decodeResource, tileMode, tileMode));
        canvas.drawRect(0.0f, 0.0f, decodeResource.getWidth() * 2, decodeResource.getHeight() * 2, paint);
        this.f14335y = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_tail);
        this.f14333w = resources.getDisplayMetrics().density;
    }

    private void a(Rect rect) {
        if (rect.height() == 0) {
            Log.d("ScanDrawable", "initBounds bounds is null");
            return;
        }
        this.f14325o.set(rect);
        this.f14325o.inset(0, (int) (rect.height() * 0.1f));
        this.f14326p = (int) (rect.height() * 0.18f);
        this.f14327q = (int) (rect.height() * 0.36f);
        Rect rect2 = new Rect(rect);
        rect2.inset((int) (rect.width() * 0.2f), 0);
        float f10 = this.f14333w;
        float f11 = 0.001f;
        if (f10 != 0.0f) {
            f11 = 0.001f / (f10 * f10);
        }
        int width = (int) (f11 * rect2.width() * rect2.height());
        this.f14332v = new Ac(new Bc(width, 500L).a(0.33f, 1.0f).a(0, -1, 0L, 100L, new LinearInterpolator()).a(-1, 0, 400L, 500L, new LinearInterpolator()), rect2, width, this.f14333w * 2.0f, f14311a);
    }

    public ScanDrawable(Resources resources) {
        this();
        a(resources);
    }

    private void a(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.f14335y;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f14335y.getHeight() == 0) {
            Log.e("ScanDrawable", "dawTail failed, input bitmap is null");
            return;
        }
        this.f14317g.setScale(rect.width() / this.f14335y.getWidth(), rect.height() / this.f14335y.getHeight());
        this.f14317g.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f14335y, this.f14317g, this.f14318h);
        this.f14317g.reset();
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.f14336z;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f14336z.getHeight() == 0) {
            Log.e("ScanDrawable", "drawLight failed, light bitmap is null");
            return;
        }
        float floatValue = (this.f14330t * 0.5f) + (((Float) this.f14315e.getAnimatedValue()).floatValue() * this.f14328r);
        float f10 = (1.5f - floatValue) * 0.05f;
        float f11 = f10 + 1.0f;
        this.f14320j.set(new float[]{1.0f, f10, f10, f10, 0.0f, f10, f11, f10, f10, 0.0f, f10, f10, f11, f10, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.f14319i.setColorFilter(new ColorMatrixColorFilter(this.f14320j));
        int i10 = (int) (this.f14326p * ((floatValue * 0.2f) + 0.4f));
        if (this.f14329s) {
            int i11 = this.f14331u;
            this.f14322l.set(0, i11 + i10, getBounds().right, i11 - i10);
        } else {
            int i12 = this.f14331u;
            this.f14322l.set(0, i12 - i10, getBounds().right, i12 + i10);
        }
        this.f14321k.setScale(this.f14322l.width() / this.f14336z.getWidth(), this.f14322l.height() / this.f14336z.getHeight());
        Matrix matrix = this.f14321k;
        Rect rect = this.f14322l;
        matrix.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f14336z, this.f14321k, this.f14319i);
        this.f14321k.reset();
    }
}
