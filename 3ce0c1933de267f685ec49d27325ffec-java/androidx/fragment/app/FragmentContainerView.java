package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.d0;
import androidx.core.view.n0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v0.c;
/* compiled from: FragmentContainerView.kt */
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final List<View> f2968a;

    /* renamed from: b  reason: collision with root package name */
    private final List<View> f2969b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnApplyWindowInsetsListener f2970c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2971d;

    /* compiled from: FragmentContainerView.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f2972a = new a();

        private a() {
        }

        public final WindowInsets a(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View v10, WindowInsets insets) {
            i.f(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            i.f(v10, "v");
            i.f(insets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(v10, insets);
            i.e(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        i.f(context, "context");
        this.f2968a = new ArrayList();
        this.f2969b = new ArrayList();
        this.f2971d = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    private final void a(View view) {
        if (this.f2969b.contains(view)) {
            this.f2968a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int i10, ViewGroup.LayoutParams layoutParams) {
        i.f(child, "child");
        if (FragmentManager.B0(child) != null) {
            super.addView(child, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + child + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        n0 n0Var;
        i.f(insets, "insets");
        n0 w10 = n0.w(insets);
        i.e(w10, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2970c;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f2972a;
            i.d(onApplyWindowInsetsListener);
            n0Var = n0.w(aVar.a(onApplyWindowInsetsListener, this, insets));
        } else {
            n0Var = d0.f0(this, w10);
        }
        if (!n0Var.p()) {
            int i10 = 0;
            int childCount = getChildCount();
            if (childCount > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    d0.i(getChildAt(i10), n0Var);
                    if (i11 >= childCount) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        if (this.f2971d) {
            for (View view : this.f2968a) {
                super.drawChild(canvas, view, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j10) {
        i.f(canvas, "canvas");
        i.f(child, "child");
        if (!this.f2971d || !(!this.f2968a.isEmpty()) || !this.f2968a.contains(child)) {
            return super.drawChild(canvas, child, j10);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        i.f(view, "view");
        this.f2969b.remove(view);
        if (this.f2968a.remove(view)) {
            this.f2971d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.i0(this).f0(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        i.f(insets, "insets");
        return insets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount() - 1;
        if (childCount >= 0) {
            while (true) {
                int i10 = childCount - 1;
                View view = getChildAt(childCount);
                i.e(view, "view");
                a(view);
                if (i10 < 0) {
                    break;
                }
                childCount = i10;
            }
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        i.f(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View view = getChildAt(i10);
        i.e(view, "view");
        a(view);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        i.f(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        if (i10 < i12) {
            int i13 = i10;
            while (true) {
                int i14 = i13 + 1;
                View view = getChildAt(i13);
                i.e(view, "view");
                a(view);
                if (i14 >= i12) {
                    break;
                }
                i13 = i14;
            }
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        if (i10 < i12) {
            int i13 = i10;
            while (true) {
                int i14 = i13 + 1;
                View view = getChildAt(i13);
                i.e(view, "view");
                a(view);
                if (i14 >= i12) {
                    break;
                }
                i13 = i14;
            }
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f2971d = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        i.f(listener, "listener");
        this.f2970c = listener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        i.f(view, "view");
        if (view.getParent() == this) {
            this.f2969b.add(view);
        }
        super.startViewTransition(view);
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        String str;
        i.f(context, "context");
        this.f2968a = new ArrayList();
        this.f2969b = new ArrayList();
        this.f2971d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] FragmentContainerView = c.f35567e;
            i.e(FragmentContainerView, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentContainerView, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(c.f35568f);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + ((Object) classAttribute) + '\"');
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attrs, FragmentManager fm2) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
        i.f(fm2, "fm");
        this.f2968a = new ArrayList();
        this.f2969b = new ArrayList();
        this.f2971d = true;
        String classAttribute = attrs.getClassAttribute();
        int[] FragmentContainerView = c.f35567e;
        i.e(FragmentContainerView, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(c.f35568f) : classAttribute;
        String string = obtainStyledAttributes.getString(c.f35569g);
        obtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment f02 = fm2.f0(id2);
        if (classAttribute != null && f02 == null) {
            if (id2 <= 0) {
                String n10 = string != null ? i.n(" with tag ", string) : "";
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + ((Object) classAttribute) + n10);
            }
            Fragment a10 = fm2.s0().a(context.getClassLoader(), classAttribute);
            i.e(a10, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            a10.onInflate(context, attrs, (Bundle) null);
            fm2.l().y(true).d(this, a10, string).m();
        }
        fm2.U0(this);
    }
}
