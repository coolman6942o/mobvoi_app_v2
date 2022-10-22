package oc;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentEnableFailBinding.java */
/* loaded from: classes2.dex */
public final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31523a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f31524b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f31525c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31526d;

    private g(LinearLayout linearLayout, Button button, Button button2, TextView textView) {
        this.f31523a = linearLayout;
        this.f31524b = button;
        this.f31525c = button2;
        this.f31526d = textView;
    }

    public static g b(View view) {
        int i10 = R.id.enable_quit;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = R.id.enable_retry;
            Button button2 = (Button) b.a(view, i10);
            if (button2 != null) {
                i10 = R.id.reason_one;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    return new g((LinearLayout) view, button, button2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31523a;
    }
}
