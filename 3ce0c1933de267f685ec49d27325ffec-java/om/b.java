package om;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
/* compiled from: ProgressDrawable.java */
/* loaded from: classes2.dex */
public class b extends a implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    protected ValueAnimator f32430e;

    /* renamed from: b  reason: collision with root package name */
    protected int f32427b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f32428c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f32429d = 0;

    /* renamed from: f  reason: collision with root package name */
    protected Path f32431f = new Path();

    public b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.f32430e = ofInt;
        ofInt.setDuration(10000L);
        this.f32430e.setInterpolator(null);
        this.f32430e.setRepeatCount(-1);
        this.f32430e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f10 = width;
        float max = Math.max(1.0f, f10 / 22.0f);
        if (!(this.f32427b == width && this.f32428c == height)) {
            this.f32431f.reset();
            float f11 = f10 - max;
            float f12 = height / 2.0f;
            this.f32431f.addCircle(f11, f12, max, Path.Direction.CW);
            float f13 = f10 - (5.0f * max);
            this.f32431f.addRect(f13, f12 - max, f11, f12 + max, Path.Direction.CW);
            this.f32431f.addCircle(f13, f12, max, Path.Direction.CW);
            this.f32427b = width;
            this.f32428c = height;
        }
        canvas.save();
        float f14 = f10 / 2.0f;
        float f15 = height / 2.0f;
        canvas.rotate(this.f32429d, f14, f15);
        for (int i10 = 0; i10 < 12; i10++) {
            this.f32426a.setAlpha((i10 + 5) * 17);
            canvas.rotate(30.0f, f14, f15);
            canvas.drawPath(this.f32431f, this.f32426a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f32430e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f32429d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.f32430e.isRunning()) {
            this.f32430e.addUpdateListener(this);
            this.f32430e.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f32430e.isRunning()) {
            this.f32430e.removeAllListeners();
            this.f32430e.removeAllUpdateListeners();
            this.f32430e.cancel();
        }
    }
}
