package com.makeramen.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import s9.b;
/* loaded from: classes2.dex */
public class RoundedImageView extends ImageView {

    /* renamed from: o  reason: collision with root package name */
    public static final Shader.TileMode f15260o = Shader.TileMode.CLAMP;

    /* renamed from: p  reason: collision with root package name */
    private static final ImageView.ScaleType[] f15261p = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a  reason: collision with root package name */
    private final float[] f15262a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f15263b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f15264c;

    /* renamed from: d  reason: collision with root package name */
    private float f15265d;

    /* renamed from: e  reason: collision with root package name */
    private ColorFilter f15266e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15267f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f15268g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15269h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15270i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15271j;

    /* renamed from: k  reason: collision with root package name */
    private int f15272k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView.ScaleType f15273l;

    /* renamed from: m  reason: collision with root package name */
    private Shader.TileMode f15274m;

    /* renamed from: n  reason: collision with root package name */
    private Shader.TileMode f15275n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15276a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f15276a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15276a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15276a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15276a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15276a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15276a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15276a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        Drawable drawable = this.f15268g;
        if (drawable != null && this.f15267f) {
            Drawable mutate = drawable.mutate();
            this.f15268g = mutate;
            if (this.f15269h) {
                mutate.setColorFilter(this.f15266e);
            }
        }
    }

    private static Shader.TileMode b(int i10) {
        if (i10 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    private Drawable c() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i10 = this.f15272k;
        if (i10 != 0) {
            try {
                drawable = resources.getDrawable(i10);
            } catch (Exception e10) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f15272k, e10);
                this.f15272k = 0;
            }
        }
        return b.e(drawable);
    }

    private void e(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof b) {
                b bVar = (b) drawable;
                bVar.l(this.f15273l).i(this.f15265d).h(this.f15264c).k(this.f15270i).m(this.f15274m).n(this.f15275n);
                float[] fArr = this.f15262a;
                if (fArr != null) {
                    bVar.j(fArr[0], fArr[1], fArr[2], fArr[3]);
                }
                a();
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    e(layerDrawable.getDrawable(i10));
                }
            }
        }
    }

    private void f(boolean z10) {
        if (this.f15271j) {
            if (z10) {
                this.f15263b = b.e(this.f15263b);
            }
            e(this.f15263b);
        }
    }

    private void g() {
        e(this.f15268g);
    }

    public void d(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f15262a;
        if (fArr[0] != f10 || fArr[1] != f11 || fArr[2] != f13 || fArr[3] != f12) {
            fArr[0] = f10;
            fArr[1] = f11;
            fArr[3] = f12;
            fArr[2] = f13;
            g();
            f(false);
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f15264c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f15264c;
    }

    public float getBorderWidth() {
        return this.f15265d;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f10 = 0.0f;
        for (float f11 : this.f15262a) {
            f10 = Math.max(f11, f10);
        }
        return f10;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f15273l;
    }

    public Shader.TileMode getTileModeX() {
        return this.f15274m;
    }

    public Shader.TileMode getTileModeY() {
        return this.f15275n;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f15263b = drawable;
        f(true);
        super.setBackgroundDrawable(this.f15263b);
    }

    public void setBorderColor(int i10) {
        setBorderColor(ColorStateList.valueOf(i10));
    }

    public void setBorderWidth(int i10) {
        setBorderWidth(getResources().getDimension(i10));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f15266e != colorFilter) {
            this.f15266e = colorFilter;
            this.f15269h = true;
            this.f15267f = true;
            a();
            invalidate();
        }
    }

    public void setCornerRadius(float f10) {
        d(f10, f10, f10, f10);
    }

    public void setCornerRadiusDimen(int i10) {
        float dimension = getResources().getDimension(i10);
        d(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f15272k = 0;
        this.f15268g = b.d(bitmap);
        g();
        super.setImageDrawable(this.f15268g);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f15272k = 0;
        this.f15268g = b.e(drawable);
        g();
        super.setImageDrawable(this.f15268g);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f15272k != i10) {
            this.f15272k = i10;
            this.f15268g = c();
            g();
            super.setImageDrawable(this.f15268g);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z10) {
        this.f15270i = z10;
        g();
        f(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.f15273l != scaleType) {
            this.f15273l = scaleType;
            switch (a.f15276a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            g();
            f(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f15274m != tileMode) {
            this.f15274m = tileMode;
            g();
            f(false);
            invalidate();
        }
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f15275n != tileMode) {
            this.f15275n = tileMode;
            g();
            f(false);
            invalidate();
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f15262a = fArr;
        this.f15264c = ColorStateList.valueOf(-16777216);
        this.f15265d = 0.0f;
        this.f15266e = null;
        this.f15267f = false;
        this.f15269h = false;
        this.f15270i = false;
        this.f15271j = false;
        this.f15273l = ImageView.ScaleType.FIT_CENTER;
        Shader.TileMode tileMode = f15260o;
        this.f15274m = tileMode;
        this.f15275n = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s9.a.f34341a, i10, 0);
        int i11 = obtainStyledAttributes.getInt(s9.a.f34342b, -1);
        if (i11 >= 0) {
            setScaleType(f15261p[i11]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34345e, -1);
        fArr[0] = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34348h, -1);
        fArr[1] = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34349i, -1);
        fArr[2] = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34347g, -1);
        fArr[3] = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34346f, -1);
        int length = fArr.length;
        boolean z10 = false;
        for (int i12 = 0; i12 < length; i12++) {
            float[] fArr2 = this.f15262a;
            if (fArr2[i12] < 0.0f) {
                fArr2[i12] = 0.0f;
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f15262a.length;
            for (int i13 = 0; i13 < length2; i13++) {
                this.f15262a[i13] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(s9.a.f34344d, -1);
        this.f15265d = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f15265d = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(s9.a.f34343c);
        this.f15264c = colorStateList;
        if (colorStateList == null) {
            this.f15264c = ColorStateList.valueOf(-16777216);
        }
        this.f15271j = obtainStyledAttributes.getBoolean(s9.a.f34350j, false);
        this.f15270i = obtainStyledAttributes.getBoolean(s9.a.f34351k, false);
        int i14 = obtainStyledAttributes.getInt(s9.a.f34352l, -2);
        if (i14 != -2) {
            setTileModeX(b(i14));
            setTileModeY(b(i14));
        }
        int i15 = obtainStyledAttributes.getInt(s9.a.f34353m, -2);
        if (i15 != -2) {
            setTileModeX(b(i15));
        }
        int i16 = obtainStyledAttributes.getInt(s9.a.f34354n, -2);
        if (i16 != -2) {
            setTileModeY(b(i16));
        }
        g();
        f(true);
        obtainStyledAttributes.recycle();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.f15264c.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            this.f15264c = colorStateList;
            g();
            f(false);
            if (this.f15265d > 0.0f) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(float f10) {
        if (this.f15265d != f10) {
            this.f15265d = f10;
            g();
            f(false);
            invalidate();
        }
    }
}
