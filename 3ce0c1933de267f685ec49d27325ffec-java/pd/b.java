package pd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import od.c;
import p1.a;
/* compiled from: FragmentQuickControlBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f32758a;

    /* renamed from: b  reason: collision with root package name */
    public final RelativeLayout f32759b;

    private b(LinearLayout linearLayout, TextView textView, RelativeLayout relativeLayout) {
        this.f32758a = linearLayout;
        this.f32759b = relativeLayout;
    }

    public static b b(View view) {
        int i10 = od.b.f31586n;
        TextView textView = (TextView) p1.b.a(view, i10);
        if (textView != null) {
            i10 = od.b.p_res_0x7f0b08a5;
            RelativeLayout relativeLayout = (RelativeLayout) p1.b.a(view, i10);
            if (relativeLayout != null) {
                return new b((LinearLayout) view, textView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(c.f_res_0x7f0e00e4, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f32758a;
    }
}
