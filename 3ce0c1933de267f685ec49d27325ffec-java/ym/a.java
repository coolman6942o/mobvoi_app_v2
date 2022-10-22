package ym;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.core.view.p;
import androidx.core.view.t;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedList;
import sm.b;
import sm.e;
import vm.i;
/* compiled from: RefreshContentWrapper.java */
/* loaded from: classes2.dex */
public class a implements b, vm.a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    protected View f37135a;

    /* renamed from: b  reason: collision with root package name */
    protected View f37136b;

    /* renamed from: c  reason: collision with root package name */
    protected View f37137c;

    /* renamed from: d  reason: collision with root package name */
    protected View f37138d;

    /* renamed from: e  reason: collision with root package name */
    protected View f37139e;

    /* renamed from: f  reason: collision with root package name */
    protected int f37140f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f37141g = true;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f37142h = true;

    /* renamed from: i  reason: collision with root package name */
    protected wm.a f37143i = new wm.a();

    public a(View view) {
        this.f37137c = view;
        this.f37136b = view;
        this.f37135a = view;
    }

    @Override // sm.b
    public boolean a() {
        return this.f37141g && this.f37143i.a(this.f37135a);
    }

    @Override // sm.b
    public void b(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f37135a.getLeft(), -this.f37135a.getTop());
        View view = this.f37137c;
        View view2 = this.f37135a;
        if (view != view2) {
            this.f37137c = l(view2, pointF, view);
        }
        if (this.f37137c == this.f37135a) {
            this.f37143i.f36327a = null;
        } else {
            this.f37143i.f36327a = pointF;
        }
    }

    @Override // sm.b
    public void c(i iVar) {
        if (iVar instanceof wm.a) {
            this.f37143i = (wm.a) iVar;
        } else {
            this.f37143i.f36328b = iVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // sm.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i10, int i11, int i12) {
        boolean z10;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z11 = true;
        if (!(i11 == -1 || (findViewById2 = this.f37136b.findViewById(i11)) == null)) {
            if (i10 > 0) {
                findViewById2.setTranslationY(i10);
                z10 = true;
                if (!(i12 == -1 || (findViewById = this.f37136b.findViewById(i12)) == null)) {
                    if (i10 >= 0) {
                        findViewById.setTranslationY(i10);
                        if (!z11) {
                            this.f37136b.setTranslationY(i10);
                        } else {
                            this.f37136b.setTranslationY(0.0f);
                        }
                        view = this.f37138d;
                        if (view != null) {
                            view.setTranslationY(Math.max(0, i10));
                        }
                        view2 = this.f37139e;
                        if (view2 != null) {
                            view2.setTranslationY(Math.min(0, i10));
                            return;
                        }
                        return;
                    } else if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z11 = z10;
                if (!z11) {
                }
                view = this.f37138d;
                if (view != null) {
                }
                view2 = this.f37139e;
                if (view2 != null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z10 = false;
        if (i12 == -1) {
            if (i10 >= 0) {
            }
        }
        z11 = z10;
        if (!z11) {
        }
        view = this.f37138d;
        if (view != null) {
        }
        view2 = this.f37139e;
        if (view2 != null) {
        }
    }

    @Override // sm.b
    public void e(e eVar, View view, View view2) {
        k(this.f37135a, eVar);
        if (view != null || view2 != null) {
            this.f37138d = view;
            this.f37139e = view2;
            FrameLayout frameLayout = new FrameLayout(this.f37135a.getContext());
            int indexOfChild = eVar.d().getLayout().indexOfChild(this.f37135a);
            eVar.d().getLayout().removeView(this.f37135a);
            frameLayout.addView(this.f37135a, 0, new ViewGroup.LayoutParams(-1, -1));
            eVar.d().getLayout().addView(frameLayout, indexOfChild, this.f37135a.getLayoutParams());
            this.f37135a = frameLayout;
            if (view != null) {
                view.setTag(um.a.f35517a, "fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = xm.b.h(view);
                viewGroup.addView(new Space(this.f37135a.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag(um.a.f35517a, "fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = xm.b.h(view2);
                viewGroup2.addView(new Space(this.f37135a.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }

    @Override // sm.b
    public void f(boolean z10) {
        this.f37143i.f36329c = z10;
    }

    @Override // sm.b
    public ValueAnimator.AnimatorUpdateListener g(int i10) {
        View view = this.f37137c;
        if (view == null || i10 == 0) {
            return null;
        }
        if ((i10 >= 0 || !view.canScrollVertically(1)) && (i10 <= 0 || !this.f37137c.canScrollVertically(-1))) {
            return null;
        }
        this.f37140f = i10;
        return this;
    }

    @Override // sm.b
    public View getView() {
        return this.f37135a;
    }

    @Override // sm.b
    public boolean h() {
        return this.f37142h && this.f37143i.b(this.f37135a);
    }

    @Override // vm.a
    public void i(boolean z10, boolean z11) {
        this.f37141g = z10;
        this.f37142h = z11;
    }

    @Override // sm.b
    public View j() {
        return this.f37137c;
    }

    protected void k(View view, e eVar) {
        boolean isInEditMode = this.f37135a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof t) || (view2 instanceof p))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                xm.a.a(view, eVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f37137c = view2;
        }
    }

    protected View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (xm.b.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && xm.b.e(childAt)) {
                        return childAt;
                    } else {
                        pointF.offset(pointF2.x, pointF2.y);
                        View l10 = l(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                        return l10;
                    }
                }
            }
        }
        return view2;
    }

    protected View m(View view, boolean z10) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z10 || view3 != view) && xm.b.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                        linkedList.add(viewGroup.getChildAt(i10));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f37140f) * this.f37137c.getScaleY();
            View view = this.f37137c;
            if (view instanceof AbsListView) {
                xm.b.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f37140f = intValue;
    }
}
