package xh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.d;
/* compiled from: BadgeCupDrawable.kt */
/* loaded from: classes2.dex */
public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36549a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36550b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f36551c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f36552d;

    /* renamed from: e  reason: collision with root package name */
    private float f36553e;

    /* renamed from: f  reason: collision with root package name */
    private float f36554f;

    public /* synthetic */ a(Context context, String str, boolean z10, int i10, f fVar) {
        this(context, str, (i10 & 4) != 0 ? false : z10);
    }

    private final float a() {
        return getBounds().width() / 18.0f;
    }

    public final Paint b() {
        return this.f36552d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i.f(canvas, "canvas");
        canvas.drawBitmap(this.f36551c, (Rect) null, new RectF(getBounds()), this.f36552d);
        canvas.drawText(this.f36550b, this.f36553e, this.f36554f - a(), this.f36552d);
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
            this.f36553e = rect.centerX();
            this.f36554f = rect.centerY();
            Paint b10 = b();
            int length = this.f36550b.length();
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
            b10.setTextSize(f10 / f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public a(Context context, String number, boolean z10) {
        i.f(context, "context");
        i.f(number, "number");
        this.f36549a = context;
        this.f36550b = number;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), z10 ? sh.f.f34562l : sh.f.f34559k);
        i.e(decodeResource, "decodeResource(\n            context.resources,\n            if (isBig) R.drawable.ic_badge_cup_big else R.drawable.ic_badge_cup\n        )");
        this.f36551c = decodeResource;
        Paint paint = new Paint(1);
        paint.setColor(b.c(context, d.f34451k));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setFakeBoldText(true);
        m mVar = m.f28349a;
        this.f36552d = paint;
    }
}
