package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ActivityArtyFeedBinding.java */
/* loaded from: classes2.dex */
public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37530a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f37531b;

    /* renamed from: c  reason: collision with root package name */
    public final SwipeRefreshLayout f37532c;

    private e(LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.f37530a = linearLayout;
        this.f37531b = recyclerView;
        this.f37532c = swipeRefreshLayout;
    }

    public static e b(View view) {
        int i10 = h.L2;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = h.f34613a3;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) b.a(view, i10);
            if (swipeRefreshLayout != null) {
                return new e((LinearLayout) view, recyclerView, swipeRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static e d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static e e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.i_res_0x7f0e0027, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37530a;
    }
}
