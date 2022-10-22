package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import sh.d;
import sh.e;
/* compiled from: SportControlBaseButton.java */
/* loaded from: classes2.dex */
public abstract class z extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19707a;

    /* renamed from: b  reason: collision with root package name */
    private final float f19708b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f19709c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f19710d;

    /* renamed from: e  reason: collision with root package name */
    private final Path f19711e;

    /* renamed from: f  reason: collision with root package name */
    private final PathMeasure f19712f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f19713g;

    /* renamed from: h  reason: collision with root package name */
    protected float f19714h;

    /* renamed from: i  reason: collision with root package name */
    protected float f19715i;

    /* renamed from: j  reason: collision with root package name */
    protected Bitmap f19716j;

    /* renamed from: k  reason: collision with root package name */
    protected int f19717k;

    /* renamed from: l  reason: collision with root package name */
    protected Timer f19718l;

    /* renamed from: m  reason: collision with root package name */
    protected int f19719m;

    /* renamed from: n  reason: collision with root package name */
    protected int f19720n;

    /* compiled from: SportControlBaseButton.java */
    /* loaded from: classes2.dex */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            z.this.d(this);
        }
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f19717k = 0;
        this.f19718l.cancel();
        this.f19718l.purge();
    }

    protected abstract boolean b();

    protected abstract boolean c();

    protected abstract void d(TimerTask timerTask);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f19718l = new Timer();
        this.f19718l.schedule(new a(), 0L, 100L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (b()) {
            this.f19709c.setStyle(Paint.Style.FILL);
            this.f19709c.setColor(getResources().getColor(this.f19719m));
            float f10 = this.f19714h;
            canvas.drawCircle(f10, f10, f10, this.f19709c);
            Bitmap bitmap = this.f19716j;
            canvas.drawBitmap(bitmap, this.f19714h - (bitmap.getWidth() / 2.0f), this.f19714h - (this.f19716j.getHeight() / 2.0f), this.f19709c);
            return;
        }
        this.f19709c.setStyle(Paint.Style.FILL);
        this.f19709c.setColor(getResources().getColor(this.f19719m));
        float f11 = this.f19715i;
        canvas.drawCircle(f11, f11, this.f19714h, this.f19709c);
        this.f19709c.setStyle(Paint.Style.STROKE);
        this.f19709c.setStrokeWidth(this.f19708b);
        this.f19709c.setColor(getResources().getColor(this.f19720n));
        float f12 = this.f19715i;
        canvas.drawCircle(f12, f12, this.f19714h + (this.f19708b / 2.0f), this.f19709c);
        this.f19709c.setColor(getResources().getColor(d.f34444b0));
        this.f19709c.setStrokeWidth(getResources().getDimension(e.f34478d1));
        RectF rectF = this.f19710d;
        float f13 = this.f19708b;
        rectF.set(f13, f13, getWidth() - this.f19708b, getHeight() - this.f19708b);
        canvas.drawArc(this.f19710d, -90.0f, (this.f19717k / 100.0f) * 360.0f, false, this.f19709c);
        Path path = this.f19711e;
        float f14 = this.f19715i;
        path.addCircle(f14, f14, this.f19714h, Path.Direction.CW);
        this.f19712f.setPath(this.f19711e, false);
        float f15 = this.f19717k / 100.0f;
        float f16 = ((double) f15) >= 0.25d ? f15 - 0.25f : f15 + 0.75f;
        PathMeasure pathMeasure = this.f19712f;
        pathMeasure.getPosTan(pathMeasure.getLength() * f16, this.f19713g, null);
        this.f19709c.setStyle(Paint.Style.FILL);
        float[] fArr = this.f19713g;
        canvas.drawCircle(fArr[0], fArr[1], getResources().getDimension(e.f34490h1), this.f19709c);
        Bitmap bitmap2 = this.f19716j;
        canvas.drawBitmap(bitmap2, this.f19715i - (bitmap2.getWidth() / 2.0f), this.f19715i - (this.f19716j.getHeight() / 2.0f), this.f19709c);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        if (c()) {
            i12 = View.MeasureSpec.makeMeasureSpec(((int) this.f19715i) * 2, Integer.MIN_VALUE);
        } else {
            i12 = View.MeasureSpec.makeMeasureSpec(((int) this.f19714h) * 2, Integer.MIN_VALUE);
        }
        super.onMeasure(i12, i12);
    }

    public z(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19713g = new float[2];
        this.f19707a = context;
        this.f19714h = context.getResources().getDimension(e.f34481e1);
        this.f19715i = context.getResources().getDimension(e.f34484f1);
        this.f19708b = context.getResources().getDimension(e.f34487g1);
        this.f19710d = new RectF();
        this.f19709c = new Paint(1);
        this.f19711e = new Path();
        this.f19712f = new PathMeasure();
    }
}
