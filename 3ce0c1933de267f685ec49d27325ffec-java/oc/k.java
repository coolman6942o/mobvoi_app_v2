package oc;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.HomeMedalView;
import com.mobvoi.companion.health.widget.HealthTitleContainer;
import p1.a;
import p1.b;
/* compiled from: FragmentHealthHomeTabBinding.java */
/* loaded from: classes2.dex */
public final class k implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f31537a;

    /* renamed from: b  reason: collision with root package name */
    public final HealthTitleContainer f31538b;

    /* renamed from: c  reason: collision with root package name */
    public final HomeMedalView f31539c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f31540d;

    /* renamed from: e  reason: collision with root package name */
    public final SwipeRefreshLayout f31541e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31542f;

    private k(FrameLayout frameLayout, HealthTitleContainer healthTitleContainer, HomeMedalView homeMedalView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        this.f31537a = frameLayout;
        this.f31538b = healthTitleContainer;
        this.f31539c = homeMedalView;
        this.f31540d = recyclerView;
        this.f31541e = swipeRefreshLayout;
        this.f31542f = textView;
    }

    public static k b(View view) {
        int i10 = R.id.health_title_container;
        HealthTitleContainer healthTitleContainer = (HealthTitleContainer) b.a(view, i10);
        if (healthTitleContainer != null) {
            i10 = R.id.home_medal_view;
            HomeMedalView homeMedalView = (HomeMedalView) b.a(view, i10);
            if (homeMedalView != null) {
                i10 = R.id.rv;
                RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.swipe_refresh_layout;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) b.a(view, i10);
                    if (swipeRefreshLayout != null) {
                        i10 = R.id.tv_weekly_goal;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            return new k((FrameLayout) view, healthTitleContainer, homeMedalView, recyclerView, swipeRefreshLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f31537a;
    }
}
