package s9;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;
/* compiled from: RoundedDrawable.java */
/* loaded from: classes2.dex */
public class b extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private final RectF f34357c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f34358d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f34359e;

    /* renamed from: f  reason: collision with root package name */
    private final int f34360f;

    /* renamed from: g  reason: collision with root package name */
    private final int f34361g;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f34363i;

    /* renamed from: l  reason: collision with root package name */
    private Shader.TileMode f34366l;

    /* renamed from: m  reason: collision with root package name */
    private Shader.TileMode f34367m;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f34355a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f34356b = new RectF();

    /* renamed from: h  reason: collision with root package name */
    private final RectF f34362h = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f34364j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    private final RectF f34365k = new RectF();

    /* renamed from: n  reason: collision with root package name */
    private boolean f34368n = true;

    /* renamed from: o  reason: collision with root package name */
    private float f34369o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    private final boolean[] f34370p = {true, true, true, true};

    /* renamed from: q  reason: collision with root package name */
    private boolean f34371q = false;

    /* renamed from: r  reason: collision with root package name */
    private float f34372r = 0.0f;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f34373s = ColorStateList.valueOf(-16777216);

    /* renamed from: t  reason: collision with root package name */
    private ImageView.ScaleType f34374t = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RoundedDrawable.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f34375a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f34375a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34375a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34375a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34375a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34375a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34375a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34375a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f34357c = rectF;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f34366l = tileMode;
        this.f34367m = tileMode;
        this.f34358d = bitmap;
        int width = bitmap.getWidth();
        this.f34360f = width;
        int height = bitmap.getHeight();
        this.f34361g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f34359e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f34363i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f34373s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f34372r);
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z10 : zArr) {
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e10) {
            e10.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static b d(Bitmap bitmap) {
        if (bitmap != null) {
            return new b(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof b)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i10), e(layerDrawable.getDrawable(i10)));
            }
            return layerDrawable;
        }
        Bitmap c10 = c(drawable);
        return c10 != null ? new b(c10) : drawable;
    }

    private void f(Canvas canvas) {
        if (!a(this.f34370p) && this.f34369o != 0.0f) {
            RectF rectF = this.f34356b;
            float f10 = rectF.left;
            float f11 = rectF.top;
            float width = rectF.width() + f10;
            float height = this.f34356b.height() + f11;
            float f12 = this.f34369o;
            if (!this.f34370p[0]) {
                this.f34365k.set(f10, f11, f10 + f12, f11 + f12);
                canvas.drawRect(this.f34365k, this.f34359e);
            }
            if (!this.f34370p[1]) {
                this.f34365k.set(width - f12, f11, width, f12);
                canvas.drawRect(this.f34365k, this.f34359e);
            }
            if (!this.f34370p[2]) {
                this.f34365k.set(width - f12, height - f12, width, height);
                canvas.drawRect(this.f34365k, this.f34359e);
            }
            if (!this.f34370p[3]) {
                this.f34365k.set(f10, height - f12, f12 + f10, height);
                canvas.drawRect(this.f34365k, this.f34359e);
            }
        }
    }

    private void g(Canvas canvas) {
        float f10;
        if (!a(this.f34370p) && this.f34369o != 0.0f) {
            RectF rectF = this.f34356b;
            float f11 = rectF.left;
            float f12 = rectF.top;
            float width = rectF.width() + f11;
            float height = f12 + this.f34356b.height();
            float f13 = this.f34369o;
            float f14 = this.f34372r / 2.0f;
            if (!this.f34370p[0]) {
                canvas.drawLine(f11 - f14, f12, f11 + f13, f12, this.f34363i);
                canvas.drawLine(f11, f12 - f14, f11, f12 + f13, this.f34363i);
            }
            if (!this.f34370p[1]) {
                canvas.drawLine((width - f13) - f14, f12, width, f12, this.f34363i);
                canvas.drawLine(width, f12 - f14, width, f12 + f13, this.f34363i);
            }
            if (!this.f34370p[2]) {
                f10 = f13;
                canvas.drawLine((width - f13) - f14, height, width + f14, height, this.f34363i);
                canvas.drawLine(width, height - f10, width, height, this.f34363i);
            } else {
                f10 = f13;
            }
            if (!this.f34370p[3]) {
                canvas.drawLine(f11 - f14, height, f11 + f10, height, this.f34363i);
                canvas.drawLine(f11, height - f10, f11, height, this.f34363i);
            }
        }
    }

    private void o() {
        float f10;
        float f11;
        int i10 = a.f34375a[this.f34374t.ordinal()];
        if (i10 == 1) {
            this.f34362h.set(this.f34355a);
            RectF rectF = this.f34362h;
            float f12 = this.f34372r;
            rectF.inset(f12 / 2.0f, f12 / 2.0f);
            this.f34364j.reset();
            this.f34364j.setTranslate((int) (((this.f34362h.width() - this.f34360f) * 0.5f) + 0.5f), (int) (((this.f34362h.height() - this.f34361g) * 0.5f) + 0.5f));
        } else if (i10 == 2) {
            this.f34362h.set(this.f34355a);
            RectF rectF2 = this.f34362h;
            float f13 = this.f34372r;
            rectF2.inset(f13 / 2.0f, f13 / 2.0f);
            this.f34364j.reset();
            float f14 = 0.0f;
            if (this.f34360f * this.f34362h.height() > this.f34362h.width() * this.f34361g) {
                f11 = this.f34362h.height() / this.f34361g;
                f14 = (this.f34362h.width() - (this.f34360f * f11)) * 0.5f;
                f10 = 0.0f;
            } else {
                f11 = this.f34362h.width() / this.f34360f;
                f10 = (this.f34362h.height() - (this.f34361g * f11)) * 0.5f;
            }
            this.f34364j.setScale(f11, f11);
            Matrix matrix = this.f34364j;
            float f15 = this.f34372r;
            matrix.postTranslate(((int) (f14 + 0.5f)) + (f15 / 2.0f), ((int) (f10 + 0.5f)) + (f15 / 2.0f));
        } else if (i10 == 3) {
            this.f34364j.reset();
            float min = (((float) this.f34360f) > this.f34355a.width() || ((float) this.f34361g) > this.f34355a.height()) ? Math.min(this.f34355a.width() / this.f34360f, this.f34355a.height() / this.f34361g) : 1.0f;
            this.f34364j.setScale(min, min);
            this.f34364j.postTranslate((int) (((this.f34355a.width() - (this.f34360f * min)) * 0.5f) + 0.5f), (int) (((this.f34355a.height() - (this.f34361g * min)) * 0.5f) + 0.5f));
            this.f34362h.set(this.f34357c);
            this.f34364j.mapRect(this.f34362h);
            RectF rectF3 = this.f34362h;
            float f16 = this.f34372r;
            rectF3.inset(f16 / 2.0f, f16 / 2.0f);
            this.f34364j.setRectToRect(this.f34357c, this.f34362h, Matrix.ScaleToFit.FILL);
        } else if (i10 == 5) {
            this.f34362h.set(this.f34357c);
            this.f34364j.setRectToRect(this.f34357c, this.f34355a, Matrix.ScaleToFit.END);
            this.f34364j.mapRect(this.f34362h);
            RectF rectF4 = this.f34362h;
            float f17 = this.f34372r;
            rectF4.inset(f17 / 2.0f, f17 / 2.0f);
            this.f34364j.setRectToRect(this.f34357c, this.f34362h, Matrix.ScaleToFit.FILL);
        } else if (i10 == 6) {
            this.f34362h.set(this.f34357c);
            this.f34364j.setRectToRect(this.f34357c, this.f34355a, Matrix.ScaleToFit.START);
            this.f34364j.mapRect(this.f34362h);
            RectF rectF5 = this.f34362h;
            float f18 = this.f34372r;
            rectF5.inset(f18 / 2.0f, f18 / 2.0f);
            this.f34364j.setRectToRect(this.f34357c, this.f34362h, Matrix.ScaleToFit.FILL);
        } else if (i10 != 7) {
            this.f34362h.set(this.f34357c);
            this.f34364j.setRectToRect(this.f34357c, this.f34355a, Matrix.ScaleToFit.CENTER);
            this.f34364j.mapRect(this.f34362h);
            RectF rectF6 = this.f34362h;
            float f19 = this.f34372r;
            rectF6.inset(f19 / 2.0f, f19 / 2.0f);
            this.f34364j.setRectToRect(this.f34357c, this.f34362h, Matrix.ScaleToFit.FILL);
        } else {
            this.f34362h.set(this.f34355a);
            RectF rectF7 = this.f34362h;
            float f20 = this.f34372r;
            rectF7.inset(f20 / 2.0f, f20 / 2.0f);
            this.f34364j.reset();
            this.f34364j.setRectToRect(this.f34357c, this.f34362h, Matrix.ScaleToFit.FILL);
        }
        this.f34356b.set(this.f34362h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f34368n) {
            BitmapShader bitmapShader = new BitmapShader(this.f34358d, this.f34366l, this.f34367m);
            Shader.TileMode tileMode = this.f34366l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f34367m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f34364j);
            }
            this.f34359e.setShader(bitmapShader);
            this.f34368n = false;
        }
        if (this.f34371q) {
            if (this.f34372r > 0.0f) {
                canvas.drawOval(this.f34356b, this.f34359e);
                canvas.drawOval(this.f34362h, this.f34363i);
                return;
            }
            canvas.drawOval(this.f34356b, this.f34359e);
        } else if (b(this.f34370p)) {
            float f10 = this.f34369o;
            if (this.f34372r > 0.0f) {
                canvas.drawRoundRect(this.f34356b, f10, f10, this.f34359e);
                canvas.drawRoundRect(this.f34362h, f10, f10, this.f34363i);
                f(canvas);
                g(canvas);
                return;
            }
            canvas.drawRoundRect(this.f34356b, f10, f10, this.f34359e);
            f(canvas);
        } else {
            canvas.drawRect(this.f34356b, this.f34359e);
            if (this.f34372r > 0.0f) {
                canvas.drawRect(this.f34362h, this.f34363i);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f34359e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f34359e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f34361g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34360f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public b h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f34373s = colorStateList;
        this.f34363i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public b i(float f10) {
        this.f34372r = f10;
        this.f34363i.setStrokeWidth(f10);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f34373s.isStateful();
    }

    public b j(float f10, float f11, float f12, float f13) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f10));
        hashSet.add(Float.valueOf(f11));
        hashSet.add(Float.valueOf(f12));
        hashSet.add(Float.valueOf(f13));
        hashSet.remove(Float.valueOf(0.0f));
        boolean z10 = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                this.f34369o = floatValue;
            } else {
                this.f34369o = 0.0f;
            }
            boolean[] zArr = this.f34370p;
            zArr[0] = f10 > 0.0f;
            zArr[1] = f11 > 0.0f;
            zArr[2] = f12 > 0.0f;
            if (f13 <= 0.0f) {
                z10 = false;
            }
            zArr[3] = z10;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public b k(boolean z10) {
        this.f34371q = z10;
        return this;
    }

    public b l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f34374t != scaleType) {
            this.f34374t = scaleType;
            o();
        }
        return this;
    }

    public b m(Shader.TileMode tileMode) {
        if (this.f34366l != tileMode) {
            this.f34366l = tileMode;
            this.f34368n = true;
            invalidateSelf();
        }
        return this;
    }

    public b n(Shader.TileMode tileMode) {
        if (this.f34367m != tileMode) {
            this.f34367m = tileMode;
            this.f34368n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f34355a.set(rect);
        o();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f34373s.getColorForState(iArr, 0);
        if (this.f34363i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f34363i.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f34359e.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34359e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f34359e.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f34359e.setFilterBitmap(z10);
        invalidateSelf();
    }
}
