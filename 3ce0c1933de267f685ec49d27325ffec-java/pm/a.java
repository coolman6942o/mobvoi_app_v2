package pm;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
/* compiled from: ArrowDrawable.java */
/* loaded from: classes2.dex */
public class a extends om.a {

    /* renamed from: b  reason: collision with root package name */
    private int f32877b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f32878c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Path f32879d = new Path();

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (!(this.f32877b == width && this.f32878c == height)) {
            this.f32879d.reset();
            float f10 = (width * 30) / 225;
            float f11 = f10 * 0.70710677f;
            float f12 = f10 / 0.70710677f;
            float f13 = width;
            float f14 = f13 / 2.0f;
            float f15 = height;
            this.f32879d.moveTo(f14, f15);
            float f16 = f15 / 2.0f;
            this.f32879d.lineTo(0.0f, f16);
            float f17 = f16 - f11;
            this.f32879d.lineTo(f11, f17);
            float f18 = f10 / 2.0f;
            float f19 = f14 - f18;
            float f20 = (f15 - f12) - f18;
            this.f32879d.lineTo(f19, f20);
            this.f32879d.lineTo(f19, 0.0f);
            float f21 = f14 + f18;
            this.f32879d.lineTo(f21, 0.0f);
            this.f32879d.lineTo(f21, f20);
            this.f32879d.lineTo(f13 - f11, f17);
            this.f32879d.lineTo(f13, f16);
            this.f32879d.close();
            this.f32877b = width;
            this.f32878c = height;
        }
        canvas.drawPath(this.f32879d, this.f32426a);
    }
}
