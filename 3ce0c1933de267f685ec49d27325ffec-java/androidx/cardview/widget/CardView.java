package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p.b;
import p.d;
import p.e;
/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f1397h = {16842801};

    /* renamed from: i  reason: collision with root package name */
    private static final e f1398i;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1399a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1400b;

    /* renamed from: c  reason: collision with root package name */
    int f1401c;

    /* renamed from: d  reason: collision with root package name */
    int f1402d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f1403e;

    /* renamed from: f  reason: collision with root package name */
    final Rect f1404f;

    /* renamed from: g  reason: collision with root package name */
    private final d f1405g;

    /* loaded from: classes.dex */
    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        private Drawable f1406a;

        a() {
        }

        @Override // androidx.cardview.widget.d
        public void a(int i10, int i11, int i12, int i13) {
            CardView.this.f1404f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1403e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        @Override // androidx.cardview.widget.d
        public void b(int i10, int i11) {
            CardView cardView = CardView.this;
            if (i10 > cardView.f1401c) {
                CardView.super.setMinimumWidth(i10);
            }
            CardView cardView2 = CardView.this;
            if (i11 > cardView2.f1402d) {
                CardView.super.setMinimumHeight(i11);
            }
        }

        @Override // androidx.cardview.widget.d
        public void c(Drawable drawable) {
            this.f1406a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable f() {
            return this.f1406a;
        }

        @Override // androidx.cardview.widget.d
        public View g() {
            return CardView.this;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            f1398i = new b();
        } else if (i10 >= 17) {
            f1398i = new androidx.cardview.widget.a();
        } else {
            f1398i = new c();
        }
        f1398i.j();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, p.a.f32519a);
    }

    public void f(int i10, int i11, int i12, int i13) {
        this.f1403e.set(i10, i11, i12, i13);
        f1398i.i(this.f1405g);
    }

    public ColorStateList getCardBackgroundColor() {
        return f1398i.h(this.f1405g);
    }

    public float getCardElevation() {
        return f1398i.c(this.f1405g);
    }

    public int getContentPaddingBottom() {
        return this.f1403e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1403e.left;
    }

    public int getContentPaddingRight() {
        return this.f1403e.right;
    }

    public int getContentPaddingTop() {
        return this.f1403e.top;
    }

    public float getMaxCardElevation() {
        return f1398i.g(this.f1405g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1400b;
    }

    public float getRadius() {
        return f1398i.d(this.f1405g);
    }

    public boolean getUseCompatPadding() {
        return this.f1399a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        e eVar = f1398i;
        if (!(eVar instanceof b)) {
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.l(this.f1405g)), View.MeasureSpec.getSize(i10)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i11);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(eVar.k(this.f1405g)), View.MeasureSpec.getSize(i11)), mode2);
            }
            super.onMeasure(i10, i11);
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f1398i.n(this.f1405g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f1398i.f(this.f1405g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f1398i.o(this.f1405g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f1402d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f1401c = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f1400b) {
            this.f1400b = z10;
            f1398i.m(this.f1405g);
        }
    }

    public void setRadius(float f10) {
        f1398i.b(this.f1405g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f1399a != z10) {
            this.f1399a = z10;
            f1398i.e(this.f1405g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1403e = rect;
        this.f1404f = new Rect();
        a aVar = new a();
        this.f1405g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f32526a, i10, d.f32525a);
        int i12 = e.f32529d;
        if (obtainStyledAttributes.hasValue(i12)) {
            valueOf = obtainStyledAttributes.getColorStateList(i12);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1397h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i11 = getResources().getColor(b.f32521b);
            } else {
                i11 = getResources().getColor(b.f32520a);
            }
            valueOf = ColorStateList.valueOf(i11);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(e.f32530e, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(e.f32531f, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(e.f32532g, 0.0f);
        this.f1399a = obtainStyledAttributes.getBoolean(e.f32534i, false);
        this.f1400b = obtainStyledAttributes.getBoolean(e.f32533h, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(e.f32535j, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(e.f32537l, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(e.f32539n, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(e.f32538m, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(e.f32536k, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1401c = obtainStyledAttributes.getDimensionPixelSize(e.f32527b, 0);
        this.f1402d = obtainStyledAttributes.getDimensionPixelSize(e.f32528c, 0);
        obtainStyledAttributes.recycle();
        f1398i.a(aVar, context, colorStateList, dimension, dimension2, f10);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f1398i.n(this.f1405g, colorStateList);
    }
}
