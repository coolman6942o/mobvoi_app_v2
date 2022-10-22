package zh;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import p1.a;
import p1.b;
import sh.h;
/* compiled from: ActivityMenstrualSettingBinding.java */
/* loaded from: classes2.dex */
public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37540a;

    /* renamed from: b  reason: collision with root package name */
    public final MaterialButton f37541b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f37542c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f37543d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f37544e;

    /* renamed from: f  reason: collision with root package name */
    public final View f37545f;

    /* renamed from: g  reason: collision with root package name */
    public final View f37546g;

    /* renamed from: h  reason: collision with root package name */
    public final View f37547h;

    private i(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3, View view, View view2, View view3) {
        this.f37540a = constraintLayout;
        this.f37541b = materialButton;
        this.f37542c = textView;
        this.f37543d = textView2;
        this.f37544e = textView3;
        this.f37545f = view;
        this.f37546g = view2;
        this.f37547h = view3;
    }

    public static i b(View view) {
        View a10;
        View a11;
        View a12;
        int i10 = h.W_res_0x7f0b0128;
        MaterialButton materialButton = (MaterialButton) b.a(view, i10);
        if (materialButton != null) {
            i10 = h.C3;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = h.E3;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = h.M3;
                    TextView textView3 = (TextView) b.a(view, i10);
                    if (!(textView3 == null || (a10 = b.a(view, (i10 = h.f34695s4))) == null || (a11 = b.a(view, (i10 = h.f34699t4))) == null || (a12 = b.a(view, (i10 = h.f34703u4))) == null)) {
                        return new i((ConstraintLayout) view, materialButton, textView, textView2, textView3, a10, a11, a12);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37540a;
    }
}
