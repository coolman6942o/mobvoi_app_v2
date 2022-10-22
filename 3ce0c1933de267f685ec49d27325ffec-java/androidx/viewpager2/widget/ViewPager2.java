package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.d0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import k0.c;
import k0.f;
/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: u  reason: collision with root package name */
    static boolean f4607u = true;

    /* renamed from: d  reason: collision with root package name */
    int f4611d;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayoutManager f4614g;

    /* renamed from: i  reason: collision with root package name */
    private Parcelable f4616i;

    /* renamed from: j  reason: collision with root package name */
    RecyclerView f4617j;

    /* renamed from: k  reason: collision with root package name */
    private androidx.recyclerview.widget.n f4618k;

    /* renamed from: l  reason: collision with root package name */
    androidx.viewpager2.widget.e f4619l;

    /* renamed from: m  reason: collision with root package name */
    private androidx.viewpager2.widget.b f4620m;

    /* renamed from: n  reason: collision with root package name */
    private androidx.viewpager2.widget.c f4621n;

    /* renamed from: o  reason: collision with root package name */
    private androidx.viewpager2.widget.d f4622o;

    /* renamed from: t  reason: collision with root package name */
    e f4627t;

    /* renamed from: a  reason: collision with root package name */
    private final Rect f4608a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final Rect f4609b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private androidx.viewpager2.widget.b f4610c = new androidx.viewpager2.widget.b(3);

    /* renamed from: e  reason: collision with root package name */
    boolean f4612e = false;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.i f4613f = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f4615h = -1;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView.l f4623p = null;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4624q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4625r = true;

    /* renamed from: s  reason: collision with root package name */
    private int f4626s = -1;

    /* loaded from: classes.dex */
    class a extends g {
        a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f4612e = true;
            viewPager2.f4619l.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends i {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i10) {
            if (i10 == 0) {
                ViewPager2.this.n();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f4611d != i10) {
                viewPager2.f4611d = i10;
                viewPager2.f4627t.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends i {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f4617j.requestFocus(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements RecyclerView.p {
        d(ViewPager2 viewPager2) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void a(View view) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void b(View view) {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) oVar).width != -1 || ((ViewGroup.MarginLayoutParams) oVar).height != -1) {
                throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class e {
        private e(ViewPager2 viewPager2) {
        }

        boolean a() {
            return false;
        }

        boolean b(int i10) {
            return false;
        }

        boolean c(int i10, Bundle bundle) {
            return false;
        }

        boolean d() {
            return false;
        }

        void e(RecyclerView.Adapter<?> adapter) {
        }

        void f(RecyclerView.Adapter<?> adapter) {
        }

        String g() {
            throw new IllegalStateException("Not implemented.");
        }

        void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
        }

        void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void j(k0.c cVar) {
        }

        boolean k(int i10) {
            throw new IllegalStateException("Not implemented.");
        }

        boolean l(int i10, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        void m() {
        }

        CharSequence n() {
            throw new IllegalStateException("Not implemented.");
        }

        void o(AccessibilityEvent accessibilityEvent) {
        }

        void p() {
        }

        void q() {
        }

        void r() {
        }

        void s() {
        }

        /* synthetic */ e(ViewPager2 viewPager2, a aVar) {
            this(viewPager2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends e {
        f() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean b(int i10) {
            return (i10 == 8192 || i10 == 4096) && !ViewPager2.this.e();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean d() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void j(k0.c cVar) {
            if (!ViewPager2.this.e()) {
                cVar.S(c.a.f29699i);
                cVar.S(c.a.f29698h);
                cVar.t0(false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean k(int i10) {
            if (b(i10)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public CharSequence n() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    private static abstract class g extends RecyclerView.i {
        private g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void b(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void c(int i10, int i11, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void d(int i10, int i11) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void e(int i10, int i11, int i12) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public final void f(int i10, int i11) {
            a();
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends LinearLayoutManager {
        h(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void N0(RecyclerView.u uVar, RecyclerView.y yVar, k0.c cVar) {
            super.N0(uVar, yVar, cVar);
            ViewPager2.this.f4627t.j(cVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void N1(RecyclerView.y yVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.N1(yVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean i1(RecyclerView.u uVar, RecyclerView.y yVar, int i10, Bundle bundle) {
            if (ViewPager2.this.f4627t.b(i10)) {
                return ViewPager2.this.f4627t.k(i10);
            }
            return super.i1(uVar, yVar, i10, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a(int i10) {
        }

        public void b(int i10, float f10, int i11) {
        }

        public void c(int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends e {

        /* renamed from: a  reason: collision with root package name */
        private final k0.f f4635a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final k0.f f4636b = new b();

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.i f4637c;

        /* loaded from: classes.dex */
        class a implements k0.f {
            a() {
            }

            @Override // k0.f
            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        class b implements k0.f {
            b() {
            }

            @Override // k0.f
            public boolean a(View view, f.a aVar) {
                j.this.v(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        class c extends g {
            c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void a() {
                j.this.w();
            }
        }

        j() {
            super(ViewPager2.this, null);
        }

        private void t(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i10;
            int i11;
            if (ViewPager2.this.getAdapter() == null) {
                i11 = 0;
                i10 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i11 = ViewPager2.this.getAdapter().getItemCount();
                i10 = 0;
            } else {
                i10 = ViewPager2.this.getAdapter().getItemCount();
                i11 = 0;
            }
            k0.c.D0(accessibilityNodeInfo).c0(c.b.a(i11, i10, false, 0));
        }

        private void u(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.f4611d > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f4611d < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean c(int i10, Bundle bundle) {
            return i10 == 8192 || i10 == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void e(RecyclerView.Adapter<?> adapter) {
            w();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f4637c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void f(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f4637c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void h(androidx.viewpager2.widget.b bVar, RecyclerView recyclerView) {
            d0.E0(recyclerView, 2);
            this.f4637c = new c();
            if (d0.C(ViewPager2.this) == 0) {
                d0.E0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            t(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                u(accessibilityNodeInfo);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public boolean l(int i10, Bundle bundle) {
            int i11;
            if (c(i10, bundle)) {
                if (i10 == 8192) {
                    i11 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i11 = ViewPager2.this.getCurrentItem() + 1;
                }
                v(i11);
                return true;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void m() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void o(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void p() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void q() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void r() {
            w();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void s() {
            w();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        void v(int i10) {
            if (ViewPager2.this.e()) {
                ViewPager2.this.k(i10, true);
            }
        }

        void w() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i10 = 16908360;
            d0.n0(viewPager2, 16908360);
            d0.n0(viewPager2, 16908361);
            d0.n0(viewPager2, 16908358);
            d0.n0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.e()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean d10 = ViewPager2.this.d();
                    int i11 = d10 ? 16908360 : 16908361;
                    if (d10) {
                        i10 = 16908361;
                    }
                    if (ViewPager2.this.f4611d < itemCount - 1) {
                        d0.p0(viewPager2, new c.a(i11, null), null, this.f4635a);
                    }
                    if (ViewPager2.this.f4611d > 0) {
                        d0.p0(viewPager2, new c.a(i10, null), null, this.f4636b);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f4611d < itemCount - 1) {
                    d0.p0(viewPager2, new c.a(16908359, null), null, this.f4635a);
                }
                if (ViewPager2.this.f4611d > 0) {
                    d0.p0(viewPager2, new c.a(16908358, null), null, this.f4636b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(View view, float f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class l extends androidx.recyclerview.widget.n {
        l() {
        }

        @Override // androidx.recyclerview.widget.n, androidx.recyclerview.widget.r
        public View f(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.f(layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class m extends RecyclerView {
        m(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f4627t.d()) {
                return ViewPager2.this.f4627t.n();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4611d);
            accessibilityEvent.setToIndex(ViewPager2.this.f4611d);
            ViewPager2.this.f4627t.o(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.e() && super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f4643a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f4644b;

        n(int i10, RecyclerView recyclerView) {
            this.f4643a = i10;
            this.f4644b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4644b.w1(this.f4643a);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    private RecyclerView.p a() {
        return new d(this);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f4627t = f4607u ? new j() : new f();
        m mVar = new m(context);
        this.f4617j = mVar;
        mVar.setId(d0.m());
        this.f4617j.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        h hVar = new h(context);
        this.f4614g = hVar;
        this.f4617j.setLayoutManager(hVar);
        this.f4617j.setScrollingTouchSlop(1);
        l(context, attributeSet);
        this.f4617j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4617j.j(a());
        androidx.viewpager2.widget.e eVar = new androidx.viewpager2.widget.e(this);
        this.f4619l = eVar;
        this.f4621n = new androidx.viewpager2.widget.c(this, eVar, this.f4617j);
        l lVar = new l();
        this.f4618k = lVar;
        lVar.b(this.f4617j);
        this.f4617j.l(this.f4619l);
        androidx.viewpager2.widget.b bVar = new androidx.viewpager2.widget.b(3);
        this.f4620m = bVar;
        this.f4619l.o(bVar);
        b bVar2 = new b();
        c cVar = new c();
        this.f4620m.d(bVar2);
        this.f4620m.d(cVar);
        this.f4627t.h(this.f4620m, this.f4617j);
        this.f4620m.d(this.f4610c);
        androidx.viewpager2.widget.d dVar = new androidx.viewpager2.widget.d(this.f4614g);
        this.f4622o = dVar;
        this.f4620m.d(dVar);
        RecyclerView recyclerView = this.f4617j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void f(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f4613f);
        }
    }

    private void i() {
        RecyclerView.Adapter adapter;
        if (this.f4615h != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f4616i;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.a) {
                    ((androidx.viewpager2.adapter.a) adapter).b(parcelable);
                }
                this.f4616i = null;
            }
            int max = Math.max(0, Math.min(this.f4615h, adapter.getItemCount() - 1));
            this.f4611d = max;
            this.f4615h = -1;
            this.f4617j.o1(max);
            this.f4627t.m();
        }
    }

    private void l(Context context, AttributeSet attributeSet) {
        int[] iArr = q1.a.f32908a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(q1.a.f32909b, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f4613f);
        }
    }

    public boolean c() {
        return this.f4621n.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.f4617j.canScrollHorizontally(i10);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.f4617j.canScrollVertically(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f4614g.a0() == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i10 = ((SavedState) parcelable).f4628a;
            sparseArray.put(this.f4617j.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        i();
    }

    public boolean e() {
        return this.f4625r;
    }

    public void g(i iVar) {
        this.f4610c.d(iVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.f4627t.a()) {
            return this.f4627t.g();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f4617j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4611d;
    }

    public int getItemDecorationCount() {
        return this.f4617j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f4626s;
    }

    public int getOrientation() {
        return this.f4614g.n2();
    }

    int getPageSize() {
        int i10;
        int i11;
        RecyclerView recyclerView = this.f4617j;
        if (getOrientation() == 0) {
            i10 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i11 = recyclerView.getPaddingRight();
        } else {
            i10 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i11 = recyclerView.getPaddingBottom();
        }
        return i10 - i11;
    }

    public int getScrollState() {
        return this.f4619l.h();
    }

    public void h() {
        if (this.f4622o.d() != null) {
            double g10 = this.f4619l.g();
            int i10 = (int) g10;
            float f10 = (float) (g10 - i10);
            this.f4622o.b(i10, f10, Math.round(getPageSize() * f10));
        }
    }

    public void j(int i10, boolean z10) {
        if (!c()) {
            k(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    void k(int i10, boolean z10) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f4615h != -1) {
                this.f4615h = Math.max(i10, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
            if (min != this.f4611d || !this.f4619l.j()) {
                int i11 = this.f4611d;
                if (min != i11 || !z10) {
                    double d10 = i11;
                    this.f4611d = min;
                    this.f4627t.q();
                    if (!this.f4619l.j()) {
                        d10 = this.f4619l.g();
                    }
                    this.f4619l.m(min, z10);
                    if (!z10) {
                        this.f4617j.o1(min);
                        return;
                    }
                    double d11 = min;
                    if (Math.abs(d11 - d10) > 3.0d) {
                        this.f4617j.o1(d11 > d10 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.f4617j;
                        recyclerView.post(new n(min, recyclerView));
                        return;
                    }
                    this.f4617j.w1(min);
                }
            }
        }
    }

    void n() {
        androidx.recyclerview.widget.n nVar = this.f4618k;
        if (nVar != null) {
            View f10 = nVar.f(this.f4614g);
            if (f10 != null) {
                int i02 = this.f4614g.i0(f10);
                if (i02 != this.f4611d && getScrollState() == 0) {
                    this.f4620m.c(i02);
                }
                this.f4612e = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4627t.i(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f4617j.getMeasuredWidth();
        int measuredHeight = this.f4617j.getMeasuredHeight();
        this.f4608a.left = getPaddingLeft();
        this.f4608a.right = (i12 - i10) - getPaddingRight();
        this.f4608a.top = getPaddingTop();
        this.f4608a.bottom = (i13 - i11) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f4608a, this.f4609b);
        RecyclerView recyclerView = this.f4617j;
        Rect rect = this.f4609b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f4612e) {
            n();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        measureChild(this.f4617j, i10, i11);
        int measuredWidth = this.f4617j.getMeasuredWidth();
        int measuredHeight = this.f4617j.getMeasuredHeight();
        int measuredState = this.f4617j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4615h = savedState.f4629b;
        this.f4616i = savedState.f4630c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4628a = this.f4617j.getId();
        int i10 = this.f4615h;
        if (i10 == -1) {
            i10 = this.f4611d;
        }
        savedState.f4629b = i10;
        Parcelable parcelable = this.f4616i;
        if (parcelable != null) {
            savedState.f4630c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f4617j.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.a) {
                savedState.f4630c = ((androidx.viewpager2.adapter.a) adapter).a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, Bundle bundle) {
        if (this.f4627t.c(i10, bundle)) {
            return this.f4627t.l(i10, bundle);
        }
        return super.performAccessibilityAction(i10, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f4617j.getAdapter();
        this.f4627t.f(adapter2);
        m(adapter2);
        this.f4617j.setAdapter(adapter);
        this.f4611d = 0;
        i();
        this.f4627t.e(adapter);
        f(adapter);
    }

    public void setCurrentItem(int i10) {
        j(i10, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.f4627t.p();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 >= 1 || i10 == -1) {
            this.f4626s = i10;
            this.f4617j.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i10) {
        this.f4614g.B2(i10);
        this.f4627t.r();
    }

    public void setPageTransformer(k kVar) {
        if (kVar != null) {
            if (!this.f4624q) {
                this.f4623p = this.f4617j.getItemAnimator();
                this.f4624q = true;
            }
            this.f4617j.setItemAnimator(null);
        } else if (this.f4624q) {
            this.f4617j.setItemAnimator(this.f4623p);
            this.f4623p = null;
            this.f4624q = false;
        }
        if (kVar != this.f4622o.d()) {
            this.f4622o.e(kVar);
            h();
        }
    }

    public void setUserInputEnabled(boolean z10) {
        this.f4625r = z10;
        this.f4627t.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f4628a;

        /* renamed from: b  reason: collision with root package name */
        int f4629b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f4630c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f4628a = parcel.readInt();
            this.f4629b = parcel.readInt();
            this.f4630c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f4628a);
            parcel.writeInt(this.f4629b);
            parcel.writeParcelable(this.f4630c, i10);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
