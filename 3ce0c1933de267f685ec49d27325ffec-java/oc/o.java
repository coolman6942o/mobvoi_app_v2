package oc;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentSimOpenGuideBinding.java */
/* loaded from: classes2.dex */
public final class o implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f31553a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f31554b;

    private o(ScrollView scrollView, Button button) {
        this.f31553a = scrollView;
        this.f31554b = button;
    }

    public static o b(View view) {
        int i10 = R.id.sim_open_continue;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            return new o((ScrollView) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ScrollView a() {
        return this.f31553a;
    }
}
