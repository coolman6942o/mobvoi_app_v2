package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.a;
import androidx.core.view.d0;
import androidx.core.view.n0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k0.c;
/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: b  reason: collision with root package name */
    private static Field f2501b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2502c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f2503d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2504e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f2505f;

    /* renamed from: h  reason: collision with root package name */
    private static Field f2507h;

    /* renamed from: j  reason: collision with root package name */
    private static ThreadLocal<Rect> f2509j;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f2500a = new AtomicInteger(1);

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, i0> f2506g = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2508i = false;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f2510k = {z.b.f37157b, z.b.f37158c, z.b.f37169n, z.b.f37180y, z.b.B, z.b.C, z.b.D, z.b.E, z.b.F, z.b.G, z.b.f37159d, z.b.f37160e, z.b.f37161f, z.b.f37162g, z.b.f37163h, z.b.f37164i, z.b.f37165j, z.b.f37166k, z.b.f37167l, z.b.f37168m, z.b.f37170o, z.b.f37171p, z.b.f37172q, z.b.f37173r, z.b.f37174s, z.b.f37175t, z.b.f37176u, z.b.f37177v, z.b.f37178w, z.b.f37179x, z.b.f37181z, z.b.A};

    /* renamed from: l  reason: collision with root package name */
    private static final x f2511l = c0.f2498a;

    /* renamed from: m  reason: collision with root package name */
    private static final e f2512m = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class a extends f<Boolean> {
        a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(q.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            q.i(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class b extends f<CharSequence> {
        b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return q.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            q.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class c extends f<CharSequence> {
        c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return s.a(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            s.c(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class d extends f<Boolean> {
        d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(q.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            q.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f2513a = new WeakHashMap<>();

        e() {
        }

        private void b(View view, boolean z10) {
            boolean z11 = view.getVisibility() == 0;
            if (z10 != z11) {
                d0.c0(view, z11 ? 16 : 32);
                this.f2513a.put(view, Boolean.valueOf(z11));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        void a(View view) {
            this.f2513a.put(view, Boolean.valueOf(view.getVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        void d(View view) {
            this.f2513a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f2513a.entrySet()) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f2514a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f2515b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2516c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2517d;

        f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f2516c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract T d(View view);

        abstract void e(View view, T t10);

        T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T t10 = (T) view.getTag(this.f2514a);
            if (this.f2515b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        void g(View view, T t10) {
            if (c()) {
                e(view, t10);
            } else if (b() && h(f(view), t10)) {
                d0.l(view);
                view.setTag(this.f2514a, t10);
                d0.c0(view, this.f2517d);
            }
        }

        abstract boolean h(T t10, T t11);

        f(int i10, Class<T> cls, int i11, int i12) {
            this.f2514a = i10;
            this.f2515b = cls;
            this.f2517d = i11;
            this.f2516c = i12;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class g {
        static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class h {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        static void s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class i {
        static int a() {
            return View.generateViewId();
        }

        static Display b(View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i10) {
            view.setLabelFor(i10);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        static void k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class j {
        static Rect a(View view) {
            return view.getClipBounds();
        }

        static boolean b(View view) {
            return view.isInLayout();
        }

        static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class k {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        static void f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class l {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class m {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ViewCompat.java */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            n0 f2518a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f2519b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ androidx.core.view.v f2520c;

            a(View view, androidx.core.view.v vVar) {
                this.f2519b = view;
                this.f2520c = vVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                n0 x10 = n0.x(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    m.a(windowInsets, this.f2519b);
                    if (x10.equals(this.f2518a)) {
                        return this.f2520c.a(view, x10).v();
                    }
                }
                this.f2518a = x10;
                n0 a10 = this.f2520c.a(view, x10);
                if (i10 >= 30) {
                    return a10.v();
                }
                d0.q0(view);
                return a10.v();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(z.b.T);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static n0 b(View view, n0 n0Var, Rect rect) {
            WindowInsets v10 = n0Var.v();
            if (v10 != null) {
                return n0.x(view.computeSystemWindowInsets(v10, rect), view);
            }
            rect.setEmpty();
            return n0Var;
        }

        static boolean c(View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        static boolean d(View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static n0 j(View view) {
            return n0.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f10) {
            view.setElevation(f10);
        }

        static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        static void u(View view, androidx.core.view.v vVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(z.b.L, vVar);
            }
            if (vVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(z.b.T));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, vVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        static void x(View view, float f10) {
            view.setZ(f10);
        }

        static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static class n {
        public static n0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            n0 w10 = n0.w(rootWindowInsets);
            w10.t(w10);
            w10.d(view.getRootView());
            return w10;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i10) {
            view.setScrollIndicators(i10);
        }

        static void d(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class o {
        static void a(View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class p {
        static void a(View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        static int b(View view) {
            return view.getImportantForAutofill();
        }

        static int c(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View h(View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        static void l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        static void m(View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        static void n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class q {
        static void a(View view, final v vVar) {
            int i10 = z.b.S;
            androidx.collection.f fVar = (androidx.collection.f) view.getTag(i10);
            if (fVar == null) {
                fVar = new androidx.collection.f();
                view.setTag(i10, fVar);
            }
            Objects.requireNonNull(vVar);
            View.OnUnhandledKeyEventListener e0Var = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.e0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return d0.v.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            fVar.put(vVar, e0Var);
            view.addOnUnhandledKeyEventListener(e0Var);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, v vVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            androidx.collection.f fVar = (androidx.collection.f) view.getTag(z.b.S);
            if (fVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) fVar.get(vVar)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class r {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class s {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static o0 b(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return o0.d(windowInsetsController);
            }
            return null;
        }

        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static final class t {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static androidx.core.view.c b(View view, androidx.core.view.c cVar) {
            ContentInfo f10 = cVar.f();
            ContentInfo performReceiveContent = view.performReceiveContent(f10);
            if (performReceiveContent == null) {
                return null;
            }
            return performReceiveContent == f10 ? cVar : androidx.core.view.c.g(performReceiveContent);
        }

        public static void c(View view, String[] strArr, androidx.core.view.w wVar) {
            if (wVar == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new u(wVar));
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    private static final class u implements OnReceiveContentListener {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.view.w f2521a;

        u(androidx.core.view.w wVar) {
            this.f2521a = wVar;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            androidx.core.view.c g10 = androidx.core.view.c.g(contentInfo);
            androidx.core.view.c a10 = this.f2521a.a(view, g10);
            if (a10 == null) {
                return null;
            }
            return a10 == g10 ? contentInfo : a10.f();
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface v {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    static class w {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f2522d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f2523a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f2524b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f2525c = null;

        w() {
        }

        static w a(View view) {
            int i10 = z.b.R;
            w wVar = (w) view.getTag(i10);
            if (wVar != null) {
                return wVar;
            }
            w wVar2 = new w();
            view.setTag(i10, wVar2);
            return wVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f2523a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f2524b == null) {
                this.f2524b = new SparseArray<>();
            }
            return this.f2524b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(z.b.S);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((v) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f2523a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f2522d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f2523a == null) {
                        this.f2523a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f2522d;
                        View view = arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f2523a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2523a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c10));
                }
            }
            return c10 != null;
        }

        boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f2525c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f2525c = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference2 = null;
            SparseArray<WeakReference<View>> d10 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d10.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d10.valueAt(indexOfKey);
                d10.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d10.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = weakReference2.get();
            if (view != null && d0.W(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    private static x A(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        return f2511l;
    }

    public static void A0(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            j.c(view, rect);
        }
    }

    public static boolean B(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.b(view);
        }
        return false;
    }

    public static void B0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.s(view, f10);
        }
    }

    public static int C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.c(view);
        }
        return 0;
    }

    @Deprecated
    public static void C0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @SuppressLint({"InlinedApi"})
    public static int D(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.b(view);
        }
        return 0;
    }

    public static void D0(View view, boolean z10) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.r(view, z10);
        }
    }

    public static int E(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.d(view);
        }
        return 0;
    }

    public static void E0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            h.s(view, i10);
        } else if (i11 >= 16) {
            if (i10 == 4) {
                i10 = 2;
            }
            h.s(view, i10);
        }
    }

    public static int F(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.d(view);
        }
        if (!f2504e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f2503d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2504e = true;
        }
        Field field = f2503d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void F0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.l(view, i10);
        }
    }

    public static int G(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.e(view);
        }
        if (!f2502c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f2501b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f2502c = true;
        }
        Field field = f2501b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static void G0(View view, androidx.core.view.v vVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.u(view, vVar);
        }
    }

    public static String[] H(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return t.a(view);
        }
        return (String[]) view.getTag(z.b.N);
    }

    public static void H0(View view, int i10, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 17) {
            i.k(view, i10, i11, i12, i13);
        } else {
            view.setPadding(i10, i11, i12, i13);
        }
    }

    public static int I(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.e(view);
        }
        return view.getPaddingRight();
    }

    public static void I0(View view, z zVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            o.d(view, (PointerIcon) (zVar != null ? zVar.a() : null));
        }
    }

    public static int J(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.f(view);
        }
        return view.getPaddingLeft();
    }

    public static void J0(View view, boolean z10) {
        s0().g(view, Boolean.valueOf(z10));
    }

    public static ViewParent K(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.f(view);
        }
        return view.getParent();
    }

    public static void K0(View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            n.d(view, i10, i11);
        }
    }

    public static n0 L(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return n.a(view);
        }
        if (i10 >= 21) {
            return m.j(view);
        }
        return null;
    }

    public static void L0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            Q0().g(view, charSequence);
        }
    }

    public static CharSequence M(View view) {
        return Q0().f(view);
    }

    public static void M0(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.v(view, str);
            return;
        }
        if (f2505f == null) {
            f2505f = new WeakHashMap<>();
        }
        f2505f.put(view, str);
    }

    public static String N(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.k(view);
        }
        WeakHashMap<View, String> weakHashMap = f2505f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static void N0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.w(view, f10);
        }
    }

    public static float O(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.l(view);
        }
        return 0.0f;
    }

    private static void O0(View view) {
        if (C(view) == 0) {
            E0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (C((View) parent) == 4) {
                E0(view, 2);
                return;
            }
        }
    }

    public static o0 P(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return s.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return m0.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void P0(View view, float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.x(view, f10);
        }
    }

    @Deprecated
    public static int Q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.g(view);
        }
        return 0;
    }

    private static f<CharSequence> Q0() {
        return new c(z.b.P, CharSequence.class, 64, 30);
    }

    public static float R(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.m(view);
        }
        return 0.0f;
    }

    public static void R0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            m.z(view);
        } else if (view instanceof androidx.core.view.p) {
            ((androidx.core.view.p) view).stopNestedScroll();
        }
    }

    public static boolean S(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return g.a(view);
        }
        return false;
    }

    private static void S0(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static boolean T(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.h(view);
        }
        return true;
    }

    public static boolean U(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.i(view);
        }
        return false;
    }

    public static boolean V(View view) {
        Boolean f10 = b().f(view);
        return f10 != null && f10.booleanValue();
    }

    public static boolean W(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.b(view);
        }
        return view.getWindowToken() != null;
    }

    public static boolean X(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.c(view);
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean Y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.p(view);
        }
        if (view instanceof androidx.core.view.p) {
            return ((androidx.core.view.p) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static boolean Z(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.g(view);
        }
        return false;
    }

    public static boolean a0(View view) {
        Boolean f10 = s0().f(view);
        return f10 != null && f10.booleanValue();
    }

    private static f<Boolean> b() {
        return new d(z.b.J, Boolean.class, 28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ androidx.core.view.c b0(androidx.core.view.c cVar) {
        return cVar;
    }

    public static int c(View view, CharSequence charSequence, k0.f fVar) {
        int t10 = t(view, charSequence);
        if (t10 != -1) {
            d(view, new c.a(t10, charSequence, fVar));
        }
        return t10;
    }

    static void c0(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = r(view) != null && view.getVisibility() == 0;
            int i11 = 32;
            if (q(view) != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = 2048;
                }
                obtain.setEventType(i11);
                k.g(obtain, i10);
                if (z10) {
                    obtain.getText().add(r(view));
                    O0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(r(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e10);
                }
            }
        }
    }

    private static void d(View view, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            l(view);
            o0(aVar.b(), view);
            s(view).add(aVar);
            c0(view, 0);
        }
    }

    public static void d0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetLeftAndRight(i10);
        } else if (i11 >= 21) {
            Rect z10 = z();
            boolean z11 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                z10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z11 = !z10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            f(view, i10);
            if (z11 && z10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(z10);
            }
        } else {
            f(view, i10);
        }
    }

    public static i0 e(View view) {
        if (f2506g == null) {
            f2506g = new WeakHashMap<>();
        }
        i0 i0Var = f2506g.get(view);
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0(view);
        f2506g.put(view, i0Var2);
        return i0Var2;
    }

    public static void e0(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            view.offsetTopAndBottom(i10);
        } else if (i11 >= 21) {
            Rect z10 = z();
            boolean z11 = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                z10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z11 = !z10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            g(view, i10);
            if (z11 && z10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(z10);
            }
        } else {
            g(view, i10);
        }
    }

    private static void f(View view, int i10) {
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            S0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                S0((View) parent);
            }
        }
    }

    public static n0 f0(View view, n0 n0Var) {
        WindowInsets v10;
        if (Build.VERSION.SDK_INT >= 21 && (v10 = n0Var.v()) != null) {
            WindowInsets b10 = l.b(view, v10);
            if (!b10.equals(v10)) {
                return n0.x(b10, view);
            }
        }
        return n0Var;
    }

    private static void g(View view, int i10) {
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            S0(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                S0((View) parent);
            }
        }
    }

    public static void g0(View view, k0.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.C0());
    }

    public static n0 h(View view, n0 n0Var, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? m.b(view, n0Var, rect) : n0Var;
    }

    private static f<CharSequence> h0() {
        return new b(z.b.K, CharSequence.class, 8, 28);
    }

    public static n0 i(View view, n0 n0Var) {
        WindowInsets v10;
        if (Build.VERSION.SDK_INT >= 21 && (v10 = n0Var.v()) != null) {
            WindowInsets a10 = l.a(view, v10);
            if (!a10.equals(v10)) {
                return n0.x(a10, view);
            }
        }
        return n0Var;
    }

    public static boolean i0(View view, int i10, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return h.j(view, i10, bundle);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).b(view, keyEvent);
    }

    public static androidx.core.view.c j0(View view, androidx.core.view.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.b(view, cVar);
        }
        androidx.core.view.w wVar = (androidx.core.view.w) view.getTag(z.b.M);
        if (wVar == null) {
            return A(view).a(cVar);
        }
        androidx.core.view.c a10 = wVar.a(view, cVar);
        if (a10 == null) {
            return null;
        }
        return A(view).a(a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).f(keyEvent);
    }

    public static void k0(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.k(view);
        } else {
            view.postInvalidate();
        }
    }

    static void l(View view) {
        androidx.core.view.a n10 = n(view);
        if (n10 == null) {
            n10 = new androidx.core.view.a();
        }
        t0(view, n10);
    }

    public static void l0(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.m(view, runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static int m() {
        AtomicInteger atomicInteger;
        int i10;
        int i11;
        if (Build.VERSION.SDK_INT >= 17) {
            return i.a();
        }
        do {
            atomicInteger = f2500a;
            i10 = atomicInteger.get();
            i11 = i10 + 1;
            if (i11 > 16777215) {
                i11 = 1;
            }
        } while (!atomicInteger.compareAndSet(i10, i11));
        return i10;
    }

    @SuppressLint({"LambdaLast"})
    public static void m0(View view, Runnable runnable, long j10) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.n(view, runnable, j10);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j10);
        }
    }

    public static androidx.core.view.a n(View view) {
        View.AccessibilityDelegate o10 = o(view);
        if (o10 == null) {
            return null;
        }
        if (o10 instanceof a.C0020a) {
            return ((a.C0020a) o10).f2482a;
        }
        return new androidx.core.view.a(o10);
    }

    public static void n0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            o0(i10, view);
            c0(view, 0);
        }
    }

    private static View.AccessibilityDelegate o(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return r.a(view);
        }
        return p(view);
    }

    private static void o0(int i10, View view) {
        List<c.a> s10 = s(view);
        for (int i11 = 0; i11 < s10.size(); i11++) {
            if (s10.get(i11).b() == i10) {
                s10.remove(i11);
                return;
            }
        }
    }

    private static View.AccessibilityDelegate p(View view) {
        if (f2508i) {
            return null;
        }
        if (f2507h == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f2507h = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f2508i = true;
                return null;
            }
        }
        try {
            Object obj = f2507h.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f2508i = true;
            return null;
        }
    }

    public static void p0(View view, c.a aVar, CharSequence charSequence, k0.f fVar) {
        if (fVar == null && charSequence == null) {
            n0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, fVar));
        }
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return k.a(view);
        }
        return 0;
    }

    public static void q0(View view) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            l.c(view);
        } else if (i10 >= 16) {
            h.p(view);
        }
    }

    public static CharSequence r(View view) {
        return h0().f(view);
    }

    public static void r0(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.c(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    private static List<c.a> s(View view) {
        int i10 = z.b.H;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    private static f<Boolean> s0() {
        return new a(z.b.O, Boolean.class, 28);
    }

    private static int t(View view, CharSequence charSequence) {
        List<c.a> s10 = s(view);
        for (int i10 = 0; i10 < s10.size(); i10++) {
            if (TextUtils.equals(charSequence, s10.get(i10).c())) {
                return s10.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f2510k;
            if (i12 >= iArr.length || i11 != -1) {
                break;
            }
            int i13 = iArr[i12];
            boolean z10 = true;
            for (int i14 = 0; i14 < s10.size(); i14++) {
                z10 &= s10.get(i14).b() != i13;
            }
            if (z10) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    public static void t0(View view, androidx.core.view.a aVar) {
        if (aVar == null && (o(view) instanceof a.C0020a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static ColorStateList u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.g(view);
        }
        if (view instanceof b0) {
            return ((b0) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void u0(View view, boolean z10) {
        b().g(view, Boolean.valueOf(z10));
    }

    public static PorterDuff.Mode v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.h(view);
        }
        if (view instanceof b0) {
            return ((b0) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void v0(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 19) {
            k.f(view, i10);
        }
    }

    public static Rect w(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return j.a(view);
        }
        return null;
    }

    public static void w0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            h0().g(view, charSequence);
            if (charSequence != null) {
                f2512m.a(view);
            } else {
                f2512m.d(view);
            }
        }
    }

    public static Display x(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return i.b(view);
        }
        if (W(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void x0(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            h.q(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static float y(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m.i(view);
        }
        return 0.0f;
    }

    public static void y0(View view, ColorStateList colorStateList) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            m.q(view, colorStateList);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                boolean z10 = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof b0) {
            ((b0) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    private static Rect z() {
        if (f2509j == null) {
            f2509j = new ThreadLocal<>();
        }
        Rect rect = f2509j.get();
        if (rect == null) {
            rect = new Rect();
            f2509j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void z0(View view, PorterDuff.Mode mode) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            m.r(view, mode);
            if (i10 == 21) {
                Drawable background = view.getBackground();
                boolean z10 = (m.g(view) == null && m.h(view) == null) ? false : true;
                if (background != null && z10) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    h.q(view, background);
                }
            }
        } else if (view instanceof b0) {
            ((b0) view).setSupportBackgroundTintMode(mode);
        }
    }
}
