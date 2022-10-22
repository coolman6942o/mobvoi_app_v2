package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.d0;
import androidx.core.view.f0;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.t;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k0.c;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.a0, androidx.core.view.p {
    private static final int[] L0 = {16843830};
    static final boolean M0;
    static final boolean N0;
    static final boolean O0;
    static final boolean P0;
    private static final boolean Q0;
    private static final boolean R0;
    private static final Class<?>[] S0;
    static final Interpolator T0;
    private int A;
    private final int[] A0;
    boolean B;
    private androidx.core.view.q B0;
    private final AccessibilityManager C;
    private final int[] C0;
    private List<p> D;
    private final int[] D0;
    boolean E;
    final int[] E0;
    boolean F;
    final List<b0> F0;
    private int G;
    private Runnable G0;
    private int H;
    private boolean H0;
    private k I;
    private int I0;
    private EdgeEffect J;
    private int J0;
    private EdgeEffect K;
    private final t.b K0;
    private EdgeEffect L;
    private EdgeEffect M;
    l N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private q W;

    /* renamed from: a  reason: collision with root package name */
    private final w f3738a;

    /* renamed from: b  reason: collision with root package name */
    final u f3739b;

    /* renamed from: c  reason: collision with root package name */
    SavedState f3740c;

    /* renamed from: d  reason: collision with root package name */
    androidx.recyclerview.widget.a f3741d;

    /* renamed from: e  reason: collision with root package name */
    androidx.recyclerview.widget.b f3742e;

    /* renamed from: f  reason: collision with root package name */
    final androidx.recyclerview.widget.t f3743f;

    /* renamed from: g  reason: collision with root package name */
    boolean f3744g;

    /* renamed from: h  reason: collision with root package name */
    final Runnable f3745h;

    /* renamed from: i  reason: collision with root package name */
    final Rect f3746i;

    /* renamed from: j  reason: collision with root package name */
    private final Rect f3747j;

    /* renamed from: j0  reason: collision with root package name */
    private final int f3748j0;

    /* renamed from: k  reason: collision with root package name */
    final RectF f3749k;

    /* renamed from: k0  reason: collision with root package name */
    private final int f3750k0;

    /* renamed from: l  reason: collision with root package name */
    Adapter f3751l;

    /* renamed from: l0  reason: collision with root package name */
    private float f3752l0;

    /* renamed from: m  reason: collision with root package name */
    LayoutManager f3753m;

    /* renamed from: m0  reason: collision with root package name */
    private float f3754m0;

    /* renamed from: n  reason: collision with root package name */
    v f3755n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f3756n0;

    /* renamed from: o  reason: collision with root package name */
    final List<v> f3757o;

    /* renamed from: o0  reason: collision with root package name */
    final a0 f3758o0;

    /* renamed from: p  reason: collision with root package name */
    final ArrayList<n> f3759p;

    /* renamed from: p0  reason: collision with root package name */
    androidx.recyclerview.widget.f f3760p0;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<r> f3761q;

    /* renamed from: q0  reason: collision with root package name */
    f.b f3762q0;

    /* renamed from: r  reason: collision with root package name */
    private r f3763r;

    /* renamed from: r0  reason: collision with root package name */
    final y f3764r0;

    /* renamed from: s  reason: collision with root package name */
    boolean f3765s;

    /* renamed from: s0  reason: collision with root package name */
    private s f3766s0;

    /* renamed from: t  reason: collision with root package name */
    boolean f3767t;

    /* renamed from: t0  reason: collision with root package name */
    private List<s> f3768t0;

    /* renamed from: u  reason: collision with root package name */
    boolean f3769u;

    /* renamed from: u0  reason: collision with root package name */
    boolean f3770u0;

    /* renamed from: v  reason: collision with root package name */
    boolean f3771v;

    /* renamed from: v0  reason: collision with root package name */
    boolean f3772v0;

    /* renamed from: w  reason: collision with root package name */
    private int f3773w;

    /* renamed from: w0  reason: collision with root package name */
    private l.b f3774w0;

    /* renamed from: x  reason: collision with root package name */
    boolean f3775x;

    /* renamed from: x0  reason: collision with root package name */
    boolean f3776x0;

    /* renamed from: y  reason: collision with root package name */
    boolean f3777y;

    /* renamed from: y0  reason: collision with root package name */
    androidx.recyclerview.widget.o f3778y0;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3779z;

    /* renamed from: z0  reason: collision with root package name */
    private j f3780z0;

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends b0> {
        private final h mObservable = new h();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh2, int i10) {
            boolean z10 = vh2.mBindingAdapter == null;
            if (z10) {
                vh2.mPosition = i10;
                if (hasStableIds()) {
                    vh2.mItemId = getItemId(i10);
                }
                vh2.setFlags(1, 519);
                g0.j.a("RV OnBindView");
            }
            vh2.mBindingAdapter = this;
            onBindViewHolder(vh2, i10, vh2.getUnmodifiedPayloads());
            if (z10) {
                vh2.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh2.itemView.getLayoutParams();
                if (layoutParams instanceof o) {
                    ((o) layoutParams).f3826c = true;
                }
                g0.j.b();
            }
        }

        boolean canRestoreState() {
            int i10 = g.f3814a[this.mStateRestorationPolicy.ordinal()];
            if (i10 != 1) {
                return i10 != 2 || getItemCount() > 0;
            }
            return false;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i10) {
            try {
                g0.j.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i10);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i10;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                g0.j.b();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends b0> adapter, b0 b0Var, int i10) {
            if (adapter == this) {
                return i10;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i10) {
            return -1L;
        }

        public int getItemViewType(int i10) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i10) {
            this.mObservable.d(i10, 1);
        }

        public final void notifyItemInserted(int i10) {
            this.mObservable.f(i10, 1);
        }

        public final void notifyItemMoved(int i10, int i11) {
            this.mObservable.c(i10, i11);
        }

        public final void notifyItemRangeChanged(int i10, int i11) {
            this.mObservable.d(i10, i11);
        }

        public final void notifyItemRangeInserted(int i10, int i11) {
            this.mObservable.f(i10, i11);
        }

        public final void notifyItemRangeRemoved(int i10, int i11) {
            this.mObservable.g(i10, i11);
        }

        public final void notifyItemRemoved(int i10) {
            this.mObservable.g(i10, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh2, int i10);

        public void onBindViewHolder(VH vh2, int i10, List<Object> list) {
            onBindViewHolder(vh2, i10);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i10);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh2) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh2) {
        }

        public void onViewDetachedFromWindow(VH vh2) {
        }

        public void onViewRecycled(VH vh2) {
        }

        public void registerAdapterDataObserver(i iVar) {
            this.mObservable.registerObserver(iVar);
        }

        public void setHasStableIds(boolean z10) {
            if (!hasObservers()) {
                this.mHasStableIds = z10;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(i iVar) {
            this.mObservable.unregisterObserver(iVar);
        }

        public final void notifyItemChanged(int i10, Object obj) {
            this.mObservable.e(i10, 1, obj);
        }

        public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
            this.mObservable.e(i10, i11, obj);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {

        /* renamed from: a  reason: collision with root package name */
        androidx.recyclerview.widget.b f3781a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f3782b;

        /* renamed from: c  reason: collision with root package name */
        private final s.b f3783c;

        /* renamed from: d  reason: collision with root package name */
        private final s.b f3784d;

        /* renamed from: e  reason: collision with root package name */
        androidx.recyclerview.widget.s f3785e;

        /* renamed from: f  reason: collision with root package name */
        androidx.recyclerview.widget.s f3786f;

        /* renamed from: g  reason: collision with root package name */
        x f3787g;

        /* renamed from: h  reason: collision with root package name */
        boolean f3788h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f3789i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f3790j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f3791k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f3792l = true;

        /* renamed from: m  reason: collision with root package name */
        int f3793m;

        /* renamed from: n  reason: collision with root package name */
        boolean f3794n;

        /* renamed from: o  reason: collision with root package name */
        private int f3795o;

        /* renamed from: p  reason: collision with root package name */
        private int f3796p;

        /* renamed from: q  reason: collision with root package name */
        private int f3797q;

        /* renamed from: r  reason: collision with root package name */
        private int f3798r;

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        /* loaded from: classes.dex */
        class a implements s.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.s.b
            public View a(int i10) {
                return LayoutManager.this.J(i10);
            }

            @Override // androidx.recyclerview.widget.s.b
            public int b(View view) {
                return LayoutManager.this.R(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return LayoutManager.this.f0();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int d() {
                return LayoutManager.this.p0() - LayoutManager.this.g0();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int e(View view) {
                return LayoutManager.this.U(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements s.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.s.b
            public View a(int i10) {
                return LayoutManager.this.J(i10);
            }

            @Override // androidx.recyclerview.widget.s.b
            public int b(View view) {
                return LayoutManager.this.V(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.s.b
            public int c() {
                return LayoutManager.this.h0();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int d() {
                return LayoutManager.this.X() - LayoutManager.this.e0();
            }

            @Override // androidx.recyclerview.widget.s.b
            public int e(View view) {
                return LayoutManager.this.P(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i10, int i11);
        }

        public LayoutManager() {
            a aVar = new a();
            this.f3783c = aVar;
            b bVar = new b();
            this.f3784d = bVar;
            this.f3785e = new androidx.recyclerview.widget.s(aVar);
            this.f3786f = new androidx.recyclerview.widget.s(bVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r5 == 1073741824) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static int L(int i10, int i11, int i12, int i13, boolean z10) {
            int max = Math.max(0, i10 - i12);
            if (z10) {
                if (i13 < 0) {
                    if (i13 == -1) {
                        if (i11 != Integer.MIN_VALUE) {
                            if (i11 != 0) {
                            }
                        }
                        i13 = max;
                    }
                    i11 = 0;
                    i13 = 0;
                }
                i11 = 1073741824;
            } else {
                if (i13 < 0) {
                    if (i13 != -1) {
                        if (i13 == -2) {
                            if (i11 == Integer.MIN_VALUE || i11 == 1073741824) {
                                i13 = max;
                                i11 = Integer.MIN_VALUE;
                            } else {
                                i13 = max;
                                i11 = 0;
                            }
                        }
                        i11 = 0;
                        i13 = 0;
                    }
                    i13 = max;
                }
                i11 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i13, i11);
        }

        private int[] M(View view, Rect rect) {
            int[] iArr = new int[2];
            int f02 = f0();
            int h02 = h0();
            int p02 = p0() - g0();
            int X = X() - e0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i10 = left - f02;
            int min = Math.min(0, i10);
            int i11 = top - h02;
            int min2 = Math.min(0, i11);
            int i12 = width - p02;
            int max = Math.max(0, i12);
            int max2 = Math.max(0, height - X);
            if (a0() != 1) {
                if (min == 0) {
                    min = Math.min(i10, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i12);
            }
            if (min2 == 0) {
                min2 = Math.min(i11, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void g(View view, int i10, boolean z10) {
            b0 j02 = RecyclerView.j0(view);
            if (z10 || j02.isRemoved()) {
                this.f3782b.f3743f.b(j02);
            } else {
                this.f3782b.f3743f.p(j02);
            }
            o oVar = (o) view.getLayoutParams();
            if (j02.wasReturnedFromScrap() || j02.isScrap()) {
                if (j02.isScrap()) {
                    j02.unScrap();
                } else {
                    j02.clearReturnedFromScrapFlag();
                }
                this.f3781a.c(view, i10, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3782b) {
                int m10 = this.f3781a.m(view);
                if (i10 == -1) {
                    i10 = this.f3781a.g();
                }
                if (m10 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3782b.indexOfChild(view) + this.f3782b.Q());
                } else if (m10 != i10) {
                    this.f3782b.f3753m.C0(m10, i10);
                }
            } else {
                this.f3781a.a(view, i10, false);
                oVar.f3826c = true;
                x xVar = this.f3787g;
                if (xVar != null && xVar.h()) {
                    this.f3787g.k(view);
                }
            }
            if (oVar.f3827d) {
                j02.itemView.invalidate();
                oVar.f3827d = false;
            }
        }

        public static Properties j0(Context context, AttributeSet attributeSet, int i10, int i11) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e1.d.f25706a, i10, i11);
            properties.orientation = obtainStyledAttributes.getInt(e1.d.f25707b, 1);
            properties.spanCount = obtainStyledAttributes.getInt(e1.d.f25717l, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(e1.d.f25716k, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(e1.d.f25718m, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        public static int o(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i11, i12) : size;
            }
            return Math.min(size, Math.max(i11, i12));
        }

        private boolean u0(RecyclerView recyclerView, int i10, int i11) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int f02 = f0();
            int h02 = h0();
            int p02 = p0() - g0();
            int X = X() - e0();
            Rect rect = this.f3782b.f3746i;
            Q(focusedChild, rect);
            return rect.left - i10 < p02 && rect.right - i10 > f02 && rect.top - i11 < X && rect.bottom - i11 > h02;
        }

        private void w1(u uVar, int i10, View view) {
            b0 j02 = RecyclerView.j0(view);
            if (!j02.shouldIgnore()) {
                if (!j02.isInvalid() || j02.isRemoved() || this.f3782b.f3751l.hasStableIds()) {
                    y(i10);
                    uVar.D(view);
                    this.f3782b.f3743f.k(j02);
                    return;
                }
                r1(i10);
                uVar.C(j02);
            }
        }

        private static boolean x0(int i10, int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (i12 > 0 && i10 != i12) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i10;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i10;
            }
            return true;
        }

        private void z(int i10, View view) {
            this.f3781a.d(i10);
        }

        void A(RecyclerView recyclerView) {
            this.f3789i = true;
            H0(recyclerView);
        }

        public void A0(View view, int i10, int i11, int i12, int i13) {
            o oVar = (o) view.getLayoutParams();
            Rect rect = oVar.f3825b;
            view.layout(i10 + rect.left + ((ViewGroup.MarginLayoutParams) oVar).leftMargin, i11 + rect.top + ((ViewGroup.MarginLayoutParams) oVar).topMargin, (i12 - rect.right) - ((ViewGroup.MarginLayoutParams) oVar).rightMargin, (i13 - rect.bottom) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
        }

        void A1(RecyclerView recyclerView) {
            B1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        void B(RecyclerView recyclerView, u uVar) {
            this.f3789i = false;
            J0(recyclerView, uVar);
        }

        public void B0(View view, int i10, int i11) {
            o oVar = (o) view.getLayoutParams();
            Rect o02 = this.f3782b.o0(view);
            int i12 = i10 + o02.left + o02.right;
            int i13 = i11 + o02.top + o02.bottom;
            int L = L(p0(), q0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin + i12, ((ViewGroup.MarginLayoutParams) oVar).width, l());
            int L2 = L(X(), Y(), h0() + e0() + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin + i13, ((ViewGroup.MarginLayoutParams) oVar).height, m());
            if (G1(view, L, L2, oVar)) {
                view.measure(L, L2);
            }
        }

        void B1(int i10, int i11) {
            this.f3797q = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            this.f3795o = mode;
            if (mode == 0 && !RecyclerView.N0) {
                this.f3797q = 0;
            }
            this.f3798r = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3796p = mode2;
            if (mode2 == 0 && !RecyclerView.N0) {
                this.f3798r = 0;
            }
        }

        public View C(View view) {
            View T;
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView == null || (T = recyclerView.T(view)) == null || this.f3781a.n(T)) {
                return null;
            }
            return T;
        }

        public void C0(int i10, int i11) {
            View J = J(i10);
            if (J != null) {
                y(i10);
                i(J, i11);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i10 + this.f3782b.toString());
        }

        public void C1(int i10, int i11) {
            this.f3782b.setMeasuredDimension(i10, i11);
        }

        public View D(int i10) {
            int K = K();
            for (int i11 = 0; i11 < K; i11++) {
                View J = J(i11);
                b0 j02 = RecyclerView.j0(J);
                if (j02 != null && j02.getLayoutPosition() == i10 && !j02.shouldIgnore() && (this.f3782b.f3764r0.e() || !j02.isRemoved())) {
                    return J;
                }
            }
            return null;
        }

        public void D0(int i10) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                recyclerView.F0(i10);
            }
        }

        public void D1(Rect rect, int i10, int i11) {
            C1(o(i10, rect.width() + f0() + g0(), d0()), o(i11, rect.height() + h0() + e0(), c0()));
        }

        public abstract o E();

        public void E0(int i10) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                recyclerView.G0(i10);
            }
        }

        void E1(int i10, int i11) {
            int K = K();
            if (K == 0) {
                this.f3782b.x(i10, i11);
                return;
            }
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MAX_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MIN_VALUE;
            for (int i16 = 0; i16 < K; i16++) {
                View J = J(i16);
                Rect rect = this.f3782b.f3746i;
                Q(J, rect);
                int i17 = rect.left;
                if (i17 < i13) {
                    i13 = i17;
                }
                int i18 = rect.right;
                if (i18 > i12) {
                    i12 = i18;
                }
                int i19 = rect.top;
                if (i19 < i14) {
                    i14 = i19;
                }
                int i20 = rect.bottom;
                if (i20 > i15) {
                    i15 = i20;
                }
            }
            this.f3782b.f3746i.set(i13, i14, i12, i15);
            D1(this.f3782b.f3746i, i10, i11);
        }

        public o F(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public void F0(Adapter adapter, Adapter adapter2) {
        }

        void F1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f3782b = null;
                this.f3781a = null;
                this.f3797q = 0;
                this.f3798r = 0;
            } else {
                this.f3782b = recyclerView;
                this.f3781a = recyclerView.f3742e;
                this.f3797q = recyclerView.getWidth();
                this.f3798r = recyclerView.getHeight();
            }
            this.f3795o = 1073741824;
            this.f3796p = 1073741824;
        }

        public o G(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof o) {
                return new o((o) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new o((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new o(layoutParams);
        }

        public boolean G0(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean G1(View view, int i10, int i11, o oVar) {
            return view.isLayoutRequested() || !this.f3791k || !x0(view.getWidth(), i10, ((ViewGroup.MarginLayoutParams) oVar).width) || !x0(view.getHeight(), i11, ((ViewGroup.MarginLayoutParams) oVar).height);
        }

        public int H() {
            return -1;
        }

        public void H0(RecyclerView recyclerView) {
        }

        boolean H1() {
            return false;
        }

        public int I(View view) {
            return ((o) view.getLayoutParams()).f3825b.bottom;
        }

        @Deprecated
        public void I0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean I1(View view, int i10, int i11, o oVar) {
            return !this.f3791k || !x0(view.getMeasuredWidth(), i10, ((ViewGroup.MarginLayoutParams) oVar).width) || !x0(view.getMeasuredHeight(), i11, ((ViewGroup.MarginLayoutParams) oVar).height);
        }

        public View J(int i10) {
            androidx.recyclerview.widget.b bVar = this.f3781a;
            if (bVar != null) {
                return bVar.f(i10);
            }
            return null;
        }

        public void J0(RecyclerView recyclerView, u uVar) {
            I0(recyclerView);
        }

        public void J1(RecyclerView recyclerView, y yVar, int i10) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int K() {
            androidx.recyclerview.widget.b bVar = this.f3781a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View K0(View view, int i10, u uVar, y yVar) {
            return null;
        }

        public void K1(x xVar) {
            x xVar2 = this.f3787g;
            if (!(xVar2 == null || xVar == xVar2 || !xVar2.h())) {
                this.f3787g.r();
            }
            this.f3787g = xVar;
            xVar.q(this.f3782b, this);
        }

        public void L0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3782b;
            M0(recyclerView.f3739b, recyclerView.f3764r0, accessibilityEvent);
        }

        void L1() {
            x xVar = this.f3787g;
            if (xVar != null) {
                xVar.r();
            }
        }

        public void M0(u uVar, y yVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z10 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f3782b.canScrollVertically(-1) && !this.f3782b.canScrollHorizontally(-1) && !this.f3782b.canScrollHorizontally(1)) {
                    z10 = false;
                }
                accessibilityEvent.setScrollable(z10);
                Adapter adapter = this.f3782b.f3751l;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public boolean M1() {
            return false;
        }

        public boolean N() {
            RecyclerView recyclerView = this.f3782b;
            return recyclerView != null && recyclerView.f3744g;
        }

        public void N0(u uVar, y yVar, k0.c cVar) {
            if (this.f3782b.canScrollVertically(-1) || this.f3782b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.t0(true);
            }
            if (this.f3782b.canScrollVertically(1) || this.f3782b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.t0(true);
            }
            cVar.c0(c.b.a(l0(uVar, yVar), O(uVar, yVar), w0(uVar, yVar), m0(uVar, yVar)));
        }

        public int O(u uVar, y yVar) {
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void O0(k0.c cVar) {
            RecyclerView recyclerView = this.f3782b;
            N0(recyclerView.f3739b, recyclerView.f3764r0, cVar);
        }

        public int P(View view) {
            return view.getBottom() + I(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void P0(View view, k0.c cVar) {
            b0 j02 = RecyclerView.j0(view);
            if (j02 != null && !j02.isRemoved() && !this.f3781a.n(j02.itemView)) {
                RecyclerView recyclerView = this.f3782b;
                Q0(recyclerView.f3739b, recyclerView.f3764r0, view, cVar);
            }
        }

        public void Q(View view, Rect rect) {
            RecyclerView.l0(view, rect);
        }

        public void Q0(u uVar, y yVar, View view, k0.c cVar) {
        }

        public int R(View view) {
            return view.getLeft() - b0(view);
        }

        public View R0(View view, int i10) {
            return null;
        }

        public int S(View view) {
            Rect rect = ((o) view.getLayoutParams()).f3825b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void S0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int T(View view) {
            Rect rect = ((o) view.getLayoutParams()).f3825b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void T0(RecyclerView recyclerView) {
        }

        public int U(View view) {
            return view.getRight() + k0(view);
        }

        public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        }

        public int V(View view) {
            return view.getTop() - n0(view);
        }

        public void V0(RecyclerView recyclerView, int i10, int i11) {
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3781a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void W0(RecyclerView recyclerView, int i10, int i11) {
        }

        public int X() {
            return this.f3798r;
        }

        public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
            W0(recyclerView, i10, i11);
        }

        public int Y() {
            return this.f3796p;
        }

        public void Y0(u uVar, y yVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Z() {
            RecyclerView recyclerView = this.f3782b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void Z0(y yVar) {
        }

        public int a0() {
            return d0.E(this.f3782b);
        }

        public void a1(u uVar, y yVar, int i10, int i11) {
            this.f3782b.x(i10, i11);
        }

        public int b0(View view) {
            return ((o) view.getLayoutParams()).f3825b.left;
        }

        @Deprecated
        public boolean b1(RecyclerView recyclerView, View view, View view2) {
            return y0() || recyclerView.z0();
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return d0.F(this.f3782b);
        }

        public boolean c1(RecyclerView recyclerView, y yVar, View view, View view2) {
            return b1(recyclerView, view, view2);
        }

        public void d(View view, int i10) {
            g(view, i10, true);
        }

        public int d0() {
            return d0.G(this.f3782b);
        }

        public void d1(Parcelable parcelable) {
        }

        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable e1() {
            return null;
        }

        public void f(View view, int i10) {
            g(view, i10, false);
        }

        public int f0() {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void f1(int i10) {
        }

        public int g0() {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void g1(x xVar) {
            if (this.f3787g == xVar) {
                this.f3787g = null;
            }
        }

        public void h(String str) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean h1(int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3782b;
            return i1(recyclerView.f3739b, recyclerView.f3764r0, i10, bundle);
        }

        public void i(View view, int i10) {
            j(view, i10, (o) view.getLayoutParams());
        }

        public int i0(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public boolean i1(u uVar, y yVar, int i10, Bundle bundle) {
            int i11;
            int i12;
            int i13;
            int i14;
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView == null) {
                return false;
            }
            if (i10 == 4096) {
                i13 = recyclerView.canScrollVertically(1) ? (X() - h0()) - e0() : 0;
                if (this.f3782b.canScrollHorizontally(1)) {
                    i14 = (p0() - f0()) - g0();
                    i11 = i13;
                    i12 = i14;
                }
                i11 = i13;
                i12 = 0;
            } else if (i10 != 8192) {
                i12 = 0;
                i11 = 0;
            } else {
                i13 = recyclerView.canScrollVertically(-1) ? -((X() - h0()) - e0()) : 0;
                if (this.f3782b.canScrollHorizontally(-1)) {
                    i14 = -((p0() - f0()) - g0());
                    i11 = i13;
                    i12 = i14;
                }
                i11 = i13;
                i12 = 0;
            }
            if (i11 == 0 && i12 == 0) {
                return false;
            }
            this.f3782b.v1(i12, i11, null, Integer.MIN_VALUE, true);
            return true;
        }

        public void j(View view, int i10, o oVar) {
            b0 j02 = RecyclerView.j0(view);
            if (j02.isRemoved()) {
                this.f3782b.f3743f.b(j02);
            } else {
                this.f3782b.f3743f.p(j02);
            }
            this.f3781a.c(view, i10, oVar, j02.isRemoved());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean j1(View view, int i10, Bundle bundle) {
            RecyclerView recyclerView = this.f3782b;
            return k1(recyclerView.f3739b, recyclerView.f3764r0, view, i10, bundle);
        }

        public void k(View view, Rect rect) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.o0(view));
            }
        }

        public int k0(View view) {
            return ((o) view.getLayoutParams()).f3825b.right;
        }

        public boolean k1(u uVar, y yVar, View view, int i10, Bundle bundle) {
            return false;
        }

        public boolean l() {
            return false;
        }

        public int l0(u uVar, y yVar) {
            return -1;
        }

        public void l1(u uVar) {
            for (int K = K() - 1; K >= 0; K--) {
                if (!RecyclerView.j0(J(K)).shouldIgnore()) {
                    o1(K, uVar);
                }
            }
        }

        public boolean m() {
            return false;
        }

        public int m0(u uVar, y yVar) {
            return 0;
        }

        void m1(u uVar) {
            int j10 = uVar.j();
            for (int i10 = j10 - 1; i10 >= 0; i10--) {
                View n10 = uVar.n(i10);
                b0 j02 = RecyclerView.j0(n10);
                if (!j02.shouldIgnore()) {
                    j02.setIsRecyclable(false);
                    if (j02.isTmpDetached()) {
                        this.f3782b.removeDetachedView(n10, false);
                    }
                    l lVar = this.f3782b.N;
                    if (lVar != null) {
                        lVar.j(j02);
                    }
                    j02.setIsRecyclable(true);
                    uVar.y(n10);
                }
            }
            uVar.e();
            if (j10 > 0) {
                this.f3782b.invalidate();
            }
        }

        public boolean n(o oVar) {
            return oVar != null;
        }

        public int n0(View view) {
            return ((o) view.getLayoutParams()).f3825b.top;
        }

        public void n1(View view, u uVar) {
            q1(view);
            uVar.B(view);
        }

        public void o0(View view, boolean z10, Rect rect) {
            Matrix matrix;
            if (z10) {
                Rect rect2 = ((o) view.getLayoutParams()).f3825b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f3782b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f3782b.f3749k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void o1(int i10, u uVar) {
            View J = J(i10);
            r1(i10);
            uVar.B(J);
        }

        public void p(int i10, int i11, y yVar, c cVar) {
        }

        public int p0() {
            return this.f3797q;
        }

        public boolean p1(Runnable runnable) {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void q(int i10, c cVar) {
        }

        public int q0() {
            return this.f3795o;
        }

        public void q1(View view) {
            this.f3781a.p(view);
        }

        public int r(y yVar) {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean r0() {
            int K = K();
            for (int i10 = 0; i10 < K; i10++) {
                ViewGroup.LayoutParams layoutParams = J(i10).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void r1(int i10) {
            if (J(i10) != null) {
                this.f3781a.q(i10);
            }
        }

        public int s(y yVar) {
            return 0;
        }

        public boolean s0() {
            return this.f3789i;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
            return t1(recyclerView, view, rect, z10, false);
        }

        public int t(y yVar) {
            return 0;
        }

        public boolean t0() {
            return this.f3790j;
        }

        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            int[] M = M(view, rect);
            int i10 = M[0];
            int i11 = M[1];
            if ((z11 && !u0(recyclerView, i10, i11)) || (i10 == 0 && i11 == 0)) {
                return false;
            }
            if (z10) {
                recyclerView.scrollBy(i10, i11);
            } else {
                recyclerView.s1(i10, i11);
            }
            return true;
        }

        public int u(y yVar) {
            return 0;
        }

        public void u1() {
            RecyclerView recyclerView = this.f3782b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int v(y yVar) {
            return 0;
        }

        public final boolean v0() {
            return this.f3792l;
        }

        public void v1() {
            this.f3788h = true;
        }

        public int w(y yVar) {
            return 0;
        }

        public boolean w0(u uVar, y yVar) {
            return false;
        }

        public void x(u uVar) {
            for (int K = K() - 1; K >= 0; K--) {
                w1(uVar, K, J(K));
            }
        }

        public int x1(int i10, u uVar, y yVar) {
            return 0;
        }

        public void y(int i10) {
            z(i10, J(i10));
        }

        public boolean y0() {
            x xVar = this.f3787g;
            return xVar != null && xVar.h();
        }

        public void y1(int i10) {
        }

        public boolean z0(View view, boolean z10, boolean z11) {
            boolean z12 = this.f3785e.b(view, 24579) && this.f3786f.b(view, 24579);
            return z10 ? z12 : !z12;
        }

        public int z1(int i10, u uVar, y yVar) {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3771v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.f3765s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.f3777y) {
                    recyclerView2.f3775x = true;
                } else {
                    recyclerView2.v();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f3803a;

        /* renamed from: b  reason: collision with root package name */
        private int f3804b;

        /* renamed from: c  reason: collision with root package name */
        OverScroller f3805c;

        /* renamed from: d  reason: collision with root package name */
        Interpolator f3806d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3807e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3808f = false;

        a0() {
            Interpolator interpolator = RecyclerView.T0;
            this.f3806d = interpolator;
            this.f3805c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i10, int i11) {
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            boolean z10 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z10 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z10) {
                abs = abs2;
            }
            return Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            d0.l0(RecyclerView.this, this);
        }

        public void b(int i10, int i11) {
            RecyclerView.this.setScrollState(2);
            this.f3804b = 0;
            this.f3803a = 0;
            Interpolator interpolator = this.f3806d;
            Interpolator interpolator2 = RecyclerView.T0;
            if (interpolator != interpolator2) {
                this.f3806d = interpolator2;
                this.f3805c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f3805c.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        void d() {
            if (this.f3807e) {
                this.f3808f = true;
            } else {
                c();
            }
        }

        public void e(int i10, int i11, int i12, Interpolator interpolator) {
            if (i12 == Integer.MIN_VALUE) {
                i12 = a(i10, i11);
            }
            int i13 = i12;
            if (interpolator == null) {
                interpolator = RecyclerView.T0;
            }
            if (this.f3806d != interpolator) {
                this.f3806d = interpolator;
                this.f3805c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f3804b = 0;
            this.f3803a = 0;
            RecyclerView.this.setScrollState(2);
            this.f3805c.startScroll(0, 0, i10, i11, i13);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3805c.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f3805c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            int i11;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3753m == null) {
                f();
                return;
            }
            this.f3808f = false;
            this.f3807e = true;
            recyclerView.v();
            OverScroller overScroller = this.f3805c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i12 = currX - this.f3803a;
                int i13 = currY - this.f3804b;
                this.f3803a = currX;
                this.f3804b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.E0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i12, i13, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.E0;
                    i12 -= iArr2[0];
                    i13 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i12, i13);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.f3751l != null) {
                    int[] iArr3 = recyclerView3.E0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.n1(i12, i13, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.E0;
                    i10 = iArr4[0];
                    i11 = iArr4[1];
                    i12 -= i10;
                    i13 -= i11;
                    x xVar = recyclerView4.f3753m.f3787g;
                    if (xVar != null && !xVar.g() && xVar.h()) {
                        int b10 = RecyclerView.this.f3764r0.b();
                        if (b10 == 0) {
                            xVar.r();
                        } else if (xVar.f() >= b10) {
                            xVar.p(b10 - 1);
                            xVar.j(i10, i11);
                        } else {
                            xVar.j(i10, i11);
                        }
                    }
                } else {
                    i11 = 0;
                    i10 = 0;
                }
                if (!RecyclerView.this.f3759p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.E0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i10, i11, i12, i13, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.E0;
                int i14 = i12 - iArr6[0];
                int i15 = i13 - iArr6[1];
                if (!(i10 == 0 && i11 == 0)) {
                    recyclerView6.J(i10, i11);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z10 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i14 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i15 != 0));
                x xVar2 = RecyclerView.this.f3753m.f3787g;
                if ((xVar2 != null && xVar2.g()) || !z10) {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.f fVar = recyclerView7.f3760p0;
                    if (fVar != null) {
                        fVar.f(recyclerView7, i10, i11);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i16 = i14 < 0 ? -currVelocity : i14 > 0 ? currVelocity : 0;
                        if (i15 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i15 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i16, currVelocity);
                    }
                    if (RecyclerView.P0) {
                        RecyclerView.this.f3762q0.b();
                    }
                }
            }
            x xVar3 = RecyclerView.this.f3753m.f3787g;
            if (xVar3 != null && xVar3.g()) {
                xVar3.j(0, 0);
            }
            this.f3807e = false;
            if (this.f3808f) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.A1(1);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.f3776x0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends b0> mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        b0 mShadowedHolder = null;
        b0 mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        u mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public b0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i10) {
            this.mFlags = i10 | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && d0.U(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i10, int i11, boolean z10) {
            addFlags(8);
            offsetPosition(i11, z10);
            this.mPosition = i10;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.e0(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends b0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int e02;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (e02 = this.mOwnerRecyclerView.e0(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, e02);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i10 = this.mPreLayoutPosition;
            return i10 == -1 ? this.mPosition : i10;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i10) {
            return (i10 & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !d0.U(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i10, boolean z10) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z10) {
                this.mPreLayoutPosition += i10;
            }
            this.mPosition += i10;
            if (this.itemView.getLayoutParams() != null) {
                ((o) this.itemView.getLayoutParams()).f3826c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i10 = this.mPendingAccessibilityState;
            if (i10 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i10;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = d0.C(this.itemView);
            }
            recyclerView.q1(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.q1(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.s(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i10, int i11) {
            this.mFlags = (i10 & i11) | (this.mFlags & (~i11));
        }

        public final void setIsRecyclable(boolean z10) {
            int i10 = this.mIsRecyclableCount;
            int i11 = z10 ? i10 - 1 : i10 + 1;
            this.mIsRecyclableCount = i11;
            if (i11 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z10 && i11 == 1) {
                this.mFlags |= 16;
            } else if (z10 && i11 == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(u uVar, boolean z10) {
            this.mScrapContainer = uVar;
            this.mInChangeScrap = z10;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & FLAG_IGNORE) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        void unScrap() {
            this.mScrapContainer.J(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* loaded from: classes.dex */
    class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    class d implements t.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.t.b
        public void a(b0 b0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3753m.n1(b0Var.itemView, recyclerView.f3739b);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void b(b0 b0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.m(b0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void c(b0 b0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f3739b.J(b0Var);
            RecyclerView.this.o(b0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.t.b
        public void d(b0 b0Var, l.c cVar, l.c cVar2) {
            b0Var.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.E) {
                if (recyclerView.N.b(b0Var, b0Var, cVar, cVar2)) {
                    RecyclerView.this.S0();
                }
            } else if (recyclerView.N.d(b0Var, cVar, cVar2)) {
                RecyclerView.this.S0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.AbstractC0041b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public View a(int i10) {
            return RecyclerView.this.getChildAt(i10);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void b(View view) {
            b0 j02 = RecyclerView.j0(view);
            if (j02 != null) {
                j02.onEnteredHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public int c() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void d() {
            int c10 = c();
            for (int i10 = 0; i10 < c10; i10++) {
                View a10 = a(i10);
                RecyclerView.this.A(a10);
                a10.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public int e(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public b0 f(View view) {
            return RecyclerView.j0(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void g(int i10) {
            b0 j02;
            View a10 = a(i10);
            if (!(a10 == null || (j02 = RecyclerView.j0(a10)) == null)) {
                if (!j02.isTmpDetached() || j02.shouldIgnore()) {
                    j02.addFlags(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + j02 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.detachViewFromParent(i10);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void h(View view) {
            b0 j02 = RecyclerView.j0(view);
            if (j02 != null) {
                j02.onLeftHiddenState(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void i(View view, int i10) {
            RecyclerView.this.addView(view, i10);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void j(int i10) {
            View childAt = RecyclerView.this.getChildAt(i10);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i10);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0041b
        public void k(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            b0 j02 = RecyclerView.j0(view);
            if (j02 != null) {
                if (j02.isTmpDetached() || j02.shouldIgnore()) {
                    j02.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + j02 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.attachViewToParent(view, i10, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.AbstractC0040a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void a(int i10, int i11) {
            RecyclerView.this.I0(i10, i11);
            RecyclerView.this.f3770u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.D1(i10, i11, obj);
            RecyclerView.this.f3772v0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void d(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public b0 e(int i10) {
            b0 c02 = RecyclerView.this.c0(i10, true);
            if (c02 != null && !RecyclerView.this.f3742e.n(c02.itemView)) {
                return c02;
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void f(int i10, int i11) {
            RecyclerView.this.J0(i10, i11, false);
            RecyclerView.this.f3770u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void g(int i10, int i11) {
            RecyclerView.this.H0(i10, i11);
            RecyclerView.this.f3770u0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0040a
        public void h(int i10, int i11) {
            RecyclerView.this.J0(i10, i11, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3770u0 = true;
            recyclerView.f3764r0.f3861d += i11;
        }

        void i(a.b bVar) {
            int i10 = bVar.f3922a;
            if (i10 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f3753m.S0(recyclerView, bVar.f3923b, bVar.f3925d);
            } else if (i10 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f3753m.V0(recyclerView2, bVar.f3923b, bVar.f3925d);
            } else if (i10 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f3753m.X0(recyclerView3, bVar.f3923b, bVar.f3925d, bVar.f3924c);
            } else if (i10 == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f3753m.U0(recyclerView4, bVar.f3923b, bVar.f3925d, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3814a;

        static {
            int[] iArr = new int[Adapter.StateRestorationPolicy.values().length];
            f3814a = iArr;
            try {
                iArr[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3814a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i10, i11, 1);
            }
        }

        public void d(int i10, int i11) {
            e(i10, i11, null);
        }

        public void e(int i10, int i11, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i10, i11, obj);
            }
        }

        public void f(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i10, i11);
            }
        }

        public void g(int i10, int i11) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).f(i10, i11);
            }
        }

        public void h() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).g();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }

        public void b(int i10, int i11) {
        }

        public void c(int i10, int i11, Object obj) {
            b(i10, i11);
        }

        public void d(int i10, int i11) {
        }

        public void e(int i10, int i11, int i12) {
        }

        public void f(int i10, int i11) {
        }

        public void g() {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i10, int i11);
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i10) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private b f3815a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f3816b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f3817c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f3818d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f3819e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f3820f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(b0 b0Var);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f3821a;

            /* renamed from: b  reason: collision with root package name */
            public int f3822b;

            public c a(b0 b0Var) {
                return b(b0Var, 0);
            }

            public c b(b0 b0Var, int i10) {
                View view = b0Var.itemView;
                this.f3821a = view.getLeft();
                this.f3822b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(b0 b0Var) {
            int i10 = b0Var.mFlags & 14;
            if (b0Var.isInvalid()) {
                return 4;
            }
            if ((i10 & 4) != 0) {
                return i10;
            }
            int oldPosition = b0Var.getOldPosition();
            int absoluteAdapterPosition = b0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i10 : i10 | 2048;
        }

        public abstract boolean a(b0 b0Var, c cVar, c cVar2);

        public abstract boolean b(b0 b0Var, b0 b0Var2, c cVar, c cVar2);

        public abstract boolean c(b0 b0Var, c cVar, c cVar2);

        public abstract boolean d(b0 b0Var, c cVar, c cVar2);

        public abstract boolean f(b0 b0Var);

        public boolean g(b0 b0Var, List<Object> list) {
            return f(b0Var);
        }

        public final void h(b0 b0Var) {
            s(b0Var);
            b bVar = this.f3815a;
            if (bVar != null) {
                bVar.a(b0Var);
            }
        }

        public final void i() {
            int size = this.f3816b.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3816b.get(i10).a();
            }
            this.f3816b.clear();
        }

        public abstract void j(b0 b0Var);

        public abstract void k();

        public long l() {
            return this.f3817c;
        }

        public long m() {
            return this.f3820f;
        }

        public long n() {
            return this.f3819e;
        }

        public long o() {
            return this.f3818d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean p10 = p();
            if (aVar != null) {
                if (!p10) {
                    aVar.a();
                } else {
                    this.f3816b.add(aVar);
                }
            }
            return p10;
        }

        public c r() {
            return new c();
        }

        public void s(b0 b0Var) {
        }

        public c t(y yVar, b0 b0Var) {
            return r().a(b0Var);
        }

        public c u(y yVar, b0 b0Var, int i10, List<Object> list) {
            return r().a(b0Var);
        }

        public abstract void v();

        void w(b bVar) {
            this.f3815a = bVar;
        }
    }

    /* loaded from: classes.dex */
    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(b0 b0Var) {
            b0Var.setIsRecyclable(true);
            if (b0Var.mShadowedHolder != null && b0Var.mShadowingHolder == null) {
                b0Var.mShadowedHolder = null;
            }
            b0Var.mShadowingHolder = null;
            if (!b0Var.shouldBeKeptAsChild() && !RecyclerView.this.b1(b0Var.itemView) && b0Var.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(b0Var.itemView, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void c(Rect rect, int i10, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void d(Rect rect, View view, RecyclerView recyclerView, y yVar) {
            c(rect, ((o) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void e(Canvas canvas, RecyclerView recyclerView) {
        }

        public void f(Canvas canvas, RecyclerView recyclerView, y yVar) {
            e(canvas, recyclerView);
        }

        @Deprecated
        public void g(Canvas canvas, RecyclerView recyclerView) {
        }

        public void h(Canvas canvas, RecyclerView recyclerView, y yVar) {
            g(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class q {
        public abstract boolean a(int i10, int i11);
    }

    /* loaded from: classes.dex */
    public interface r {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z10);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        public void a(RecyclerView recyclerView, int i10) {
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
        }
    }

    /* loaded from: classes.dex */
    public static class t {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f3828a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f3829b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<b0> f3830a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f3831b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f3832c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f3833d = 0;

            a() {
            }
        }

        private a g(int i10) {
            a aVar = this.f3828a.get(i10);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f3828a.put(i10, aVar2);
            return aVar2;
        }

        void a() {
            this.f3829b++;
        }

        public void b() {
            for (int i10 = 0; i10 < this.f3828a.size(); i10++) {
                this.f3828a.valueAt(i10).f3830a.clear();
            }
        }

        void c() {
            this.f3829b--;
        }

        void d(int i10, long j10) {
            a g10 = g(i10);
            g10.f3833d = j(g10.f3833d, j10);
        }

        void e(int i10, long j10) {
            a g10 = g(i10);
            g10.f3832c = j(g10.f3832c, j10);
        }

        public b0 f(int i10) {
            a aVar = this.f3828a.get(i10);
            if (aVar == null || aVar.f3830a.isEmpty()) {
                return null;
            }
            ArrayList<b0> arrayList = aVar.f3830a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(Adapter adapter, Adapter adapter2, boolean z10) {
            if (adapter != null) {
                c();
            }
            if (!z10 && this.f3829b == 0) {
                b();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void i(b0 b0Var) {
            int itemViewType = b0Var.getItemViewType();
            ArrayList<b0> arrayList = g(itemViewType).f3830a;
            if (this.f3828a.get(itemViewType).f3831b > arrayList.size()) {
                b0Var.resetInternal();
                arrayList.add(b0Var);
            }
        }

        long j(long j10, long j11) {
            return j10 == 0 ? j11 : ((j10 / 4) * 3) + (j11 / 4);
        }

        public void k(int i10, int i11) {
            a g10 = g(i10);
            g10.f3831b = i11;
            ArrayList<b0> arrayList = g10.f3830a;
            while (arrayList.size() > i11) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        boolean l(int i10, long j10, long j11) {
            long j12 = g(i10).f3833d;
            return j12 == 0 || j10 + j12 < j11;
        }

        boolean m(int i10, long j10, long j11) {
            long j12 = g(i10).f3832c;
            return j12 == 0 || j10 + j12 < j11;
        }
    }

    /* loaded from: classes.dex */
    public final class u {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<b0> f3834a;

        /* renamed from: d  reason: collision with root package name */
        private final List<b0> f3837d;

        /* renamed from: g  reason: collision with root package name */
        t f3840g;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b0> f3835b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<b0> f3836c = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        private int f3838e = 2;

        /* renamed from: f  reason: collision with root package name */
        int f3839f = 2;

        public u() {
            ArrayList<b0> arrayList = new ArrayList<>();
            this.f3834a = arrayList;
            this.f3837d = Collections.unmodifiableList(arrayList);
        }

        private boolean H(b0 b0Var, int i10, int i11, long j10) {
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = b0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j10 != Long.MAX_VALUE && !this.f3840g.l(itemViewType, nanoTime, j10)) {
                return false;
            }
            RecyclerView.this.f3751l.bindViewHolder(b0Var, i10);
            this.f3840g.d(b0Var.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(b0Var);
            if (!RecyclerView.this.f3764r0.e()) {
                return true;
            }
            b0Var.mPreLayoutPosition = i11;
            return true;
        }

        private void b(b0 b0Var) {
            if (RecyclerView.this.y0()) {
                View view = b0Var.itemView;
                if (d0.C(view) == 0) {
                    d0.E0(view, 1);
                }
                androidx.recyclerview.widget.o oVar = RecyclerView.this.f3778y0;
                if (oVar != null) {
                    androidx.core.view.a n10 = oVar.n();
                    if (n10 instanceof o.a) {
                        ((o.a) n10).o(view);
                    }
                    d0.t0(view, n10);
                }
            }
        }

        private void q(ViewGroup viewGroup, boolean z10) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z10) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(b0 b0Var) {
            View view = b0Var.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i10) {
            a(this.f3836c.get(i10), true);
            this.f3836c.remove(i10);
        }

        public void B(View view) {
            b0 j02 = RecyclerView.j0(view);
            if (j02.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (j02.isScrap()) {
                j02.unScrap();
            } else if (j02.wasReturnedFromScrap()) {
                j02.clearReturnedFromScrapFlag();
            }
            C(j02);
            if (RecyclerView.this.N != null && !j02.isRecyclable()) {
                RecyclerView.this.N.j(j02);
            }
        }

        void C(b0 b0Var) {
            boolean z10;
            boolean z11 = false;
            boolean z12 = true;
            if (b0Var.isScrap() || b0Var.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(b0Var.isScrap());
                sb2.append(" isAttached:");
                if (b0Var.itemView.getParent() != null) {
                    z11 = true;
                }
                sb2.append(z11);
                sb2.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb2.toString());
            } else if (b0Var.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + b0Var + RecyclerView.this.Q());
            } else if (!b0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = b0Var.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.f3751l;
                if ((adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(b0Var)) || b0Var.isRecyclable()) {
                    if (this.f3839f <= 0 || b0Var.hasAnyOfTheFlags(526)) {
                        z10 = false;
                    } else {
                        int size = this.f3836c.size();
                        if (size >= this.f3839f && size > 0) {
                            A(0);
                            size--;
                        }
                        if (RecyclerView.P0 && size > 0 && !RecyclerView.this.f3762q0.d(b0Var.mPosition)) {
                            int i10 = size - 1;
                            while (i10 >= 0) {
                                if (!RecyclerView.this.f3762q0.d(this.f3836c.get(i10).mPosition)) {
                                    break;
                                }
                                i10--;
                            }
                            size = i10 + 1;
                        }
                        this.f3836c.add(size, b0Var);
                        z10 = true;
                    }
                    if (!z10) {
                        a(b0Var, true);
                    } else {
                        z12 = false;
                    }
                    z11 = z10;
                } else {
                    z12 = false;
                }
                RecyclerView.this.f3743f.q(b0Var);
                if (!z11 && !z12 && doesTransientStatePreventRecycling) {
                    b0Var.mBindingAdapter = null;
                    b0Var.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
        }

        void D(View view) {
            b0 j02 = RecyclerView.j0(view);
            if (!j02.hasAnyOfTheFlags(12) && j02.isUpdated() && !RecyclerView.this.q(j02)) {
                if (this.f3835b == null) {
                    this.f3835b = new ArrayList<>();
                }
                j02.setScrapContainer(this, true);
                this.f3835b.add(j02);
            } else if (!j02.isInvalid() || j02.isRemoved() || RecyclerView.this.f3751l.hasStableIds()) {
                j02.setScrapContainer(this, false);
                this.f3834a.add(j02);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
            }
        }

        void E(t tVar) {
            t tVar2 = this.f3840g;
            if (tVar2 != null) {
                tVar2.c();
            }
            this.f3840g = tVar;
            if (tVar != null && RecyclerView.this.getAdapter() != null) {
                this.f3840g.a();
            }
        }

        void F(z zVar) {
        }

        public void G(int i10) {
            this.f3838e = i10;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01d3 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b0 I(int i10, boolean z10, long j10) {
            boolean z11;
            b0 b0Var;
            b0 b0Var2;
            boolean z12;
            boolean z13;
            ViewGroup.LayoutParams layoutParams;
            o oVar;
            RecyclerView X;
            if (i10 < 0 || i10 >= RecyclerView.this.f3764r0.b()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i10 + "(" + i10 + "). Item count:" + RecyclerView.this.f3764r0.b() + RecyclerView.this.Q());
            }
            boolean z14 = true;
            if (RecyclerView.this.f3764r0.e()) {
                b0Var = h(i10);
                if (b0Var != null) {
                    z11 = true;
                    if (b0Var == null && (b0Var = m(i10, z10)) != null) {
                        if (L(b0Var)) {
                            if (!z10) {
                                b0Var.addFlags(4);
                                if (b0Var.isScrap()) {
                                    RecyclerView.this.removeDetachedView(b0Var.itemView, false);
                                    b0Var.unScrap();
                                } else if (b0Var.wasReturnedFromScrap()) {
                                    b0Var.clearReturnedFromScrapFlag();
                                }
                                C(b0Var);
                            }
                            b0Var = null;
                        } else {
                            z11 = true;
                        }
                    }
                    if (b0Var == null) {
                        int m10 = RecyclerView.this.f3741d.m(i10);
                        if (m10 < 0 || m10 >= RecyclerView.this.f3751l.getItemCount()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i10 + "(offset:" + m10 + ").state:" + RecyclerView.this.f3764r0.b() + RecyclerView.this.Q());
                        }
                        int itemViewType = RecyclerView.this.f3751l.getItemViewType(m10);
                        if (RecyclerView.this.f3751l.hasStableIds() && (b0Var = l(RecyclerView.this.f3751l.getItemId(m10), itemViewType, z10)) != null) {
                            b0Var.mPosition = m10;
                            z11 = true;
                        }
                        if (b0Var == null) {
                            b0 f10 = i().f(itemViewType);
                            if (f10 != null) {
                                f10.resetInternal();
                                if (RecyclerView.M0) {
                                    r(f10);
                                }
                            }
                            b0Var = f10;
                        }
                        if (b0Var == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j10 != Long.MAX_VALUE && !this.f3840g.m(itemViewType, nanoTime, j10)) {
                                return null;
                            }
                            RecyclerView recyclerView = RecyclerView.this;
                            b0 createViewHolder = recyclerView.f3751l.createViewHolder(recyclerView, itemViewType);
                            if (RecyclerView.P0 && (X = RecyclerView.X(createViewHolder.itemView)) != null) {
                                createViewHolder.mNestedRecyclerView = new WeakReference<>(X);
                            }
                            this.f3840g.e(itemViewType, RecyclerView.this.getNanoTime() - nanoTime);
                            b0Var2 = createViewHolder;
                            z12 = z11;
                            if (z12 && !RecyclerView.this.f3764r0.e() && b0Var2.hasAnyOfTheFlags(8192)) {
                                b0Var2.setFlags(0, 8192);
                                if (RecyclerView.this.f3764r0.f3868k) {
                                    RecyclerView recyclerView2 = RecyclerView.this;
                                    RecyclerView.this.X0(b0Var2, recyclerView2.N.u(recyclerView2.f3764r0, b0Var2, l.e(b0Var2) | 4096, b0Var2.getUnmodifiedPayloads()));
                                }
                            }
                            if (!RecyclerView.this.f3764r0.e() && b0Var2.isBound()) {
                                b0Var2.mPreLayoutPosition = i10;
                            } else if (b0Var2.isBound() || b0Var2.needsUpdate() || b0Var2.isInvalid()) {
                                z13 = H(b0Var2, RecyclerView.this.f3741d.m(i10), i10, j10);
                                layoutParams = b0Var2.itemView.getLayoutParams();
                                if (layoutParams != null) {
                                    oVar = (o) RecyclerView.this.generateDefaultLayoutParams();
                                    b0Var2.itemView.setLayoutParams(oVar);
                                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                    oVar = (o) RecyclerView.this.generateLayoutParams(layoutParams);
                                    b0Var2.itemView.setLayoutParams(oVar);
                                } else {
                                    oVar = (o) layoutParams;
                                }
                                oVar.f3824a = b0Var2;
                                if (z12 || !z13) {
                                    z14 = false;
                                }
                                oVar.f3827d = z14;
                                return b0Var2;
                            }
                            z13 = false;
                            layoutParams = b0Var2.itemView.getLayoutParams();
                            if (layoutParams != null) {
                            }
                            oVar.f3824a = b0Var2;
                            if (z12) {
                            }
                            z14 = false;
                            oVar.f3827d = z14;
                            return b0Var2;
                        }
                    }
                    b0Var2 = b0Var;
                    z12 = z11;
                    if (z12) {
                        b0Var2.setFlags(0, 8192);
                        if (RecyclerView.this.f3764r0.f3868k) {
                        }
                    }
                    if (!RecyclerView.this.f3764r0.e()) {
                    }
                    if (b0Var2.isBound()) {
                    }
                    z13 = H(b0Var2, RecyclerView.this.f3741d.m(i10), i10, j10);
                    layoutParams = b0Var2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    oVar.f3824a = b0Var2;
                    if (z12) {
                    }
                    z14 = false;
                    oVar.f3827d = z14;
                    return b0Var2;
                }
            } else {
                b0Var = null;
            }
            z11 = false;
            if (b0Var == null) {
                if (L(b0Var)) {
                }
            }
            if (b0Var == null) {
            }
            b0Var2 = b0Var;
            z12 = z11;
            if (z12) {
            }
            if (!RecyclerView.this.f3764r0.e()) {
            }
            if (b0Var2.isBound()) {
            }
            z13 = H(b0Var2, RecyclerView.this.f3741d.m(i10), i10, j10);
            layoutParams = b0Var2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            oVar.f3824a = b0Var2;
            if (z12) {
            }
            z14 = false;
            oVar.f3827d = z14;
            return b0Var2;
        }

        void J(b0 b0Var) {
            if (b0Var.mInChangeScrap) {
                this.f3835b.remove(b0Var);
            } else {
                this.f3834a.remove(b0Var);
            }
            b0Var.mScrapContainer = null;
            b0Var.mInChangeScrap = false;
            b0Var.clearReturnedFromScrapFlag();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            LayoutManager layoutManager = RecyclerView.this.f3753m;
            this.f3839f = this.f3838e + (layoutManager != null ? layoutManager.f3793m : 0);
            for (int size = this.f3836c.size() - 1; size >= 0 && this.f3836c.size() > this.f3839f; size--) {
                A(size);
            }
        }

        boolean L(b0 b0Var) {
            if (b0Var.isRemoved()) {
                return RecyclerView.this.f3764r0.e();
            }
            int i10 = b0Var.mPosition;
            if (i10 < 0 || i10 >= RecyclerView.this.f3751l.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + b0Var + RecyclerView.this.Q());
            } else if (RecyclerView.this.f3764r0.e() || RecyclerView.this.f3751l.getItemViewType(b0Var.mPosition) == b0Var.getItemViewType()) {
                return !RecyclerView.this.f3751l.hasStableIds() || b0Var.getItemId() == RecyclerView.this.f3751l.getItemId(b0Var.mPosition);
            } else {
                return false;
            }
        }

        void M(int i10, int i11) {
            int i12;
            int i13 = i11 + i10;
            for (int size = this.f3836c.size() - 1; size >= 0; size--) {
                b0 b0Var = this.f3836c.get(size);
                if (b0Var != null && (i12 = b0Var.mPosition) >= i10 && i12 < i13) {
                    b0Var.addFlags(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(b0 b0Var, boolean z10) {
            RecyclerView.s(b0Var);
            View view = b0Var.itemView;
            androidx.recyclerview.widget.o oVar = RecyclerView.this.f3778y0;
            if (oVar != null) {
                androidx.core.view.a n10 = oVar.n();
                d0.t0(view, n10 instanceof o.a ? ((o.a) n10).n(view) : null);
            }
            if (z10) {
                g(b0Var);
            }
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = null;
            i().i(b0Var);
        }

        public void c() {
            this.f3834a.clear();
            z();
        }

        void d() {
            int size = this.f3836c.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f3836c.get(i10).clearOldPosition();
            }
            int size2 = this.f3834a.size();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f3834a.get(i11).clearOldPosition();
            }
            ArrayList<b0> arrayList = this.f3835b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    this.f3835b.get(i12).clearOldPosition();
                }
            }
        }

        void e() {
            this.f3834a.clear();
            ArrayList<b0> arrayList = this.f3835b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i10) {
            if (i10 >= 0 && i10 < RecyclerView.this.f3764r0.b()) {
                return !RecyclerView.this.f3764r0.e() ? i10 : RecyclerView.this.f3741d.m(i10);
            }
            throw new IndexOutOfBoundsException("invalid position " + i10 + ". State item count is " + RecyclerView.this.f3764r0.b() + RecyclerView.this.Q());
        }

        void g(b0 b0Var) {
            v vVar = RecyclerView.this.f3755n;
            if (vVar != null) {
                vVar.a(b0Var);
            }
            int size = RecyclerView.this.f3757o.size();
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView.this.f3757o.get(i10).a(b0Var);
            }
            Adapter adapter = RecyclerView.this.f3751l;
            if (adapter != null) {
                adapter.onViewRecycled(b0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3764r0 != null) {
                recyclerView.f3743f.q(b0Var);
            }
        }

        b0 h(int i10) {
            int size;
            int m10;
            ArrayList<b0> arrayList = this.f3835b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                for (int i11 = 0; i11 < size; i11++) {
                    b0 b0Var = this.f3835b.get(i11);
                    if (!b0Var.wasReturnedFromScrap() && b0Var.getLayoutPosition() == i10) {
                        b0Var.addFlags(32);
                        return b0Var;
                    }
                }
                if (RecyclerView.this.f3751l.hasStableIds() && (m10 = RecyclerView.this.f3741d.m(i10)) > 0 && m10 < RecyclerView.this.f3751l.getItemCount()) {
                    long itemId = RecyclerView.this.f3751l.getItemId(m10);
                    for (int i12 = 0; i12 < size; i12++) {
                        b0 b0Var2 = this.f3835b.get(i12);
                        if (!b0Var2.wasReturnedFromScrap() && b0Var2.getItemId() == itemId) {
                            b0Var2.addFlags(32);
                            return b0Var2;
                        }
                    }
                }
            }
            return null;
        }

        t i() {
            if (this.f3840g == null) {
                this.f3840g = new t();
            }
            return this.f3840g;
        }

        int j() {
            return this.f3834a.size();
        }

        public List<b0> k() {
            return this.f3837d;
        }

        b0 l(long j10, int i10, boolean z10) {
            for (int size = this.f3834a.size() - 1; size >= 0; size--) {
                b0 b0Var = this.f3834a.get(size);
                if (b0Var.getItemId() == j10 && !b0Var.wasReturnedFromScrap()) {
                    if (i10 == b0Var.getItemViewType()) {
                        b0Var.addFlags(32);
                        if (b0Var.isRemoved() && !RecyclerView.this.f3764r0.e()) {
                            b0Var.setFlags(2, 14);
                        }
                        return b0Var;
                    } else if (!z10) {
                        this.f3834a.remove(size);
                        RecyclerView.this.removeDetachedView(b0Var.itemView, false);
                        y(b0Var.itemView);
                    }
                }
            }
            int size2 = this.f3836c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                b0 b0Var2 = this.f3836c.get(size2);
                if (b0Var2.getItemId() == j10 && !b0Var2.isAttachedToTransitionOverlay()) {
                    if (i10 == b0Var2.getItemViewType()) {
                        if (!z10) {
                            this.f3836c.remove(size2);
                        }
                        return b0Var2;
                    } else if (!z10) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        b0 m(int i10, boolean z10) {
            View e10;
            int size = this.f3834a.size();
            for (int i11 = 0; i11 < size; i11++) {
                b0 b0Var = this.f3834a.get(i11);
                if (!b0Var.wasReturnedFromScrap() && b0Var.getLayoutPosition() == i10 && !b0Var.isInvalid() && (RecyclerView.this.f3764r0.f3865h || !b0Var.isRemoved())) {
                    b0Var.addFlags(32);
                    return b0Var;
                }
            }
            if (z10 || (e10 = RecyclerView.this.f3742e.e(i10)) == null) {
                int size2 = this.f3836c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    b0 b0Var2 = this.f3836c.get(i12);
                    if (!b0Var2.isInvalid() && b0Var2.getLayoutPosition() == i10 && !b0Var2.isAttachedToTransitionOverlay()) {
                        if (!z10) {
                            this.f3836c.remove(i12);
                        }
                        return b0Var2;
                    }
                }
                return null;
            }
            b0 j02 = RecyclerView.j0(e10);
            RecyclerView.this.f3742e.s(e10);
            int m10 = RecyclerView.this.f3742e.m(e10);
            if (m10 != -1) {
                RecyclerView.this.f3742e.d(m10);
                D(e10);
                j02.addFlags(8224);
                return j02;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + j02 + RecyclerView.this.Q());
        }

        View n(int i10) {
            return this.f3834a.get(i10).itemView;
        }

        public View o(int i10) {
            return p(i10, false);
        }

        View p(int i10, boolean z10) {
            return I(i10, z10, Long.MAX_VALUE).itemView;
        }

        void s() {
            int size = this.f3836c.size();
            for (int i10 = 0; i10 < size; i10++) {
                o oVar = (o) this.f3836c.get(i10).itemView.getLayoutParams();
                if (oVar != null) {
                    oVar.f3826c = true;
                }
            }
        }

        void t() {
            int size = this.f3836c.size();
            for (int i10 = 0; i10 < size; i10++) {
                b0 b0Var = this.f3836c.get(i10);
                if (b0Var != null) {
                    b0Var.addFlags(6);
                    b0Var.addChangePayload(null);
                }
            }
            Adapter adapter = RecyclerView.this.f3751l;
            if (adapter == null || !adapter.hasStableIds()) {
                z();
            }
        }

        void u(int i10, int i11) {
            int size = this.f3836c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b0 b0Var = this.f3836c.get(i12);
                if (b0Var != null && b0Var.mPosition >= i10) {
                    b0Var.offsetPosition(i11, false);
                }
            }
        }

        void v(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (i10 < i11) {
                i14 = -1;
                i13 = i10;
                i12 = i11;
            } else {
                i14 = 1;
                i12 = i10;
                i13 = i11;
            }
            int size = this.f3836c.size();
            for (int i16 = 0; i16 < size; i16++) {
                b0 b0Var = this.f3836c.get(i16);
                if (b0Var != null && (i15 = b0Var.mPosition) >= i13 && i15 <= i12) {
                    if (i15 == i10) {
                        b0Var.offsetPosition(i11 - i10, false);
                    } else {
                        b0Var.offsetPosition(i14, false);
                    }
                }
            }
        }

        void w(int i10, int i11, boolean z10) {
            int i12 = i10 + i11;
            for (int size = this.f3836c.size() - 1; size >= 0; size--) {
                b0 b0Var = this.f3836c.get(size);
                if (b0Var != null) {
                    int i13 = b0Var.mPosition;
                    if (i13 >= i12) {
                        b0Var.offsetPosition(-i11, z10);
                    } else if (i13 >= i10) {
                        b0Var.addFlags(8);
                        A(size);
                    }
                }
            }
        }

        void x(Adapter adapter, Adapter adapter2, boolean z10) {
            c();
            i().h(adapter, adapter2, z10);
        }

        void y(View view) {
            b0 j02 = RecyclerView.j0(view);
            j02.mScrapContainer = null;
            j02.mInChangeScrap = false;
            j02.clearReturnedFromScrapFlag();
            C(j02);
        }

        void z() {
            for (int size = this.f3836c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f3836c.clear();
            if (RecyclerView.P0) {
                RecyclerView.this.f3762q0.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void a(b0 b0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class w extends i {
        w() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f3764r0.f3864g = true;
            recyclerView.V0(true);
            if (!RecyclerView.this.f3741d.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i10, int i11, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3741d.r(i10, i11, obj)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3741d.s(i10, i11)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3741d.t(i10, i11, i12)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f3741d.u(i10, i11)) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void g() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f3740c != null && (adapter = recyclerView.f3751l) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        void h() {
            if (RecyclerView.O0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.f3767t && recyclerView.f3765s) {
                    d0.l0(recyclerView, recyclerView.f3745h);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class x {

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f3844b;

        /* renamed from: c  reason: collision with root package name */
        private LayoutManager f3845c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3846d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3847e;

        /* renamed from: f  reason: collision with root package name */
        private View f3848f;

        /* renamed from: h  reason: collision with root package name */
        private boolean f3850h;

        /* renamed from: a  reason: collision with root package name */
        private int f3843a = -1;

        /* renamed from: g  reason: collision with root package name */
        private final a f3849g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f3851a;

            /* renamed from: b  reason: collision with root package name */
            private int f3852b;

            /* renamed from: c  reason: collision with root package name */
            private int f3853c;

            /* renamed from: d  reason: collision with root package name */
            private int f3854d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f3855e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f3856f;

            /* renamed from: g  reason: collision with root package name */
            private int f3857g;

            public a(int i10, int i11) {
                this(i10, i11, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f3855e != null && this.f3853c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f3853c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f3854d >= 0;
            }

            public void b(int i10) {
                this.f3854d = i10;
            }

            void c(RecyclerView recyclerView) {
                int i10 = this.f3854d;
                if (i10 >= 0) {
                    this.f3854d = -1;
                    recyclerView.B0(i10);
                    this.f3856f = false;
                } else if (this.f3856f) {
                    e();
                    recyclerView.f3758o0.e(this.f3851a, this.f3852b, this.f3853c, this.f3855e);
                    int i11 = this.f3857g + 1;
                    this.f3857g = i11;
                    if (i11 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f3856f = false;
                } else {
                    this.f3857g = 0;
                }
            }

            public void d(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3851a = i10;
                this.f3852b = i11;
                this.f3853c = i12;
                this.f3855e = interpolator;
                this.f3856f = true;
            }

            public a(int i10, int i11, int i12, Interpolator interpolator) {
                this.f3854d = -1;
                this.f3856f = false;
                this.f3857g = 0;
                this.f3851a = i10;
                this.f3852b = i11;
                this.f3853c = i12;
                this.f3855e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i10);
        }

        public PointF a(int i10) {
            LayoutManager e10 = e();
            if (e10 instanceof b) {
                return ((b) e10).a(i10);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i10) {
            return this.f3844b.f3753m.D(i10);
        }

        public int c() {
            return this.f3844b.f3753m.K();
        }

        public int d(View view) {
            return this.f3844b.h0(view);
        }

        public LayoutManager e() {
            return this.f3845c;
        }

        public int f() {
            return this.f3843a;
        }

        public boolean g() {
            return this.f3846d;
        }

        public boolean h() {
            return this.f3847e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f10 = pointF.x;
            float f11 = pointF.y;
            float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i10, int i11) {
            PointF a10;
            RecyclerView recyclerView = this.f3844b;
            if (this.f3843a == -1 || recyclerView == null) {
                r();
            }
            if (this.f3846d && this.f3848f == null && this.f3845c != null && (a10 = a(this.f3843a)) != null) {
                float f10 = a10.x;
                if (!(f10 == 0.0f && a10.y == 0.0f)) {
                    recyclerView.n1((int) Math.signum(f10), (int) Math.signum(a10.y), null);
                }
            }
            this.f3846d = false;
            View view = this.f3848f;
            if (view != null) {
                if (d(view) == this.f3843a) {
                    o(this.f3848f, recyclerView.f3764r0, this.f3849g);
                    this.f3849g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f3848f = null;
                }
            }
            if (this.f3847e) {
                l(i10, i11, recyclerView.f3764r0, this.f3849g);
                boolean a11 = this.f3849g.a();
                this.f3849g.c(recyclerView);
                if (a11 && this.f3847e) {
                    this.f3846d = true;
                    recyclerView.f3758o0.d();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f3848f = view;
            }
        }

        protected abstract void l(int i10, int i11, y yVar, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, y yVar, a aVar);

        public void p(int i10) {
            this.f3843a = i10;
        }

        void q(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.f3758o0.f();
            if (this.f3850h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f3844b = recyclerView;
            this.f3845c = layoutManager;
            int i10 = this.f3843a;
            if (i10 != -1) {
                recyclerView.f3764r0.f3858a = i10;
                this.f3847e = true;
                this.f3846d = true;
                this.f3848f = b(f());
                m();
                this.f3844b.f3758o0.d();
                this.f3850h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f3847e) {
                this.f3847e = false;
                n();
                this.f3844b.f3764r0.f3858a = -1;
                this.f3848f = null;
                this.f3843a = -1;
                this.f3846d = false;
                this.f3845c.g1(this);
                this.f3845c = null;
                this.f3844b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f3859b;

        /* renamed from: m  reason: collision with root package name */
        int f3870m;

        /* renamed from: n  reason: collision with root package name */
        long f3871n;

        /* renamed from: o  reason: collision with root package name */
        int f3872o;

        /* renamed from: p  reason: collision with root package name */
        int f3873p;

        /* renamed from: a  reason: collision with root package name */
        int f3858a = -1;

        /* renamed from: c  reason: collision with root package name */
        int f3860c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f3861d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f3862e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f3863f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f3864g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f3865h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f3866i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f3867j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f3868k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f3869l = false;

        void a(int i10) {
            if ((this.f3862e & i10) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i10) + " but it is " + Integer.toBinaryString(this.f3862e));
            }
        }

        public int b() {
            if (this.f3865h) {
                return this.f3860c - this.f3861d;
            }
            return this.f3863f;
        }

        public int c() {
            return this.f3858a;
        }

        public boolean d() {
            return this.f3858a != -1;
        }

        public boolean e() {
            return this.f3865h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(Adapter adapter) {
            this.f3862e = 1;
            this.f3863f = adapter.getItemCount();
            this.f3865h = false;
            this.f3866i = false;
            this.f3867j = false;
        }

        public boolean g() {
            return this.f3869l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f3858a + ", mData=" + this.f3859b + ", mItemCount=" + this.f3863f + ", mIsMeasuring=" + this.f3867j + ", mPreviousLayoutItemCount=" + this.f3860c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f3861d + ", mStructureChanged=" + this.f3864g + ", mInPreLayout=" + this.f3865h + ", mRunSimpleAnimations=" + this.f3868k + ", mRunPredictiveAnimations=" + this.f3869l + '}';
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        M0 = i10 == 18 || i10 == 19 || i10 == 20;
        N0 = i10 >= 23;
        O0 = i10 >= 16;
        P0 = i10 >= 21;
        Q0 = i10 <= 15;
        R0 = i10 <= 15;
        Class<?> cls = Integer.TYPE;
        S0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        T0 = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private boolean A0(View view, View view2, int i10) {
        int i11;
        if (view2 == null || view2 == this || view2 == view || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.f3746i.set(0, 0, view.getWidth(), view.getHeight());
        this.f3747j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3746i);
        offsetDescendantRectToMyCoords(view2, this.f3747j);
        char c10 = 65535;
        int i12 = this.f3753m.a0() == 1 ? -1 : 1;
        Rect rect = this.f3746i;
        int i13 = rect.left;
        Rect rect2 = this.f3747j;
        int i14 = rect2.left;
        if ((i13 < i14 || rect.right <= i14) && rect.right < rect2.right) {
            i11 = 1;
        } else {
            int i15 = rect.right;
            int i16 = rect2.right;
            i11 = ((i15 > i16 || i13 >= i16) && i13 > i14) ? -1 : 0;
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
            c10 = 1;
        } else {
            int i19 = rect.bottom;
            int i20 = rect2.bottom;
            if ((i19 <= i20 && i17 < i20) || i17 <= i18) {
                c10 = 0;
            }
        }
        if (i10 == 1) {
            return c10 < 0 || (c10 == 0 && i11 * i12 < 0);
        }
        if (i10 == 2) {
            return c10 > 0 || (c10 == 0 && i11 * i12 > 0);
        }
        if (i10 == 17) {
            return i11 < 0;
        }
        if (i10 == 33) {
            return c10 < 0;
        }
        if (i10 == 66) {
            return i11 > 0;
        }
        if (i10 == 130) {
            return c10 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i10 + Q());
    }

    private void B() {
        int i10 = this.A;
        this.A = 0;
        if (i10 != 0 && y0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            k0.b.b(obtain, i10);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void C1() {
        this.f3758o0.f();
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.L1();
        }
    }

    private void D() {
        boolean z10 = true;
        this.f3764r0.a(1);
        R(this.f3764r0);
        this.f3764r0.f3867j = false;
        x1();
        this.f3743f.f();
        M0();
        U0();
        k1();
        y yVar = this.f3764r0;
        if (!yVar.f3868k || !this.f3772v0) {
            z10 = false;
        }
        yVar.f3866i = z10;
        this.f3772v0 = false;
        this.f3770u0 = false;
        yVar.f3865h = yVar.f3869l;
        yVar.f3863f = this.f3751l.getItemCount();
        W(this.A0);
        if (this.f3764r0.f3868k) {
            int g10 = this.f3742e.g();
            for (int i10 = 0; i10 < g10; i10++) {
                b0 j02 = j0(this.f3742e.f(i10));
                if (!j02.shouldIgnore() && (!j02.isInvalid() || this.f3751l.hasStableIds())) {
                    this.f3743f.e(j02, this.N.u(this.f3764r0, j02, l.e(j02), j02.getUnmodifiedPayloads()));
                    if (this.f3764r0.f3866i && j02.isUpdated() && !j02.isRemoved() && !j02.shouldIgnore() && !j02.isInvalid()) {
                        this.f3743f.c(f0(j02), j02);
                    }
                }
            }
        }
        if (this.f3764r0.f3869l) {
            l1();
            y yVar2 = this.f3764r0;
            boolean z11 = yVar2.f3864g;
            yVar2.f3864g = false;
            this.f3753m.Y0(this.f3739b, yVar2);
            this.f3764r0.f3864g = z11;
            for (int i11 = 0; i11 < this.f3742e.g(); i11++) {
                b0 j03 = j0(this.f3742e.f(i11));
                if (!j03.shouldIgnore() && !this.f3743f.i(j03)) {
                    int e10 = l.e(j03);
                    boolean hasAnyOfTheFlags = j03.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e10 |= 4096;
                    }
                    l.c u10 = this.N.u(this.f3764r0, j03, e10, j03.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        X0(j03, u10);
                    } else {
                        this.f3743f.a(j03, u10);
                    }
                }
            }
            t();
        } else {
            t();
        }
        N0();
        z1(false);
        this.f3764r0.f3862e = 2;
    }

    private void E() {
        x1();
        M0();
        this.f3764r0.a(6);
        this.f3741d.j();
        this.f3764r0.f3863f = this.f3751l.getItemCount();
        this.f3764r0.f3861d = 0;
        if (this.f3740c != null && this.f3751l.canRestoreState()) {
            Parcelable parcelable = this.f3740c.f3801c;
            if (parcelable != null) {
                this.f3753m.d1(parcelable);
            }
            this.f3740c = null;
        }
        y yVar = this.f3764r0;
        yVar.f3865h = false;
        this.f3753m.Y0(this.f3739b, yVar);
        y yVar2 = this.f3764r0;
        yVar2.f3864g = false;
        yVar2.f3868k = yVar2.f3868k && this.N != null;
        yVar2.f3862e = 4;
        N0();
        z1(false);
    }

    private void E0(int i10, int i11, MotionEvent motionEvent, int i12) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3777y) {
            int[] iArr = this.E0;
            int i13 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean l10 = layoutManager.l();
            boolean m10 = this.f3753m.m();
            y1(m10 ? l10 | 2 : l10, i12);
            if (G(l10 ? i10 : 0, m10 ? i11 : 0, this.E0, this.C0, i12)) {
                int[] iArr2 = this.E0;
                i10 -= iArr2[0];
                i11 -= iArr2[1];
            }
            int i14 = l10 ? i10 : 0;
            if (m10) {
                i13 = i11;
            }
            m1(i14, i13, motionEvent, i12);
            androidx.recyclerview.widget.f fVar = this.f3760p0;
            if (!(fVar == null || (i10 == 0 && i11 == 0))) {
                fVar.f(this, i10, i11);
            }
            A1(i12);
        }
    }

    private void F() {
        this.f3764r0.a(4);
        x1();
        M0();
        y yVar = this.f3764r0;
        yVar.f3862e = 1;
        if (yVar.f3868k) {
            for (int g10 = this.f3742e.g() - 1; g10 >= 0; g10--) {
                b0 j02 = j0(this.f3742e.f(g10));
                if (!j02.shouldIgnore()) {
                    long f02 = f0(j02);
                    l.c t10 = this.N.t(this.f3764r0, j02);
                    b0 g11 = this.f3743f.g(f02);
                    if (g11 == null || g11.shouldIgnore()) {
                        this.f3743f.d(j02, t10);
                    } else {
                        boolean h10 = this.f3743f.h(g11);
                        boolean h11 = this.f3743f.h(j02);
                        if (!h10 || g11 != j02) {
                            l.c n10 = this.f3743f.n(g11);
                            this.f3743f.d(j02, t10);
                            l.c m10 = this.f3743f.m(j02);
                            if (n10 == null) {
                                p0(f02, j02, g11);
                            } else {
                                n(g11, j02, n10, m10, h10, h11);
                            }
                        } else {
                            this.f3743f.d(j02, t10);
                        }
                    }
                }
            }
            this.f3743f.o(this.K0);
        }
        this.f3753m.m1(this.f3739b);
        y yVar2 = this.f3764r0;
        yVar2.f3860c = yVar2.f3863f;
        this.E = false;
        this.F = false;
        yVar2.f3868k = false;
        yVar2.f3869l = false;
        this.f3753m.f3788h = false;
        ArrayList<b0> arrayList = this.f3739b.f3835b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager.f3794n) {
            layoutManager.f3793m = 0;
            layoutManager.f3794n = false;
            this.f3739b.K();
        }
        this.f3753m.Z0(this.f3764r0);
        N0();
        z1(false);
        this.f3743f.f();
        int[] iArr = this.A0;
        if (y(iArr[0], iArr[1])) {
            J(0, 0);
        }
        Y0();
        i1();
    }

    private boolean L(MotionEvent motionEvent) {
        r rVar = this.f3763r;
        if (rVar != null) {
            rVar.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.f3763r = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return V(motionEvent);
        }
    }

    private void P0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.T = x10;
            this.R = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.U = y10;
            this.S = y10;
        }
    }

    private boolean T0() {
        return this.N != null && this.f3753m.M1();
    }

    private void U0() {
        boolean z10;
        if (this.E) {
            this.f3741d.y();
            if (this.F) {
                this.f3753m.T0(this);
            }
        }
        if (T0()) {
            this.f3741d.w();
        } else {
            this.f3741d.j();
        }
        boolean z11 = false;
        boolean z12 = this.f3770u0 || this.f3772v0;
        this.f3764r0.f3868k = this.f3771v && this.N != null && ((z10 = this.E) || z12 || this.f3753m.f3788h) && (!z10 || this.f3751l.hasStableIds());
        y yVar = this.f3764r0;
        if (yVar.f3868k && z12 && !this.E && T0()) {
            z11 = true;
        }
        yVar.f3869l = z11;
    }

    private boolean V(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f3761q.size();
        for (int i10 = 0; i10 < size; i10++) {
            r rVar = this.f3761q.get(i10);
            if (rVar.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.f3763r = rVar;
                return true;
            }
        }
        return false;
    }

    private void W(int[] iArr) {
        int g10 = this.f3742e.g();
        if (g10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < g10; i12++) {
            b0 j02 = j0(this.f3742e.f(i12));
            if (!j02.shouldIgnore()) {
                int layoutPosition = j02.getLayoutPosition();
                if (layoutPosition < i10) {
                    i10 = layoutPosition;
                }
                if (layoutPosition > i11) {
                    i11 = layoutPosition;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void W0(float f10, float f11, float f12, float f13) {
        boolean z10;
        boolean z11 = true;
        if (f11 < 0.0f) {
            N();
            androidx.core.widget.e.c(this.J, (-f11) / getWidth(), 1.0f - (f12 / getHeight()));
        } else if (f11 > 0.0f) {
            O();
            androidx.core.widget.e.c(this.L, f11 / getWidth(), f12 / getHeight());
        } else {
            z10 = false;
            if (f13 >= 0.0f) {
                P();
                androidx.core.widget.e.c(this.K, (-f13) / getHeight(), f10 / getWidth());
            } else if (f13 > 0.0f) {
                M();
                androidx.core.widget.e.c(this.M, f13 / getHeight(), 1.0f - (f10 / getWidth()));
            } else {
                z11 = z10;
            }
            if (!z11 || f11 != 0.0f || f13 != 0.0f) {
                d0.k0(this);
            }
            return;
        }
        z10 = true;
        if (f13 >= 0.0f) {
        }
        if (!z11) {
        }
        d0.k0(this);
    }

    static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView X = X(viewGroup.getChildAt(i10));
            if (X != null) {
                return X;
            }
        }
        return null;
    }

    private View Y() {
        b0 Z;
        y yVar = this.f3764r0;
        int i10 = yVar.f3870m;
        if (i10 == -1) {
            i10 = 0;
        }
        int b10 = yVar.b();
        for (int i11 = i10; i11 < b10; i11++) {
            b0 Z2 = Z(i11);
            if (Z2 == null) {
                break;
            } else if (Z2.itemView.hasFocusable()) {
                return Z2.itemView;
            }
        }
        int min = Math.min(b10, i10);
        while (true) {
            min--;
            if (min < 0 || (Z = Z(min)) == null) {
                return null;
            }
            if (Z.itemView.hasFocusable()) {
                return Z.itemView;
            }
        }
    }

    private void Y0() {
        View findViewById;
        if (this.f3756n0 && this.f3751l != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!R0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f3742e.n(focusedChild)) {
                            return;
                        }
                    } else if (this.f3742e.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                b0 a02 = (this.f3764r0.f3871n == -1 || !this.f3751l.hasStableIds()) ? null : a0(this.f3764r0.f3871n);
                if (a02 != null && !this.f3742e.n(a02.itemView) && a02.itemView.hasFocusable()) {
                    view = a02.itemView;
                } else if (this.f3742e.g() > 0) {
                    view = Y();
                }
                if (view != null) {
                    int i10 = this.f3764r0.f3872o;
                    if (!(i10 == -1 || (findViewById = view.findViewById(i10)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void Z0() {
        boolean z10;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.J.isFinished();
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.M.isFinished();
        }
        if (z10) {
            d0.k0(this);
        }
    }

    private void g(b0 b0Var) {
        View view = b0Var.itemView;
        boolean z10 = view.getParent() == this;
        this.f3739b.J(i0(view));
        if (b0Var.isTmpDetached()) {
            this.f3742e.c(view, -1, view.getLayoutParams(), true);
        } else if (!z10) {
            this.f3742e.b(view, true);
        } else {
            this.f3742e.k(view);
        }
    }

    private androidx.core.view.q getScrollingChildHelper() {
        if (this.B0 == null) {
            this.B0 = new androidx.core.view.q(this);
        }
        return this.B0;
    }

    private void h1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3746i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f3826c) {
                Rect rect = oVar.f3825b;
                Rect rect2 = this.f3746i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3746i);
            offsetRectIntoDescendantCoords(view, this.f3746i);
        }
        LayoutManager layoutManager = this.f3753m;
        Rect rect3 = this.f3746i;
        boolean z10 = true;
        boolean z11 = !this.f3771v;
        if (view2 != null) {
            z10 = false;
        }
        layoutManager.t1(this, view, rect3, z11, z10);
    }

    private void i1() {
        y yVar = this.f3764r0;
        yVar.f3871n = -1L;
        yVar.f3870m = -1;
        yVar.f3872o = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 j0(View view) {
        if (view == null) {
            return null;
        }
        return ((o) view.getLayoutParams()).f3824a;
    }

    private void j1() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        A1(0);
        Z0();
    }

    private void k1() {
        int i10;
        b0 b0Var = null;
        View focusedChild = (!this.f3756n0 || !hasFocus() || this.f3751l == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            b0Var = U(focusedChild);
        }
        if (b0Var == null) {
            i1();
            return;
        }
        this.f3764r0.f3871n = this.f3751l.hasStableIds() ? b0Var.getItemId() : -1L;
        y yVar = this.f3764r0;
        if (this.E) {
            i10 = -1;
        } else {
            i10 = b0Var.isRemoved() ? b0Var.mOldPosition : b0Var.getAbsoluteAdapterPosition();
        }
        yVar.f3870m = i10;
        this.f3764r0.f3872o = m0(b0Var.itemView);
    }

    static void l0(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.f3825b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private int m0(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private void n(b0 b0Var, b0 b0Var2, l.c cVar, l.c cVar2, boolean z10, boolean z11) {
        b0Var.setIsRecyclable(false);
        if (z10) {
            g(b0Var);
        }
        if (b0Var != b0Var2) {
            if (z11) {
                g(b0Var2);
            }
            b0Var.mShadowedHolder = b0Var2;
            g(b0Var);
            this.f3739b.J(b0Var);
            b0Var2.setIsRecyclable(false);
            b0Var2.mShadowingHolder = b0Var;
        }
        if (this.N.b(b0Var, b0Var2, cVar, cVar2)) {
            S0();
        }
    }

    private String n0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void p0(long j10, b0 b0Var, b0 b0Var2) {
        int g10 = this.f3742e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            b0 j02 = j0(this.f3742e.f(i10));
            if (j02 != b0Var && f0(j02) == j10) {
                Adapter adapter = this.f3751l;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + j02 + " \n View Holder 2:" + b0Var + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + j02 + " \n View Holder 2:" + b0Var + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + b0Var2 + " cannot be found but it is necessary for " + b0Var + Q());
    }

    private void p1(Adapter adapter, boolean z10, boolean z11) {
        Adapter adapter2 = this.f3751l;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.f3738a);
            this.f3751l.onDetachedFromRecyclerView(this);
        }
        if (!z10 || z11) {
            a1();
        }
        this.f3741d.y();
        Adapter adapter3 = this.f3751l;
        this.f3751l = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f3738a);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.F0(adapter3, this.f3751l);
        }
        this.f3739b.x(adapter3, this.f3751l, z10);
        this.f3764r0.f3864g = true;
    }

    private void r() {
        j1();
        setScrollState(0);
    }

    static void s(b0 b0Var) {
        WeakReference<RecyclerView> weakReference = b0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != b0Var.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            b0Var.mNestedRecyclerView = null;
        }
    }

    private boolean s0() {
        int g10 = this.f3742e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            b0 j02 = j0(this.f3742e.f(i10));
            if (!(j02 == null || j02.shouldIgnore() || !j02.isUpdated())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void u0() {
        if (d0.D(this) == 0) {
            d0.F0(this, 8);
        }
    }

    private void v0() {
        this.f3742e = new androidx.recyclerview.widget.b(new e());
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i10, int i11) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String n02 = n0(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(n02, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(S0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i10), Integer.valueOf(i11)};
                    } catch (NoSuchMethodException e10) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e11) {
                            e11.initCause(e10);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + n02, e11);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + n02, e12);
                } catch (ClassNotFoundException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + n02, e13);
                } catch (IllegalAccessException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + n02, e14);
                } catch (InstantiationException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + n02, e15);
                } catch (InvocationTargetException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + n02, e16);
                }
            }
        }
    }

    private boolean y(int i10, int i11) {
        W(this.A0);
        int[] iArr = this.A0;
        return (iArr[0] == i10 && iArr[1] == i11) ? false : true;
    }

    void A(View view) {
        b0 j02 = j0(view);
        L0(view);
        Adapter adapter = this.f3751l;
        if (!(adapter == null || j02 == null)) {
            adapter.onViewDetachedFromWindow(j02);
        }
        List<p> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).a(view);
            }
        }
    }

    public void A1(int i10) {
        getScrollingChildHelper().r(i10);
    }

    void B0(int i10) {
        if (this.f3753m != null) {
            setScrollState(2);
            this.f3753m.y1(i10);
            awakenScrollBars();
        }
    }

    public void B1() {
        setScrollState(0);
        C1();
    }

    void C() {
        if (this.f3751l == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f3753m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f3764r0.f3867j = false;
            boolean z10 = this.H0 && !(this.I0 == getWidth() && this.J0 == getHeight());
            this.I0 = 0;
            this.J0 = 0;
            this.H0 = false;
            if (this.f3764r0.f3862e == 1) {
                D();
                this.f3753m.A1(this);
                E();
            } else if (this.f3741d.q() || z10 || this.f3753m.p0() != getWidth() || this.f3753m.X() != getHeight()) {
                this.f3753m.A1(this);
                E();
            } else {
                this.f3753m.A1(this);
            }
            F();
        }
    }

    void C0() {
        int j10 = this.f3742e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            ((o) this.f3742e.i(i10).getLayoutParams()).f3826c = true;
        }
        this.f3739b.s();
    }

    void D0() {
        int j10 = this.f3742e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            b0 j02 = j0(this.f3742e.i(i10));
            if (j02 != null && !j02.shouldIgnore()) {
                j02.addFlags(6);
            }
        }
        C0();
        this.f3739b.t();
    }

    void D1(int i10, int i11, Object obj) {
        int i12;
        int j10 = this.f3742e.j();
        int i13 = i10 + i11;
        for (int i14 = 0; i14 < j10; i14++) {
            View i15 = this.f3742e.i(i14);
            b0 j02 = j0(i15);
            if (j02 != null && !j02.shouldIgnore() && (i12 = j02.mPosition) >= i10 && i12 < i13) {
                j02.addFlags(2);
                j02.addChangePayload(obj);
                ((o) i15.getLayoutParams()).f3826c = true;
            }
        }
        this.f3739b.M(i10, i11);
    }

    public void F0(int i10) {
        int g10 = this.f3742e.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3742e.f(i11).offsetLeftAndRight(i10);
        }
    }

    public boolean G(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().d(i10, i11, iArr, iArr2, i12);
    }

    public void G0(int i10) {
        int g10 = this.f3742e.g();
        for (int i11 = 0; i11 < g10; i11++) {
            this.f3742e.f(i11).offsetTopAndBottom(i10);
        }
    }

    public final void H(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    void H0(int i10, int i11) {
        int j10 = this.f3742e.j();
        for (int i12 = 0; i12 < j10; i12++) {
            b0 j02 = j0(this.f3742e.i(i12));
            if (j02 != null && !j02.shouldIgnore() && j02.mPosition >= i10) {
                j02.offsetPosition(i11, false);
                this.f3764r0.f3864g = true;
            }
        }
        this.f3739b.u(i10, i11);
        requestLayout();
    }

    void I(int i10) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.f1(i10);
        }
        Q0(i10);
        s sVar = this.f3766s0;
        if (sVar != null) {
            sVar.a(this, i10);
        }
        List<s> list = this.f3768t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3768t0.get(size).a(this, i10);
            }
        }
    }

    void I0(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int j10 = this.f3742e.j();
        if (i10 < i11) {
            i14 = -1;
            i13 = i10;
            i12 = i11;
        } else {
            i12 = i10;
            i13 = i11;
            i14 = 1;
        }
        for (int i16 = 0; i16 < j10; i16++) {
            b0 j02 = j0(this.f3742e.i(i16));
            if (j02 != null && (i15 = j02.mPosition) >= i13 && i15 <= i12) {
                if (i15 == i10) {
                    j02.offsetPosition(i11 - i10, false);
                } else {
                    j02.offsetPosition(i14, false);
                }
                this.f3764r0.f3864g = true;
            }
        }
        this.f3739b.v(i10, i11);
        requestLayout();
    }

    void J(int i10, int i11) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        R0(i10, i11);
        s sVar = this.f3766s0;
        if (sVar != null) {
            sVar.b(this, i10, i11);
        }
        List<s> list = this.f3768t0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3768t0.get(size).b(this, i10, i11);
            }
        }
        this.H--;
    }

    void J0(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int j10 = this.f3742e.j();
        for (int i13 = 0; i13 < j10; i13++) {
            b0 j02 = j0(this.f3742e.i(i13));
            if (j02 != null && !j02.shouldIgnore()) {
                int i14 = j02.mPosition;
                if (i14 >= i12) {
                    j02.offsetPosition(-i11, z10);
                    this.f3764r0.f3864g = true;
                } else if (i14 >= i10) {
                    j02.flagRemovedAndOffsetPosition(i10 - 1, -i11, z10);
                    this.f3764r0.f3864g = true;
                }
            }
        }
        this.f3739b.w(i10, i11, z10);
        requestLayout();
    }

    void K() {
        int i10;
        for (int size = this.F0.size() - 1; size >= 0; size--) {
            b0 b0Var = this.F0.get(size);
            if (b0Var.itemView.getParent() == this && !b0Var.shouldIgnore() && (i10 = b0Var.mPendingAccessibilityState) != -1) {
                d0.E0(b0Var.itemView, i10);
                b0Var.mPendingAccessibilityState = -1;
            }
        }
        this.F0.clear();
    }

    public void K0(View view) {
    }

    public void L0(View view) {
    }

    void M() {
        if (this.M == null) {
            EdgeEffect a10 = this.I.a(this, 3);
            this.M = a10;
            if (this.f3744g) {
                a10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a10.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M0() {
        this.G++;
    }

    void N() {
        if (this.J == null) {
            EdgeEffect a10 = this.I.a(this, 0);
            this.J = a10;
            if (this.f3744g) {
                a10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a10.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void N0() {
        O0(true);
    }

    void O() {
        if (this.L == null) {
            EdgeEffect a10 = this.I.a(this, 2);
            this.L = a10;
            if (this.f3744g) {
                a10.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a10.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(boolean z10) {
        int i10 = this.G - 1;
        this.G = i10;
        if (i10 < 1) {
            this.G = 0;
            if (z10) {
                B();
                K();
            }
        }
    }

    void P() {
        if (this.K == null) {
            EdgeEffect a10 = this.I.a(this, 1);
            this.K = a10;
            if (this.f3744g) {
                a10.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a10.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    String Q() {
        return " " + super.toString() + ", adapter:" + this.f3751l + ", layout:" + this.f3753m + ", context:" + getContext();
    }

    public void Q0(int i10) {
    }

    final void R(y yVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f3758o0.f3805c;
            yVar.f3873p = overScroller.getFinalX() - overScroller.getCurrX();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        yVar.f3873p = 0;
    }

    public void R0(int i10, int i11) {
    }

    public View S(float f10, float f11) {
        for (int g10 = this.f3742e.g() - 1; g10 >= 0; g10--) {
            View f12 = this.f3742e.f(g10);
            float translationX = f12.getTranslationX();
            float translationY = f12.getTranslationY();
            if (f10 >= f12.getLeft() + translationX && f10 <= f12.getRight() + translationX && f11 >= f12.getTop() + translationY && f11 <= f12.getBottom() + translationY) {
                return f12;
            }
        }
        return null;
    }

    void S0() {
        if (!this.f3776x0 && this.f3765s) {
            d0.l0(this, this.G0);
            this.f3776x0 = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View T(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        return null;
    }

    public b0 U(View view) {
        View T = T(view);
        if (T == null) {
            return null;
        }
        return i0(T);
    }

    void V0(boolean z10) {
        this.F = z10 | this.F;
        this.E = true;
        D0();
    }

    void X0(b0 b0Var, l.c cVar) {
        b0Var.setFlags(0, 8192);
        if (this.f3764r0.f3866i && b0Var.isUpdated() && !b0Var.isRemoved() && !b0Var.shouldIgnore()) {
            this.f3743f.c(f0(b0Var), b0Var);
        }
        this.f3743f.e(b0Var, cVar);
    }

    public b0 Z(int i10) {
        b0 b0Var = null;
        if (this.E) {
            return null;
        }
        int j10 = this.f3742e.j();
        for (int i11 = 0; i11 < j10; i11++) {
            b0 j02 = j0(this.f3742e.i(i11));
            if (j02 != null && !j02.isRemoved() && e0(j02) == i10) {
                if (!this.f3742e.n(j02.itemView)) {
                    return j02;
                }
                b0Var = j02;
            }
        }
        return b0Var;
    }

    void a(int i10, int i11) {
        if (i10 < 0) {
            N();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            O();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            P();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            M();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i11);
            }
        }
        if (i10 != 0 || i11 != 0) {
            d0.k0(this);
        }
    }

    public b0 a0(long j10) {
        Adapter adapter = this.f3751l;
        b0 b0Var = null;
        if (adapter != null && adapter.hasStableIds()) {
            int j11 = this.f3742e.j();
            for (int i10 = 0; i10 < j11; i10++) {
                b0 j02 = j0(this.f3742e.i(i10));
                if (j02 != null && !j02.isRemoved() && j02.getItemId() == j10) {
                    if (!this.f3742e.n(j02.itemView)) {
                        return j02;
                    }
                    b0Var = j02;
                }
            }
        }
        return b0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.l1(this.f3739b);
            this.f3753m.m1(this.f3739b);
        }
        this.f3739b.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null || !layoutManager.G0(this, arrayList, i10, i11)) {
            super.addFocusables(arrayList, i10, i11);
        }
    }

    public b0 b0(int i10) {
        return c0(i10, false);
    }

    boolean b1(View view) {
        x1();
        boolean r10 = this.f3742e.r(view);
        if (r10) {
            b0 j02 = j0(view);
            this.f3739b.J(j02);
            this.f3739b.C(j02);
        }
        z1(!r10);
        return r10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    b0 c0(int i10, boolean z10) {
        int j10 = this.f3742e.j();
        b0 b0Var = null;
        for (int i11 = 0; i11 < j10; i11++) {
            b0 j02 = j0(this.f3742e.i(i11));
            if (j02 != null && !j02.isRemoved()) {
                if (z10) {
                    if (j02.mPosition != i10) {
                        continue;
                    }
                    if (this.f3742e.n(j02.itemView)) {
                        return j02;
                    }
                    b0Var = j02;
                } else {
                    if (j02.getLayoutPosition() != i10) {
                        continue;
                    }
                    if (this.f3742e.n(j02.itemView)) {
                    }
                }
            }
        }
        return b0Var;
    }

    public void c1(n nVar) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3759p.remove(nVar);
        if (this.f3759p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        C0();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.f3753m.n((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.l()) {
            return this.f3753m.r(this.f3764r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.l()) {
            return this.f3753m.s(this.f3764r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.l()) {
            return this.f3753m.t(this.f3764r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.m()) {
            return this.f3753m.u(this.f3764r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.m()) {
            return this.f3753m.v(this.f3764r0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null && layoutManager.m()) {
            return this.f3753m.w(this.f3764r0);
        }
        return 0;
    }

    public boolean d0(int i10, int i11) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f3777y) {
            return false;
        } else {
            boolean l10 = layoutManager.l();
            boolean m10 = this.f3753m.m();
            if (!l10 || Math.abs(i10) < this.f3748j0) {
                i10 = 0;
            }
            if (!m10 || Math.abs(i11) < this.f3748j0) {
                i11 = 0;
            }
            if (i10 == 0 && i11 == 0) {
                return false;
            }
            float f10 = i10;
            float f11 = i11;
            if (!dispatchNestedPreFling(f10, f11)) {
                boolean z10 = l10 || m10;
                dispatchNestedFling(f10, f11, z10);
                q qVar = this.W;
                if (qVar != null && qVar.a(i10, i11)) {
                    return true;
                }
                if (z10) {
                    if (m10) {
                        boolean z11 = l10 ? 1 : 0;
                        char c10 = l10 ? 1 : 0;
                        l10 = z11 | true;
                    }
                    int i12 = l10 ? 1 : 0;
                    int i13 = l10 ? 1 : 0;
                    y1(i12, 1);
                    int i14 = this.f3750k0;
                    int max = Math.max(-i14, Math.min(i10, i14));
                    int i15 = this.f3750k0;
                    this.f3758o0.b(max, Math.max(-i15, Math.min(i11, i15)));
                    return true;
                }
            }
            return false;
        }
    }

    public void d1(p pVar) {
        List<p> list = this.D;
        if (list != null) {
            list.remove(pVar);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        int size = this.f3759p.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            this.f3759p.get(i10).h(canvas, this, this.f3764r0);
        }
        EdgeEffect edgeEffect = this.J;
        boolean z12 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f3744g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.J;
            z10 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f3744g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z10 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3744g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.L;
            z10 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3744g) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save4);
        }
        if (z10 || this.N == null || this.f3759p.size() <= 0 || !this.N.p()) {
            z12 = z10;
        }
        if (z12) {
            d0.k0(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    int e0(b0 b0Var) {
        if (b0Var.hasAnyOfTheFlags(524) || !b0Var.isBound()) {
            return -1;
        }
        return this.f3741d.e(b0Var.mPosition);
    }

    public void e1(r rVar) {
        this.f3761q.remove(rVar);
        if (this.f3763r == rVar) {
            this.f3763r = null;
        }
    }

    long f0(b0 b0Var) {
        return this.f3751l.hasStableIds() ? b0Var.getItemId() : b0Var.mPosition;
    }

    public void f1(s sVar) {
        List<s> list = this.f3768t0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i10) {
        View view2;
        boolean z10;
        View R02 = this.f3753m.R0(view, i10);
        if (R02 != null) {
            return R02;
        }
        boolean z11 = true;
        boolean z12 = this.f3751l != null && this.f3753m != null && !z0() && !this.f3777y;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (!z12 || !(i10 == 2 || i10 == 1)) {
            View findNextFocus = focusFinder.findNextFocus(this, view, i10);
            if (findNextFocus != null || !z12) {
                view2 = findNextFocus;
            } else {
                v();
                if (T(view) == null) {
                    return null;
                }
                x1();
                view2 = this.f3753m.K0(view, i10, this.f3739b, this.f3764r0);
                z1(false);
            }
        } else {
            if (this.f3753m.m()) {
                int i11 = i10 == 2 ? 130 : 33;
                z10 = focusFinder.findNextFocus(this, view, i11) == null;
                if (Q0) {
                    i10 = i11;
                }
            } else {
                z10 = false;
            }
            if (!z10 && this.f3753m.l()) {
                int i12 = (this.f3753m.a0() == 1) ^ (i10 == 2) ? 66 : 17;
                if (focusFinder.findNextFocus(this, view, i12) != null) {
                    z11 = false;
                }
                if (Q0) {
                    i10 = i12;
                }
                z10 = z11;
            }
            if (z10) {
                v();
                if (T(view) == null) {
                    return null;
                }
                x1();
                this.f3753m.K0(view, i10, this.f3739b, this.f3764r0);
                z1(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i10);
        }
        if (view2 == null || view2.hasFocusable()) {
            return A0(view, view2, i10) ? view2 : super.focusSearch(view, i10);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i10);
        }
        h1(view2, null);
        return view;
    }

    public int g0(View view) {
        b0 j02 = j0(view);
        if (j02 != null) {
            return j02.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    void g1() {
        b0 b0Var;
        int g10 = this.f3742e.g();
        for (int i10 = 0; i10 < g10; i10++) {
            View f10 = this.f3742e.f(i10);
            b0 i02 = i0(f10);
            if (!(i02 == null || (b0Var = i02.mShadowingHolder) == null)) {
                View view = b0Var.itemView;
                int left = f10.getLeft();
                int top = f10.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            return layoutManager.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            return layoutManager.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f3751l;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            return layoutManager.H();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        j jVar = this.f3780z0;
        if (jVar == null) {
            return super.getChildDrawingOrder(i10, i11);
        }
        return jVar.a(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f3744g;
    }

    public androidx.recyclerview.widget.o getCompatAccessibilityDelegate() {
        return this.f3778y0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.f3759p.size();
    }

    public LayoutManager getLayoutManager() {
        return this.f3753m;
    }

    public int getMaxFlingVelocity() {
        return this.f3750k0;
    }

    public int getMinFlingVelocity() {
        return this.f3748j0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (P0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3756n0;
    }

    public t getRecycledViewPool() {
        return this.f3739b.i();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public int h0(View view) {
        b0 j02 = j0(view);
        if (j02 != null) {
            return j02.getLayoutPosition();
        }
        return -1;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i10) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3759p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.f3759p.add(nVar);
        } else {
            this.f3759p.add(i10, nVar);
        }
        C0();
        requestLayout();
    }

    public b0 i0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return j0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f3765s;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f3777y;
    }

    @Override // android.view.View, androidx.core.view.p
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(p pVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(pVar);
    }

    public void k(r rVar) {
        this.f3761q.add(rVar);
    }

    public void k0(View view, Rect rect) {
        l0(view, rect);
    }

    public void l(s sVar) {
        if (this.f3768t0 == null) {
            this.f3768t0 = new ArrayList();
        }
        this.f3768t0.add(sVar);
    }

    void l1() {
        int j10 = this.f3742e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            b0 j02 = j0(this.f3742e.i(i10));
            if (!j02.shouldIgnore()) {
                j02.saveOldPosition();
            }
        }
    }

    void m(b0 b0Var, l.c cVar, l.c cVar2) {
        b0Var.setIsRecyclable(false);
        if (this.N.a(b0Var, cVar, cVar2)) {
            S0();
        }
    }

    boolean m1(int i10, int i11, MotionEvent motionEvent, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        v();
        if (this.f3751l != null) {
            int[] iArr = this.E0;
            iArr[0] = 0;
            iArr[1] = 0;
            n1(i10, i11, iArr);
            int[] iArr2 = this.E0;
            int i17 = iArr2[0];
            int i18 = iArr2[1];
            i14 = i10 - i17;
            i13 = i11 - i18;
            i16 = i18;
            i15 = i17;
        } else {
            i16 = 0;
            i15 = 0;
            i14 = 0;
            i13 = 0;
        }
        if (!this.f3759p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.E0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i15, i16, i14, i13, this.C0, i12, iArr3);
        int[] iArr4 = this.E0;
        int i19 = i14 - iArr4[0];
        int i20 = i13 - iArr4[1];
        boolean z10 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i21 = this.T;
        int[] iArr5 = this.C0;
        this.T = i21 - iArr5[0];
        this.U -= iArr5[1];
        int[] iArr6 = this.D0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.o.f(motionEvent, 8194)) {
                W0(motionEvent.getX(), i19, motionEvent.getY(), i20);
            }
            u(i10, i11);
        }
        if (!(i15 == 0 && i16 == 0)) {
            J(i15, i16);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z10 && i15 == 0 && i16 == 0) ? false : true;
    }

    void n1(int i10, int i11, int[] iArr) {
        x1();
        M0();
        g0.j.a("RV Scroll");
        R(this.f3764r0);
        int x12 = i10 != 0 ? this.f3753m.x1(i10, this.f3739b, this.f3764r0) : 0;
        int z12 = i11 != 0 ? this.f3753m.z1(i11, this.f3739b, this.f3764r0) : 0;
        g0.j.b();
        g1();
        N0();
        z1(false);
        if (iArr != null) {
            iArr[0] = x12;
            iArr[1] = z12;
        }
    }

    void o(b0 b0Var, l.c cVar, l.c cVar2) {
        g(b0Var);
        b0Var.setIsRecyclable(false);
        if (this.N.c(b0Var, cVar, cVar2)) {
            S0();
        }
    }

    Rect o0(View view) {
        o oVar = (o) view.getLayoutParams();
        if (!oVar.f3826c) {
            return oVar.f3825b;
        }
        if (this.f3764r0.e() && (oVar.b() || oVar.d())) {
            return oVar.f3825b;
        }
        Rect rect = oVar.f3825b;
        rect.set(0, 0, 0, 0);
        int size = this.f3759p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3746i.set(0, 0, 0, 0);
            this.f3759p.get(i10).d(this.f3746i, view, this, this.f3764r0);
            int i11 = rect.left;
            Rect rect2 = this.f3746i;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        oVar.f3826c = false;
        return rect;
    }

    public void o1(int i10) {
        if (!this.f3777y) {
            B1();
            LayoutManager layoutManager = this.f3753m;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.y1(i10);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = 0;
        boolean z10 = true;
        this.f3765s = true;
        if (!this.f3771v || isLayoutRequested()) {
            z10 = false;
        }
        this.f3771v = z10;
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.A(this);
        }
        this.f3776x0 = false;
        if (P0) {
            ThreadLocal<androidx.recyclerview.widget.f> threadLocal = androidx.recyclerview.widget.f.f4017e;
            androidx.recyclerview.widget.f fVar = threadLocal.get();
            this.f3760p0 = fVar;
            if (fVar == null) {
                this.f3760p0 = new androidx.recyclerview.widget.f();
                Display x10 = d0.x(this);
                float f10 = 60.0f;
                if (!isInEditMode() && x10 != null) {
                    float refreshRate = x10.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f10 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.f fVar2 = this.f3760p0;
                fVar2.f4021c = 1.0E9f / f10;
                threadLocal.set(fVar2);
            }
            this.f3760p0.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.f fVar;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        B1();
        this.f3765s = false;
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            layoutManager.B(this, this.f3739b);
        }
        this.F0.clear();
        removeCallbacks(this.G0);
        this.f3743f.j();
        if (P0 && (fVar = this.f3760p0) != null) {
            fVar.j(this);
            this.f3760p0 = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3759p.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3759p.get(i10).f(canvas, this, this.f3764r0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float f11;
        if (this.f3753m != null && !this.f3777y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f11 = this.f3753m.m() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f3753m.l()) {
                    f10 = motionEvent.getAxisValue(10);
                    if (f11 == 0.0f || f10 != 0.0f) {
                        E0((int) (f10 * this.f3752l0), (int) (f11 * this.f3754m0), motionEvent, 1);
                    }
                }
                f10 = 0.0f;
                if (f11 == 0.0f) {
                }
                E0((int) (f10 * this.f3752l0), (int) (f11 * this.f3754m0), motionEvent, 1);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f3753m.m()) {
                        f11 = -axisValue;
                        f10 = 0.0f;
                        if (f11 == 0.0f) {
                        }
                        E0((int) (f10 * this.f3752l0), (int) (f11 * this.f3754m0), motionEvent, 1);
                    } else if (this.f3753m.l()) {
                        f10 = axisValue;
                        f11 = 0.0f;
                        if (f11 == 0.0f) {
                        }
                        E0((int) (f10 * this.f3752l0), (int) (f11 * this.f3754m0), motionEvent, 1);
                    }
                }
                f11 = 0.0f;
                f10 = 0.0f;
                if (f11 == 0.0f) {
                }
                E0((int) (f10 * this.f3752l0), (int) (f11 * this.f3754m0), motionEvent, 1);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object[] objArr;
        if (this.f3777y) {
            return false;
        }
        this.f3763r = null;
        if (V(motionEvent)) {
            r();
            return true;
        }
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            return false;
        }
        boolean l10 = layoutManager.l();
        boolean m10 = this.f3753m.m();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f3779z) {
                this.f3779z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.T = x10;
            this.R = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.U = y10;
            this.S = y10;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                A1(1);
            }
            int[] iArr = this.D0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (m10) {
                boolean z10 = l10 ? 1 : 0;
                char c10 = l10 ? 1 : 0;
                l10 = z10 | true;
            }
            int i10 = l10 ? 1 : 0;
            int i11 = l10 ? 1 : 0;
            y1(i10, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            A1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i12 = x11 - this.R;
                int i13 = y11 - this.S;
                if (!l10 || Math.abs(i12) <= this.V) {
                    objArr = null;
                } else {
                    this.T = x11;
                    objArr = 1;
                }
                if (m10 && Math.abs(i13) > this.V) {
                    this.U = y11;
                    objArr = 1;
                }
                if (objArr != null) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x12;
            this.R = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y12;
            this.S = y12;
        } else if (actionMasked == 6) {
            P0(motionEvent);
        }
        return this.O == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        g0.j.a("RV OnLayout");
        C();
        g0.j.b();
        this.f3771v = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            x(i10, i11);
            return;
        }
        boolean z10 = false;
        if (layoutManager.t0()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.f3753m.a1(this.f3739b, this.f3764r0, i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.H0 = z10;
            if (!z10 && this.f3751l != null) {
                if (this.f3764r0.f3862e == 1) {
                    D();
                }
                this.f3753m.B1(i10, i11);
                this.f3764r0.f3867j = true;
                E();
                this.f3753m.E1(i10, i11);
                if (this.f3753m.H1()) {
                    this.f3753m.B1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f3764r0.f3867j = true;
                    E();
                    this.f3753m.E1(i10, i11);
                }
                this.I0 = getMeasuredWidth();
                this.J0 = getMeasuredHeight();
            }
        } else if (this.f3767t) {
            this.f3753m.a1(this.f3739b, this.f3764r0, i10, i11);
        } else {
            if (this.B) {
                x1();
                M0();
                U0();
                N0();
                y yVar = this.f3764r0;
                if (yVar.f3869l) {
                    yVar.f3865h = true;
                } else {
                    this.f3741d.j();
                    this.f3764r0.f3865h = false;
                }
                this.B = false;
                z1(false);
            } else if (this.f3764r0.f3869l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.f3751l;
            if (adapter != null) {
                this.f3764r0.f3863f = adapter.getItemCount();
            } else {
                this.f3764r0.f3863f = 0;
            }
            x1();
            this.f3753m.a1(this.f3739b, this.f3764r0, i10, i11);
            z1(false);
            this.f3764r0.f3865h = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (z0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f3740c = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f3740c;
        if (savedState2 != null) {
            savedState.b(savedState2);
        } else {
            LayoutManager layoutManager = this.f3753m;
            if (layoutManager != null) {
                savedState.f3801c = layoutManager.e1();
            } else {
                savedState.f3801c = null;
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12 || i11 != i13) {
            x0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object[] objArr;
        boolean z10 = false;
        if (this.f3777y || this.f3779z) {
            return false;
        }
        if (L(motionEvent)) {
            r();
            return true;
        }
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            return false;
        }
        boolean l10 = layoutManager.l();
        boolean m10 = this.f3753m.m();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.D0;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.D0;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.P = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.T = x10;
            this.R = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.U = y10;
            this.S = y10;
            if (m10) {
                boolean z11 = l10 ? 1 : 0;
                char c10 = l10 ? 1 : 0;
                l10 = z11 | true;
            }
            int i10 = l10 ? 1 : 0;
            int i11 = l10 ? 1 : 0;
            y1(i10, 0);
        } else if (actionMasked == 1) {
            this.Q.addMovement(obtain);
            this.Q.computeCurrentVelocity(1000, this.f3750k0);
            float f10 = l10 ? -this.Q.getXVelocity(this.P) : 0.0f;
            float f11 = m10 ? -this.Q.getYVelocity(this.P) : 0.0f;
            if ((f10 == 0.0f && f11 == 0.0f) || !d0((int) f10, (int) f11)) {
                setScrollState(0);
            }
            j1();
            z10 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i12 = this.T - x11;
            int i13 = this.U - y11;
            if (this.O != 1) {
                if (l10) {
                    if (i12 > 0) {
                        i12 = Math.max(0, i12 - this.V);
                    } else {
                        i12 = Math.min(0, i12 + this.V);
                    }
                    if (i12 != 0) {
                        objArr = 1;
                        if (m10) {
                            if (i13 > 0) {
                                i13 = Math.max(0, i13 - this.V);
                            } else {
                                i13 = Math.min(0, i13 + this.V);
                            }
                            if (i13 != 0) {
                                objArr = 1;
                            }
                        }
                        if (objArr != null) {
                            setScrollState(1);
                        }
                    }
                }
                objArr = null;
                if (m10) {
                }
                if (objArr != null) {
                }
            }
            int i14 = i12;
            int i15 = i13;
            if (this.O == 1) {
                int[] iArr3 = this.E0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (G(l10 ? i14 : 0, m10 ? i15 : 0, iArr3, this.C0, 0)) {
                    int[] iArr4 = this.E0;
                    i14 -= iArr4[0];
                    i15 -= iArr4[1];
                    int[] iArr5 = this.D0;
                    int i16 = iArr5[0];
                    int[] iArr6 = this.C0;
                    iArr5[0] = i16 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int i17 = i15;
                int[] iArr7 = this.C0;
                this.T = x11 - iArr7[0];
                this.U = y11 - iArr7[1];
                if (m1(l10 ? i14 : 0, m10 ? i17 : 0, motionEvent, 0)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                androidx.recyclerview.widget.f fVar = this.f3760p0;
                if (!(fVar == null || (i14 == 0 && i17 == 0))) {
                    fVar.f(this, i14, i17);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x12;
            this.R = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y12;
            this.S = y12;
        } else if (actionMasked == 6) {
            P0(motionEvent);
        }
        if (!z10) {
            this.Q.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    void p(String str) {
        if (z0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + Q()));
        }
    }

    boolean q(b0 b0Var) {
        l lVar = this.N;
        return lVar == null || lVar.g(b0Var, b0Var.getUnmodifiedPayloads());
    }

    public boolean q0() {
        return this.f3767t;
    }

    boolean q1(b0 b0Var, int i10) {
        if (z0()) {
            b0Var.mPendingAccessibilityState = i10;
            this.F0.add(b0Var);
            return false;
        }
        d0.E0(b0Var.itemView, i10);
        return true;
    }

    public boolean r0() {
        return !this.f3771v || this.E || this.f3741d.p();
    }

    boolean r1(AccessibilityEvent accessibilityEvent) {
        int i10 = 0;
        if (!z0()) {
            return false;
        }
        int a10 = accessibilityEvent != null ? k0.b.a(accessibilityEvent) : 0;
        if (a10 != 0) {
            i10 = a10;
        }
        this.A |= i10;
        return true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z10) {
        b0 j02 = j0(view);
        if (j02 != null) {
            if (j02.isTmpDetached()) {
                j02.clearTmpDetachFlag();
            } else if (!j02.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + j02 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f3753m.c1(this, this.f3764r0, view, view2) && view2 != null) {
            h1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.f3753m.s1(this, view, rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.f3761q.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3761q.get(i10).onRequestDisallowInterceptTouchEvent(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3773w != 0 || this.f3777y) {
            this.f3775x = true;
        } else {
            super.requestLayout();
        }
    }

    public void s1(int i10, int i11) {
        t1(i10, i11, null);
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3777y) {
            boolean l10 = layoutManager.l();
            boolean m10 = this.f3753m.m();
            if (l10 || m10) {
                if (!l10) {
                    i10 = 0;
                }
                if (!m10) {
                    i11 = 0;
                }
                m1(i10, i11, null, 0);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!r1(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.o oVar) {
        this.f3778y0 = oVar;
        d0.t0(this, oVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        p1(adapter, false, true);
        V0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar != this.f3780z0) {
            this.f3780z0 = jVar;
            setChildrenDrawingOrderEnabled(jVar != null);
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z10) {
        if (z10 != this.f3744g) {
            x0();
        }
        this.f3744g = z10;
        super.setClipToPadding(z10);
        if (this.f3771v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        j0.h.g(kVar);
        this.I = kVar;
        x0();
    }

    public void setHasFixedSize(boolean z10) {
        this.f3767t = z10;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.k();
            this.N.w(null);
        }
        this.N = lVar;
        if (lVar != null) {
            lVar.w(this.f3774w0);
        }
    }

    public void setItemViewCacheSize(int i10) {
        this.f3739b.G(i10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.f3753m) {
            B1();
            if (this.f3753m != null) {
                l lVar = this.N;
                if (lVar != null) {
                    lVar.k();
                }
                this.f3753m.l1(this.f3739b);
                this.f3753m.m1(this.f3739b);
                this.f3739b.c();
                if (this.f3765s) {
                    this.f3753m.B(this, this.f3739b);
                }
                this.f3753m.F1(null);
                this.f3753m = null;
            } else {
                this.f3739b.c();
            }
            this.f3742e.o();
            this.f3753m = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f3782b == null) {
                    layoutManager.F1(this);
                    if (this.f3765s) {
                        this.f3753m.A(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f3782b.Q());
                }
            }
            this.f3739b.K();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        getScrollingChildHelper().m(z10);
    }

    public void setOnFlingListener(q qVar) {
        this.W = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.f3766s0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.f3756n0 = z10;
    }

    public void setRecycledViewPool(t tVar) {
        this.f3739b.E(tVar);
    }

    @Deprecated
    public void setRecyclerListener(v vVar) {
        this.f3755n = vVar;
    }

    void setScrollState(int i10) {
        if (i10 != this.O) {
            this.O = i10;
            if (i10 != 2) {
                C1();
            }
            I(i10);
        }
    }

    public void setScrollingTouchSlop(int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
            } else {
                this.V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(z zVar) {
        this.f3739b.F(zVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().o(i10);
    }

    @Override // android.view.View, androidx.core.view.p
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z10) {
        if (z10 != this.f3777y) {
            p("Do not suppressLayout in layout or scroll");
            if (!z10) {
                this.f3777y = false;
                if (!(!this.f3775x || this.f3753m == null || this.f3751l == null)) {
                    requestLayout();
                }
                this.f3775x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3777y = true;
            this.f3779z = true;
            B1();
        }
    }

    void t() {
        int j10 = this.f3742e.j();
        for (int i10 = 0; i10 < j10; i10++) {
            b0 j02 = j0(this.f3742e.i(i10));
            if (!j02.shouldIgnore()) {
                j02.clearOldPosition();
            }
        }
        this.f3739b.d();
    }

    void t0() {
        this.f3741d = new androidx.recyclerview.widget.a(new f());
    }

    public void t1(int i10, int i11, Interpolator interpolator) {
        u1(i10, i11, interpolator, Integer.MIN_VALUE);
    }

    void u(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.J.onRelease();
            z10 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.L.onRelease();
            z10 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.K.onRelease();
            z10 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.M.onRelease();
            z10 |= this.M.isFinished();
        }
        if (z10) {
            d0.k0(this);
        }
    }

    public void u1(int i10, int i11, Interpolator interpolator, int i12) {
        v1(i10, i11, interpolator, i12, false);
    }

    void v() {
        if (!this.f3771v || this.E) {
            g0.j.a("RV FullInvalidate");
            C();
            g0.j.b();
        } else if (this.f3741d.p()) {
            if (this.f3741d.o(4) && !this.f3741d.o(11)) {
                g0.j.a("RV PartialInvalidate");
                x1();
                M0();
                this.f3741d.w();
                if (!this.f3775x) {
                    if (s0()) {
                        C();
                    } else {
                        this.f3741d.i();
                    }
                }
                z1(true);
                N0();
                g0.j.b();
            } else if (this.f3741d.p()) {
                g0.j.a("RV FullInvalidate");
                C();
                g0.j.b();
            }
        }
    }

    void v1(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3777y) {
            int i13 = 0;
            if (!layoutManager.l()) {
                i10 = 0;
            }
            if (!this.f3753m.m()) {
                i11 = 0;
            }
            if (i10 != 0 || i11 != 0) {
                if (i12 == Integer.MIN_VALUE || i12 > 0) {
                    if (z10) {
                        if (i10 != 0) {
                            i13 = 1;
                        }
                        if (i11 != 0) {
                            i13 |= 2;
                        }
                        y1(i13, 1);
                    }
                    this.f3758o0.e(i10, i11, i12, interpolator);
                    return;
                }
                scrollBy(i10, i11);
            }
        }
    }

    void w0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
        Resources resources = getContext().getResources();
        new androidx.recyclerview.widget.e(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(e1.b.f25699a), resources.getDimensionPixelSize(e1.b.f25701c), resources.getDimensionPixelOffset(e1.b.f25700b));
    }

    public void w1(int i10) {
        if (!this.f3777y) {
            LayoutManager layoutManager = this.f3753m;
            if (layoutManager == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.J1(this, this.f3764r0, i10);
            }
        }
    }

    void x(int i10, int i11) {
        setMeasuredDimension(LayoutManager.o(i10, getPaddingLeft() + getPaddingRight(), d0.G(this)), LayoutManager.o(i11, getPaddingTop() + getPaddingBottom(), d0.F(this)));
    }

    void x0() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    void x1() {
        int i10 = this.f3773w + 1;
        this.f3773w = i10;
        if (i10 == 1 && !this.f3777y) {
            this.f3775x = false;
        }
    }

    boolean y0() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean y1(int i10, int i11) {
        return getScrollingChildHelper().p(i10, i11);
    }

    void z(View view) {
        b0 j02 = j0(view);
        K0(view);
        Adapter adapter = this.f3751l;
        if (!(adapter == null || j02 == null)) {
            adapter.onViewAttachedToWindow(j02);
        }
        List<p> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    public boolean z0() {
        return this.G > 0;
    }

    void z1(boolean z10) {
        if (this.f3773w < 1) {
            this.f3773w = 1;
        }
        if (!z10 && !this.f3777y) {
            this.f3775x = false;
        }
        if (this.f3773w == 1) {
            if (z10 && this.f3775x && !this.f3777y && this.f3753m != null && this.f3751l != null) {
                C();
            }
            if (!this.f3777y) {
                this.f3775x = false;
            }
        }
        this.f3773w--;
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e1.a.f25698a);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Parcelable f3801c;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3801c = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        void b(SavedState savedState) {
            this.f3801c = savedState.f3801c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f3801c, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3738a = new w();
        this.f3739b = new u();
        this.f3743f = new androidx.recyclerview.widget.t();
        this.f3745h = new a();
        this.f3746i = new Rect();
        this.f3747j = new Rect();
        this.f3749k = new RectF();
        this.f3757o = new ArrayList();
        this.f3759p = new ArrayList<>();
        this.f3761q = new ArrayList<>();
        this.f3773w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new androidx.recyclerview.widget.c();
        this.O = 0;
        this.P = -1;
        this.f3752l0 = Float.MIN_VALUE;
        this.f3754m0 = Float.MIN_VALUE;
        boolean z10 = true;
        this.f3756n0 = true;
        this.f3758o0 = new a0();
        this.f3762q0 = P0 ? new f.b() : null;
        this.f3764r0 = new y();
        this.f3770u0 = false;
        this.f3772v0 = false;
        this.f3774w0 = new m();
        this.f3776x0 = false;
        this.A0 = new int[2];
        this.C0 = new int[2];
        this.D0 = new int[2];
        this.E0 = new int[2];
        this.F0 = new ArrayList();
        this.G0 = new b();
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.f3752l0 = f0.b(viewConfiguration, context);
        this.f3754m0 = f0.e(viewConfiguration, context);
        this.f3748j0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3750k0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.w(this.f3774w0);
        t0();
        v0();
        u0();
        if (d0.C(this) == 0) {
            d0.E0(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.o(this));
        int[] iArr = e1.d.f25706a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        d0.r0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        String string = obtainStyledAttributes.getString(e1.d.f25715j);
        if (obtainStyledAttributes.getInt(e1.d.f25709d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f3744g = obtainStyledAttributes.getBoolean(e1.d.f25708c, true);
        boolean z11 = obtainStyledAttributes.getBoolean(e1.d.f25710e, false);
        this.f3769u = z11;
        if (z11) {
            w0((StateListDrawable) obtainStyledAttributes.getDrawable(e1.d.f25713h), obtainStyledAttributes.getDrawable(e1.d.f25714i), (StateListDrawable) obtainStyledAttributes.getDrawable(e1.d.f25711f), obtainStyledAttributes.getDrawable(e1.d.f25712g));
        }
        obtainStyledAttributes.recycle();
        w(context, string, attributeSet, i10, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr2 = L0;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
            d0.r0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i10, 0);
            z10 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z10);
    }

    /* loaded from: classes.dex */
    public static class o extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        b0 f3824a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f3825b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f3826c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f3827d = false;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f3824a.getLayoutPosition();
        }

        public boolean b() {
            return this.f3824a.isUpdated();
        }

        public boolean c() {
            return this.f3824a.isRemoved();
        }

        public boolean d() {
            return this.f3824a.isInvalid();
        }

        public o(int i10, int i11) {
            super(i10, i11);
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.f3753m;
        if (layoutManager != null) {
            return layoutManager.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }
}
