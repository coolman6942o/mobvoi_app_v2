package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.a0;
import androidx.core.view.d0;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.s;
import androidx.core.view.u;
import androidx.recyclerview.widget.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import k0.c;
import k0.e;
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements s, p, a0 {
    private static final a A = new a();
    private static final int[] B = {16843130};

    /* renamed from: a  reason: collision with root package name */
    private long f2630a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f2631b;

    /* renamed from: c  reason: collision with root package name */
    private OverScroller f2632c;

    /* renamed from: d  reason: collision with root package name */
    public EdgeEffect f2633d;

    /* renamed from: e  reason: collision with root package name */
    public EdgeEffect f2634e;

    /* renamed from: f  reason: collision with root package name */
    private int f2635f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2636g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2637h;

    /* renamed from: i  reason: collision with root package name */
    private View f2638i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2639j;

    /* renamed from: k  reason: collision with root package name */
    private VelocityTracker f2640k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2641l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2642m;

    /* renamed from: n  reason: collision with root package name */
    private int f2643n;

    /* renamed from: o  reason: collision with root package name */
    private int f2644o;

    /* renamed from: p  reason: collision with root package name */
    private int f2645p;

    /* renamed from: q  reason: collision with root package name */
    private int f2646q;

    /* renamed from: r  reason: collision with root package name */
    private final int[] f2647r;

    /* renamed from: s  reason: collision with root package name */
    private final int[] f2648s;

    /* renamed from: t  reason: collision with root package name */
    private int f2649t;

    /* renamed from: u  reason: collision with root package name */
    private int f2650u;

    /* renamed from: v  reason: collision with root package name */
    private SavedState f2651v;

    /* renamed from: w  reason: collision with root package name */
    private final u f2652w;

    /* renamed from: x  reason: collision with root package name */
    private final q f2653x;

    /* renamed from: y  reason: collision with root package name */
    private float f2654y;

    /* renamed from: z  reason: collision with root package name */
    private b f2655z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f2656a;

        /* loaded from: classes.dex */
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

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2656a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2656a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2656a = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    static class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            e.a(accessibilityEvent, nestedScrollView.getScrollX());
            e.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.a
        public void g(View view, c cVar) {
            int scrollRange;
            super.g(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.a0(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                cVar.t0(true);
                if (nestedScrollView.getScrollY() > 0) {
                    cVar.b(c.a.f29699i);
                    cVar.b(c.a.f29703m);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    cVar.b(c.a.f29698h);
                    cVar.b(c.a.f29704n);
                }
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.P(0, max, true);
                    return true;
                } else if (i10 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.P(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void w(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z.a.f37155c);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i10, int i11) {
        view.getDrawingRect(this.f2631b);
        offsetDescendantRectToMyCoords(view, this.f2631b);
        return this.f2631b.bottom + i10 >= getScrollY() && this.f2631b.top - i10 <= getScrollY() + i11;
    }

    private void C(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2653x.e(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2646q) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f2635f = (int) motionEvent.getY(i10);
            this.f2646q = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f2640k;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.f2640k;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2640k = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int H(int i10, float f10) {
        int round;
        float d10;
        float width = f10 / getWidth();
        float height = i10 / getHeight();
        float f11 = 0.0f;
        if (e.b(this.f2633d) != 0.0f) {
            d10 = -e.d(this.f2633d, -height, width);
            if (e.b(this.f2633d) == 0.0f) {
                this.f2633d.onRelease();
            }
        } else {
            if (e.b(this.f2634e) != 0.0f) {
                d10 = e.d(this.f2634e, height, 1.0f - width);
                if (e.b(this.f2634e) == 0.0f) {
                    this.f2634e.onRelease();
                }
            }
            round = Math.round(f11 * getHeight());
            if (round != 0) {
                invalidate();
            }
            return round;
        }
        f11 = d10;
        round = Math.round(f11 * getHeight());
        if (round != 0) {
        }
        return round;
    }

    private void I(boolean z10) {
        if (z10) {
            Q(2, 1);
        } else {
            S(1);
        }
        this.f2650u = getScrollY();
        d0.k0(this);
    }

    private boolean J(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View r10 = r(z11, i11, i12);
        if (r10 == null) {
            r10 = this;
        }
        if (i11 < scrollY || i12 > i13) {
            h(z11 ? i11 - scrollY : i12 - i13);
            z10 = true;
        }
        if (r10 != findFocus()) {
            r10.requestFocus(i10);
        }
        return z10;
    }

    private void K(View view) {
        view.getDrawingRect(this.f2631b);
        offsetDescendantRectToMyCoords(view, this.f2631b);
        int e10 = e(this.f2631b);
        if (e10 != 0) {
            scrollBy(0, e10);
        }
    }

    private boolean L(Rect rect, boolean z10) {
        int e10 = e(rect);
        boolean z11 = e10 != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, e10);
            } else {
                M(0, e10);
            }
        }
        return z11;
    }

    private void N(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2630a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f2632c;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i12);
                I(z10);
            } else {
                if (!this.f2632c.isFinished()) {
                    a();
                }
                scrollBy(i10, i11);
            }
            this.f2630a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    private boolean R(MotionEvent motionEvent) {
        boolean z10;
        if (e.b(this.f2633d) != 0.0f) {
            e.d(this.f2633d, 0.0f, motionEvent.getY() / getHeight());
            z10 = true;
        } else {
            z10 = false;
        }
        if (e.b(this.f2634e) == 0.0f) {
            return z10;
        }
        e.d(this.f2634e, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
        return true;
    }

    private void a() {
        this.f2632c.abortAnimation();
        S(1);
    }

    private boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int d(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2654y == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2654y = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2654y;
    }

    private void h(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f2642m) {
            M(0, i10);
        } else {
            scrollBy(0, i10);
        }
    }

    private boolean i(int i10) {
        if (e.b(this.f2633d) != 0.0f) {
            this.f2633d.onAbsorb(i10);
        } else if (e.b(this.f2634e) == 0.0f) {
            return false;
        } else {
            this.f2634e.onAbsorb(-i10);
        }
        return true;
    }

    private void p() {
        this.f2639j = false;
        G();
        S(0);
        this.f2633d.onRelease();
        this.f2634e.onRelease();
    }

    private View r(boolean z10, int i10, int i11) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = (View) focusables.get(i12);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z12 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12) {
                            if (!z13) {
                            }
                            view = view2;
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else {
                        if (!z13) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean v(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.f2640k;
        if (velocityTracker == null) {
            this.f2640k = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.f2632c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2643n = viewConfiguration.getScaledTouchSlop();
        this.f2644o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2645p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.f2640k == null) {
            this.f2640k = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    boolean E(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        boolean z11;
        boolean z12;
        int overScrollMode = getOverScrollMode();
        boolean z13 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z14 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z15 = overScrollMode == 0 || (overScrollMode == 1 && z13);
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        int i18 = i12 + i10;
        int i19 = !z15 ? 0 : i16;
        int i20 = i13 + i11;
        int i21 = !z16 ? 0 : i17;
        int i22 = -i19;
        int i23 = i19 + i14;
        int i24 = -i21;
        int i25 = i21 + i15;
        if (i18 > i23) {
            i18 = i23;
            z11 = true;
        } else if (i18 < i22) {
            z11 = true;
            i18 = i22;
        } else {
            z11 = false;
        }
        if (i20 > i25) {
            i20 = i25;
            z12 = true;
        } else if (i20 < i24) {
            z12 = true;
            i20 = i24;
        } else {
            z12 = false;
        }
        if (z12 && !u(1)) {
            this.f2632c.springBack(i18, i20, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i18, i20, z11, z12);
        return z11 || z12;
    }

    public boolean F(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f2631b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2631b;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2631b.top = getScrollY() - height;
            Rect rect2 = this.f2631b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2631b;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return J(i10, i11, i12);
    }

    public final void M(int i10, int i11) {
        N(i10, i11, g.f.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    void O(int i10, int i11, int i12, boolean z10) {
        N(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    void P(int i10, int i11, boolean z10) {
        O(i10, i11, g.f.DEFAULT_SWIPE_ANIMATION_DURATION, z10);
    }

    public boolean Q(int i10, int i11) {
        return this.f2653x.p(i10, i11);
    }

    public void S(int i10) {
        this.f2653x.r(i10);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean b(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !B(findNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            h(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f2631b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2631b);
            h(e(this.f2631b));
            findNextFocus.requestFocus(i10);
        }
        if (findFocus == null || !findFocus.isFocused() || !z(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f2632c.isFinished()) {
            this.f2632c.computeScrollOffset();
            int currY = this.f2632c.getCurrY();
            int i10 = currY - this.f2650u;
            this.f2650u = currY;
            int[] iArr = this.f2648s;
            boolean z10 = false;
            iArr[1] = 0;
            f(0, i10, iArr, null, 1);
            int i11 = i10 - this.f2648s[1];
            int scrollRange = getScrollRange();
            if (i11 != 0) {
                int scrollY = getScrollY();
                E(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i12 = i11 - scrollY2;
                int[] iArr2 = this.f2648s;
                iArr2[1] = 0;
                g(0, scrollY2, 0, i12, this.f2647r, 1, iArr2);
                i11 = i12 - this.f2648s[1];
            }
            if (i11 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    z10 = true;
                }
                if (z10) {
                    if (i11 < 0) {
                        if (this.f2633d.isFinished()) {
                            this.f2633d.onAbsorb((int) this.f2632c.getCurrVelocity());
                        }
                    } else if (this.f2634e.isFinished()) {
                        this.f2634e.onAbsorb((int) this.f2632c.getCurrVelocity());
                    }
                }
                a();
            }
            if (!this.f2632c.isFinished()) {
                d0.k0(this);
            } else {
                S(1);
            }
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f2653x.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f2653x.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return f(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f2653x.f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i11 = 0;
        if (!this.f2633d.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            int i12 = Build.VERSION.SDK_INT;
            if (i12 < 21 || getClipToPadding()) {
                width -= getPaddingLeft() + getPaddingRight();
                i10 = getPaddingLeft() + 0;
            } else {
                i10 = 0;
            }
            if (i12 >= 21 && getClipToPadding()) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i10, min);
            this.f2633d.setSize(width, height);
            if (this.f2633d.draw(canvas)) {
                d0.k0(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f2634e.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            int i13 = Build.VERSION.SDK_INT;
            if (i13 < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i11 = 0 + getPaddingLeft();
            }
            if (i13 >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i11 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f2634e.setSize(width2, height2);
            if (this.f2634e.draw(canvas)) {
                d0.k0(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    protected int e(Rect rect) {
        int i10;
        int i11;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i13 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i12 - verticalFadingEdgeLength : i12;
        int i14 = rect.bottom;
        if (i14 > i13 && rect.top > scrollY) {
            if (rect.height() > height) {
                i11 = rect.top - scrollY;
            } else {
                i11 = rect.bottom - i13;
            }
            return Math.min(i11 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i12);
        } else if (rect.top >= scrollY || i14 >= i13) {
            return 0;
        } else {
            if (rect.height() > height) {
                i10 = 0 - (i13 - rect.bottom);
            } else {
                i10 = 0 - (scrollY - rect.top);
            }
            return Math.max(i10, -getScrollY());
        }
    }

    public boolean f(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.f2653x.d(i10, i11, iArr, iArr2, i12);
    }

    public void g(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        this.f2653x.e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2652w.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // android.view.View, androidx.core.view.p
    public boolean isNestedScrollingEnabled() {
        return this.f2653x.l();
    }

    @Override // androidx.core.view.s
    public void j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        C(i13, i14, iArr);
    }

    @Override // androidx.core.view.r
    public void k(View view, int i10, int i11, int i12, int i13, int i14) {
        C(i13, i14, null);
    }

    @Override // androidx.core.view.r
    public boolean l(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.r
    public void m(View view, View view2, int i10, int i11) {
        this.f2652w.c(view, view2, i10, i11);
        Q(2, i11);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i10, int i11) {
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.r
    public void n(View view, int i10) {
        this.f2652w.e(view, i10);
        S(i10);
    }

    @Override // androidx.core.view.r
    public void o(View view, int i10, int i11, int[] iArr, int i12) {
        f(i10, i11, iArr, null, i12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2637h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f2639j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int verticalScrollFactorCompat = scrollY - ((int) (axisValue * getVerticalScrollFactorCompat()));
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 2 && this.f2639j) {
            return true;
        }
        int i10 = action & 255;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = this.f2646q;
                    if (i11 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i11);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i11 + " in onInterceptTouchEvent");
                        } else {
                            int y10 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y10 - this.f2635f) > this.f2643n && (2 & getNestedScrollAxes()) == 0) {
                                this.f2639j = true;
                                this.f2635f = y10;
                                y();
                                this.f2640k.addMovement(motionEvent);
                                this.f2649t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i10 != 3) {
                    if (i10 == 6) {
                        D(motionEvent);
                    }
                }
            }
            this.f2639j = false;
            this.f2646q = -1;
            G();
            if (this.f2632c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                d0.k0(this);
            }
            S(0);
        } else {
            int y11 = (int) motionEvent.getY();
            if (!v((int) motionEvent.getX(), y11)) {
                if (!R(motionEvent) && this.f2632c.isFinished()) {
                    z10 = false;
                }
                this.f2639j = z10;
                G();
            } else {
                this.f2635f = y11;
                this.f2646q = motionEvent.getPointerId(0);
                w();
                this.f2640k.addMovement(motionEvent);
                this.f2632c.computeScrollOffset();
                if (!R(motionEvent) && this.f2632c.isFinished()) {
                    z10 = false;
                }
                this.f2639j = z10;
                Q(2, 0);
            }
        }
        return this.f2639j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int i14 = 0;
        this.f2636g = false;
        View view = this.f2638i;
        if (view != null && A(view, this)) {
            K(this.f2638i);
        }
        this.f2638i = null;
        if (!this.f2637h) {
            if (this.f2651v != null) {
                scrollTo(getScrollX(), this.f2651v.f2656a);
                this.f2651v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i14 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int d10 = d(scrollY, paddingTop, i14);
            if (d10 != scrollY) {
                scrollTo(getScrollX(), d10);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2637h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2641l && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        s((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        o(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        C(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        m(view, view2, i10, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View view;
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, null, i10);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        }
        if (view != null && !z(view)) {
            return view.requestFocus(i10, rect);
        }
        return false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2651v = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2656a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        b bVar = this.f2655z;
        if (bVar != null) {
            bVar.w(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && B(findFocus, 0, i13)) {
            findFocus.getDrawingRect(this.f2631b);
            offsetDescendantRectToMyCoords(findFocus, this.f2631b);
            h(e(this.f2631b));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return l(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onStopNestedScroll(View view) {
        n(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01d8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        y();
        int actionMasked = motionEvent.getActionMasked();
        boolean z10 = false;
        if (actionMasked == 0) {
            this.f2649t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f2649t);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f2640k;
                velocityTracker.computeCurrentVelocity(1000, this.f2645p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2646q);
                if (Math.abs(yVelocity) >= this.f2644o) {
                    if (!i(yVelocity)) {
                        int i10 = -yVelocity;
                        float f10 = i10;
                        if (!dispatchNestedPreFling(0.0f, f10)) {
                            dispatchNestedFling(0.0f, f10, true);
                            s(i10);
                        }
                    }
                } else if (this.f2632c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    d0.k0(this);
                }
                this.f2646q = -1;
                p();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f2646q);
                if (findPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f2646q + " in onTouchEvent");
                } else {
                    int y10 = (int) motionEvent.getY(findPointerIndex);
                    int i11 = this.f2635f - y10;
                    int H = i11 - H(i11, motionEvent.getX(findPointerIndex));
                    if (!this.f2639j && Math.abs(H) > this.f2643n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2639j = true;
                        H = H > 0 ? H - this.f2643n : H + this.f2643n;
                    }
                    int i12 = H;
                    if (this.f2639j) {
                        if (f(0, i12, this.f2648s, this.f2647r, 0)) {
                            i12 -= this.f2648s[1];
                            this.f2649t += this.f2647r[1];
                        }
                        int i13 = i12;
                        this.f2635f = y10 - this.f2647r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z11 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        boolean z12 = E(0, i13, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !u(0);
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.f2648s;
                        iArr[1] = 0;
                        g(0, scrollY2, 0, i13 - scrollY2, this.f2647r, 0, iArr);
                        int i14 = this.f2635f;
                        int[] iArr2 = this.f2647r;
                        this.f2635f = i14 - iArr2[1];
                        this.f2649t += iArr2[1];
                        if (z11) {
                            int i15 = i13 - this.f2648s[1];
                            int i16 = scrollY + i15;
                            if (i16 < 0) {
                                e.d(this.f2633d, (-i15) / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f2634e.isFinished()) {
                                    this.f2634e.onRelease();
                                }
                            } else if (i16 > scrollRange) {
                                e.d(this.f2634e, i15 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.f2633d.isFinished()) {
                                    this.f2633d.onRelease();
                                }
                            }
                            if (!this.f2633d.isFinished() || !this.f2634e.isFinished()) {
                                d0.k0(this);
                                if (z10) {
                                    this.f2640k.clear();
                                }
                            }
                        }
                        z10 = z12;
                        if (z10) {
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f2639j && getChildCount() > 0 && this.f2632c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    d0.k0(this);
                }
                this.f2646q = -1;
                p();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f2635f = (int) motionEvent.getY(actionIndex);
                this.f2646q = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                D(motionEvent);
                this.f2635f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f2646q));
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            if (this.f2639j && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2632c.isFinished()) {
                a();
            }
            this.f2635f = (int) motionEvent.getY();
            this.f2646q = motionEvent.getPointerId(0);
            Q(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f2640k;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public boolean q(KeyEvent keyEvent) {
        this.f2631b.setEmpty();
        int i10 = 130;
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        return false;
                    }
                    if (keyEvent.isShiftPressed()) {
                        i10 = 33;
                    }
                    F(i10);
                    return false;
                } else if (!keyEvent.isAltPressed()) {
                    return b(130);
                } else {
                    return t(130);
                }
            } else if (!keyEvent.isAltPressed()) {
                return b(33);
            } else {
                return t(33);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f2636g) {
            K(view2);
        } else {
            this.f2638i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return L(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2636g = true;
        super.requestLayout();
    }

    public void s(int i10) {
        if (getChildCount() > 0) {
            this.f2632c.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            I(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int d10 = d(i10, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int d11 = d(i11, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (d10 != getScrollX() || d11 != getScrollY()) {
                super.scrollTo(d10, d11);
            }
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f2641l) {
            this.f2641l = z10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f2653x.m(z10);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.f2655z = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f2642m = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return Q(i10, 0);
    }

    @Override // android.view.View, androidx.core.view.p
    public void stopNestedScroll() {
        S(0);
    }

    public boolean t(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2631b;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2631b.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2631b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2631b;
        return J(i10, rect3.top, rect3.bottom);
    }

    public boolean u(int i10) {
        return this.f2653x.k(i10);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2631b = new Rect();
        this.f2636g = true;
        this.f2637h = false;
        this.f2638i = null;
        this.f2639j = false;
        this.f2642m = true;
        this.f2646q = -1;
        this.f2647r = new int[2];
        this.f2648s = new int[2];
        this.f2633d = e.a(context, attributeSet);
        this.f2634e = e.a(context, attributeSet);
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B, i10, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2652w = new u(this);
        this.f2653x = new q(this);
        setNestedScrollingEnabled(true);
        d0.t0(this, A);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
