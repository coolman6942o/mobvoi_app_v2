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
/* compiled from: ActivityRecommendationBinding.java */
/* loaded from: classes2.dex */
public final class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37548a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f37549b;

    private j(LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f37548a = linearLayout;
        this.f37549b = recyclerView;
    }

    public static j b(View view) {
        int i10 = h.B2;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            return new j((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static j d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static j e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34748q, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37548a;
    }
}
