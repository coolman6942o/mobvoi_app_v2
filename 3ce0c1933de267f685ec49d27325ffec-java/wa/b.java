package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import p1.a;
import pa.e;
import pa.f;
/* compiled from: FragmentNightModeSettingBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f36179a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f36180b;

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f36181c;

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f36182d;

    private b(LinearLayout linearLayout, RelativeLayout relativeLayout, RadioButton radioButton, RelativeLayout relativeLayout2, RadioButton radioButton2, RelativeLayout relativeLayout3, RadioButton radioButton3) {
        this.f36179a = linearLayout;
        this.f36180b = radioButton;
        this.f36181c = radioButton2;
        this.f36182d = radioButton3;
    }

    public static b b(View view) {
        int i10 = e.f32661s;
        RelativeLayout relativeLayout = (RelativeLayout) p1.b.a(view, i10);
        if (relativeLayout != null) {
            i10 = e.f32663t;
            RadioButton radioButton = (RadioButton) p1.b.a(view, i10);
            if (radioButton != null) {
                i10 = e.S;
                RelativeLayout relativeLayout2 = (RelativeLayout) p1.b.a(view, i10);
                if (relativeLayout2 != null) {
                    i10 = e.T;
                    RadioButton radioButton2 = (RadioButton) p1.b.a(view, i10);
                    if (radioButton2 != null) {
                        i10 = e.f32632d0;
                        RelativeLayout relativeLayout3 = (RelativeLayout) p1.b.a(view, i10);
                        if (relativeLayout3 != null) {
                            i10 = e.f32634e0;
                            RadioButton radioButton3 = (RadioButton) p1.b.a(view, i10);
                            if (radioButton3 != null) {
                                return new b((LinearLayout) view, relativeLayout, radioButton, relativeLayout2, radioButton2, relativeLayout3, radioButton3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.f32683g, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f36179a;
    }
}
