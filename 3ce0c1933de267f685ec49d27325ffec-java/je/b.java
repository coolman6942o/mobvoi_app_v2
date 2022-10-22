package je;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import ge.k;
import ge.l;
import p1.a;
/* compiled from: FragmentDeviceListBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f29553a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29554b;

    /* renamed from: c  reason: collision with root package name */
    public final TabLayout f29555c;

    private b(LinearLayout linearLayout, RecyclerView recyclerView, TabLayout tabLayout) {
        this.f29553a = linearLayout;
        this.f29554b = recyclerView;
        this.f29555c = tabLayout;
    }

    public static b b(View view) {
        int i10 = k.c_res_0x7f0b0213;
        RecyclerView recyclerView = (RecyclerView) p1.b.a(view, i10);
        if (recyclerView != null) {
            i10 = k.f27428d;
            TabLayout tabLayout = (TabLayout) p1.b.a(view, i10);
            if (tabLayout != null) {
                return new b((LinearLayout) view, recyclerView, tabLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static b e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(l.d_res_0x7f0e00c7, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f29553a;
    }
}
