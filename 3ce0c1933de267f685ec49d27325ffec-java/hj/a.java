package hj;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.mobvoi.mcuwatch.ui.search.widget.SearchBlankPage;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
/* compiled from: BaseSearchFragment.kt */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public SearchBlankPage f27869a;

    /* renamed from: b  reason: collision with root package name */
    public View f27870b;

    /* compiled from: BaseSearchFragment.kt */
    /* renamed from: hj.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0302a {
        private C0302a() {
        }

        public /* synthetic */ C0302a(f fVar) {
            this();
        }
    }

    static {
        new C0302a(null);
    }

    public final View Y() {
        View view = this.f27870b;
        if (view != null) {
            return view;
        }
        i.u("customView");
        throw null;
    }

    public abstract int Z();

    public final SearchBlankPage a0() {
        SearchBlankPage searchBlankPage = this.f27869a;
        if (searchBlankPage != null) {
            return searchBlankPage;
        }
        i.u("searchPage");
        throw null;
    }

    public SearchBlankPage b0() {
        Y().setVisibility(0);
        a0().setVisibility(8);
        return a0();
    }

    public final boolean c0() {
        return a0().getVisibility() == 0;
    }

    public final void d0(View view) {
        i.f(view, "<set-?>");
        this.f27870b = view;
    }

    public final void e0(SearchBlankPage searchBlankPage) {
        i.f(searchBlankPage, "<set-?>");
        this.f27869a = searchBlankPage;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = inflater.inflate(sh.i.L, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        View findViewById = constraintLayout.findViewById(h.f34693s2);
        i.e(findViewById, "root.findViewById(R.id.pair_page)");
        e0((SearchBlankPage) findViewById);
        View findViewById2 = constraintLayout.findViewById(h.N);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById2;
        View inflate2 = inflater.inflate(Z(), (ViewGroup) frameLayout, false);
        i.e(inflate2, "inflater.inflate(layoutId, layoutContainer, false)");
        d0(inflate2);
        frameLayout.addView(Y(), new ViewGroup.LayoutParams(-1, -1));
        return constraintLayout;
    }
}
