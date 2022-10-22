package com.mobvoi.ticcare.widget;

import a0.h;
import ak.a;
import ak.b;
import ak.c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
/* loaded from: classes2.dex */
public final class ScanQrfinderView extends View {

    /* renamed from: g  reason: collision with root package name */
    private static float f20836g = 135.0f;

    /* renamed from: b  reason: collision with root package name */
    private Paint f20838b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f20839c;

    /* renamed from: e  reason: collision with root package name */
    private LinearGradient f20841e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f20842f = new Rect();

    /* renamed from: a  reason: collision with root package name */
    private Paint f20837a = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private Drawable f20840d = h.f(getResources(), c.c_res_0x7f0805ac, null);

    public ScanQrfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f20838b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f20838b.setColor(getResources().getColor(a.f218c));
        this.f20838b.setAntiAlias(true);
        this.f20838b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f20839c = paint2;
        paint2.setTextSize(getResources().getDimension(b.f219a));
        this.f20839c.setColor(-1);
        this.f20839c.setTextAlign(Paint.Align.CENTER);
        this.f20839c.setAntiAlias(true);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int color = getResources().getColor(a.f217b);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, displayMetrics.heightPixels, new int[]{color, getResources().getColor(a.f216a), color}, new float[]{0.0f, 0.78f, 1.0f}, Shader.TileMode.CLAMP);
        this.f20841e = linearGradient;
        this.f20837a.setShader(linearGradient);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i10 = width / 2;
        float f10 = width;
        f20836g = (0.72f * f10) / 2.0f;
        float f11 = height;
        canvas.drawRect(0.0f, 0.0f, f10, f11, this.f20837a);
        Rect rect = this.f20842f;
        int i11 = (int) (0.22f * f11);
        rect.top = i11;
        rect.bottom = i11 + ((int) (f11 * 0.4f));
        float f12 = f20836g;
        rect.left = i10 - ((int) f12);
        rect.right = i10 + ((int) f12);
        canvas.drawRect(rect, this.f20838b);
        Drawable drawable = this.f20840d;
        if (drawable != null) {
            drawable.setBounds(this.f20842f);
            this.f20840d.draw(canvas);
        }
    }
}
