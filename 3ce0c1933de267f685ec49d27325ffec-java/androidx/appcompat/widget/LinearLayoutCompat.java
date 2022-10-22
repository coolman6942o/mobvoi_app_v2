package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.d0;
import androidx.core.view.f;
import d.j;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f925a;

    /* renamed from: b  reason: collision with root package name */
    private int f926b;

    /* renamed from: c  reason: collision with root package name */
    private int f927c;

    /* renamed from: d  reason: collision with root package name */
    private int f928d;

    /* renamed from: e  reason: collision with root package name */
    private int f929e;

    /* renamed from: f  reason: collision with root package name */
    private int f930f;

    /* renamed from: g  reason: collision with root package name */
    private float f931g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f932h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f933i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f934j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f935k;

    /* renamed from: l  reason: collision with root package name */
    private int f936l;

    /* renamed from: m  reason: collision with root package name */
    private int f937m;

    /* renamed from: n  reason: collision with root package name */
    private int f938n;

    /* renamed from: o  reason: collision with root package name */
    private int f939o;

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i10, int i11) {
            super(i10, i11);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void A(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    private void k(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View s10 = s(i12);
            if (s10.getVisibility() != 8) {
                a aVar = (a) s10.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i13 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = s10.getMeasuredWidth();
                    measureChildWithMargins(s10, i11, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i13;
                }
            }
        }
    }

    private void l(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View s10 = s(i12);
            if (s10.getVisibility() != 8) {
                a aVar = (a) s10.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i13 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = s10.getMeasuredHeight();
                    measureChildWithMargins(s10, makeMeasureSpec, 0, i11, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i13;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int virtualChildCount = getVirtualChildCount();
        boolean b10 = e1.b(this);
        for (int i14 = 0; i14 < virtualChildCount; i14++) {
            View s10 = s(i14);
            if (!(s10 == null || s10.getVisibility() == 8 || !t(i14))) {
                a aVar = (a) s10.getLayoutParams();
                if (b10) {
                    i13 = s10.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else {
                    i13 = (s10.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.f936l;
                }
                j(canvas, i13);
            }
        }
        if (t(virtualChildCount)) {
            View s11 = s(virtualChildCount - 1);
            if (s11 != null) {
                a aVar2 = (a) s11.getLayoutParams();
                if (b10) {
                    i12 = s11.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i11 = this.f936l;
                    i10 = i12 - i11;
                    j(canvas, i10);
                }
                i10 = s11.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                j(canvas, i10);
            } else if (b10) {
                i10 = getPaddingLeft();
                j(canvas, i10);
            } else {
                i12 = getWidth() - getPaddingRight();
                i11 = this.f936l;
                i10 = i12 - i11;
                j(canvas, i10);
            }
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f926b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f926b;
        if (childCount > i11) {
            View childAt = getChildAt(i11);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i12 = this.f927c;
                if (this.f928d == 1 && (i10 = this.f929e & 112) != 48) {
                    if (i10 == 16) {
                        i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f930f) / 2;
                    } else if (i10 == 80) {
                        i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f930f;
                    }
                }
                return i12 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
            } else if (this.f926b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f926b;
    }

    public Drawable getDividerDrawable() {
        return this.f935k;
    }

    public int getDividerPadding() {
        return this.f939o;
    }

    public int getDividerWidth() {
        return this.f936l;
    }

    public int getGravity() {
        return this.f929e;
    }

    public int getOrientation() {
        return this.f928d;
    }

    public int getShowDividers() {
        return this.f938n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f931g;
    }

    void h(Canvas canvas) {
        int i10;
        int virtualChildCount = getVirtualChildCount();
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View s10 = s(i11);
            if (!(s10 == null || s10.getVisibility() == 8 || !t(i11))) {
                i(canvas, (s10.getTop() - ((LinearLayout.LayoutParams) ((a) s10.getLayoutParams())).topMargin) - this.f937m);
            }
        }
        if (t(virtualChildCount)) {
            View s11 = s(virtualChildCount - 1);
            if (s11 == null) {
                i10 = (getHeight() - getPaddingBottom()) - this.f937m;
            } else {
                i10 = s11.getBottom() + ((LinearLayout.LayoutParams) ((a) s11.getLayoutParams())).bottomMargin;
            }
            i(canvas, i10);
        }
    }

    void i(Canvas canvas, int i10) {
        this.f935k.setBounds(getPaddingLeft() + this.f939o, i10, (getWidth() - getPaddingRight()) - this.f939o, this.f937m + i10);
        this.f935k.draw(canvas);
    }

    void j(Canvas canvas, int i10) {
        this.f935k.setBounds(i10, getPaddingTop() + this.f939o, this.f936l + i10, (getHeight() - getPaddingBottom()) - this.f939o);
        this.f935k.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public a generateDefaultLayoutParams() {
        int i10 = this.f928d;
        if (i10 == 0) {
            return new a(-2, -2);
        }
        if (i10 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* renamed from: n */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f935k != null) {
            if (this.f928d == 1) {
                h(canvas);
            } else {
                g(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f928d == 1) {
            v(i10, i11, i12, i13);
        } else {
            u(i10, i11, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f928d == 1) {
            z(i10, i11);
        } else {
            x(i10, i11);
        }
    }

    int p(View view, int i10) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i10) {
        return getChildAt(i10);
    }

    public void setBaselineAligned(boolean z10) {
        this.f925a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f926b = i10;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f935k) {
            this.f935k = drawable;
            boolean z10 = false;
            if (drawable != null) {
                this.f936l = drawable.getIntrinsicWidth();
                this.f937m = drawable.getIntrinsicHeight();
            } else {
                this.f936l = 0;
                this.f937m = 0;
            }
            if (drawable == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setDividerPadding(int i10) {
        this.f939o = i10;
    }

    public void setGravity(int i10) {
        if (this.f929e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f929e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f929e;
        if ((8388615 & i12) != i11) {
            this.f929e = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f932h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f928d != i10) {
            this.f928d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f938n) {
            requestLayout();
        }
        this.f938n = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f929e;
        if ((i12 & 112) != i11) {
            this.f929e = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f931g = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t(int i10) {
        if (i10 == 0) {
            return (this.f938n & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f938n & 4) != 0;
        }
        if ((this.f938n & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void u(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z10;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean b10 = e1.b(this);
        int paddingTop = getPaddingTop();
        int i24 = i13 - i11;
        int paddingBottom = i24 - getPaddingBottom();
        int paddingBottom2 = (i24 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i25 = this.f929e;
        int i26 = i25 & 112;
        boolean z11 = this.f925a;
        int[] iArr = this.f933i;
        int[] iArr2 = this.f934j;
        int b11 = f.b(8388615 & i25, d0.E(this));
        boolean z12 = true;
        if (b11 != 1) {
            i14 = b11 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i12) - i10) - this.f930f;
        } else {
            i14 = getPaddingLeft() + (((i12 - i10) - this.f930f) / 2);
        }
        if (b10) {
            i16 = virtualChildCount - 1;
            i15 = -1;
        } else {
            i16 = 0;
            i15 = 1;
        }
        int i27 = 0;
        while (i27 < virtualChildCount) {
            int i28 = i16 + (i15 * i27);
            View s10 = s(i28);
            if (s10 == null) {
                i14 += y(i28);
                z10 = z12;
                i17 = paddingTop;
                i19 = virtualChildCount;
                i18 = i26;
            } else if (s10.getVisibility() != 8) {
                int measuredWidth = s10.getMeasuredWidth();
                int measuredHeight = s10.getMeasuredHeight();
                a aVar = (a) s10.getLayoutParams();
                int i29 = i27;
                if (z11) {
                    i19 = virtualChildCount;
                    if (((LinearLayout.LayoutParams) aVar).height != -1) {
                        i20 = s10.getBaseline();
                        i21 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i21 < 0) {
                            i21 = i26;
                        }
                        i22 = i21 & 112;
                        i18 = i26;
                        if (i22 == 16) {
                            if (i22 == 48) {
                                i23 = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                                if (i20 != -1) {
                                    z10 = true;
                                    i23 += iArr[1] - i20;
                                }
                            } else if (i22 != 80) {
                                i23 = paddingTop;
                            } else {
                                i23 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                                if (i20 != -1) {
                                    i23 -= iArr2[2] - (s10.getMeasuredHeight() - i20);
                                }
                            }
                            z10 = true;
                        } else {
                            z10 = true;
                            i23 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        }
                        if (t(i28)) {
                            i14 += this.f936l;
                        }
                        int i30 = ((LinearLayout.LayoutParams) aVar).leftMargin + i14;
                        i17 = paddingTop;
                        A(s10, i30 + q(s10), i23, measuredWidth, measuredHeight);
                        i14 = i30 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(s10);
                        i27 = i29 + p(s10, i28);
                        i27++;
                        virtualChildCount = i19;
                        i26 = i18;
                        z12 = z10;
                        paddingTop = i17;
                    }
                } else {
                    i19 = virtualChildCount;
                }
                i20 = -1;
                i21 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i21 < 0) {
                }
                i22 = i21 & 112;
                i18 = i26;
                if (i22 == 16) {
                }
                if (t(i28)) {
                }
                int i302 = ((LinearLayout.LayoutParams) aVar).leftMargin + i14;
                i17 = paddingTop;
                A(s10, i302 + q(s10), i23, measuredWidth, measuredHeight);
                i14 = i302 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(s10);
                i27 = i29 + p(s10, i28);
                i27++;
                virtualChildCount = i19;
                i26 = i18;
                z12 = z10;
                paddingTop = i17;
            } else {
                i17 = paddingTop;
                i19 = virtualChildCount;
                i18 = i26;
                z10 = true;
            }
            i27++;
            virtualChildCount = i19;
            i26 = i18;
            z12 = z10;
            paddingTop = i17;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void v(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int paddingLeft = getPaddingLeft();
        int i19 = i12 - i10;
        int paddingRight = i19 - getPaddingRight();
        int paddingRight2 = (i19 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i20 = this.f929e;
        int i21 = i20 & 112;
        int i22 = i20 & 8388615;
        if (i21 != 16) {
            i14 = i21 != 80 ? getPaddingTop() : ((getPaddingTop() + i13) - i11) - this.f930f;
        } else {
            i14 = getPaddingTop() + (((i13 - i11) - this.f930f) / 2);
        }
        int i23 = 0;
        while (i23 < virtualChildCount) {
            View s10 = s(i23);
            if (s10 == null) {
                i14 += y(i23);
            } else if (s10.getVisibility() != 8) {
                int measuredWidth = s10.getMeasuredWidth();
                int measuredHeight = s10.getMeasuredHeight();
                a aVar = (a) s10.getLayoutParams();
                i22 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i22 < 0) {
                }
                int b10 = f.b(i22, d0.E(this)) & 7;
                if (b10 == 1) {
                    i18 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i17 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else if (b10 != 5) {
                    i16 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    int i24 = i16;
                    if (t(i23)) {
                        i14 += this.f937m;
                    }
                    int i25 = i14 + ((LinearLayout.LayoutParams) aVar).topMargin;
                    A(s10, i24, i25 + q(s10), measuredWidth, measuredHeight);
                    i14 = i25 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(s10);
                    i23 += p(s10, i23);
                    i15 = 1;
                    i23 += i15;
                } else {
                    i18 = paddingRight - measuredWidth;
                    i17 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i16 = i18 - i17;
                int i242 = i16;
                if (t(i23)) {
                }
                int i252 = i14 + ((LinearLayout.LayoutParams) aVar).topMargin;
                A(s10, i242, i252 + q(s10), measuredWidth, measuredHeight);
                i14 = i252 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(s10);
                i23 += p(s10, i23);
                i15 = 1;
                i23 += i15;
            }
            i15 = 1;
            i23 += i15;
        }
    }

    void w(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void x(int i10, int i11) {
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        float f10;
        int i19;
        boolean z10;
        int baseline;
        int i20;
        int i21;
        int i22;
        boolean z11;
        boolean z12;
        int i23;
        int i24;
        int i25;
        View view;
        boolean z13;
        int measuredHeight;
        int baseline2;
        int i26;
        char c10;
        int i27;
        this.f930f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (this.f933i == null || this.f934j == null) {
            this.f933i = new int[4];
            this.f934j = new int[4];
        }
        int[] iArr2 = this.f933i;
        int[] iArr3 = this.f934j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z14 = this.f925a;
        boolean z15 = this.f932h;
        int i28 = 1073741824;
        boolean z16 = mode == 1073741824;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        boolean z17 = false;
        int i34 = 0;
        boolean z18 = false;
        boolean z19 = true;
        float f11 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (i29 >= virtualChildCount) {
                break;
            }
            View s10 = s(i29);
            if (s10 == null) {
                this.f930f += y(i29);
            } else if (s10.getVisibility() == 8) {
                i29 += p(s10, i29);
            } else {
                if (t(i29)) {
                    this.f930f += this.f936l;
                }
                a aVar = (a) s10.getLayoutParams();
                float f12 = ((LinearLayout.LayoutParams) aVar).weight;
                float f13 = f11 + f12;
                if (mode == i28 && ((LinearLayout.LayoutParams) aVar).width == 0 && f12 > 0.0f) {
                    if (z16) {
                        this.f930f += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                    } else {
                        int i35 = this.f930f;
                        this.f930f = Math.max(i35, ((LinearLayout.LayoutParams) aVar).leftMargin + i35 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                    }
                    if (z14) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        s10.measure(makeMeasureSpec, makeMeasureSpec);
                        i25 = i29;
                        z12 = z15;
                        z11 = z14;
                        view = s10;
                    } else {
                        i25 = i29;
                        z12 = z15;
                        z11 = z14;
                        view = s10;
                        z17 = true;
                        i24 = 1073741824;
                        if (mode2 == i24 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z13 = true;
                            z18 = true;
                        } else {
                            z13 = false;
                        }
                        int i36 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i36;
                        i34 = View.combineMeasuredStates(i34, view.getMeasuredState());
                        if (z11 && (baseline2 = view.getBaseline()) != -1) {
                            i26 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i26 < 0) {
                                i26 = this.f929e;
                            }
                            int i37 = (((i26 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i37] = Math.max(iArr2[i37], baseline2);
                            iArr[i37] = Math.max(iArr[i37], measuredHeight - baseline2);
                        }
                        i31 = Math.max(i31, measuredHeight);
                        z19 = !z19 && ((LinearLayout.LayoutParams) aVar).height == -1;
                        if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                            if (!z13) {
                                i36 = measuredHeight;
                            }
                            i33 = Math.max(i33, i36);
                        } else {
                            i33 = i33;
                            if (!z13) {
                                i36 = measuredHeight;
                            }
                            i32 = Math.max(i32, i36);
                        }
                        int i38 = i25;
                        i23 = p(view, i38) + i38;
                        f11 = f13;
                        i29 = i23 + 1;
                        iArr3 = iArr;
                        z15 = z12;
                        z14 = z11;
                        i28 = i24;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) aVar).width != 0 || f12 <= 0.0f) {
                        c10 = 65534;
                        i27 = Integer.MIN_VALUE;
                    } else {
                        c10 = 65534;
                        ((LinearLayout.LayoutParams) aVar).width = -2;
                        i27 = 0;
                    }
                    i25 = i29;
                    int i39 = i27;
                    z12 = z15;
                    z11 = z14;
                    w(s10, i25, i10, f13 == 0.0f ? this.f930f : 0, i11, 0);
                    if (i39 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) aVar).width = i39;
                    }
                    int measuredWidth = s10.getMeasuredWidth();
                    if (z16) {
                        view = s10;
                        this.f930f += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + r(view);
                    } else {
                        view = s10;
                        int i40 = this.f930f;
                        this.f930f = Math.max(i40, i40 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + r(view));
                    }
                    if (z12) {
                        i30 = Math.max(measuredWidth, i30);
                    }
                }
                i24 = 1073741824;
                if (mode2 == i24) {
                }
                z13 = false;
                int i362 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i362;
                i34 = View.combineMeasuredStates(i34, view.getMeasuredState());
                if (z11) {
                    i26 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i26 < 0) {
                    }
                    int i372 = (((i26 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i372] = Math.max(iArr2[i372], baseline2);
                    iArr[i372] = Math.max(iArr[i372], measuredHeight - baseline2);
                }
                i31 = Math.max(i31, measuredHeight);
                if (!z19) {
                }
                if (((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                }
                int i382 = i25;
                i23 = p(view, i382) + i382;
                f11 = f13;
                i29 = i23 + 1;
                iArr3 = iArr;
                z15 = z12;
                z14 = z11;
                i28 = i24;
            }
            z12 = z15;
            z11 = z14;
            i24 = i28;
            i23 = i29;
            i29 = i23 + 1;
            iArr3 = iArr;
            z15 = z12;
            z14 = z11;
            i28 = i24;
        }
        boolean z20 = z15;
        boolean z21 = z14;
        int i41 = i31;
        int i42 = i32;
        int i43 = i33;
        int i44 = i34;
        if (this.f930f > 0 && t(virtualChildCount)) {
            this.f930f += this.f936l;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            i13 = i41;
            i12 = i44;
        } else {
            i12 = i44;
            i13 = Math.max(i41, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z20 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f930f = 0;
            int i45 = 0;
            while (i45 < virtualChildCount) {
                View s11 = s(i45);
                if (s11 == null) {
                    this.f930f += y(i45);
                } else if (s11.getVisibility() == 8) {
                    i45 += p(s11, i45);
                } else {
                    a aVar2 = (a) s11.getLayoutParams();
                    if (z16) {
                        this.f930f += ((LinearLayout.LayoutParams) aVar2).leftMargin + i30 + ((LinearLayout.LayoutParams) aVar2).rightMargin + r(s11);
                    } else {
                        int i46 = this.f930f;
                        i22 = i13;
                        this.f930f = Math.max(i46, i46 + i30 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + r(s11));
                        i45++;
                        i13 = i22;
                    }
                }
                i22 = i13;
                i45++;
                i13 = i22;
            }
        }
        int i47 = i13;
        int paddingLeft = this.f930f + getPaddingLeft() + getPaddingRight();
        this.f930f = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, 0);
        int i48 = (16777215 & resolveSizeAndState) - this.f930f;
        if (z17 || (i48 != 0 && f11 > 0.0f)) {
            float f14 = this.f931g;
            if (f14 > 0.0f) {
                f11 = f14;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f930f = 0;
            int i49 = i42;
            int i50 = -1;
            int i51 = i12;
            int i52 = 0;
            while (i52 < virtualChildCount) {
                View s12 = s(i52);
                if (s12 == null || s12.getVisibility() == 8) {
                    i18 = i48;
                    i17 = virtualChildCount;
                } else {
                    a aVar3 = (a) s12.getLayoutParams();
                    float f15 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f15 > 0.0f) {
                        int i53 = (int) ((i48 * f15) / f11);
                        f11 -= f15;
                        i18 = i48 - i53;
                        i17 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i21 = 1073741824;
                            if (mode == 1073741824) {
                                if (i53 <= 0) {
                                    i53 = 0;
                                }
                                s12.measure(View.MeasureSpec.makeMeasureSpec(i53, 1073741824), childMeasureSpec);
                                i51 = View.combineMeasuredStates(i51, s12.getMeasuredState() & (-16777216));
                            }
                        } else {
                            i21 = 1073741824;
                        }
                        int measuredWidth2 = s12.getMeasuredWidth() + i53;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        s12.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i21), childMeasureSpec);
                        i51 = View.combineMeasuredStates(i51, s12.getMeasuredState() & (-16777216));
                    } else {
                        i18 = i48;
                        i17 = virtualChildCount;
                    }
                    if (z16) {
                        this.f930f += s12.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + r(s12);
                        f10 = f11;
                    } else {
                        int i54 = this.f930f;
                        f10 = f11;
                        this.f930f = Math.max(i54, s12.getMeasuredWidth() + i54 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + r(s12));
                    }
                    boolean z22 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i55 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = s12.getMeasuredHeight() + i55;
                    i50 = Math.max(i50, measuredHeight2);
                    if (!z22) {
                        i55 = measuredHeight2;
                    }
                    int max = Math.max(i49, i55);
                    if (z19) {
                        i19 = -1;
                        if (((LinearLayout.LayoutParams) aVar3).height == -1) {
                            z10 = true;
                            if (z21 && (baseline = s12.getBaseline()) != i19) {
                                i20 = ((LinearLayout.LayoutParams) aVar3).gravity;
                                if (i20 < 0) {
                                    i20 = this.f929e;
                                }
                                int i56 = (((i20 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i56] = Math.max(iArr2[i56], baseline);
                                iArr[i56] = Math.max(iArr[i56], measuredHeight2 - baseline);
                            }
                            z19 = z10;
                            i49 = max;
                            f11 = f10;
                        }
                    } else {
                        i19 = -1;
                    }
                    z10 = false;
                    if (z21) {
                        i20 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i20 < 0) {
                        }
                        int i562 = (((i20 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i562] = Math.max(iArr2[i562], baseline);
                        iArr[i562] = Math.max(iArr[i562], measuredHeight2 - baseline);
                    }
                    z19 = z10;
                    i49 = max;
                    f11 = f10;
                }
                i52++;
                i48 = i18;
                virtualChildCount = i17;
            }
            i15 = i11;
            i14 = virtualChildCount;
            this.f930f += getPaddingLeft() + getPaddingRight();
            i47 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i50 : Math.max(i50, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i16 = i49;
            i12 = i51;
        } else {
            i16 = Math.max(i42, i43);
            if (z20 && mode != 1073741824) {
                for (int i57 = 0; i57 < virtualChildCount; i57++) {
                    View s13 = s(i57);
                    if (!(s13 == null || s13.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((a) s13.getLayoutParams())).weight <= 0.0f)) {
                        s13.measure(View.MeasureSpec.makeMeasureSpec(i30, 1073741824), View.MeasureSpec.makeMeasureSpec(s13.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i15 = i11;
            i14 = virtualChildCount;
        }
        if (z19 || mode2 == 1073741824) {
            i16 = i47;
        }
        setMeasuredDimension(resolveSizeAndState | (i12 & (-16777216)), View.resolveSizeAndState(Math.max(i16 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i15, i12 << 16));
        if (z18) {
            k(i14, i10);
        }
    }

    int y(int i10) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void z(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z10;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        View view;
        int i27;
        boolean z11;
        int i28;
        int i29;
        this.f930f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i30 = this.f926b;
        boolean z12 = this.f932h;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        boolean z13 = false;
        boolean z14 = false;
        float f10 = 0.0f;
        boolean z15 = true;
        while (true) {
            int i37 = 8;
            int i38 = i34;
            if (i36 < virtualChildCount) {
                View s10 = s(i36);
                if (s10 == null) {
                    this.f930f += y(i36);
                    i20 = virtualChildCount;
                    i21 = mode2;
                    i34 = i38;
                } else {
                    int i39 = i31;
                    if (s10.getVisibility() == 8) {
                        i36 += p(s10, i36);
                        i20 = virtualChildCount;
                        i34 = i38;
                        i31 = i39;
                        i21 = mode2;
                    } else {
                        if (t(i36)) {
                            this.f930f += this.f937m;
                        }
                        a aVar = (a) s10.getLayoutParams();
                        float f11 = ((LinearLayout.LayoutParams) aVar).weight;
                        float f12 = f10 + f11;
                        if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar).height == 0 && f11 > 0.0f) {
                            int i40 = this.f930f;
                            i23 = i32;
                            this.f930f = Math.max(i40, ((LinearLayout.LayoutParams) aVar).topMargin + i40 + ((LinearLayout.LayoutParams) aVar).bottomMargin);
                            i27 = i33;
                            view = s10;
                            i22 = i35;
                            z13 = true;
                            i26 = i39;
                            i20 = virtualChildCount;
                            i21 = mode2;
                            i24 = i38;
                            i25 = i36;
                        } else {
                            i23 = i32;
                            if (((LinearLayout.LayoutParams) aVar).height != 0 || f11 <= 0.0f) {
                                i29 = Integer.MIN_VALUE;
                            } else {
                                ((LinearLayout.LayoutParams) aVar).height = -2;
                                i29 = 0;
                            }
                            i26 = i39;
                            int i41 = i29;
                            int i42 = i33;
                            i20 = virtualChildCount;
                            i21 = mode2;
                            i24 = i38;
                            i22 = i35;
                            i25 = i36;
                            w(s10, i36, i10, 0, i11, f12 == 0.0f ? this.f930f : 0);
                            if (i41 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) aVar).height = i41;
                            }
                            int measuredHeight = s10.getMeasuredHeight();
                            int i43 = this.f930f;
                            view = s10;
                            this.f930f = Math.max(i43, i43 + measuredHeight + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + r(view));
                            i27 = z12 ? Math.max(measuredHeight, i42) : i42;
                        }
                        if (i30 >= 0 && i30 == i25 + 1) {
                            this.f927c = this.f930f;
                        }
                        if (i25 >= i30 || ((LinearLayout.LayoutParams) aVar).weight <= 0.0f) {
                            if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar).width != -1) {
                                z11 = false;
                            } else {
                                z11 = true;
                                z14 = true;
                            }
                            int i44 = ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                            int measuredWidth = view.getMeasuredWidth() + i44;
                            int max = Math.max(i23, measuredWidth);
                            int combineMeasuredStates = View.combineMeasuredStates(i26, view.getMeasuredState());
                            z15 = z15 && ((LinearLayout.LayoutParams) aVar).width == -1;
                            if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                                if (!z11) {
                                    i44 = measuredWidth;
                                }
                                i34 = Math.max(i24, i44);
                                i28 = i22;
                            } else {
                                if (!z11) {
                                    i44 = measuredWidth;
                                }
                                i28 = Math.max(i22, i44);
                                i34 = i24;
                            }
                            i36 = p(view, i25) + i25;
                            i33 = i27;
                            f10 = f12;
                            i35 = i28;
                            i31 = combineMeasuredStates;
                            i32 = max;
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    }
                }
                i36++;
                mode2 = i21;
                virtualChildCount = i20;
            } else {
                int i45 = i31;
                int i46 = i33;
                int i47 = i35;
                int i48 = virtualChildCount;
                int i49 = mode2;
                int i50 = i32;
                if (this.f930f > 0) {
                    i12 = i48;
                    if (t(i12)) {
                        this.f930f += this.f937m;
                    }
                } else {
                    i12 = i48;
                }
                if (z12 && (i49 == Integer.MIN_VALUE || i49 == 0)) {
                    this.f930f = 0;
                    int i51 = 0;
                    while (i51 < i12) {
                        View s11 = s(i51);
                        if (s11 == null) {
                            this.f930f += y(i51);
                        } else if (s11.getVisibility() == i37) {
                            i51 += p(s11, i51);
                        } else {
                            a aVar2 = (a) s11.getLayoutParams();
                            int i52 = this.f930f;
                            this.f930f = Math.max(i52, i52 + i46 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + r(s11));
                        }
                        i51++;
                        i37 = 8;
                    }
                }
                int paddingTop = this.f930f + getPaddingTop() + getPaddingBottom();
                this.f930f = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, 0);
                int i53 = (16777215 & resolveSizeAndState) - this.f930f;
                if (z13 || (i53 != 0 && f10 > 0.0f)) {
                    float f13 = this.f931g;
                    if (f13 > 0.0f) {
                        f10 = f13;
                    }
                    this.f930f = 0;
                    int i54 = i53;
                    int i55 = i47;
                    i14 = i45;
                    int i56 = 0;
                    while (i56 < i12) {
                        View s12 = s(i56);
                        if (s12.getVisibility() == 8) {
                            i16 = i54;
                        } else {
                            a aVar3 = (a) s12.getLayoutParams();
                            float f14 = ((LinearLayout.LayoutParams) aVar3).weight;
                            if (f14 > 0.0f) {
                                int i57 = (int) ((i54 * f14) / f10);
                                f10 -= f14;
                                i16 = i54 - i57;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin, ((LinearLayout.LayoutParams) aVar3).width);
                                if (((LinearLayout.LayoutParams) aVar3).height == 0) {
                                    i19 = 1073741824;
                                    if (i49 == 1073741824) {
                                        if (i57 <= 0) {
                                            i57 = 0;
                                        }
                                        s12.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i57, 1073741824));
                                        i14 = View.combineMeasuredStates(i14, s12.getMeasuredState() & (-256));
                                    }
                                } else {
                                    i19 = 1073741824;
                                }
                                int measuredHeight2 = s12.getMeasuredHeight() + i57;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                s12.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i19));
                                i14 = View.combineMeasuredStates(i14, s12.getMeasuredState() & (-256));
                            } else {
                                i16 = i54;
                            }
                            int i58 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                            int measuredWidth2 = s12.getMeasuredWidth() + i58;
                            i50 = Math.max(i50, measuredWidth2);
                            f10 = f10;
                            if (mode != 1073741824) {
                                i17 = i14;
                                i18 = -1;
                                if (((LinearLayout.LayoutParams) aVar3).width == -1) {
                                    z10 = true;
                                    if (!z10) {
                                        i58 = measuredWidth2;
                                    }
                                    int max2 = Math.max(i55, i58);
                                    boolean z16 = !z15 && ((LinearLayout.LayoutParams) aVar3).width == i18;
                                    int i59 = this.f930f;
                                    this.f930f = Math.max(i59, s12.getMeasuredHeight() + i59 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + r(s12));
                                    z15 = z16;
                                    i14 = i17;
                                    i55 = max2;
                                }
                            } else {
                                i17 = i14;
                                i18 = -1;
                            }
                            z10 = false;
                            if (!z10) {
                            }
                            int max22 = Math.max(i55, i58);
                            if (!z15) {
                            }
                            int i592 = this.f930f;
                            this.f930f = Math.max(i592, s12.getMeasuredHeight() + i592 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + r(s12));
                            z15 = z16;
                            i14 = i17;
                            i55 = max22;
                        }
                        i56++;
                        i54 = i16;
                    }
                    i13 = i10;
                    this.f930f += getPaddingTop() + getPaddingBottom();
                    i15 = i55;
                } else {
                    i15 = Math.max(i47, i38);
                    if (z12 && i49 != 1073741824) {
                        for (int i60 = 0; i60 < i12; i60++) {
                            View s13 = s(i60);
                            if (!(s13 == null || s13.getVisibility() == 8 || ((LinearLayout.LayoutParams) ((a) s13.getLayoutParams())).weight <= 0.0f)) {
                                s13.measure(View.MeasureSpec.makeMeasureSpec(s13.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i46, 1073741824));
                            }
                        }
                    }
                    i13 = i10;
                    i14 = i45;
                }
                if (z15 || mode == 1073741824) {
                    i15 = i50;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i15 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i13, i14), resolveSizeAndState);
                if (z14) {
                    l(i12, i11);
                    return;
                }
                return;
            }
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f925a = true;
        this.f926b = -1;
        this.f927c = 0;
        this.f929e = 8388659;
        int[] iArr = j.f24881f1;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        d0.r0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        int k10 = v10.k(j.f24891h1, -1);
        if (k10 >= 0) {
            setOrientation(k10);
        }
        int k11 = v10.k(j.f24886g1, -1);
        if (k11 >= 0) {
            setGravity(k11);
        }
        boolean a10 = v10.a(j.f24896i1, true);
        if (!a10) {
            setBaselineAligned(a10);
        }
        this.f931g = v10.i(j.f24906k1, -1.0f);
        this.f926b = v10.k(j.f24901j1, -1);
        this.f932h = v10.a(j.f24921n1, false);
        setDividerDrawable(v10.g(j.f24911l1));
        this.f938n = v10.k(j.f24926o1, 0);
        this.f939o = v10.f(j.f24916m1, 0);
        v10.w();
    }
}
