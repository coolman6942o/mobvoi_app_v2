package oc;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.button.MaterialButton;
import com.mobvoi.companion.R;
import p1.b;
/* compiled from: ActivityCardManagementBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f31491a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f31492b;

    /* renamed from: c  reason: collision with root package name */
    public final SwipeRefreshLayout f31493c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31494d;

    /* renamed from: e  reason: collision with root package name */
    public final MaterialButton f31495e;

    private a(ConstraintLayout constraintLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, MaterialButton materialButton) {
        this.f31491a = constraintLayout;
        this.f31492b = recyclerView;
        this.f31493c = swipeRefreshLayout;
        this.f31494d = textView;
        this.f31495e = materialButton;
    }

    public static a b(View view) {
        int i10 = R.id.rv_cards_mgr;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = R.id.swipe_refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) b.a(view, i10);
            if (swipeRefreshLayout != null) {
                i10 = R.id.tv_load_failed;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_refresh_page;
                    MaterialButton materialButton = (MaterialButton) b.a(view, i10);
                    if (materialButton != null) {
                        return new a((ConstraintLayout) view, recyclerView, swipeRefreshLayout, textView, materialButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f31491a;
    }
}
