package com.mobvoi.android.common.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.f0;
import androidx.core.view.o;
import androidx.viewpager.widget.ViewPager;
import y9.b;
import y9.c;
import y9.d;
import y9.e;
import y9.g;
import y9.k;
/* loaded from: classes2.dex */
public class CirclePageIndicator extends View implements ViewPager.j {

    /* renamed from: a  reason: collision with root package name */
    private float f15379a;

    /* renamed from: b  reason: collision with root package name */
    private float f15380b;

    /* renamed from: c  reason: collision with root package name */
    private float f15381c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f15382d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f15383e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f15384f;

    /* renamed from: g  reason: collision with root package name */
    private ViewPager f15385g;

    /* renamed from: h  reason: collision with root package name */
    private ViewPager.j f15386h;

    /* renamed from: i  reason: collision with root package name */
    private int f15387i;

    /* renamed from: j  reason: collision with root package name */
    private int f15388j;

    /* renamed from: k  reason: collision with root package name */
    private float f15389k;

    /* renamed from: l  reason: collision with root package name */
    private int f15390l;

    /* renamed from: m  reason: collision with root package name */
    private int f15391m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15392n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15393o;

    /* renamed from: p  reason: collision with root package name */
    private int f15394p;

    /* renamed from: q  reason: collision with root package name */
    private int f15395q;

    /* renamed from: r  reason: collision with root package name */
    private float f15396r;

    /* renamed from: s  reason: collision with root package name */
    private int f15397s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f15398t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f15399a;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f15399a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f15399a = parcel.readInt();
        }
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f36804a);
    }

    private int a(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824 || this.f15385g == null) {
            return size;
        }
        int indicatorCount = getIndicatorCount();
        float f10 = this.f15379a;
        int paddingLeft = (int) (getPaddingLeft() + getPaddingRight() + (indicatorCount * 2 * f10) + ((indicatorCount - 1) * f10) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f15379a * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int getIndicatorCount() {
        int i10 = this.f15394p;
        return i10 == 0 ? this.f15385g.getAdapter().d() : i10;
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
        int i12 = this.f15394p;
        if (i12 > 0) {
            this.f15387i = i10 % i12;
            this.f15389k = f10 % i12;
            invalidate();
            ViewPager.j jVar = this.f15386h;
            if (jVar != null) {
                jVar.c(i10, f10, i11);
            }
        }
    }

    public int getFillColor() {
        return this.f15384f.getColor();
    }

    public int getOrientation() {
        return this.f15391m;
    }

    public int getPageColor() {
        return this.f15382d.getColor();
    }

    public float getRadius() {
        return this.f15379a;
    }

    public int getStrokeColor() {
        return this.f15383e.getColor();
    }

    public float getStrokeWidth() {
        return this.f15383e.getStrokeWidth();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int indicatorCount;
        int i10;
        int i11;
        int i12;
        int i13;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (!(this.f15385g == null || (indicatorCount = getIndicatorCount()) == 0 || indicatorCount == 1)) {
            if (this.f15387i >= indicatorCount) {
                setCurrentItem(indicatorCount - 1);
                return;
            }
            if (this.f15391m == 0) {
                i13 = getWidth();
                i12 = getPaddingLeft();
                i11 = getPaddingRight();
                i10 = getPaddingTop();
            } else {
                i13 = getHeight();
                i12 = getPaddingTop();
                i11 = getPaddingBottom();
                i10 = getPaddingLeft();
            }
            float f12 = this.f15379a;
            float f13 = i10 + f12;
            float f14 = i12 + f12;
            if (this.f15392n) {
                f14 += (((i13 - i12) - i11) / 2.0f) - ((indicatorCount * this.f15381c) / 2.0f);
            }
            if (this.f15383e.getStrokeWidth() > 0.0f) {
                f12 -= this.f15383e.getStrokeWidth() / 2.0f;
            }
            for (int i14 = 0; i14 < indicatorCount; i14++) {
                float f15 = (i14 * this.f15381c) + f14;
                if (this.f15391m == 0) {
                    f11 = f13;
                } else {
                    f11 = f15;
                    f15 = f13;
                }
                if (this.f15382d.getAlpha() > 0) {
                    canvas.drawCircle(f15, f11, f12, this.f15382d);
                }
                float f16 = this.f15379a;
                if (f12 != f16) {
                    canvas.drawCircle(f15, f11, f16, this.f15383e);
                }
            }
            boolean z10 = this.f15393o;
            int i15 = z10 ? this.f15388j : this.f15387i;
            float f17 = this.f15381c;
            float f18 = i15 * f17;
            if (!z10) {
                f18 += this.f15389k * f17;
            }
            if (this.f15391m == 0) {
                f13 = f14 + f18;
                f10 = f13;
            } else {
                f10 = f14 + f18;
            }
            canvas.drawCircle(f13, f10, this.f15380b, this.f15384f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f15391m == 0) {
            setMeasuredDimension(a(i10), b(i11));
        } else {
            setMeasuredDimension(b(i10), a(i11));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i10 = savedState.f15399a;
        this.f15387i = i10;
        this.f15388j = i10;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15399a = this.f15387i;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        int i10 = 0;
        if (this.f15385g == null || getIndicatorCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float e10 = o.e(motionEvent, o.a(motionEvent, this.f15397s));
                    float f10 = e10 - this.f15396r;
                    if (!this.f15398t && Math.abs(f10) > this.f15395q) {
                        this.f15398t = true;
                    }
                    if (this.f15398t) {
                        this.f15396r = e10;
                        if (this.f15385g.A() || this.f15385g.e()) {
                            this.f15385g.s(f10);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int b10 = o.b(motionEvent);
                        this.f15396r = o.e(motionEvent, b10);
                        this.f15397s = o.d(motionEvent, b10);
                    } else if (action == 6) {
                        int b11 = o.b(motionEvent);
                        if (o.d(motionEvent, b11) == this.f15397s) {
                            if (b11 == 0) {
                                i10 = 1;
                            }
                            this.f15397s = o.d(motionEvent, i10);
                        }
                        this.f15396r = o.e(motionEvent, o.a(motionEvent, this.f15397s));
                    }
                }
            }
            if (!this.f15398t) {
                int indicatorCount = getIndicatorCount();
                float width = getWidth();
                float f11 = width / 2.0f;
                float f12 = width / 6.0f;
                if (this.f15387i > 0 && motionEvent.getX() < f11 - f12) {
                    if (action != 3) {
                        this.f15385g.setCurrentItem(this.f15387i - 1);
                    }
                    return true;
                } else if (this.f15387i < indicatorCount - 1 && motionEvent.getX() > f11 + f12) {
                    if (action != 3) {
                        this.f15385g.setCurrentItem(this.f15387i + 1);
                    }
                    return true;
                }
            }
            this.f15398t = false;
            this.f15397s = -1;
            if (this.f15385g.A()) {
                this.f15385g.q();
            }
        } else {
            this.f15397s = o.d(motionEvent, 0);
            this.f15396r = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z10) {
        this.f15392n = z10;
        invalidate();
    }

    public void setCurrentItem(int i10) {
        ViewPager viewPager = this.f15385g;
        if (viewPager != null) {
            viewPager.setCurrentItem(i10);
            this.f15387i = i10;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i10) {
        this.f15384f.setColor(i10);
        invalidate();
    }

    public void setIndicatorCount(int i10) {
        this.f15394p = i10;
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.f15386h = jVar;
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f15391m = i10;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public void setPageColor(int i10) {
        this.f15382d.setColor(i10);
        invalidate();
    }

    public void setRadius(float f10) {
        this.f15379a = f10;
        invalidate();
    }

    public void setSnap(boolean z10) {
        this.f15393o = z10;
        invalidate();
    }

    public void setStrokeColor(int i10) {
        this.f15383e.setColor(i10);
        invalidate();
    }

    public void setStrokeWidth(float f10) {
        this.f15383e.setStrokeWidth(f10);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f15385g;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() != null) {
                this.f15385g = viewPager;
                viewPager.setOnPageChangeListener(this);
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
        this.f15390l = i10;
        ViewPager.j jVar = this.f15386h;
        if (jVar != null) {
            jVar.u(i10);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        int i11 = this.f15394p;
        if (i11 > 0) {
            if (this.f15393o || this.f15390l == 0) {
                this.f15387i = i10 % i11;
                this.f15388j = i10 % i11;
                invalidate();
            }
            ViewPager.j jVar = this.f15386h;
            if (jVar != null) {
                jVar.v(i10);
            }
        }
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Paint paint = new Paint(1);
        this.f15382d = paint;
        Paint paint2 = new Paint(1);
        this.f15383e = paint2;
        Paint paint3 = new Paint(1);
        this.f15384f = paint3;
        this.f15394p = 0;
        this.f15396r = -1.0f;
        this.f15397s = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(d.f36807a);
            int i11 = d.f36808b;
            int color2 = resources.getColor(i11);
            int integer = resources.getInteger(g.f36829a);
            int color3 = resources.getColor(i11);
            float dimension = resources.getDimension(e.f36810b);
            int i12 = e.f36809a;
            float dimension2 = resources.getDimension(i12);
            boolean z10 = resources.getBoolean(c.f36805a);
            boolean z11 = resources.getBoolean(c.f36806b);
            float dimension3 = resources.getDimension(i12);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.f36868i, i10, 0);
            this.f15381c = obtainStyledAttributes.getDimension(k.f36877r, dimension3);
            this.f15392n = obtainStyledAttributes.getBoolean(k.f36871l, z10);
            this.f15391m = obtainStyledAttributes.getInt(k.f36869j, integer);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(obtainStyledAttributes.getColor(k.f36874o, color));
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(obtainStyledAttributes.getColor(k.f36878s, color3));
            paint2.setStrokeWidth(obtainStyledAttributes.getDimension(k.f36879t, dimension));
            paint3.setStyle(Paint.Style.FILL);
            paint3.setColor(obtainStyledAttributes.getColor(k.f36872m, color2));
            this.f15379a = obtainStyledAttributes.getDimension(k.f36875p, dimension2);
            this.f15380b = obtainStyledAttributes.getDimension(k.f36873n, dimension2);
            this.f15393o = obtainStyledAttributes.getBoolean(k.f36876q, z11);
            Drawable drawable = obtainStyledAttributes.getDrawable(k.f36870k);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f15395q = f0.d(ViewConfiguration.get(context));
        }
    }
}
