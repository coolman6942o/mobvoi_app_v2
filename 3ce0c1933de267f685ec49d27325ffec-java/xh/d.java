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
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BadgeStreakDrawable.kt */
/* loaded from: classes2.dex */
public final class d extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final String f36565a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f36566b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f36567c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f36568d;

    /* renamed from: e  reason: collision with root package name */
    private float f36569e;

    /* renamed from: f  reason: collision with root package name */
    private float f36570f;

    /* renamed from: g  reason: collision with root package name */
    private final int f36571g;

    public /* synthetic */ d(Context context, String str, boolean z10, int i10, f fVar) {
        this(context, str, (i10 & 4) != 0 ? false : z10);
    }

    private final float a() {
        float f10;
        float f11;
        if (this.f36566b) {
            f11 = getBounds().width();
            f10 = 6.0f;
        } else {
            f11 = getBounds().width();
            f10 = 7.0f;
        }
        return f11 / f10;
    }

    private final float b() {
        float f10;
        float f11;
        int length = this.f36565a.length();
        if (length == 1) {
            f11 = getBounds().width();
            f10 = 5.0f;
        } else if (length == 2) {
            f11 = getBounds().width();
            f10 = 6.0f;
        } else if (length != 3) {
            f11 = getBounds().width();
            f10 = 8.0f;
        } else {
            f11 = getBounds().width();
            f10 = 7.0f;
        }
        return f11 / f10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        i.f(canvas, "canvas");
        canvas.drawBitmap(this.f36567c, (Rect) null, new RectF(getBounds()), this.f36568d);
        this.f36568d.setColor(-1);
        this.f36568d.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f36569e, this.f36570f, a(), this.f36568d);
        this.f36568d.setColor(this.f36571g);
        this.f36568d.setTextSize(b());
        this.f36568d.setTextAlign(Paint.Align.CENTER);
        this.f36568d.setFakeBoldText(true);
        Paint.FontMetrics fontMetrics = this.f36568d.getFontMetrics();
        i.e(fontMetrics, "paint.fontMetrics");
        float f10 = fontMetrics.bottom;
        canvas.drawText(this.f36565a, this.f36569e, this.f36570f + (((f10 - fontMetrics.top) / 2) - f10), this.f36568d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect != null) {
            this.f36569e = rect.centerX();
            this.f36570f = rect.centerY();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public d(Context context, String number, boolean z10) {
        i.f(context, "context");
        i.f(number, "number");
        this.f36565a = number;
        this.f36566b = z10;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), this.f36566b ? sh.f.f34571o : sh.f.f34568n);
        i.e(decodeResource, "decodeResource(\n            context.resources,\n            if (isBig) R.drawable.ic_badge_streak_big else R.drawable.ic_badge_streak\n        )");
        this.f36567c = decodeResource;
        this.f36568d = new Paint(1);
        this.f36571g = b.c(context, sh.d.f34451k);
    }
}
