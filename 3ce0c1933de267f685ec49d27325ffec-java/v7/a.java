package v7;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
/* compiled from: ShadowRenderer.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f35620i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f35621j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f35622k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f35623l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f35624a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f35625b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f35626c;

    /* renamed from: d  reason: collision with root package name */
    private int f35627d;

    /* renamed from: e  reason: collision with root package name */
    private int f35628e;

    /* renamed from: f  reason: collision with root package name */
    private int f35629f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f35630g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f35631h;

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f35630g;
        if (z10) {
            int[] iArr = f35622k;
            iArr[0] = 0;
            iArr[1] = this.f35629f;
            iArr[2] = this.f35628e;
            iArr[3] = this.f35627d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f35622k;
            iArr2[0] = 0;
            iArr2[1] = this.f35627d;
            iArr2[2] = this.f35628e;
            iArr2[3] = this.f35629f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f13 = 1.0f - (i10 / width);
            float[] fArr = f35623l;
            fArr[1] = f13;
            fArr[2] = ((1.0f - f13) / 2.0f) + f13;
            this.f35625b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f35622k, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas.scale(1.0f, rectF.height() / rectF.width());
            if (!z10) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, this.f35631h);
            }
            canvas.drawArc(rectF, f10, f11, true, this.f35625b);
            canvas.restore();
        }
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f35620i;
        iArr[0] = this.f35629f;
        iArr[1] = this.f35628e;
        iArr[2] = this.f35627d;
        Paint paint = this.f35626c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f35621j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f35626c);
        canvas.restore();
    }

    public Paint c() {
        return this.f35624a;
    }

    public void d(int i10) {
        this.f35627d = b0.a.j(i10, 68);
        this.f35628e = b0.a.j(i10, 20);
        this.f35629f = b0.a.j(i10, 0);
        this.f35624a.setColor(this.f35627d);
    }

    public a(int i10) {
        this.f35630g = new Path();
        this.f35631h = new Paint();
        this.f35624a = new Paint();
        d(i10);
        this.f35631h.setColor(0);
        Paint paint = new Paint(4);
        this.f35625b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f35626c = new Paint(paint);
    }
}
