package oc;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentEnableSuccessBinding.java */
/* loaded from: classes2.dex */
public final class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31527a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f31528b;

    private h(LinearLayout linearLayout, Button button) {
        this.f31527a = linearLayout;
        this.f31528b = button;
    }

    public static h b(View view) {
        int i10 = R.id.enable_finish;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            return new h((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31527a;
    }
}
