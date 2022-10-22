package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.core.view.v;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: p0  reason: collision with root package name */
    static final int[] f4548p0 = {16842931};

    /* renamed from: q0  reason: collision with root package name */
    private static final Comparator<f> f4549q0 = new a();

    /* renamed from: r0  reason: collision with root package name */
    private static final Interpolator f4550r0 = new b();

    /* renamed from: s0  reason: collision with root package name */
    private static final n f4551s0 = new n();
    private int A;
    private int B;
    private float C;
    private float D;
    private float E;
    private float F;
    private VelocityTracker H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private long N;
    private EdgeEffect O;
    private EdgeEffect P;
    private boolean R;
    private int S;
    private List<j> T;
    private j U;
    private j V;
    private List<i> W;

    /* renamed from: a  reason: collision with root package name */
    private int f4552a;

    /* renamed from: e  reason: collision with root package name */
    androidx.viewpager.widget.a f4556e;

    /* renamed from: f  reason: collision with root package name */
    int f4557f;

    /* renamed from: j  reason: collision with root package name */
    private Scroller f4561j;

    /* renamed from: j0  reason: collision with root package name */
    private k f4562j0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4563k;

    /* renamed from: k0  reason: collision with root package name */
    private int f4564k0;

    /* renamed from: l  reason: collision with root package name */
    private l f4565l;

    /* renamed from: l0  reason: collision with root package name */
    private int f4566l0;

    /* renamed from: m  reason: collision with root package name */
    private int f4567m;

    /* renamed from: m0  reason: collision with root package name */
    private ArrayList<View> f4568m0;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f4569n;

    /* renamed from: o  reason: collision with root package name */
    private int f4571o;

    /* renamed from: p  reason: collision with root package name */
    private int f4573p;

    /* renamed from: s  reason: collision with root package name */
    private int f4576s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4577t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4578u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f4579v;

    /* renamed from: x  reason: collision with root package name */
    private boolean f4581x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f4582y;

    /* renamed from: z  reason: collision with root package name */
    private int f4583z;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<f> f4553b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f4554c = new f();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4555d = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private int f4558g = -1;

    /* renamed from: h  reason: collision with root package name */
    private Parcelable f4559h = null;

    /* renamed from: i  reason: collision with root package name */
    private ClassLoader f4560i = null;

    /* renamed from: q  reason: collision with root package name */
    private float f4574q = -3.4028235E38f;

    /* renamed from: r  reason: collision with root package name */
    private float f4575r = Float.MAX_VALUE;

    /* renamed from: w  reason: collision with root package name */
    private int f4580w = 1;
    private int G = -1;
    private boolean Q = true;

    /* renamed from: n0  reason: collision with root package name */
    private final Runnable f4570n0 = new c();

    /* renamed from: o0  reason: collision with root package name */
    private int f4572o0 = 0;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f4584c;

        /* renamed from: d  reason: collision with root package name */
        Parcelable f4585d;

        /* renamed from: e  reason: collision with root package name */
        ClassLoader f4586e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f4584c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4584c);
            parcel.writeParcelable(this.f4585d, i10);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4584c = parcel.readInt();
            this.f4585d = parcel.readParcelable(classLoader);
            this.f4586e = classLoader;
        }
    }

    /* loaded from: classes.dex */
    static class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f4591b - fVar2.f4591b;
        }
    }

    /* loaded from: classes.dex */
    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements v {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f4588a = new Rect();

        d() {
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            n0 f02 = d0.f0(view, n0Var);
            if (f02.p()) {
                return f02;
            }
            Rect rect = this.f4588a;
            rect.left = f02.k();
            rect.top = f02.m();
            rect.right = f02.l();
            rect.bottom = f02.j();
            int childCount = ViewPager.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                n0 i11 = d0.i(ViewPager.this.getChildAt(i10), f02);
                rect.left = Math.min(i11.k(), rect.left);
                rect.top = Math.min(i11.m(), rect.top);
                rect.right = Math.min(i11.l(), rect.right);
                rect.bottom = Math.min(i11.j(), rect.bottom);
            }
            return f02.q(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface e {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f4590a;

        /* renamed from: b  reason: collision with root package name */
        int f4591b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4592c;

        /* renamed from: d  reason: collision with root package name */
        float f4593d;

        /* renamed from: e  reason: collision with root package name */
        float f4594e;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends androidx.core.view.a {
        h() {
        }

        private boolean n() {
            androidx.viewpager.widget.a aVar = ViewPager.this.f4556e;
            return aVar != null && aVar.d() > 1;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.f4556e) != null) {
                accessibilityEvent.setItemCount(aVar.d());
                accessibilityEvent.setFromIndex(ViewPager.this.f4557f);
                accessibilityEvent.setToIndex(ViewPager.this.f4557f);
            }
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            cVar.a0(ViewPager.class.getName());
            cVar.t0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            if (i10 != 4096) {
                if (i10 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f4557f - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f4557f + 1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    /* loaded from: classes.dex */
    public interface j {
        void c(int i10, float f10, int i11);

        void u(int i10);

        void v(int i10);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(View view, float f10);
    }

    /* loaded from: classes.dex */
    private class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.i();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class m implements j {
        @Override // androidx.viewpager.widget.ViewPager.j
        public void c(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void u(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void v(int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class n implements Comparator<View> {
        n() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z10 = gVar.f4595a;
            if (z10 != gVar2.f4595a) {
                return z10 ? 1 : -1;
            }
            return gVar.f4599e - gVar2.f4599e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y();
    }

    private boolean B(float f10, float f11) {
        return (f10 < ((float) this.A) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.A)) && f11 < 0.0f);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.G) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.C = motionEvent.getX(i10);
            this.G = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean G(int i10) {
        if (this.f4553b.size() != 0) {
            f w10 = w();
            int clientWidth = getClientWidth();
            int i11 = this.f4567m;
            int i12 = clientWidth + i11;
            float f10 = clientWidth;
            int i13 = w10.f4591b;
            float f11 = ((i10 / f10) - w10.f4594e) / (w10.f4593d + (i11 / f10));
            this.R = false;
            C(i13, f11, (int) (i12 * f11));
            if (this.R) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.Q) {
            return false;
        } else {
            this.R = false;
            C(0, 0.0f, 0);
            if (this.R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean H(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.C - f10;
        this.C = f10;
        float scrollX = getScrollX() + f11;
        float clientWidth = getClientWidth();
        float f12 = this.f4574q * clientWidth;
        float f13 = this.f4575r * clientWidth;
        boolean z12 = false;
        f fVar = this.f4553b.get(0);
        ArrayList<f> arrayList = this.f4553b;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f4591b != 0) {
            f12 = fVar.f4594e * clientWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (fVar2.f4591b != this.f4556e.d() - 1) {
            f13 = fVar2.f4594e * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.O.onPull(Math.abs(f12 - scrollX) / clientWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.P.onPull(Math.abs(scrollX - f13) / clientWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.C += scrollX - i10;
        scrollTo(i10, getScrollY());
        G(i10);
        return z12;
    }

    private void K(int i10, int i11, int i12, int i13) {
        if (i11 <= 0 || this.f4553b.isEmpty()) {
            f x10 = x(this.f4557f);
            int min = (int) ((x10 != null ? Math.min(x10.f4594e, this.f4575r) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
            if (min != getScrollX()) {
                h(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.f4561j.isFinished()) {
            this.f4561j.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)), getScrollY());
        }
    }

    private void L() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((g) getChildAt(i10).getLayoutParams()).f4595a) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void O(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private boolean P() {
        this.G = -1;
        p();
        this.O.onRelease();
        this.P.onRelease();
        return this.O.isFinished() || this.P.isFinished();
    }

    private void Q(int i10, boolean z10, int i11, boolean z11) {
        f x10 = x(i10);
        int clientWidth = x10 != null ? (int) (getClientWidth() * Math.max(this.f4574q, Math.min(x10.f4594e, this.f4575r))) : 0;
        if (z10) {
            U(clientWidth, 0, i11);
            if (z11) {
                l(i10);
                return;
            }
            return;
        }
        if (z11) {
            l(i10);
        }
        h(false);
        scrollTo(clientWidth, 0);
        G(clientWidth);
    }

    private void V() {
        if (this.f4566l0 != 0) {
            ArrayList<View> arrayList = this.f4568m0;
            if (arrayList == null) {
                this.f4568m0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f4568m0.add(getChildAt(i10));
            }
            Collections.sort(this.f4568m0, f4551s0);
        }
    }

    private void f(f fVar, int i10, f fVar2) {
        int i11;
        int i12;
        f fVar3;
        f fVar4;
        int d10 = this.f4556e.d();
        int clientWidth = getClientWidth();
        float f10 = clientWidth > 0 ? this.f4567m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i13 = fVar2.f4591b;
            int i14 = fVar.f4591b;
            if (i13 < i14) {
                int i15 = 0;
                float f11 = fVar2.f4594e + fVar2.f4593d + f10;
                while (true) {
                    i13++;
                    if (i13 > fVar.f4591b || i15 >= this.f4553b.size()) {
                        break;
                    }
                    f fVar5 = this.f4553b.get(i15);
                    while (true) {
                        fVar4 = fVar5;
                        if (i13 <= fVar4.f4591b || i15 >= this.f4553b.size() - 1) {
                            break;
                        }
                        i15++;
                        fVar5 = this.f4553b.get(i15);
                    }
                    while (i13 < fVar4.f4591b) {
                        f11 += this.f4556e.g(i13) + f10;
                        i13++;
                    }
                    fVar4.f4594e = f11;
                    f11 += fVar4.f4593d + f10;
                }
            } else if (i13 > i14) {
                int size = this.f4553b.size() - 1;
                float f12 = fVar2.f4594e;
                while (true) {
                    i13--;
                    if (i13 < fVar.f4591b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f4553b.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i13 >= fVar3.f4591b || size <= 0) {
                            break;
                        }
                        size--;
                        fVar6 = this.f4553b.get(size);
                    }
                    while (i13 > fVar3.f4591b) {
                        f12 -= this.f4556e.g(i13) + f10;
                        i13--;
                    }
                    f12 -= fVar3.f4593d + f10;
                    fVar3.f4594e = f12;
                }
            }
        }
        int size2 = this.f4553b.size();
        float f13 = fVar.f4594e;
        int i16 = fVar.f4591b;
        int i17 = i16 - 1;
        this.f4574q = i16 == 0 ? f13 : -3.4028235E38f;
        int i18 = d10 - 1;
        this.f4575r = i16 == i18 ? (fVar.f4593d + f13) - 1.0f : Float.MAX_VALUE;
        int i19 = i10 - 1;
        while (i19 >= 0) {
            f fVar7 = this.f4553b.get(i19);
            while (true) {
                i12 = fVar7.f4591b;
                if (i17 <= i12) {
                    break;
                }
                i17--;
                f13 -= this.f4556e.g(i17) + f10;
            }
            f13 -= fVar7.f4593d + f10;
            fVar7.f4594e = f13;
            if (i12 == 0) {
                this.f4574q = f13;
            }
            i19--;
            i17--;
        }
        float f14 = fVar.f4594e + fVar.f4593d + f10;
        int i20 = fVar.f4591b + 1;
        int i21 = i10 + 1;
        while (i21 < size2) {
            f fVar8 = this.f4553b.get(i21);
            while (true) {
                i11 = fVar8.f4591b;
                if (i20 >= i11) {
                    break;
                }
                i20++;
                f14 += this.f4556e.g(i20) + f10;
            }
            if (i11 == i18) {
                this.f4575r = (fVar8.f4593d + f14) - 1.0f;
            }
            fVar8.f4594e = f14;
            f14 += fVar8.f4593d + f10;
            i21++;
            i20++;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h(boolean z10) {
        boolean z11 = this.f4572o0 == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            if (!this.f4561j.isFinished()) {
                this.f4561j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4561j.getCurrX();
                int currY = this.f4561j.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        G(currX);
                    }
                }
            }
        }
        this.f4579v = false;
        for (int i10 = 0; i10 < this.f4553b.size(); i10++) {
            f fVar = this.f4553b.get(i10);
            if (fVar.f4592c) {
                fVar.f4592c = false;
                z11 = true;
            }
        }
        if (!z11) {
            return;
        }
        if (z10) {
            d0.l0(this, this.f4570n0);
        } else {
            this.f4570n0.run();
        }
    }

    private int j(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.K || Math.abs(i11) <= this.I) {
            i10 += (int) (f10 + (i10 >= this.f4557f ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.f4553b.size() <= 0) {
            return i10;
        }
        ArrayList<f> arrayList = this.f4553b;
        return Math.max(this.f4553b.get(0).f4591b, Math.min(i10, arrayList.get(arrayList.size() - 1).f4591b));
    }

    private void k(int i10, float f10, int i11) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.c(i10, f10, i11);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                j jVar2 = this.T.get(i12);
                if (jVar2 != null) {
                    jVar2.c(i10, f10, i11);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.c(i10, f10, i11);
        }
    }

    private void l(int i10) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.v(i10);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.T.get(i11);
                if (jVar2 != null) {
                    jVar2.v(i10);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.v(i10);
        }
    }

    private void m(int i10) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.u(i10);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                j jVar2 = this.T.get(i11);
                if (jVar2 != null) {
                    jVar2.u(i10);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.u(i10);
        }
    }

    private void o(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.f4564k0 : 0, null);
        }
    }

    private void p() {
        this.f4581x = false;
        this.f4582y = false;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.H = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.f4578u != z10) {
            this.f4578u = z10;
        }
    }

    private Rect t(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private f w() {
        int i10;
        int clientWidth = getClientWidth();
        float f10 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f11 = clientWidth > 0 ? this.f4567m / clientWidth : 0.0f;
        f fVar = null;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        float f12 = 0.0f;
        while (i12 < this.f4553b.size()) {
            f fVar2 = this.f4553b.get(i12);
            if (!z10 && fVar2.f4591b != (i10 = i11 + 1)) {
                fVar2 = this.f4554c;
                fVar2.f4594e = f10 + f12 + f11;
                fVar2.f4591b = i10;
                fVar2.f4593d = this.f4556e.g(i10);
                i12--;
            }
            f10 = fVar2.f4594e;
            float f13 = fVar2.f4593d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return fVar;
            }
            if (scrollX < f13 || i12 == this.f4553b.size() - 1) {
                return fVar2;
            }
            i11 = fVar2.f4591b;
            f12 = fVar2.f4593d;
            i12++;
            z10 = false;
            fVar = fVar2;
        }
        return fVar;
    }

    private static boolean z(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    public boolean A() {
        return this.M;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void C(int i10, float f10, int i11) {
        int i12;
        int left;
        int i13;
        if (this.S > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f4595a) {
                    int i15 = gVar.f4596b & 7;
                    if (i15 != 1) {
                        if (i15 == 3) {
                            i12 = childAt.getWidth() + paddingLeft;
                        } else if (i15 != 5) {
                            i12 = paddingLeft;
                        } else {
                            i13 = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i12;
                    } else {
                        i13 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    paddingLeft = i13;
                    i12 = paddingLeft;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i12;
                }
            }
        }
        k(i10, f10, i11);
        if (this.f4562j0 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt2 = getChildAt(i16);
                if (!((g) childAt2.getLayoutParams()).f4595a) {
                    this.f4562j0.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.R = true;
    }

    boolean E() {
        int i10 = this.f4557f;
        if (i10 <= 0) {
            return false;
        }
        R(i10 - 1, true);
        return true;
    }

    boolean F() {
        androidx.viewpager.widget.a aVar = this.f4556e;
        if (aVar == null || this.f4557f >= aVar.d() - 1) {
            return false;
        }
        R(this.f4557f + 1, true);
        return true;
    }

    void I() {
        J(this.f4557f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void J(int i10) {
        f fVar;
        String str;
        f fVar2;
        f v10;
        f fVar3;
        int i11 = this.f4557f;
        if (i11 != i10) {
            fVar = x(i11);
            this.f4557f = i10;
        } else {
            fVar = null;
        }
        if (this.f4556e == null) {
            V();
        } else if (this.f4579v) {
            V();
        } else if (getWindowToken() != null) {
            this.f4556e.r(this);
            int i12 = this.f4580w;
            int max = Math.max(0, this.f4557f - i12);
            int d10 = this.f4556e.d();
            int min = Math.min(d10 - 1, this.f4557f + i12);
            if (d10 == this.f4552a) {
                int i13 = 0;
                while (true) {
                    if (i13 >= this.f4553b.size()) {
                        break;
                    }
                    fVar2 = this.f4553b.get(i13);
                    int i14 = fVar2.f4591b;
                    int i15 = this.f4557f;
                    if (i14 < i15) {
                        i13++;
                    }
                }
                if (fVar2 == null && d10 > 0) {
                    fVar2 = a(this.f4557f, i13);
                }
                if (fVar2 != null) {
                    int i16 = i13 - 1;
                    f fVar4 = i16 >= 0 ? this.f4553b.get(i16) : null;
                    int clientWidth = getClientWidth();
                    float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - fVar2.f4593d) + (getPaddingLeft() / clientWidth);
                    float f10 = 0.0f;
                    for (int i17 = this.f4557f - 1; i17 >= 0; i17--) {
                        if (f10 < paddingLeft || i17 >= max) {
                            if (fVar4 == null || i17 != fVar4.f4591b) {
                                f10 += a(i17, i16 + 1).f4593d;
                                i13++;
                                if (i16 >= 0) {
                                    fVar3 = this.f4553b.get(i16);
                                    fVar4 = fVar3;
                                }
                                fVar3 = null;
                                fVar4 = fVar3;
                            } else {
                                f10 += fVar4.f4593d;
                                i16--;
                                if (i16 >= 0) {
                                    fVar3 = this.f4553b.get(i16);
                                    fVar4 = fVar3;
                                }
                                fVar3 = null;
                                fVar4 = fVar3;
                            }
                        } else if (fVar4 == null) {
                            break;
                        } else if (i17 == fVar4.f4591b && !fVar4.f4592c) {
                            this.f4553b.remove(i16);
                            this.f4556e.a(this, i17, fVar4.f4590a);
                            i16--;
                            i13--;
                            if (i16 >= 0) {
                                fVar3 = this.f4553b.get(i16);
                                fVar4 = fVar3;
                            }
                            fVar3 = null;
                            fVar4 = fVar3;
                        }
                    }
                    float f11 = fVar2.f4593d;
                    int i18 = i13 + 1;
                    if (f11 < 2.0f) {
                        f fVar5 = i18 < this.f4553b.size() ? this.f4553b.get(i18) : null;
                        float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                        int i19 = this.f4557f;
                        while (true) {
                            i19++;
                            if (i19 >= d10) {
                                break;
                            } else if (f11 < paddingRight || i19 <= min) {
                                if (fVar5 == null || i19 != fVar5.f4591b) {
                                    f a10 = a(i19, i18);
                                    i18++;
                                    f11 += a10.f4593d;
                                    fVar5 = i18 < this.f4553b.size() ? this.f4553b.get(i18) : null;
                                } else {
                                    f11 += fVar5.f4593d;
                                    i18++;
                                    if (i18 < this.f4553b.size()) {
                                        fVar5 = this.f4553b.get(i18);
                                    }
                                }
                            } else if (fVar5 == null) {
                                break;
                            } else if (i19 == fVar5.f4591b && !fVar5.f4592c) {
                                this.f4553b.remove(i18);
                                this.f4556e.a(this, i19, fVar5.f4590a);
                                if (i18 < this.f4553b.size()) {
                                    fVar5 = this.f4553b.get(i18);
                                }
                            }
                        }
                    }
                    f(fVar2, i13, fVar);
                    this.f4556e.o(this, this.f4557f, fVar2.f4590a);
                }
                this.f4556e.c(this);
                int childCount = getChildCount();
                for (int i20 = 0; i20 < childCount; i20++) {
                    View childAt = getChildAt(i20);
                    g gVar = (g) childAt.getLayoutParams();
                    gVar.f4600f = i20;
                    if (!gVar.f4595a && gVar.f4597c == 0.0f && (v10 = v(childAt)) != null) {
                        gVar.f4597c = v10.f4593d;
                        gVar.f4599e = v10.f4591b;
                    }
                }
                V();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    f u10 = findFocus != null ? u(findFocus) : null;
                    if (u10 == null || u10.f4591b != this.f4557f) {
                        for (int i21 = 0; i21 < getChildCount(); i21++) {
                            View childAt2 = getChildAt(i21);
                            f v11 = v(childAt2);
                            if (v11 != null && v11.f4591b == this.f4557f && childAt2.requestFocus(2)) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                str = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                str = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f4552a + ", found: " + d10 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.f4556e.getClass());
        }
    }

    public void M(i iVar) {
        List<i> list = this.W;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void N(j jVar) {
        List<j> list = this.T;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void R(int i10, boolean z10) {
        this.f4579v = false;
        S(i10, z10, false);
    }

    void S(int i10, boolean z10, boolean z11) {
        T(i10, z10, z11, 0);
    }

    void T(int i10, boolean z10, boolean z11, int i11) {
        androidx.viewpager.widget.a aVar = this.f4556e;
        boolean z12 = false;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z11 || this.f4557f != i10 || this.f4553b.size() == 0) {
            if (i10 < 0) {
                i10 = 0;
            } else if (i10 >= this.f4556e.d()) {
                i10 = this.f4556e.d() - 1;
            }
            int i12 = this.f4580w;
            int i13 = this.f4557f;
            if (i10 > i13 + i12 || i10 < i13 - i12) {
                for (int i14 = 0; i14 < this.f4553b.size(); i14++) {
                    this.f4553b.get(i14).f4592c = true;
                }
            }
            if (this.f4557f != i10) {
                z12 = true;
            }
            if (this.Q) {
                this.f4557f = i10;
                if (z12) {
                    l(i10);
                }
                requestLayout();
                return;
            }
            J(i10);
            Q(i10, z10, i11, z12);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    void U(int i10, int i11, int i12) {
        int i13;
        int i14;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f4561j;
        if (scroller != null && !scroller.isFinished()) {
            i13 = this.f4563k ? this.f4561j.getCurrX() : this.f4561j.getStartX();
            this.f4561j.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i13 = getScrollX();
        }
        int i15 = i13;
        int scrollY = getScrollY();
        int i16 = i10 - i15;
        int i17 = i11 - scrollY;
        if (i16 == 0 && i17 == 0) {
            h(false);
            I();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i18 = clientWidth / 2;
        float f10 = clientWidth;
        float f11 = i18;
        float n10 = f11 + (n(Math.min(1.0f, (Math.abs(i16) * 1.0f) / f10)) * f11);
        int abs = Math.abs(i12);
        if (abs > 0) {
            i14 = Math.round(Math.abs(n10 / abs) * 1000.0f) * 4;
        } else {
            i14 = (int) (((Math.abs(i16) / ((f10 * this.f4556e.g(this.f4557f)) + this.f4567m)) + 1.0f) * 100.0f);
        }
        int min = Math.min(i14, 600);
        this.f4563k = false;
        this.f4561j.startScroll(i15, scrollY, i16, i17, min);
        d0.k0(this);
    }

    f a(int i10, int i11) {
        f fVar = new f();
        fVar.f4591b = i10;
        fVar.f4590a = this.f4556e.h(this, i10);
        fVar.f4593d = this.f4556e.g(i10);
        if (i11 < 0 || i11 >= this.f4553b.size()) {
            this.f4553b.add(fVar);
        } else {
            this.f4553b.add(i11, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        f v10;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (v10 = v(childAt)) != null && v10.f4591b == this.f4557f) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i11 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        f v10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (v10 = v(childAt)) != null && v10.f4591b == this.f4557f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean z10 = gVar.f4595a | z(view);
        gVar.f4595a = z10;
        if (!this.f4577t) {
            super.addView(view, i10, layoutParams);
        } else if (!z10) {
            gVar.f4598d = true;
            addViewInLayout(view, i10, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void b(i iVar) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.add(iVar);
    }

    public void c(j jVar) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(jVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f4556e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientWidth) * this.f4574q)) : i10 > 0 && scrollX < ((int) (((float) clientWidth) * this.f4575r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f4563k = true;
        if (this.f4561j.isFinished() || !this.f4561j.computeScrollOffset()) {
            h(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4561j.getCurrX();
        int currY = this.f4561j.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!G(currX)) {
                this.f4561j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        d0.k0(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(int i10) {
        View findNextFocus;
        boolean requestFocus;
        boolean z10;
        View findFocus = findFocus();
        boolean z11 = false;
        findFocus = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z10 = false;
                        break;
                    } else if (parent == this) {
                        z10 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb2.append(" => ");
                        sb2.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb2.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i10 == 17) {
                    int i11 = t(this.f4555d, findNextFocus).left;
                    int i12 = t(this.f4555d, findFocus).left;
                    if (findFocus == null || i11 < i12) {
                        requestFocus = findNextFocus.requestFocus();
                    } else {
                        requestFocus = E();
                    }
                } else if (i10 == 66) {
                    int i13 = t(this.f4555d, findNextFocus).left;
                    int i14 = t(this.f4555d, findFocus).left;
                    if (findFocus == null || i13 > i14) {
                        requestFocus = findNextFocus.requestFocus();
                    } else {
                        requestFocus = F();
                    }
                }
                z11 = requestFocus;
            } else if (i10 != 17 || i10 == 1) {
                z11 = E();
            } else if (i10 == 66 || i10 == 2) {
                z11 = F();
            }
            if (z11) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
            }
            return z11;
        }
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        if (findNextFocus == null) {
        }
        if (i10 != 17) {
        }
        z11 = E();
        if (z11) {
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || r(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f v10;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (v10 = v(childAt)) != null && v10.f4591b == this.f4557f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z10 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f4556e) != null && aVar.d() > 1)) {
            if (!this.O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f4574q * width);
                this.O.setSize(height, width);
                z10 = false | this.O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f4575r + 1.0f)) * width2);
                this.P.setSize(height2, width2);
                z10 |= this.P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O.finish();
            this.P.finish();
        }
        if (z10) {
            d0.k0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4569n;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public boolean e() {
        if (this.f4581x) {
            return false;
        }
        this.M = true;
        setScrollState(1);
        this.C = 0.0f;
        this.E = 0.0f;
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker == null) {
            this.H = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.H.addMovement(obtain);
        obtain.recycle();
        this.N = uptimeMillis;
        return true;
    }

    protected boolean g(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && g(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.f4556e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        if (this.f4566l0 == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((g) this.f4568m0.get(i11).getLayoutParams()).f4600f;
    }

    public int getCurrentItem() {
        return this.f4557f;
    }

    public int getOffscreenPageLimit() {
        return this.f4580w;
    }

    public int getPageMargin() {
        return this.f4567m;
    }

    void i() {
        int d10 = this.f4556e.d();
        this.f4552a = d10;
        boolean z10 = this.f4553b.size() < (this.f4580w * 2) + 1 && this.f4553b.size() < d10;
        int i10 = this.f4557f;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.f4553b.size()) {
            f fVar = this.f4553b.get(i11);
            int e10 = this.f4556e.e(fVar.f4590a);
            if (e10 != -1) {
                if (e10 == -2) {
                    this.f4553b.remove(i11);
                    i11--;
                    if (!z11) {
                        this.f4556e.r(this);
                        z11 = true;
                    }
                    this.f4556e.a(this, fVar.f4591b, fVar.f4590a);
                    int i12 = this.f4557f;
                    if (i12 == fVar.f4591b) {
                        i10 = Math.max(0, Math.min(i12, d10 - 1));
                    }
                } else {
                    int i13 = fVar.f4591b;
                    if (i13 != e10) {
                        if (i13 == this.f4557f) {
                            i10 = e10;
                        }
                        fVar.f4591b = e10;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.f4556e.c(this);
        }
        Collections.sort(this.f4553b, f4549q0);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                g gVar = (g) getChildAt(i14).getLayoutParams();
                if (!gVar.f4595a) {
                    gVar.f4597c = 0.0f;
                }
            }
            S(i10, false, true);
            requestLayout();
        }
    }

    float n(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f4570n0);
        Scroller scroller = this.f4561j;
        if (scroller != null && !scroller.isFinished()) {
            this.f4561j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f4567m > 0 && this.f4569n != null && this.f4553b.size() > 0 && this.f4556e != null) {
            int scrollX = getScrollX();
            float width2 = getWidth();
            float f12 = this.f4567m / width2;
            int i11 = 0;
            f fVar = this.f4553b.get(0);
            float f13 = fVar.f4594e;
            int size = this.f4553b.size();
            int i12 = fVar.f4591b;
            int i13 = this.f4553b.get(size - 1).f4591b;
            while (i12 < i13) {
                while (true) {
                    i10 = fVar.f4591b;
                    if (i12 <= i10 || i11 >= size) {
                        break;
                    }
                    i11++;
                    fVar = this.f4553b.get(i11);
                }
                if (i12 == i10) {
                    float f14 = fVar.f4594e;
                    float f15 = fVar.f4593d;
                    f10 = (f14 + f15) * width2;
                    f13 = f14 + f15 + f12;
                } else {
                    float g10 = this.f4556e.g(i12);
                    f10 = (f13 + g10) * width2;
                    f13 += g10 + f12;
                }
                if (this.f4567m + f10 > scrollX) {
                    f11 = f12;
                    this.f4569n.setBounds(Math.round(f10), this.f4571o, Math.round(this.f4567m + f10), this.f4573p);
                    this.f4569n.draw(canvas);
                } else {
                    f11 = f12;
                }
                if (f10 <= scrollX + width) {
                    i12++;
                    f12 = f11;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            P();
            return false;
        }
        if (action != 0) {
            if (this.f4581x) {
                return true;
            }
            if (this.f4582y) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.E = x10;
            this.C = x10;
            float y10 = motionEvent.getY();
            this.F = y10;
            this.D = y10;
            this.G = motionEvent.getPointerId(0);
            this.f4582y = false;
            this.f4563k = true;
            this.f4561j.computeScrollOffset();
            if (this.f4572o0 != 2 || Math.abs(this.f4561j.getFinalX() - this.f4561j.getCurrX()) <= this.L) {
                h(false);
                this.f4581x = false;
            } else {
                this.f4561j.abortAnimation();
                this.f4579v = false;
                I();
                this.f4581x = true;
                O(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.G;
            if (i10 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i10);
                float x11 = motionEvent.getX(findPointerIndex);
                float f10 = x11 - this.C;
                float abs = Math.abs(f10);
                float y11 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y11 - this.F);
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                if (i11 == 0 || B(this.C, f10) || !g(this, false, (int) f10, (int) x11, (int) y11)) {
                    int i12 = this.B;
                    if (abs > i12 && abs * 0.5f > abs2) {
                        this.f4581x = true;
                        O(true);
                        setScrollState(1);
                        float f11 = this.E;
                        float f12 = this.B;
                        this.C = i11 > 0 ? f11 + f12 : f11 - f12;
                        this.D = y11;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > i12) {
                        this.f4582y = true;
                    }
                    if (this.f4581x && H(x11)) {
                        d0.k0(this);
                    }
                } else {
                    this.C = x11;
                    this.D = y11;
                    this.f4582y = true;
                    return false;
                }
            }
        } else if (action == 6) {
            D(motionEvent);
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        return this.f4581x;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        f v10;
        int i14;
        int i15;
        int i16;
        int i17;
        int childCount = getChildCount();
        int i18 = i12 - i10;
        int i19 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i20 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.f4595a) {
                    int i22 = gVar.f4596b;
                    int i23 = i22 & 7;
                    int i24 = i22 & 112;
                    if (i23 != 1) {
                        if (i23 == 3) {
                            i14 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i23 != 5) {
                            i14 = paddingLeft;
                        } else {
                            i17 = (i18 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i24 == 16) {
                            if (i24 == 48) {
                                i15 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i24 != 80) {
                                i15 = paddingTop;
                            } else {
                                i16 = (i19 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i25 = paddingLeft + scrollX;
                            childAt.layout(i25, paddingTop, childAt.getMeasuredWidth() + i25, paddingTop + childAt.getMeasuredHeight());
                            i20++;
                            paddingTop = i15;
                            paddingLeft = i14;
                        } else {
                            i16 = Math.max((i19 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        paddingTop = i16;
                        i15 = paddingTop;
                        int i252 = paddingLeft + scrollX;
                        childAt.layout(i252, paddingTop, childAt.getMeasuredWidth() + i252, paddingTop + childAt.getMeasuredHeight());
                        i20++;
                        paddingTop = i15;
                        paddingLeft = i14;
                    } else {
                        i17 = Math.max((i18 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    paddingLeft = i17;
                    i14 = paddingLeft;
                    if (i24 == 16) {
                    }
                    paddingTop = i16;
                    i15 = paddingTop;
                    int i2522 = paddingLeft + scrollX;
                    childAt.layout(i2522, paddingTop, childAt.getMeasuredWidth() + i2522, paddingTop + childAt.getMeasuredHeight());
                    i20++;
                    paddingTop = i15;
                    paddingLeft = i14;
                }
            }
        }
        int i26 = (i18 - paddingLeft) - paddingRight;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt2 = getChildAt(i27);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.f4595a && (v10 = v(childAt2)) != null) {
                    float f10 = i26;
                    int i28 = ((int) (v10.f4594e * f10)) + paddingLeft;
                    if (gVar2.f4598d) {
                        gVar2.f4598d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f10 * gVar2.f4597c), 1073741824), View.MeasureSpec.makeMeasureSpec((i19 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i28, paddingTop, childAt2.getMeasuredWidth() + i28, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f4571o = paddingTop;
        this.f4573p = i19 - paddingBottom;
        this.S = i20;
        if (this.Q) {
            z11 = false;
            Q(this.f4557f, false, 0, false);
        } else {
            z11 = false;
        }
        this.Q = z11;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        g gVar;
        g gVar2;
        int i12;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i10), ViewGroup.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.A = Math.min(measuredWidth / 10, this.f4583z);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            boolean z10 = true;
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (!(childAt.getVisibility() == 8 || (gVar2 = (g) childAt.getLayoutParams()) == null || !gVar2.f4595a)) {
                int i15 = gVar2.f4596b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z11 = i17 == 48 || i17 == 80;
                if (!(i16 == 3 || i16 == 5)) {
                    z10 = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z11) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else {
                    i12 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i19 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f4576s = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f4577t = true;
        I();
        this.f4577t = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.f4595a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.f4597c), 1073741824), this.f4576s);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        f v10;
        int childCount = getChildCount();
        int i13 = -1;
        if ((i10 & 2) != 0) {
            i13 = childCount;
            i12 = 0;
            i11 = 1;
        } else {
            i12 = childCount - 1;
            i11 = -1;
        }
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (v10 = v(childAt)) != null && v10.f4591b == this.f4557f && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i12 += i11;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        androidx.viewpager.widget.a aVar = this.f4556e;
        if (aVar != null) {
            aVar.l(savedState.f4585d, savedState.f4586e);
            S(savedState.f4584c, false, true);
            return;
        }
        this.f4558g = savedState.f4584c;
        this.f4559h = savedState.f4585d;
        this.f4560i = savedState.f4586e;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4584c = this.f4557f;
        androidx.viewpager.widget.a aVar = this.f4556e;
        if (aVar != null) {
            savedState.f4585d = aVar.m();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.f4567m;
            K(i10, i12, i14, i14);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        if (this.M) {
            return true;
        }
        boolean z10 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f4556e) == null || aVar.d() == 0) {
            return false;
        }
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f4561j.abortAnimation();
            this.f4579v = false;
            I();
            float x10 = motionEvent.getX();
            this.E = x10;
            this.C = x10;
            float y10 = motionEvent.getY();
            this.F = y10;
            this.D = y10;
            this.G = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f4581x) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.G);
                    if (findPointerIndex == -1) {
                        z10 = P();
                    } else {
                        float x11 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x11 - this.C);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y11 - this.D);
                        if (abs > this.B && abs > abs2) {
                            this.f4581x = true;
                            O(true);
                            float f10 = this.E;
                            this.C = x11 - f10 > 0.0f ? f10 + this.B : f10 - this.B;
                            this.D = y11;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f4581x) {
                    z10 = false | H(motionEvent.getX(motionEvent.findPointerIndex(this.G)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.C = motionEvent.getX(actionIndex);
                    this.G = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    D(motionEvent);
                    this.C = motionEvent.getX(motionEvent.findPointerIndex(this.G));
                }
            } else if (this.f4581x) {
                Q(this.f4557f, true, 0, false);
                z10 = P();
            }
        } else if (this.f4581x) {
            VelocityTracker velocityTracker = this.H;
            velocityTracker.computeCurrentVelocity(1000, this.J);
            int xVelocity = (int) velocityTracker.getXVelocity(this.G);
            this.f4579v = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f w10 = w();
            float f11 = clientWidth;
            T(j(w10.f4591b, ((scrollX / f11) - w10.f4594e) / (w10.f4593d + (this.f4567m / f11)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.G)) - this.E)), true, true, xVelocity);
            z10 = P();
        }
        if (z10) {
            d0.k0(this);
        }
        return true;
    }

    public void q() {
        if (this.M) {
            if (this.f4556e != null) {
                VelocityTracker velocityTracker = this.H;
                velocityTracker.computeCurrentVelocity(1000, this.J);
                int xVelocity = (int) velocityTracker.getXVelocity(this.G);
                this.f4579v = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                f w10 = w();
                T(j(w10.f4591b, ((scrollX / clientWidth) - w10.f4594e) / w10.f4593d, xVelocity, (int) (this.C - this.E)), true, true, xVelocity);
            }
            p();
            this.M = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean r(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return F();
                } else {
                    return d(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return E();
            } else {
                return d(17);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f4577t) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void s(float f10) {
        ArrayList<f> arrayList;
        if (!this.M) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.f4556e != null) {
            this.C += f10;
            float scrollX = getScrollX() - f10;
            float clientWidth = getClientWidth();
            float f11 = this.f4574q * clientWidth;
            float f12 = this.f4575r * clientWidth;
            f fVar = this.f4553b.get(0);
            f fVar2 = this.f4553b.get(arrayList.size() - 1);
            if (fVar.f4591b != 0) {
                f11 = fVar.f4594e * clientWidth;
            }
            if (fVar2.f4591b != this.f4556e.d() - 1) {
                f12 = fVar2.f4594e * clientWidth;
            }
            if (scrollX < f11) {
                scrollX = f11;
            } else if (scrollX > f12) {
                scrollX = f12;
            }
            int i10 = (int) scrollX;
            this.C += scrollX - i10;
            scrollTo(i10, getScrollY());
            G(i10);
            MotionEvent obtain = MotionEvent.obtain(this.N, SystemClock.uptimeMillis(), 2, this.C, 0.0f, 0);
            this.H.addMovement(obtain);
            obtain.recycle();
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.f4556e;
        if (aVar2 != null) {
            aVar2.p(null);
            this.f4556e.r(this);
            for (int i10 = 0; i10 < this.f4553b.size(); i10++) {
                f fVar = this.f4553b.get(i10);
                this.f4556e.a(this, fVar.f4591b, fVar.f4590a);
            }
            this.f4556e.c(this);
            this.f4553b.clear();
            L();
            this.f4557f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.f4556e;
        this.f4556e = aVar;
        this.f4552a = 0;
        if (aVar != null) {
            if (this.f4565l == null) {
                this.f4565l = new l();
            }
            this.f4556e.p(this.f4565l);
            this.f4579v = false;
            boolean z10 = this.Q;
            this.Q = true;
            this.f4552a = this.f4556e.d();
            if (this.f4558g >= 0) {
                this.f4556e.l(this.f4559h, this.f4560i);
                S(this.f4558g, false, true);
                this.f4558g = -1;
                this.f4559h = null;
                this.f4560i = null;
            } else if (!z10) {
                I();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.W;
        if (!(list == null || list.isEmpty())) {
            int size = this.W.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.W.get(i11).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i10) {
        this.f4579v = false;
        S(i10, !this.Q, false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i10 + " too small; defaulting to 1");
            i10 = 1;
        }
        if (i10 != this.f4580w) {
            this.f4580w = i10;
            I();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.U = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.f4567m;
        this.f4567m = i10;
        int width = getWidth();
        K(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f4569n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i10) {
        if (this.f4572o0 != i10) {
            this.f4572o0 = i10;
            if (this.f4562j0 != null) {
                o(i10 != 0);
            }
            m(i10);
        }
    }

    f u(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return v(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    f v(View view) {
        for (int i10 = 0; i10 < this.f4553b.size(); i10++) {
            f fVar = this.f4553b.get(i10);
            if (this.f4556e.i(view, fVar.f4590a)) {
                return fVar;
            }
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4569n;
    }

    f x(int i10) {
        for (int i11 = 0; i11 < this.f4553b.size(); i11++) {
            f fVar = this.f4553b.get(i11);
            if (fVar.f4591b == i10) {
                return fVar;
            }
        }
        return null;
    }

    void y() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f4561j = new Scroller(context, f4550r0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.B = viewConfiguration.getScaledPagingTouchSlop();
        this.I = (int) (400.0f * f10);
        this.J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new EdgeEffect(context);
        this.P = new EdgeEffect(context);
        this.K = (int) (25.0f * f10);
        this.L = (int) (2.0f * f10);
        this.f4583z = (int) (f10 * 16.0f);
        d0.t0(this, new h());
        if (d0.C(this) == 0) {
            d0.E0(this, 1);
        }
        d0.G0(this, new d());
    }

    /* loaded from: classes.dex */
    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4595a;

        /* renamed from: b  reason: collision with root package name */
        public int f4596b;

        /* renamed from: c  reason: collision with root package name */
        float f4597c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f4598d;

        /* renamed from: e  reason: collision with root package name */
        int f4599e;

        /* renamed from: f  reason: collision with root package name */
        int f4600f;

        public g() {
            super(-1, -1);
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f4548p0);
            this.f4596b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(androidx.core.content.b.e(getContext(), i10));
    }
}
