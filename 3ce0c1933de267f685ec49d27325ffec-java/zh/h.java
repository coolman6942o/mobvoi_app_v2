package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import p1.a;
import p1.b;
import sh.i;
/* compiled from: ActivityInitialQuestionsBinding.java */
/* loaded from: classes2.dex */
public final class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37538a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f37539b;

    private h(LinearLayout linearLayout, Toolbar toolbar, FrameLayout frameLayout, LinearLayout linearLayout2) {
        this.f37538a = linearLayout;
        this.f37539b = linearLayout2;
    }

    public static h b(View view) {
        int i10 = sh.h.I0;
        Toolbar toolbar = (Toolbar) b.a(view, i10);
        if (toolbar != null) {
            i10 = sh.h.f34611a1;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                i10 = sh.h.f34664m1;
                LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                if (linearLayout != null) {
                    return new h((LinearLayout) view, toolbar, frameLayout, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static h d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static h e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.n_res_0x7f0e003d, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37538a;
    }
}
