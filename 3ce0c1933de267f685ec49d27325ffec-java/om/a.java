package om;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
/* compiled from: PaintDrawable.java */
/* loaded from: classes2.dex */
public abstract class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    protected Paint f32426a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        Paint paint = new Paint();
        this.f32426a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f32426a.setAntiAlias(true);
        this.f32426a.setColor(-5592406);
    }

    public void a(int i10) {
        this.f32426a.setColor(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f32426a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f32426a.setColorFilter(colorFilter);
    }
}
