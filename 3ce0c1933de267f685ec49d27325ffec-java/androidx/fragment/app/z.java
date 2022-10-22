package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.d0;
import androidx.core.view.y;
import g0.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class z {

    /* compiled from: FragmentTransitionImpl.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3233a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f3234b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f3235c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f3236d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f3237e;

        a(z zVar, int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f3233a = i10;
            this.f3234b = arrayList;
            this.f3235c = arrayList2;
            this.f3236d = arrayList3;
            this.f3237e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; i10 < this.f3233a; i10++) {
                d0.M0((View) this.f3234b.get(i10), (String) this.f3235c.get(i10));
                d0.M0((View) this.f3236d.get(i10), (String) this.f3237e.get(i10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(List<View> list, View view) {
        int size = list.size();
        if (!g(list, view, size)) {
            if (d0.N(view) != null) {
                list.add(view);
            }
            for (int i10 = size; i10 < list.size(); i10++) {
                View view2 = list.get(i10);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (!g(list, childAt, size) && d0.N(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean g(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View view, Rect rect) {
        if (d0.W(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(d0.N(view));
            d0.M0(view, null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList<View> arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(Fragment fragment, Object obj, c cVar, Runnable runnable) {
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String N = d0.N(view2);
            arrayList4.add(N);
            if (N != null) {
                d0.M0(view2, null);
                String str = map.get(N);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i11))) {
                        d0.M0(arrayList2.get(i11), N);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        y.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object u(Object obj);
}
