package xm;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.view.a0;
import androidx.core.view.p;
import androidx.core.view.t;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import um.a;
/* compiled from: SmartUtil.java */
/* loaded from: classes2.dex */
public class b implements Interpolator {

    /* renamed from: b  reason: collision with root package name */
    public static int f36614b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f36615c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static float f36616d = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: e  reason: collision with root package name */
    private static final float f36617e;

    /* renamed from: f  reason: collision with root package name */
    private static final float f36618f;

    /* renamed from: a  reason: collision with root package name */
    private int f36619a;

    static {
        float k10 = 1.0f / k(1.0f);
        f36617e = k10;
        f36618f = 1.0f - (k10 * k(1.0f));
    }

    public b(int i10) {
        this.f36619a = i10;
    }

    public static boolean a(View view, PointF pointF, boolean z10) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(a.f35517a);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a10 = a(childAt, pointF, z10);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a10;
                }
            }
        }
        return z10 || view.canScrollVertically(-1);
    }

    public static boolean b(View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(a.f35517a);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean b10 = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return b10;
            }
        }
        return true;
    }

    public static int c(float f10) {
        return (int) ((f10 * f36616d) + 0.5f);
    }

    public static void d(View view, int i10) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i10);
        } else if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i10);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i10);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).s(i10);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).d0(0, i10);
        }
    }

    public static boolean e(View view) {
        if (view instanceof sm.a) {
            return false;
        }
        return f(view) || (view instanceof ViewPager) || (view instanceof t);
    }

    public static boolean f(View view) {
        if (view instanceof sm.a) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof a0) || (view instanceof WebView) || (view instanceof p);
    }

    public static boolean g(View view, View view2, float f10, float f11, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f10, f11};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z10 = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z10 && pointF != null) {
            pointF.set(fArr[0] - f10, fArr[1] - f11);
        }
        return z10;
    }

    public static int h(View view) {
        int i10;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i11 = layoutParams.height;
        if (i11 > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        } else {
            i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i10);
        return view.getMeasuredHeight();
    }

    public static float i(int i10) {
        return i10 / f36616d;
    }

    public static void j(AbsListView absListView, int i10) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i10);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition != -1 && (childAt = absListView.getChildAt(0)) != null) {
                ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i10);
            }
        } else {
            absListView.smoothScrollBy(i10, 0);
        }
    }

    private static float k(float f10) {
        float f11 = f10 * 8.0f;
        if (f11 < 1.0f) {
            return f11 - (1.0f - ((float) Math.exp(-f11)));
        }
        return ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (this.f36619a == f36615c) {
            float f11 = 1.0f - f10;
            return 1.0f - (f11 * f11);
        }
        float k10 = f36617e * k(f10);
        return k10 > 0.0f ? k10 + f36618f : k10;
    }
}
