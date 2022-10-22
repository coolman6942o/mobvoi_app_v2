package xh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import io.m;
import kotlin.jvm.internal.i;
import sh.d;
import sh.f;
/* compiled from: BadgeLockDrawable.kt */
/* loaded from: classes2.dex */
public final class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36558a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36559b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f36560c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f36561d;

    /* renamed from: e  reason: collision with root package name */
    private float f36562e;

    /* renamed from: f  reason: collision with root package name */
    private float f36563f;

    /* renamed from: g  reason: collision with root package name */
    private final float f36564g;

    public c(Context context, String number) {
        i.f(context, "context");
        i.f(number, "number");
        this.f36558a = context;
        this.f36559b = number;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), f.f34565m);
        i.e(decodeResource, "decodeResource(context.resources, R.drawable.ic_badge_lock)");
        this.f36560c = decodeResource;
        Paint paint = new Paint(1);
        paint.setColor(b.c(context, d.f34453m));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        m mVar = m.f28349a;
        this.f36561d = paint;
        this.f36564g = aa.d.d(14.0f, context);
    }

    public final Paint a() {
        return this.f36561d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i.f(canvas, "canvas");
        canvas.drawBitmap(this.f36560c, 0.0f, 0.0f, this.f36561d);
        canvas.drawText(this.f36559b, this.f36562e, this.f36563f + this.f36564g, this.f36561d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        float f10;
        float f11;
        super.onBoundsChange(rect);
        if (rect != null) {
            this.f36562e = rect.centerX();
            this.f36563f = rect.centerY();
            Paint a10 = a();
            int length = this.f36559b.length();
            if (length == 1) {
                f10 = rect.width();
                f11 = 5.0f;
            } else if (length == 2) {
                f10 = rect.width();
                f11 = 6.0f;
            } else if (length != 3) {
                f10 = rect.width();
                f11 = 8.0f;
            } else {
                f10 = rect.width();
                f11 = 7.0f;
            }
            a10.setTextSize(f10 / f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
