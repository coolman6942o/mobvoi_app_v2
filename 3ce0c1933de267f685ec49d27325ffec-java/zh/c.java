package zh;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import p1.a;
import p1.b;
import sh.h;
/* compiled from: ActivityApolloOtaBinding.java */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37515a;

    /* renamed from: b  reason: collision with root package name */
    public final MaterialButton f37516b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f37517c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f37518d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f37519e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f37520f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f37521g;

    private c(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, ProgressBar progressBar, TextView textView2, TextView textView3, TextView textView4) {
        this.f37515a = constraintLayout;
        this.f37516b = materialButton;
        this.f37517c = textView;
        this.f37518d = progressBar;
        this.f37519e = textView2;
        this.f37520f = textView3;
        this.f37521g = textView4;
    }

    public static c b(View view) {
        int i10 = h.m0_res_0x7f0b0143;
        MaterialButton materialButton = (MaterialButton) b.a(view, i10);
        if (materialButton != null) {
            i10 = h.f34684q2;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = h.f34705v2;
                ProgressBar progressBar = (ProgressBar) b.a(view, i10);
                if (progressBar != null) {
                    i10 = h.f34710w2;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        i10 = h.f34662l3;
                        TextView textView3 = (TextView) b.a(view, i10);
                        if (textView3 != null) {
                            i10 = h.N3;
                            TextView textView4 = (TextView) b.a(view, i10);
                            if (textView4 != null) {
                                return new c((ConstraintLayout) view, materialButton, textView, progressBar, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37515a;
    }
}
