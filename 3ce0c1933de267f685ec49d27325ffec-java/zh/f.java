package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ActivityBadgesBinding.java */
/* loaded from: classes2.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37533a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f37534b;

    private f(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f37533a = linearLayout;
        this.f37534b = recyclerView;
    }

    public static f b(View view) {
        int i10 = h.L2;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            return new f((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static f d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static f e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.k_res_0x7f0e0029, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37533a;
    }
}
