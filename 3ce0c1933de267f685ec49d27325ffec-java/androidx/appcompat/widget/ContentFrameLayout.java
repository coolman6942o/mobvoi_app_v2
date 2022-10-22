package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.d0;
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TypedValue f915a;

    /* renamed from: b  reason: collision with root package name */
    private TypedValue f916b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f917c;

    /* renamed from: d  reason: collision with root package name */
    private TypedValue f918d;

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f919e;

    /* renamed from: f  reason: collision with root package name */
    private TypedValue f920f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f921g;

    /* renamed from: h  reason: collision with root package name */
    private a f922h;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void b(int i10, int i11, int i12, int i13) {
        this.f921g.set(i10, i11, i12, i13);
        if (d0.X(this)) {
            requestLayout();
        }
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f919e == null) {
            this.f919e = new TypedValue();
        }
        return this.f919e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f920f == null) {
            this.f920f = new TypedValue();
        }
        return this.f920f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f917c == null) {
            this.f917c = new TypedValue();
        }
        return this.f917c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f918d == null) {
            this.f918d = new TypedValue();
        }
        return this.f918d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f915a == null) {
            this.f915a = new TypedValue();
        }
        return this.f915a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f916b == null) {
            this.f916b = new TypedValue();
        }
        return this.f916b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f922h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f922h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        int measuredWidth;
        TypedValue typedValue;
        int i12;
        int i13;
        float fraction;
        int i14;
        int i15;
        float fraction2;
        int i16;
        int i17;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z11 = true;
        boolean z12 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z12 ? this.f918d : this.f917c;
            if (!(typedValue2 == null || (i16 = typedValue2.type) == 0)) {
                if (i16 == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (i16 == 6) {
                    int i18 = displayMetrics.widthPixels;
                    fraction3 = typedValue2.getFraction(i18, i18);
                } else {
                    i17 = 0;
                    if (i17 > 0) {
                        Rect rect = this.f921g;
                        i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i17 - (rect.left + rect.right), View.MeasureSpec.getSize(i10)), 1073741824);
                        z10 = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z12 ? this.f919e : this.f920f;
                            if (!(typedValue3 == null || (i14 = typedValue3.type) == 0)) {
                                if (i14 == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (i14 == 6) {
                                    int i19 = displayMetrics.heightPixels;
                                    fraction2 = typedValue3.getFraction(i19, i19);
                                } else {
                                    i15 = 0;
                                    if (i15 > 0) {
                                        Rect rect2 = this.f921g;
                                        i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i15 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i11)), 1073741824);
                                    }
                                }
                                i15 = (int) fraction2;
                                if (i15 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i10, i11);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z10 && mode == Integer.MIN_VALUE) {
                            typedValue = !z12 ? this.f916b : this.f915a;
                            if (!(typedValue == null || (i12 = typedValue.type) == 0)) {
                                if (i12 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i12 == 6) {
                                    int i20 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i20, i20);
                                } else {
                                    i13 = 0;
                                    if (i13 > 0) {
                                        Rect rect3 = this.f921g;
                                        i13 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i13) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
                                        if (z11) {
                                            super.onMeasure(makeMeasureSpec, i11);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i13 = (int) fraction;
                                if (i13 > 0) {
                                }
                                if (measuredWidth < i13) {
                                }
                            }
                        }
                        z11 = false;
                        if (z11) {
                        }
                    }
                }
                i17 = (int) fraction3;
                if (i17 > 0) {
                }
            }
        }
        z10 = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i10, i11);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z10) {
            if (!z12) {
            }
            if (typedValue == null) {
                if (i12 != 5) {
                }
                i13 = (int) fraction;
                if (i13 > 0) {
                }
                if (measuredWidth < i13) {
                }
            }
        }
        z11 = false;
        if (z11) {
        }
    }

    public void setAttachListener(a aVar) {
        this.f922h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f921g = new Rect();
    }
}
